package it.istruzione.ossscudig.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GestioneEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name="ID")
	private Long id;
	
	public Long getId() {
		return id;
	}
	
	@Column(name="COD_QUESTIONARIO")
	private String codQuestionario;
	
	@Column(name="QUESTIONARIO")
	private String questionario;
	
	@Column(name="STATO")
	private String stato;

	@Column(name="COD_RILEVAZIONE")
	private String codRilevazione;

	@Column(name="COD_TIP_STA")
	private String codTipSta;
	
	public final String getCodTipSta() {
		return codTipSta;
	}

	public final void setCodTipSta(String codTipSta) {
		this.codTipSta = codTipSta;
	}

	public final String getCodRilevazione() {
		return codRilevazione;
	}

	public final void setCodRilevazione(String codRilevazione) {
		this.codRilevazione = codRilevazione;
	}

	public String getQuestionario() {
		return questionario;
	}

	public void setQuestionario(String questionario) {
		this.questionario = questionario;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getCodQuestionario() {
		return codQuestionario;
	}

	public void setCodQuestionario(String codQuestionario) {
		this.codQuestionario = codQuestionario;
	}

	
	
}
