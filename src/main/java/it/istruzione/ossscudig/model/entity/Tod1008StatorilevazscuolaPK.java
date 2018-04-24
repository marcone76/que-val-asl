package it.istruzione.ossscudig.model.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the TOD1008_STATORILEVAZSCUOLA database table.
 * 
 */
@Embeddable
public class Tod1008StatorilevazscuolaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COD_FOR_SCU")
	private String codForScu;

	@Column(name="PRG_IST_RIL")
	private long prgIstRil;

	public Tod1008StatorilevazscuolaPK() {
	}
	public String getCodForScu() {
		return this.codForScu;
	}
	public void setCodForScu(String codForScu) {
		this.codForScu = codForScu;
	}
	public long getPrgIstRil() {
		return this.prgIstRil;
	}
	public void setPrgIstRil(long prgIstRil) {
		this.prgIstRil = prgIstRil;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Tod1008StatorilevazscuolaPK)) {
			return false;
		}
		Tod1008StatorilevazscuolaPK castOther = (Tod1008StatorilevazscuolaPK)other;
		return 
			this.codForScu.equals(castOther.codForScu)
			&& (this.prgIstRil == castOther.prgIstRil);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codForScu.hashCode();
		hash = hash * prime + ((int) (this.prgIstRil ^ (this.prgIstRil >>> 32)));
		
		return hash;
	}
}