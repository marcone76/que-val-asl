package it.istruzione.ossscudig.model.entity;

import java.io.Serializable;
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
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the TOD1003_ANAGRAFESEZIONE database table.
 * 
 */
@Entity
@Table(name="TOD1003_ANAGRAFESEZIONE")
@NamedQuery(name="Tod1003Anagrafesezione.findAll", query="SELECT t FROM Tod1003Anagrafesezione t")
public class Tod1003Anagrafesezione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COD_SEZ")
	private String codSez;

	@Column(name="COD_PGM_ULT_MOV")
	private String codPgmUltMov;
	
	@Column(name="COD_UTE_ULT_MOV")
	private String codUteUltMov;

	@Temporal(TemporalType.DATE)
	@Column(name="DAT_ORA_ULT_MOV")
	private Date datOraUltMov;

	@Column(name="DES_SEZ")
	private String desSez;


	//bi-directional many-to-one association to Tod1003Anagrafesezione
	@ManyToOne
	@JoinColumn(name="COD_SEZ_PDR")
	private Tod1003Anagrafesezione tod1003AnagrafesezionePadre;

	//bi-directional many-to-one association to Tod1003Anagrafesezione
	@OneToMany(mappedBy="tod1003AnagrafesezionePadre",fetch = FetchType.LAZY)
	private List<Tod1003Anagrafesezione> tod1003AnagrafesezioneFigli;

	//bi-directional many-to-one association to Tod1004Anagrafedomanda
	@OneToMany(mappedBy="tod1003Anagrafesezione",fetch = FetchType.EAGER)
	@OrderColumn(name="NUM_ORD_DMD")
	private List<Tod1004Anagrafedomanda> tod1004Anagrafedomandas;

	public Tod1003Anagrafesezione() {
	}

	public String getCodSez() {
		return this.codSez;
	}

	public void setCodSez(String codSez) {
		this.codSez = codSez;
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

	public String getDesSez() {
		return this.desSez;
	}

	public void setDesSez(String desSez) {
		this.desSez = desSez;
	}

	public Tod1003Anagrafesezione getTod1003AnagrafesezionePadre() {
		return this.tod1003AnagrafesezionePadre;
	}

	public void setTod1003AnagrafesezionePadre(Tod1003Anagrafesezione tod1003AnagrafesezionePadre) {
		this.tod1003AnagrafesezionePadre = tod1003AnagrafesezionePadre;
	}

	public List<Tod1003Anagrafesezione> getTod1003AnagrafesezioneFigli() {
		return this.tod1003AnagrafesezioneFigli;
	}

	public void setTod1003AnagrafesezioneFigli(List<Tod1003Anagrafesezione> tod1003AnagrafesezioneFigli) {
		this.tod1003AnagrafesezioneFigli = tod1003AnagrafesezioneFigli;
	}

	public List<Tod1004Anagrafedomanda> getTod1004Anagrafedomandas() {
		return this.tod1004Anagrafedomandas;
	}

	public void setTod1004Anagrafedomandas(List<Tod1004Anagrafedomanda> tod1004Anagrafedomandas) {
		this.tod1004Anagrafedomandas = tod1004Anagrafedomandas;
	}

	public Tod1004Anagrafedomanda addTod1004Anagrafedomanda(Tod1004Anagrafedomanda tod1004Anagrafedomanda) {
		getTod1004Anagrafedomandas().add(tod1004Anagrafedomanda);
		tod1004Anagrafedomanda.setTod1003Anagrafesezione(this);

		return tod1004Anagrafedomanda;
	}

	public Tod1004Anagrafedomanda removeTod1004Anagrafedomanda(Tod1004Anagrafedomanda tod1004Anagrafedomanda) {
		getTod1004Anagrafedomandas().remove(tod1004Anagrafedomanda);
		tod1004Anagrafedomanda.setTod1003Anagrafesezione(null);

		return tod1004Anagrafedomanda;
	}


}