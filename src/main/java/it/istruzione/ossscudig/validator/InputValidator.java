package it.istruzione.ossscudig.validator;

import java.util.List;

import it.istruzione.ossscudig.model.dto.RispostaDTO;

public interface InputValidator {
    ValidatorResponse validate(String idSezione,List<RispostaDTO> listaRisposte) throws Exception;
}
