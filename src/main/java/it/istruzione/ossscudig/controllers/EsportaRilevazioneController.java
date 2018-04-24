package it.istruzione.ossscudig.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dozer.DozerBeanMapper;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.istruzione.ossscudig.controllers.helper.DtoFactory;
import it.istruzione.ossscudig.controllers.util.CommonsUtility;
import it.istruzione.ossscudig.model.dto.ExportRispostaDTO;
import it.istruzione.ossscudig.model.dto.MonitoraggioDTO;
import it.istruzione.ossscudig.model.dto.RilevazioneDTO;
import it.istruzione.ossscudig.model.dto.ScuolaDTO;
import it.istruzione.ossscudig.model.entity.Vod1001ModTabRis;
import it.istruzione.ossscudig.model.entity.Vod1002ModTabRisVal;
import it.istruzione.ossscudig.services.AnagrafeScuolaService;
import it.istruzione.ossscudig.services.GestioneRilevazioneService;
import it.istruzione.ossscudig.services.MonitoraggioService;
import it.istruzione.ossscudig.services.RisposteInCorsoService;

@Controller
public class EsportaRilevazioneController extends BaseController {

	private static Logger logger = Logger.getLogger(EsportaRilevazioneController.class);

	@Autowired
	private GestioneRilevazioneService gestioneRilevazioneService;

	@Autowired
	private MonitoraggioService monitoraggioService;
	
	@Autowired
	private RisposteInCorsoService risposteInCorsoService;
	
	@Autowired
	private AnagrafeScuolaService anagrafeScuolaService;
	
	@Autowired
	private DozerBeanMapper rdDozerMapper;
	
	@RequestMapping(value = "/esportaRilevazione.html", method = { RequestMethod.GET, RequestMethod.POST })
	public String esportaRilevazione(Model model, HttpServletRequest request) throws Exception {
		logger.debug("esportaRilevazione.html");
		RilevazioneDTO rilevazioneDTO = gestioneRilevazioneService.loadRilevazioneAttiva();
		
		if (rilevazioneDTO != null)
		{
			logger.debug("rilevazione attiva : " + rilevazioneDTO.getId());
			model.addAttribute("rilevazione", DtoFactory.fromDtoToForm(rilevazioneDTO));

			/** VERIFICA SCUOLA: COD_SCU_UT_PRI e COD_FOR_SCU_APP **/
			ScuolaDTO scuola = anagrafeScuolaService.getScuola(getContestoCorrente());
			logger.error("Scuola loggata: Codice forte-"+scuola.getCodiceForte()+"; Codice meccanografico-"+scuola.getCodiceMeccanografico() +"; Codice Ist.Principale-"+scuola.getCodiceMeccanograficoIstitutoPrincipale());
			
			String codIstPri ="";
			if(!getContestoCorrente().equalsIgnoreCase(scuola.getCodiceMeccanograficoIstitutoPrincipale()))
				codIstPri=scuola.getCodiceMeccanograficoIstitutoPrincipale();
			else
				codIstPri=getContestoCorrente();
			
			ArrayList<MonitoraggioDTO>  questionari =  monitoraggioService.getElencoQuestionariForScuola(rilevazioneDTO.getId().toString(), codIstPri,  String.valueOf( CommonsUtility.getAnnoScolasticoCorrente()));

			model.addAttribute("questionari", questionari);
		}

		return "pages/acquisizioneRilevazione/esportaRilevazione";
	}

	@RequestMapping(value = "/downloadRilevazioneInCorso",  method = { RequestMethod.GET, RequestMethod.POST })
	public String  downloadRilevazioneInCorso(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.debug("downloadRilevazioneInCorso");

		RilevazioneDTO rilevazioneDTO = gestioneRilevazioneService.loadRilevazioneAttiva();
		if (rilevazioneDTO != null) {
			logger.debug("rilevazione attiva : " + rilevazioneDTO.getId());
			model.addAttribute("rilevazione", DtoFactory.fromDtoToForm(rilevazioneDTO));
		}
		    Map<String, String[]> mappaParametri = request.getParameterMap();
			String codScu = mappaParametri.get("codScu")[0];
			String codQuest = mappaParametri.get("codQuest")[0];
			
			List<Vod1001ModTabRis> listaDomandaInCorso = risposteInCorsoService.findAll(codQuest,codScu,"","","");//setto com prov e reg a null perchè non usati lato ds scuola
			
			ArrayList<ExportRispostaDTO> listaOut = new ArrayList<>();
			ExportRispostaDTO rispostaDTO = null;
			Vod1001ModTabRis vod1001ModTabRis = null;
			for (Iterator<Vod1001ModTabRis> iterator = listaDomandaInCorso.iterator(); iterator.hasNext();) {
				rispostaDTO = new ExportRispostaDTO();
				vod1001ModTabRis = (Vod1001ModTabRis) iterator.next();
				rispostaDTO = rdDozerMapper.map(vod1001ModTabRis, ExportRispostaDTO.class);
				listaOut.add(rispostaDTO);
			}
			
			model.addAttribute("listaDomandaInCorso", listaOut);	
			
	    return "pages/acquisizioneRilevazione/dettaglioEsportaRilevazioneInCorso";
	}
	
	@RequestMapping(value = "/downloadRilevazioneValidato",  method = { RequestMethod.GET, RequestMethod.POST })
	public String  downloadRilevazioneValidato(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.debug("downloadRilevazione");
		Map<String, String[]> mappaParametri = request.getParameterMap();
		String codScu = mappaParametri.get("codScu")[0];
		String codQuest = mappaParametri.get("codQuest")[0];
		RilevazioneDTO rilevazioneDTO = gestioneRilevazioneService.loadRilevazioneAttiva();
		if (rilevazioneDTO != null) {
			logger.debug("rilevazione attiva : " + rilevazioneDTO.getId());
			model.addAttribute("rilevazione", DtoFactory.fromDtoToForm(rilevazioneDTO));
		}
			
			List<Vod1002ModTabRisVal> listaDomandaInCorso = risposteInCorsoService.findAllVal(codQuest,codScu,"","","");
			ArrayList<ExportRispostaDTO> listaOut = new ArrayList<>();
			ExportRispostaDTO rispostaDTO = null;
			Vod1002ModTabRisVal vod1002ModTabRisVal = null;
			for (Iterator<Vod1002ModTabRisVal> iterator = listaDomandaInCorso.iterator(); iterator.hasNext();) {
				rispostaDTO = new ExportRispostaDTO();
				vod1002ModTabRisVal = (Vod1002ModTabRisVal) iterator.next();
				rispostaDTO = rdDozerMapper.map(vod1002ModTabRisVal, ExportRispostaDTO.class);
				listaOut.add(rispostaDTO);
			}
			
			model.addAttribute("listaDomandaValidato", listaOut);	
			
	    return "pages/acquisizioneRilevazione/dettaglioEsportaRilevazioneValidato";
	}

}

