package it.istruzione.ossscudig.constant;

public enum TIPO_STATO_SEZIONE {
	
	NON_COMPILATA("10","NON COMPILATA"), 
	IN_COMPILAZIONE("11","IN COMPILAZIONE"),
	COMPILATA("12","COMPILATA");

	private String codice;
	private String descrizione;

	private TIPO_STATO_SEZIONE(String codice, String descrizione) {
		this.codice = codice;
		this.descrizione = descrizione;
	}

	public String getCodice() {
		return codice;
	}

	public String getDescrizione() {
		return descrizione;
	}
	
	public static TIPO_STATO_SEZIONE getInstanceFromCode(String codice){
		TIPO_STATO_SEZIONE instance = null;
		for (TIPO_STATO_SEZIONE elem : TIPO_STATO_SEZIONE.values()){
			if (elem.getCodice().equals(codice)){
				instance = elem;
				break;
			}
		}
		return instance;
	}
}
