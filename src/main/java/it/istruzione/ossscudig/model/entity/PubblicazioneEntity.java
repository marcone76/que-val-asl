package it.istruzione.ossscudig.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PubblicazioneEntity implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	private Long id;
	@Column(name="DES_QST")
	private String descQst;
	@Column(name="DES_SEZ")
	private String desSez;
	@Column(name="COD_IDE_DMD")
	private String codIdeDmd;
	@Column(name="COD_DMD")
	private String codDmd;
	@Column(name="DES_DMD")
	private String desDmd;
	@Column(name="MINIMO")
	private String minimo;
	@Column(name="MASSIMO")
	private String massimo;
	@Column(name="MEDIA")
	private String media;
	@Column(name="NUM_VAL_MIN")
	private Long numValMin;
	@Column(name="NUM_VAL_MAS")
	private Long numValMas;
	@Column(name="COD_FOR_SCU")
	private String codForScu;	
	@Column(name="DES_RIS")
	private String desRis;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescQst() {
		return descQst;
	}
	public void setDescQst(String descQst) {
		this.descQst = descQst;
	}
	public String getDesSez() {
		return desSez;
	}
	public void setDesSez(String desSez) {
		this.desSez = desSez;
	}
	public String getCodIdeDmd() {
		return codIdeDmd;
	}
	public void setCodIdeDmd(String codIdeDmd) {
		this.codIdeDmd = codIdeDmd;
	}
	public String getCodDmd() {
		return codDmd;
	}
	public void setCodDmd(String codDmd) {
		this.codDmd = codDmd;
	}
	public String getDesDmd() {
		return desDmd;
	}
	public void setDesDmd(String desDmd) {
		this.desDmd = desDmd;
	}
	public String getMinimo() {
		return minimo;
	}
	public void setMinimo(String minimo) {
		this.minimo = minimo;
	}
	public String getMassimo() {
		return massimo;
	}
	public void setMassimo(String massimo) {
		this.massimo = massimo;
	}
	public String getMedia() {
		return media;
	}
	public void setMedia(String media) {
		this.media = media;
	}
	public Long getNumValMin() {
		return numValMin;
	}
	public void setNumValMin(Long numValMin) {
		this.numValMin = numValMin;
	}
	public Long getNumValMas() {
		return numValMas;
	}
	public void setNumValMas(Long numValMas) {
		this.numValMas = numValMas;
	}
	public String getCodForScu() {
		return codForScu;
	}
	public void setCodForScu(String codForScu) {
		this.codForScu = codForScu;
	}
	public String getDesRis() {
		return desRis;
	}
	public void setDesRis(String desRis) {
		this.desRis = desRis;
	}
	
	
}
