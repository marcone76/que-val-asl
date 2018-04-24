package it.istruzione.ossscudig.model.entity;

import java.io.Serializable;
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
 * The persistent class for the TOD1004_ANAGRAFEDOMANDA database table.
 * 
 */
@Entity
@Table(name="TOD1004_ANAGRAFEDOMANDA")
@NamedQuery(name="Tod1004Anagrafedomanda.findAll", query="SELECT t FROM Tod1004Anagrafedomanda t")
public class Tod1004Anagrafedomanda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COD_DMD")
	private String codDmd;

	@Column(name="COD_IDE_DMD")
	private String codIdeDmd;

	@Column(name="COD_PGM_ULT_MOV")
	private String codPgmUltMov;

	@Column(name="COD_UTE_ULT_MOV")
	private String codUteUltMov;

	@Temporal(TemporalType.DATE)
	@Column(name="DAT_ORA_ULT_MOV")
	private Date datOraUltMov;

	@Column(name="DES_DMD")
	private String desDmd;

	@Column(name="FLG_OBB")
	private String flgObb;

	@Column(name="FLG_VIS")
	private String flgVis;

	@Column(name="NUM_ORD_DMD")
	private Integer numOrdDmd;

	//bi-directional many-to-one association to Tod1003Anagrafesezione
	@ManyToOne
	@JoinColumn(name="COD_SEZ")
	private Tod1003Anagrafesezione tod1003Anagrafesezione;

	//bi-directional many-to-one association to Tod1005Tipodomanda
	@ManyToOne
	@JoinColumn(name="COD_TIP_DMD")
	private Tod1005Tipodomanda tod1005Tipodomanda;

	//bi-directional many-to-one association to Tod1006Regolevalidazione
	@ManyToOne
	@JoinColumn(name="PRG_REG_VLD")
	private Tod1006Regolevalidazione tod1006Regolevalidazione;

	//bi-directional many-to-one association to Tod1011Gruppovoce
	@ManyToOne
	@JoinColumn(name="PRG_GRP_VOC")
	private Tod1011Gruppovoce tod1011Gruppovoce;
	
	



	public Tod1004Anagrafedomanda() {
	}

	public String getCodDmd() {
		return this.codDmd;
	}

	public void setCodDmd(String codDmd) {
		this.codDmd = codDmd;
	}

	public String getCodIdeDmd() {
		return this.codIdeDmd;
	}

	public void setCodIdeDmd(String codIdeDmd) {
		this.codIdeDmd = codIdeDmd;
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

	public String getDesDmd() {
		return this.desDmd;
	}

	public void setDesDmd(String desDmd) {
		this.desDmd = desDmd;
	}

	public String getFlgObb() {
		return this.flgObb;
	}

	public void setFlgObb(String flgObb) {
		this.flgObb = flgObb;
	}

	public String getFlgVis() {
		return this.flgVis;
	}

	public void setFlgVis(String flgVis) {
		this.flgVis = flgVis;
	}

	public Integer getNumOrdDmd() {
		return this.numOrdDmd;
	}

	public void setNumOrdDmd(Integer numOrdDmd) {
		this.numOrdDmd = numOrdDmd;
	}

	public Tod1003Anagrafesezione getTod1003Anagrafesezione() {
		return this.tod1003Anagrafesezione;
	}

	public void setTod1003Anagrafesezione(Tod1003Anagrafesezione tod1003Anagrafesezione) {
		this.tod1003Anagrafesezione = tod1003Anagrafesezione;
	}

	public Tod1005Tipodomanda getTod1005Tipodomanda() {
		return this.tod1005Tipodomanda;
	}

	public void setTod1005Tipodomanda(Tod1005Tipodomanda tod1005Tipodomanda) {
		this.tod1005Tipodomanda = tod1005Tipodomanda;
	}

	public Tod1006Regolevalidazione getTod1006Regolevalidazione() {
		return this.tod1006Regolevalidazione;
	}

	public void setTod1006Regolevalidazione(Tod1006Regolevalidazione tod1006Regolevalidazione) {
		this.tod1006Regolevalidazione = tod1006Regolevalidazione;
	}

	public Tod1011Gruppovoce getTod1011Gruppovoce() {
		return this.tod1011Gruppovoce;
	}

	public void setTod1011Gruppovoce(Tod1011Gruppovoce tod1011Gruppovoce) {
		this.tod1011Gruppovoce = tod1011Gruppovoce;
	}

}