package it.istruzione.ossscudig.model.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ElencoScuoleEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID")
	private Long id;	
	
	@Column(name="CODSCU")
	private String codScu;
	
	@Column(name="DENOM")
	private String denom;
	
	@Column(name="COD_QUESTIONARIO")
	private String codQuestionario;
	
	@Column(name="QUESTIONARIO")
	private String questionario;
	
	@Column(name="STATO")
	private String stato;

	@Column(name="TIP_STA_VAL")
	private String tipStaVal;
	
	public final String getTipStaVal() {
		return tipStaVal;
	}

	public final void setTipStaVal(String tipStaVal) {
		this.tipStaVal = tipStaVal;
	}

	public final Long getId() {
		return id;
	}

	public final void setId(Long id) {
		this.id = id;
	}

	public final String getCodScu() {
		return codScu;
	}

	public final void setCodScu(String codScu) {
		this.codScu = codScu;
	}

	public final String getDenom() {
		return denom;
	}

	public final void setDenom(String denom) {
		this.denom = denom;
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


}
