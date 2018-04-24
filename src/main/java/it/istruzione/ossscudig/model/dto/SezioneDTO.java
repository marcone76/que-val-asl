package it.istruzione.ossscudig.model.dto;

import it.istruzione.ossscudig.constant.TIPO_STATO_SEZIONE;

import java.util.List;

public class SezioneDTO {
	
	private String idSezione;
	private String descrizioneSezione;
	private String descrizioneQuestionario;
	private String idQuestionario;
	private List<GruppoDomandaDTO> gruppiDomande;
	private String codiceForteScuola;
	private TIPO_STATO_SEZIONE stato;
	private Integer sizeListaEdificiPlessi;
	private List<String> listaCodiciEdificiPlessi;
	
	public final Integer getSizeListaEdificiPlessi() {
		return sizeListaEdificiPlessi;
	}
	public final void setSizeListaEdificiPlessi(Integer sizeListaEdificiPlessi) {
		this.sizeListaEdificiPlessi = sizeListaEdificiPlessi;
	}
	public final List<String> getListaCodiciEdificiPlessi() {
		return listaCodiciEdificiPlessi;
	}
	public final void setListaCodiciEdificiPlessi(List<String> listaCodiciEdificiPlessi) {
		this.listaCodiciEdificiPlessi = listaCodiciEdificiPlessi;
	}
	public String getDescrizioneSezione() {
		return descrizioneSezione;
	}
	public void setDescrizioneSezione(String descrizioneSezione) {
		this.descrizioneSezione = descrizioneSezione;
	}
	public String getIdSezione() {
		return idSezione;
	}
	public void setIdSezione(String idSezione) {
		this.idSezione = idSezione;
	}
	public String getDescrizioneQuestionario() {
		return descrizioneQuestionario;
	}
	public void setDescrizioneQuestionario(String descrizioneQuestionario) {
		this.descrizioneQuestionario = descrizioneQuestionario;
	}
	public String getIdQuestionario() {
		return idQuestionario;
	}
	public void setIdQuestionario(String idQuestionario) {
		this.idQuestionario = idQuestionario;
	}
	public TIPO_STATO_SEZIONE getStato() {
		return stato;
	}
	public void setStato(TIPO_STATO_SEZIONE stato) {
		this.stato = stato;
	}
	public String getCodiceForteScuola() {
		return codiceForteScuola;
	}
	public void setCodiceForteScuola(String codiceForteScuola) {
		this.codiceForteScuola = codiceForteScuola;
	}
	public List<GruppoDomandaDTO> getGruppiDomande() {
		return gruppiDomande;
	}
	public void setGruppiDomande(List<GruppoDomandaDTO> gruppiDomande) {
		this.gruppiDomande = gruppiDomande;
	}
	

}
