package it.istruzione.ossscudig.model.dto;

import it.istruzione.ossscudig.constant.TIPO_STATO_QUESTIONARIO;

import java.util.Date;

public class StatoQuestionarioDTO {
	
	private TIPO_STATO_QUESTIONARIO tipoStato;
	private Date dataUltimaModifica;
	
	public TIPO_STATO_QUESTIONARIO getTipoStato() {
		return tipoStato;
	}
	public void setTipoStato(TIPO_STATO_QUESTIONARIO tipoStato) {
		this.tipoStato = tipoStato;
	}
	public Date getDataUltimaModifica() {
		return dataUltimaModifica;
	}
	public void setDataUltimaModifica(Date dataUltimaModifica) {
		this.dataUltimaModifica = dataUltimaModifica;
	}
	
	
	

}
