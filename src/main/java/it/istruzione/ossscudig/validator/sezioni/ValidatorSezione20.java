package it.istruzione.ossscudig.validator.sezioni;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.jboss.logging.Logger;

import it.istruzione.ossscudig.model.dto.RispostaDTO;
import it.istruzione.ossscudig.validator.ISezione;
import it.istruzione.ossscudig.validator.ValidationError;
import it.istruzione.ossscudig.validator.ValidatorResponse;

public class ValidatorSezione20 extends ISezione {
	private static Logger logger = Logger.getLogger(ValidatorSezione19.class);

	public ValidatorResponse validate(String idSezione, List<RispostaDTO> listaRisposte) {

		logger.debug("ingresso nel validator 20");
		ValidatorResponse validatorResponse = new ValidatorResponse();
		validatorResponse.setSuccess(true);
		List<ValidationError> errors = new LinkedList<>();
		boolean isMainError = false;
		int contatoreNumRisposte=0;
		List<String> risposteDate = new ArrayList<String>();
		String plesso = "_COD_EDI_";

		List<String> codici = new ArrayList<>();


		for (int i=0; i<listaRisposte.size(); i++) {
			String str = listaRisposte.get(i).getCodDmd();
			String[] parts = str.split("_");
			String extractedResult = "";
			extractedResult =  parts[4];
			codici.add(extractedResult);

		}





		for (String str : codici) {

			for(RispostaDTO risposta:listaRisposte)
			{
				//Risposta 2.2
				if(("DOM_502"+plesso+str).equals(risposta.getCodDmd()))
				{
					contatoreNumRisposte++;
					risposteDate.add(risposta.getCodDmd());

					//Validator radio type SI/NO 2.2
					if("165".equalsIgnoreCase(risposta.getRisposte().get(0))){

						Integer[] listaApertura= {503,1610,1611,1612};
						for (Integer idcheck : listaApertura	)
						{	
							if(idcheck!=0 )
							{
								if(checkInputPlesso(listaRisposte,idcheck,idcheck,str,errors))
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

			//MULTIPLE CHECKBOX DOM_503
			for(int i=0;i<listaRisposte.size();i++)
			{
				if(("DOM_503"+plesso+str).equals(listaRisposte.get(i).getCodDmd()))
				{
					contatoreNumRisposte++;
					risposteDate.add(listaRisposte.get(i).getCodDmd());
				}

			}

			//campo obbligatorio
			for(int i=0;i<listaRisposte.size();i++)
			{
				if(("DOM_507"+plesso+str).equals(listaRisposte.get(i).getCodDmd()))
				{
					contatoreNumRisposte++;
					risposteDate.add(listaRisposte.get(i).getCodDmd());
				}

			}

			//checkbox altro con scritta seguente obbligatoria
			for(RispostaDTO risposta:listaRisposte)
			{


				int startTextId=0,endTextId=0,startId=0,endId=0;
				for (String oRisposte : risposta.getRisposte()) {

					if(("DOM_503"+plesso+str).equals(risposta.getCodDmd()) && "771".equalsIgnoreCase(oRisposte)
							&& StringUtils.isNotBlank(oRisposte)) {
						//Validator text type 13.3.1 
						startTextId=504; endTextId=504;
					}		
				}
				if(startTextId!=0 && endTextId!=0)
				{
					if(checkInputPlesso(listaRisposte,startTextId,endTextId,str,errors))
					{
						isMainError=true;
					}
				}


				if(isMainError)
					break;
			}

			//checkbox altro con scritta seguente obbligatoria
			for(RispostaDTO risposta:listaRisposte)
			{
				//Risposta 2.2
				if(("DOM_1612"+plesso+str).equals(risposta.getCodDmd()))
				{
					contatoreNumRisposte++;
					risposteDate.add(risposta.getCodDmd());

					//Validator radio type SI/NO 2.2
					if("9".equalsIgnoreCase(risposta.getRisposte().get(0)) || "10".equalsIgnoreCase(risposta.getRisposte().get(0))){

						Integer[] listaApertura= {1613};
						for (Integer idcheck : listaApertura	)
						{	
							if(idcheck!=0 )
							{
								if(checkInputPlesso(listaRisposte,idcheck,idcheck,str,errors))
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


			//campi obbligatori
			for(RispostaDTO risposta:listaRisposte)
			{
				Integer[] listaApertura= {502,507,510,511,512,513,514,1614,1616};
				for (Integer idcheck : listaApertura	)
				{	
					if(idcheck!=0 )
					{
						if(checkInputPlesso(listaRisposte,idcheck,idcheck,str,errors))
						{
							isMainError=true;
						}
					}
				}
			}

			//campi numerici
			String[] listaStrToCheck = {"DOM_510"+plesso+str, "DOM_511"+plesso+str, "DOM_512"+plesso+str, "DOM_513"+plesso+str, "DOM_514"+plesso+str, "DOM_1611"+plesso+str, "DOM_1614"+plesso+str, "DOM_1616"+plesso+str };

			for (String number : listaStrToCheck) {
				isNumeric(errors, listaRisposte, Arrays.asList(number));
				isMainError=true;
			}
		}

		if (isMainError) {
			if (!errors.isEmpty()) {
				validatorResponse.setErrors(errors);
				validatorResponse.setSuccess(false);
			}
		}

		return validatorResponse;
	}


	/*public List Plessi(List<RispostaDTO> listaPlessi) {
		List<String> codici = new ArrayList<>();
		for (int i=0; i<listaPlessi.size(); i++) {
			String str = listaPlessi.get(i).getCodDmd();
			String[] parts = str.split("_");
			String extractedResult = "";
			extractedResult =  parts[4];
			codici.add(extractedResult);

	}
return codici;
	}*/
}