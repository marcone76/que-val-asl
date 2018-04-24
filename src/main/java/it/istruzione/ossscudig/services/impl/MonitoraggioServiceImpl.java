package it.istruzione.ossscudig.services.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.istruzione.ossscudig.constant.TIPO_STATO_QUESTIONARIO;
import it.istruzione.ossscudig.controllers.util.CommonsUtility;
import it.istruzione.ossscudig.model.dto.AcquisizioneQuestionarioInCorsoDTO;
import it.istruzione.ossscudig.model.dto.AcquisizioneRilevazioneValidataDTO;
import it.istruzione.ossscudig.model.dto.LabelValueDTO;
import it.istruzione.ossscudig.model.dto.MonitoraggioDTO;
import it.istruzione.ossscudig.model.dto.RilevazioneDTO;
import it.istruzione.ossscudig.model.dto.StatoAcquisizioneQuestionarioInCorsoDTO;
import it.istruzione.ossscudig.model.dto.StatoAcquisizioneRilevazioneValidataDTO;
import it.istruzione.ossscudig.model.entity.AndamentoEntity;
import it.istruzione.ossscudig.model.entity.ElencoQuestionariForScuolaEntity;
import it.istruzione.ossscudig.model.entity.ElencoScuoleCountEntity;
import it.istruzione.ossscudig.model.entity.ElencoScuoleEntity;
import it.istruzione.ossscudig.model.entity.Mfg1029Provnuoist;
import it.istruzione.ossscudig.model.entity.MonitoraggioEntity;
import it.istruzione.ossscudig.model.entity.Tod1002Anagrafequestionario;
import it.istruzione.ossscudig.model.entity.Twb1012Regione;
import it.istruzione.ossscudig.model.entity.Twb1014Comune;
import it.istruzione.ossscudig.repository.AndamentoRepository;
import it.istruzione.ossscudig.repository.ElencoQuestionariRepository;
import it.istruzione.ossscudig.repository.ElencoScuoleRepository;
import it.istruzione.ossscudig.repository.EsportaAcquisizioneRepository;
import it.istruzione.ossscudig.repository.Mfg1029ProvnuoistRepository;
import it.istruzione.ossscudig.repository.MonitoraggioRepository;
import it.istruzione.ossscudig.repository.Tod1002AnagrafequestionarioRepository;
import it.istruzione.ossscudig.repository.Tod1003AnagrafesezioneRepository;
import it.istruzione.ossscudig.repository.Tod1008StatorilevazscuolaRepository;
import it.istruzione.ossscudig.repository.Tod1009StatoquestscuolaRepository;
import it.istruzione.ossscudig.repository.Tod1010StatosezionescuolaRepository;
import it.istruzione.ossscudig.repository.Tod1014RispostadomandascuRepository;
import it.istruzione.ossscudig.repository.Tod1015ValrispostadomandascuRepository;
import it.istruzione.ossscudig.repository.Twb1012RegioneRepository;
import it.istruzione.ossscudig.repository.Twb1014ComuneRepository;
import it.istruzione.ossscudig.services.AnagrafeQuestionarioService;
import it.istruzione.ossscudig.services.AnagrafeScuolaService;
import it.istruzione.ossscudig.services.AnagrafeSezioneService;
import it.istruzione.ossscudig.services.GestioneRilevazioneService;
import it.istruzione.ossscudig.services.MonitoraggioService;

@Service
public class MonitoraggioServiceImpl implements MonitoraggioService {

	private static Logger logger = Logger.getLogger(MonitoraggioServiceImpl.class);

	@Autowired
	Tod1002AnagrafequestionarioRepository tod1002AnagrafequestionarioRepository;

	@Autowired
	Tod1003AnagrafesezioneRepository tod1003AnagrafesezioneRepository;

	@Autowired
	Tod1014RispostadomandascuRepository tod1014RispostadomandascuRepository;

	@Autowired
	Tod1008StatorilevazscuolaRepository tod1008StatorilevazscuolaRepository;

	@Autowired
	Tod1009StatoquestscuolaRepository tod1009StatoquestscuolaRepository;

	@Autowired
	Tod1010StatosezionescuolaRepository tod1010StatosezionescuolaRepository;

	@Autowired
	Tod1015ValrispostadomandascuRepository tod1015ValrispostadomandascuRepository;

	@Autowired
	AnagrafeScuolaService anagrafeScuolaService;

	@Autowired
	AnagrafeQuestionarioService anagrafeQuestionarioService;

	@Autowired
	AnagrafeSezioneService anagrafeSezioneService;

