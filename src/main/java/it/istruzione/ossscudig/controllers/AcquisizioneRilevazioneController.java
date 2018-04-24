package it.istruzione.ossscudig.controllers;

import it.istruzione.commons.utils.FormResponse;
import it.istruzione.ossscudig.constant.TIPO_STATO_QUESTIONARIO;
import it.istruzione.ossscudig.constant.TIPO_STATO_SEZIONE;
import it.istruzione.ossscudig.controllers.helper.DtoFactory;
import it.istruzione.ossscudig.model.dto.QuestionarioDTO;
import it.istruzione.ossscudig.model.dto.QuestionarioScuolaDTO;
import it.istruzione.ossscudig.model.dto.RilevazioneDTO;
import it.istruzione.ossscudig.model.dto.ScuolaDTO;
import it.istruzione.ossscudig.model.dto.SezioneDTO;
import it.istruzione.ossscudig.model.entity.Tod1015Valrispostadomandascu;
import it.istruzione.ossscudig.repository.Tod1015ValrispostadomandascuRepository;
import it.istruzione.ossscudig.services.AcquisizioneRilevazioneService;
import it.istruzione.ossscudig.services.AnagrafeQuestionarioService;
import it.istruzione.ossscudig.services.AnagrafeScuolaService;
import it.istruzione.ossscudig.services.AnagrafeSezioneService;
import it.istruzione.ossscudig.services.GestioneRilevazioneService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
// @PreAuthorize("isAuthorized('#acquisizioneRilevazione?breadcrumbTitle=AcquisizioneRilevazione')")
public class AcquisizioneRilevazioneController extends BaseController {

	private static Logger logger = Logger.getLogger(AcquisizioneRilevazioneController.class);

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

	@Autowired
	private Tod1015ValrispostadomandascuRepository tod1015ValrispostadomandascuRepository;

	@RequestMapping("/acquisizioneRilevazione.html")
	public String acquisizioneRilevazione(Model model, HttpServletRequest request) throws Exception {
		logger.debug("acquisizioneRilevazione.html");

		RilevazioneDTO dto = gestioneRilevazioneService.loadRilevazioneAttiva();
		model.addAttribute("rilevazione", DtoFactory.fromDtoToForm(dto));

		/** caricamento delle scuole associate al contesto selezionato **/
		List<ScuolaDTO> scuole = anagrafeScuolaService.getScuoleAssociate(getContestoCorrente(),dto.getId());
		logger.debug("scuole size : "+scuole.size());
		/**
		 * TODO gestire abilitazione di ogni plesso alla rilevazione nel caso di scuola
		 * e istituzione duplicare il record per far acquisire entrambi i questionari
		 */
		model.addAttribute("scuole", scuole);

		return "pages/acquisizioneRilevazione/acquisizioneRilevazione";
	}

	@RequestMapping("/questionari.html")
	public String questionari(Model model, HttpServletRequest request) throws Exception {
		logger.debug("questionari.html");
		RilevazioneDTO rilevazioneDTO = gestioneRilevazioneService.loadRilevazioneAttiva();
		if (rilevazioneDTO != null) {
			logger.debug("rilevazione attiva : " + rilevazioneDTO.getId());
			rilevazioneDTO.setStato(acquisizioneRilevazioneService.getStatoRilevazioneScuola(getContestoCorrente(),
					rilevazioneDTO.getId()));

			model.addAttribute("rilevazione", DtoFactory.fromDtoToForm(rilevazioneDTO));

			/** caricamento delle scuole associate al contesto selezionato **/
			List<ScuolaDTO> scuole = anagrafeScuolaService.getScuoleAssociate(getContestoCorrente(),rilevazioneDTO.getId());
			logger.debug("scuole associate : " + scuole.size());

			/** caricamento dei questionari associati all'istanza di rilevazione attiva **/
			Map<String, QuestionarioDTO> mapQuestionariByRilevazione = anagrafeQuestionarioService
					.findQuestionariByRilevazione(rilevazioneDTO.getId());
			logger.debug("QuestionariByRilevazione : " + mapQuestionariByRilevazione.size());

			/**
			 * associare i questionari alle scuole con lo stato. Per ogni scuola bisogna
			 * visualizzare un record per ogni questionario a cui è abilitata
			 **/

			List<QuestionarioScuolaDTO> questionari = getQuestionariAbilitatiPerScuole(scuole, rilevazioneDTO,
					mapQuestionariByRilevazione);

			logger.debug("questionari scuola");
			logger.debug(ReflectionToStringBuilder.toString(questionari, ToStringStyle.MULTI_LINE_STYLE));
			model.addAttribute("questionari", questionari);
		}
		return "pages/acquisizioneRilevazione/questionari";
	}

