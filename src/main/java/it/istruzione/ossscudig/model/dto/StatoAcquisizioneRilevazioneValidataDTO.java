package it.istruzione.ossscudig.model.dto;

public class StatoAcquisizioneRilevazioneValidataDTO {
	Integer idQst;
	String  descizioneQuestionario;
	Integer numeroNonValidati;
	Integer numeroValidati;
	
	public final Integer getIdQst() {
		return idQst;
	}
	public final void setIdQst(Integer idQst) {
		this.idQst = idQst;
	}
	public String getDescizioneQuestionario() {
		return descizioneQuestionario;
	}
	public void setDescizioneQuestionario(String descizioneQuestionario) {
		this.descizioneQuestionario = descizioneQuestionario;
	}
	public Integer getNumeroNonValidati() {
		return numeroNonValidati;
	}
	public void setNumeroNonValidati(Integer numeroNonValidati) {
		this.numeroNonValidati = numeroNonValidati;
	}
	public Integer getNumeroValidati() {
		return numeroValidati;
	}
	public void setNumeroValidati(Integer numeroValidati) {
		this.numeroValidati = numeroValidati;
	}
	
}
