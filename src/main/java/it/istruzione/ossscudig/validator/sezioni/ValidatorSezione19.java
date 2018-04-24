package it.istruzione.ossscudig.validator.sezioni;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.jboss.logging.Logger;

import it.istruzione.ossscudig.model.dto.RispostaDTO;
import it.istruzione.ossscudig.validator.ISezione;
import it.istruzione.ossscudig.validator.ValidationError;
import it.istruzione.ossscudig.validator.ValidatorResponse;

public class ValidatorSezione19 extends ISezione{

	private static Logger logger = Logger.getLogger(ValidatorSezione19.class);

	public ValidatorResponse validate(String idSezione, List<RispostaDTO> listaRisposte) {

		logger.debug("ingresso nel validator scheda 19");
		ValidatorResponse validatorResponse = new ValidatorResponse();
		String verifica = "";
		ValidationError validationError = new ValidationError();

		boolean successCheck = true;
		boolean successAltro = true;
		boolean successRis = true;
		boolean successRadio = false;
		boolean successRadioCheck = false;
		boolean successNo= true;
		
		if (!listaRisposte.isEmpty()) {

		for (RispostaDTO olistaRisposte : listaRisposte) {
	

			if ("DOM_366".equals(olistaRisposte.getCodDmd())) {
				successRadio=true;
				successNo= false;
				if (!"165".equals(olistaRisposte.getRisposte().get(0))) {
					break;
				}else {
					successNo= true;
				}
				
			}else if("DOM_367".equals(olistaRisposte.getCodDmd())){
				successRadioCheck=true;
					if ( olistaRisposte.getRisposte().size() > 0) {
						for (String oRisposte : olistaRisposte.getRisposte()) {
							if ("759".equals(oRisposte)) {
								successAltro = false;	
								break;
							}else {
								successAltro = true;
							}
						}	
			        }else {
			         successCheck =false;
			        }
					
			}else if(!successAltro && "DOM_368".equals(olistaRisposte.getCodDmd())){
						verifica = olistaRisposte.getRisposte().get(0);
						if (StringUtils.isBlank(verifica)) {
							successAltro = false;	
				         }else {
				        	 successCheck =true; 
				        	 successAltro = true;	
				         }
			}else if(listaRisposte.size()==2 ) {
		   
		    	 successCheck =false;
	
			}
		}
		
		}
		 
		if(successNo) {
			
			if (listaRisposte.isEmpty()) {
				riempiValidator(validationError, "DOM_366", "Inserire un valore");
				successRis=false;
			}
		
			if(!successRadio ) {
			    riempiValidator(validationError, "DOM_366", "Specificare almeno un check");	
			}
			
			if(!successCheck || (successRadio && !successRadioCheck)) {
				successRis = false;
				successAltro=true;
			    riempiValidator(validationError, "DOM_367", "Specificare almeno un check");	
			}
			else if(!successAltro  ) {
				successRis = false;
				riempiValidator(validationError, "DOM_368", "Valorizzare il campo altro");
			}
		
		
		}
		if (successRis) {
			validatorResponse.setSuccess(true);
		}
		
		
		List<ValidationError> errors = new LinkedList<>();
		errors.add(validationError);

		if (!validatorResponse.isSuccess()) {
			validatorResponse.setErrors(errors);
		}
		return validatorResponse;
	}

	public ValidationError riempiValidator(ValidationError validationError, String fieldName, String messaggi0Errore) {
		validationError.setFieldName(fieldName);
		validationError.setErrorMessage(messaggi0Errore);
		return validationError;
	}

}
