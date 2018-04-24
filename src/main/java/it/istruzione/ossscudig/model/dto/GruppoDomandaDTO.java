package it.istruzione.ossscudig.model.dto;

import java.util.List;

public class GruppoDomandaDTO {

	private String codEdi;
	private String tipoGruppo; /** D=Default, E=Edifici, P=Plessi **/
	private List<DomandaDTO> domande;
	private String indirizzo;	
	public String getCodEdi() {
		return codEdi;
	}
	public void setCodEdi(String codEdi) {
		this.codEdi = codEdi;
	}

	public List<DomandaDTO> getDomande() {
		return domande;
	}
	public void setDomande(List<DomandaDTO> domande) {
		this.domande = domande;
	}
	public String getTipoGruppo() {
		return tipoGruppo;
	}
	public void setTipoGruppo(String tipoGruppo) {
		this.tipoGruppo = tipoGruppo;
	}
	public final String getIndirizzo() {
		return indirizzo;
	}
	public final void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	

}
