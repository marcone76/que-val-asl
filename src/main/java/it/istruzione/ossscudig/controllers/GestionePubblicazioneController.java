package it.istruzione.ossscudig.controllers;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import it.istruzione.ossscudig.controllers.helper.DtoFactory;
import it.istruzione.ossscudig.model.dto.PubblicazioneDTO;
import it.istruzione.ossscudig.model.dto.RilevazioneDTO;
import it.istruzione.ossscudig.services.GestioneRilevazioneService;

@Controller
public class GestionePubblicazioneController extends BaseController {

	private static Logger logger = Logger.getLogger(GestioneDomandeController.class);

	@Autowired
	private GestioneRilevazioneService gestioneRilevazioneService;

	@RequestMapping("/gestionePubblicazione.html")
	public String gestionePubblicazione(Model model, HttpServletRequest request) throws Exception {
		logger.debug("gestionePubblicazione.html");
		RilevazioneDTO rilevazioneDTO = gestioneRilevazioneService.loadRilevazioneAttiva();
		if (rilevazioneDTO != null) {
			logger.debug("rilevazione attiva : " + rilevazioneDTO.getId());
			model.addAttribute("rilevazione", DtoFactory.fromDtoToForm(rilevazioneDTO));
		}

		List<PubblicazioneDTO> pubblicazione = gestioneRilevazioneService.loadPubblicazione();
		model.addAttribute("pubblicazione", pubblicazione);

		return "pages/gestione/gestionePubblicazione";
	}
	


	@RequestMapping("/gestioneRecordS.html")
	public String gestioneRecordS(Model model, HttpServletRequest request) throws Exception {
		logger.debug("gestioneRecordS.html");
	
		RilevazioneDTO rilevazioneDTO = gestioneRilevazioneService.loadRilevazioneAttiva();
		if (rilevazioneDTO != null) {
			logger.debug("rilevazione attiva : " + rilevazioneDTO.getId());
			model.addAttribute("rilevazione", DtoFactory.fromDtoToForm(rilevazioneDTO));
		}
		Map<String, String[]> mappaParametri =   request.getParameterMap();
		String codQuest = mappaParametri.get("codQuest")[0];	
		String id = mappaParametri.get("id")[0];
			String codicedomanda = request.getParameter("codicedomanda");
			String limitemassimoB =null;
			if (request.getParameter("limiteMassimo").isEmpty()) {}else {
			 limitemassimoB = request.getParameter("limiteMassimo");}
			
			String limiteminimoB=null;
			if (request.getParameter("limiteMinimo").isEmpty()) {}else {
			 limiteminimoB = request.getParameter("limiteMinimo");}

			List<PubblicazioneDTO> pubblicazioneRecord = gestioneRilevazioneService.getRecordPubblicati(codicedomanda,
					limiteminimoB,limitemassimoB);
			model.addAttribute("pubblicazioneRecord", pubblicazioneRecord);

			PubblicazioneDTO pubblicazioneDTO = gestioneRilevazioneService.percentualeRecordIgnorati(codicedomanda,
					 limiteminimoB,limitemassimoB);
			pubblicazioneDTO.setCodDmd(codicedomanda);
			pubblicazioneDTO.setCodQuest(mappaParametri.get("codQuest")[0]);
			pubblicazioneDTO.setPrgIstRil(Long.valueOf(id).longValue());
			pubblicazioneDTO.setFiltroMas(limitemassimoB);
			pubblicazioneDTO.setFiltroMin(limiteminimoB);
			model.addAttribute("pubblicazionePercentualeRecord", pubblicazioneDTO);

		return "pages/gestione/gestioneRecords";
	}
	
	@RequestMapping("/applicaFiltri.html")
	public String applicaFiltri(Model model, HttpServletRequest request) throws Exception {
		logger.debug("applicaFiltri.html");
		Map<String, String[]> mappaParametri =   request.getParameterMap();
			String codicedomanda = request.getParameter("codicedomanda");
			String limitemassimoB =null;
			if (request.getParameter("limiteMassimo").isEmpty()) {}else {
			 limitemassimoB = request.getParameter("limiteMassimo");}		
			String limiteminimoB=null;
			if (request.getParameter("limiteMinimo").isEmpty()) {}else {
			 limiteminimoB = request.getParameter("limiteMinimo");}
			PubblicazioneDTO pubblicazioneDTO =new PubblicazioneDTO();
			pubblicazioneDTO.setCodDmd(codicedomanda);
			pubblicazioneDTO.setCodQuest(mappaParametri.get("codQuest")[0]);
			pubblicazioneDTO.setPrgIstRil(Long.valueOf(mappaParametri.get("id")[0]).longValue());
			pubblicazioneDTO.setFiltroMas(limitemassimoB);
			pubblicazioneDTO.setFiltroMin(limiteminimoB);		
		    gestioneRilevazioneService.insertFiltri(pubblicazioneDTO);
		    
		    List<PubblicazioneDTO> pubblicazioneRecord = gestioneRilevazioneService.getRecordPubblicati(codicedomanda,
					 limiteminimoB,limitemassimoB);
			model.addAttribute("pubblicazioneRecord", pubblicazioneRecord);

			PubblicazioneDTO pubblicazioneDTO1 = gestioneRilevazioneService.percentualeRecordIgnorati(codicedomanda,
					 limiteminimoB,limitemassimoB);
			pubblicazioneDTO1.setCodDmd(codicedomanda);
			pubblicazioneDTO1.setCodQuest(mappaParametri.get("codQuest")[0]);
			pubblicazioneDTO1.setPrgIstRil(Long.valueOf(mappaParametri.get("id")[0]).longValue());
			pubblicazioneDTO1.setFiltroMas(limitemassimoB);
			pubblicazioneDTO1.setFiltroMin(limiteminimoB);
			model.addAttribute("pubblicazionePercentualeRecord", pubblicazioneDTO1);
		    
		    
			
		return "pages/gestione/gestioneRecords";
	}

	
	@RequestMapping("/pubblica.html")
	public String pubblica(Model model, HttpServletRequest request) throws Exception {
		String isFiltered = (String)request.getParameter("isFiltered");
		
		if(isFiltered.equals("true")) {
			gestioneRilevazioneService.pubblicaRilevazione(true);
		}else {
			gestioneRilevazioneService.pubblicaRilevazione(false);
		}
		
		List<PubblicazioneDTO> pubblicazione = gestioneRilevazioneService.loadPubblicazione();
		model.addAttribute("pubblicazione", pubblicazione);
		
		
		return "pages/gestione/gestionePubblicazione";
		
	}
	
	
	
}