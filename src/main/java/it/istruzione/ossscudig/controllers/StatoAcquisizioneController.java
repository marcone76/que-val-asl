package it.istruzione.ossscudig.controllers;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import it.istruzione.ossscudig.controllers.helper.DtoFactory;
import it.istruzione.ossscudig.model.dto.AcquisizioneQuestionarioInCorsoDTO;
import it.istruzione.ossscudig.model.dto.AcquisizioneRilevazioneValidataDTO;
import it.istruzione.ossscudig.model.dto.LabelValueDTO;
import it.istruzione.ossscudig.model.dto.RilevazioneDTO;
import it.istruzione.ossscudig.services.GestioneRilevazioneService;
import it.istruzione.ossscudig.services.MonitoraggioService;

@Controller

public class StatoAcquisizioneController extends BaseController {

	private static Logger logger = Logger.getLogger(StatoAcquisizioneController.class);

	@Autowired
	private GestioneRilevazioneService gestioneRilevazioneService;
	@Autowired
	private MonitoraggioService monitoraggioServiceImpl;
	@Autowired
	private ServiziGenericiController serviziGenericiController;

	@RequestMapping("/statoAcquisizione.html")
	public String statoAcquisizione(Model model, HttpServletRequest request) throws Exception {
		logger.debug("statoAcquisizione.html");
		RilevazioneDTO dto = gestioneRilevazioneService.loadRilevazioneAttiva();
		model.addAttribute("rilevazione", DtoFactory.fromDtoToForm(dto));

		LinkedList<LabelValueDTO> questionari = monitoraggioServiceImpl.getQuestionari();
		LinkedList<LabelValueDTO> cicliScolastici =getCicloScolastico();
		model.addAttribute("cicliScolastici", cicliScolastici);
		model.addAttribute("questionari", questionari);
		LinkedList<LabelValueDTO> regioni = monitoraggioServiceImpl.getRegioni();
		model.addAttribute("regioni", regioni);
		model.addAttribute("province", serviziGenericiController.aggiornaListaProvince(model, ""));
		model.addAttribute("comuni", serviziGenericiController.aggiornaListaComuni(model, ""));
		return "pages/monitoraggio/statoAcquisizione";
	}

	@RequestMapping("/elencoQuestionariStatoAcquisizioneInCorso")
	public String elencoQuestionariStatoAcquisizioneInCorso(Model model, HttpServletRequest request) throws Exception {
		logger.debug("elencoQuestionariStatoAcquisizioneInCorso");
		String regione = request.getParameter("regione");
		String provincia = request.getParameter("provincia");
		String comune = request.getParameter("comune");
		String cicloScolastico = request.getParameter("cicloScolastico");
		model.addAttribute("regioneR", regione);
		model.addAttribute("provinciaR", provincia);
		model.addAttribute("comuneR", comune);
		model.addAttribute("cicloScolasticoR", cicloScolastico);
		Map<String, String[]> mappaParametri = request.getParameterMap();
		for (String param : mappaParametri.keySet()) {
			logger.debug("param : " + param + " --- param : " + mappaParametri.get(param)[0]);
		}
		RilevazioneDTO rilevazioneDTO = gestioneRilevazioneService.loadRilevazioneAttiva();
		if (rilevazioneDTO != null) {
			logger.debug("rilevazione attiva : " + rilevazioneDTO.getId());
			model.addAttribute("rilevazione", DtoFactory.fromDtoToForm(rilevazioneDTO));
		
			List<AcquisizioneQuestionarioInCorsoDTO> listaElencoQuestionarioInCorso = monitoraggioServiceImpl.getAcquisizioneQuestionarioInCorso(rilevazioneDTO.getId(),getCodice(regione,"/"),getCodice(provincia,"/"),getCodice(comune,"/"), cicloScolastico!=null ? cicloScolastico : "");

			model.addAttribute("listaElencoQuestionarioInCorso", listaElencoQuestionarioInCorso);
		}
		return "pages/monitoraggio/elencoQuestionariStatoAcquisizioneInCorso";
	}

	@RequestMapping("/elencoQuestionariStatoAcquisizioneValidati")
	public String elencoQuestionariStatoAcquisizioneValidati(Model model, HttpServletRequest request) throws Exception {
		logger.debug("elencoQuestionariStatoAcquisizioneValidati");

		String regione = request.getParameter("regione");
		String provincia = request.getParameter("provincia");
		String comune = request.getParameter("comune");
		String cicloScolastico = request.getParameter("cicloScolastico");
		model.addAttribute("regioneR", regione);
		model.addAttribute("provinciaR", provincia);
		model.addAttribute("comuneR", comune);
		model.addAttribute("cicloScolasticoR", cicloScolastico);
		Map<String, String[]> mappaParametri = request.getParameterMap();
		for (String param : mappaParametri.keySet()) {
			logger.debug("param : " + param + " --- param : " + mappaParametri.get(param)[0]);
		}

		RilevazioneDTO rilevazioneDTO = gestioneRilevazioneService.loadRilevazioneAttiva();
		if (rilevazioneDTO != null) {
			logger.debug("rilevazione attiva : " + rilevazioneDTO.getId());
			model.addAttribute("rilevazione", DtoFactory.fromDtoToForm(rilevazioneDTO));

			List<AcquisizioneRilevazioneValidataDTO> listaElencoQuestionarioValidati = monitoraggioServiceImpl.getAcquisizioneRilevazioneValidata(rilevazioneDTO.getId(),getCodice(regione,"/"),getCodice(provincia,"/"),getCodice(comune,"/"), cicloScolastico!=null ? cicloScolastico : "");
			model.addAttribute("listaElencoQuestionarioValidati", listaElencoQuestionarioValidati);
		}

		return "pages/monitoraggio/elencoRilevazioniStatoAcquisizioneValidati";
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