package it.istruzione.ossscudig.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import it.istruzione.ossscudig.model.dto.OggettoGenerico;
import it.istruzione.ossscudig.model.dto.PieDTO;


@Controller
public class StatoAcquisizioneController2  {

	private static Logger logger = Logger.getLogger(StatoAcquisizioneController2.class);
	
	@RequestMapping( produces=MediaType.APPLICATION_JSON_VALUE, value= "/datiQuestionariInCorso2.json",method = RequestMethod.GET )
	public @ResponseBody PieDTO getDatiQuestionariInCorso2(Model model, HttpServletResponse response) throws Exception {
		logger.debug("datiQuestionariInCorso2.json");

		PieDTO pie = new PieDTO();
		pie.setCompilazione(100);
		pie.setInAttesa(50);
		pie.setValidati(40);
		return pie;
	}
	
	@RequestMapping( produces=MediaType.APPLICATION_JSON_VALUE, value= "/datiQuestionariInCorso3.json",method = RequestMethod.GET )
	public @ResponseBody PieDTO getDatiQuestionariInCorso3(Model model, HttpServletResponse response) throws Exception {
		logger.debug("datiQuestionariInCorso3.json");

		PieDTO pie = new PieDTO();
		pie.setCompilazione(50);
		pie.setInAttesa(150);
		pie.setValidati(20);
		return pie;
	}
	
	
	@RequestMapping( produces=MediaType.APPLICATION_JSON_VALUE, value= "/datiQuestionariInCorso4.json",method = RequestMethod.GET )
	public @ResponseBody OggettoGenerico getDatiQuestionariInCorso4(Model model, HttpServletResponse response) throws Exception {
		logger.debug("datiQuestionariInCorso444444444444444444444444444444444444444444444444444444.json");
		OggettoGenerico obj = new OggettoGenerico();
		ArrayList<PieDTO> data = new ArrayList<>();
		
		PieDTO pie = new PieDTO();
		pie.setCompilazione(100);
		pie.setInAttesa(50);
		pie.setValidati(40);
		
		
		PieDTO pie2 = new PieDTO();
		pie2.setCompilazione(100);
		pie2.setInAttesa(50);
		pie2.setValidati(40);
		data.add(pie);
		data.add(pie2);
		
		obj.setData(data);
		
		return obj;
	}
	
	



}