package it.istruzione.ossscudig.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dozer.DozerBeanMapper;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;

import it.istruzione.commons.utils.GeneralPrintService;
import it.istruzione.ossscudig.controllers.helper.DtoFactory;
import it.istruzione.ossscudig.controllers.util.CommonsUtility;
import it.istruzione.ossscudig.model.dto.ExportRispostaDTO;
import it.istruzione.ossscudig.model.dto.LabelValueDTO;
import it.istruzione.ossscudig.model.dto.MonitoraggioDTO;
import it.istruzione.ossscudig.model.dto.QuestionarioDTO;
import it.istruzione.ossscudig.model.dto.QuestionarioScuolaDTO;
import it.istruzione.ossscudig.model.dto.RilevazioneDTO;
import it.istruzione.ossscudig.model.dto.ScuolaDTO;
import it.istruzione.ossscudig.model.entity.Vod1001ModTabRis;
import it.istruzione.ossscudig.model.entity.Vod1002ModTabRisVal;
import it.istruzione.ossscudig.services.AnagrafeQuestionarioService;
import it.istruzione.ossscudig.services.AnagrafeScuolaService;
import it.istruzione.ossscudig.services.GestioneRilevazioneService;
import it.istruzione.ossscudig.services.MonitoraggioService;
import it.istruzione.ossscudig.services.RisposteInCorsoService;

@Controller
// @PreAuthorize("isAuthorized('#acquisizioneRilevazione?breadcrumbTitle=AcquisizioneRilevazione')")
public class EsportaAcquisizioneController extends BaseController {

	private static Logger logger = Logger.getLogger(EsportaAcquisizioneController.class);

	@Autowired
	private GestioneRilevazioneService gestioneRilevazioneService;

	@Autowired
	private AnagrafeScuolaService anagrafeScuolaService;

	@Autowired
	private GeneralPrintService  printService;

	@Autowired
	private AnagrafeQuestionarioService anagrafeQuestionarioService;

	@Autowired
	private MonitoraggioService monitoraggioServiceImpl;
	@Autowired
	private ServiziGenericiController serviziGenericiController;
	@Autowired
	private RisposteInCorsoService risposteInCorsoService;
	@Autowired
	private DozerBeanMapper rdDozerMapper;

	@RequestMapping("/esportaAcquisizione.html")
	public String esportaAcquisizione(Model model, HttpServletRequest request) throws Exception {
		logger.debug("esportaAcquisizione.html");

		RilevazioneDTO dto = gestioneRilevazioneService.loadRilevazioneAttiva();
		model.addAttribute("rilevazione", DtoFactory.fromDtoToForm(dto));
		//List<ScuolaDTO> scuole = anagrafeScuolaService.getScuoleAssociate(getContestoCorrente());

		model.addAttribute("command", new ScuolaDTO());

		LinkedList<LabelValueDTO> regioni = monitoraggioServiceImpl.getRegioni();
		LinkedList<LabelValueDTO> questionari = monitoraggioServiceImpl.getQuestionari();
		model.addAttribute("regioni", regioni);
		model.addAttribute("province", serviziGenericiController.aggiornaListaProvince(model, ""));
		model.addAttribute("comuni", serviziGenericiController.aggiornaListaComuni(model, ""));
		model.addAttribute("questionari", questionari);

		return "pages/monitoraggio/esportaAcquisizione";
	}

	@RequestMapping("/elencoQuestionariDaEsportare.html")
	public String elencoQuestionariDaEsportare(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.debug("elencoQuestionariDaEsportare.html");
		Map<String, String[]> mappaParametri =   request.getParameterMap();
		request.getParameter("regioneEs");
		String codMec = mappaParametri.get("codiceMeccanografico")[0];
		String regione = mappaParametri.get("regioneEs")[0];
		String provincia = mappaParametri.get("provinciaEs")[0];
		String comune = mappaParametri.get("comuneEs")[0];
		model.addAttribute("regioneR", regione);
		model.addAttribute("provinciaR", provincia);
		model.addAttribute("comuneR", comune);
		model.addAttribute("codMec", codMec);

		RilevazioneDTO rilevazioneDTO = gestioneRilevazioneService.loadRilevazioneAttiva();
		if (rilevazioneDTO != null) {
			logger.debug("rilevazione attiva : " + rilevazioneDTO.getId());
			model.addAttribute("rilevazione", DtoFactory.fromDtoToForm(rilevazioneDTO));

			List<MonitoraggioDTO> listaRilevazioneAcquisizione = monitoraggioServiceImpl.getElencoScuoleCount(rilevazioneDTO.getId().toString(), String.valueOf( CommonsUtility.getAnnoScolasticoCorrente()), getCodice(regione,"/"),getCodice(provincia,"/"),getCodice(comune,"/"), codMec);
			model.addAttribute("listaRilevazioneAcquisizione", listaRilevazioneAcquisizione);
		}

		return "pages/monitoraggio/elencoQuestionariDaEsportare";
	}


	

	

