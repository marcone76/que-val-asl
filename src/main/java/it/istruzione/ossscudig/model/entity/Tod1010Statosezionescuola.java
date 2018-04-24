package it.istruzione.ossscudig.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the TOD1010_STATOSEZIONESCUOLA database table.
 * 
 */
@Entity
@Table(name="TOD1010_STATOSEZIONESCUOLA")
@NamedQuery(name="Tod1010Statosezionescuola.findAll", query="SELECT t FROM Tod1010Statosezionescuola t")
public class Tod1010Statosezionescuola implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private Tod1010StatosezionescuolaPK id;

	@Column(name="COD_PGM_ULT_MOV")
	private String codPgmUltMov;

	@Column(name="COD_UTE_ULT_MOV")
	private String codUteUltMov;

	@Temporal(TemporalType.DATE)
	@Column(name="DAT_ORA_ULT_MOV")
	private Date datOraUltMov;

	//bi-directional many-to-one association to Tod1003Anagrafesezione
	@ManyToOne
	@JoinColumn(name="COD_SEZ", insertable=false, updatable=false)
	private Tod1003Anagrafesezione tod1003Anagrafesezione;

	//bi-directional many-to-one association to Tod1007Tipostato
	@ManyToOne
	@JoinColumn(name="COD_TIP_STA")
	private Tod1007Tipostato tod1007Tipostato;

	public Tod1010Statosezionescuola() {
	}

	public Tod1010StatosezionescuolaPK getId() {
		return this.id;
	}

	public void setId(Tod1010StatosezionescuolaPK id) {
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

	public Tod1003Anagrafesezione getTod1003Anagrafesezione() {
		return this.tod1003Anagrafesezione;
	}

	public void setTod1003Anagrafesezione(Tod1003Anagrafesezione tod1003Anagrafesezione) {
		this.tod1003Anagrafesezione = tod1003Anagrafesezione;
	}

	public Tod1007Tipostato getTod1007Tipostato() {
		return this.tod1007Tipostato;
	}

	public void setTod1007Tipostato(Tod1007Tipostato tod1007Tipostato) {
		this.tod1007Tipostato = tod1007Tipostato;
	}

}