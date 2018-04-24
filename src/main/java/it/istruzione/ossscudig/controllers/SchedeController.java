package it.istruzione.ossscudig.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import it.istruzione.commons.utils.FormResponse;
import it.istruzione.ossscudig.constant.Constants;
import it.istruzione.ossscudig.controllers.util.CommonsUtility;
import it.istruzione.ossscudig.model.dto.AnagrafeDomandaDTO;
import it.istruzione.ossscudig.model.dto.GruppoDomandaDTO;
import it.istruzione.ossscudig.model.dto.RilevazioneDTO;
import it.istruzione.ossscudig.model.dto.RispostaDTO;
import it.istruzione.ossscudig.model.dto.SezioneDTO;
import it.istruzione.ossscudig.services.AcquisizioneRilevazioneService;
import it.istruzione.ossscudig.services.AnagrafeQuestionarioService;
import it.istruzione.ossscudig.services.GestioneRilevazioneService;
import it.istruzione.ossscudig.validator.InputValidator;
import it.istruzione.ossscudig.validator.ValidationError;
import it.istruzione.ossscudig.validator.ValidatorResponse;

@Controller
public class SchedeController extends BaseController {

	private static Logger logger = Logger.getLogger(SchedeController.class);
	
	@Autowired
	private AcquisizioneRilevazioneService acquisizioneRilevazioneService;
	
	@Autowired
	private GestioneRilevazioneService gestioneRilevazioneService;
	
	@Autowired
	private AnagrafeQuestionarioService anagrafeQuestionarioService;

    @Autowired
    private InputValidator inputValidatorChain;
    
	@RequestMapping("/schedeVis.html" )
	public String schedeVis(@ModelAttribute("schedaForm") Object schedaForm, BindingResult result, Model model,  HttpServletRequest req) throws Exception {
		logger.debug("schede.html");
		String scheda = req.getParameter("scheda");
		String codForteScu = req.getParameter("codForteScu");
		String sezioneValidata = req.getParameter("sezioneValidata");//1-sezione validata; 0-sezione in corso
		String codQuest = req.getParameter("codQuest");
		SezioneDTO sezDto = null;
		if (sezioneValidata != null && sezioneValidata.equals("1")){
			sezDto = acquisizioneRilevazioneService.loadSezione(scheda, codForteScu, codQuest, true);
		}else{
			sezDto = acquisizioneRilevazioneService.loadSezione(scheda, codForteScu, codQuest, false);			
		}
		ArrayList<String> lisStr = new ArrayList<String>();
		for (Iterator<GruppoDomandaDTO> iterator = sezDto.getGruppiDomande().iterator(); iterator.hasNext();) {
			GruppoDomandaDTO gruppoDomandaDTO = (GruppoDomandaDTO) iterator.next();
			if(!gruppoDomandaDTO.getTipoGruppo().equals("D")){
				lisStr.add(gruppoDomandaDTO.getCodEdi());
			}
		}
		if (sezDto != null){
			sezDto.setListaCodiciEdificiPlessi(lisStr);
			sezDto.setSizeListaEdificiPlessi(lisStr.size());
			sezDto.setCodiceForteScuola(codForteScu);
		}
		model.addAttribute("sezione", sezDto);
		model.addAttribute("codQuest", codQuest);
		model.addAttribute("sezioneValidata",sezioneValidata);
		return "pages/sezioniQuestionario/schedeVis";
	}
    
	@RequestMapping("/schede.html" )
	public String schede(@ModelAttribute("schedaForm") Object schedaForm, BindingResult result, Model model,  HttpServletRequest req) throws Exception {
		logger.debug("schede.html");
		String scheda = req.getParameter("scheda");
		String codForteScu = req.getParameter("codForteScu");
//		String codEdi = req.getParameter("codEdi");
		String codQuest = req.getParameter("codQuest");
		SezioneDTO sezDto = acquisizioneRilevazioneService.loadSezione(scheda, codForteScu, codQuest, false);
		ArrayList<String> lisStr = new ArrayList<String>();
		for (Iterator<GruppoDomandaDTO> iterator = sezDto.getGruppiDomande().iterator(); iterator.hasNext();) {
			GruppoDomandaDTO gruppoDomandaDTO = (GruppoDomandaDTO) iterator.next();
			if(!gruppoDomandaDTO.getTipoGruppo().equals("D")){
				lisStr.add(gruppoDomandaDTO.getCodEdi());
			}
		}
		sezDto.setListaCodiciEdificiPlessi(lisStr);
		sezDto.setSizeListaEdificiPlessi(lisStr.size());
		sezDto.setCodiceForteScuola(codForteScu);
		model.addAttribute("sezione", sezDto);
		model.addAttribute("codQuest", codQuest);
		return "pages/sezioniQuestionario/schede";
	}
	
