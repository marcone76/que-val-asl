package it.istruzione.ossscudig.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the TOD1013_GESTPROPRISTANZA database table.
 * 
 */
@Entity
@Table(name="TOD1013_GESTPROPRISTANZA")
@NamedQuery(name="Tod1013Gestpropristanza.findAll", query="SELECT t FROM Tod1013Gestpropristanza t")
public class Tod1013Gestpropristanza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PRG_PRP_IST")
	private Long prgPrpIst;

	@Column(name="COD_PGM_ULT_MOV")
	private String codPgmUltMov;

	@Column(name="COD_PRP_RIL")
	private String codPrpRil;

	@Column(name="COD_UTE_ULT_MOV")
	private String codUteUltMov;

	@Temporal(TemporalType.DATE)
	@Column(name="DAT_ORA_ULT_MOV")
	private Date datOraUltMov;

	@Column(name="DES_PRP_RIL")
	private String desPrpRil;

	//bi-directional many-to-one association to Tod1001Istanzarilevazione
	@ManyToOne
	@JoinColumn(name="PRG_IST_RIL")
	private Tod1001Istanzarilevazione tod1001Istanzarilevazione;

	public Tod1013Gestpropristanza() {
	}

	public Long getPrgPrpIst() {
		return this.prgPrpIst;
	}

	public void setPrgPrpIst(Long prgPrpIst) {
		this.prgPrpIst = prgPrpIst;
	}

	public String getCodPgmUltMov() {
		return this.codPgmUltMov;
	}

	public void setCodPgmUltMov(String codPgmUltMov) {
		this.codPgmUltMov = codPgmUltMov;
	}

	public String getCodPrpRil() {
		return this.codPrpRil;
	}

	public void setCodPrpRil(String codPrpRil) {
		this.codPrpRil = codPrpRil;
	}

	public String getCodUteUltMov() {
		return this.codUteUltMov;
	}

	public void setCodUteUltMov(String codUteUltMov) {
		this.codUteUltMov = codUteUltMov;
	}

	public Date getDatOraUltMov() {
		return this.datOraUltMov;
	}

	public void setDatOraUltMov(Date datOraUltMov) {
		this.datOraUltMov = datOraUltMov;
	}

	public String getDesPrpRil() {
		return this.desPrpRil;
	}

	public void setDesPrpRil(String desPrpRil) {
		this.desPrpRil = desPrpRil;
	}

	public Tod1001Istanzarilevazione getTod1001Istanzarilevazione() {
		return this.tod1001Istanzarilevazione;
	}

	public void setTod1001Istanzarilevazione(Tod1001Istanzarilevazione tod1001Istanzarilevazione) {
		this.tod1001Istanzarilevazione = tod1001Istanzarilevazione;
	}

}