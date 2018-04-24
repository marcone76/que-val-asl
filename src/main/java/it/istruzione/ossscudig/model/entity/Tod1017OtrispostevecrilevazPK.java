package it.istruzione.ossscudig.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Tod1017OtrispostevecrilevazPK implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="COD_FOR_SCU")
	private String codForScu;

	@Column(name="COD_IDE_DMD")
	private String codIdeDmd;
	
	public Tod1017OtrispostevecrilevazPK() {
	}
	
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
	
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Tod1017OtrispostevecrilevazPK)) {
			return false;
		}
		Tod1017OtrispostevecrilevazPK castOther = (Tod1017OtrispostevecrilevazPK)other;
		return 
			this.codForScu.equals(castOther.codForScu)
			&& (this.codIdeDmd == castOther.codIdeDmd);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codForScu.hashCode();
		hash = hash * prime + this.codIdeDmd.hashCode();
		return hash;
	}

}