	@RequestMapping(value = "salvaScheda.json" ,method = RequestMethod.POST)
	public @ResponseBody FormResponse salvaScheda(@ModelAttribute("schedaForm") @Valid Object schedaForm, 
												  BindingResult bindingResult, 
												  Model model, 
												  HttpServletRequest req) throws Exception {
		
		logger.debug("in salvaScheda.html");
		
		try{
			RilevazioneDTO rilevazione = gestioneRilevazioneService.loadRilevazioneAttiva();

			String codForteScu = req.getParameter("codForteScu");
			String codEdi = req.getParameter("codEdi");
			String idSezione = req.getParameter("idSezione");
			String codQuest = req.getParameter("codQuest");
			String sezione = req.getParameter("sezione");
			String sizeListaEdificiPlessi = req.getParameter("sizeListaEdificiPlessi");
			//ArrayList<String> listaCodiciEdificiPlessi = req.getParameter("listaCodiciEdificiPlessi");

			logger.debug("rilevazione = " + rilevazione.getId());
			logger.debug("codForteScu = " + codForteScu);
			logger.debug("codEdi = " + codEdi);
			logger.debug("idSezione = " + idSezione);
			logger.debug("codQuest = " + codQuest);
			logger.debug("codQuest = " + codQuest);

			if (codForteScu != null && ! codForteScu.isEmpty() && rilevazione != null){

				List<RispostaDTO> risposte = new ArrayList<>();
				Map<String, String[]> mappaParametri =   req.getParameterMap();
				for (String param : mappaParametri.keySet()) {
					logger.debug("param : " + param);
					if (param.startsWith(Constants.PREFIX_DOM)){
						logger.debug("elaborazione domanda COD_DMD = " + param);
						RispostaDTO rispostaDTO = new RispostaDTO();
						rispostaDTO.setCodDmd(param);
						AnagrafeDomandaDTO anagrafeDomandaDTO = anagrafeQuestionarioService.getAnagrafeDomandaDTOValidator(CommonsUtility.getCodDmdFromParam(param));
						if (anagrafeDomandaDTO != null){
							rispostaDTO.setIdRegex(anagrafeDomandaDTO.getIdRegExp());
							rispostaDTO.setRegEx(anagrafeDomandaDTO.getRegExp());
							rispostaDTO.setMessaggioUtente(anagrafeDomandaDTO.getDesMsgUte());
						}
						rispostaDTO.setRisposte(new ArrayList<String>());
						String[] risposteDomanda = mappaParametri.get(param);
						if(risposteDomanda.length==1 && risposteDomanda[0].equals("")) {
							continue;
						}else {
							for (String risposta : risposteDomanda) {
								rispostaDTO.getRisposte().add(risposta);
							}
							risposte.add(rispostaDTO);
						}
					}
				}

				ValidatorResponse validatorResponse = inputValidatorChain.validate(idSezione,risposte);

				logger.debug("validazione superata: " + validatorResponse.isSuccess());

				if (!validatorResponse.isSuccess()) {//validazione non ok
					FormResponse formResponse = null;

					for (ValidationError validationError: validatorResponse.getErrors()) {
						if (validationError.getFieldName() != null) {
							FieldError error = new FieldError("schedaForm", validationError.getFieldName(), validationError.getErrorMessage());
							bindingResult.addError(error);
							formResponse = new FormResponse(bindingResult);
						}
					}

					if (formResponse == null) {
						for (ValidationError validationError: validatorResponse.getErrors()) {
							formResponse = FormResponse.failed("Attenzione: sono presenti errori di validazione. I dati inseriti sono stati comunque salvati");
							formResponse.setJavascriptCallBack("showSectionErrors");
							formResponse.setResponseData(idSezione + "|" + validationError.getErrorMessage());
						}
					}
					acquisizioneRilevazioneService.saveSezione(idSezione, codForteScu, rilevazione.getId(), risposte, codQuest, false);
					return formResponse;
				}else {//validazione ok
					acquisizioneRilevazioneService.saveSezione(idSezione, codForteScu, rilevazione.getId(), risposte, codQuest, true);
					FormResponse formResponse = FormResponse.success("Operazione effettuata con successo");
					return formResponse;
				}

			}else{
				FormResponse formResponse = FormResponse.failed("Parametri di input non validi");
				return formResponse;
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			FormResponse formResponse = FormResponse.failed(e.getMessage());
			return formResponse;
		}
		
	}
}