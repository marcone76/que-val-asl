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

public class ValidatorSezione54 extends ISezione {

	private static Logger logger = Logger.getLogger(ValidatorSezione54.class);

	public ValidatorResponse validate(String idSezione, List<RispostaDTO> listaRisposte) {

		logger.debug("ingresso nel validator");
		ValidatorResponse validatorResponse = new ValidatorResponse();
		validatorResponse.setSuccess(true);
		List<ValidationError> errors = new LinkedList<>();
        List<String> risposteDate = new ArrayList<String>();
		boolean isMainError = false;
		int contatoreNumRisposte=0;

		
		
		for (RispostaDTO risposta : listaRisposte) {
			int startTextId = 0, endTextId = 0;
			for (String oRisposte : risposta.getRisposte()) {

				if ("DOM_1065".equals(risposta.getCodDmd()) && "165".equalsIgnoreCase(oRisposte) && StringUtils.isNotBlank(oRisposte)) {
		
					for (startTextId = 1067; startTextId < 1070; startTextId++) {
						if (startTextId != 1068) {

							endTextId = startTextId;

							if (startTextId != 0 && endTextId != 0) {
								if (checkInput(listaRisposte, startTextId, endTextId, errors)) {
									isMainError = true;
								}
							}
						}
					}
				}
				if (isMainError)
					break;

			}
		}
		
		
		
		for (RispostaDTO risposta : listaRisposte) {
			int startTextId = 0, endTextId = 0;
			for (String oRisposte : risposta.getRisposte()) {
				if ("DOM_1083".equals(risposta.getCodDmd())&&"165".equalsIgnoreCase(oRisposte)
						&& StringUtils.isNotBlank(oRisposte)) {

					startTextId = 1084;
					endTextId = 1084;
				}
			}
			
			if (startTextId != 0 && endTextId != 0) {
			
				if (checkInput(listaRisposte, startTextId, endTextId, errors)) {

					isMainError = true;
				}
				// }
			
			}
		
			if (isMainError)
				break;
		}
		
		
		for (RispostaDTO risposta : listaRisposte) {
			int startTextId = 0, endTextId = 0;
			for (String oRisposte : risposta.getRisposte()) {
				if ("DOM_1087".equals(risposta.getCodDmd()) && "165".equalsIgnoreCase(oRisposte)
						&& StringUtils.isNotBlank(oRisposte)) {

					startTextId = 1088;
					endTextId = 1088;
				}
			}
			
			if (startTextId != 0 && endTextId != 0) {
			
				if (checkInput(listaRisposte, startTextId, endTextId, errors)) {

					isMainError = true;
				}
				// }
			
			
			}
			if (isMainError)
				break;
		}
		
		
		
		for (RispostaDTO risposta : listaRisposte) {
			int startTextId = 0, endTextId = 0;
			for (String oRisposte : risposta.getRisposte()) {
				if ("DOM_1091".equals(risposta.getCodDmd()) && "165".equalsIgnoreCase(oRisposte)
						&& StringUtils.isNotBlank(oRisposte)) {

					startTextId = 1092;
					endTextId = 1092;
				}
			}
			
			if (startTextId != 0 && endTextId != 0) {
			
				if (checkInput(listaRisposte, startTextId, endTextId, errors)) {

					isMainError = true;
				}
				// }
			
			
			}
			if (isMainError)
				break;
		}
		
		
		for (RispostaDTO risposta : listaRisposte) {
			int startTextId = 0, endTextId = 0;
			for (String oRisposte : risposta.getRisposte()) {
				if ("DOM_1079".equals(risposta.getCodDmd()) && "165".equalsIgnoreCase(oRisposte)
						&& StringUtils.isNotBlank(oRisposte)) {
					risposteDate.add(risposta.getCodDmd());

					startTextId = 1080;
					endTextId = 1080;
				}
			}
			if (startTextId != 0 && endTextId != 0) {
			
				if (checkInput(listaRisposte, startTextId, endTextId, errors)) {

					isMainError = true;
				}
				// }
			
			
			}
			if (isMainError)
				break;
		}
		
		/*for (RispostaDTO risposta : listaRisposte) {

			for (int startTextId = 1095; startTextId < 1101; startTextId++) {
				if (startTextId != 1096) {
		


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

		}*/
		
		
		
		
		for(RispostaDTO risposta:listaRisposte)
		{
		 if("DOM_1069".equals(risposta.getCodDmd())&& StringUtils.isNotBlank(risposta.getRisposte().get(0))) {
				for (int startTextId=1070; startTextId<1077; startTextId++) {
				 int endTextId=startTextId;
							
			if(startTextId!=0 && endTextId!=0)
			{
				if(checkInput(listaRisposte,startTextId,endTextId,errors))
				{
					isMainError=true;
				}
			}
				}
				if(isMainError)
					break;
				}
		 
		}
		
		
		for(RispostaDTO risposta:listaRisposte)
		{
		 if("DOM_1078".equals(risposta.getCodDmd())&& StringUtils.isNotBlank(risposta.getRisposte().get(0))) {
				for (int startTextId=1079; startTextId<1082; startTextId++) {
					if (startTextId != 1080) {

				 int endTextId=startTextId;
							
			if(startTextId!=0 && endTextId!=0)
			{
				if(checkInput(listaRisposte,startTextId,endTextId,errors))
				{
					isMainError=true;
				}
			}
					}
				}
				if(isMainError)
					break;
				}
		 
		}
		
		for(RispostaDTO risposta:listaRisposte)
		{
		 if("DOM_1082".equals(risposta.getCodDmd())&& StringUtils.isNotBlank(risposta.getRisposte().get(0))) {
				for (int startTextId=1083; startTextId<1086; startTextId++) {
					if (startTextId != 1084) {

				 int endTextId=startTextId;
							
			if(startTextId!=0 && endTextId!=0)
			{
				if(checkInput(listaRisposte,startTextId,endTextId,errors))
				{
					isMainError=true;
				}
			}
					}
				}
				if(isMainError)
					break;
				}
		 
		}
		
		for(RispostaDTO risposta:listaRisposte)
		{
		 if("DOM_1086".equals(risposta.getCodDmd())&& StringUtils.isNotBlank(risposta.getRisposte().get(0))) {
				for (int startTextId=1087; startTextId<1090; startTextId++) {
					if (startTextId != 1088) {

				 int endTextId=startTextId;
							
			if(startTextId!=0 && endTextId!=0)
			{
				if(checkInput(listaRisposte,startTextId,endTextId,errors))
				{
					isMainError=true;
				}
			}
					}
				}
				if(isMainError)
					break;
				}
		 
		}
		
		for(RispostaDTO risposta:listaRisposte)
		{
		 if("DOM_1090".equals(risposta.getCodDmd())&& StringUtils.isNotBlank(risposta.getRisposte().get(0))) {
				for (int startTextId=1091; startTextId<1094; startTextId++) {
					if (startTextId != 1092) {

				 int endTextId=startTextId;
							
			if(startTextId!=0 && endTextId!=0)
			{
				if(checkInput(listaRisposte,startTextId,endTextId,errors))
				{
					isMainError=true;
				}
			}
					}
				}
				if(isMainError)
					break;
				}
		 
		}
		
		
		for (RispostaDTO risposta : listaRisposte) {
			int startTextId = 0, endTextId = 0;
			for (String oRisposte : risposta.getRisposte()) {
				if ("DOM_1101".equals(risposta.getCodDmd()) && StringUtils.isNotBlank(oRisposte)) {
			

					startTextId = 1102;
					endTextId = 1102;
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
		
		
		
		
		for(RispostaDTO risposta:listaRisposte)
		{
    		//Risposta 2.2
			if("DOM_1065".equals(risposta.getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(risposta.getCodDmd());

				
			}
		}
	
		/*for(RispostaDTO risposta:listaRisposte)
		{
			for (String oRisposte : risposta.getRisposte()) {

				if(("DOM_1078").equals(risposta.getCodDmd()) && StringUtils.isNotBlank(oRisposte))
				{
					contatoreNumRisposte++;
					risposteDate.add(risposta.getCodDmd());
				}
			}
		}*/
		
		
		
		
		
	

	

		String[] listaStrToCheck = { "DOM_1067", "DOM_1068", "DOM_1069", "DOM_1070", "DOM_1071", "DOM_1072", "DOM_1073",
				"DOM_1074", "DOM_1075", "DOM_1076", "DOM_1095",  "DOM_1097", "DOM_1098", "DOM_1099",
				"DOM_1100" };



		for (String str : listaStrToCheck) {
			isNumeric(errors, listaRisposte, Arrays.asList(str));
		}

		 //Controllo Tutte risposte
    	if(listaRisposte.size()==0 || contatoreNumRisposte<2)
    	{
    		String[] idDmdList = {"1065"};
    		checkAllResponse(errors, risposteDate, idDmdList);
    		isMainError=true;
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