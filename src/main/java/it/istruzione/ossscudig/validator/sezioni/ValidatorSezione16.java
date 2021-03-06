package it.istruzione.ossscudig.validator.sezioni;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.jboss.logging.Logger;

import it.istruzione.ossscudig.model.dto.RispostaDTO;
import it.istruzione.ossscudig.validator.ISezione;
import it.istruzione.ossscudig.validator.ValidationError;
import it.istruzione.ossscudig.validator.ValidatorResponse;

public class ValidatorSezione16 extends ISezione{

	private static Logger logger = Logger.getLogger(ValidatorSezione16.class);

	public ValidatorResponse validate(String idSezione,List<RispostaDTO> listaRisposte) {

		logger.debug("ingresso nel validator");
		ValidatorResponse validatorResponse = new ValidatorResponse();
		validatorResponse.setSuccess(true);
		List<ValidationError> errors = new LinkedList<>();
		List<String> risposteDate = new ArrayList<String>();
		int contatoreNumRisposte=0;
		boolean isMainError=false;
		boolean is131 = false;
		boolean is133=false;

		
		
		for(RispostaDTO risposta:listaRisposte)
		{
			
			
				int startTextId=0,endTextId=0,startId=0,endId=0;

				for (String oRisposte : risposta.getRisposte()) {

					if("DOM_264".equals(risposta.getCodDmd()) && "32".equalsIgnoreCase(oRisposte)
							&& StringUtils.isNotBlank(oRisposte)) {
						//Validator text type 13.3.1 
						startTextId=265; endTextId=265;
					}		
					}				
				if(startTextId!=0 && endTextId!=0)
				{
					if(checkInput(listaRisposte,startTextId,endTextId,errors))
					{
						isMainError=true;
					}
				}


			if(isMainError)
				break;
		}
		
		
		for(RispostaDTO risposta:listaRisposte)
		{
    		//Risposta 2.2
			if("DOM_266".equals(risposta.getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(risposta.getCodDmd());

				//Validator radio type SI/NO 2.2
				if("165".equalsIgnoreCase(risposta.getRisposte().get(0))){

					
					for (int startTextId=267; startTextId<268; startTextId++) {
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
			}
		
    	
			
			
	
		for(int i=0;i<listaRisposte.size();i++)
		{
				if(("DOM_264").equals(listaRisposte.get(i).getCodDmd()))
				{
					contatoreNumRisposte++;
					risposteDate.add(listaRisposte.get(i).getCodDmd());
				}
			
		}
		
	//Controllo Tutte risposte
	if(listaRisposte.size()==0 || contatoreNumRisposte<2)
	{
		String[] idDmdList = {"264","266","267"};
		checkAllResponse(errors, risposteDate, idDmdList);
		isMainError=true;
	}



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