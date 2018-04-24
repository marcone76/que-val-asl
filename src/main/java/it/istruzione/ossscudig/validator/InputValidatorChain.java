package it.istruzione.ossscudig.validator;


import java.util.Iterator;
import java.util.List;

import it.istruzione.ossscudig.model.dto.RispostaDTO;

public class InputValidatorChain implements InputValidator {
    private List<InputValidator> validators;

    @Override
    public ValidatorResponse validate(String idSezione,List<RispostaDTO> listaRisposte) throws Exception {

        ValidatorResponse validatorResponse = new ValidatorResponse();
        validatorResponse.setSuccess(true);

        for (Iterator<InputValidator> iter = validators.iterator(); iter.hasNext() && validatorResponse.isSuccess();) {
            InputValidator validator = iter.next();
            validatorResponse = validator.validate(idSezione, listaRisposte);
        }
        return validatorResponse;
    }

    public void setValidators(List<InputValidator> validators) {
        this.validators = validators;
    }
}
