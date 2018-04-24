package it.istruzione.ossscudig.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the TOD1013_GESTPROPRISTANZA database table.
 * 
 */
/**
 * @author admin
 *
 */
@Entity
@Table(name="TOD1021_STODATPUBDWH")
@NamedQuery(name="Tod1021Storicizzazione.findAll", query="SELECT t FROM Tod1021Storicizzazione t")
public class Tod1021Storicizzazione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PRG_STO_DWH")
	private Long prgStor;

	@Column(name="DAT_STO_DWH")
	private Date datStoDwh;

	@Column(name="DAT_PUB_RIS")
	private Date datPubRis;

	@Temporal(TemporalType.DATE)
	@Column(name="DAT_ORA_ULT_MOV")
	private Date datOraUltMov;

	@Column(name="COD_PGM_ULT_MOV")
	private String codPgmUltMov;
	
	@Column(name="COD_UTE_ULT_MOV")
	private String codUteUltMov;
	
//	@Column(name="FLG_LIM")
//	private String flgLim;
	
	@Column(name="PRG_IST_RIL")
	private Long prgIstRil;
		

	/*//bi-directional many-to-one association to Tod1001Istanzarilevazione
	@ManyToOne  	@OneToMany
	@JoinColumn(name="PRG_IST_RIL")
	private Tod1019Pubrispostadomandascu Tod1019Pubrispostadomandascu;

	public Tod1019Pubrispostadomandascu getTod1019Pubrispostadomandascu() {
		return Tod1019Pubrispostadomandascu;
	}


	public void setTod1019Pubrispostadomandascu(Tod1019Pubrispostadomandascu tod1019Pubrispostadomandascu) {
		Tod1019Pubrispostadomandascu = tod1019Pubrispostadomandascu;
	}
*/

	public Tod1021Storicizzazione() {
	}


	public Long getPrgStor() {
		return prgStor;
	}


	public void setPrgStor(Long prgStor) {
		this.prgStor = prgStor;
	}


	public Date getDatStoDwh() {
		return datStoDwh;
	}


	public void setDatStoDwh(Date datStoDwh) {
		this.datStoDwh = datStoDwh;
	}


	public Date getDatPubRis() {
		return datPubRis;
	}


	public void setDatPubRis(Date datPubRis) {
		this.datPubRis = datPubRis;
	}


	public Date getDatOraUltMov() {
		return datOraUltMov;
	}


	public void setDatOraUltMov(Date datOraUltMov) {
		this.datOraUltMov = datOraUltMov;
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


//	public String getFlgLim() {
//		return flgLim;
//	}
//
//
//	public void setFlgLim(String flgLim) {
//		this.flgLim = flgLim;
//	}


	public Long getPrgIstRil() {
		return prgIstRil;
	}


	public void setPrgIstRil(Long prgIstRil) {
		this.prgIstRil = prgIstRil;
	}
	

	
}