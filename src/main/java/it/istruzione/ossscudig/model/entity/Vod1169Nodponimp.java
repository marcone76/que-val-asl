package it.istruzione.ossscudig.model.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the VOD1169_NODPONIMP database table.
 * 
 */
@Entity
@Table(name="VOD1169_NODPONIMP")
@NamedQuery(name="Vod1169Nodponimp.findAll", query="SELECT v FROM Vod1169Nodponimp v")
public class Vod1169Nodponimp implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private Vod1169NodponimpPK id;

	@Column(name="COD_MEC_IST_PRI")
	private String codMecIstPri;

	@Column(name="DES_SOT_AZI")
	private String desSotAzi;

	@Column(name="IMP_SOT_AZI")
	private BigDecimal impSotAzi;

	public Vod1169Nodponimp() {
	}

	public String getCodMecIstPri() {
		return this.codMecIstPri;
	}

	public void setCodMecIstPri(String codMecIstPri) {
		this.codMecIstPri = codMecIstPri;
	}

	public String getDesSotAzi() {
		return this.desSotAzi;
	}

	public void setDesSotAzi(String desSotAzi) {
		this.desSotAzi = desSotAzi;
	}

	public BigDecimal getImpSotAzi() {
		return this.impSotAzi;
	}

	public void setImpSotAzi(BigDecimal impSotAzi) {
		this.impSotAzi = impSotAzi;
	}

	public Vod1169NodponimpPK getId() {
		return id;
	}

	public void setId(Vod1169NodponimpPK id) {
		this.id = id;
	}

	

}