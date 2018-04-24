package it.istruzione.ossscudig.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the TOD1016_ASSQUESTSEZIONE database table.
 * 
 */
@Entity
@Table(name="TOD1016_ASSQUESTSEZIONE")
@NamedQuery(name="Tod1016Assquestsezione.findAll", query="SELECT t FROM Tod1016Assquestsezione t")
public class Tod1016Assquestsezione implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private Tod1016AssquestsezionePK id;

	@Column(name="COD_PGM_ULT_MOV")
	private String codPgmUltMov;

	@Column(name="COD_UTE_ULT_MOV")
	private String codUteUltMov;

	@Temporal(TemporalType.DATE)
	@Column(name="DAT_ORA_ULT_MOV")
	private Date datOraUltMov;

	@Column(name="NUM_ORD_SEZ")
	private BigDecimal numOrdSez;

	public Tod1016Assquestsezione() {
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

	public BigDecimal getNumOrdSez() {
		return this.numOrdSez;
	}

	public void setNumOrdSez(BigDecimal numOrdSez) {
		this.numOrdSez = numOrdSez;
	}

	public Tod1016AssquestsezionePK getId() {
		return id;
	}

	public void setId(Tod1016AssquestsezionePK id) {
		this.id = id;
	}

	
}