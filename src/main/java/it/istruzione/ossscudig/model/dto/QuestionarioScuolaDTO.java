package it.istruzione.ossscudig.model.dto;

import java.util.Date;
import java.util.List;

import it.istruzione.ossscudig.constant.TIPO_STATO_QUESTIONARIO;

public class QuestionarioScuolaDTO extends QuestionarioDTO{

	private ScuolaDTO scuola;
	private TIPO_STATO_QUESTIONARIO stato;
	private Date dataUltimaModificaQuestionarioInCorso;
	private Date dataUltimaModificaQuestionarioValidato;
	private List<QuestionarioScuolaDTO> lista;
	
	public ScuolaDTO getScuola() {
		return scuola;
	}
	public void setScuola(ScuolaDTO scuola) {
		this.scuola = scuola;
	}
	public TIPO_STATO_QUESTIONARIO getStato() {
		return stato;
	}
	public void setStato(TIPO_STATO_QUESTIONARIO stato) {
		this.stato = stato;
	}
	public Date getDataUltimaModificaQuestionarioInCorso() {
		return dataUltimaModificaQuestionarioInCorso;
	}
	public void setDataUltimaModificaQuestionarioInCorso(
			Date dataUltimaModificaQuestionarioInCorso) {
		this.dataUltimaModificaQuestionarioInCorso = dataUltimaModificaQuestionarioInCorso;
	}
	public Date getDataUltimaModificaQuestionarioValidato() {
		return dataUltimaModificaQuestionarioValidato;
	}
	public void setDataUltimaModificaQuestionarioValidato(
			Date dataUltimaModificaQuestionarioValidato) {
		this.dataUltimaModificaQuestionarioValidato = dataUltimaModificaQuestionarioValidato;
	}
	public List<QuestionarioScuolaDTO> getLista() {
		return lista;
	}
	public void setLista(List<QuestionarioScuolaDTO> lista) {
		this.lista = lista;
	}
	
	
	
	
}
