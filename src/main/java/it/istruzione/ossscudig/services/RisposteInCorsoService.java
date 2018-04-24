package it.istruzione.ossscudig.services;

import java.util.List;
import it.istruzione.ossscudig.model.entity.Vod1001ModTabRis;
import it.istruzione.ossscudig.model.entity.Vod1002ModTabRisVal;

public interface RisposteInCorsoService {
	
	List<Vod1001ModTabRis> findAll(String codQst, String codForScu, String comune, String provincia, String regione);
	List<Vod1002ModTabRisVal> findAllVal(String codQst, String codForScu, String comune, String provincia, String regione);
	
	List<Vod1001ModTabRis> findAllPaged(String codQst, String codForScu, String comune, String provincia,String regione, Integer pageNumber, Integer pageSize);
	List<Vod1002ModTabRisVal> findAllValPaged(String codQst, String codForScu, String comune, String provincia,String regione, Integer pageNumber, Integer pageSize);
	
	Integer countListDatiInCorso(String codQst, String codForScu, String comune, String provincia, String regione);
	Integer countListDatiValidati(String codQst, String codForScu, String comune, String provincia,String regione);
	

}
