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

public class ValidatorSezione4 extends ISezione{

	private static Logger logger = Logger.getLogger(ValidatorSezione4.class);

	public ValidatorResponse validate(String idSezione,List<RispostaDTO> listaRisposte) {

		logger.debug("ingresso nel validator");
		ValidatorResponse validatorResponse = new ValidatorResponse();
		validatorResponse.setSuccess(true);
		List<ValidationError> errors = new LinkedList<>();
		List<String> risposteDate = new ArrayList<String>();
		int contatoreNumRisposte=0;
		boolean is43 = false;

		for(int i=0;i<listaRisposte.size();i++)
		{
			

			//Risposta 4.2
			if("DOM_43".equals(listaRisposte.get(i).getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(listaRisposte.get(i).getCodDmd());

				if("165".equalsIgnoreCase(listaRisposte.get(i).getRisposte().get(0)))
				{
					List<Integer> idList = new ArrayList<Integer>();
					idList.add(45);idList.add(48);idList.add(51);idList.add(54);idList.add(57);idList.add(60);idList.add(63);
					is43=true;
					
					for(int id:idList)
					{
						checkInput(listaRisposte,id,id,errors);
					}
				}
			}
		}

		if(listaRisposte.size()==0 || contatoreNumRisposte<1)
		{
			String[] idDmdList = {"43"};
			checkAllResponse(errors, risposteDate, idDmdList);
		}

		//Validazione manyRadio&text type da 4.3.1.1, 4.3.1.2, 4.3.1.3, 4.3.1.4, 4.3.1.5, 4.3.1.6, 4.3.1.7
		if(is43)
		{
			ArrayList<String> listaStrToCheck = new ArrayList<String>();
	       
			for(RispostaDTO risposta:listaRisposte)
			{
				int startId=0,endId=0;

				if("DOM_45".equals(risposta.getCodDmd())
						&& "165".equalsIgnoreCase(risposta.getRisposte().get(0))) {
					//Validator text type 4.3.1.1.1 e 4.3.1.1.2
					startId=46;endId=47;
					listaStrToCheck.add("DOM_46");
				}
				else if("DOM_48".equals(risposta.getCodDmd())
						&& "165".equalsIgnoreCase(risposta.getRisposte().get(0))) {
					//Validator text type 4.3.1.2.1 e 4.3.1.2.2
					startId=49; endId=50;
					listaStrToCheck.add("DOM_49");
				}
				else if("DOM_51".equals(risposta.getCodDmd())
						&& "165".equalsIgnoreCase(risposta.getRisposte().get(0))) {
					//Validator text type 4.3.1.3.1 e 4.3.1.3.2
					startId=52; endId=53;
					listaStrToCheck.add("DOM_52");
				}
				else if("DOM_54".equals(risposta.getCodDmd())
						&& "165".equalsIgnoreCase(risposta.getRisposte().get(0))) {
					//Validator text type 4.3.1.4.1 e 4.3.1.4.2
					startId=55; endId=56;
					listaStrToCheck.add("DOM_55");
				}
				else if("DOM_57".equals(risposta.getCodDmd())
						&& "165".equalsIgnoreCase(risposta.getRisposte().get(0))) {
					//Validator text type 4.3.1.5.1 e 4.3.1.5.2
					startId=58; endId=59;
					listaStrToCheck.add("DOM_58");
				}
				else if("DOM_60".equals(risposta.getCodDmd())
						&& "165".equalsIgnoreCase(risposta.getRisposte().get(0))) {
					//Validator text type 4.3.1.6.1 e 4.3.1.6.2
					startId=61; endId=62;
					listaStrToCheck.add("DOM_61");
				}
				else if("DOM_63".equals(risposta.getCodDmd())
						&& "165".equalsIgnoreCase(risposta.getRisposte().get(0))) {
					//Validator text type 4.3.1.7.1 e 4.3.1.7.2 e 4.3.1.7.3
					startId=64; endId=66;
					listaStrToCheck.add("DOM_65");
				}
				for(String str:listaStrToCheck) {
					isNumeric(errors,listaRisposte, Arrays.asList(str));
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