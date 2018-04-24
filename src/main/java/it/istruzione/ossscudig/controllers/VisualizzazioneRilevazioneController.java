package it.istruzione.ossscudig.controllers;

import it.istruzione.ossscudig.constant.TIPO_STATO_SEZIONE;
import it.istruzione.ossscudig.controllers.helper.DtoFactory;
import it.istruzione.ossscudig.model.dto.QuestionarioDTO;
import it.istruzione.ossscudig.model.dto.QuestionarioScuolaDTO;
import it.istruzione.ossscudig.model.dto.RilevazioneDTO;
import it.istruzione.ossscudig.model.dto.ScuolaDTO;
import it.istruzione.ossscudig.model.dto.SezioneDTO;
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

@Controller
public class VisualizzazioneRilevazioneController extends BaseController {

	private static Logger logger = Logger.getLogger(VisualizzazioneRilevazioneController.class);

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



	@RequestMapping("/visualizzaRilevazione.html" )
	public String visualizzaRilevazione(Model model, HttpServletRequest request) throws Exception {
		logger.debug("visualizzaRilevazione.html");
		RilevazioneDTO rilevazioneDTO = gestioneRilevazioneService.loadRilevazioneAttiva();
		if (rilevazioneDTO != null){
			logger.debug("rilevazione attiva : " + rilevazioneDTO.getId());
			model.addAttribute("rilevazione", DtoFactory.fromDtoToForm(rilevazioneDTO));

			/** caricamento delle scuole associate al contesto selezionato **/
			List<ScuolaDTO> scuole = anagrafeScuolaService.getScuoleAssociate(getContestoCorrente(),rilevazioneDTO.getId());
			logger.debug("scuole associate : " + scuole.size());

			/** caricamento dei questionari associati all'istanza di rilevazione attiva **/
			Map<String, QuestionarioDTO> mapQuestionariByRilevazione = anagrafeQuestionarioService.findQuestionariByRilevazione(rilevazioneDTO.getId());
			logger.debug("QuestionariByRilevazione : " + mapQuestionariByRilevazione.size());

			/** associare i questionari alle scuole con lo stato. 
			 *  Per ogni scuola bisogna visualizzare un record per ogni questionario a cui è abilitata
			 **/

			List<QuestionarioScuolaDTO> questionari = getQuestionariAbilitatiPerScuole(scuole, rilevazioneDTO, mapQuestionariByRilevazione);

			logger.debug("questionari scuola");
			logger.debug(ReflectionToStringBuilder.toString(questionari,ToStringStyle.MULTI_LINE_STYLE));
			model.addAttribute("questionari", questionari);
		}

		return "pages/acquisizioneRilevazione/visualizzazioneQuestionari";
	}

	@RequestMapping("/visualizzaQuestionario2.html" )
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