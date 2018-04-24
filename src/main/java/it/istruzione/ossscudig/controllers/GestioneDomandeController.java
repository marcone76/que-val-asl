package it.istruzione.ossscudig.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import it.istruzione.commons.utils.FormResponse;
import it.istruzione.ossscudig.constant.Constants;
import it.istruzione.ossscudig.constant.TIPO_STATO_RILEVAZIONE;
import it.istruzione.ossscudig.controllers.helper.DtoFactory;
import it.istruzione.ossscudig.model.dto.AnagrafeDomandaDTO;
import it.istruzione.ossscudig.model.dto.DomandaDTO;
import it.istruzione.ossscudig.model.dto.GruppoDomandaDTO;
import it.istruzione.ossscudig.model.dto.QuestionarioDTO;
import it.istruzione.ossscudig.model.dto.QuestionarioScuolaDTO;
import it.istruzione.ossscudig.model.dto.RilevazioneDTO;
import it.istruzione.ossscudig.model.dto.SezioneDTO;
import it.istruzione.ossscudig.model.dto.VoceDTO;
import it.istruzione.ossscudig.services.AcquisizioneRilevazioneService;
import it.istruzione.ossscudig.services.AnagrafeQuestionarioService;
import it.istruzione.ossscudig.services.AnagrafeScuolaService;
import it.istruzione.ossscudig.services.AnagrafeSezioneService;
import it.istruzione.ossscudig.services.GestioneRilevazioneService;

@Controller
public class GestioneDomandeController extends BaseController {

	private static Logger logger = Logger.getLogger(GestioneDomandeController.class);

	@Autowired
	private GestioneRilevazioneService gestioneRilevazioneService;

	@Autowired
	private AnagrafeScuolaService anagrafeScuolaService;

	@Autowired
	private AnagrafeQuestionarioService anagrafeQuestionarioService;

	@Autowired
	private AnagrafeSezioneService anagrafeSezioneService;

	@Autowired
	private AcquisizioneRilevazioneService acquisizioneRilevazioneService;

	@RequestMapping("/gestioneDomande.html")
	public String gestioneDomande(Model model, HttpServletRequest request) throws Exception {
		logger.debug("gestioneDomande.html");
		RilevazioneDTO rilevazioneDTO = gestioneRilevazioneService.loadRilevazioneBozza();
		if (rilevazioneDTO != null) {
			logger.debug("rilevazione attiva : " + rilevazioneDTO.getId());
			rilevazioneDTO.setStato(acquisizioneRilevazioneService.getStatoRilevazioneScuola(getContestoCorrente(),	rilevazioneDTO.getId()));
			model.addAttribute("rilevazione", DtoFactory.fromDtoToForm(rilevazioneDTO));

			int codTipSta = new Long( TIPO_STATO_RILEVAZIONE.BOZZA.getCodice() ).intValue();
			List<QuestionarioDTO> questionari = anagrafeQuestionarioService.getGestioneQuestionario(codTipSta);

			logger.debug("questionari scuola");
			logger.debug(ReflectionToStringBuilder.toString(questionari, ToStringStyle.MULTI_LINE_STYLE));
			model.addAttribute("questionari", questionari);

		}

		return "pages/gestione/gestioneDomande";
	}

	@RequestMapping("/questionarioDomande.html")
	public String questionarioDomande(Model model, HttpServletRequest request, String codForScu, String idQst) throws Exception {
		logger.debug("questionarioDomande.html " + idQst);

		RilevazioneDTO dto = gestioneRilevazioneService.loadRilevazioneBozza();
		model.addAttribute("rilevazione", DtoFactory.fromDtoToForm(dto));

		QuestionarioDTO questionario = anagrafeQuestionarioService.getQuestionario(idQst);
		model.addAttribute("questionario", questionario);

		List<SezioneDTO> sezioni = anagrafeSezioneService.findSezioniQuestionario(idQst);
		/** imposto lo stato per ogni sezione **/
		for (SezioneDTO sezioneDTO : sezioni) {
			sezioneDTO.setCodiceForteScuola(codForScu);
		}
		model.addAttribute("sezioni", sezioni);

		return "pages/gestione/sezioniQuestionario";
	}

	

	public QuestionarioScuolaDTO getQuestionarioScuolaDTO(String stato, String descrizione) {
		QuestionarioScuolaDTO oQuestionarioScuolaDTO = new QuestionarioScuolaDTO();

		oQuestionarioScuolaDTO.setNome(descrizione);
		return oQuestionarioScuolaDTO;
	}

