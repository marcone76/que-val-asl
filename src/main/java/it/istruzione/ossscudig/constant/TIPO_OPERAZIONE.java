package it.istruzione.ossscudig.constant;

public enum TIPO_OPERAZIONE {

	SALVA("S"), 
	APRI_ADESSO("A"),
	CHIUDI_ADESSO("C"),
	SOSPENDI("D"),
	RIATTIVA("R");

	private String codice;

	private TIPO_OPERAZIONE(String codice) {
		this.codice = codice;
	}

	public String getCodice() {
		return codice;
	}
	
	public static TIPO_OPERAZIONE getInstanceFromCode(String codice){
		TIPO_OPERAZIONE instance = null;
		for (TIPO_OPERAZIONE elem : TIPO_OPERAZIONE.values()){
			if (elem.getCodice().equals(codice)){
				instance = elem;
				break;
			}
		}
		return instance;
	}
}
