package it.istruzione.ossscudig.model.dto;

public class ScuolaDTO {

	private String 	codiceMeccanografico;
	private String 	codiceMeccanograficoIstitutoPrincipale;
	private String 	denominazione;
	private String 	codiceForte;
	private Integer annoScolastico;
	private String  comune;
	private String  provincia;
	private String  regione;
	private String  questionario;
	private boolean statale;
	private boolean cpia;
	private String tipoIstituto;
	private String indirizzo;
	
	public final String getProvincia() {
		return provincia;
	}
	public final void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public final String getRegione() {
		return regione;
	}
	public final void setRegione(String regione) {
		this.regione = regione;
	}
	public final String getQuestionario() {
		return questionario;
	}
	public final void setQuestionario(String questionario) {
		this.questionario = questionario;
	}
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
	public String getCodiceForte() {
		return codiceForte;
	}
	public void setCodiceForte(String codiceForte) {
		this.codiceForte = codiceForte;
	}
	public Integer getAnnoScolastico() {
		return annoScolastico;
	}
	public void setAnnoScolastico(Integer annoScolastico) {
		this.annoScolastico = annoScolastico;
	}
	public String getComune() {
		return comune;
	}
	public void setComune(String comune) {
		this.comune = comune;
	}
	public String getCodiceMeccanograficoIstitutoPrincipale() {
		return codiceMeccanograficoIstitutoPrincipale;
	}
	public void setCodiceMeccanograficoIstitutoPrincipale(
			String codiceMeccanograficoIstitutoPrincipale) {
		this.codiceMeccanograficoIstitutoPrincipale = codiceMeccanograficoIstitutoPrincipale;
	}
	public boolean isStatale() {
		return statale;
	}
	public void setStatale(boolean statale) {
		this.statale = statale;
	}
	public boolean isCpia() {
		return cpia;
	}
	public void setCpia(boolean cpia) {
		this.cpia = cpia;
	}
	public String getOrdScu() {
		return codiceMeccanografico.substring(2,4);
	}
	public boolean isIstitutoPrincipale() {
		return codiceMeccanografico.equals(codiceMeccanograficoIstitutoPrincipale);
	}
	public boolean isPlesso() {
		return (!codiceMeccanografico.equals(codiceMeccanograficoIstitutoPrincipale)) 
				|| ((this.isSecondariaPrimoGrado() || this.isSecondariaSecondoGrado()) && codiceMeccanografico.substring(7, 9).compareTo("00") == 0);
	}
    public boolean isSecondariaSecondoGrado() {
        return (this.getOrdScu().compareTo("IS") == 0 || this.getOrdScu().compareTo("MM") > 0);
    }
    public boolean isSecondariaPrimoGrado() {
        return this.getOrdScu().compareTo("MM") == 0 || this.getOrdScu().compareTo("1M") == 0;
    }
    public boolean isInfanzia() {
        return this.getOrdScu().compareTo("AA") == 0 || this.getOrdScu().compareTo("1A") == 0;
    }
    public boolean isPrimaria() {
        return this.getOrdScu().compareTo("EE") == 0 || this.getOrdScu().compareTo("1E") == 0;
    }
    public boolean isCircoloDidattico() {
        return (this.getOrdScu().compareTo("EE") == 0 && codiceMeccanografico.substring(7, 9).compareTo("00") == 0);
    }
	public String getTipoScuola() {
		String out = "";
		if (this.isIstitutoPrincipale() && !this.isPlesso()){
			return "ISTITUTO SCOLASTICO";
		}else if (this.isPlesso() && !this.isIstitutoPrincipale()){
			return "SCUOLA";
		}else if (this.isPlesso() && this.isIstitutoPrincipale()){
			return "ISTITUTO SCOLASTICO E SCUOLA";
		}
		return out;
	}
    public boolean isSecondoCiclo() {
        return this.isSecondariaSecondoGrado();
    }
	public String getTipoIstituto() {
		return tipoIstituto;
	}
	public void setTipoIstituto(String tipoIstituto) {
		this.tipoIstituto = tipoIstituto;
	}
	public final String getIndirizzo() {
		return indirizzo;
	}
	public final void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	
}
