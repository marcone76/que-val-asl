package it.istruzione.ossscudig.validator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import it.istruzione.ossscudig.model.dto.RispostaDTO;
import it.istruzione.ossscudig.services.AnagrafeQuestionarioService;

public abstract class ISezione {

	@Autowired
	private AnagrafeQuestionarioService anagrafeQuestionarioService;
	
	public abstract ValidatorResponse validate(String idSezione,List<RispostaDTO> listaRisposte);
	public void aggiungiErrore(List<ValidationError> errors, String campo, String messaggio) {
		ValidationError validationError = new ValidationError();
		validationError.setErrorMessage(messaggio);
		validationError.setFieldName(campo);
		errors.add(validationError);
	}
	public boolean contieneCodiceDomandaValorizzato(List<RispostaDTO> listaRisposte, String codiceDomanda) {
		for (Iterator iterator = listaRisposte.iterator(); iterator.hasNext();) {
			RispostaDTO rispostaDTO = (RispostaDTO) iterator.next();
			if(rispostaDTO.getCodDmd().equals(codiceDomanda)) {

				for (Iterator iterator2 = rispostaDTO.getRisposte().iterator(); iterator2.hasNext();) {
					String risp = (String) iterator2.next();
					if(StringUtils.isBlank(risp))
						return false;

					return true;
				}

			}
		}
		return false;
	}


	public boolean contieneRadioSI(List<RispostaDTO> listaRisposte, String codiceDomanda) {
		for (Iterator iterator = listaRisposte.iterator(); iterator.hasNext();) {
			RispostaDTO rispostaDTO = (RispostaDTO) iterator.next();
			if(rispostaDTO.getCodDmd().equals(codiceDomanda)) {

				for (Iterator iterator2 = rispostaDTO.getRisposte().iterator(); iterator2.hasNext();) {
					String risp = (String) iterator2.next();
					if(!risp.equals("165"))
						return false;

					return true;
				}

			}
		}
		return false;
	}

	public boolean contieneAlmenoUnCheck(List<RispostaDTO> listaRisposte, String codiceDomanda) {
		for (Iterator iterator = listaRisposte.iterator(); iterator.hasNext();) {
			RispostaDTO rispostaDTO = (RispostaDTO) iterator.next();
			if(rispostaDTO.getCodDmd().equals(codiceDomanda)) {

				for (Iterator iterator2 = rispostaDTO.getRisposte().iterator(); iterator2.hasNext();) {
					String risp = (String) iterator2.next();
					if(!risp.equals(""))
						return true;

					return false;
				}

			}
		}
		return false;
	}

	public boolean contieneCheckAltro(List<RispostaDTO> listaRisposte, String codiceDomanda) {
		for (Iterator iterator = listaRisposte.iterator(); iterator.hasNext();) {
			RispostaDTO rispostaDTO = (RispostaDTO) iterator.next();
			if(rispostaDTO.getCodDmd().equals(codiceDomanda)) {

				for (Iterator iterator2 = rispostaDTO.getRisposte().iterator(); iterator2.hasNext();) {
					String risp = (String) iterator2.next();
					if(risp.equals("865"))
						return true;

					return false;
				}

			}
		}
		return false;
	}

	public boolean checkInput(List<RispostaDTO> risposte,int startId,int endId, List<ValidationError> errors) {
		boolean isError = false; 
		for(Integer idDmd=startId;idDmd<endId+1;idDmd++) {
			boolean presentDmd=false;
			for(RispostaDTO risposta:risposte) {
				presentDmd=false;
				if(("DOM_"+idDmd).equals(risposta.getCodDmd())) {
					presentDmd=true;
					break;
				}
			}
			if(!presentDmd) {
				aggiungiErrore(errors,"DOM_"+idDmd,"Campo obbligatorio");
				isError=true;
			}
		}
		return isError;
	}

	public boolean checkInputPlesso(List<RispostaDTO> risposte,int startId,int endId, String codice, List<ValidationError> errors) {
		boolean isError = false; 
		for(Integer idDmd=startId;idDmd<endId+1;idDmd++) {
			boolean presentDmd=false;
			for(RispostaDTO risposta:risposte) {
				presentDmd=false;
				if(("DOM_"+idDmd+"_COD_EDI_"+codice).equals(risposta.getCodDmd())) {
					presentDmd=true;
					break;
				}
			}
			if(!presentDmd) {
				aggiungiErrore(errors,"DOM_"+idDmd+"_COD_EDI_"+codice,"Campo obbligatorio");
				isError=true;
			}
		}
		return isError;
	}




