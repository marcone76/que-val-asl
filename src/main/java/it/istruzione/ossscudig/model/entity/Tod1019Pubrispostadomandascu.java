package it.istruzione.ossscudig.model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the TOD1019_PUBRISPOSTADOMANDASCU database table.
 * 
 */
@Entity
@Table(name="TOD1019_PUBRISPOSTADOMANDASCU")
@NamedQuery(name="Tod1019Pubrispostadomandascu.findAll", query="SELECT t FROM Tod1019Pubrispostadomandascu t")
public class Tod1019Pubrispostadomandascu implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private Tod1019PubrispostadomandascuPK id;

	@Column(name="COD_PGM_ULT_MOV")
	private String codPgmUltMov;

	@Column(name="COD_UTE_ULT_MOV")
	private String codUteUltMov;

	@Temporal(TemporalType.DATE)
	@Column(name="DAT_ORA_ULT_MOV")
	private Date datOraUltMov;

	@Column(name="DES_PRI_RIS")
	private String desPriRis;

	@Column(name="DES_RIS")
	private String desRis;

	@Column(name="DES_SEC_RIS")
	private String desSecRis;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DAT_PUB_RIS")
	private Date datPubRis;

	//bi-directional many-to-one association to Tod1001Istanzarilevazione
	@ManyToOne
	@JoinColumn(name="PRG_IST_RIL", insertable=false, updatable=false)
	private Tod1001Istanzarilevazione tod1001Istanzarilevazione;

	public Tod1019Pubrispostadomandascu() {
	}

	public Tod1019PubrispostadomandascuPK getId() {
		return this.id;
	}

	public void setId(Tod1019PubrispostadomandascuPK id) {
		this.id = id;
	}

	public String getCodPgmUltMov() {
		return this.codPgmUltMov;
	}

	public void setCodPgmUltMov(String codPgmUltMov) {
		this.codPgmUltMov = codPgmUltMov;
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

	public String getDesPriRis() {
		return this.desPriRis;
	}

	public void setDesPriRis(String desPriRis) {
		this.desPriRis = desPriRis;
	}

	public String getDesRis() {
		return this.desRis;
	}

	public void setDesRis(String desRis) {
		this.desRis = desRis;
	}

	public String getDesSecRis() {
		return this.desSecRis;
	}

	public void setDesSecRis(String desSecRis) {
		this.desSecRis = desSecRis;
	}

	public Tod1001Istanzarilevazione getTod1001Istanzarilevazione() {
		return this.tod1001Istanzarilevazione;
	}

	public void setTod1001Istanzarilevazione(Tod1001Istanzarilevazione tod1001Istanzarilevazione) {
		this.tod1001Istanzarilevazione = tod1001Istanzarilevazione;
	}

	public Date getDatPubRis() {
		return datPubRis;
	}

	public void setDatPubRis(Date datPubRis) {
		this.datPubRis = datPubRis;
	}
	
}