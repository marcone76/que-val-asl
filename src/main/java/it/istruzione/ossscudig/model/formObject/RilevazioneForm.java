package it.istruzione.ossscudig.model.formObject;

import it.istruzione.ossscudig.constant.TIPO_STATO_RILEVAZIONE;
import it.istruzione.ossscudig.controllers.util.CommonsUtility;

import java.io.Serializable;
import java.util.Date;

public class RilevazioneForm implements Serializable{
	
	private static final long serialVersionUID = 6147788535197834682L;
	
	private String descrizione;
	private String dataInizio;
	private String dataFine;
	private String tipoOperazione;
	private TIPO_STATO_RILEVAZIONE stato;
	private String id;
	private String nomeBottone;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(String dataInizio) {
		this.dataInizio = dataInizio;
	}
	public String getDataFine() {
		return dataFine;
	}
	public void setDataFine(String dataFine) {
		this.dataFine = dataFine;
	}
	public String getTipoOperazione() {
		return tipoOperazione;
	}
	public void setTipoOperazione(String tipoOperazione) {
		this.tipoOperazione = tipoOperazione;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public boolean isChiusa() {
		Date today = CommonsUtility.getTodayDate();
		Date dataInizio = CommonsUtility.parse(this.dataInizio);
		Date dataFine = CommonsUtility.parse(this.dataFine);
		boolean isChiusa = dataInizio == null
							|| dataInizio.after(today)
							|| (dataFine != null && dataFine.before(today));
		
		return isChiusa;
		
	}
	
	public String getDescrizioneStato() {
		if (this.isChiusa()){
			return "CHIUSA";
		}else if (this.getStato() != null){
			return this.getStato().getDescrizione();
		}else
			return "APERTA";
	}
	
	public TIPO_STATO_RILEVAZIONE getStato() {
		return stato;
	}
	public void setStato(TIPO_STATO_RILEVAZIONE stato) {
		this.stato = stato;
	}
	public String getNomeBottone() {
		return nomeBottone;
	}
	public void setNomeBottone(String nomeBottone) {
		this.nomeBottone = nomeBottone;
	}
	
	
	
	
}
