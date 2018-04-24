package it.istruzione.ossscudig.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AndamentoEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID")
	private Long id;
	
	@Column(name="GIORNO")
	private String giorno;
	
	@Column(name="CONTEGGIO")
	private String conteggio;
	
	public final String getGiorno() {
		return giorno;
	}

	public final void setGiorno(String giorno) {
		this.giorno = giorno;
	}

	public final String getConteggio() {
		return conteggio;
	}

	public final void setConteggio(String conteggio) {
		this.conteggio = conteggio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


}
