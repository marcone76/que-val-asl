package it.istruzione.ossscudig.model.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


@Embeddable
public class Vod1007AssocscuedificiPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="COD_EDI")
	private String codEdi;

	@Column(name="COD_SCU_UT")
	private String codScuUt;

	@Column(name="PER_ANN_SCO")
	private Long perAnnSco;

	public Vod1007AssocscuedificiPK() {
	}

	public String getCodEdi() {
		return this.codEdi;
	}

	public void setCodEdi(String codEdi) {
		this.codEdi = codEdi;
	}

	public String getCodScuUt() {
		return this.codScuUt;
	}

	public void setCodScuUt(String codScuUt) {
		this.codScuUt = codScuUt;
	}

	public Long getPerAnnSco() {
		return this.perAnnSco;
	}

	public void setPerAnnSco(Long perAnnSco) {
		this.perAnnSco = perAnnSco;
	}
	
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Vod1007AssocscuedificiPK)) {
			return false;
		}
		Vod1007AssocscuedificiPK castOther = (Vod1007AssocscuedificiPK)other;
		return 
			this.codEdi.equals(castOther.codEdi)
			&& this.codScuUt.equals(castOther.codScuUt)
			&& (this.perAnnSco == castOther.perAnnSco);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codEdi.hashCode();
		hash = hash * prime + this.codScuUt.hashCode();
		hash = hash * prime + ((int) (this.perAnnSco ^ (this.perAnnSco >>> 32)));
		return hash;
	}

}