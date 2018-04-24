package it.istruzione.ossscudig.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the MFG1029_PROVNUOIST database table.
 * 
 */
@Entity
@Table(name="MFG1029_PROVNUOIST", schema = "", catalog = "")
@NamedQuery(name="Mfg1029Provnuoist.findAll", query="SELECT m FROM Mfg1029Provnuoist m")
public class Mfg1029Provnuoist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COD_PRV")
	private String codPrv;

	@Column(name="COD_IST")
	private BigDecimal codIst;

	@Column(name="COD_IST_MET")
	private String codIstMet;

	@Column(name="COD_PGM_ULT_MOV")
	private String codPgmUltMov;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COD_REG", nullable = false, insertable = false, updatable = false)
	private Twb1012Regione twb1012Regione;

	@Column(name="COD_REG_NAZ")
	private String codRegNaz;

	@Column(name="COD_UTE_ULT_MOV")
	private String codUteUltMov;

	@Temporal(TemporalType.DATE)
	@Column(name="DAT_ORA_ULT_MOV")
	private Date datOraUltMov;

	@Column(name="DES_PRV")
	private String desPrv;

	@Column(name="FLG_CAP_PRV")
	private String flgCapPrv;

	@Column(name="FLG_PTO_PRV_COM")
	private BigDecimal flgPtoPrvCom;
	
	@OneToMany(mappedBy="mfg1029Provnuoist",fetch = FetchType.LAZY)
	@OrderBy("desCom")
	private List<Twb1014Comune> twb1014Comunes;

	public Mfg1029Provnuoist() {
	}

	public String getCodPrv() {
		return this.codPrv;
	}

	public void setCodPrv(String codPrv) {
		this.codPrv = codPrv;
	}

	public BigDecimal getCodIst() {
		return this.codIst;
	}

	public void setCodIst(BigDecimal codIst) {
		this.codIst = codIst;
	}

	public String getCodIstMet() {
		return this.codIstMet;
	}

	public void setCodIstMet(String codIstMet) {
		this.codIstMet = codIstMet;
	}

	public String getCodPgmUltMov() {
		return this.codPgmUltMov;
	}

	public void setCodPgmUltMov(String codPgmUltMov) {
		this.codPgmUltMov = codPgmUltMov;
	}

	public String getCodRegNaz() {
		return this.codRegNaz;
	}

	public void setCodRegNaz(String codRegNaz) {
		this.codRegNaz = codRegNaz;
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

	public String getDesPrv() {
		return this.desPrv;
	}

	public void setDesPrv(String desPrv) {
		this.desPrv = desPrv;
	}

	public String getFlgCapPrv() {
		return this.flgCapPrv;
	}

	public void setFlgCapPrv(String flgCapPrv) {
		this.flgCapPrv = flgCapPrv;
	}

	public BigDecimal getFlgPtoPrvCom() {
		return this.flgPtoPrvCom;
	}

	public void setFlgPtoPrvCom(BigDecimal flgPtoPrvCom) {
		this.flgPtoPrvCom = flgPtoPrvCom;
	}

	public Twb1012Regione getTwb1012Regione() {
		return twb1012Regione;
	}

	public void setTwb1012Regione(Twb1012Regione twb1012Regione) {
		this.twb1012Regione = twb1012Regione;
	}

	public List<Twb1014Comune> getTwb1014Comunes() {
		return twb1014Comunes;
	}

	public void setTwb1014Comunes(List<Twb1014Comune> twb1014Comunes) {
		this.twb1014Comunes = twb1014Comunes;
	}

	
}