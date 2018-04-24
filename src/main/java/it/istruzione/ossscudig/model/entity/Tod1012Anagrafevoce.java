package it.istruzione.ossscudig.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * The persistent class for the TOD1012_ANAGRAFEVOCE database table.
 * 
 */
@Entity
@Table(name="TOD1012_ANAGRAFEVOCE")
@NamedQuery(name="Tod1012Anagrafevoce.findAll", query="SELECT t FROM Tod1012Anagrafevoce t")
public class Tod1012Anagrafevoce implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PRG_VOC")
	private long prgVoc;

	@Column(name="COD_PGM_ULT_MOV")
	private String codPgmUltMov;

	@Column(name="COD_UTE_ULT_MOV")
	private String codUteUltMov;

	@Temporal(TemporalType.DATE)
	@Column(name="DAT_ORA_ULT_MOV")
	private Date datOraUltMov;

	@Column(name="DES_VOC")
	private String desVoc;

	@Column(name="NUM_ORD_VOC")
	private BigDecimal numOrdVoc;

	//bi-directional many-to-one association to Tod1011Gruppovoce
	@ManyToOne
	@JoinColumn(name="PRG_GRP_VOC")
	private Tod1011Gruppovoce tod1011Gruppovoce;

	public Tod1012Anagrafevoce() {
	}

	public long getPrgVoc() {
		return this.prgVoc;
	}

	public void setPrgVoc(long prgVoc) {
		this.prgVoc = prgVoc;
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

	public String getDesVoc() {
		return this.desVoc;
	}

	public void setDesVoc(String desVoc) {
		this.desVoc = desVoc;
	}

	public BigDecimal getNumOrdVoc() {
		return this.numOrdVoc;
	}

	public void setNumOrdVoc(BigDecimal numOrdVoc) {
		this.numOrdVoc = numOrdVoc;
	}

	public Tod1011Gruppovoce getTod1011Gruppovoce() {
		return this.tod1011Gruppovoce;
	}

	public void setTod1011Gruppovoce(Tod1011Gruppovoce tod1011Gruppovoce) {
		this.tod1011Gruppovoce = tod1011Gruppovoce;
	}

}