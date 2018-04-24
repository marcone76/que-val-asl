package it.istruzione.ossscudig.model.dto;

import java.util.List;

public class VoceDTO {

	private String id;
	private String descrizione;
	private String checked = "";
	private List<String> voci;

	public String getId() {
		return id;
	}
	public void setId(String codice) {
		this.id = codice;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		if(checked)
			this.checked = "checked=\"checked\"";
	}
	public List<String> getVoci() {
		return voci;
	}
	public void setVoci(List<String> voci) {
		this.voci = voci;
	}
	public void setChecked(String checked) {
		this.checked = checked;
	}
	
	
	
}
