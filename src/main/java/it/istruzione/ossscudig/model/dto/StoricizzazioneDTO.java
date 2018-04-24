package it.istruzione.ossscudig.model.dto;

public class StoricizzazioneDTO {

	private Long id;
	private Long prgIstRil;
	private String dataPubblicazioni;
	private String dataStoricizzazione;
	private String dataUltimaModifica;
	private String flagLimite;
	
	
	
	public String getFlagLimite() {
		return flagLimite;
	}
	public void setFlagLimite(String flagLimite) {
		this.flagLimite = flagLimite;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPrgIstRil() {
		return prgIstRil;
	}
	public void setPrgIstRil(Long prgIstRil) {
		this.prgIstRil = prgIstRil;
	}
	
	public String getDataPubblicazioni() {
		return dataPubblicazioni;
	}
	public void setDataPubblicazioni(String dataPubblicazioni) {
		this.dataPubblicazioni = dataPubblicazioni;
	}
	public String getDataStoricizzazione() {
		return dataStoricizzazione;
	}
	public void setDataStoricizzazione(String dataStoricizzazione) {
		this.dataStoricizzazione = dataStoricizzazione;
	}
	public String getDataUltimaModifica() {
		return dataUltimaModifica;
	}
	public void setDataUltimaModifica(String dataUltimaModifica) {
		this.dataUltimaModifica = dataUltimaModifica;
	}
	
			
}
