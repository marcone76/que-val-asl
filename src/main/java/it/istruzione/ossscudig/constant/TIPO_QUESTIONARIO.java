package it.istruzione.ossscudig.constant;

public enum TIPO_QUESTIONARIO {
	
	SECONDO_CICLO_ISTITUZIONE_SCOLASTICA("1","SECONDO CICLO ISTITUZIONE SCOLASTICA"), 
	PRIMO_CICLO_ISTITUZIONE_SCOLASTICA("2","PRIMO CICLO ISTITUZIONE SCOLASTICA"),
	SECONDO_CICLO_PLESSO("3","SECONDO CICLO PLESSO"),
	PRIMO_CICLO_PLESSO("4","PRIMO CICLO PLESSO"),
	SECONDO_CICLO_PARITARIA("5","SECONDO CICLO PARITARIA"),
	PRIMO_CICLO_PARITARIA("6","PRIMO CICLO PARITARIA");


	private String codice;
	private String descrizione;

	private TIPO_QUESTIONARIO(String codice, String descrizione) {
		this.codice = codice;
		this.descrizione = descrizione;
	}

	public String getCodice() {
		return codice;
	}

	public String getDescrizione() {
		return descrizione;
	}
	
	public static TIPO_QUESTIONARIO getInstanceFromCode(String codice){
		TIPO_QUESTIONARIO instance = null;
		for (TIPO_QUESTIONARIO elem : TIPO_QUESTIONARIO.values()){
			if (elem.getCodice().equals(codice)){
				instance = elem;
				break;
			}
		}
		return instance;
	}
}
