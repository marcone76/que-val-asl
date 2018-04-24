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

public class ValidatorSezione13 extends ISezione{

	private static Logger logger = Logger.getLogger(ValidatorSezione13.class);

	public ValidatorResponse validate(String idSezione,List<RispostaDTO> listaRisposte) {

		logger.debug("ingresso nel validator");
		ValidatorResponse validatorResponse = new ValidatorResponse();
		validatorResponse.setSuccess(true);
		List<ValidationError> errors = new LinkedList<>();
		List<String> risposteDate = new ArrayList<String>();
		int contatoreNumRisposte=0;
		boolean is131 = false;
		boolean is133=false;

		for(RispostaDTO risposta:listaRisposte) {

			//Risposta 13.1
			if("DOM_182".equals(risposta.getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(risposta.getCodDmd());

				//Validator radio type SI/NO 13.1
				if("165".equalsIgnoreCase(risposta.getRisposte().get(0))){

					is131=true;

					//Validazione radio type SI/NO 13.1.1, 13.1.2, 13.1.3, 13.1.4, 13.1.5
					List<Integer> idList = new ArrayList<Integer>();
					idList.add(183);idList.add(193);idList.add(203);idList.add(213);idList.add(223);

					for(int id:idList)
					{
						checkInput(listaRisposte,id,id,errors);
					}
				}
			}

			//Risposta 13.3
			if("DOM_235".equals(risposta.getCodDmd()))
			{
				is133=true;
				contatoreNumRisposte++;
				risposteDate.add(risposta.getCodDmd());

				//Validator radio type SI/NO 13.3
				if("165".equalsIgnoreCase(risposta.getRisposte().get(0)))
				{
					is133=true;
					
					//Validazione radio type SI/NO 13.3.1, 13.3.2, 13.3.3
					int id=236;
					checkInput(listaRisposte,id,id,errors);
				}
			}

			//Risposta 13.2
			if("DOM_234".equals(risposta.getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(risposta.getCodDmd());
			}

			//Risposta 13.4
			if("DOM_242".equals(risposta.getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(risposta.getCodDmd());
			}
		}

		//Controllo Tutte risposte
		if(listaRisposte.size()==0 || contatoreNumRisposte<4)
		{
			String[] idDmdList = {"182","234","235","242"};
			checkAllResponse(errors, risposteDate, idDmdList);
		}

		for(RispostaDTO risposta:listaRisposte)
		{
			//Validazione manyRadio&text type da 13.1.1, 13.1.2, 13.1.3, 13.1.4, 13.1.5
			if(is131)
			{
				int startId=0,endId=0;

				if("DOM_183".equals(risposta.getCodDmd())
						&& "165".equalsIgnoreCase(risposta.getRisposte().get(0))) {
					//Validator text type 13.1.1 
					startId=184;endId=192;
					List<String> listaStrToCheck = new ArrayList<String>();
					listaStrToCheck.add("DOM_184");
					isNumeric(errors, listaRisposte, listaStrToCheck);
				}
				else if("DOM_193".equals(risposta.getCodDmd())
						&& "165".equalsIgnoreCase(risposta.getRisposte().get(0))) {
					//Validator text type 13.1.2
					startId=194;endId=202;
					List<String> listaStrToCheck = new ArrayList<String>();
					listaStrToCheck.add("DOM_194");
					isNumeric(errors, listaRisposte, listaStrToCheck);
				}
				else if("DOM_203".equals(risposta.getCodDmd())
						&& "165".equalsIgnoreCase(risposta.getRisposte().get(0))) {
					//Validator text type 13.1.3
					startId=204;endId=212;
					List<String> listaStrToCheck = new ArrayList<String>();
					listaStrToCheck.add("DOM_204");
					isNumeric(errors, listaRisposte, listaStrToCheck);
				}
				else if("DOM_213".equals(risposta.getCodDmd())
						&& "165".equalsIgnoreCase(risposta.getRisposte().get(0))) {
					//Validator text type 13.1.4
					startId=214;endId=222;
					List<String> listaStrToCheck = new ArrayList<String>();
					listaStrToCheck.add("DOM_214");
					isNumeric(errors, listaRisposte, listaStrToCheck);
				}
				else if("DOM_223".equals(risposta.getCodDmd())
						&& "165".equalsIgnoreCase(risposta.getRisposte().get(0))) {
					//Validator text type 13.1.5
					startId=224; endId=233;
					List<String> listaStrToCheck = new ArrayList<String>();
					listaStrToCheck.add("DOM_225");
					isNumeric(errors, listaRisposte, listaStrToCheck);
				}
				if(startId!=0 && endId!=0)
				{
					checkInput(listaRisposte,startId,endId,errors);
				}
			}
			//Validazione manyRadio&text type da 13.3.1, 13.3.2, 13.3.3
			if(is133)
			{
				int startId=0,endId=0;

				if("DOM_236".equals(risposta.getCodDmd())
						&& StringUtils.isNotBlank(risposta.getRisposte().get(0))) {
					//Validator text type 13.3.1 
					startId=237; endId=237;
					List<String> listaStrToCheck = new ArrayList<String>();
					listaStrToCheck.add("DOM_237");
					isNumeric(errors, listaRisposte,listaStrToCheck);
				}
				if("DOM_238".equals(risposta.getCodDmd())
						&& StringUtils.isNotBlank(risposta.getRisposte().get(0))) {
					//Validator text type 13.3.2
					startId=239; endId=239;
					List<String> listaStrToCheck2 = new ArrayList<String>();
					listaStrToCheck2.add("DOM_239");
					isNumeric(errors, listaRisposte,listaStrToCheck2);
				}
				if("DOM_240".equals(risposta.getCodDmd())
						&& StringUtils.isNotBlank(risposta.getRisposte().get(0))) {
					//Validator text type 13.3.3
					startId=241; endId=241;
					List<String> listaStrToCheck3 = new ArrayList<String>();
					listaStrToCheck3.add("DOM_241");
					isNumeric(errors, listaRisposte,listaStrToCheck3);
				}
				if(startId!=0 && endId!=0)
				{
					checkInput(listaRisposte,startId,endId,errors);
				}
			}
		}

		if(!errors.isEmpty()) {
			validatorResponse.setErrors(errors);
			validatorResponse.setSuccess(false);
		}

		return validatorResponse;
	}
}