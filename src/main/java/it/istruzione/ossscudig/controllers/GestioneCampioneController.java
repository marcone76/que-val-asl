package it.istruzione.ossscudig.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import it.istruzione.commons.utils.FormResponse;
import it.istruzione.ossscudig.controllers.helper.DtoFactory;
import it.istruzione.ossscudig.model.dto.LabelValueDTO;
import it.istruzione.ossscudig.model.dto.QuestionarioDTO;
import it.istruzione.ossscudig.model.dto.RilevazioneDTO;
import it.istruzione.ossscudig.services.AnagrafeQuestionarioService;
import it.istruzione.ossscudig.services.AnagrafeScuolaService;
import it.istruzione.ossscudig.services.GestioneRilevazioneService;
import it.istruzione.ossscudig.services.MonitoraggioService;

@Controller
// @PreAuthorize("isAuthorized('#acquisizioneRilevazione?breadcrumbTitle=AcquisizioneRilevazione')")
public class GestioneCampioneController extends BaseController {

	private static Logger logger = Logger.getLogger(GestioneCampioneController.class);

	@Autowired
	private GestioneRilevazioneService gestioneRilevazioneService;
	@Autowired
	private AnagrafeQuestionarioService anagrafeQuestionarioService;
	@Autowired
	private AnagrafeScuolaService anagrafeScuolaService;
	@Autowired
	private MonitoraggioService monitoraggioServiceImpl;

	@RequestMapping("/gestioneCampione")
	public String gestioneCampione(Model model, HttpServletRequest request) throws Exception {
		logger.debug("gestioneCampione");

		RilevazioneDTO dto = gestioneRilevazioneService.loadRilevazioneApprovata();
		if (dto != null) {
			model.addAttribute("rilevazione", DtoFactory.fromDtoToForm(dto));
		}

		LinkedList<LabelValueDTO> regioni = monitoraggioServiceImpl.getRegioni();
		model.addAttribute("regioni", regioni);
		LinkedList<LabelValueDTO> tipologiaIstituto = getTipologiaIstituto();
		model.addAttribute("tipologiaIstituto", tipologiaIstituto);
		String ordineScuola1 = "INFANZIA";
		model.addAttribute("ordineScuola1", ordineScuola1);
		String ordineScuola2 = "PRIMARIA";
		model.addAttribute("ordineScuola2", ordineScuola2);
		String ordineScuola3 = "SECONDARIA PRIMO GRADO";
		model.addAttribute("ordineScuola3", ordineScuola3);
		String ordineScuola4 = "SECONDARIA SECONDO GRADO";
		model.addAttribute("ordineScuola4", ordineScuola4);
		String ordineScuola5 = "ISTITUTO COMPRENSIVO";
		model.addAttribute("ordineScuola5", ordineScuola5);
		String ordineScuola6 = "CENTRO TERRITORIALE";
		model.addAttribute("ordineScuola6", ordineScuola6);
		String ordineScuola7 = "TUTTI";
		model.addAttribute("ordineScuola7", ordineScuola7);

		String adulti = "SI";
		model.addAttribute("adulti", adulti);

		model.addAttribute("regione", regioni);
		model.addAttribute("tipologiaIstituto", tipologiaIstituto);

		return "pages/gestione/gestioneCampione";
	}

	@RequestMapping("/gestioneCampioneFiltri")
	public String gestioneCampioneFiltri(Model model, HttpServletRequest request) throws Exception {
		logger.debug("gestioneCampione");
		String regione = "";
		String tipologia = "";
		String adulti = "NO";
		int id = 0;
		List<String> ordini = new ArrayList<>();

		RilevazioneDTO dto = gestioneRilevazioneService.loadRilevazioneApprovata();
		if (dto != null) {
			model.addAttribute("rilevazione", DtoFactory.fromDtoToForm(dto));
		}
		gestioneRilevazioneService.deleteFieldCampione(dto.getId());

		Map<String, String[]> mappaParametri = request.getParameterMap();
		for (String param : mappaParametri.keySet()) {
			logger.debug("param : " + param + " --- param : " + mappaParametri.get(param)[0]);

			regione = mappaParametri.get("regioneCamp.value")[0];
			gestioneRilevazioneService.insertFieldCampione(dto.getId(), regione, "REGIONE", ++id);

			tipologia = mappaParametri.get("tipologiaIstituto.value")[0];
			gestioneRilevazioneService.insertFieldCampione(dto.getId(), tipologia, "TIPOLOGIA_ISTITUTO", ++id);
			if (request.getParameter("adulti") != null) {
				adulti= mappaParametri.get("adulti")[0];}
				gestioneRilevazioneService.insertFieldCampione(dto.getId(),adulti, "ADULTI",++id);
			
			for (int i = 0; i < mappaParametri.get("ordine").length; i++) {

				String ordineScuola = mappaParametri.get("ordine")[i];
				ordini.add(ordineScuola);
				gestioneRilevazioneService.insertFieldCampione(dto.getId(), ordineScuola, "INCLUDI_ORDINE", ++id);
			}
			break;
		}
		LinkedList<LabelValueDTO> regioni = monitoraggioServiceImpl.getRegioni();
		model.addAttribute("regioni", regioni);
		LinkedList<LabelValueDTO> tipologiaIstituto = getTipologiaIstituto();
		model.addAttribute("tipologiaIstituto", tipologiaIstituto);
		// LinkedList<LabelValueDTO> ordineScuola =getOrdineScuola();
		String ordineScuola1 = "INFANZIA";
		model.addAttribute("ordineScuola1", ordineScuola1);
		String ordineScuola2 = "PRIMARIA";
		model.addAttribute("ordineScuola2", ordineScuola2);
		String ordineScuola3 = "SECONDARIA PRIMO GRADO";
		model.addAttribute("ordineScuola3", ordineScuola3);
		String ordineScuola4 = "SECONDARIA SECONDO GRADO";
		model.addAttribute("ordineScuola4", ordineScuola4);
		String ordineScuola5 = "ISTITUTO COMPRENSIVO";
		model.addAttribute("ordineScuola5", ordineScuola5);
		String ordineScuola6 = "CENTRO TERRITORIALE";
		model.addAttribute("ordineScuola6", ordineScuola6);
		String ordineScuola7 = "TUTTI";
		model.addAttribute("ordineScuola7", ordineScuola7);
		model.addAttribute("adulti", adulti);

		return "pages/gestione/gestioneCampione";

	}

	public LinkedList<LabelValueDTO> getTipologiaIstituto() {
		Map<String, String> tipologiaIstituto = new HashMap<>();
		tipologiaIstituto.put("ST", "STATALI");
		tipologiaIstituto.put("PA", "PARITARIE");
		Set<Map.Entry<String, String>> set = tipologiaIstituto.entrySet();
		LinkedList<LabelValueDTO> out = new LinkedList<>();
		LabelValueDTO item = null;
		for (Map.Entry<String, String> ciclo : set) {
			item = new LabelValueDTO();
			item.setValue(ciclo.getKey());
			item.setLabel(ciclo.getValue());
			out.add(item);
		}
		return out;
	}


}