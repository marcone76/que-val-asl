package it.istruzione.ossscudig.validator.sezioni;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.jboss.logging.Logger;

import it.istruzione.ossscudig.model.dto.RispostaDTO;
import it.istruzione.ossscudig.validator.ISezione;
import it.istruzione.ossscudig.validator.ValidationError;
import it.istruzione.ossscudig.validator.ValidatorResponse;

public class ValidatorSezione12 extends ISezione{

	private static Logger logger = Logger.getLogger(ValidatorSezione12.class);
	
	public ValidatorResponse validate(String idSezione,List<RispostaDTO> listaRisposte) {

		logger.debug("ingresso nel validator");
        ValidatorResponse validatorResponse = new ValidatorResponse();
        validatorResponse.setSuccess(true);
        List<ValidationError> errors = new LinkedList<>();
        List<String> risposteDate = new ArrayList<String>();
    	int contatoreNumRisposte=0;
    	
        for(int i=0;i<listaRisposte.size();i++)
        {
            if("DOM_177".equals(listaRisposte.get(i).getCodDmd()))
            {
            	contatoreNumRisposte++;
            	risposteDate.add(listaRisposte.get(i).getCodDmd());
            	
            	if("165".equalsIgnoreCase(listaRisposte.get(i).getRisposte().get(0)))
            	{
            		int startId=178,endId=178;
            		checkInput(listaRisposte,startId,endId,errors);
            	}
            }
            if("DOM_180".equals(listaRisposte.get(i).getCodDmd()))
            {
            	contatoreNumRisposte++;
            	risposteDate.add(listaRisposte.get(i).getCodDmd());
            	
            	if("712".equalsIgnoreCase(listaRisposte.get(i).getRisposte().get(0))|| "713".equalsIgnoreCase(listaRisposte.get(i).getRisposte().get(0)))
            	{
            		int startId=181, endId=181;
            		checkInput(listaRisposte,startId,endId,errors);
            	}
            }
            if(contatoreNumRisposte<2 && i==listaRisposte.size()-1)
            {
            	String[] idDmdList = {"177","180"};
            	checkAllResponse(errors, risposteDate, idDmdList);
            }
        }
        
        if(listaRisposte.size()==0 || contatoreNumRisposte<2)
        {
        	String[] idDmdList = {"177","180"};
        	checkAllResponse(errors, risposteDate, idDmdList);
        }
        
        if (!errors.isEmpty()) {
        	validatorResponse.setErrors(errors);
			validatorResponse.setSuccess(false);
        }

        return validatorResponse;
	}


}