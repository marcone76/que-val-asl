package it.istruzione.ossscudig.model.dto;

public class AcquisizioneQuestionarioInCorsoDTO {
	
	private String codiceMeccanografico;
	private String denominazione;
	private String questionario;
	private String regione;
	private String provincia;
	private String comune;
	private String stato;
	
	
	public String getCodiceMeccanografico() {
		return codiceMeccanografico;
	}
	public void setCodiceMeccanografico(String codiceMeccanografico) {
		this.codiceMeccanografico = codiceMeccanografico;
	}
	public String getDenominazione() {
		return denominazione;
	}
	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}
	public String getQuestionario() {
		return questionario;
	}
	public void setQuestionario(String questionario) {
		this.questionario = questionario;
	}
	public String getRegione() {
		return regione;
	}
	public void setRegione(String regione) {
		this.regione = regione;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getComune() {
		return comune;
	}
	public void setComune(String comune) {
		this.comune = comune;
	}
	public String getStato() {
		return stato;
	}
	public void setStato(String stato) {
		this.stato = stato;
	}
	
	

}
