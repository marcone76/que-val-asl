package it.istruzione.ossscudig.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PubblicazionePercentualeRecordsEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="DOM_ESC")
	private Long domEsc;
	@Column(name="DOM_TOT")
	private Long domTot;
	@Column(name="PER_DMD")
	private Long perDmd;
	public Long getDomEsc() {
		return domEsc;
	}
	public void setDomEsc(Long domEsc) {
		this.domEsc = domEsc;
	}
	public Long getDomTot() {
		return domTot;
	}
	public void setDomTot(Long domTot) {
		this.domTot = domTot;
	}
	public Long getPerDmd() {
		return perDmd;
	}
	public void setPerDmd(Long perDmd) {
		this.perDmd = perDmd;
	}
	
	
	
	
}