	public void checkAllResponse(List<ValidationError> errors, List<String> risposteDate, String[] idDmdList) {
		for(int i=0;i<idDmdList.length;i++) {
			if(!risposteDate.contains("DOM_"+idDmdList[i])) {
				aggiungiErrore(errors,"DOM_"+idDmdList[i],"Rispondere a tutte le domande");
			}
		}
	}

	public void checkAllResponseById(List<ValidationError> errors, List<String> risposteDate, Integer idDmdListId) {
		for(int i=0;i<idDmdListId; i++) {
			if(!risposteDate.contains("DOM_"+idDmdListId)) {
				aggiungiErrore(errors,"DOM_"+idDmdListId,"Rispondere a tutte le domande");
			}
		}
	}

	public void checkAllResponseByIdNotName(List<ValidationError> errors, List<String> risposteDate, String[] idDmdList) {
		for(int i=0;i<idDmdList.length; i++) {
			if(!risposteDate.contains(idDmdList)) {
				aggiungiErrore(errors,""+idDmdList,"Rispondere a tutte le domande");
			}
		}
	}

	public void textObbligatorio(List<ValidationError> errors, List<String> risposteDate, String[] idDmdList) {
		for(int i=0;i<idDmdList.length;i++) {
			if(!risposteDate.contains("DOM_"+idDmdList[i])) {
				aggiungiErrore(errors,"DOM_"+idDmdList[i],"Campo obbligatorio");
			}
		}
	}
	
	
	public boolean isNumeric(List<ValidationError> errors,List<RispostaDTO> listaRisposte, List<String> listaStrToCheck){
		List<Long> listaCodiciRegolaVal = new ArrayList<Long>();
		listaCodiciRegolaVal.add((long) 1);listaCodiciRegolaVal.add((long)2);listaCodiciRegolaVal.add((long)8);listaCodiciRegolaVal.add((long)9);
		
		for (Iterator iterator = listaRisposte.iterator(); iterator.hasNext();) {
			RispostaDTO risposta = (RispostaDTO) iterator.next();

			for (Iterator iterator2 = listaCodiciRegolaVal.iterator(); iterator2.hasNext();) {
				Long string = (Long) iterator2.next();

				if( string==risposta.getIdRegex() ) {
					if(risposta.getRisposte().size()>0  ) 
						if(!risposta.getRisposte().get(0).matches(risposta.getRegEx())) {//"-?\\d+"	
							aggiungiErrore(errors,risposta.getCodDmd(),risposta.getMessaggioUtente());
							return false;
						}
				}
			}
		}
		return true;
	}

	public boolean isNumericSingolo(List<ValidationError> errors, RispostaDTO risposta){
		String a=risposta.getRegEx();
		if(risposta.getRisposte().size()>0  && !risposta.getRisposte().get(0).matches(risposta.getRegEx())) {//"-?\\d+"	
			aggiungiErrore(errors,risposta.getCodDmd(), risposta.getMessaggioUtente());
			return false;
		}
		return true;
	}


	public boolean isNumericMag0(List<ValidationError> errors,List<RispostaDTO> listaRisposte, List<String> listaStrToCheck){

		for (Iterator iterator = listaRisposte.iterator(); iterator.hasNext();) {
			RispostaDTO risposta = (RispostaDTO) iterator.next();

			for (Iterator iterator2 = listaStrToCheck.iterator(); iterator2.hasNext();) {
				String string = (String) iterator2.next();

				if(string.equals(risposta.getCodDmd())) {
					if(risposta.getRisposte().size()>0  ) 
						if(!risposta.getRisposte().get(0).matches(risposta.getRegEx()) || !(new Integer(risposta.getRisposte().get(0))>0)) {//"-?\\d+"	
							aggiungiErrore(errors,risposta.getCodDmd(),"Il campo deve essere numerico e maggiore di zero");
							return false;
						}
				}
			}
		}
		return true;
	}


	public boolean isNumericSingoloMag0(List<ValidationError> errors, RispostaDTO risposta){
		if(risposta.getRisposte().size()>0  && !risposta.getRisposte().get(0).matches(risposta.getRegEx()) || !(new Integer(risposta.getRisposte().get(0))>0)) {//"-?\\d+"	
			aggiungiErrore(errors,risposta.getCodDmd(),"Il campo deve essere numerico e maggiore di zero");
			return false;
		}
		return true;
	}


}
