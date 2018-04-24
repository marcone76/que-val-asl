package it.istruzione.ossscudig.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the TOD1017_OTRISPOSTEVECRILEVAZ database table.
 * 
 */
@Entity
@Table(name="TOD1017_OTRISPOSTEVECRILEVAZ")
@NamedQuery(name="Tod1017Otrispostevecrilevaz.findAll", query="SELECT t FROM Tod1017Otrispostevecrilevaz t")
public class Tod1017Otrispostevecrilevaz implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private Tod1017OtrispostevecrilevazPK id;
	
	@Column(name="COD_PGM_ULT_MOV")
	private String codPgmUltMov;

	@Column(name="COD_UTE_ULT_MOV")
	private String codUteUltMov;

	@Temporal(TemporalType.DATE)
	@Column(name="DAT_ORA_ULT_MOV")
	private Date datOraUltMov;

	@Column(name="DES_RIS_OST")
	private String desRisOst;

	public Tod1017Otrispostevecrilevaz() {
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

	public String getDesRisOst() {
		return this.desRisOst;
	}

	public void setDesRisOst(String desRisOst) {
		this.desRisOst = desRisOst;
	}

	public Tod1017OtrispostevecrilevazPK getId() {
		return id;
	}

	public void setId(Tod1017OtrispostevecrilevazPK id) {
		this.id = id;
	}

}