	@RequestMapping("/questionario.html")
	public String questionario(Model model, HttpServletRequest request, String codForScu, String idQst)
			throws Exception {
		logger.debug("questionario.html " + codForScu + " - " + idQst);

		RilevazioneDTO dto = gestioneRilevazioneService.loadRilevazioneAttiva();
		model.addAttribute("rilevazione", DtoFactory.fromDtoToForm(dto));

		ScuolaDTO scuola = anagrafeScuolaService.getScuola(codForScu);
		model.addAttribute("scuola", scuola);

		QuestionarioDTO questionario = anagrafeQuestionarioService.getQuestionario(idQst);
		model.addAttribute("questionario", questionario);

		List<SezioneDTO> sezioni = anagrafeSezioneService.findSezioniQuestionario(idQst);
		/** imposto lo stato per ogni sezione **/
		for (SezioneDTO sezioneDTO : sezioni) {
			sezioneDTO.setCodiceForteScuola(codForScu);
			sezioneDTO.setStato(acquisizioneRilevazioneService.getStatoSezioneScuola(codForScu, dto.getId(), idQst,
					sezioneDTO.getIdSezione()));
		}
		model.addAttribute("sezioni", sezioni);

		/** calcolo la percentuale di completamento **/
		int nSez = sezioni.size();
		int nSezCompilate = 0;
		for (SezioneDTO sezioneDTO : sezioni) {
			if (sezioneDTO.getStato() == TIPO_STATO_SEZIONE.COMPILATA) {
				nSezCompilate++;
			}
		}
		Integer percentuale = (100 / nSez) * nSezCompilate;
		model.addAttribute("percentuale", percentuale);

		return "pages/acquisizioneRilevazione/sezioniQuestionario";
	}

	@RequestMapping(value = "validaRilevazione.json", method = RequestMethod.POST)
	public @ResponseBody FormResponse validaRilevazione(Model model, HttpServletRequest req) throws Exception {

		logger.debug("in validaQuestionario.html");

		try {
			RilevazioneDTO rilevazioneDTO = gestioneRilevazioneService.loadRilevazioneAttiva();

			if (rilevazioneDTO != null) {
				logger.debug("rilevazione attiva : " + rilevazioneDTO.getId());
				model.addAttribute("rilevazione", DtoFactory.fromDtoToForm(rilevazioneDTO));

				/** caricamento delle scuole associate al contesto selezionato **/
				List<ScuolaDTO> scuole = anagrafeScuolaService.getScuoleAssociate(getContestoCorrente(),rilevazioneDTO.getId());
				logger.debug("scuole associate : " + scuole.size());

				/** caricamento dei questionari associati all'istanza di rilevazione attiva **/
				Map<String, QuestionarioDTO> mapQuestionariByRilevazione = anagrafeQuestionarioService.findQuestionariByRilevazione(rilevazioneDTO.getId());
				logger.debug("QuestionariByRilevazione : " + mapQuestionariByRilevazione.size());

				List<QuestionarioScuolaDTO> questionari = this.getQuestionariAbilitatiPerScuole(scuole, rilevazioneDTO,	mapQuestionariByRilevazione);

				logger.debug("questionari scuola");
				logger.debug(ReflectionToStringBuilder.toString(questionari, ToStringStyle.MULTI_LINE_STYLE));



				boolean questionariCompilati = true;
				
				boolean datarispostaDomande = true;
				for (QuestionarioScuolaDTO questionarioScuolaDTO : questionari) {
						if (questionarioScuolaDTO.getStato() != TIPO_STATO_QUESTIONARIO.COMPILATO) {
							questionariCompilati = false;
							break;
					}
					
				//controllo data inserimento domanda per validazione 	
					List<Tod1015Valrispostadomandascu> list = tod1015ValrispostadomandascuRepository.findByIdCodForScuAndIdPrgIstRil(scuole.get(0).getCodiceMeccanograficoIstitutoPrincipale(),rilevazioneDTO.getId());
					
					if (!list.isEmpty()) {//pieno
						Integer confrontoDate = tod1015ValrispostadomandascuRepository.getValidatePerData(questionarioScuolaDTO.getScuola().getCodiceForte());
						if(confrontoDate != null && confrontoDate==1) {
							datarispostaDomande = true;
							break;
						}
						if (confrontoDate == null || confrontoDate != 1) {
							datarispostaDomande = false;
						}
					}

				}

				if (!questionariCompilati) {
					FormResponse formResponse = FormResponse.failed("Per validare la rilevazione tutti i questionari devono essere compilati");
					return formResponse;
				}

				if (!datarispostaDomande) {
					FormResponse formResponse = FormResponse.failed("Per validare la rilevazione la data di salvataggio delle domande in corso deve essere superiore alla data di validazione");
					return formResponse;
				}


				acquisizioneRilevazioneService.validaRilevazione(scuole, rilevazioneDTO.getId());
				FormResponse formResponse = FormResponse.success("Operazione effettuata con successo");
				return formResponse;
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			FormResponse formResponse = FormResponse.failed(e.getMessage());
			return formResponse;
		}

		FormResponse formResponse = null;
		return formResponse;
	}

}