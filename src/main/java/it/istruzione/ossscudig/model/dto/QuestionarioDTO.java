package it.istruzione.ossscudig.model.dto;

import java.io.Serializable;
import it.istruzione.ossscudig.constant.TIPO_STATO_QUESTIONARIO;

public class QuestionarioDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String codiceRilevazione;
	private String codiceQuestionario;
	private String nome;
	private String descrizioneStatoQuestionario;
	private String codTipSta;
	
	public final String getCodTipSta() {
		return codTipSta;
	}
	public final void setCodTipSta(String codTipSta) {
		this.codTipSta = codTipSta;
	}
	public final String getCodiceQuestionario() {
		return codiceQuestionario;
	}
	public final void setCodiceQuestionario(String codiceQuestionario) {
		this.codiceQuestionario = codiceQuestionario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizioneStatoQuestionario() {
		return descrizioneStatoQuestionario;
	}
	public void setDescrizioneStatoQuestionario(String descrizioneStatoQuestionario) {
		this.descrizioneStatoQuestionario = descrizioneStatoQuestionario;
	}
	public final String getCodiceRilevazione() {
		return codiceRilevazione;
	}
	public final void setCodiceRilevazione(String codiceRilevazione) {
		this.codiceRilevazione = codiceRilevazione;
	}
	
}
