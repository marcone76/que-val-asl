package it.istruzione.ossscudig.validator.sezioni;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.jboss.logging.Logger;

import it.istruzione.ossscudig.model.dto.RispostaDTO;
import it.istruzione.ossscudig.validator.ISezione;
import it.istruzione.ossscudig.validator.ValidationError;
import it.istruzione.ossscudig.validator.ValidatorResponse;

public class ValidatorSezione10 extends ISezione{

	private static Logger logger = Logger.getLogger(ValidatorSezione10.class);

	public ValidatorResponse validate(String idSezione,List<RispostaDTO> listaRisposte) {

		logger.debug("ingresso nel validator");
		ValidatorResponse validatorResponse = new ValidatorResponse();
		validatorResponse.setSuccess(true);
		List<ValidationError> errors = new LinkedList<>();
		List<String> risposteDate = new ArrayList<String>();
		int contatoreNumRisposte=0;

		for(int i=0;i<listaRisposte.size();i++)
		{
			for(int j=154;j<168;j++) {
				if(("DOM_"+j).equals(listaRisposte.get(i).getCodDmd()) && j!=161)
				{
					contatoreNumRisposte++;
					risposteDate.add(listaRisposte.get(i).getCodDmd());
				}
			}
		}
		if(listaRisposte.size()==0 || contatoreNumRisposte<13)
		{
			String[] idDmdList = {"154","155","156","157","158","159","160","162","163","164","165","166","167","168"};
			checkAllResponse(errors, risposteDate, idDmdList);
		}

		if(!errors.isEmpty()) {
			validatorResponse.setErrors(errors);
			validatorResponse.setSuccess(false);
		}
		return validatorResponse;
	}

}