package it.istruzione.ossscudig.validator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

import it.istruzione.ossscudig.model.dto.RispostaDTO;

public class RegExpInputValidator extends AbstractInputValidator {

    @Override
    protected long getIdRilevazione() {
        return 0;
    }

    @Override
    public ValidatorResponse validateInternal(String idSezione,List<RispostaDTO> listaRisposte) {

        String errorMessage = "Errore di validazione campo";
        
        validatorResponse.setSuccess(true);
        
        for (Iterator iterator = listaRisposte.iterator(); iterator.hasNext();) {
			RispostaDTO rispostaDTO = (RispostaDTO) iterator.next();
			if(rispostaDTO.getRegEx()!=null) {
				if(rispostaDTO.getRisposte().size()==1){
					if(!Pattern.matches(rispostaDTO.getRegEx(), rispostaDTO.getRisposte().get(0))){
						aggiungiErrore(errors, rispostaDTO.getCodDmd(), rispostaDTO.getMessaggioUtente());
						validatorResponse.setErrors(errors);
					}
				}
			}
		}

        return validatorResponse;
    }
}
