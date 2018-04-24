package it.istruzione.ossscudig.validator.sezioni;

import java.util.LinkedList;
import java.util.List;

import org.jboss.logging.Logger;

import it.istruzione.ossscudig.model.dto.RispostaDTO;
import it.istruzione.ossscudig.validator.ISezione;
import it.istruzione.ossscudig.validator.ValidationError;
import it.istruzione.ossscudig.validator.ValidatorResponse;

public class ValidatorSezione7 extends ISezione{

	private static Logger logger = Logger.getLogger(ValidatorSezione7.class);

	public ValidatorResponse validate(String idSezione, List<RispostaDTO> listaRisposte) {

		logger.debug("ingresso nel validator scheda 7");
		ValidatorResponse validatorResponse = new ValidatorResponse();
		ValidationError validationError = new ValidationError();

		boolean successRis = false;

		for (RispostaDTO olistaRisposte : listaRisposte) {

			if (olistaRisposte.getCodDmd().equals("DOM_140")) {
				successRis = true;			
		}
		 
		}
		if(!successRis ) {
		    riempiValidator(validationError, "DOM_140", "Specificare almeno un check");	
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
