package it.istruzione.ossscudig.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the TOD1011_GRUPPOVOCE database table.
 * 
 */
@Entity
@Table(name="TOD1011_GRUPPOVOCE")
@NamedQuery(name="Tod1011Gruppovoce.findAll", query="SELECT t FROM Tod1011Gruppovoce t")
public class Tod1011Gruppovoce implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PRG_GRP_VOC")
	private long prgGrpVoc;

	@Column(name="COD_PGM_ULT_MOV")
	private String codPgmUltMov;

	@Column(name="COD_UTE_ULT_MOV")
	private String codUteUltMov;

	@Temporal(TemporalType.DATE)
	@Column(name="DAT_ORA_ULT_MOV")
	private Date datOraUltMov;

	@Column(name="DES_GRP_VOC")
	private String desGrpVoc;

	@Column(name="DES_GRP_VOC_BRE")
	private String desGrpVocBre;

	//bi-directional many-to-one association to Tod1012Anagrafevoce
	@OneToMany(mappedBy="tod1011Gruppovoce",fetch = FetchType.EAGER)
	@OrderColumn(name="NUM_ORD_VOC")
	private List<Tod1012Anagrafevoce> tod1012Anagrafevoces;

	public Tod1011Gruppovoce() {
	}

	public long getPrgGrpVoc() {
		return this.prgGrpVoc;
	}

	public void setPrgGrpVoc(long prgGrpVoc) {
		this.prgGrpVoc = prgGrpVoc;
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

	public String getDesGrpVoc() {
		return this.desGrpVoc;
	}

	public void setDesGrpVoc(String desGrpVoc) {
		this.desGrpVoc = desGrpVoc;
	}

	public String getDesGrpVocBre() {
		return this.desGrpVocBre;
	}

	public void setDesGrpVocBre(String desGrpVocBre) {
		this.desGrpVocBre = desGrpVocBre;
	}

	public List<Tod1012Anagrafevoce> getTod1012Anagrafevoces() {
		return this.tod1012Anagrafevoces;
	}

	public void setTod1012Anagrafevoces(List<Tod1012Anagrafevoce> tod1012Anagrafevoces) {
		this.tod1012Anagrafevoces = tod1012Anagrafevoces;
	}

	public Tod1012Anagrafevoce addTod1012Anagrafevoce(Tod1012Anagrafevoce tod1012Anagrafevoce) {
		getTod1012Anagrafevoces().add(tod1012Anagrafevoce);
		tod1012Anagrafevoce.setTod1011Gruppovoce(this);

		return tod1012Anagrafevoce;
	}

	public Tod1012Anagrafevoce removeTod1012Anagrafevoce(Tod1012Anagrafevoce tod1012Anagrafevoce) {
		getTod1012Anagrafevoces().remove(tod1012Anagrafevoce);
		tod1012Anagrafevoce.setTod1011Gruppovoce(null);

		return tod1012Anagrafevoce;
	}

}