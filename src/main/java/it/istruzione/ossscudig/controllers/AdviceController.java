package it.istruzione.ossscudig.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import it.istruzione.ossscudig.exceptions.BeneficiarioNonTrovatoException;

@ControllerAdvice
public class AdviceController {

	/**
	 * @ExceptionHandler-annotated
	 * @InitBinder-annotated
	 * @ModelAttribute-annotated
	 * 
	 */


	@ExceptionHandler(BeneficiarioNonTrovatoException.class)
	public String beneficiarioExceptionHandler() {
		return "error";
	}

/*	@ExceptionHandler(CalcoloPraticaException.class)
	public ModelAndView calcoloExceptionHandler(CalcoloPraticaException cpe) {
		ModelAndView modelAndView = new ModelAndView("error2");
		modelAndView.addObject("errorObject", cpe);
		return modelAndView;
	}
*/}
