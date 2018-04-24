package it.istruzione.ossscudig.model.dto;

import java.math.BigDecimal;

public class AnagrafeDomandaDTO {

	private String regExp;
	private Long idRegExp;
	private String desMsgUte;
	private String desGrpVoce;
	private BigDecimal ordineVoce;


	
	
	
	public BigDecimal getOrdineVoce() {
		return ordineVoce;
	}
	public void setOrdineVoce(BigDecimal ordineVoce) {
		this.ordineVoce = ordineVoce;
	}
	public String getRegExp() {
		return regExp;
	}
	public void setRegExp(String regExp) {
		this.regExp = regExp;
	}
	public String getDesMsgUte() {
		return desMsgUte;
	}
	public void setDesMsgUte(String desMsgUte) {
		this.desMsgUte = desMsgUte;
	}
	public String getDesGrpVoce() {
		return desGrpVoce;
	}
	public void setDesGrpVoce(String desGrpVoce) {
		this.desGrpVoce = desGrpVoce;
	}
	public final Long getIdRegExp() {
		return idRegExp;
	}
	public final void setIdRegExp(Long idRegExp) {
		this.idRegExp = idRegExp;
	}
	
	
}
