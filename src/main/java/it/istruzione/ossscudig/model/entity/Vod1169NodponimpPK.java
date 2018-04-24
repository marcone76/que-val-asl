package it.istruzione.ossscudig.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Vod1169NodponimpPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="COD_FOR_IST_PRI")
	private String codForIstPri;

	@Column(name="COD_SOT_AZI")
	private String codSotAzi;

	public Vod1169NodponimpPK() {
	}

	public String getCodForIstPri() {
		return this.codForIstPri;
	}

	public void setCodForIstPri(String codForIstPri) {
		this.codForIstPri = codForIstPri;
	}

	public String getCodSotAzi() {
		return this.codSotAzi;
	}

	public void setCodSotAzi(String codSotAzi) {
		this.codSotAzi = codSotAzi;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Vod1169NodponimpPK)) {
			return false;
		}
		Vod1169NodponimpPK castOther = (Vod1169NodponimpPK)other;
		return 
			this.codForIstPri.equals(castOther.codForIstPri)
			&& this.codSotAzi.equals(castOther.codSotAzi);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codForIstPri.hashCode();
		hash = hash * prime + this.codSotAzi.hashCode();
		return hash;
	}

}