package it.istruzione.ossscudig.model.dto;

import java.math.BigDecimal;

import javax.persistence.Column;

public class PubblicazioneDTO {

	private Long id;
	private Long prgIstRil;	
	private String descQst;
	private String desSez;
	private String codIdeDmd;
	private String codDmd;
	private String desDmd;
	private String minimo;
	private String massimo;
	private String media;
	private BigDecimal numValMin;
	private BigDecimal numValMas;
	private String codForScu;	
	private String desRis;
	private String domEsc;
	private String domTot;
	private String perDmd;
	private String codQuest;
	private String filtroMin;
	private String filtroMas;
	
	
	public String getCodQuest() {
		return codQuest;
	}
	public void setCodQuest(String codQuest) {
		this.codQuest = codQuest;
	}
	public String getDomEsc() {
		return domEsc;
	}
	public void setDomEsc(String domEsc) {
		this.domEsc = domEsc;
	}
	public String getDomTot() {
		return domTot;
	}
	public void setDomTot(String domTot) {
		this.domTot = domTot;
	}
	public String getPerDmd() {
		return perDmd;
	}
	public void setPerDmd(String perDmd) {
		this.perDmd = perDmd;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPrgIstRil() {
		return prgIstRil;
	}
	public void setPrgIstRil(Long prgIstRil) {
		this.prgIstRil = prgIstRil;
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
	public BigDecimal getNumValMin() {
		return numValMin;
	}
	public void setNumValMin(BigDecimal numValMin) {
		this.numValMin = numValMin;
	}
	public BigDecimal getNumValMas() {
		return numValMas;
	}
	public void setNumValMas(BigDecimal numValMas) {
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
	public String getFiltroMin() {
		return filtroMin;
	}
	public void setFiltroMin(String filtroMin) {
		this.filtroMin = filtroMin;
	}
	public String getFiltroMas() {
		return filtroMas;
	}
	public void setFiltroMas(String filtroMas) {
		this.filtroMas = filtroMas;
	}
	
		
}
