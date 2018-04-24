package it.istruzione.ossscudig.model.formObject;

import java.io.Serializable;
import java.util.List;

import it.istruzione.ossscudig.model.dto.DomandaDTO;

public class SchedaForm implements Serializable{
	
	private static final long serialVersionUID = 6147788535197834682L;

	public static final long getSerialversionuid() {
		return serialVersionUID;
	}
	private List<DomandaDTO> domande;
	private String domanda11 ;
	private String domanda12 ;
	private String domanda13 ;
	private String domanda131 ;
	private String domanda1311 ;
	private String domanda132 ;
	private String domanda1321 ;
	private String domanda14 ;

	
	public final String getDomanda11() {
		return domanda11;
	}

	public final void setDomanda11(String domanda11) {
		this.domanda11 = domanda11;
	}

	public final String getDomanda13() {
		return domanda13;
	}

	public final void setDomanda13(String domanda13) {
		this.domanda13 = domanda13;
	}

	public final String getDomanda131() {
		return domanda131;
	}

	public final void setDomanda131(String domanda131) {
		this.domanda131 = domanda131;
	}

	public final String getDomanda1311() {
		return domanda1311;
	}

	public final void setDomanda1311(String domanda1311) {
		this.domanda1311 = domanda1311;
	}

	public final String getDomanda132() {
		return domanda132;
	}

	public final void setDomanda132(String domanda132) {
		this.domanda132 = domanda132;
	}

	public final String getDomanda1321() {
		return domanda1321;
	}

	public final void setDomanda1321(String domanda1321) {
		this.domanda1321 = domanda1321;
	}

	public final String getDomanda12() {
		return domanda12;
	}

	public final void setDomanda12(String domanda12) {
		this.domanda12 = domanda12;
	}

	public final List<DomandaDTO> getDomande() {
		return domande;
	}

	public final void setDomande(List<DomandaDTO> domande) {
		this.domande = domande;
	}

	public final String getDomanda14() {
		return domanda14;
	}

	public final void setDomanda14(String domanda14) {
		this.domanda14 = domanda14;
	}
	
	
	
	
}
