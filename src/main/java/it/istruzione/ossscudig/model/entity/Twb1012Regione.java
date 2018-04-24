package it.istruzione.ossscudig.model.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the MFG1012_REGIONE database table.
 * 
 */
@Entity
@Table(name="TWB1012_REGIONE", schema = "", catalog = "")
@NamedQuery(name="Twb1012Regione.findAll", query="SELECT m FROM Twb1012Regione m")
public class Twb1012Regione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COD_REG")
	private String codReg;

	@Column(name="COD_CIT")
	private String codCit;

	@Column(name="COD_PGM_ULT_MOV")
	private String codPgmUltMov;

	@Column(name="COD_UTE_ULT_MOV")
	private String codUteUltMov;

	@Temporal(TemporalType.DATE)
	@Column(name="DAT_ORA_ULT_MOV")
	private Date datOraUltMov;

	@Column(name="DES_REG")
	private String desReg;
	
	@OneToMany(mappedBy="twb1012Regione",fetch = FetchType.LAZY)
	@OrderBy("desPrv")
	private List<Mfg1029Provnuoist> mfg1029Provnuoists;

	public Twb1012Regione() {
	}

	public String getCodReg() {
		return this.codReg;
	}

	public void setCodReg(String codReg) {
		this.codReg = codReg;
	}


	public String getCodCit() {
		return this.codCit;
	}

	public void setCodCit(String codCit) {
		this.codCit = codCit;
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

	public String getDesReg() {
		return this.desReg;
	}

	public void setDesReg(String desReg) {
		this.desReg = desReg;
	}

	public List<Mfg1029Provnuoist> getMfg1029Provnuoists() {
		return mfg1029Provnuoists;
	}

	public void setMfg1029Provnuoists(List<Mfg1029Provnuoist> mfg1029Provnuoists) {
		this.mfg1029Provnuoists = mfg1029Provnuoists;
	}

}