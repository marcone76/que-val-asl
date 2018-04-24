package it.istruzione.ossscudig.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the TOD1024_AVVISO database table.
 * 
 */
@Entity
@Table(name="TOD1024_AVVISO")
@NamedQuery(name="Tod1024Avviso.findAll", query="SELECT t FROM Tod1024Avviso t")
public class Tod1024Avviso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@SequenceGenerator(name="TOD1024_AVVISO_PRG_AVV_GENERATOR", sequenceName="Q1024AVVISO", allocationSize=1)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TOD1024_AVVISO_PRG_AVV_GENERATOR")
	@Column(name="PRG_AVV")
	private Long prgAvv;
	
	@Column(name="DES_TES_AVV")
	private String desTesAvv;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="DAT_INI_VAL_AVV")
	private Date datIniValAvv;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DAT_FIN_VAL_AVV")
	private Date datFinValAvv;

	@Temporal(TemporalType.DATE)
	@Column(name="DAT_ORA_ULT_MOV")
	private Date datOraUltMov;
	
	@Column(name="COD_PGM_ULT_MOV")
	private String codPgmUltMov;

	@Column(name="COD_UTE_ULT_MOV")
	private String codUteUltMov;

	//bi-directional many-to-one association to Tod1007Tipostato
	@ManyToOne
	@JoinColumn(name="COD_TIP_AVV")
	private Tod1023Tipoavviso tod1023Tipoavviso;

	public Long getPrgAvv() {
		return prgAvv;
	}

	public void setPrgAvv(Long prgAvv) {
		this.prgAvv = prgAvv;
	}

	public String getDesTesAvv() {
		return desTesAvv;
	}

	public void setDesTesAvv(String desTesAvv) {
		this.desTesAvv = desTesAvv;
	}

	

	public Date getDatIniValAvv() {
		return datIniValAvv;
	}

	public void setDatIniValAvv(Date datIniValAvv) {
		this.datIniValAvv = datIniValAvv;
	}

	public Date getDatFinValAvv() {
		return datFinValAvv;
	}

	public void setDatFinValAvv(Date datFinValAvv) {
		this.datFinValAvv = datFinValAvv;
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

	public Tod1023Tipoavviso getTod1023Tipoavviso() {
		return tod1023Tipoavviso;
	}

	public void setTod1023Tipoavviso(Tod1023Tipoavviso tod1023Tipoavviso) {
		this.tod1023Tipoavviso = tod1023Tipoavviso;
	}
	
}