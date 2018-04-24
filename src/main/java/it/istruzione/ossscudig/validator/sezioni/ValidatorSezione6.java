package it.istruzione.ossscudig.validator.sezioni;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.jboss.logging.Logger;

import it.istruzione.ossscudig.model.dto.RispostaDTO;
import it.istruzione.ossscudig.validator.ISezione;
import it.istruzione.ossscudig.validator.ValidationError;
import it.istruzione.ossscudig.validator.ValidatorResponse;

public class ValidatorSezione6 extends ISezione {
	private static Logger logger = Logger.getLogger(ValidatorSezione6.class);

	public ValidatorResponse validate(String idSezione, List<RispostaDTO> listaRisposte) {
		// in questo validator mancano i Dom 122 125 131 che devono essere esclusi
		logger.debug("ingresso nel validator 6");
		ValidatorResponse validatorResponse = new ValidatorResponse();
		validatorResponse.setSuccess(true);
		List<ValidationError> errors = new LinkedList<>();
		boolean isMainError = false;
		String plesso = "_COD_EDI_";
		List<String> risposteDate = new ArrayList<String>();
		List<String> listaPlessi = checkInputPlessi(listaRisposte);
		int contatoreNumRisposte=0;

		for (RispostaDTO risposta : listaRisposte) {
			int startTextId = 0, endTextId = 0;
			for (String oRisposte : risposta.getRisposte()) {
				if ("DOM_108".equals(risposta.getCodDmd()) && "165".equalsIgnoreCase(oRisposte)
						&& StringUtils.isNotBlank(oRisposte)) {
					startTextId = 112;
					endTextId = 119;
				}
			}
			if (startTextId != 0 && endTextId != 0) {
                 if (checkInput(listaRisposte, startTextId, endTextId, errors)) {
                	
						isMainError = true;
					}
				//}
			}
			if (isMainError)
				break;
		}
		
		for (RispostaDTO risposta : listaRisposte) {
			int startTextId = 0, endTextId = 0;
			for (String oRisposte : risposta.getRisposte()) {
				if ("DOM_108".equals(risposta.getCodDmd()) && "165".equalsIgnoreCase(oRisposte)
						&& StringUtils.isNotBlank(oRisposte)) {
					startTextId = 110;
					endTextId = 110;
				}
			}
			if (startTextId != 0 && endTextId != 0) {
                 if (checkInput(listaRisposte, startTextId, endTextId, errors)) {
                	
						isMainError = true;
					}
				//}
			}
			if (isMainError)
				break;
		}

		for (RispostaDTO risposta : listaRisposte) {
			int startTextId = 0, endTextId = 0;
			for (String oRisposte : risposta.getRisposte()) {
				if ("DOM_121".equals(risposta.getCodDmd()) && "733".equalsIgnoreCase(oRisposte)
						&& StringUtils.isNotBlank(oRisposte)) {
					startTextId = 124;
					endTextId = 124;
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

		for (String str : listaPlessi) {

			for (RispostaDTO risposta : listaRisposte) {
				// Risposta 2.2
				if (("DOM_1261" + plesso + str).equals(risposta.getCodDmd())) {
					contatoreNumRisposte++;
					risposteDate.add(risposta.getCodDmd());

					// Validator radio type SI/NO 2.2
					if ("165".equalsIgnoreCase(risposta.getRisposte().get(0))) {

						for (int startTextId = 127; startTextId < 131; startTextId++) {
							if (startTextId != 129) {
								int endTextId = startTextId;
								if (startTextId != 0 && endTextId != 0) {
									if (checkInputPlesso(listaRisposte, startTextId, endTextId, str, errors)) {
										isMainError = true;
									}
								}
							}
						}

						// MULTIPLE CHECKBOX DOM_36
						for (int i = 0; i < listaRisposte.size(); i++) {
							if (("DOM_128" + plesso + str).equals(listaRisposte.get(i).getCodDmd())) {

								risposteDate.add(listaRisposte.get(i).getCodDmd());
							}

						}

						for (RispostaDTO rispostaA : listaRisposte) {
							int startTextId = 0, endTextId = 0;
							for (String oRisposte : rispostaA.getRisposte()) {
								if ("DOM_121".equals(rispostaA.getCodDmd()) && "733".equalsIgnoreCase(oRisposte)
										&& StringUtils.isNotBlank(oRisposte)) {
									startTextId = 124;
									endTextId = 124;
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

						// Controllo Tutte risposte
						if (listaRisposte.size() == 0 /*||contatoreNumRisposte<listaPlessi.size()*/) {
							// RADIO BUTTON INIZIALE _34
							String[] idDmdList = { "DOM_1261" + plesso + str };
							checkAllResponseByIdNotName(errors, risposteDate, idDmdList);
							isMainError = true;
						}

						if (isMainError)
							break;

					}
				}
				
			}

			for (RispostaDTO risposta : listaRisposte) {
				int startTextId = 0, endTextId = 0, startId = 0, endId = 0;
				for (String oRisposte : risposta.getRisposte()) {
					if (("DOM_128" + plesso + str).equals(risposta.getCodDmd()) && "165".equalsIgnoreCase(oRisposte)
							&& StringUtils.isNotBlank(oRisposte)) {
						// Validator text type 13.3.1
						startTextId = 129;
						endTextId = 129;
					}
				}
				if (startTextId != 0 && endTextId != 0) {
					if (checkInputPlesso(listaRisposte, startTextId, endTextId, str, errors)) {
						isMainError = true;
					}
				}
				if (isMainError)
					break;
			}
			
			for(RispostaDTO risposta:listaRisposte)
			{
				Integer[] listaApertura= {1261};
				for (Integer idcheck : listaApertura	)
				{	
				if(idcheck!=0 )
				{
					if(checkInputPlesso(listaRisposte,idcheck,idcheck,str,errors))
					{
						isMainError=true;
					}
				}
			}
			}
			

		}
		for (RispostaDTO risposta : listaRisposte) {
			int startTextId = 0, endTextId = 0;
			for (String oRisposte : risposta.getRisposte()) {
				if ("DOM_138".equals(risposta.getCodDmd()) && StringUtils.isNotBlank(oRisposte)) {
					startTextId = 139;
					endTextId = 139;
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
			for (int startTextId = 108; startTextId < 140; startTextId++) {
				if (startTextId != 109 && startTextId != 110 && startTextId != 111 && startTextId != 112
						&& startTextId != 113 && startTextId != 114 && startTextId != 115 && startTextId != 116
						&& startTextId != 117 && startTextId != 118 && startTextId != 119 && startTextId != 120
						&& startTextId != 121 && startTextId != 122 && startTextId != 123 && startTextId != 124
						&& startTextId != 125 && startTextId != 126 && startTextId != 127 && startTextId != 128
						&& startTextId != 129 && startTextId != 130 && startTextId != 131 && startTextId != 138
						&& startTextId != 139 && startTextId != 133 ) {
					int endTextId = startTextId;
					if (startTextId == 126) {
						isMainError = true;
					}
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
		
		/*int contatoreNumRisposte=0;
		for (String str : listaPlessi) {

			for (RispostaDTO risposta : listaRisposte) {
				// Risposta 2.2
				if (("DOM_1261" + plesso + str).equals(risposta.getCodDmd())) {
					contatoreNumRisposte++;
				}
			}
			
			if (contatoreNumRisposte<listaPlessi.size()) {
				// RADIO BUTTON INIZIALE _34
				String[] idDmdList = { "DOM_1261" + plesso + str };
				checkAllResponseByIdNotName(errors, risposteDate, idDmdList);
				isMainError = true;
			}

			if (isMainError)
				break;

			}*/
		
		
		String[] listaStrToCheck = { "DOM_109", "DOM_110", "DOM_111", "DOM_112", "DOM_113", "DOM_114", "DOM_115",
				"DOM_116", "DOM_117", "DOM_118", "DOM_119", "DOM_132",  "DOM_134", "DOM_135", "DOM_136",
				"DOM_137","DOM_138"};
	        		

		for(String str:listaStrToCheck) {
			if (isNumeric(errors,listaRisposte, Arrays.asList(str)) == false) {
				isMainError=true;
			}
		}
		
		if (isMainError) {
			if (!errors.isEmpty()) {
				validatorResponse.setErrors(errors);
				validatorResponse.setSuccess(false);
			}
		}

		return validatorResponse;
	}

	public List<String> checkInputPlessi(List<RispostaDTO> risposte) {
		List<String> listaPlessi = new ArrayList<>();
		for (int i = 0; i < risposte.size(); i++) {
			String str = risposte	.get(i).getCodDmd();
			if (str.length() > 7) {
				String[] parts = str.split("_");
				String extractedResult = "";
				extractedResult = parts[4];
				listaPlessi.add(extractedResult);
			}
		}
		return listaPlessi;
	}
}
