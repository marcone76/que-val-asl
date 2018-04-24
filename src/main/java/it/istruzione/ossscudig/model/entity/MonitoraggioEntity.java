package it.istruzione.ossscudig.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MonitoraggioEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID")
	private Long id;
	
	@Column(name="COD_SCU_UT")
	private String codiceMeccanografico;
	
	@Column(name="DENOM")
	private String denominazione;
	
	@Column(name="QUESTIONARIO")
	private String questionario;
	
	@Column(name="REGIONE")
	private String regione;
	
	@Column(name="PROVINCIA")
	private String provincia;
	
	@Column(name="COMUNE")
	private String comune;
	
	@Column(name="STATO")
	private String stato;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
