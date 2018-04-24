package it.istruzione.ossscudig.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ElencoScuoleCountEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID")   //ID, COD_QUESTIONARIO, QUESTIONARIO, IN_CORSO, VALIDATI
	private Long id;
	
	@Column(name="COD_QUESTIONARIO")
	private String codQuestionario;
	
	@Column(name="QUESTIONARIO")
	private String questionario;
	
	@Column(name="IN_CORSO")
	private String inCorso;
	
	@Column(name="VALIDATI")
	private String validati;

	public final Long getId() {
		return id;
	}

	public final void setId(Long id) {
		this.id = id;
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

}
