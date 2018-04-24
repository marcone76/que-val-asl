package it.istruzione.ossscudig.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StoricizzazioneEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name="ID")
	private Long id;
	
	@Column(name="Data")
	private Date dataUltimaPubblicazione;
	
	
	@Column(name="Filtro")
	private String filtro;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getDataUltimaPubblicazione() {
		return dataUltimaPubblicazione;
	}


	public void setDataUltimaPubblicazione(Date dataUltimaPubblicazione) {
		this.dataUltimaPubblicazione = dataUltimaPubblicazione;
	}


	public String getFiltro() {
		return filtro;
	}


	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	
}
