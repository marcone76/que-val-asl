package it.istruzione.ossscudig.validator.sezioni;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.jboss.logging.Logger;

import it.istruzione.ossscudig.model.dto.RispostaDTO;
import it.istruzione.ossscudig.validator.ISezione;
import it.istruzione.ossscudig.validator.ValidationError;
import it.istruzione.ossscudig.validator.ValidatorResponse;

public class ValidatorSezione5 extends ISezione {

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
			if("DOM_67".equals(risposta.getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(risposta.getCodDmd());

				//Validator radio type SI/NO 5.1
				if(isNumericSingoloMag0(errors, risposta)){
					is51=true;

					//Validazione radio type SI/NO 5.1.1, 13.1.2, 13.1.3, 13.1.4, 13.1.5
					List<Integer> idListRadio = new ArrayList<Integer>();
					idListRadio.add(70);idListRadio.add(75);idListRadio.add(80);idListRadio.add(85);
					for(int id:idListRadio)
					{
						checkInput(listaRisposte,id,id,errors);
					}
					
				}
			}
			//Risposta 5.3.1
			if("DOM_91".equals(risposta.getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(risposta.getCodDmd());
				isNumericSingolo(errors, risposta);
			}
			
			//Risposta 5.3.3
			if("DOM_93".equals(risposta.getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(risposta.getCodDmd());
				isNumericSingolo(errors, risposta);
			}
			//Risposta 5.3.4
			if("DOM_94".equals(risposta.getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(risposta.getCodDmd());
				isNumericSingolo(errors, risposta);
			}
			//Risposta 5.3.5
			if("DOM_95".equals(risposta.getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(risposta.getCodDmd());
				isNumericSingolo(errors, risposta);
			}
			//Risposta 5.3.7
            if("DOM_96".equals(risposta.getCodDmd()))
            {
            	isNumericSingolo(errors, risposta);
            	if(isNumericSingolo(errors, risposta) && new Integer(risposta.getRisposte().get(0))>0)
            	{
            		//Validazione text type 5.3.7.1
            		int idText=97;
            		checkInput(listaRisposte,idText,idText,errors);
            	}
            }
			//Risposta 5.3.6
			if("DOM_1600".equals(risposta.getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(risposta.getCodDmd());
				isNumericSingolo(errors, risposta);
			}
			//Risposta 5.4.1
			if("DOM_99".equals(risposta.getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(risposta.getCodDmd());

				//Validazione radio type SI/NO 5.4.1
				if("165".equalsIgnoreCase(risposta.getRisposte().get(0)))
				{
					//Validazione text type 5.4.1.1
					int id=100;
					List<String> listaStrToCheck = new ArrayList<String>();
					listaStrToCheck.add("DOM_"+id);
					isNumeric(errors, listaRisposte, listaStrToCheck);
					checkInput(listaRisposte,id,id,errors);
				}
			}
			//Risposta 5.4.2
			if("DOM_101".equals(risposta.getCodDmd()))
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
					listaStrToCheck.add("DOM_102");listaStrToCheck.add("DOM_104");listaStrToCheck.add("DOM_105");listaStrToCheck.add("DOM_106");
					listaStrToCheckMag0.add("DOM_102");
					listaStr.add(102);listaStr.add(104);listaStr.add(105);listaStr.add(106);
					isNumeric(errors, listaRisposte, listaStrToCheck);
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
			String[] idDmdList = {"67","91","93","94","95","1600","99","101"};
			checkAllResponse(errors, risposteDate, idDmdList);
		}


		for(RispostaDTO risposta:listaRisposte)
		{
			//Validazione manyRadio&text&checkbox type da 5.2.1, 5.2.2, 5.2.3, 5.2.4
			if(is51)
			{
				if("DOM_70".equals(risposta.getCodDmd())
						&& "165".equalsIgnoreCase(risposta.getRisposte().get(0)))
				{
					//Validator text type 5.2.1.1, 5.2.1.2 e 5.2.1.4
					List<String> listaStrToCheck = new ArrayList<String>();
					listaStrToCheck.add("DOM_71");
					isNumericMag0(errors, listaRisposte, listaStrToCheck);

					List<Integer> idList = new ArrayList<Integer>();
					idList.add(72);idList.add(74);idList.add(71);
					for(int id:idList)
					{
						checkInput(listaRisposte,id,id,errors);
						if(id==72)
							is52=true;
					}
				}
				else if("DOM_75".equals(risposta.getCodDmd())
						&& "165".equalsIgnoreCase(risposta.getRisposte().get(0)))
				{
					//Validator text type 5.2.1.1, 5.2.1.2 e 5.2.1.4
					List<String> listaStrToCheck = new ArrayList<String>();
					listaStrToCheck.add("DOM_76");
					isNumericMag0(errors, listaRisposte, listaStrToCheck);

					List<Integer> idList = new ArrayList<Integer>();
					idList.add(77);idList.add(79);idList.add(76);
					for(int id:idList)
					{
						checkInput(listaRisposte,id,id,errors);
						if(id==77)
							is52=true;
					}
				}
				else if("DOM_80".equals(risposta.getCodDmd())
						&& "165".equalsIgnoreCase(risposta.getRisposte().get(0)))
				{
					//Validator text type 5.2.1.1, 5.2.1.2 e 5.2.1.4
					List<String> listaStrToCheck = new ArrayList<String>();
					listaStrToCheck.add("DOM_81");
					isNumericMag0(errors, listaRisposte, listaStrToCheck);

					List<Integer> idList = new ArrayList<Integer>();
					idList.add(82);idList.add(84);idList.add(81);
					for(int id:idList)
					{
						checkInput(listaRisposte,id,id,errors);
						if(id==82)
							is52=true;
					}
				}
				else if("DOM_85".equals(risposta.getCodDmd())
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
				}
			}
		}

		for(RispostaDTO risposta:listaRisposte)
		{
			int checkId=0;
			//Validazione manyRadio&text&checkbox type da 5.2.2.2, 5.2.3.2, 5.2.4.2
			if(is52)
			{
				if("DOM_72".equals(risposta.getCodDmd())
						&& "165".equalsIgnoreCase(risposta.getRisposte().get(0))) {
					checkId=73;
				}
				else if("DOM_77".equals(risposta.getCodDmd())
						&& "165".equalsIgnoreCase(risposta.getRisposte().get(0))) {
					checkId=78;
				}
				else if("DOM_87".equals(risposta.getCodDmd())
						&& "165".equalsIgnoreCase(risposta.getRisposte().get(0))) {
					checkId=88;
				}
				else if("DOM_82".equals(risposta.getCodDmd())
						&& "165".equalsIgnoreCase(risposta.getRisposte().get(0))) {
					checkId=83;
				}
			}
			if(is54)
			{
				if("DOM_101".equals(risposta.getCodDmd())
						&& "165".equalsIgnoreCase(risposta.getRisposte().get(0))) {
					checkId=107;
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