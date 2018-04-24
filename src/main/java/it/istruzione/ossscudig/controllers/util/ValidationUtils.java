package it.istruzione.ossscudig.controllers.util;

import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

/**
 * Classe di utilità che aggiunge funzioni per la gestione della validazione con
 * particolare attenzione al binding tra target object
 * 
 * @author Giannini
 *
 */
public class ValidationUtils {

	private ValidationUtils() {
	}

	/**
	 * Crea un nuovo BindingResult a partire da uno esistente modificandone il
	 * target ed il targetName
	 * 
	 * @param bindingResult
	 * @param target
	 * @param targetName
	 * @return
	 */
	public static BindingResult redefineBindingTarget(BindingResult bindingResult, Object target, String targetName) {
		BeanPropertyBindingResult newBindingResult = new BeanPropertyBindingResult(target, targetName);
		for (ObjectError error : bindingResult.getAllErrors()) {
			newBindingResult.addError(error);
		}
		return newBindingResult;
	}

}
