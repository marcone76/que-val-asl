package it.istruzione.ossscudig.validator.sezioni;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.jboss.logging.Logger;

import it.istruzione.ossscudig.model.dto.RispostaDTO;
import it.istruzione.ossscudig.validator.ISezione;
import it.istruzione.ossscudig.validator.ValidationError;
import it.istruzione.ossscudig.validator.ValidatorResponse;

public class ValidatorSezione65 extends ISezione {

	private static Logger logger = Logger.getLogger(ValidatorSezione65.class);

	public ValidatorResponse validate(String idSezione, List<RispostaDTO> listaRisposte) {

		logger.debug("ingresso nel validator");
		ValidatorResponse validatorResponse = new ValidatorResponse();
		validatorResponse.setSuccess(true);
		List<ValidationError> errors = new LinkedList<>();
		List<String> risposteDate = new ArrayList<String>();
		int contatoreNumRisposte = 0;
		int sum=0;
		boolean isMainError = false;

		for(RispostaDTO risposta:listaRisposte)
		{
    		//Risposta 2.2
			if("DOM_1290".equals(risposta.getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(risposta.getCodDmd());

				//Validator radio type SI/NO 2.2
				if("165".equalsIgnoreCase(risposta.getRisposte().get(0))){

					
					for (int startTextId=1291; startTextId<1292; startTextId++) {
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
			}

		for(RispostaDTO risposta:listaRisposte)
		{
			if("DOM_1294".equals(risposta.getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(risposta.getCodDmd());
				if(!risposta.getRisposte().get(0).trim().equals("0")) {
					if(isNumericSingolo(errors, risposta))	
						sum=sum+new Integer(risposta.getRisposte().get(0));
						}
			}
			if("DOM_1295".equals(risposta.getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(risposta.getCodDmd());
				if(!risposta.getRisposte().get(0).trim().equals("0")) {
					if(isNumericSingolo(errors, risposta))	
						sum=sum+new Integer(risposta.getRisposte().get(0));
						}
			}
			if("DOM_1296".equals(risposta.getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(risposta.getCodDmd());
				if(!risposta.getRisposte().get(0).trim().equals("0")) {
					if(isNumericSingolo(errors, risposta))	
						sum=sum+new Integer(risposta.getRisposte().get(0));
						}
			}
			if("DOM_1297".equals(risposta.getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(risposta.getCodDmd());
				if(!risposta.getRisposte().get(0).trim().equals("0")) {
					if(isNumericSingolo(errors, risposta))	
						sum=sum+new Integer(risposta.getRisposte().get(0));
						}
			}
			
		}
		
		for (RispostaDTO risposta : listaRisposte) {

			for (int startTextId = 1299; startTextId < 1306; startTextId++) {

				int endTextId = startTextId;
				if (startTextId != 0 && endTextId != 0) {
					if (checkInput(listaRisposte, startTextId, endTextId, errors)) {
						isMainError = true;
					}
				}

			
			}

			if (isMainError)
				break;
		}

		if(sum!=100 ) {
			for(int idDmd=1294;idDmd<1298;idDmd++)
			{
				aggiungiErrore(errors,"DOM_"+idDmd,"La somma dei campi evidenziati deve essere uguale a 100");
			}
		}
		
		if (listaRisposte.size() == 0) {
			String[] idDmdList = { "1290", "1292", "1293", "1294", "1295", "1296", "1297", "1298", "1299", "1301",
					"1302", "1303", "1304", "1305" };
			checkAllResponse(errors, risposteDate, idDmdList);

		}

		if (!errors.isEmpty()) {
			validatorResponse.setErrors(errors);
			validatorResponse.setSuccess(false);
		}

		return validatorResponse;
	}

}