	@Autowired
	Twb1012RegioneRepository twb1012RegioneRepository;

	@Autowired
	Mfg1029ProvnuoistRepository mfg1029ProvnuoistRepository;

	@Autowired
	Twb1014ComuneRepository twb1014ComuneRepository;

	@Autowired
	GestioneRilevazioneService gestioneRilevazioneService;

	@Autowired
	MonitoraggioRepository monitoraggioRepository;

	@Autowired
	private DozerBeanMapper rdDozerMapper;
	
	@Autowired
	EsportaAcquisizioneRepository esportaAcquisizioneRepository;
	
	@Autowired
	AndamentoRepository andamentoRepository;
	
	@Autowired
	ElencoQuestionariRepository elencoQuestionariRepository;
	
	@Autowired
	ElencoScuoleRepository elencoScuoleRepository;
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public LinkedList<LabelValueDTO> getRegioni() {

		LinkedList<LabelValueDTO> out = new LinkedList<>();
		LinkedList<Twb1012Regione> entityRegioni = twb1012RegioneRepository.findAllRegioniItaliane();
		if (entityRegioni != null && !entityRegioni.isEmpty()) {
			for (Iterator<Twb1012Regione> iterator = entityRegioni.iterator(); iterator.hasNext();) {
				Twb1012Regione twb1012Regione = (Twb1012Regione) iterator.next();
				LabelValueDTO item = new LabelValueDTO();
				item.setLabel(twb1012Regione.getDesReg());
				item.setValue(twb1012Regione.getCodReg());
				//item.setValue(twb1012Regione.getCodReg() != null ? twb1012Regione.getCodReg().trim() : null);
				out.add(item);
			}
		}
		return out;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public LinkedList<LabelValueDTO> getProvince(String codRegione) {

		LinkedList<LabelValueDTO> out = new LinkedList<>();
		LinkedList<Mfg1029Provnuoist> entityProvince = mfg1029ProvnuoistRepository.findByCodiceRegione(codRegione);
		if (entityProvince != null && !entityProvince.isEmpty()) {
			for (Iterator<Mfg1029Provnuoist> iterator = entityProvince.iterator(); iterator.hasNext();) {
				Mfg1029Provnuoist mfg1029Provnuoist = (Mfg1029Provnuoist) iterator.next();
				LabelValueDTO item = new LabelValueDTO();
				item.setLabel(mfg1029Provnuoist.getDesPrv());
				item.setValue(mfg1029Provnuoist.getCodPrv());
				//item.setValue(mfg1029Provnuoist.getCodPrv() != null ? mfg1029Provnuoist.getCodPrv().trim() : null);
				
				out.add(item);
			}
		}
		return out;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public LinkedList<LabelValueDTO> getComuni(String codProvincia) {

		LinkedList<LabelValueDTO> out = new LinkedList<>();
		LinkedList<Twb1014Comune> entityComuni = twb1014ComuneRepository
				.findByMfg1029ProvnuoistCodPrvOrderByDesComAsc(codProvincia);
		if (entityComuni != null && !entityComuni.isEmpty()) {
			for (Iterator<Twb1014Comune> iterator = entityComuni.iterator(); iterator.hasNext();) {
				Twb1014Comune twb1014Comune = (Twb1014Comune) iterator.next();
				LabelValueDTO item = new LabelValueDTO();
				item.setLabel(twb1014Comune.getDesCom());
				item.setValue(twb1014Comune.getCodCom());
				//item.setValue(twb1014Comune.getCodCom() != null ? twb1014Comune.getCodCom().trim() : null);
				out.add(item);
			}
		}
		return out;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public LinkedList<LabelValueDTO> getQuestionari() {

		LinkedList<LabelValueDTO> out = new LinkedList<>();
		RilevazioneDTO rilevazioneDTO = gestioneRilevazioneService.loadRilevazioneAttiva();
		if (rilevazioneDTO != null) {
			LinkedList<Tod1002Anagrafequestionario> entityQuestionari = tod1002AnagrafequestionarioRepository
					.findByTod1001IstanzarilevazionePrgIstRilOrderByCodQstAsc(rilevazioneDTO.getId());
			if (entityQuestionari != null && !entityQuestionari.isEmpty()) {
				for (Iterator<Tod1002Anagrafequestionario> iterator = entityQuestionari.iterator(); iterator
						.hasNext();) {
					Tod1002Anagrafequestionario tod1002Anagrafequestionario = (Tod1002Anagrafequestionario) iterator
							.next();
					LabelValueDTO item = new LabelValueDTO();
					item.setLabel(tod1002Anagrafequestionario.getDesQst());
					item.setValue(tod1002Anagrafequestionario.getCodQst());
					out.add(item);
				}
			}
		}
		return out;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public StatoAcquisizioneQuestionarioInCorsoDTO getStatoAcquisizioneQuestionarioInCorso(Long prgIstRil, String codiceRegione, String codiceProvincia, String codiceComune, String cicliScolastici) {
		StatoAcquisizioneQuestionarioInCorsoDTO out = new StatoAcquisizioneQuestionarioInCorsoDTO();

		BigDecimal numeroTotaleScuole = new BigDecimal(0);
		BigDecimal numeroQuestionariCompilati = new BigDecimal(0);
		BigDecimal numeroQuestionariInCompilazione = new BigDecimal(0);
		String flagAdulti=anagrafeScuolaService.getAdultiInclusiNelCampione(prgIstRil);
		flagAdulti = ("NO".equals(flagAdulti) ) ? "0" : null;
		Object[] numTot = tod1009StatoquestscuolaRepository.getNumeriTortaQstInCorso(prgIstRil, CommonsUtility.getAnnoScolasticoCorrente(),flagAdulti, codiceComune, codiceProvincia, codiceRegione, cicliScolastici).get(0);
		
			numeroTotaleScuole  =  (BigDecimal) numTot[0];
			
			if (numTot[2] == null) {
				BigDecimal nessuna = new BigDecimal(0);
				numeroQuestionariCompilati = nessuna;

			}
			else {
				numeroQuestionariCompilati  =  (BigDecimal) numTot[2];

			}
			
			if (numTot[1] == null) {
				BigDecimal nessuna = new BigDecimal(0);
				numeroQuestionariInCompilazione = nessuna;

			}
			else {
				numeroQuestionariInCompilazione  =  (BigDecimal) numTot[1];

			}
			
		
		out.setNumeroCompilati(numeroQuestionariCompilati.intValue());
		out.setNumeroInCompilazione(numeroQuestionariInCompilazione.intValue());
		out.setNumeroNonCompilati(numeroTotaleScuole.intValue() - numeroQuestionariCompilati.intValue() - numeroQuestionariInCompilazione.intValue());

		return out;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public StatoAcquisizioneRilevazioneValidataDTO getStatoAcquisizioneRilevazioneValidata(Long prgIstRil, String codiceRegione, String codiceProvincia, String codiceComune, String cicliScolastici) {
		StatoAcquisizioneRilevazioneValidataDTO out = new StatoAcquisizioneRilevazioneValidataDTO();
		BigDecimal numeroTotaleScuole = new BigDecimal(0);
		BigDecimal numeroRilevazioniValidate = new BigDecimal(0);
		
		
		String flagAdulti=anagrafeScuolaService.getAdultiInclusiNelCampione(prgIstRil);
		flagAdulti = ("NO".equals(flagAdulti) ) ? "0" : null;
		Object[] numTot = tod1009StatoquestscuolaRepository.getNumeriTortaValidati(prgIstRil,flagAdulti,  CommonsUtility.getAnnoScolasticoCorrente(), codiceComune, codiceProvincia, codiceRegione, cicliScolastici).get(0);
		numeroTotaleScuole  =  (BigDecimal) numTot[0];
		numeroRilevazioniValidate  =  (BigDecimal) numTot[1];
		
		if (numTot[1] == null) {
			BigDecimal nessuna = new BigDecimal(0);
			numeroRilevazioniValidate = nessuna;

		}
		else {
			numeroRilevazioniValidate  =  (BigDecimal) numTot[1];

		}
		
		out.setNumeroValidati(numeroRilevazioniValidate.intValue());
		out.setNumeroNonValidati(numeroTotaleScuole.intValue() - numeroRilevazioniValidate.intValue());

		return out;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<AcquisizioneQuestionarioInCorsoDTO> getAcquisizioneQuestionarioInCorso(Long prgIstRil, String codiceRegione, String codiceProvincia, String codiceComune, String ciclo) {
		 List<String> codTipSta  = new ArrayList<String>();
		 codTipSta.add(TIPO_STATO_QUESTIONARIO.IN_COMPILAZIONE.getCodice());
		 codTipSta.add(TIPO_STATO_QUESTIONARIO.NON_COMPILATO.getCodice());
		 codTipSta.add(TIPO_STATO_QUESTIONARIO.COMPILATO.getCodice());
		List<AcquisizioneQuestionarioInCorsoDTO> out = new ArrayList<>();
		List<MonitoraggioEntity> entitys = monitoraggioRepository.getAcquisizioneQuestionarioInCorso(
				CommonsUtility.getAnnoScolasticoCorrente(),
				(codiceComune != null && !codiceComune.trim().equals("")) ? codiceComune.trim() : null,
				(codiceProvincia != null && !codiceProvincia.trim().equals("")) ? codiceProvincia.trim() : null,
				(codiceRegione != null && !codiceRegione.trim().equals("")) ? codiceRegione.trim() : null,
						prgIstRil, codTipSta, ciclo
				);

		for (MonitoraggioEntity monitoraggioEntity : entitys) {
			AcquisizioneQuestionarioInCorsoDTO dto = new AcquisizioneQuestionarioInCorsoDTO();
			dto.setCodiceMeccanografico(monitoraggioEntity.getCodiceMeccanografico());
			dto.setComune(monitoraggioEntity.getComune());
			dto.setDenominazione(monitoraggioEntity.getDenominazione());
			dto.setProvincia(monitoraggioEntity.getProvincia());
			dto.setQuestionario(monitoraggioEntity.getQuestionario());
			dto.setRegione(monitoraggioEntity.getRegione());
			dto.setStato(monitoraggioEntity.getStato());

			out.add(dto);

		}

		return out;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<AcquisizioneRilevazioneValidataDTO> getAcquisizioneRilevazioneValidata(Long prgIstRil, String codiceRegione, String codiceProvincia, String codiceComune, String ciclo) {

		List<AcquisizioneRilevazioneValidataDTO> out = new ArrayList<>();
//		List<MonitoraggioEntity> entitys = monitoraggioRepository.getAcquisizioneRilevazioneValidata(CommonsUtility.getAnnoScolasticoCorrente(),
//				(codiceComune != null && !codiceComune.trim().equals("")) ? codiceComune.trim() : null,
//				(codiceProvincia != null && !codiceProvincia.trim().equals("")) ? codiceProvincia.trim() : null,
//				(codiceRegione != null && !codiceRegione.trim().equals("")) ? codiceRegione.trim() : null, prgIstRil, ciclo);

		String flagAdulti=anagrafeScuolaService.getAdultiInclusiNelCampione(prgIstRil);
		flagAdulti = ("NO".equals(flagAdulti) ) ? "0" : null;
		List<MonitoraggioEntity> entitys = monitoraggioRepository.getNumeriElencoValidati(CommonsUtility.getAnnoScolasticoCorrente(),
				(codiceComune != null && !codiceComune.trim().equals("")) ? codiceComune.trim() : null,
				(codiceProvincia != null && !codiceProvincia.trim().equals("")) ? codiceProvincia.trim() : null,
				(codiceRegione != null && !codiceRegione.trim().equals("")) ? codiceRegione.trim() : null, prgIstRil, ciclo, flagAdulti);
		
		
		for (MonitoraggioEntity monitoraggioEntity : entitys){
			AcquisizioneRilevazioneValidataDTO dto = new AcquisizioneRilevazioneValidataDTO();
			dto.setCodiceMeccanografico(monitoraggioEntity.getCodiceMeccanografico());
			dto.setComune(monitoraggioEntity.getComune());
			dto.setDenominazione(monitoraggioEntity.getDenominazione());
			dto.setProvincia(monitoraggioEntity.getProvincia());
			dto.setIstituto(monitoraggioEntity.getQuestionario());
			dto.setRegione(monitoraggioEntity.getRegione());

			out.add(dto);

		}

		return out;
	}

	@Override
	public ArrayList<LabelValueDTO> getAndamento(String dataFrom, String codiceRegione, String codiceProvincia, String codiceComune,String ciclo) {
		ArrayList<LabelValueDTO> listaOut = new ArrayList<LabelValueDTO>();
		List<AndamentoEntity> listaRet = null;
		listaRet = andamentoRepository.getAndamento(dataFrom, (codiceRegione != null && !codiceRegione.trim().equals("")) ? codiceRegione.trim() : null,
				(codiceProvincia != null && !codiceProvincia.trim().equals("")) ? codiceProvincia.trim() : null,
				(codiceComune != null && !codiceComune.trim().equals("")) ? codiceComune.trim() : null, CommonsUtility.getAnnoScolasticoCorrente(),ciclo);
		logger.debug("dopo " + listaRet.size());
		LabelValueDTO lab = null;
		for (Iterator<AndamentoEntity> iterator = listaRet.iterator(); iterator.hasNext();) {
			AndamentoEntity andamentoEntity = (AndamentoEntity) iterator.next();
			lab = new LabelValueDTO();
			lab.setLabel(andamentoEntity.getGiorno());
			lab.setValue(andamentoEntity.getConteggio());
			listaOut.add(lab);
		}

		return listaOut;
	}

	@Override
	public ArrayList<MonitoraggioDTO> getElencoQuestionariForScuola(String prgIstRil, String codIstPri,	String annoScolastico) {
		List<ElencoQuestionariForScuolaEntity> list = elencoQuestionariRepository.getQuestionariForScuola(prgIstRil, annoScolastico, codIstPri);
		ArrayList<MonitoraggioDTO> listOut = new ArrayList<MonitoraggioDTO>();
		MonitoraggioDTO monitoraggioDTO = null;
		for (Iterator<ElencoQuestionariForScuolaEntity> iterator = list.iterator(); iterator.hasNext();) {
			ElencoQuestionariForScuolaEntity object = (ElencoQuestionariForScuolaEntity) iterator.next();
			monitoraggioDTO = rdDozerMapper.map(object, MonitoraggioDTO.class);
			listOut.add(monitoraggioDTO);
		}

		return listOut;
	}

	@Override
	public ArrayList<MonitoraggioDTO> getElencoScuole(String prgIstRil, String annoScolastico, String codiceRegione, String codiceProvincia, String codiceComune, String idQst, String codScu) 	{
		List<ElencoScuoleEntity> list = elencoScuoleRepository.getElencoScuole(prgIstRil, annoScolastico, 
				        (codiceRegione != null && !codiceRegione.trim().equals("")) ? codiceRegione.trim() : null,
						(codiceProvincia != null && !codiceProvincia.trim().equals("")) ? codiceProvincia.trim() : null,
						(codiceComune != null && !codiceComune.trim().equals("")) ? codiceComune.trim() : null,
						(idQst != null && !idQst.trim().equals("")) ? idQst.trim() : null,
						(codScu != null && !codScu.trim().equals("")) ? codScu.trim() : null);
		
		ArrayList<MonitoraggioDTO> listOut = new ArrayList<MonitoraggioDTO>();
		MonitoraggioDTO monitoraggioDTO = null;
		for (Iterator<ElencoScuoleEntity> iterator = list.iterator(); iterator.hasNext();) {
			ElencoScuoleEntity object = (ElencoScuoleEntity) iterator.next();
			monitoraggioDTO = rdDozerMapper.map(object, MonitoraggioDTO.class);
			listOut.add(monitoraggioDTO);
		}

		return listOut;
	}

	@Override
	public ArrayList<MonitoraggioDTO> getElencoScuoleCount(String prgIstRil, String annoScolastico,	String codiceRegione, String codiceProvincia, String codiceComune, String codScu) {

		List<ElencoScuoleCountEntity> list = esportaAcquisizioneRepository.getElencoScuoleAndCount(prgIstRil, annoScolastico,
		        (codiceRegione != null && !codiceRegione.trim().equals("")) ? codiceRegione.trim() : null,
				(codiceProvincia != null && !codiceProvincia.trim().equals("")) ? codiceProvincia.trim() : null,
				(codiceComune != null && !codiceComune.trim().equals("")) ? codiceComune.trim() : null,
				(codScu != null && !codScu.trim().equals("")) ? codScu.trim() : null);  
		
		ArrayList<MonitoraggioDTO> listOut = new ArrayList<MonitoraggioDTO>();
		MonitoraggioDTO monitoraggioDTO = null;
		for (Iterator<ElencoScuoleCountEntity> iterator = list.iterator(); iterator.hasNext();) {
			ElencoScuoleCountEntity object = (ElencoScuoleCountEntity )iterator.next();
			monitoraggioDTO = rdDozerMapper.map(object, MonitoraggioDTO.class);
			listOut.add(monitoraggioDTO);
		}

		return listOut;
	}
	@Override
	public List<String> getCicli(Long prgIstRil) {

		List<Tod1002Anagrafequestionario>  listCicli=tod1002AnagrafequestionarioRepository.findByTod1001IstanzarilevazionePrgIstRil(prgIstRil);	
		List<String> listOut = new ArrayList<String>();
	
		for (Iterator<Tod1002Anagrafequestionario> iterator = listCicli.iterator(); iterator.hasNext();) {
			String object = String.valueOf(iterator.next().getCodQst());
			listOut.add(object);
		}
		return listOut;
	}
	

}
