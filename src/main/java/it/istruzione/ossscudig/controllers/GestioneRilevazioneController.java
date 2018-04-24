package it.istruzione.ossscudig.controllers;

import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.istruzione.ossscudig.constant.TIPO_STATO_RILEVAZIONE;
import it.istruzione.ossscudig.controllers.helper.DtoFactory;
import it.istruzione.ossscudig.controllers.util.CommonsUtility;
import it.istruzione.ossscudig.model.dto.RilevazioneDTO;
import it.istruzione.ossscudig.model.entity.Tod1013Gestpropristanza;
import it.istruzione.ossscudig.model.formObject.RilevazioneForm;
import it.istruzione.ossscudig.services.GestioneRilevazioneService;

@Controller
public class GestioneRilevazioneController extends BaseController {

	private static Logger logger = Logger.getLogger(GestioneRilevazioneController.class);

	@Autowired
	private GestioneRilevazioneService gestioneRilevazioneService;

	@RequestMapping("/gestioneRilevazione.html")
	public String gestioneRilevazione(Model model, HttpServletRequest request) throws Exception {
		logger.debug("gestioneRilevazione.html");
		getContestoCorrente();
		List<RilevazioneDTO> rilevazioni = gestioneRilevazioneService.getRilevazioni();
		logger.debug(ReflectionToStringBuilder.toString(rilevazioni, ToStringStyle.MULTI_LINE_STYLE));
		// model.addAttribute("rilevazioni", rilevazioni);
		List<RilevazioneDTO> rilevazioniFiltro = new ArrayList<>();
		for (int i = 0; i < rilevazioni.size(); i++) {
			if (rilevazioni.get(i).getStato().getCodice().equals("2")
					|| rilevazioni.get(i).getStato().getCodice().equals("5")
					|| rilevazioni.get(i).getStato().getCodice().equals("3")) {
				rilevazioniFiltro.add(rilevazioni.get(i));
				model.addAttribute("rilevazioni", rilevazioniFiltro);
			}

		}
		return "pages/gestione/gestioneRilevazione";
	}

	@RequestMapping(value = "/dettaglioRilevazione.html", method = { RequestMethod.GET, RequestMethod.POST })
	public String dettaglioRilevazione(Model model, HttpServletRequest request) {
		String id = request.getParameter("id");
		RilevazioneDTO dto = gestioneRilevazioneService.getRilevazioneById(id);
		model.addAttribute("rilevazioneForm", DtoFactory.fromDtoToForm(dto));
		return "pages/gestione/dettaglioGestioneRilevazione";
	}

	@RequestMapping(value = "/salvaRilevazione.html", method = { RequestMethod.GET, RequestMethod.POST })
	public String salvaRilevazione(Model model, HttpServletRequest request,
			@ModelAttribute("rilevazioneForm") @Valid RilevazioneForm rilevazioneForm) {
		model.addAttribute("messageRilevazione", null);
		boolean stato = false;
		rilevazioneForm.setId(request.getParameter("id"));
		if ("Sospendi".equals(request.getParameter("nomeBottone"))) {
			rilevazioneForm.setStato(TIPO_STATO_RILEVAZIONE.APERTA);
			stato = true;
		}
		if (request.getParameter("stato").equals("APERTA")) {
			rilevazioneForm.setStato(TIPO_STATO_RILEVAZIONE.APERTA);
		} else if (request.getParameter("stato").equals("APPROVATO")) {
			rilevazioneForm.setStato(TIPO_STATO_RILEVAZIONE.APPROVATO);
		} else if (request.getParameter("stato").equals("SOSPESA")) {
			rilevazioneForm.setStato(TIPO_STATO_RILEVAZIONE.SOSPESA);
		}
		rilevazioneForm.setDataFine(request.getParameter("dataFine"));
		rilevazioneForm.setDataInizio(request.getParameter("dataInizio"));
		List<Tod1013Gestpropristanza> listacampioni = gestioneRilevazioneService.findCampione(Long.valueOf(rilevazioneForm.getId()));
		int sizeListaCampioni = listacampioni.size();
		Date dataOdierna = CommonsUtility.getTodayDate();
		Date dataInizio = CommonsUtility.parse(rilevazioneForm.getDataInizio());
		Date dataFine = CommonsUtility.parse(rilevazioneForm.getDataFine());
	
		if (rilevazioneForm.getDataInizio() != null && !"".equals(rilevazioneForm.getDataInizio().trim()) && dataOdierna.after(dataInizio) && !dataOdierna.after(dataInizio)) {
				model.addAttribute("messageRilevazione",
						"Non e' possibile aprire una rilevazione se si sceglie una data minore della data odierna");
		}
		else if (rilevazioneForm.getDataFine() != null && !"".equals(rilevazioneForm.getDataFine().trim()) && dataOdierna.after(dataFine)) {

				model.addAttribute("messageRilevazione",
						"Non e' possibile chiudere una rilevazione se si sceglie una data minore della data odierna");
		}
		else if (sizeListaCampioni == 0) {
			
				model.addAttribute("messageRilevazione",
						"Non e' possibile salvare senza aver gestito i campioni");
		
		} 
		else if (!request.getParameter("stato").equals("CHIUSA") ) {

			RilevazioneDTO dto = gestioneRilevazioneService.salvaGestioneRilevazione(rilevazioneForm, stato);
			model.addAttribute("rilevazioneForm", DtoFactory.fromDtoToForm(dto));
		}

		return "pages/gestione/dettaglioGestioneRilevazione";

	}

}