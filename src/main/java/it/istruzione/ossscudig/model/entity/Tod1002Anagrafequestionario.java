package it.istruzione.ossscudig.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the TOD1002_ANAGRAFEQUESTIONARIO database table.
 * 
 */
@Entity
@Table(name="TOD1002_ANAGRAFEQUESTIONARIO")
@NamedQuery(name="Tod1002Anagrafequestionario.findAll", query="SELECT t FROM Tod1002Anagrafequestionario t")
public class Tod1002Anagrafequestionario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COD_QST")
	private String codQst;

	@Column(name="COD_PGM_ULT_MOV")
	private String codPgmUltMov;

	@Column(name="COD_UTE_ULT_MOV")
	private String codUteUltMov;

	@Temporal(TemporalType.DATE)
	@Column(name="DAT_ORA_ULT_MOV")
	private Date datOraUltMov;

	@Column(name="DES_QST")
	private String desQst;

	//bi-directional many-to-one association to Tod1001Istanzarilevazione
	@ManyToOne
	@JoinColumn(name="PRG_IST_RIL")
	private Tod1001Istanzarilevazione tod1001Istanzarilevazione;
	//bi-directional many-to-one association to Tod1007Tipostato
    @ManyToOne
	@JoinColumn(name="COD_TIP_STA")
	private Tod1007Tipostato tod1007Tipostato;

	public Tod1002Anagrafequestionario() {
	}

	public String getCodQst() {
		return this.codQst;
	}

	public void setCodQst(String codQst) {
		this.codQst = codQst;
	}

	public Tod1007Tipostato getTod1007Tipostato() {
		return tod1007Tipostato;
	}

	public void setTod1007Tipostato(Tod1007Tipostato tod1007Tipostato) {
		this.tod1007Tipostato = tod1007Tipostato;
	}

	public String getCodPgmUltMov() {
		return this.codPgmUltMov;
	}

	public void setCodPgmUltMov(String codPgmUltMov) {
		this.codPgmUltMov = codPgmUltMov;
	}

	public String getCodUteUltMov() {
		return this.codUteUltMov;
	}

	public void setCodUteUltMov(String codUteUltMov) {
		this.codUteUltMov = codUteUltMov;
	}

	public Date getDatOraUltMov() {
		return this.datOraUltMov;
	}

	public void setDatOraUltMov(Date datOraUltMov) {
		this.datOraUltMov = datOraUltMov;
	}

	public String getDesQst() {
		return this.desQst;
	}

	public void setDesQst(String desQst) {
		this.desQst = desQst;
	}

	public Tod1001Istanzarilevazione getTod1001Istanzarilevazione() {
		return this.tod1001Istanzarilevazione;
	}

	public void setTod1001Istanzarilevazione(Tod1001Istanzarilevazione tod1001Istanzarilevazione) {
		this.tod1001Istanzarilevazione = tod1001Istanzarilevazione;
	}

}