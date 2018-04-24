package it.istruzione.ossscudig.controllers.util;

public enum TIPO_PROFILO {
	RIMO_UTE_DGRUF("Utente Amministrativo"), RIMO_UTE_USR("Utente Territoriale");

	private String desc;

	private TIPO_PROFILO(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}
}
