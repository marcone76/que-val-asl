package it.istruzione.ossscudig.model.dto;

public class StatoAcquisizioneQuestionarioElencoDTO {
	
	private String 	codiceMeccanografico;
	private String 	denominazioneScuola;
	private String 	denominazioneQuestionario;
	private String 	regione;
	private String 	provincia;
	private String 	comune;
	private String 	statoQuestionario;
	
	public String getCodiceMeccanografico() {
		return codiceMeccanografico;
	}
	public void setCodiceMeccanografico(String codiceMeccanografico) {
		this.codiceMeccanografico = codiceMeccanografico;
	}
	public String getDenominazioneScuola() {
		return denominazioneScuola;
	}
	public void setDenominazioneScuola(String denominazioneScuola) {
		this.denominazioneScuola = denominazioneScuola;
	}
	public String getDenominazioneQuestionario() {
		return denominazioneQuestionario;
	}
	public void setDenominazioneQuestionario(String denominazioneQuestionario) {
		this.denominazioneQuestionario = denominazioneQuestionario;
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
	public String getStatoQuestionario() {
		return statoQuestionario;
	}
	public void setStatoQuestionario(String statoQuestionario) {
		this.statoQuestionario = statoQuestionario;
	}
	
}
