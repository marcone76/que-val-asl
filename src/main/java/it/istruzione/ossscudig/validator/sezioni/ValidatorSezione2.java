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

public class ValidatorSezione2 extends ISezione{

	private static Logger logger = Logger.getLogger(ValidatorSezione2.class);

	public ValidatorResponse validate(String idSezione,List<RispostaDTO> listaRisposte) {

		logger.debug("ingresso nel validator");
		ValidatorResponse validatorResponse = new ValidatorResponse();
		validatorResponse.setSuccess(true);
		List<ValidationError> errors = new LinkedList<>();
		List<String> risposteDate = new ArrayList<String>();
		int contatoreNumRisposte=0;
		boolean is22=false;

		for(RispostaDTO risposta:listaRisposte)
		{
			

			//Risposta 2.2
			if("DOM_10".equals(risposta.getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(risposta.getCodDmd());
				is22=true;

				//Validator radio type SI/NO 2.2
				if("165".equalsIgnoreCase(risposta.getRisposte().get(0))){

					//Validazione radio type SI/NO 2.2.1.1, 2.2.1.2, 2.2.1.3, 2.2.1.4, 2.2.1.5, 2.2.1.6, 2.2.1.7

					List<Integer> idList = new ArrayList<Integer>();
					idList.add(12);idList.add(15);idList.add(18);idList.add(21);idList.add(24);idList.add(27);idList.add(30);

					for(int id:idList)
					{
						checkInput(listaRisposte,id,id,errors);
					}
				}
			}
		}

		//Controllo Tutte risposte
		if(listaRisposte.size()==0 || contatoreNumRisposte<1)
		{
			String[] idDmdList = {"10"};
			checkAllResponse(errors, risposteDate, idDmdList);
		}


		//Validator 2° Risposte Livello
		if(is22)
		{
			for(RispostaDTO risposta:listaRisposte)
			{
				//Validazione manyRadio&text type da 2.2.1.1,

				int startTextId=0,endTextId=0;

				if("DOM_12".equals(risposta.getCodDmd())
						&& "165".equalsIgnoreCase(risposta.getRisposte().get(0))) {
					//Validator text type 2.2.1.1.1 e 2.2.1.1.2
					startTextId=13;endTextId=14;			        

					for (startTextId=13; startTextId<=endTextId; startTextId++) {

						if(startTextId!=0 && endTextId!=0)
						{
							checkInput(listaRisposte,startTextId,endTextId,errors);
						}
					}
					String[] listaStrToCheck = {"DOM_13"};
					isNumeric(errors,listaRisposte, Arrays.asList(listaStrToCheck));
				}

				else if("DOM_15".equals(risposta.getCodDmd())
						&& "165".equalsIgnoreCase(risposta.getRisposte().get(0))) {
					//Validator text type 2.2.1.1.1 e 2.2.1.1.2
					startTextId=16;endTextId=17;			        

					for (startTextId=16; startTextId<=endTextId; startTextId++) {

						if(startTextId!=0 && endTextId!=0)
						{
							checkInput(listaRisposte,startTextId,endTextId,errors);
						}
					}
					String[] listaStrToCheck = {"DOM_16"};
					isNumeric(errors,listaRisposte, Arrays.asList(listaStrToCheck));
				}

				else if("DOM_18".equals(risposta.getCodDmd())
						&& "165".equalsIgnoreCase(risposta.getRisposte().get(0))) {
					//Validator text type 2.2.1.1.1 e 2.2.1.1.2
					startTextId=19;endTextId=20;			        

					for (startTextId=19; startTextId<=endTextId; startTextId++)
					{
						if(startTextId!=0 && endTextId!=0)
						{
							checkInput(listaRisposte,startTextId,endTextId,errors);
						}
					}
					String[] listaStrToCheck = {"DOM_19"};
					isNumeric(errors,listaRisposte, Arrays.asList(listaStrToCheck));
				}
				
				else if("DOM_21".equals(risposta.getCodDmd())
						&& "165".equalsIgnoreCase(risposta.getRisposte().get(0))) {
					//Validator text type 2.2.1.1.1 e 2.2.1.1.2
					startTextId=22;endTextId=23;			        

					for (startTextId=21; startTextId<=endTextId; startTextId++)
					{
						if(startTextId!=0 && endTextId!=0)
						{
							checkInput(listaRisposte,startTextId,endTextId,errors);
						}
					}
					String[] listaStrToCheck = {"DOM_22"};
					isNumeric(errors,listaRisposte, Arrays.asList(listaStrToCheck));
				}

				else if("DOM_24".equals(risposta.getCodDmd())
						&& "165".equalsIgnoreCase(risposta.getRisposte().get(0))) {
					//Validator text type 2.2.1.1.1 e 2.2.1.1.2
					startTextId=25;endTextId=26;			        

					for (startTextId=25; startTextId<=endTextId; startTextId++)
					{
						if(startTextId!=0 && endTextId!=0)
						{
							checkInput(listaRisposte,startTextId,endTextId,errors);
						}
					}
					String[] listaStrToCheck = {"DOM_25"};
					isNumeric(errors,listaRisposte, Arrays.asList(listaStrToCheck));
				}

				else if("DOM_27".equals(risposta.getCodDmd())
						&& "165".equalsIgnoreCase(risposta.getRisposte().get(0))) {
					//Validator text type 2.2.1.1.1 e 2.2.1.1.2
					startTextId=28;endTextId=29;			        

					for (startTextId=28; startTextId<=endTextId; startTextId++) {

						if(startTextId!=0 && endTextId!=0)
						{
							checkInput(listaRisposte,startTextId,endTextId,errors);
						}
					}
					String[] listaStrToCheck = {"DOM_28"};
					isNumeric(errors,listaRisposte, Arrays.asList(listaStrToCheck));
				}

				else if("DOM_30".equals(risposta.getCodDmd())
						&& "165".equalsIgnoreCase(risposta.getRisposte().get(0))) {
					//Validator text type 2.2.1.1.1 e 2.2.1.1.2
					startTextId=31;endTextId=33;			        

					for (startTextId=31; startTextId<=endTextId; startTextId++) {

						if(startTextId!=0 && endTextId!=0)
						{
							checkInput(listaRisposte,startTextId,endTextId,errors);
						}
					}
					String[] listaStrToCheck = {"DOM_32"};
					isNumeric(errors,listaRisposte, Arrays.asList(listaStrToCheck));
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