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
 * The persistent class for the TOD1001_ISTANZARILEVAZIONE database table.
 * 
 */
@Entity
@Table(name="TOD1001_ISTANZARILEVAZIONE")
@NamedQuery(name="Tod1001Istanzarilevazione.findAll", query="SELECT t FROM Tod1001Istanzarilevazione t")
public class Tod1001Istanzarilevazione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TOD1001_ISTANZARILEVAZIONE_PRGISTRIL_GENERATOR", sequenceName="Q1001ISTANZARILEVAZIONE", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TOD1001_ISTANZARILEVAZIONE_PRGISTRIL_GENERATOR")
	@Column(name="PRG_IST_RIL")
	private Long prgIstRil;

	@Column(name="COD_PGM_ULT_MOV")
	private String codPgmUltMov;

	@Column(name="COD_UTE_ULT_MOV")
	private String codUteUltMov;

	@Temporal(TemporalType.DATE)
	@Column(name="DAT_FIN_VAL")
	private Date datFinVal;

	@Temporal(TemporalType.DATE)
	@Column(name="DAT_INI_VAL")
	private Date datIniVal;

	@Temporal(TemporalType.DATE)
	@Column(name="DAT_ORA_ULT_MOV")
	private Date datOraUltMov;

	@Column(name="DES_IST_RIL")
	private String desIstRil;

	//bi-directional many-to-one association to Tod1007Tipostato
	@ManyToOne
	@JoinColumn(name="COD_TIP_STA")
	private Tod1007Tipostato tod1007Tipostato;

	//bi-directional many-to-one association to Tod1002Anagrafequestionario
	@OneToMany(mappedBy="tod1001Istanzarilevazione",fetch = FetchType.LAZY)
	private List<Tod1002Anagrafequestionario> tod1002Anagrafequestionarios;

	//bi-directional many-to-one association to Tod1013Gestpropristanza
	@OneToMany(mappedBy="tod1001Istanzarilevazione",fetch = FetchType.LAZY)
	private List<Tod1013Gestpropristanza> tod1013Gestpropristanzas;

/*	//bi-directional many-to-one association to Tod1014Rispostadomandascu
	@OneToMany(mappedBy="tod1001Istanzarilevazione")
	private List<Tod1014Rispostadomandascu> tod1014Rispostadomandascus;*/

	public Tod1001Istanzarilevazione() {
	}

	public Long getPrgIstRil() {
		return this.prgIstRil;
	}

	public void setPrgIstRil(Long prgIstRil) {
		this.prgIstRil = prgIstRil;
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

	public Date getDatFinVal() {
		return this.datFinVal;
	}

	public void setDatFinVal(Date datFinVal) {
		this.datFinVal = datFinVal;
	}

	public Date getDatIniVal() {
		return this.datIniVal;
	}

	public void setDatIniVal(Date datIniVal) {
		this.datIniVal = datIniVal;
	}

	public Date getDatOraUltMov() {
		return this.datOraUltMov;
	}

	public void setDatOraUltMov(Date datOraUltMov) {
		this.datOraUltMov = datOraUltMov;
	}

	public String getDesIstRil() {
		return this.desIstRil;
	}

	public void setDesIstRil(String desIstRil) {
		this.desIstRil = desIstRil;
	}

	public List<Tod1002Anagrafequestionario> getTod1002Anagrafequestionarios() {
		return this.tod1002Anagrafequestionarios;
	}

	public void setTod1002Anagrafequestionarios(List<Tod1002Anagrafequestionario> tod1002Anagrafequestionarios) {
		this.tod1002Anagrafequestionarios = tod1002Anagrafequestionarios;
	}

	public Tod1002Anagrafequestionario addTod1002Anagrafequestionario(Tod1002Anagrafequestionario tod1002Anagrafequestionario) {
		getTod1002Anagrafequestionarios().add(tod1002Anagrafequestionario);
		tod1002Anagrafequestionario.setTod1001Istanzarilevazione(this);

		return tod1002Anagrafequestionario;
	}

	public Tod1002Anagrafequestionario removeTod1002Anagrafequestionario(Tod1002Anagrafequestionario tod1002Anagrafequestionario) {
		getTod1002Anagrafequestionarios().remove(tod1002Anagrafequestionario);
		tod1002Anagrafequestionario.setTod1001Istanzarilevazione(null);

		return tod1002Anagrafequestionario;
	}

	public List<Tod1013Gestpropristanza> getTod1013Gestpropristanzas() {
		return this.tod1013Gestpropristanzas;
	}

	public void setTod1013Gestpropristanzas(List<Tod1013Gestpropristanza> tod1013Gestpropristanzas) {
		this.tod1013Gestpropristanzas = tod1013Gestpropristanzas;
	}

	public Tod1013Gestpropristanza addTod1013Gestpropristanza(Tod1013Gestpropristanza tod1013Gestpropristanza) {
		getTod1013Gestpropristanzas().add(tod1013Gestpropristanza);
		tod1013Gestpropristanza.setTod1001Istanzarilevazione(this);

		return tod1013Gestpropristanza;
	}

	public Tod1013Gestpropristanza removeTod1013Gestpropristanza(Tod1013Gestpropristanza tod1013Gestpropristanza) {
		getTod1013Gestpropristanzas().remove(tod1013Gestpropristanza);
		tod1013Gestpropristanza.setTod1001Istanzarilevazione(null);

		return tod1013Gestpropristanza;
	}

	public Tod1007Tipostato getTod1007Tipostato() {
		return tod1007Tipostato;
	}

	public void setTod1007Tipostato(Tod1007Tipostato tod1007Tipostato) {
		this.tod1007Tipostato = tod1007Tipostato;
	}



}