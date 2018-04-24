package it.istruzione.ossscudig.services.impl;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.istruzione.ossscudig.controllers.util.CommonsUtility;
import it.istruzione.ossscudig.model.entity.Vod1001ModTabRis;
import it.istruzione.ossscudig.model.entity.Vod1002ModTabRisVal;
import it.istruzione.ossscudig.repository.Vod1001ModTabRisRepository;
import it.istruzione.ossscudig.repository.Vod1002ModTabRisValRepository;
import it.istruzione.ossscudig.services.RisposteInCorsoService;

@Service
public class RisposteInCorsoServiceImpl implements RisposteInCorsoService{
	
	private static Logger logger = Logger.getLogger(RisposteInCorsoServiceImpl.class);

	@Autowired
	Vod1001ModTabRisRepository vod1001ModTabRisRepository;
	@Autowired
	Vod1002ModTabRisValRepository vod1002ModTabRisValRepository;
	
	@Override
	public List<Vod1001ModTabRis> findAll(String codQst, String codForScu, String comune, String provincia, String regione) {
		logger.debug("service findAll codQst "+codQst);
		logger.debug("service findAll codForScu "+codForScu);
		//List<Vod1001ModTabRis> list = vod1001ModTabRisRepository.findAll(); 
		List<Vod1001ModTabRis> list = vod1001ModTabRisRepository.getDatiInCorso(codQst, codForScu,  comune,  provincia,  regione, CommonsUtility.getAnnoScolasticoCorrente()); 
		return list;
	}
	
	@Override
	public Integer countListDatiInCorso(String codQst, String codForScu, String comune, String provincia, String regione) {
		logger.debug("service countListDatiInCorso codQst "+codQst);
		logger.debug("service countListDatiInCorso codForScu "+codForScu);
		Integer countList = vod1001ModTabRisRepository.countDatiInCorso(codQst, codForScu,  comune,  provincia,  regione, CommonsUtility.getAnnoScolasticoCorrente()); 
		return countList;
	}
	
	@Override
	public List<Vod1001ModTabRis> findAllPaged(String codQst, String codForScu, String comune, String provincia, String regione,Integer pageNumber,Integer pageSize) {
		logger.debug("service findAllPaged codQst "+codQst);
		logger.debug("service findAllPaged codForScu "+codForScu);
		List<Vod1001ModTabRis> list = vod1001ModTabRisRepository.getDatiInCorsoPaged(codQst, codForScu,  comune,  provincia,  regione, CommonsUtility.getAnnoScolasticoCorrente(),pageNumber,pageSize); 
		return list;
	}
	
	
	@Override
	public List<Vod1002ModTabRisVal> findAllVal(String codQst, String codForScu, String comune, String provincia, String regione) {
		logger.debug("service findAllVal codQst "+codQst);
		logger.debug("service findAllVal codForScu "+codForScu);
		//List<Vod1002ModTabRisVal> list = vod1002ModTabRisValRepository.findAll();
		List<Vod1002ModTabRisVal> list = vod1002ModTabRisValRepository.getDatiValidati(codQst, codForScu,  comune,  provincia,  regione, CommonsUtility.getAnnoScolasticoCorrente());
		return list;
	}
	
	@Override
	public List<Vod1002ModTabRisVal> findAllValPaged(String codQst, String codForScu, String comune, String provincia, String regione,Integer pageNumber,Integer pageSize) {
		logger.debug("service findAllValPaged codQst "+codQst);
		logger.debug("service findAllValPaged codForScu "+codForScu);
		List<Vod1002ModTabRisVal> list = vod1002ModTabRisValRepository.getDatiValidatiPaged(codQst, codForScu,  comune,  provincia,  regione, CommonsUtility.getAnnoScolasticoCorrente(),pageNumber,pageSize);
		return list;
	}

	@Override
	public Integer countListDatiValidati(String codQst, String codForScu, String comune, String provincia,String regione) {
		logger.debug("service countListDatiValidati codQst "+codQst);
		logger.debug("service countListDatiValidati codForScu "+codForScu);
		Integer count = vod1002ModTabRisValRepository.countDatiValidati(codQst, codForScu,  comune,  provincia,  regione, CommonsUtility.getAnnoScolasticoCorrente());
		return count;
	}
	
	  
}