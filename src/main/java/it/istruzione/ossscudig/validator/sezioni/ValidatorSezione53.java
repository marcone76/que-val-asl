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

public class ValidatorSezione53 extends ISezione {

	private static Logger logger = Logger.getLogger(ValidatorSezione5.class);

	public ValidatorResponse validate(String idSezione, List<RispostaDTO> listaRisposte) {

		logger.debug("ingresso nel validator");
		ValidatorResponse validatorResponse = new ValidatorResponse();
		validatorResponse.setSuccess(true);
		List<ValidationError> errors = new LinkedList<>();
		List<String> risposteDate = new ArrayList<String>();
		int contatoreNumRisposte=0;
		boolean is51=false;
		boolean is52=false;
		boolean is54=false;

		for(RispostaDTO risposta:listaRisposte)
		{
			
			//Validator radio type SI/NO 5.1
				is51=true;

				//Validazione radio type SI/NO 5.1.1, 13.1.2, 13.1.3, 13.1.4, 13.1.5
				List<Integer> idListRadio = new ArrayList<Integer>();
				idListRadio.add(1026);idListRadio.add(1031);idListRadio.add(1036);idListRadio.add(1064);
				for(int id:idListRadio)
				{
					checkInput(listaRisposte,id,id,errors);
				}
				
			
			
			//Risposta 5.3.1
			if("DOM_1047".equals(risposta.getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(risposta.getCodDmd());
				isNumericSingolo(errors, risposta);
			}
			
			//Risposta 5.3.3
			if("DOM_1049".equals(risposta.getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(risposta.getCodDmd());
				isNumericSingolo(errors, risposta);
			}
			//Risposta 5.3.4
			if("DOM_1050".equals(risposta.getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(risposta.getCodDmd());
				isNumericSingolo(errors, risposta);
			}
			//Risposta 5.3.5
			if("DOM_1051".equals(risposta.getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(risposta.getCodDmd());
				isNumericSingolo(errors, risposta);
			}
			
			
			
			//Risposta 5.3.7
            if("DOM_1052".equals(risposta.getCodDmd()) && StringUtils.isNotBlank(risposta.getRisposte().get(0)))
            {
            	{
            		//Validazione text type 5.3.7.1
            		int idText=1053;
            		isNumericSingolo(errors, risposta);
            		checkInput(listaRisposte,idText,idText,errors);
            	}
            }
            
			//Risposta 5.3.6
			if("DOM_1602".equals(risposta.getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(risposta.getCodDmd());
				isNumericSingolo(errors, risposta);
			}
			//Risposta 5.4.1
			if("DOM_1055".equals(risposta.getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(risposta.getCodDmd());

				//Validazione radio type SI/NO 5.4.1
				if("165".equalsIgnoreCase(risposta.getRisposte().get(0)))
				{
					//Validazione text type 5.4.1.1
					int id=1056;
					List<String> listaStrToCheck = new ArrayList<String>();
					listaStrToCheck.add("DOM_"+id);
					isNumeric(errors, listaRisposte, listaStrToCheck);
					checkInput(listaRisposte,id,id,errors);
				}
			}
			//Risposta 5.4.2
			if("DOM_1057".equals(risposta.getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(risposta.getCodDmd());

				if("165".equalsIgnoreCase(risposta.getRisposte().get(0)))
				{
					//Validazione text type 5.4.1.1
					is54=true;
					List<String> listaStrToCheck = new ArrayList<String>();
					List<String> listaStrToCheckMag0 = new ArrayList<String>();
					List<Integer> listaStr = new ArrayList<Integer>();
					listaStrToCheck.add("DOM_1058");
					isNumeric(errors, listaRisposte, listaStrToCheck);
					listaStrToCheck.add("DOM_1060");
					isNumeric(errors, listaRisposte, listaStrToCheck);
					listaStrToCheck.add("DOM_1061");
					isNumeric(errors, listaRisposte, listaStrToCheck);
					listaStrToCheck.add("DOM_1062");
					isNumeric(errors, listaRisposte, listaStrToCheck);
					listaStrToCheckMag0.add("DOM_1058");
					listaStr.add(1058);listaStr.add(1060);listaStr.add(1061);listaStr.add(1062);
					isNumericMag0(errors, listaRisposte, listaStrToCheckMag0);
					for(Integer id:listaStr) {
						checkInput(listaRisposte,id,id,errors);
					}
				}
			}
		}


		//Controllo Tutte risposte
		if(listaRisposte.size()==0 || contatoreNumRisposte<8)
		{
			String[] idDmdList = {"1047","1049","1050","1051","1602","1055","1057"};
			checkAllResponse(errors, risposteDate, idDmdList);
		}


		for(RispostaDTO risposta:listaRisposte)
		{
			//Validazione manyRadio&text&checkbox type da 5.2.1, 5.2.2, 5.2.3, 5.2.4
			if(is51)
			{
				if("DOM_1026".equals(risposta.getCodDmd())
						&& "165".equalsIgnoreCase(risposta.getRisposte().get(0)))
				{
					//Validator text type 5.2.1.1, 5.2.1.2 e 5.2.1.4
					List<String> listaStrToCheck = new ArrayList<String>();
					listaStrToCheck.add("DOM_1027");
					isNumericMag0(errors, listaRisposte, listaStrToCheck);

					List<Integer> idList = new ArrayList<Integer>();
					idList.add(1028);idList.add(1030);idList.add(1027);
					for(int id:idList)
					{
						checkInput(listaRisposte,id,id,errors);
						if(id==1028)
							is52=true;
					}
				}
				else if("DOM_1031".equals(risposta.getCodDmd())
						&& "165".equalsIgnoreCase(risposta.getRisposte().get(0)))
				{
					//Validator text type 5.2.1.1, 5.2.1.2 e 5.2.1.4
					List<String> listaStrToCheck = new ArrayList<String>();
					listaStrToCheck.add("DOM_1032");
					isNumericMag0(errors, listaRisposte, listaStrToCheck);

					List<Integer> idList = new ArrayList<Integer>();
					idList.add(1033);idList.add(1035);idList.add(1032);
					for(int id:idList)
					{
						checkInput(listaRisposte,id,id,errors);
						if(id==1033)
							is52=true;
					}
				}
				else if("DOM_1036".equals(risposta.getCodDmd())
						&& "165".equalsIgnoreCase(risposta.getRisposte().get(0)))
				{
					//Validator text type 5.2.1.1, 5.2.1.2 e 5.2.1.4
					List<String> listaStrToCheck = new ArrayList<String>();
					listaStrToCheck.add("DOM_1037");
					isNumericMag0(errors, listaRisposte, listaStrToCheck);

					List<Integer> idList = new ArrayList<Integer>();
					idList.add(1038);idList.add(1040);idList.add(1037);
					for(int id:idList)
					{
						checkInput(listaRisposte,id,id,errors);
						if(id==1038)
							is52=true;
					}
				}
				
			}
		}

		for(RispostaDTO risposta:listaRisposte)
		{
			int checkId=0;
			//Validazione manyRadio&text&checkbox type da 5.2.2.2, 5.2.3.2, 5.2.4.2
			if(is52)
			{
				if("DOM_1028".equals(risposta.getCodDmd())
						&& "165".equalsIgnoreCase(risposta.getRisposte().get(0))) {
					checkId=1029;
				}
				else if("DOM_1033".equals(risposta.getCodDmd())
						&& "165".equalsIgnoreCase(risposta.getRisposte().get(0))) {
					checkId=1034;
				}
				else if("DOM_1038".equals(risposta.getCodDmd())
						&& "165".equalsIgnoreCase(risposta.getRisposte().get(0))) {
					checkId=1039;
				}
				else if("DOM_1066".equals(risposta.getCodDmd())
						&& "165".equalsIgnoreCase(risposta.getRisposte().get(0))) {
					checkId=1067;
				}
			}
			if(is54)
			{
				if("DOM_1057".equals(risposta.getCodDmd())
						&& "165".equalsIgnoreCase(risposta.getRisposte().get(0))) {
					checkId=1063;
				}
			}
			if(checkId>0) {
				if(!contieneAlmenoUnCheck(listaRisposte, "DOM_"+checkId))
				{
					aggiungiErrore(errors,"DOM_"+checkId,"Campo obbligatorio");
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