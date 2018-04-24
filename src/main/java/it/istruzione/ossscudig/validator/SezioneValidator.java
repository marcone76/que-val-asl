package it.istruzione.ossscudig.validator;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import it.istruzione.ossscudig.exceptions.ScuolaDigitaleException;
import it.istruzione.ossscudig.model.dto.RispostaDTO;

public class SezioneValidator extends AbstractInputValidator {

    @Override
    protected long getIdRilevazione() {
        return 0;
    }

    @Override
    public ValidatorResponse validateInternal(String idSezione,List<RispostaDTO> listaRisposte) throws ScuolaDigitaleException {

        String errorMessage = "Errore di validazione campo";
        validatorResponse.setSuccess(true);

        Class<ISezione> classeInvocata = null;
        try {
        	classeInvocata =  (Class<ISezione>) Class.forName("it.istruzione.ossscudig.validator.sezioni.ValidatorSezione"+idSezione);
		
        Method[] metodi = classeInvocata.getMethods();
        for(Method m: metodi)
           System.out.println("Metodo: " +m.getName());
     
        Constructor costruttore = classeInvocata.getConstructor();
        // instanziamo la classe
        ISezione rf = (ISezione) costruttore.newInstance();
     
        // ed invochiamo il metodo rinomina()
        validatorResponse = (ValidatorResponse) classeInvocata.getMethod("validate",String.class,List.class).invoke(rf,idSezione,listaRisposte);
        
        } catch (Exception e) {
			e.printStackTrace();
			throw new ScuolaDigitaleException("Eccezione nella chiamata al validator relativo",e);
		} 
        
        return validatorResponse;
    }
}
