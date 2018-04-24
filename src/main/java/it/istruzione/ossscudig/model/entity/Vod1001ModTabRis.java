package it.istruzione.ossscudig.model.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the VOD1001_MODTABRIS database table.
 * 
 */
@Entity
@Table(name="UODOSSDIG_OWN.VOD1001_MODTABRIS")
@NamedQuery(name="Vod1001ModTabBris.findAll", query="SELECT v FROM Vod1001ModTabRis v")
public class Vod1001ModTabRis implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private Vod1001ModTabRisPK id;
	
	@Column(name="COD_TIP_DMD")
	private String codTipDmd;
	
	@Column(name="DES_DMD")
	private String desDmd;
	
	@Column(name="COD_QST")
	private String codQst;
	
	@Column(name="DES_QST")
	private String desQst;
	
	@Column(name="COD_SEZ")
	private String codSez;
	
	@Column(name="DES_SEZ")
	private String desSez;
	
	@Column(name="DES_RISS")
	private String desRiss;
	
	@Column(name="VAL_RISPP")
	private String valRispp;

	public final Vod1001ModTabRisPK getId() {
		return id;
	}

	public final void setId(Vod1001ModTabRisPK id) {
		this.id = id;
	}

	public final String getCodTipDmd() {
		return codTipDmd;
	}

	public final void setCodTipDmd(String codTipDmd) {
		this.codTipDmd = codTipDmd;
	}

	public final String getDesDmd() {
		return desDmd;
	}

	public final void setDesDmd(String desDmd) {
		this.desDmd = desDmd;
	}

	public final String getCodQst() {
		return codQst;
	}

	public final void setCodQst(String codQst) {
		this.codQst = codQst;
	}

	public final String getDesQst() {
		return desQst;
	}

	public final void setDesQst(String desQst) {
		this.desQst = desQst;
	}

	public final String getCodSez() {
		return codSez;
	}

	public final void setCodSez(String codSez) {
		this.codSez = codSez;
	}

	public final String getDesSez() {
		return desSez;
	}

	public final void setDesSez(String desSez) {
		this.desSez = desSez;
	}

	public final String getDesRiss() {
		return desRiss;
	}

	public final void setDesRiss(String desRiss) {
		this.desRiss = desRiss;
	}

	public final String getValRispp() {
		return valRispp;
	}

	public final void setValRispp(String valRispp) {
		this.valRispp = valRispp;
	}

	public static final long getSerialversionuid() {
		return serialVersionUID;
	}
	

}