package it.istruzione.ossscudig.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EdificiEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID")
	private Long id;
	
	@Column(name="COD_EDI")
	private String codiceEdificio;
	
	@Column(name="A006")
	private String indirizzoEdificio;

	public final Long getId() {
		return id;
	}

	public final void setId(Long id) {
		this.id = id;
	}

	public final String getCodiceEdificio() {
		return codiceEdificio;
	}

	public final void setCodiceEdificio(String codiceEdificio) {
		this.codiceEdificio = codiceEdificio;
	}

	public final String getIndirizzoEdificio() {
		return indirizzoEdificio;
	}

	public final void setIndirizzoEdificio(String indirizzoEdificio) {
		this.indirizzoEdificio = indirizzoEdificio;
	}
	
	
	

}
