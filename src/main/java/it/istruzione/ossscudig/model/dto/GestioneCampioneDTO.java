package it.istruzione.ossscudig.model.dto;

import it.istruzione.ossscudig.constant.TIPO_STATO_RILEVAZIONE;

import java.util.Date;

public class GestioneCampioneDTO {

	private String tipologiaIstituto;
	private String ordineScuola;
	private String regione;
	
	
	public String getTipologiaIstituto() {
		return tipologiaIstituto;
	}
	public void setTipologiaIstituto(String tipologiaIstituto) {
		this.tipologiaIstituto = tipologiaIstituto;
	}
	public String getOrdineScuola() {
		return ordineScuola;
	}
	public void setOrdineScuola(String ordineScuola) {
		this.ordineScuola = ordineScuola;
	}
	public String getRegione() {
		return regione;
	}
	public void setRegione(String regione) {
		this.regione = regione;
	}
	
	
	
	
}
