package it.istruzione.ossscudig.model.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the TOD1009_STATOQUESTSCUOLA database table.
 * 
 */
@Embeddable
public class Tod1009StatoquestscuolaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COD_FOR_SCU")
	private String codForScu;

	@Column(name="PRG_IST_RIL")
	private long prgIstRil;

	@Column(name="COD_QST")
	private String codQst;

	public Tod1009StatoquestscuolaPK() {
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
	public String getCodQst() {
		return this.codQst;
	}
	public void setCodQst(String codQst) {
		this.codQst = codQst;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Tod1009StatoquestscuolaPK)) {
			return false;
		}
		Tod1009StatoquestscuolaPK castOther = (Tod1009StatoquestscuolaPK)other;
		return 
			this.codForScu.equals(castOther.codForScu)
			&& (this.prgIstRil == castOther.prgIstRil)
			&& this.codQst.equals(castOther.codQst);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codForScu.hashCode();
		hash = hash * prime + ((int) (this.prgIstRil ^ (this.prgIstRil >>> 32)));
		hash = hash * prime + this.codQst.hashCode();
		
		return hash;
	}
}