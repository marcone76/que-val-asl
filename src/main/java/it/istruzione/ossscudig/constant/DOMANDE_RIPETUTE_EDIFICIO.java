package it.istruzione.ossscudig.constant;

public enum DOMANDE_RIPETUTE_EDIFICIO {
	DOMANDA_501("501"),
	DOMANDA_502("502"),
	DOMANDA_503("503"),
	DOMANDA_504("504"),
	DOMANDA_1610("1610"),
	DOMANDA_1611("1611"),
	DOMANDA_1612("1612"),
	DOMANDA_1613("1613"),
	DOMANDA_1614("1614"),
	DOMANDA_1615("1615"),
	DOMANDA_1616("1616"),
	
	DOMANDA_506("506"),
	DOMANDA_507("507"),
	DOMANDA_508("508"),
	
	DOMANDA_509("509"),
	DOMANDA_510("510"),
	DOMANDA_511("511"),
	DOMANDA_512("512"),
	DOMANDA_513("513"),
	DOMANDA_514("514"),
	DOMANDA_515("515");
	
	private String codice;

	private DOMANDE_RIPETUTE_EDIFICIO(String codice) {
		this.codice = codice;
	}
	
	public static boolean contains(String codDmd){
		boolean contains = false;
		for (DOMANDE_RIPETUTE_EDIFICIO elem : DOMANDE_RIPETUTE_EDIFICIO.values()){
			if (elem.codice.equals(codDmd)){
				contains = true;
				break;
			}
		}
		return contains;
	}
	public static DOMANDE_RIPETUTE_EDIFICIO getCodice(String codDmd) {
		
		return DOMANDE_RIPETUTE_EDIFICIO.DOMANDA_501;
	}
}
