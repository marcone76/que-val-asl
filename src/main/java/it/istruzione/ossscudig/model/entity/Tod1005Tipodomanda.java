package it.istruzione.ossscudig.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the TOD1005_TIPODOMANDA database table.
 * 
 */
@Entity
@Table(name="TOD1005_TIPODOMANDA")
@NamedQuery(name="Tod1005Tipodomanda.findAll", query="SELECT t FROM Tod1005Tipodomanda t")
public class Tod1005Tipodomanda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COD_TIP_DMD")
	private String codTipDmd;

	@Column(name="COD_PGM_ULT_MOV")
	private String codPgmUltMov;

	@Column(name="COD_UTE_ULT_MOV")
	private String codUteUltMov;

	@Temporal(TemporalType.DATE)
	@Column(name="DAT_ORA_ULT_MOV")
	private Date datOraUltMov;

	@Column(name="DES_TIP_DMD")
	private String desTipDmd;

	public Tod1005Tipodomanda() {
	}

	public String getCodTipDmd() {
		return this.codTipDmd;
	}

	public void setCodTipDmd(String codTipDmd) {
		this.codTipDmd = codTipDmd;
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

	public String getDesTipDmd() {
		return this.desTipDmd;
	}

	public void setDesTipDmd(String desTipDmd) {
		this.desTipDmd = desTipDmd;
	}
}