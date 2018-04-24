package it.istruzione.ossscudig.validator.sezioni;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.jboss.logging.Logger;

import it.istruzione.ossscudig.model.dto.RispostaDTO;
import it.istruzione.ossscudig.validator.ISezione;
import it.istruzione.ossscudig.validator.ValidationError;
import it.istruzione.ossscudig.validator.ValidatorResponse;

public class ValidatorSezione18 extends ISezione {

	private static Logger logger = Logger.getLogger(ValidatorSezione18.class);

	public ValidatorResponse validate(String idSezione, List<RispostaDTO> listaRisposte) {

		logger.debug("ingresso nel validator");
		ValidatorResponse validatorResponse = new ValidatorResponse();
		validatorResponse.setSuccess(true);
		List<ValidationError> errors = new LinkedList<>();
		List<String> risposteDate = new ArrayList<String>();
		int contatoreNumRisposte = 0;
		boolean isMainError = false;
		boolean isMainError1 = false;

		for (RispostaDTO risposta : listaRisposte) {
			int startTextId = 0, endTextId = 0;
			for (String oRisposte : risposta.getRisposte()) {
				if ("DOM_359".equals(risposta.getCodDmd()) && "800".equalsIgnoreCase(oRisposte)
						&& StringUtils.isNotBlank(oRisposte)) {
					// Validator text
					startTextId = 360;
					endTextId = 360;
				}
			}
			if (startTextId != 0 && endTextId != 0) {
				if (checkInput(listaRisposte, startTextId, endTextId, errors)) {
					isMainError = true;
				}
			}
			if (isMainError)
				break;
		}

		for (RispostaDTO risposta : listaRisposte) {
			int startTextId = 0, endTextId = 0;
			for (String oRisposte : risposta.getRisposte()) {
				if ("DOM_362".equals(risposta.getCodDmd()) && "823".equalsIgnoreCase(oRisposte)
						&& StringUtils.isNotBlank(oRisposte)) {
					// Validator text
					startTextId = 363;
					endTextId = 363;
				}
			}
			if (startTextId != 0 && endTextId != 0) {
				if (checkInput(listaRisposte, startTextId, endTextId, errors)) {
					isMainError = true;
				}
			}
			if (isMainError)
				break;
		}

		for (RispostaDTO risposta : listaRisposte) {
			int startTextId = 0, endTextId = 0;
			for (String oRisposte : risposta.getRisposte()) {
				if ("DOM_364".equals(risposta.getCodDmd()) && "866".equalsIgnoreCase(oRisposte)
						&& StringUtils.isNotBlank(oRisposte)) {
					// Validator text
					startTextId = 365;
					endTextId = 365;
				}
			}
			if (startTextId != 0 && endTextId != 0) {
				if (checkInput(listaRisposte, startTextId, endTextId, errors)) {
					isMainError = true;
				}
			}
			if (isMainError)
				break;
		}

		for (RispostaDTO risposta : listaRisposte) {

			for (int startTextId = 359; startTextId < 365; startTextId++) {
				if (startTextId != 360 && startTextId != 363 && startTextId != 364 && startTextId != 365) {
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

		// Controllo Tutte risposte
		if (listaRisposte.isEmpty()/* || contatoreNumRisposte<2 */) {
			String[] idDmdList = { "359", "360", "361", "362", "363" };
			checkAllResponse(errors, risposteDate, idDmdList);
			isMainError = true;
		}

		if (isMainError ) {
			if (!errors.isEmpty()) {
				validatorResponse.setErrors(errors);
				validatorResponse.setSuccess(false);
			}
		}

		return validatorResponse;
	}

	public boolean checkAltro(List<ValidationError> errors, List<RispostaDTO> listaRisposte, int startTextIdR,
			int endTextIdR, String dom, String idDom) {
		// dom= "DOM_359
		// idDom=800
		// startTextIdR es campo altro 360 endTextIdR
		boolean isMainError = false;
		for (RispostaDTO risposta : listaRisposte) {
			int startTextId = 0, endTextId = 0;
			for (String oRisposte : risposta.getRisposte()) {
				if (dom.equals(risposta.getCodDmd()) && idDom.equalsIgnoreCase(oRisposte)
						&& StringUtils.isNotBlank(oRisposte)) {
					// Validator text
					startTextId = startTextIdR;
					endTextId = startTextIdR;
				}
			}
			if (startTextId != 0 && endTextId != 0) {
				if (checkInput(listaRisposte, startTextId, endTextId, errors)) {
					isMainError = true;
				}
			}
			if (isMainError)
				break;
		}
		return isMainError;
	}
}