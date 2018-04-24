package it.istruzione.ossscudig.model.dto;

import it.istruzione.ossscudig.constant.TIPO_STATO_RILEVAZIONE;

import java.util.Date;

public class RilevazioneDTO {

	private Long id;
	private Date dataInizio;
	private Date dataFine;
	private TIPO_STATO_RILEVAZIONE stato;
	private String descrizione;
	
	public Date getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}
	public Date getDataFine() {
		return dataFine;
	}
	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public TIPO_STATO_RILEVAZIONE getStato() {
		return stato;
	}
	public void setStato(TIPO_STATO_RILEVAZIONE stato) {
		this.stato = stato;
	}
	
	
	
	
}