	@RequestMapping(value = "/esportaDati", method = { RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody List<QuestionarioScuolaDTO> esportaDati(Model model, HttpServletResponse response)
			throws Exception {
		logger.debug("esportaDati.json");


		RilevazioneDTO rilevazioneDTO = gestioneRilevazioneService.loadRilevazioneAttiva();

		/** caricamento delle scuole associate al contesto selezionato **/
		List<ScuolaDTO> scuole = anagrafeScuolaService.getScuoleAssociate(getContestoCorrente(),rilevazioneDTO.getId());
		logger.debug("scuole associate : " + scuole.size());

		/** caricamento dei questionari associati all'istanza di rilevazione attiva **/
		Map<String, QuestionarioDTO> mapQuestionariByRilevazione = anagrafeQuestionarioService
				.findQuestionariByRilevazione(rilevazioneDTO.getId());
		logger.debug("QuestionariByRilevazione : " + mapQuestionariByRilevazione.size());

		/**
		 * associare i questionari alle scuole con lo stato. Per ogni scuola bisogna
		 * visualizzare un record per ogni questionario a cui è abilitata
		 **/
		QuestionarioScuolaDTO questionario = new QuestionarioScuolaDTO();
		List<QuestionarioScuolaDTO> questionari = this.getQuestionariAbilitatiPerScuole(scuole, rilevazioneDTO,	mapQuestionariByRilevazione);
		return questionari;
	}


	@RequestMapping("/elencoQuestionariDaEsportarePage.html")
	public String elencoQuestionariDaEsportarePage(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.debug("elencoQuestionariDaEsportarePage.html");

		return "pages/monitoraggio/elencoQuestionariDaEsportare";
	}

	@RequestMapping(value = "/esportaAcquisizioneInCorso.html", method = { RequestMethod.GET, RequestMethod.POST })
	public String esportaAcquisizioneInCorso(Model model, HttpServletResponse response, HttpServletRequest req) throws Exception {
		logger.debug("esportaAcquisizioneInCorso");
		RilevazioneDTO rilevazioneDTO = gestioneRilevazioneService.loadRilevazioneAttiva();
		if (rilevazioneDTO != null) {
			logger.debug("rilevazione attiva : " + rilevazioneDTO.getId());
			model.addAttribute("rilevazione", DtoFactory.fromDtoToForm(rilevazioneDTO));
			String codMec = req.getParameter("codMec");
			String regioned = req.getParameter("regioneEs");		
			String provinciad = req.getParameter("provinciaEs");			
			String comuned = req.getParameter("comuneEs");		
			String codQst = req.getParameter("codQst");
			model.addAttribute("regioneR", regioned);
			model.addAttribute("provinciaR", provinciad);
			model.addAttribute("comuneR", comuned);
			model.addAttribute("codMec", codMec);
			model.addAttribute("codQst", codQst);

			//ORA PAGINAZIONE LATO SERVER
//			List<Vod1001ModTabRis> listaDomandaInCorso = risposteInCorsoService.findAll(codQst,"",getCodice(comuned,"/"),getCodice(provinciad,"/"),getCodice(regioned,"/"));
//			ArrayList<ExportRispostaDTO> listaOut = new ArrayList<>();
//			ExportRispostaDTO rispostaDTO = null;
//			Vod1001ModTabRis vod1001ModTabRis = null;
//			for (Iterator<Vod1001ModTabRis> iterator = listaDomandaInCorso.iterator(); iterator.hasNext();) {
//				rispostaDTO = new ExportRispostaDTO();
//				vod1001ModTabRis = (Vod1001ModTabRis) iterator.next();
//				rispostaDTO = rdDozerMapper.map(vod1001ModTabRis, ExportRispostaDTO.class);
//				listaOut.add(rispostaDTO);
//			}
//			model.addAttribute("listaDomandaInCorso", listaOut);
		}
		return "pages/monitoraggio/dettaglioEsportaAcquisizioneInCorso";
	}

	@RequestMapping(value = "/esportaAcquisizioneValidato.html", method = { RequestMethod.GET, RequestMethod.POST })
	public String esportaAcquisizioneValidato(Model model, HttpServletResponse response, HttpServletRequest req) throws Exception {
		
		logger.debug("esportaAcquisizioneValidato");
		
		RilevazioneDTO rilevazioneDTO = gestioneRilevazioneService.loadRilevazioneAttiva();
		
		if (rilevazioneDTO != null)
		{
			logger.debug("rilevazione attiva : " + rilevazioneDTO.getId());
			model.addAttribute("rilevazione", DtoFactory.fromDtoToForm(rilevazioneDTO));
			String codMec = req.getParameter("codMec");
			String regioned = req.getParameter("regioneEs");		
			String provinciad = req.getParameter("provinciaEs");			
			String comuned = req.getParameter("comuneEs");		
			String codQst = req.getParameter("codQst");
			model.addAttribute("regioneR", regioned);
			model.addAttribute("provinciaR", provinciad);
			model.addAttribute("comuneR", comuned);
			model.addAttribute("codMec", codMec);
			model.addAttribute("codQst", codQst);
			
			//ORA PAGINAZIONE LATO SERVER
//			List<Vod1002ModTabRisVal> listaDomandaValidato = risposteInCorsoService.findAllVal(codQst,"",getCodice(comuned,"/"),getCodice(provinciad,"/"),getCodice(regioned,"/"));
//			ArrayList<ExportRispostaDTO> listaOut = new ArrayList<>();
//			ExportRispostaDTO rispostaDTO = null;
//			Vod1002ModTabRisVal vod1002ModTabRisVal = null;
//			for (Iterator<Vod1002ModTabRisVal> iterator = listaDomandaValidato.iterator(); iterator.hasNext();) {
//				rispostaDTO = new ExportRispostaDTO();
//				vod1002ModTabRisVal = (Vod1002ModTabRisVal) iterator.next();
//				rispostaDTO = rdDozerMapper.map(vod1002ModTabRisVal, ExportRispostaDTO.class);
//				listaOut.add(rispostaDTO);
//			}
//			model.addAttribute("listaDomandaValidato", listaOut);
		}
		return "pages/monitoraggio/dettaglioEsportaAcquisizioneValidato";
	}

	@RequestMapping(value = "/scaricaAcquisizioneDomandeInCorso.html")
	public View scaricaAcquisizioneDomandeInCorso(
			Model model, 
			@RequestParam(value = "Regione", required = false ) String regione, 
			@RequestParam(value = "Provincia", required = false ) String  provincia,
			@RequestParam(value = "Comune", required = false ) String comune
			,HttpServletRequest request,HttpServletResponse response) throws Exception{

		logger.debug("scaricaAcquisizioneDomandeInCorso('"+ "')...");

		String codQst = request.getParameter("codQst");
		View retView = null;
		List<Vod1001ModTabRis> listaDomandaInCorso = risposteInCorsoService.findAll(codQst,"",getCodice(comune,"/"),getCodice(provincia,"/"),getCodice(regione,"/"));

		ArrayList<ExportRispostaDTO> listaOut = new ArrayList<>();
		ExportRispostaDTO rispostaDTO = null;
		Vod1001ModTabRis vod1001ModTabRis = null;

		for (Iterator<Vod1001ModTabRis> iterator = listaDomandaInCorso.iterator(); iterator.hasNext();)
		{
			rispostaDTO = new ExportRispostaDTO();
			vod1001ModTabRis = (Vod1001ModTabRis) iterator.next();
			rispostaDTO = rdDozerMapper.map(vod1001ModTabRis, ExportRispostaDTO.class);
			listaOut.add(rispostaDTO);
		}

		model.addAttribute("listaDomanda", listaOut);

		String path="",inCorsoValidate=" IN CORSO ";
		model.addAttribute("inCorsoValidate", inCorsoValidate);

		if("pdf".equalsIgnoreCase(request.getParameter("formato")))
			path = "pages/monitoraggio/".concat("stampaPdfDettaglioExportAcquisizione");
		else
			path = "pages/monitoraggio/".concat("stampaXlsDettaglioExportAcquisizione");

		retView = printService.printResolvedView(path, model, request, response);
		return retView;
	}

	@RequestMapping(value = "/scaricaAcquisizioneDomandeValidate.html")
	public View scaricaAcquisizioneDomandeValidate(
			Model model, 
			@RequestParam(value = "Regione", required = false ) String regione, 
			@RequestParam(value = "Provincia", required = false ) String  provincia,
			@RequestParam(value = "Comune", required = false ) String comune
			,HttpServletRequest request,HttpServletResponse response) throws Exception{

		logger.debug("scaricaAcquisizioneDomandeValidate('"+ "')...");

		String codQst = request.getParameter("codQst");
		View retView = null;

		List<Vod1002ModTabRisVal> listaDomandaValidate = risposteInCorsoService.findAllVal(codQst,"",getCodice(comune,"/"),getCodice(provincia,"/"),getCodice(regione,"/"));

		ArrayList<ExportRispostaDTO> listaOut = new ArrayList<>();
		ExportRispostaDTO rispostaDTO = null;
		Vod1002ModTabRisVal vod1002ModTabRisVal = null;

		for (Iterator<Vod1002ModTabRisVal> iterator = listaDomandaValidate.iterator(); iterator.hasNext();)
		{
			rispostaDTO = new ExportRispostaDTO();
			vod1002ModTabRisVal = (Vod1002ModTabRisVal) iterator.next();
			rispostaDTO = rdDozerMapper.map(vod1002ModTabRisVal, ExportRispostaDTO.class);
			listaOut.add(rispostaDTO);
		}

		model.addAttribute("listaDomanda", listaOut);

		String path="",inCorsoValidate=" VALIDATE ";
		model.addAttribute("inCorsoValidate", inCorsoValidate);

		if("pdf".equalsIgnoreCase(request.getParameter("formato"))) 
			path = "pages/monitoraggio/".concat("stampaPdfDettaglioExportAcquisizione");
		else 
			path = "pages/monitoraggio/".concat("stampaXlsDettaglioExportAcquisizione");

		retView = printService.printResolvedView(path, model, request, response);

		return retView;
	}

	
	@RequestMapping(produces=MediaType.APPLICATION_JSON_VALUE,value="/tabellaEsportaAcquisizioneInCorso.json",method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Map<String, Object> tabellaEsportaAcquisizioneInCorso(Model model, HttpServletRequest req, HttpServletResponse response) throws Exception {

		logger.debug("tabellaEsportaAcquisizioneInCorso.html");

		RilevazioneDTO rilevazioneDTO = gestioneRilevazioneService.loadRilevazioneAttiva();
		ArrayList<ExportRispostaDTO> listaOut = new ArrayList<>();
		Integer countListaDomandaInCorso = 0;
				
		if (rilevazioneDTO != null) {
			logger.debug("rilevazione attiva : " + rilevazioneDTO.getId());
			model.addAttribute("rilevazione", DtoFactory.fromDtoToForm(rilevazioneDTO));
			String codMec = req.getParameter("codMec");
			String regioned = req.getParameter("regioneEs");		
			String provinciad = req.getParameter("provinciaEs");			
			String comuned = req.getParameter("comuneEs");		
			String codQst = req.getParameter("codQst");
			model.addAttribute("regioneR", regioned);
			model.addAttribute("provinciaR", provinciad);
			model.addAttribute("comuneR", comuned);
			model.addAttribute("codMec", codMec);
			model.addAttribute("codQst", codQst);
			
			Integer pageSize=new Integer(req.getParameter("length"));
			Integer pageNumber=new Integer(req.getParameter("start"));

			List<Vod1001ModTabRis> listaDomandaInCorso = risposteInCorsoService.findAllPaged(codQst,"",getCodice(comuned,"/"),getCodice(provinciad,"/"),getCodice(regioned,"/"),pageNumber,pageSize);
			countListaDomandaInCorso = risposteInCorsoService.countListDatiInCorso(codQst,"",getCodice(comuned,"/"),getCodice(provinciad,"/"),getCodice(regioned,"/"));
			
			ExportRispostaDTO rispostaDTO = null;
			Vod1001ModTabRis vod1001ModTabRis = null;
			for (Iterator<Vod1001ModTabRis> iterator = listaDomandaInCorso.iterator(); iterator.hasNext();) {
				rispostaDTO = new ExportRispostaDTO();
				vod1001ModTabRis = (Vod1001ModTabRis) iterator.next();
				rispostaDTO = rdDozerMapper.map(vod1001ModTabRis, ExportRispostaDTO.class);
				listaOut.add(rispostaDTO);
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("aaData",getJSONForUser(listaOut));
		map.put("iTotalRecords",countListaDomandaInCorso);
		map.put("iTotalDisplayRecords",countListaDomandaInCorso);
		map.put("sEcho",req.getParameter("sEcho"));
		 	
		return   map;
	}

	@RequestMapping(produces=MediaType.APPLICATION_JSON_VALUE,value="/tabellaEsportaAcquisizioneValidati.json",method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Map<String, Object> tabellaEsportaAcquisizioneValidati(Model model, HttpServletRequest req, HttpServletResponse response) throws Exception {

		logger.debug("tabellaEsportaAcquisizioneValidati.html");

		RilevazioneDTO rilevazioneDTO = gestioneRilevazioneService.loadRilevazioneAttiva();
		ArrayList<ExportRispostaDTO> listaOut = new ArrayList<>();
		Integer countListaDomandaValidati=0;
		
		if (rilevazioneDTO != null) {
			logger.debug("rilevazione attiva : " + rilevazioneDTO.getId());
			model.addAttribute("rilevazione", DtoFactory.fromDtoToForm(rilevazioneDTO));
			String codMec = req.getParameter("codMec");
			String regioned = req.getParameter("regioneEs");		
			String provinciad = req.getParameter("provinciaEs");			
			String comuned = req.getParameter("comuneEs");		
			String codQst = req.getParameter("codQst");
			model.addAttribute("regioneR", regioned);
			model.addAttribute("provinciaR", provinciad);
			model.addAttribute("comuneR", comuned);
			model.addAttribute("codMec", codMec);
			model.addAttribute("codQst", codQst);
			
			Integer pageSize=new Integer(req.getParameter("length"));
			Integer pageNumber=new Integer(req.getParameter("start"));

			List<Vod1002ModTabRisVal> listaDomandaValidato = risposteInCorsoService.findAllValPaged(codQst,"",getCodice(comuned,"/"),getCodice(provinciad,"/"),getCodice(regioned,"/"),pageNumber,pageSize);
			countListaDomandaValidati = risposteInCorsoService.countListDatiValidati(codQst,"",getCodice(comuned,"/"),getCodice(provinciad,"/"),getCodice(regioned,"/"));
			
			ExportRispostaDTO rispostaDTO = null;
			Vod1002ModTabRisVal vod1002ModTabRisVal = null;
			for (Iterator<Vod1002ModTabRisVal> iterator = listaDomandaValidato.iterator(); iterator.hasNext();) {
				rispostaDTO = new ExportRispostaDTO();
				vod1002ModTabRisVal = (Vod1002ModTabRisVal) iterator.next();
				rispostaDTO = rdDozerMapper.map(vod1002ModTabRisVal, ExportRispostaDTO.class);
				listaOut.add(rispostaDTO);
			}
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("aaData",getJSONForUser(listaOut));
		map.put("iTotalRecords",countListaDomandaValidati);
		map.put("iTotalDisplayRecords",countListaDomandaValidati);
		map.put("sEcho",req.getParameter("sEcho"));
		
		return  map;
	}
	
	
	private Object[] getJSONForUser(List<ExportRispostaDTO> listMonitoraggio){
		Object[] rdArray = new Object[listMonitoraggio.size()];
		int i = 0;
		for(ExportRispostaDTO monitoraggio:listMonitoraggio)
		{
			Object[] us = new String[]{monitoraggio.getCodiceScuola(),monitoraggio.getCodiceEdificio(),monitoraggio.getDescrizioneQuestionario(),
					monitoraggio.getDescrizioneSezione(),monitoraggio.getCodiceDomanda(),monitoraggio.getDescrizioneDomanda(),monitoraggio.getDescrizioneRisposta()
			}; 
			rdArray[i] = us;
			i++;            
		}
		return rdArray;
	} 

}