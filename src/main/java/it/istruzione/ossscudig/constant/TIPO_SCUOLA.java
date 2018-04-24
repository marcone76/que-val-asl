package it.istruzione.ossscudig.constant;

public enum TIPO_SCUOLA {
	
	/* statale, non statale, plesso, istituto principale, cpia */

	ISTITUTO_PRINCIPALE("1","Istituto principale"), 
	PLESSO("2","plesso"),
	ISTITUTO_PRINCIPALE_E_PLESSO("1","Istituto principale e plesso");

	private String codice;
	private String descrizione;

	private TIPO_SCUOLA(String codice, String descrizione) {
		this.codice = codice;
		this.descrizione = descrizione;
	}

	public String getCodice() {
		return codice;
	}

	public String getDescrizione() {
		return descrizione;
	}
	
	public static TIPO_SCUOLA getInstanceFromCode(String codice){
		TIPO_SCUOLA instance = null;
		for (TIPO_SCUOLA elem : TIPO_SCUOLA.values()){
			if (elem.getCodice().equals(codice)){
				instance = elem;
				break;
			}
		}
		return instance;
	}
}
