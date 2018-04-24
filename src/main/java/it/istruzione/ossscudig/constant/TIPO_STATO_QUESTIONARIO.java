package it.istruzione.ossscudig.constant;

public enum TIPO_STATO_QUESTIONARIO {
	
	IN_COMPILAZIONE("7","IN COMPILAZIONE"), 
	NON_COMPILATO("8","NON COMPILATO"),
	COMPILATO("9","COMPILATO");

	private String codice;
	private String descrizione;

	private TIPO_STATO_QUESTIONARIO(String codice, String descrizione) {
		this.codice = codice;
		this.descrizione = descrizione;
	}

	public String getCodice() {
		return codice;
	}

	public String getDescrizione() {
		return descrizione;
	}
	
	public static TIPO_STATO_QUESTIONARIO getInstanceFromCode(String codice){
		TIPO_STATO_QUESTIONARIO instance = null;
		for (TIPO_STATO_QUESTIONARIO elem : TIPO_STATO_QUESTIONARIO.values()){
			if (elem.getCodice().equals(codice)){
				instance = elem;
				break;
			}
		}
		return instance;
	}
}
