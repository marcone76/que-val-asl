package it.istruzione.ossscudig.validator.sezioni;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.jboss.logging.Logger;

import it.istruzione.ossscudig.model.dto.RispostaDTO;
import it.istruzione.ossscudig.validator.ISezione;
import it.istruzione.ossscudig.validator.ValidationError;
import it.istruzione.ossscudig.validator.ValidatorResponse;

public class ValidatorSezione50 extends ISezione {

	private static Logger logger = Logger.getLogger(ValidatorSezione50.class);

	public ValidatorResponse validate(String idSezione, List<RispostaDTO> listaRisposte) {
		
		
		
		logger.debug("ingresso nel validator");
		ValidatorResponse validatorResponse = new ValidatorResponse();
		validatorResponse.setSuccess(true);
		List<ValidationError> errors = new LinkedList<>();
		List<String> risposteDate = new ArrayList<String>();
        int contatoreNumRisposte=0;
        
		for(int i=0;i<listaRisposte.size();i++)
		{
			if("DOM_1010".equals(listaRisposte.get(i).getCodDmd()))
			{
				
				risposteDate.add(listaRisposte.get(i).getCodDmd());

				if("165".equalsIgnoreCase(listaRisposte.get(i).getRisposte().get(0)))
				{
					int startId=1011,endId=1011;
					List<String> listaStrToCheck = new ArrayList<String>();
					listaStrToCheck.add("DOM_1011");
					
					checkInput(listaRisposte,startId,endId,errors);
				}
			}
			
			
			if("DOM_1012".equals(listaRisposte.get(i).getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(listaRisposte.get(i).getCodDmd());
			}
			
			
		}
		
		if(listaRisposte.size()==0 || contatoreNumRisposte<1)
		{
			String[] idDmdList = {"1010","1012"};
			checkAllResponse(errors, risposteDate, idDmdList);
			
		}

		if(!errors.isEmpty()) {
			validatorResponse.setErrors(errors);
			validatorResponse.setSuccess(false);
		}

		return validatorResponse;
	}
	
		

}