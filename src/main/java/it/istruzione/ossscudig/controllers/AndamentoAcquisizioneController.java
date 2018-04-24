package it.istruzione.ossscudig.controllers;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import it.istruzione.ossscudig.controllers.helper.DtoFactory;
import it.istruzione.ossscudig.model.dto.LabelValueDTO;
import it.istruzione.ossscudig.model.dto.RilevazioneDTO;
import it.istruzione.ossscudig.services.GestioneRilevazioneService;
import it.istruzione.ossscudig.services.MonitoraggioService;

@Controller
//@PreAuthorize("isAuthorized('#acquisizioneRilevazione?breadcrumbTitle=AcquisizioneRilevazione')")
public class AndamentoAcquisizioneController extends BaseController {

	private static Logger logger = Logger.getLogger(AndamentoAcquisizioneController.class);
	
	@Autowired
	private GestioneRilevazioneService gestioneRilevazioneService;
	
	@Autowired
	private MonitoraggioService monitoraggioServiceImpl;
	
	@Autowired
	private ServiziGenericiController serviziGenericiController;
	
	@RequestMapping("/andamentoAcquisizione" )
	public String andamentoAcquisizione(Model model, HttpServletRequest request) throws Exception {
		logger.debug("andamentoAcquisizione");
		
		RilevazioneDTO dto = gestioneRilevazioneService.loadRilevazioneAttiva();
		model.addAttribute("rilevazione", DtoFactory.fromDtoToForm(dto));
		LinkedList<LabelValueDTO> cicliScolastici =getCicloScolastico();
		model.addAttribute("cicliScolastici", cicliScolastici);
		LinkedList<LabelValueDTO> regioni = monitoraggioServiceImpl.getRegioni();
		model.addAttribute("regioni", regioni);
		model.addAttribute("province",serviziGenericiController.aggiornaListaProvince(model,""));
		model.addAttribute("comuni", serviziGenericiController.aggiornaListaComuni(model,""));
		
		return "pages/monitoraggio/andamentoAcquisizione";
	}
	
	public LinkedList<LabelValueDTO> getCicloScolastico() {
		LinkedList<LabelValueDTO> out = new LinkedList<>();
		LabelValueDTO item1 = new LabelValueDTO();
		 item1.setValue("1");
		 item1.setLabel("Primo Ciclo");
		out.add(item1);
		
		LabelValueDTO item2 = new LabelValueDTO();
		 item2.setValue("2");
		 item2.setLabel("Secondo Ciclo");
		out.add(item2);
		
		return out;
	}


}