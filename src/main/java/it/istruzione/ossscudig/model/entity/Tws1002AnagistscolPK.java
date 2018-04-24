package it.istruzione.ossscudig.model.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the TWS1002_ANAGISTSCOL database table.
 * 
 */
@Embeddable
public class Tws1002AnagistscolPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COD_SCU_UT")
	private String codScuUt;

	@Column(name="DAT_ANN_SCO_RIL")
	private Long datAnnScoRil;

	public Tws1002AnagistscolPK() {
	}
	public String getCodScuUt() {
		return this.codScuUt;
	}
	public void setCodScuUt(String codScuUt) {
		this.codScuUt = codScuUt;
	}
	public Long getDatAnnScoRil() {
		return this.datAnnScoRil;
	}
	public void setDatAnnScoRil(Long datAnnScoRil) {
		this.datAnnScoRil = datAnnScoRil;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Tws1002AnagistscolPK)) {
			return false;
		}
		Tws1002AnagistscolPK castOther = (Tws1002AnagistscolPK)other;
		return 
			this.codScuUt.equals(castOther.codScuUt)
			&& (this.datAnnScoRil == castOther.datAnnScoRil);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codScuUt.hashCode();
		hash = hash * prime + ((int) (this.datAnnScoRil ^ (this.datAnnScoRil >>> 32)));
		
		return hash;
	}
}