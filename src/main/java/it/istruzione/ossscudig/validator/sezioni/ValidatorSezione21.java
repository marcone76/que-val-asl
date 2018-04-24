package it.istruzione.ossscudig.validator.sezioni;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.jboss.logging.Logger;
import it.istruzione.ossscudig.model.dto.RispostaDTO;
import it.istruzione.ossscudig.validator.ISezione;
import it.istruzione.ossscudig.validator.ValidationError;
import it.istruzione.ossscudig.validator.ValidatorResponse;

public class ValidatorSezione21 extends ISezione{

	private static Logger logger = Logger.getLogger(ValidatorSezione21.class);
	
	public ValidatorResponse validate(String idSezione,List<RispostaDTO> listaRisposte) {

		logger.debug("ingresso nel ValidatorSezione1");
        ValidatorResponse validatorResponse = new ValidatorResponse();
        validatorResponse.setSuccess(true);
        //ArrayList<String> listaRisposteStr = new ArrayList<String>();
        ArrayList<String> listaDomandeStr = new ArrayList<String>();
        
        List<ValidationError> errors = new LinkedList<>();
        for (Iterator iterator = listaRisposte.iterator(); iterator.hasNext();) {
        	RispostaDTO rispostaDTO = (RispostaDTO) iterator.next();
        	//listaRisposteStr.addAll(rispostaDTO.getRisposte());
        	listaDomandeStr.add(rispostaDTO.getCodDmd());
		}
		
        String[] listaObblig = {"DOM_516","DOM_517","DOM_518"};
        ArrayList<String> listaObblList = new ArrayList<String>( Arrays.asList(listaObblig) );
        
        if(   ! listaDomandeStr.containsAll(  listaObblList )   ){
        	listaObblList.removeAll(listaDomandeStr);  //dalla lista obbligatori rimuovo quelli che mi arrivano
        	for (Iterator iterator = listaObblList.iterator(); iterator.hasNext();) {
				String string = (String) iterator.next();
				aggiungiErrore(errors, string, "Se valorizzato devono essere valorizzati anche i campi evidenziati ai fini della validazione! Il salvataggio dei dai già inseriti viene comunque effettuato!");
			}
        }
        
        if(!errors.isEmpty()) {
        	validatorResponse.setSuccess(false);
        	validatorResponse.setErrors(errors);
        }
        return validatorResponse;
	}

	
}
