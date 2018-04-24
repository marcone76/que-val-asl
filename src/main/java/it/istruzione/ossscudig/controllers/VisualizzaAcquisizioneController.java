package it.istruzione.ossscudig.controllers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import it.istruzione.ossscudig.constant.TIPO_STATO_SEZIONE;
import it.istruzione.ossscudig.controllers.helper.DtoFactory;
import it.istruzione.ossscudig.controllers.util.CommonsUtility;
import it.istruzione.ossscudig.model.dto.LabelValueDTO;
import it.istruzione.ossscudig.model.dto.MonitoraggioDTO;
import it.istruzione.ossscudig.model.dto.QuestionarioDTO;
import it.istruzione.ossscudig.model.dto.RilevazioneDTO;
import it.istruzione.ossscudig.model.dto.ScuolaDTO;
import it.istruzione.ossscudig.model.dto.SezioneDTO;
import it.istruzione.ossscudig.services.AnagrafeQuestionarioService;
import it.istruzione.ossscudig.services.AnagrafeScuolaService;
import it.istruzione.ossscudig.services.AnagrafeSezioneService;
import it.istruzione.ossscudig.services.GestioneRilevazioneService;
import it.istruzione.ossscudig.services.MonitoraggioService;

@Controller
public class VisualizzaAcquisizioneController extends BaseController {

	private static Logger logger = Logger.getLogger(VisualizzaAcquisizioneController.class);
	
	@Autowired
	private GestioneRilevazioneService gestioneRilevazioneService;
	@Autowired
	private AnagrafeScuolaService anagrafeScuolaService;
	@Autowired
	private AnagrafeQuestionarioService anagrafeQuestionarioService;
	@Autowired
	private MonitoraggioService monitoraggioServiceImpl;
	@Autowired
	private AnagrafeSezioneService anagrafeSezioneService;
	@Autowired
	private MonitoraggioService monitoraggioService;
	@RequestMapping("/ricercaVisualizzaAcquisizione.html" )
	public String ricercaVisualizzaAcquisizione(Model model, HttpServletRequest request) throws Exception {
		logger.debug("ricercaVisualizzaAcquisizione.html");
		
		RilevazioneDTO dto = gestioneRilevazioneService.loadRilevazioneAttiva();
		model.addAttribute("rilevazione", DtoFactory.fromDtoToForm(dto));
		
		/** caricamento delle scuole associate al contesto selezionato **/
		//List<ScuolaDTO> scuole = anagrafeScuolaService.getScuoleAssociate(getContestoCorrente());
		//model.addAttribute("scuole", scuole);
		
		LinkedList<LabelValueDTO> regioni = monitoraggioServiceImpl.getRegioni();
		LinkedList<LabelValueDTO> questionari = monitoraggioServiceImpl.getQuestionari();
		LinkedList<LabelValueDTO> province = new LinkedList<LabelValueDTO>();
		LinkedList<LabelValueDTO> comuni = new LinkedList<LabelValueDTO>();
		model.addAttribute("regioni", regioni);
		model.addAttribute("province", province);
		model.addAttribute("comuni", comuni);
		model.addAttribute("questionari",questionari);
		
		return "pages/monitoraggio/ricercaVisualizzaAcquisizione";
	}
	
	
	@RequestMapping("/visualizzaAcquisizioneElencoScuole")
	public String visualizzaAcquisizioneElencoScuole(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.debug("visualizzaAcquisizioneElencoScuole.html");
		Map<String, String[]> mappaParametri =   request.getParameterMap();
		for (String param : mappaParametri.keySet()) {
			logger.debug("param : " + param+" --- param : " + mappaParametri.get(param)[0]);
		}
		
		String codMec = mappaParametri.get("codMec")[0];
		String questionario = mappaParametri.get("questionario")[0];
		String regione = mappaParametri.get("regioneAc")[0];
		String provincia = mappaParametri.get("provinciaAc")[0];
		String comune = mappaParametri.get("comuneAc")[0];
		
		
		
		model.addAttribute("codMec", codMec);
		model.addAttribute("regioni", regione);
		model.addAttribute("province", provincia);
		model.addAttribute("comuni", comune);
	
		RilevazioneDTO rilevazioneDTO = gestioneRilevazioneService.loadRilevazioneAttiva();
		if (rilevazioneDTO != null){
			logger.debug("rilevazione attiva : " + rilevazioneDTO.getId());
			model.addAttribute("rilevazione", DtoFactory.fromDtoToForm(rilevazioneDTO));
		
//		/** caricamento delle scuole associate al contesto selezionato **/
//		List<ScuolaDTO> scuole = anagrafeScuolaService.getScuoleAssociate("LETE010002");
//		logger.debug("scuole associate : " + scuole.size());
//
//		/** caricamento dei questionari associati all'istanza di rilevazione attiva **/
//		Map<String, QuestionarioDTO> mapQuestionariByRilevazione = anagrafeQuestionarioService.findQuestionariByRilevazione(rilevazioneDTO.getId());
//		logger.debug("QuestionariByRilevazione : " + mapQuestionariByRilevazione.size());
//
//		/** associare i questionari alle scuole con lo stato. 
//		 *  Per ogni scuola bisogna visualizzare un record per ogni questionario a cui è abilitata
//		 **/
//
//		List<QuestionarioScuolaDTO> questionari = getQuestionariAbilitatiPerScuole(scuole, rilevazioneDTO, mapQuestionariByRilevazione);
//
//		logger.debug("questionari scuola");
//		logger.debug(ReflectionToStringBuilder.toString(questionari,ToStringStyle.MULTI_LINE_STYLE));
//		if(questionari.size()>0) {
//			model.addAttribute("questionario",questionari.get(0).getNome());
//		}
//		model.addAttribute("questionari", questionari);
//		
			ArrayList<MonitoraggioDTO> lista =	monitoraggioService.getElencoScuole(rilevazioneDTO.getId().toString(),String.valueOf( CommonsUtility.getAnnoScolasticoCorrente()), getCodice(regione,"/"),getCodice(provincia,"/"),getCodice(comune,"/"), questionario,codMec);
			if(lista.size()>0) {
				model.addAttribute("questionario",lista.get(0).getQuestionario());
			}
			model.addAttribute("questionari", lista);
		}
		
		
		return "pages/monitoraggio/visualizzaAcquisizioneElencoScuole";
	}

