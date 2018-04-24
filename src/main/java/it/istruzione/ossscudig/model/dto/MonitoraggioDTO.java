package it.istruzione.ossscudig.model.dto;

public class MonitoraggioDTO {
	
	private String codScu;
	private String codForScu;
	private String codQuestionario;
	private String questionario;
	private String stato;
	private String datUltSal;
	private String dataUltVal;
	private String inCorso;
	private String validati;
	private String denom;
	
	public final String getCodForScu() {
		return codForScu;
	}
	public final void setCodForScu(String codForScu) {
		this.codForScu = codForScu;
	}
	public final String getCodScu() {
		return codScu;
	}
	public final void setCodScu(String codScu) {
		this.codScu = codScu;
	}
	public final String getCodQuestionario() {
		return codQuestionario;
	}
	public final void setCodQuestionario(String codQuestionario) {
		this.codQuestionario = codQuestionario;
	}
	public final String getQuestionario() {
		return questionario;
	}
	public final void setQuestionario(String questionario) {
		this.questionario = questionario;
	}
	public final String getStato() {
		return stato;
	}
	public final void setStato(String stato) {
		this.stato = stato;
	}
	public final String getDatUltSal() {
		return datUltSal;
	}
	public final void setDatUltSal(String datUltSal) {
		this.datUltSal = datUltSal;
	}
	public final String getDataUltVal() {
		return dataUltVal;
	}
	public final void setDataUltVal(String dataUltVal) {
		this.dataUltVal = dataUltVal;
	}
	public final String getInCorso() {
		return inCorso;
	}
	public final void setInCorso(String inCorso) {
		this.inCorso = inCorso;
	}
	public final String getValidati() {
		return validati;
	}
	public final void setValidati(String validati) {
		this.validati = validati;
	}
	public final String getDenom() {
		return denom;
	}
	public final void setDenom(String denom) {
		this.denom = denom;
	}

	


}
