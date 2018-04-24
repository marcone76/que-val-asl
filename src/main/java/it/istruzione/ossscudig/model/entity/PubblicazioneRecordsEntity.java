package it.istruzione.ossscudig.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PubblicazioneRecordsEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="COD_FOR_SCU")
	private String codForScu;	
	@Column(name="COD_IDE_DMD")
	private String codIdeDmd;
	@Column(name="DES_DMD")
	private String desDmd;
	@Column(name="DES_RIS")
	private String desRis;
	
	
	
	public String getCodForScu() {
		return codForScu;
	}
	public void setCodForScu(String codForScu) {
		this.codForScu = codForScu;
	}
	public String getCodIdeDmd() {
		return codIdeDmd;
	}
	public void setCodIdeDmd(String codIdeDmd) {
		this.codIdeDmd = codIdeDmd;
	}
	public String getDesDmd() {
		return desDmd;
	}
	public void setDesDmd(String desDmd) {
		this.desDmd = desDmd;
	}
	public String getDesRis() {
		return desRis;
	}
	public void setDesRis(String desRis) {
		this.desRis = desRis;
	}
	
	
	
	
}
