package it.istruzione.ossscudig.model.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class Vod1002ModTabRisValPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="COD_EDI")
	private String codEdi;

	@Column(name="COD_FOR_SCU")
	private String codForScu;

	@Column(name="PRG_IST_RIL")
	private Long prgIstRil;

	@Column(name="COD_IDE_DMD")
	private String codIdeDmd;
	
	public Vod1002ModTabRisValPK() {
	}
	
	public final String getCodIdeDmd() {
		return codIdeDmd;
	}

	public final void setCodIdeDmd(String codIdeDmd) {
		this.codIdeDmd = codIdeDmd;
	}

	public final String getCodEdi() {
		return codEdi;
	}

	public final void setCodEdi(String codEdi) {
		this.codEdi = codEdi;
	}

	public final String getCodForScu() {
		return codForScu;
	}

	public final void setCodForScu(String codForScu) {
		this.codForScu = codForScu;
	}

	public final Long getPrgIstRil() {
		return prgIstRil;
	}

	public final void setPrgIstRil(Long prgIstRil) {
		this.prgIstRil = prgIstRil;
	}

	public static final long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Vod1002ModTabRisValPK)) {
			return false;
		}
		Vod1002ModTabRisValPK castOther = (Vod1002ModTabRisValPK)other;
		return 
			this.codEdi.equals(castOther.codEdi)
			&& this.codForScu.equals(castOther.codForScu)
			&& (this.prgIstRil == castOther.prgIstRil)
			&& (this.codIdeDmd == castOther.codIdeDmd)
			;
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codEdi.hashCode();
		hash = hash * prime + this.codForScu.hashCode();
		hash = hash * prime + this.codIdeDmd.hashCode();
		hash = hash * prime + ((int) (this.prgIstRil ^ (this.prgIstRil >>> 32)));
		return hash;
	}

}