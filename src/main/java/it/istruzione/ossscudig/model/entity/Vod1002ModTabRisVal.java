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
@Table(name="UODOSSDIG_OWN.VOD1002_MODTABRISVAL")
@NamedQuery(name="Vod1002ModTabRisVal.findAll", query="SELECT v FROM Vod1002ModTabRisVal v")
public class Vod1002ModTabRisVal implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private Vod1002ModTabRisValPK id;
	
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

	public final Vod1002ModTabRisValPK getId() {
		return id;
	}

	public final void setId(Vod1002ModTabRisValPK id) {
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