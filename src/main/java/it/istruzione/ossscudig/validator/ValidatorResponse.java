package it.istruzione.ossscudig.validator;

import java.util.List;

public class ValidatorResponse {
    private boolean success;
    private List<ValidationError> errors;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<ValidationError> getErrors() {
        return errors;
    }

    public void setErrors(List<ValidationError> errors) {
        this.errors = errors;
    }
}
