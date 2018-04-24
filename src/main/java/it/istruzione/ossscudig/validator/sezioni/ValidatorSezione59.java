package it.istruzione.ossscudig.validator.sezioni;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.jboss.logging.Logger;

import it.istruzione.ossscudig.model.dto.RispostaDTO;
import it.istruzione.ossscudig.validator.ISezione;
import it.istruzione.ossscudig.validator.ValidationError;
import it.istruzione.ossscudig.validator.ValidatorResponse;

public class ValidatorSezione59 extends ISezione {

	private static Logger logger = Logger.getLogger(ValidatorSezione59.class);

	public ValidatorResponse validate(String idSezione, List<RispostaDTO> listaRisposte) {

		logger.debug("ingresso nel validator");
		ValidatorResponse validatorResponse = new ValidatorResponse();
		validatorResponse.setSuccess(true);
		List<ValidationError> errors = new LinkedList<>();
		List<String> risposteDate = new ArrayList<String>();
		int contatoreNumRisposte = 0;
		boolean isMainError = false;

		for (RispostaDTO risposta : listaRisposte) {

			for (int startTextId = 1125; startTextId < 1126; startTextId++) {
				
				int endTextId = startTextId;
				if (startTextId != 0 && endTextId != 0) {
					if (checkInput(listaRisposte, startTextId, endTextId, errors)) {
						isMainError = true;
					}
				}
				
			}

			if (isMainError)
				break;
		}
		
		
		

		// Controllo Tutte risposte
		if (listaRisposte.isEmpty()) {
			String[] idDmdList = { "1125", "1126" };
			checkAllResponse(errors, risposteDate, idDmdList);
			isMainError = true;
		}

		if (isMainError) {
			if (!errors.isEmpty()) {
				validatorResponse.setErrors(errors);
				validatorResponse.setSuccess(false);
			}
		}

		return validatorResponse;

	}
}