	@RequestMapping("/visualizzaQuestionario.html" )
	public String visualizzaQuestionario(Model model, HttpServletRequest request, String codForScu, String idQst, boolean isValidato) throws Exception {
		logger.debug("questionario.html " + codForScu + " - " + idQst);

		RilevazioneDTO dto = gestioneRilevazioneService.loadRilevazioneAttiva();
		model.addAttribute("rilevazione", DtoFactory.fromDtoToForm(dto));

		ScuolaDTO scuola = anagrafeScuolaService.getScuola(codForScu);
		model.addAttribute("scuola", scuola);

		QuestionarioDTO questionario = anagrafeQuestionarioService.getQuestionario(idQst);
		model.addAttribute("questionario", questionario);

		String sezioneValidata = request.getParameter("sezioneValidata");//1-sezione validata; 0-sezione in corso

		List<SezioneDTO> sezioni = anagrafeSezioneService.findSezioniQuestionario(idQst);
		/** imposto lo stato per ogni sezione **/
		for (SezioneDTO sezioneDTO : sezioni) {
			sezioneDTO.setCodiceForteScuola(codForScu);
			sezioneDTO.setStato(acquisizioneRilevazioneService.getStatoSezioneScuola(codForScu, dto.getId(), idQst, sezioneDTO.getIdSezione()));
		}
		model.addAttribute("sezioni", sezioni);
		model.addAttribute("isValidato", isValidato);

		/** calcolo la percentuale di completamento **/
		int nSez = sezioni.size();
		int nSezCompilate = 0;
		for (SezioneDTO sezioneDTO : sezioni) {
			if (sezioneDTO.getStato() == TIPO_STATO_SEZIONE.COMPILATA){
				nSezCompilate ++;
			}
		}
		Integer percentuale = (100/nSez)*nSezCompilate;
		model.addAttribute("percentuale", percentuale);
		model.addAttribute("sezioneValidata",sezioneValidata);

		return "pages/acquisizioneRilevazione/visualizzaSezioniQuestionario";
	}
	
	
	
	
}