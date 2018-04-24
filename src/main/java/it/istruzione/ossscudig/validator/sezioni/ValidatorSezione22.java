package it.istruzione.ossscudig.validator.sezioni;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.jboss.logging.Logger;

import it.istruzione.ossscudig.model.dto.RispostaDTO;
import it.istruzione.ossscudig.validator.ISezione;
import it.istruzione.ossscudig.validator.ValidationError;
import it.istruzione.ossscudig.validator.ValidatorResponse;

public class ValidatorSezione22 extends ISezione{

	private static Logger logger = Logger.getLogger(ValidatorSezione19.class);

	public ValidatorResponse validate(String idSezione, List<RispostaDTO> listaRisposte) {

		logger.debug("ingresso nel validator");
		ValidatorResponse validatorResponse = new ValidatorResponse();
		validatorResponse.setSuccess(true);
		List<ValidationError> errors = new LinkedList<>();
		List<String> risposteDate = new ArrayList<String>();
		int contatoreNumRisposte=0;
		int sum=0;

		for(RispostaDTO risposta:listaRisposte)
		{
			//Risposta 3a.1.1
			if("DOM_520".equals(risposta.getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(risposta.getCodDmd());
				if(!risposta.getRisposte().get(0).trim().equals("0")) {
					if(isNumericSingolo(errors, risposta))	
						sum=sum+new Integer(risposta.getRisposte().get(0));
				}
			}
			//Risposta 3a.1.2
			if("DOM_521".equals(risposta.getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(risposta.getCodDmd());
				if(!risposta.getRisposte().get(0).trim().equals("0")) {
					if(isNumericSingolo(errors, risposta))	
						sum=sum+new Integer(risposta.getRisposte().get(0));
				}
			}
			//Risposta 3a.1.3
			if("DOM_522".equals(risposta.getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(risposta.getCodDmd());
				if(!risposta.getRisposte().get(0).trim().equals("0")) {
					if(isNumericSingolo(errors, risposta))	
						sum=sum+new Integer(risposta.getRisposte().get(0));
				}
			}
			//Risposta 3a.1.4
			if("DOM_523".equals(risposta.getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(risposta.getCodDmd());
				if(!risposta.getRisposte().get(0).trim().equals("0")) {
					if(isNumericSingolo(errors, risposta))	
						sum=sum+new Integer(risposta.getRisposte().get(0));
				}
			}
			//Risposta 3a.1.5
			if("DOM_524".equals(risposta.getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(risposta.getCodDmd());
				if(!risposta.getRisposte().get(0).trim().equals("0")) {
					if(isNumericSingolo(errors, risposta))	
						sum=sum+new Integer(risposta.getRisposte().get(0));
				}
			}
			//Risposta 3a.2.1
			if("DOM_526".equals(risposta.getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(risposta.getCodDmd());
			}
			//Risposta 3a.2.2
			if("DOM_527".equals(risposta.getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(risposta.getCodDmd());
			}
			//Risposta 3a.2.3
			if("DOM_528".equals(risposta.getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(risposta.getCodDmd());
			}
			//Risposta 3a.2.4
			if("DOM_529".equals(risposta.getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(risposta.getCodDmd());
			}
			//Risposta 3a.2.5
			if("DOM_530".equals(risposta.getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(risposta.getCodDmd());
			}
			//Risposta 3a.2.6
			if("DOM_531".equals(risposta.getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(risposta.getCodDmd());
			}
			//Risposta 3a.2.7
			if("DOM_532".equals(risposta.getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(risposta.getCodDmd());
			}

			//Risposta 3a.2.8
			if("DOM_533".equals(risposta.getCodDmd()))
			{
				if("789".equalsIgnoreCase(risposta.getRisposte().get(0))
					|| "790".equalsIgnoreCase(risposta.getRisposte().get(0))
					|| "791".equalsIgnoreCase(risposta.getRisposte().get(0))
					|| "792".equalsIgnoreCase(risposta.getRisposte().get(0))
					|| "793".equalsIgnoreCase(risposta.getRisposte().get(0))
					|| "794".equalsIgnoreCase(risposta.getRisposte().get(0)))
				{
					int startTextId=534, endTextId=534 ;
					checkInput(listaRisposte,startTextId,endTextId,errors);
				}
			}

			if("DOM_535".equals(risposta.getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(risposta.getCodDmd());
			}
		}

		if(sum!=100 && errors.isEmpty()) {
			for(int idDmd=520;idDmd<525;idDmd++)
			{
				aggiungiErrore(errors,"DOM_"+idDmd,"La somma dei campi evidenziati deve essere uguale a 100");
			}
		}

		//Controllo Tutte risposte
		if(listaRisposte.size()==0 || contatoreNumRisposte<13)
		{
			String[] idDmdList = {"526","527","528","529","530","531","532","535"};
			checkAllResponse(errors, risposteDate, idDmdList);
		}

		if(!errors.isEmpty()) {
			validatorResponse.setErrors(errors);
			validatorResponse.setSuccess(false);
		}

		return validatorResponse;
	}

}