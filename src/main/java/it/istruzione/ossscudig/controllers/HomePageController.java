package it.istruzione.ossscudig.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import it.istruzione.ossscudig.model.dto.AvvisiDTO;
import it.istruzione.ossscudig.services.AvvisiService;

@Controller

public class HomePageController extends BaseController {

	private static Logger logger = Logger.getLogger(HomePageController.class);
	@Autowired
	private AvvisiService avvisiService;
	@RequestMapping("/avvisiHome.html" )
	public String avvisiHome(Model model, HttpServletRequest request) throws Exception {
		logger.debug("monitoraggioRilevazione.html");
		List <AvvisiDTO> avvisi=avvisiService.loadAvvisi();
		model.addAttribute("avvisi", avvisi);
		return "pages/home";
	}
	
}

