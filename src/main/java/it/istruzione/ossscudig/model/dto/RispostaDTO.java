package it.istruzione.ossscudig.model.dto;

import java.util.List;

public class RispostaDTO {
	
	private String codDmd;
	private String regEx;
	private String messaggioUtente;
	private Long idRegex;
	private List<String> risposte;
	
	public String getCodDmd() {
		return codDmd;
	}
	public void setCodDmd(String codDmd) {
		this.codDmd = codDmd;
	}
	
	public final String getRegEx() {
		return regEx;
	}
	public final void setRegEx(String regEx) {
		this.regEx = regEx;
	}
	public List<String> getRisposte() {
		return risposte;
	}
	public void setRisposte(List<String> risposte) {
		this.risposte = risposte;
	}
	public String getMessaggioUtente() {
		return messaggioUtente;
	}
	public void setMessaggioUtente(String messaggioUtente) {
		this.messaggioUtente = messaggioUtente;
	}
	public final Long getIdRegex() {
		return idRegex;
	}
	public final void setIdRegex(Long idRegex) {
		this.idRegex = idRegex;
	}
	

}
