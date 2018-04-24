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
 * The persistent class for the TOD1008_STATORILEVAZSCUOLA database table.
 * 
 */
@Entity
@Table(name="TOD1008_STATORILEVAZSCUOLA")
@NamedQuery(name="Tod1008Statorilevazscuola.findAll", query="SELECT t FROM Tod1008Statorilevazscuola t")
public class Tod1008Statorilevazscuola implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private Tod1008StatorilevazscuolaPK id;

	@Column(name="COD_PGM_ULT_MOV")
	private String codPgmUltMov;

	@Column(name="COD_UTE_ULT_MOV")
	private String codUteUltMov;

	@Temporal(TemporalType.DATE)
	@Column(name="DAT_ORA_ULT_MOV")
	private Date datOraUltMov;

	//bi-directional many-to-one association to Tod1007Tipostato
	@ManyToOne
	@JoinColumn(name="COD_TIP_STA")
	private Tod1007Tipostato tod1007Tipostato;

	public Tod1008Statorilevazscuola() {
	}

	public Tod1008StatorilevazscuolaPK getId() {
		return this.id;
	}

	public void setId(Tod1008StatorilevazscuolaPK id) {
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

	public Tod1007Tipostato getTod1007Tipostato() {
		return this.tod1007Tipostato;
	}

	public void setTod1007Tipostato(Tod1007Tipostato tod1007Tipostato) {
		this.tod1007Tipostato = tod1007Tipostato;
	}
}