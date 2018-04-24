package it.istruzione.ossscudig.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import it.istruzione.ossscudig.controllers.helper.DtoFactory;
import it.istruzione.ossscudig.model.dto.LabelValueDTO;
import it.istruzione.ossscudig.model.dto.PieDTO;
import it.istruzione.ossscudig.model.dto.RilevazioneDTO;
import it.istruzione.ossscudig.model.dto.StatoAcquisizioneQuestionarioInCorsoDTO;
import it.istruzione.ossscudig.model.dto.StatoAcquisizioneRilevazioneValidataDTO;
import it.istruzione.ossscudig.services.GestioneRilevazioneService;
import it.istruzione.ossscudig.services.MonitoraggioService;

@Controller
public class ServiziGenericiController extends BaseController {

	private static Logger logger = Logger.getLogger(ServiziGenericiController.class);
	@Autowired
	private MonitoraggioService monitoraggioServiceImpl;
	@Autowired
	private GestioneRilevazioneService gestioneRilevazioneService;
	@Autowired
	private MonitoraggioService monitoraggioService;
	
	@RequestMapping(value = "/aggiornaListaProvince.json", method = RequestMethod.POST)
	public  @ResponseBody Map<String,LinkedList<LabelValueDTO>>  aggiornaListaProvince(Model model, String codRegione){		 
		logger.info("AggiornaListaProvince()...");

		LinkedList<LabelValueDTO> province = monitoraggioServiceImpl.getProvince(codRegione.trim());
		HashMap<String, LinkedList<LabelValueDTO>> modelMap = new HashMap<String,LinkedList<LabelValueDTO>>();
		modelMap.put("province", province);

		return modelMap;
	}
	
	@RequestMapping(value = "/aggiornaListaComuni.json", method = RequestMethod.POST)
	public  @ResponseBody Map<String,LinkedList<LabelValueDTO>>  aggiornaListaComuni(Model model, String codProvincia){		 
		logger.info("AggiornaListacomuni()...");

		LinkedList<LabelValueDTO> comuni = monitoraggioServiceImpl.getComuni(codProvincia.trim());
		HashMap<String, LinkedList<LabelValueDTO>> modelMap = new HashMap<String,LinkedList<LabelValueDTO>>();
		modelMap.put("comuni", comuni);

		return modelMap;
	}

	@RequestMapping( produces=MediaType.APPLICATION_JSON_VALUE, value= "/getDatiTortaQuestionariInCorso.json",method = RequestMethod.GET )
	public @ResponseBody PieDTO getDatiTortaQuestionariInCorso(Model model, HttpServletResponse response, HttpServletRequest req) throws Exception {
		logger.debug("getDatiTortaQuestionariInCorso.json");

		RilevazioneDTO dto = gestioneRilevazioneService.loadRilevazioneAttiva();
		model.addAttribute("rilevazione", DtoFactory.fromDtoToForm(dto));
		
		String regione = req.getParameter("regione");
		String provincia = req.getParameter("provincia");
		String comune = req.getParameter("comune");
		String cicliScolastici = req.getParameter("cicloScolastico");
		
		logger.debug("---------------- > regione : "+regione);
		logger.debug("---------------- > provincia : "+provincia);
		logger.debug("---------------- > comune : "+comune);
		logger.debug("---------------- > cicliScolastici : "+cicliScolastici);
		
		StatoAcquisizioneQuestionarioInCorsoDTO inCorso =   monitoraggioService.getStatoAcquisizioneQuestionarioInCorso(dto.getId(), getCodice(regione,"/"),getCodice(provincia,"/"),getCodice(comune,"/"), cicliScolastici!=null ? cicliScolastici : "");//codiceRegione, codiceProvincia, codiceComune
		
		
		
		PieDTO pie = new PieDTO();
		pie.setCompilazione(inCorso.getNumeroInCompilazione());
		pie.setInAttesa(inCorso.getNumeroNonCompilati());
		pie.setValidati(inCorso.getNumeroCompilati());
		return pie;
	}
	
	
	@RequestMapping( produces=MediaType.APPLICATION_JSON_VALUE, value= "/getDatiTortaQuestionariRilevazioniValidate.json",method = RequestMethod.GET )
	public @ResponseBody PieDTO getDatiTortaQuestionariRilevazioniValidate(Model model, HttpServletResponse response, HttpServletRequest req) throws Exception {
		logger.debug("getDatiTortaQuestionariRilevazioniValidate.json");
		RilevazioneDTO dto = gestioneRilevazioneService.loadRilevazioneAttiva();
		model.addAttribute("rilevazione", DtoFactory.fromDtoToForm(dto));
		
		String regione = req.getParameter("regione");
		String provincia = req.getParameter("provincia");
		String comune = req.getParameter("comune");
		String cicliScolastici = req.getParameter("cicloScolastico");
		
		logger.debug("---------------- > regione : "+regione);
		logger.debug("---------------- > provincia : "+provincia);
		logger.debug("---------------- > comune : "+comune);
		logger.debug("---------------- > cicliScolastici : "+cicliScolastici);
		
		StatoAcquisizioneRilevazioneValidataDTO valid =   monitoraggioService.getStatoAcquisizioneRilevazioneValidata(dto.getId(),getCodice(regione,"/"),getCodice(provincia,"/"),getCodice(comune,"/"), cicliScolastici!=null ? cicliScolastici : "");
		
		
		PieDTO pie = new PieDTO();
		pie.setInAttesa(valid.getNumeroNonValidati());
		pie.setValidati(valid.getNumeroValidati());
		return pie;
	}
	
	
	
