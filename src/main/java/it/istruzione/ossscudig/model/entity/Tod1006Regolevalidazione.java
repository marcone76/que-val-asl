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
 * The persistent class for the TOD1006_REGOLEVALIDAZIONE database table.
 * 
 */
@Entity
@Table(name="TOD1006_REGOLEVALIDAZIONE")
@NamedQuery(name="Tod1006Regolevalidazione.findAll", query="SELECT t FROM Tod1006Regolevalidazione t")
public class Tod1006Regolevalidazione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PRG_REG_VLD")
	private long prgRegVld;

	@Column(name="COD_PGM_ULT_MOV")
	private String codPgmUltMov;

	@Column(name="COD_UTE_ULT_MOV")
	private String codUteUltMov;

	@Temporal(TemporalType.DATE)
	@Column(name="DAT_ORA_ULT_MOV")
	private Date datOraUltMov;

	@Column(name="DES_MSG_INF")
	private String desMsgInf;

	@Column(name="DES_MSG_UTE")
	private String desMsgUte;

	@Column(name="DES_REG_VLD")
	private String desRegVld;

	@Column(name="DES_SCR_REG_VLD")
	private String desScrRegVld;

	@Column(name="DES_TIP_DAT")
	private String desTipDat;

	public Tod1006Regolevalidazione() {
	}

	public long getPrgRegVld() {
		return this.prgRegVld;
	}

	public void setPrgRegVld(long prgRegVld) {
		this.prgRegVld = prgRegVld;
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

	public String getDesMsgInf() {
		return this.desMsgInf;
	}

	public void setDesMsgInf(String desMsgInf) {
		this.desMsgInf = desMsgInf;
	}

	public String getDesMsgUte() {
		return this.desMsgUte;
	}

	public void setDesMsgUte(String desMsgUte) {
		this.desMsgUte = desMsgUte;
	}

	public String getDesRegVld() {
		return this.desRegVld;
	}

	public void setDesRegVld(String desRegVld) {
		this.desRegVld = desRegVld;
	}

	public String getDesScrRegVld() {
		return this.desScrRegVld;
	}

	public void setDesScrRegVld(String desScrRegVld) {
		this.desScrRegVld = desScrRegVld;
	}

	public String getDesTipDat() {
		return this.desTipDat;
	}

	public void setDesTipDat(String desTipDat) {
		this.desTipDat = desTipDat;
	}

}