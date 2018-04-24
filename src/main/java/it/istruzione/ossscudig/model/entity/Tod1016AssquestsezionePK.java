package it.istruzione.ossscudig.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Tod1016AssquestsezionePK implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="COD_QST")
	private String codQst;

	@Column(name="COD_SEZ")
	private String codSez;
	
	public Tod1016AssquestsezionePK() {
	}

	public String getCodQst() {
		return codQst;
	}

	public void setCodQst(String codQst) {
		this.codQst = codQst;
	}

	public String getCodSez() {
		return codSez;
	}

	public void setCodSez(String codSez) {
		this.codSez = codSez;
	}
	
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Tod1016AssquestsezionePK)) {
			return false;
		}
		Tod1016AssquestsezionePK castOther = (Tod1016AssquestsezionePK)other;
		return 
			this.codQst.equals(castOther.codQst)
			&& (this.codSez == castOther.codSez);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codQst.hashCode();
		hash = hash * prime + this.codSez.hashCode();
		return hash;
	}

}