	@RequestMapping( produces=MediaType.APPLICATION_JSON_VALUE, value= "/getDatiAndamentoAcquisizione.json",method = RequestMethod.GET )
	public @ResponseBody ArrayList<LabelValueDTO> getDatiAndamentoAcquisizione(Model model, HttpServletResponse response, HttpServletRequest req) throws Exception {
		logger.debug("getDatiAndamentoAcquisizione.json");

		RilevazioneDTO dto = gestioneRilevazioneService.loadRilevazioneAttiva();
		model.addAttribute("rilevazione", DtoFactory.fromDtoToForm(dto));
		
		String regione = req.getParameter("regione");
		String provincia = req.getParameter("provincia");
		String comune = req.getParameter("comune");
		String data = req.getParameter("from");
		String cicliScolastici = req.getParameter("cicliScolastici");

		
		logger.debug("---------------- > regione : "+regione);
		logger.debug("---------------- > provincia : "+provincia);
		logger.debug("---------------- > comune : "+comune);
		logger.debug("---------------- > cicliScolastici : "+cicliScolastici);
		logger.debug("---------------- > data : "+data);

		
		ArrayList<LabelValueDTO> andamentoAcquisizione = new ArrayList<LabelValueDTO>();
		//05042019
		if (data != null) {
		String [] res = data.split("/");
		String dataString=null;
		if(res[1].length()==1) {
			res[1]="0"+res[1];}
		if(res[0].length()==1) {
			res[0]="0"+res[0];}
		
		 dataString = res[0]+res[1]+res[2];	
	
		andamentoAcquisizione =monitoraggioServiceImpl.getAndamento(dataString,getCodice(regione,"/"),getCodice(provincia,"/"),getCodice(comune,"/"),cicliScolastici!=null ? cicliScolastici : "");

	}
		else {
			DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
			Date date = new Date();
		andamentoAcquisizione =monitoraggioServiceImpl.getAndamento(dateFormat.format(date),getCodice(regione,"/"),getCodice(provincia,"/"),getCodice(comune,"/"),cicliScolastici);
		}
				/*LabelValueDTO la = new LabelValueDTO();
				LabelValueDTO lb = new LabelValueDTO();

				la.setLabel("10");
				la.setValue("24");
				lb.setLabel("1");
				lb.setValue("11");
		
				andamentoAcquisizione.add(la);
				andamentoAcquisizione.add(lb);
				*/
				

				
		return andamentoAcquisizione;
	}
	
}