	@RequestMapping("/modificaRisposte.html" )
	public String modificaRisposte(Model model, HttpServletRequest req) throws Exception {
		logger.debug("modificaRisposte.html");
		RilevazioneDTO rilevazioneDTO = gestioneRilevazioneService.loadRilevazioneAttiva();
		if (rilevazioneDTO != null) {
			logger.debug("rilevazione attiva : " + rilevazioneDTO.getId());
			rilevazioneDTO.setStato(acquisizioneRilevazioneService.getStatoRilevazioneScuola(getContestoCorrente(),
					rilevazioneDTO.getId()));
		}
			Map<String, String[]> mappaParametri =   req.getParameterMap();
			for (String param : mappaParametri.keySet()) {
				logger.debug("param : " + param+" --- param : " + mappaParametri.get(param)[0]);
			}
			
			String codQuest = mappaParametri.get("idQst")[0];
			String idDomanda = mappaParametri.get("idDmd")[0];
			String idSezione = req.getParameter("idSezione");
			AnagrafeDomandaDTO aa;
			
			SezioneDTO sezDto = acquisizioneRilevazioneService.loadSezione(idSezione, "", codQuest, false);
			List<Integer> ordine = new ArrayList<>();
			String gruppoVoce = "";
			for (int i=0; i<sezDto.getGruppiDomande().get(0).getDomande().size(); i++) {
				String result = sezDto.getGruppiDomande().get(0).getDomande().get(i).getId();
				String descrizione = sezDto.getGruppiDomande().get(0).getDomande().get(i).getTestoDomanda();
				List<VoceDTO> voci = new ArrayList<>();
				voci = sezDto.getGruppiDomande().get(0).getDomande().get(i).getVoci();
				if (voci != null) {
				String vociId=voci.get(0).getId();
				 aa = anagrafeQuestionarioService.getAnagrafeDomandaDTO(idDomanda,vociId);
				 gruppoVoce = aa.getDesGrpVoce();
				}
			if (result.equals(idDomanda)) {
				model.addAttribute("descrizione", descrizione);
				model.addAttribute("voci", voci);
				model.addAttribute("gruppoVoce", gruppoVoce);			
                break;
			}
			}
			
			model.addAttribute("sezione", sezDto);
			model.addAttribute("codQuest", codQuest);
			model.addAttribute("idDmd", idDomanda);
			model.addAttribute("idSezione", idSezione);

			
		

		return "pages/gestione/gestioneRisposte";
	}
	
	
	@RequestMapping(value = "salvaRisposte", method = RequestMethod.POST)
	public @ResponseBody FormResponse salvaRisposte(@ModelAttribute("salvaRisposteForm") @Valid Object schedaForm,
			BindingResult bindingResult, Model model, HttpServletRequest req) throws Exception {

		logger.debug("in salvaScheda.html");
		FormResponse formResponse = null;
		try {
			RilevazioneDTO rilevazione = gestioneRilevazioneService.loadRilevazioneAttiva();

			String idSezione = req.getParameter("idSezione");
			String codQuest = req.getParameter("codQuest");
			logger.debug("rilevazione = " + rilevazione.getId());
			logger.debug("idSezione = " + idSezione);
			logger.debug("codQuest = " + codQuest);

			if (rilevazione != null) {

				List<VoceDTO> voci = new ArrayList<>();
				Map<String, String[]> mappaParametri = req.getParameterMap();
				for (String param : mappaParametri.keySet()) {
					logger.debug("param : " + param);
					if (param != null && Character.isDigit(param.charAt(0))) {
						logger.debug("elaborazione domanda COD_DMD = " + param);
						VoceDTO voceDTO = new VoceDTO();
						voceDTO.setId(param);

						voceDTO.setVoci(new ArrayList<String>());
						String[] modificaVoce = mappaParametri.get(param);
						if (modificaVoce.length == 1 && modificaVoce[0].equals("")) {
							continue;
						} else {
							for (String risposta : modificaVoce) {
								voceDTO.getVoci().add(risposta);
							}
							voci.add(voceDTO);
						}
					}
					
				}
				// salvataggio ok
				if (voci != null) {
					anagrafeQuestionarioService.saveSezioneVoci(idSezione,voci);
					formResponse = FormResponse.success("Operazione effettuata con successo");
					return formResponse;
				}
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			formResponse = FormResponse.failed(e.getMessage());
			return formResponse;
		}
		return formResponse;

	}
	
	@RequestMapping("/schedeGestione.html")
	public String schedeGestione(@ModelAttribute("schedaGestianeForm") Object schedaForm, BindingResult result,
			Model model, HttpServletRequest req) throws Exception {
		logger.debug("schedeGestione.html");
		String scheda = req.getParameter("scheda");
		String codForteScu = req.getParameter("codForteScu");
		// String codEdi = req.getParameter("codEdi");
		String codQuest = req.getParameter("codQuest");
		SezioneDTO sezDto = acquisizioneRilevazioneService.loadSezione(scheda, codForteScu, codQuest, false);
		ArrayList<String> lisStr = new ArrayList<String>();
		for (Iterator<GruppoDomandaDTO> iterator = sezDto.getGruppiDomande().iterator(); iterator.hasNext();) {
			GruppoDomandaDTO gruppoDomandaDTO = (GruppoDomandaDTO) iterator.next();
			if (!gruppoDomandaDTO.getTipoGruppo().equals("D")) {
				lisStr.add(gruppoDomandaDTO.getCodEdi());
			}
		}

		sezDto.setListaCodiciEdificiPlessi(lisStr);
		sezDto.setSizeListaEdificiPlessi(lisStr.size());
		sezDto.setCodiceForteScuola(codForteScu);
		model.addAttribute("sezione", sezDto);
		model.addAttribute("codQuest", codQuest);
		return "pages/gestione/schedeGestione";
	}

	@RequestMapping(value = "salvaGestioneScheda", method = RequestMethod.POST)
	public @ResponseBody FormResponse salvaGestioneScheda(@ModelAttribute("schedaForm") @Valid Object schedaForm,
			BindingResult bindingResult, Model model, HttpServletRequest req) throws Exception {

		logger.debug("in salvaScheda.html");
		FormResponse formResponse = null;
		try {
			RilevazioneDTO rilevazione = gestioneRilevazioneService.loadRilevazioneAttiva();

			String codEdi = req.getParameter("codEdi");
			String idSezione = req.getParameter("idSezione");
			String codQuest = req.getParameter("codQuest");

			logger.debug("rilevazione = " + rilevazione.getId());
			logger.debug("codEdi = " + codEdi);
			logger.debug("idSezione = " + idSezione);
			logger.debug("codQuest = " + codQuest);

			if (rilevazione != null) {

				List<DomandaDTO> domande = new ArrayList<>();
				Map<String, String[]> mappaParametri = req.getParameterMap();
				for (String param : mappaParametri.keySet()) {
					logger.debug("param : " + param);
					if (param.startsWith(Constants.PREFIX_DOM)) {
						logger.debug("elaborazione domanda COD_DMD = " + param);
						DomandaDTO domandaDTO = new DomandaDTO();
						domandaDTO.setId(param);

						domandaDTO.setDomande(new ArrayList<String>());
						String[] modificaDomanda = mappaParametri.get(param);
						if (modificaDomanda.length == 1 && modificaDomanda[0].equals("")) {
							continue;
						} else {
							for (String risposta : modificaDomanda) {
								domandaDTO.getDomande().add(risposta);
							}
							domande.add(domandaDTO);
						}
					}
				}
				// salvataggio ok
				if (domande != null) {
					anagrafeQuestionarioService.saveSezioneDomande(idSezione,domande);
					formResponse = FormResponse.success("Operazione effettuata con successo");
					return formResponse;
				}
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			formResponse = FormResponse.failed(e.getMessage());
			return formResponse;
		}
		return formResponse;

	}
	
	
	@RequestMapping(value = "approvaQuestionario.html", method = RequestMethod.GET)
	public String approvaQuestionario(HttpServletRequest req,Model model) throws Exception {
		logger.debug("in approvaQuestionario");
		String idQst = req.getParameter("codQst");
		gestioneRilevazioneService.approvaQuestionario(idQst);

		RilevazioneDTO dto = gestioneRilevazioneService.loadRilevazioneBozza();
		model.addAttribute("rilevazione", DtoFactory.fromDtoToForm(dto));	
		model.addAttribute("message", "Questionario Approvato");
		
		return "pages/gestione/sezioniQuestionario";

	}
	
	@RequestMapping(value = "approvaRilevazione.html", method = RequestMethod.GET)
	public String approvaRilevazione(HttpServletRequest req,Model model) throws Exception {
		logger.debug("in approvaQuestionario");
	
		RilevazioneDTO rilevazioneDTO = gestioneRilevazioneService.approvaRilevazione();
		
			if(rilevazioneDTO==null) {
				rilevazioneDTO = gestioneRilevazioneService.loadRilevazioneBozza();
					model.addAttribute("rilevazione", DtoFactory.fromDtoToForm(rilevazioneDTO));
				model.addAttribute("message", "Non tutti i questionari sono approvati");
				
				int codTipSta = new Long( TIPO_STATO_RILEVAZIONE.BOZZA.getCodice() ).intValue();
				List<QuestionarioDTO> questionari = anagrafeQuestionarioService.getGestioneQuestionario(codTipSta);

				logger.debug("questionari scuola");
				logger.debug(ReflectionToStringBuilder.toString(questionari, ToStringStyle.MULTI_LINE_STYLE));
				model.addAttribute("questionari", questionari);
				
			}
			else {
				model.addAttribute("message", "Rilevazione Approvata");
			}
			

			return "pages/gestione/gestioneDomande";

	}
	
}