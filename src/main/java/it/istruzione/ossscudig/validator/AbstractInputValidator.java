package it.istruzione.ossscudig.validator;

import java.util.LinkedList;
import java.util.List;

import it.istruzione.ossscudig.model.dto.RispostaDTO;

public abstract class AbstractInputValidator implements InputValidator {

	ValidatorResponse validatorResponse = new ValidatorResponse();
	List<ValidationError> errors = new LinkedList<>();
    @Override
    public ValidatorResponse validate(String idSezione,List<RispostaDTO> listaRisposte) throws Exception {
    	
    	if(idSezione != null && !idSezione.equals("") /*&& listaRisposte.size()>0*/)
            return validateInternal(idSezione, listaRisposte);
    	
        //ValidatorResponse validatorResponse = new ValidatorResponse();
        validatorResponse.setSuccess(true);
        return validatorResponse;
    }

    protected abstract ValidatorResponse validateInternal(String idSezione,List<RispostaDTO> listaRisposte) throws Exception;

    protected abstract long getIdRilevazione();
    public void aggiungiErrore(List<ValidationError> errors, String campo, String messaggio) {
		ValidationError validationError = new ValidationError();
		validationError.setErrorMessage(messaggio);
		validationError.setFieldName(campo);
		errors.add(validationError);
	}
}
