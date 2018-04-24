package it.istruzione.ossscudig.validator.sezioni;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.jboss.logging.Logger;

import it.istruzione.ossscudig.model.dto.RispostaDTO;
import it.istruzione.ossscudig.validator.ISezione;
import it.istruzione.ossscudig.validator.ValidationError;
import it.istruzione.ossscudig.validator.ValidatorResponse;

public class ValidatorSezione11 extends ISezione{

	private static Logger logger = Logger.getLogger(ValidatorSezione11.class);

	public ValidatorResponse validate(String idSezione,List<RispostaDTO> listaRisposte) {

		logger.debug("ingresso nel validator");
		ValidatorResponse validatorResponse = new ValidatorResponse();
		validatorResponse.setSuccess(true);
		List<ValidationError> errors = new LinkedList<>();
		List<String> risposteDate = new ArrayList<String>();
		int contatoreNumRisposte=0;

		for(int i=0;i<listaRisposte.size();i++)
		{
			if("DOM_169".equals(listaRisposte.get(i).getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(listaRisposte.get(i).getCodDmd());

				if("165".equalsIgnoreCase(listaRisposte.get(i).getRisposte().get(0)))
				{
					int startId=171,endId=172;
					List<String> listaStrToCheck = new ArrayList<String>();
					listaStrToCheck.add("DOM_171");listaStrToCheck.add("DOM_172");
					isNumeric(errors, listaRisposte, listaStrToCheck);
					checkInput(listaRisposte,startId,endId,errors);
				}
			}
			if("DOM_173".equals(listaRisposte.get(i).getCodDmd()))
			{
				contatoreNumRisposte++;
				risposteDate.add(listaRisposte.get(i).getCodDmd());

				if("165".equalsIgnoreCase(listaRisposte.get(i).getRisposte().get(0)))
				{
					int startId = 175,endId=176;
					List<String> listaStrToCheck = new ArrayList<String>();
					listaStrToCheck.add("DOM_175");listaStrToCheck.add("DOM_176");
					isNumeric(errors, listaRisposte, listaStrToCheck);
					checkInput(listaRisposte,startId,endId,errors);
				}
			}
			if(contatoreNumRisposte<2 && i==listaRisposte.size()-1)
			{
				String[] idDmdList = {"169","173"};
				checkAllResponse(errors, risposteDate, idDmdList);
			}
		}
		
		if(listaRisposte.size()==0)
		{
			String[] idDmdList = {"169","173"};
			checkAllResponse(errors, risposteDate, idDmdList);
		}

		if(!errors.isEmpty()) {
			validatorResponse.setErrors(errors);
			validatorResponse.setSuccess(false);
		}

		return validatorResponse;
	}


}