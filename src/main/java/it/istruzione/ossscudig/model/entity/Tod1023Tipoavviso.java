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
 * The persistent class for the TOD1023_TIPOAVVISO database table.
 * 
 */
@Entity
@Table(name="TOD1023_TIPOAVVISO")
@NamedQuery(name="Tod1023Tipoavviso.findAll", query="SELECT t FROM Tod1023Tipoavviso t")
public class Tod1023Tipoavviso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COD_TIP_AVV")
	private String codTipAvv;

	@Column(name="DES_TIP_AVV")
	private String desTipAvv;
	
	@Column(name="COD_AVV")
	private String codAvv;

	@Column(name="COD_PGM_ULT_MOV")
	private String codPgmUltMov;

	@Column(name="COD_UTE_ULT_MOV")
	private String codUteUltMov;

	@Temporal(TemporalType.DATE)
	@Column(name="DAT_ORA_ULT_MOV")
	private Date datOraUltMov;

	public String getCodTipAvv() {
		return codTipAvv;
	}

	public void setCodTipAvv(String codTipAvv) {
		this.codTipAvv = codTipAvv;
	}

	public String getDesTipAvv() {
		return desTipAvv;
	}

	public void setDesTipAvv(String desTipAvv) {
		this.desTipAvv = desTipAvv;
	}

	public String getCodAvv() {
		return codAvv;
	}

	public void setCodAvv(String codAvv) {
		this.codAvv = codAvv;
	}

	public String getCodPgmUltMov() {
		return codPgmUltMov;
	}

	public void setCodPgmUltMov(String codPgmUltMov) {
		this.codPgmUltMov = codPgmUltMov;
	}

	public String getCodUteUltMov() {
		return codUteUltMov;
	}

	public void setCodUteUltMov(String codUteUltMov) {
		this.codUteUltMov = codUteUltMov;
	}

	public Date getDatOraUltMov() {
		return datOraUltMov;
	}

	public void setDatOraUltMov(Date datOraUltMov) {
		this.datOraUltMov = datOraUltMov;
	}


}