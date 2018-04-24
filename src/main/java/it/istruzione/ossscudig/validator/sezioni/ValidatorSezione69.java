package it.istruzione.ossscudig.validator.sezioni;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.jboss.logging.Logger;

import org.apache.commons.lang3.StringUtils;
import it.istruzione.ossscudig.model.dto.RispostaDTO;
import it.istruzione.ossscudig.validator.ISezione;
import it.istruzione.ossscudig.validator.ValidationError;
import it.istruzione.ossscudig.validator.ValidatorResponse;

public class ValidatorSezione69 extends ISezione {

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
			//Risposta 5.1
			if("DOM_1322".equals(risposta.getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(risposta.getCodDmd());

				//Validator radio type SI/NO 5.1
				if(isNumericSingoloMag0(errors, risposta)){
					is51=true;

					//Validazione radio type SI/NO 5.1.1, 13.1.2, 13.1.3, 13.1.4, 13.1.5
					List<Integer> idListRadio = new ArrayList<Integer>();
					idListRadio.add(1323);idListRadio.add(1325);idListRadio.add(1330);idListRadio.add(1335);
					for(int id:idListRadio)
					{
						checkInput(listaRisposte,id,id,errors);
					}
					List<String> listaStrToCheck = new ArrayList<String>();
					listaStrToCheck.add("DOM_1323");
					isNumeric(errors, listaRisposte, listaStrToCheck);
				}
			}
			//Risposta 5.3.1
			if("DOM_1341".equals(risposta.getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(risposta.getCodDmd());
				isNumericSingolo(errors, risposta);
			}
			
			//Risposta 5.3.3
			if("DOM_1343".equals(risposta.getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(risposta.getCodDmd());
				isNumericSingolo(errors, risposta);
			}
			//Risposta 5.3.4
			if("DOM_1344".equals(risposta.getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(risposta.getCodDmd());
				isNumericSingolo(errors, risposta);
			}
			//Risposta 5.3.5
			if("DOM_1345".equals(risposta.getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(risposta.getCodDmd());
				isNumericSingolo(errors, risposta);
			}
			//Risposta 5.3.7
			//Risposta 5.3.7
			 if("DOM_1346".equals(risposta.getCodDmd())&& StringUtils.isNotBlank(risposta.getRisposte().get(0))) {
           
           		//Validazione text type 5.3.7.1
           		int idText=1347;
           		isNumericSingolo(errors, risposta);
           		checkInput(listaRisposte,idText,idText,errors);
           	
           }
			//Risposta 5.3.6
			if("DOM_1603".equals(risposta.getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(risposta.getCodDmd());
				isNumericSingolo(errors, risposta);
			}
			//Risposta 5.4.1
			if("DOM_1349".equals(risposta.getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(risposta.getCodDmd());

				//Validazione radio type SI/NO 5.4.1
				if("165".equalsIgnoreCase(risposta.getRisposte().get(0)))
				{
					//Validazione text type 5.4.1.1
					int id=1350;
					List<String> listaStrToCheck = new ArrayList<String>();
					listaStrToCheck.add("DOM_"+id);
					isNumeric(errors, listaRisposte, listaStrToCheck);
					checkInput(listaRisposte,id,id,errors);
				}
			}
			//Risposta 5.4.2
			if("DOM_1351".equals(risposta.getCodDmd()))
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
					listaStrToCheck.add("DOM_1352");
					isNumeric(errors, listaRisposte, listaStrToCheck);
					listaStrToCheck.add("DOM_1354");
					isNumeric(errors, listaRisposte, listaStrToCheck);
					listaStrToCheck.add("DOM_1355");
					isNumeric(errors, listaRisposte, listaStrToCheck);
					listaStrToCheck.add("DOM_1356");
					isNumeric(errors, listaRisposte, listaStrToCheck);
					listaStrToCheckMag0.add("DOM_1352");
					isNumeric(errors, listaRisposte, listaStrToCheck);
					listaStr.add(1352);listaStr.add(1354);listaStr.add(1355);listaStr.add(1356);
					isNumericMag0(errors, listaRisposte, listaStrToCheckMag0);
					for(Integer id:listaStr) {
						checkInput(listaRisposte,id,id,errors);
					}
				}
			}
		}


		//Controllo Tutte risposte
		if(listaRisposte.size()==0 || contatoreNumRisposte<9)
		{
			String[] idDmdList = {"1322","1341","1343","1344","1345","1603","1349","1351"};
			checkAllResponse(errors, risposteDate, idDmdList);
		}


		for(RispostaDTO risposta:listaRisposte)
		{
			//Validazione manyRadio&text&checkbox type da 5.2.1, 5.2.2, 5.2.3, 5.2.4
			if(is51)
			{
				if("DOM_1325".equals(risposta.getCodDmd())
						&& "165".equalsIgnoreCase(risposta.getRisposte().get(0)))
				{
					//Validator text type 5.2.1.1, 5.2.1.2 e 5.2.1.4
					List<String> listaStrToCheck = new ArrayList<String>();
					listaStrToCheck.add("DOM_1326");
					isNumericMag0(errors, listaRisposte, listaStrToCheck);

					List<Integer> idList = new ArrayList<Integer>();
					idList.add(1327);idList.add(1329);idList.add(1326);
					for(int id:idList)
					{
						checkInput(listaRisposte,id,id,errors);
						if(id==1327)
							is52=true;
					}
				}
				else if("DOM_1330".equals(risposta.getCodDmd())
						&& "165".equalsIgnoreCase(risposta.getRisposte().get(0)))
				{
					//Validator text type 5.2.1.1, 5.2.1.2 e 5.2.1.4
					List<String> listaStrToCheck = new ArrayList<String>();
					listaStrToCheck.add("DOM_1331");
					isNumericMag0(errors, listaRisposte, listaStrToCheck);

					List<Integer> idList = new ArrayList<Integer>();
					idList.add(1332);idList.add(1335);idList.add(1331);
					for(int id:idList)
					{
						checkInput(listaRisposte,id,id,errors);
						if(id==1332)
							is52=true;
					}
				}
				else if("DOM_1335".equals(risposta.getCodDmd())
						&& "165".equalsIgnoreCase(risposta.getRisposte().get(0)))
				{
					//Validator text type 5.2.1.1, 5.2.1.2 e 5.2.1.4
					List<String> listaStrToCheck = new ArrayList<String>();
					listaStrToCheck.add("DOM_1336");
					isNumericMag0(errors, listaRisposte, listaStrToCheck);

					List<Integer> idList = new ArrayList<Integer>();
					idList.add(1337);idList.add(1339);idList.add(1336);
					for(int id:idList)
					{
						checkInput(listaRisposte,id,id,errors);
						if(id==1337)
							is52=true;
					}
				}
				/*else if("DOM_85".equals(risposta.getCodDmd())
						&& "165".equalsIgnoreCase(risposta.getRisposte().get(0)))
				{
					//Validator text type 5.2.1.1, 5.2.1.2 e 5.2.1.4 
					List<String> listaStrToCheck = new ArrayList<String>();
					listaStrToCheck.add("DOM_86");
					isNumericMag0(errors, listaRisposte, listaStrToCheck);

					List<Integer> idList = new ArrayList<Integer>();
					idList.add(87);idList.add(89);idList.add(86);
					for(int id:idList)
					{
						checkInput(listaRisposte,id,id,errors);
						if(id==87)
							is52=true;
					}
				}*/
			}
		}

		for(RispostaDTO risposta:listaRisposte)
		{
			int checkId=0;
			//Validazione manyRadio&text&checkbox type da 5.2.2.2, 5.2.3.2, 5.2.4.2
			if(is52)
			{
				if("DOM_1327".equals(risposta.getCodDmd())
						&& "165".equalsIgnoreCase(risposta.getRisposte().get(0))) {
					checkId=1328;
				}
				else if("DOM_1332".equals(risposta.getCodDmd())
						&& "165".equalsIgnoreCase(risposta.getRisposte().get(0))) {
					checkId=1333;
				}
				else if("DOM_1337".equals(risposta.getCodDmd())
						&& "165".equalsIgnoreCase(risposta.getRisposte().get(0))) {
					checkId=1338;
				}
				/*else if("DOM_82".equals(risposta.getCodDmd())
						&& "165".equalsIgnoreCase(risposta.getRisposte().get(0))) {
					checkId=83;
				}*/
			}
			if(is54)
			{
				if("DOM_1351".equals(risposta.getCodDmd())
						&& "165".equalsIgnoreCase(risposta.getRisposte().get(0))) {
					checkId=1357;
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