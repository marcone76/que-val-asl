package it.istruzione.ossscudig.validator.sezioni;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.jboss.logging.Logger;

import it.istruzione.ossscudig.model.dto.RispostaDTO;
import it.istruzione.ossscudig.validator.ISezione;
import it.istruzione.ossscudig.validator.ValidationError;
import it.istruzione.ossscudig.validator.ValidatorResponse;

public class ValidatorSezione17 extends ISezione{

	private static Logger logger = Logger.getLogger(ValidatorSezione17.class);
	
	public ValidatorResponse validate(String idSezione,List<RispostaDTO> listaRisposte) {

		logger.debug("ingresso nel validator");
        ValidatorResponse validatorResponse = new ValidatorResponse();
        validatorResponse.setSuccess(true);
        List<ValidationError> errors = new LinkedList<>();
        List<String> risposteDate = new ArrayList<String>();
    	int contatoreNumRisposte=0;
    	boolean isMainError=false;
		boolean is22 = false;

		//ciclo che si attiva dal si, per ora nascosto e fatto tutto giu

		
		
		
		for(RispostaDTO risposta:listaRisposte)
		{
			for (String oRisposte : risposta.getRisposte()) {

				if(("DOM_270").equals(risposta.getCodDmd()) && StringUtils.isNotBlank(oRisposte))
				{
					contatoreNumRisposte++;
					risposteDate.add(risposta.getCodDmd());
				}
			}
		}
		
		for(RispostaDTO risposta:listaRisposte)
		{
			for (String oRisposte : risposta.getRisposte()) {

				if(("DOM_291").equals(risposta.getCodDmd()) && StringUtils.isNotBlank(oRisposte))
				{
					contatoreNumRisposte++;
					risposteDate.add(risposta.getCodDmd());
				}
			}
		}
		
		for(RispostaDTO risposta:listaRisposte)
		{
			for (String oRisposte : risposta.getRisposte()) {

				if(("DOM_312").equals(risposta.getCodDmd()) && StringUtils.isNotBlank(oRisposte))
				{
					contatoreNumRisposte++;
					risposteDate.add(risposta.getCodDmd());
				}
			}
		}
		
		
		
		
		 for(RispostaDTO risposta:listaRisposte)
		{
		
			 
			 if("DOM_270".equals(risposta.getCodDmd())&& StringUtils.isNotBlank(risposta.getRisposte().get(0))) {
					for (int startTextId=271; startTextId<274; startTextId++) {
					 int endTextId=startTextId;
								
				if(startTextId!=0 && endTextId!=0)
				{
					if(checkInput(listaRisposte,startTextId,endTextId,errors))
					{
						isMainError=true;
					}
				}
					}
					if(isMainError)
						break;
					}
			 
		}
		 for(RispostaDTO risposta:listaRisposte)
			{
			 if("DOM_275".equals(risposta.getCodDmd())&& StringUtils.isNotBlank(risposta.getRisposte().get(0))) {
					for (int startTextId=276; startTextId<279; startTextId++) {
					 int endTextId=startTextId;
								
				if(startTextId!=0 && endTextId!=0)
				{
					if(checkInput(listaRisposte,startTextId,endTextId,errors))
					{
						isMainError=true;
					}
				}
					}
					if(isMainError)
						break;
					}
			 
			}
		 
		 for(RispostaDTO risposta:listaRisposte)
			{
			 if("DOM_280".equals(risposta.getCodDmd())&& StringUtils.isNotBlank(risposta.getRisposte().get(0))) {
					for (int startTextId=280; startTextId<284; startTextId++) {
					 int endTextId=startTextId;
								
				if(startTextId!=0 && endTextId!=0)
				{
					if(checkInput(listaRisposte,startTextId,endTextId,errors))
					{
						isMainError=true;
					}
				}
					}
					if(isMainError)
						break;
					}
			
			}
			 
			 for(RispostaDTO risposta:listaRisposte)
				{
			 if("DOM_285".equals(risposta.getCodDmd())&& StringUtils.isNotBlank(risposta.getRisposte().get(0))) {
					for (int startTextId=286; startTextId<289; startTextId++) {
					 int endTextId=startTextId;
								
				if(startTextId!=0 && endTextId!=0)
				{
					if(checkInput(listaRisposte,startTextId,endTextId,errors))
					{
						isMainError=true;
					}
				}
					}
					if(isMainError)
						break;
					}
			 
			}
			 
			 for(RispostaDTO risposta:listaRisposte)
				{
			 if("DOM_291".equals(risposta.getCodDmd())&& StringUtils.isNotBlank(risposta.getRisposte().get(0))) {
					for (int startTextId=292; startTextId<295; startTextId++) {
					 int endTextId=startTextId;
								
				if(startTextId!=0 && endTextId!=0)
				{
					if(checkInput(listaRisposte,startTextId,endTextId,errors))
					{
						isMainError=true;
					}
				}
					}
					if(isMainError)
						break;
					}
			 
			}
					
			 for(RispostaDTO risposta:listaRisposte)
				{
			 if("DOM_296".equals(risposta.getCodDmd())&& StringUtils.isNotBlank(risposta.getRisposte().get(0))) {
					for (int startTextId=297; startTextId<300; startTextId++) {
					 int endTextId=startTextId;
								
				if(startTextId!=0 && endTextId!=0)
				{
					if(checkInput(listaRisposte,startTextId,endTextId,errors))
					{
						isMainError=true;
					}
				}
					}
				
					if(isMainError)
						break;
					}
			
				}
			
			 
			 for(RispostaDTO risposta:listaRisposte)
				{
			 if("DOM_301".equals(risposta.getCodDmd())&& StringUtils.isNotBlank(risposta.getRisposte().get(0))) {
					for (int startTextId=302; startTextId<305; startTextId++) {
					 int endTextId=startTextId;
								
				if(startTextId!=0 && endTextId!=0)
				{
					if(checkInput(listaRisposte,startTextId,endTextId,errors))
					{
						isMainError=true;
					}
				}
					}
				
					if(isMainError)
						break;
					}
			 
				}
			 
			 for(RispostaDTO risposta:listaRisposte)
				{
			 if("DOM_306".equals(risposta.getCodDmd())&& StringUtils.isNotBlank(risposta.getRisposte().get(0))) {
					for (int startTextId=307; startTextId<310; startTextId++) {
					 int endTextId=startTextId;
								
				if(startTextId!=0 && endTextId!=0)
				{
					if(checkInput(listaRisposte,startTextId,endTextId,errors))
					{
						isMainError=true;
					}
				}
					}
				
					if(isMainError)
						break;
					}
			 
				}
			 
			 for(RispostaDTO risposta:listaRisposte)
				{
			 if("DOM_312".equals(risposta.getCodDmd())&& StringUtils.isNotBlank(risposta.getRisposte().get(0))) {
					for (int startTextId=313; startTextId<317; startTextId++) {
					 int endTextId=startTextId;
								
				if(startTextId!=0 && endTextId!=0)
				{
					if(checkInput(listaRisposte,startTextId,endTextId,errors))
					{
						isMainError=true;
					}
				}
					}
					if(isMainError)
						break;
				
					
					}
			 
				}
			 
			 for(RispostaDTO risposta:listaRisposte)
				{
			 if("DOM_318".equals(risposta.getCodDmd())&& StringUtils.isNotBlank(risposta.getRisposte().get(0))) {
					for (int startTextId=318; startTextId<323; startTextId++) {
					 int endTextId=startTextId;
								
				if(startTextId!=0 && endTextId!=0)
				{
					if(checkInput(listaRisposte,startTextId,endTextId,errors))
					{
						isMainError=true;
					}
				}
					}
					if(isMainError)
						break;
				
				}
				
			}
			 
			 for(RispostaDTO risposta:listaRisposte)
				{
			 if("DOM_324".equals(risposta.getCodDmd())&& StringUtils.isNotBlank(risposta.getRisposte().get(0))) {
					for (int startTextId=325; startTextId<329; startTextId++) {
					 int endTextId=startTextId;
								
				if(startTextId!=0 && endTextId!=0)
				{
					if(checkInput(listaRisposte,startTextId,endTextId,errors))
					{
						isMainError=true;
					}
				}
					}
				
					if(isMainError)
						break;
				}
			 
			}
			 
			 for(RispostaDTO risposta:listaRisposte)
				{
			 
			 if("DOM_330".equals(risposta.getCodDmd())&& StringUtils.isNotBlank(risposta.getRisposte().get(0))) {
					for (int startTextId=331; startTextId<335; startTextId++) {
					 int endTextId=startTextId;
								
				if(startTextId!=0 && endTextId!=0)
				{
					if(checkInput(listaRisposte,startTextId,endTextId,errors))
					{
						isMainError=true;
					}
				}
					}
				
					 if(isMainError)
							break;	
				}
			
			}
			 
			 
			 
			 
			 
		
			
		
		

        String[] listaStrToCheck = {"DOM_272","DOM_273","DOM_277","DOM_278","DOM_282","DOM_283","DOM_287","DOM_288",
        		"DOM_293","DOM_294","DOM_298","DOM_299","DOM_303","DOM_304","DOM_308","DOM_309","DOM_314","DOM_315",
        		"DOM_316","DOM_320","DOM_321","DOM_322","DOM_326","DOM_327","DOM_328","DOM_332","DOM_333","DOM_334"
        		        		};
        		

        for(String str:listaStrToCheck) {
        	  if (isNumeric(errors,listaRisposte, Arrays.asList(str)) == false) {
					isMainError=true;
					}
        }
        
        //Controllo Tutte risposte
    	/*if(listaRisposte.size()==0 || contatoreNumRisposte<3)
    	{
    		String[] idDmdList = {"270","291", "312"};
    		checkAllResponse(errors, risposteDate, idDmdList);
    		isMainError=true;
    	}*/
        
        if(isMainError) 
		{
			if(!errors.isEmpty()) {
				validatorResponse.setErrors(errors);
				validatorResponse.setSuccess(false);
			}
		}

        return validatorResponse;
	}

	}


