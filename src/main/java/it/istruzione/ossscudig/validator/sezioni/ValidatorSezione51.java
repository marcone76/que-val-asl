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

public class ValidatorSezione51 extends ISezione {

	private static Logger logger = Logger.getLogger(ValidatorSezione51.class);

	public ValidatorResponse validate(String idSezione, List<RispostaDTO> listaRisposte) {

		logger.debug("ingresso nel validator");
		ValidatorResponse validatorResponse = new ValidatorResponse();
		validatorResponse.setSuccess(true);
		List<ValidationError> errors = new LinkedList<>();
		List<String> risposteDate = new ArrayList<String>();
		int contatoreNumRisposte = 0;
		boolean isMainError = false;

		for (RispostaDTO risposta : listaRisposte) {

			for (int startTextId = 1013; startTextId < 1020; startTextId++) {
				if (startTextId != 1014) {
				int endTextId = startTextId;
				if (startTextId != 0 && endTextId != 0) {
					if (checkInput(listaRisposte, startTextId, endTextId, errors)) {
						isMainError = true;
					}
				}
				}
			}

			if (isMainError)
				break;
		}
		
		
		String[] listaStrToCheck = {"DOM_1015","DOM_1016","DOM_1017","DOM_1018","DOM_1019"};
        		

        for(String str:listaStrToCheck) {
        	  if (isNumeric(errors,listaRisposte, Arrays.asList(str)) == false) {
					isMainError=true;
					}
        }

		// Controllo Tutte risposte
		if (listaRisposte.isEmpty()) {
			String[] idDmdList = { "1013", "1014", "1015", "1016", "1017", "1018", "1019", "1020" };
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