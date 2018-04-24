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
 * The persistent class for the TOD1007_TIPOSTATO database table.
 * 
 */
@Entity
@Table(name="TOD1007_TIPOSTATO")
@NamedQuery(name="Tod1007Tipostato.findAll", query="SELECT t FROM Tod1007Tipostato t")
public class Tod1007Tipostato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COD_TIP_STA")
	private long codTipSta;

	@Column(name="COD_CNT_STA")
	private String codCntSta;

	@Column(name="COD_PGM_ULT_MOV")
	private String codPgmUltMov;

	@Column(name="COD_UTE_ULT_MOV")
	private String codUteUltMov;

	@Temporal(TemporalType.DATE)
	@Column(name="DAT_ORA_ULT_MOV")
	private Date datOraUltMov;

	@Column(name="DES_TIP_STA")
	private String desTipSta;

	public Tod1007Tipostato() {
	}

	public long getCodTipSta() {
		return this.codTipSta;
	}

	public void setCodTipSta(long codTipSta) {
		this.codTipSta = codTipSta;
	}

	public String getCodCntSta() {
		return this.codCntSta;
	}

	public void setCodCntSta(String codCntSta) {
		this.codCntSta = codCntSta;
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

	public String getDesTipSta() {
		return this.desTipSta;
	}

	public void setDesTipSta(String desTipSta) {
		this.desTipSta = desTipSta;
	}

}