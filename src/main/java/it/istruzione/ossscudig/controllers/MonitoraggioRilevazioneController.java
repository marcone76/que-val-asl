package it.istruzione.ossscudig.controllers;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import it.istruzione.ossscudig.controllers.helper.DtoFactory;
import it.istruzione.ossscudig.model.dto.RilevazioneDTO;
import it.istruzione.ossscudig.services.AnagrafeScuolaService;
import it.istruzione.ossscudig.services.GestioneRilevazioneService;

@Controller
//@PreAuthorize("isAuthorized('#acquisizioneRilevazione?breadcrumbTitle=AcquisizioneRilevazione')")
public class MonitoraggioRilevazioneController extends BaseController {

	private static Logger logger = Logger.getLogger(MonitoraggioRilevazioneController.class);
	
	@Autowired
	private GestioneRilevazioneService gestioneRilevazioneService;
	@Autowired
	private AnagrafeScuolaService anagrafeScuolaService;
	
	@RequestMapping("/monitoraggioRilevazione.html" )
	public String monitoraggioRilevazione(Model model, HttpServletRequest request) throws Exception {
		logger.debug("monitoraggioRilevazione.html");
		
		RilevazioneDTO dto = gestioneRilevazioneService.loadRilevazioneAttiva();
		model.addAttribute("rilevazione", DtoFactory.fromDtoToForm(dto));
		
		/** caricamento delle scuole associate al contesto selezionato **/
		//List<ScuolaDTO> scuole = anagrafeScuolaService.getScuoleAssociate(getContestoCorrente());
		/**
		 * TODO
		 * gestire abilitazione di ogni plesso alla rilevazione
		 * nel caso di scuola e istituzione duplicare il record per far acquisire entrambi i questionari
		 */
		//model.addAttribute("scuole", scuole);
		
		
		return "pages/monitoraggio/monitoraggioRilevazione";
	}
	

	



}