package it.istruzione.ossscudig.constant;

public enum DOMANDE_RIPETUTE_PLESSO {
	DOMANDA_126("126"),
	DOMANDA_1261("1261"),
	DOMANDA_127("127"),
	DOMANDA_128("128"),
	DOMANDA_129("129"),
	DOMANDA_130("130");
	
	public static boolean contains(String codDmd){
		boolean contains = false;
		for (DOMANDE_RIPETUTE_PLESSO elem : DOMANDE_RIPETUTE_PLESSO.values()){
			if (elem.codice.equals(codDmd)){
				contains = true;
				break;
			}
		}
		return contains;
	}
	
	private String codice;

	private DOMANDE_RIPETUTE_PLESSO(String codice) {
		this.codice = codice;
	}
	
}
