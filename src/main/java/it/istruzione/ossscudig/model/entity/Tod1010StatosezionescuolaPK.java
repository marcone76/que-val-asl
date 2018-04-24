package it.istruzione.ossscudig.model.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the TOD1010_STATOSEZIONESCUOLA database table.
 * 
 */
@Embeddable
public class Tod1010StatosezionescuolaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COD_FOR_SCU")
	private String codForScu;

	@Column(name="PRG_IST_RIL")
	private long prgIstRil;

	@Column(name="COD_QST")
	private String codQst;

	@Column(name="COD_SEZ")
	private String codSez;

	public Tod1010StatosezionescuolaPK() {
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
	public String getCodSez() {
		return this.codSez;
	}
	public void setCodSez(String codSez) {
		this.codSez = codSez;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Tod1010StatosezionescuolaPK)) {
			return false;
		}
		Tod1010StatosezionescuolaPK castOther = (Tod1010StatosezionescuolaPK)other;
		return 
			this.codForScu.equals(castOther.codForScu)
			&& (this.prgIstRil == castOther.prgIstRil)
			&& this.codQst.equals(castOther.codQst)
			&& this.codSez.equals(castOther.codSez);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codForScu.hashCode();
		hash = hash * prime + ((int) (this.prgIstRil ^ (this.prgIstRil >>> 32)));
		hash = hash * prime + this.codQst.hashCode();
		hash = hash * prime + this.codSez.hashCode();
		
		return hash;
	}
}