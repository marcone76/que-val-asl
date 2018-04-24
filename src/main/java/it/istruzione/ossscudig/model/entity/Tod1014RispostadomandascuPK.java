package it.istruzione.ossscudig.model.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the TOD1014_RISPOSTADOMANDASCU database table.
 * 
 */
@Embeddable
public class Tod1014RispostadomandascuPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COD_FOR_SCU")
	private String codForScu;

	@Column(name="PRG_IST_RIL")
	private long prgIstRil;

	@Column(name="COD_DMD")
	private String codDmd;
	
	@Column(name="COD_QST")
	private String codQst;

	@Column(name="PRG_RIS_DMD_SCU")
	private long prgRisDmdScu;

	@Column(name="COD_EDI")
	private String codEdi;

	public Tod1014RispostadomandascuPK() {
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
	public String getCodDmd() {
		return this.codDmd;
	}
	public void setCodDmd(String codDmd) {
		this.codDmd = codDmd;
	}
	public long getPrgRisDmdScu() {
		return this.prgRisDmdScu;
	}
	public void setPrgRisDmdScu(long prgRisDmdScu) {
		this.prgRisDmdScu = prgRisDmdScu;
	}
	public String getCodEdi() {
		return this.codEdi;
	}
	public void setCodEdi(String codEdi) {
		this.codEdi = codEdi;
	}
	public String getCodQst() {
		return codQst;
	}
	public void setCodQst(String codQst) {
		this.codQst = codQst;
	}
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Tod1014RispostadomandascuPK)) {
			return false;
		}
		Tod1014RispostadomandascuPK castOther = (Tod1014RispostadomandascuPK)other;
		return 
			this.codForScu.equals(castOther.codForScu)
			&& (this.prgIstRil == castOther.prgIstRil)
			&& this.codDmd.equals(castOther.codDmd)
			&& this.codQst.equals(castOther.codQst)
			&& (this.prgRisDmdScu == castOther.prgRisDmdScu)
			&& this.codEdi.equals(castOther.codEdi);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codForScu.hashCode();
		hash = hash * prime + ((int) (this.prgIstRil ^ (this.prgIstRil >>> 32)));
		hash = hash * prime + this.codDmd.hashCode();
		hash = hash * prime + this.codQst.hashCode();
		hash = hash * prime + ((int) (this.prgRisDmdScu ^ (this.prgRisDmdScu >>> 32)));
		hash = hash * prime + this.codEdi.hashCode();
		
		return hash;
	}
}