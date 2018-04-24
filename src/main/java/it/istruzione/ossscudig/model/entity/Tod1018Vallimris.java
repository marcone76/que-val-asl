package it.istruzione.ossscudig.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the TOD10201_DATSTODWH database table.
 * 
 */
@Entity
@Table(name="TOD1018_VALLIMRIS")
@NamedQuery(name="Tod1018Vallimris.findAll", query="SELECT t FROM Tod1018Vallimris t")
public class Tod1018Vallimris implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id	
	@Column(name="COD_DMD")
	private String codDmd;
	
	@Column(name="COD_QST")
	private String codQst;
	
	@Column(name="PRG_IST_RIL")
	private Long prgIstRil;

	@Column(name="NUM_VAL_MIN")
	private Long numValMin;
	
	@Column(name="NUM_VAL_MAS")
	private Long numValMas;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DAT_ORA_ULT_MOV")
	private Date datOraUltMov;

	@Column(name="COD_PGM_ULT_MOV")
	private String codPgmUltMov;

	@Column(name="COD_UTE_ULT_MOV")
	private String codUteUltMov;

	public String getCodDmd() {
		return codDmd;
	}

	public void setCodDmd(String codDmd) {
		this.codDmd = codDmd;
	}

	public String getCodQst() {
		return codQst;
	}

	public void setCodQst(String codQst) {
		this.codQst = codQst;
	}

	public Long getPrgIstRil() {
		return prgIstRil;
	}

	public void setPrgIstRil(Long prgIstRil) {
		this.prgIstRil = prgIstRil;
	}

	public Long getNumValMin() {
		return numValMin;
	}

	public void setNumValMin(Long numValMin) {
		this.numValMin = numValMin;
	}

	public Long getNumValMas() {
		return numValMas;
	}

	public void setNumValMas(Long numValMas) {
		this.numValMas = numValMas;
	}

	public String getCodPgmUltMov() {
		return codPgmUltMov;
	}

	public void setCodPgmUltMov(String codPgmUltMov) {
		this.codPgmUltMov = codPgmUltMov;
	}

	public String getCodUteUltMov() {
		return codUteUltMov;
	}

	public void setCodUteUltMov(String codUteUltMov) {
		this.codUteUltMov = codUteUltMov;
	}

	public Date getDatOraUltMov() {
		return datOraUltMov;
	}

	public void setDatOraUltMov(Date datOraUltMov) {
		this.datOraUltMov = datOraUltMov;
	}

}