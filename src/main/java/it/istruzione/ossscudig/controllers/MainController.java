package it.istruzione.ossscudig.controllers;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import it.istruzione.commons.menu.Menu;
import it.istruzione.commons.menu.MenuBuilder;
import it.istruzione.commons.security.SidiContesto;
import it.istruzione.commons.security.SidiProfile;
import it.istruzione.commons.security.SidiUser;

@Controller
public class MainController {

	private static Logger logger = Logger.getLogger(MainController.class);
	
	@Value("${application.title}")
	private String applicationTitle;
	
	@Value("${application.description}")
	private String applicationDescription;
	
	@Value("${application.helpUrl}")
	private String helpUrl;
	
	@Autowired
	private MenuBuilder menuBuilder;

	@RequestMapping({ "/", "/index.html" })
	public String index(Model model, HttpServletRequest request) throws Exception {
		logger.debug("index.html");
		model.addAttribute("applicationTitle", applicationTitle);
		model.addAttribute("applicationDescription", applicationDescription);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		request.getSession().setAttribute("linkManuale", helpUrl);
		if (authentication != null && !request.isUserInRole("ROLE_ANONYMOUS")) {
			SidiUser sidiUser = (SidiUser) authentication.getPrincipal();
			Menu menu = menuBuilder.creaMenu(sidiUser);
			model.addAttribute("menu", menu.getMenu());

			// imposta un profilo di default
			if (sidiUser.getCurrentProfile() == null) {
//				if (!sidiUser.getSidiProfiles().isEmpty()) {
//					SidiProfile sidiProfile = sidiUser.getSidiProfiles().iterator().next();
//					String contesto = null;
//					if (!sidiProfile.getContesti().isEmpty()) {
//						contesto = sidiProfile.getContesti().iterator().next().getCodice();
//					}
//					sidiUser = cambiaContesto(sidiProfile.getNome(), contesto);
//				} else {
//					sidiUser.setCurrentProfile(new SidiProfile("", "", null, null));
//				}

			}
			model.addAttribute("singleProfile", true);
		}
		return "index";
	}

	@RequestMapping("/visualizzaProfiloContesto.html" )
	public String accessoCambiaProfiloContesto(Model model, HttpServletRequest request) throws Exception {
		logger.debug("cambiaProfiloContesto.html");
		model.addAttribute("applicationTitle", applicationTitle);
		model.addAttribute("applicationDescription", applicationDescription);
		model.addAttribute("singleProfile", true);
		return "includes/cambiaProfiloContesto";
	}
	
	@RequestMapping("/home.html")
	public String home(Model model) {
		logger.debug("home.html");
		model.addAttribute("applicationTitle", applicationTitle);
		model.addAttribute("applicationDescription", applicationDescription);
		model.addAttribute("singleProfile", true);

		SidiUser sidiUser = (SidiUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		logger.debug("home :  "+sidiUser.getCurrentProfile().getNome());
		logger.debug("home :  "+sidiUser.getCurrentProfile().getDescrizione());
		if(sidiUser.getCurrentProfile().getNome().equals("OTSURVEY_UTE_MON")) {
			return "forward:/monitoraggioRilevazione.html?breadcrumbTitle=MonitoraggioRilevazione";
		}
		
//		if(sidiUser.getCurrentProfile().getNome().equals("OTSURVEY_UTE_SCU")) {
//			return "forward:/acquisizioneRilevazione.html?breadcrumbTitle=AcquisizioneRilevazione";
//		}
		//inserimento avvisi utente in homepage
		return "forward:/avvisiHome.html?breadcrumbTitle=AvvisiHome";
		//	return "pages/home";
			 
	}

	@RequestMapping(value = "/cambiaProfiloContesto", method = RequestMethod.POST)
	public @ResponseBody SidiUser cambiaContesto(Model model, String currentProfile, String currentContext) {
		SidiUser sidiUser = (SidiUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		// aggiorno profilo
		SidiProfile sidiProfile = sidiUser.getSidiProfilesMap().get(currentProfile);
		sidiUser.setCurrentProfile(sidiProfile);

		// aggiorno contesto
		if (sidiProfile != null) {
			SidiContesto sidiContesto = sidiProfile.getContestiMap().get(currentContext);
			sidiUser.setCurrentContesto(sidiContesto);
		} else {
			sidiUser.setCurrentContesto(null);
		}

		logger.debug("sidiUser updated: " + sidiUser);
		return sidiUser;
	}

}