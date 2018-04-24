package it.istruzione.ossscudig.constant;

public enum TIPO_STATO_RILEVAZIONE {
	
	BOZZA("1","BOZZA"), 
	APPROVATO("2","APPROVATO"),
	APERTA("3","APERTA"),
	CHIUSA("4","CHIUSA"),
	SOSPESA("5","SOSPESA"),
	VALIDATA("6","VALIDATA"),
	IN_COMPILAZIONE("13","IN COMPILAZIONE"),
	QST_APPROVATO_GEST("15","APPROVATO QUESTIONARIO GESTIONE");

	private String codice;
	private String descrizione;

	private TIPO_STATO_RILEVAZIONE(String codice, String descrizione) {
		this.codice = codice;
		this.descrizione = descrizione;
	}

	public String getCodice() {
		return codice;
	}

	public String getDescrizione() {
		return descrizione;
	}
	
	public static TIPO_STATO_RILEVAZIONE getInstanceFromCode(String codice){
		TIPO_STATO_RILEVAZIONE instance = null;
		for (TIPO_STATO_RILEVAZIONE elem : TIPO_STATO_RILEVAZIONE.values()){
			if (elem.getCodice().equals(codice)){
				instance = elem;
				break;
			}
		}
		return instance;
	}
}
