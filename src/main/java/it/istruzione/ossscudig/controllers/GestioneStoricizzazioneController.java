package it.istruzione.ossscudig.controllers;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import it.istruzione.ossscudig.controllers.helper.DtoFactory;
import it.istruzione.ossscudig.controllers.util.CommonsUtility;
import it.istruzione.ossscudig.model.dto.RilevazioneDTO;
import it.istruzione.ossscudig.model.dto.StoricizzazioneDTO;
import it.istruzione.ossscudig.services.AnagrafeScuolaService;
import it.istruzione.ossscudig.services.GestioneRilevazioneService;
import it.istruzione.ossscudig.services.MonitoraggioService;

@Controller
//@PreAuthorize("isAuthorized('#acquisizioneRilevazione?breadcrumbTitle=AcquisizioneRilevazione')")
public class GestioneStoricizzazioneController extends BaseController {

	private static Logger logger = Logger.getLogger(GestioneStoricizzazioneController.class);
	
	@Autowired
	private GestioneRilevazioneService gestioneRilevazioneService;
	@Autowired
	private AnagrafeScuolaService anagrafeScuolaService;
	@Autowired
	private MonitoraggioService monitoraggioServiceImpl;
	
	@RequestMapping("/gestioneStoricizzazione" )
	public String gestioneStoricizzazione(Model model, HttpServletRequest request) throws Exception {
		logger.debug("gestioneStoricizzazione");
		model.addAttribute("messageInserisStoric",null);
		RilevazioneDTO rilevazioneDTO = gestioneRilevazioneService.loadRilevazioneAttiva();
		if (rilevazioneDTO != null) {
			logger.debug("rilevazione attiva : " + rilevazioneDTO.getId());
			model.addAttribute("rilevazione", DtoFactory.fromDtoToForm(rilevazioneDTO));
		}
		List<StoricizzazioneDTO>  storicizzazione =  gestioneRilevazioneService.loadStoricizzazione();
		model.addAttribute("storicizzazione", storicizzazione);
		return "pages/gestione/gestioneStoricizzazione";
	}
	
	@RequestMapping("/cancellaRecordStoricizzazione.html")
	public String cancellaRecordStoricizzazione(Model model, HttpServletRequest request) throws Exception {
		logger.debug("cancellaRecord.html");
		RilevazioneDTO rilevazioneDTO = gestioneRilevazioneService.loadRilevazioneAttiva();
		if (rilevazioneDTO != null) {
			logger.debug("rilevazione attiva : " + rilevazioneDTO.getId());
			model.addAttribute("rilevazione", DtoFactory.fromDtoToForm(rilevazioneDTO));
		}
		Map<String, String[]> mappaParametri =   request.getParameterMap();	
		String id = mappaParametri.get("id")[0];
		String dataStoricizzazione = mappaParametri.get("dataStoricizzazione")[0];
		if (dataStoricizzazione!=null && !"".equals(dataStoricizzazione.trim())){
			Date dataOdierna=CommonsUtility.getTodayDate();
			Date dataStor=CommonsUtility.parse(dataStoricizzazione);		
			if (dataStor.after(dataOdierna)) {
			gestioneRilevazioneService.deleteFieldStoricizzazione(Long.valueOf(id));
			}
		}			
		List<StoricizzazioneDTO>  storicizzazione =  gestioneRilevazioneService.loadStoricizzazione();
		model.addAttribute("storicizzazione", storicizzazione);
		return "pages/gestione/gestioneStoricizzazione";
	}
	@RequestMapping("/confermaDataStoricizzazione.html")
	public String confermaDataStoricizzazione(Model model, HttpServletRequest request) throws Exception {
		logger.debug("confermaDataStoricizzazione.html");
		model.addAttribute("messageInserisStoric",null);
		RilevazioneDTO dto = gestioneRilevazioneService.loadRilevazioneAttiva();
	
		if (dto != null) {
			logger.debug("rilevazione attiva : " + dto.getId());
			model.addAttribute("rilevazione", DtoFactory.fromDtoToForm(dto));
		}
		Map<String, String[]> mappaParametri =   request.getParameterMap();	
		String dataStoricizzazione = mappaParametri.get("dataStoricizzazione")[0];
		if (dataStoricizzazione!=null && !"".equals(dataStoricizzazione.trim())){
			Date dataOdierna=CommonsUtility.getTodayDate();
			Date dataStor=CommonsUtility.parse(dataStoricizzazione);		
			if (dataStor.after(dataOdierna)) {
			gestioneRilevazioneService.insertStoricizzazione(dto.getId(),dataStoricizzazione);
		} else {
			model.addAttribute("messageInserisStoric","Non e possibile inserire una nuova storicizzazione se si sceglie una data minore della data odierna");
		}
		}			
		List<StoricizzazioneDTO>  storicizzazione =  gestioneRilevazioneService.loadStoricizzazione();
		model.addAttribute("storicizzazione", storicizzazione);
		return "pages/gestione/gestioneStoricizzazione";
	}

	
}
	
	



