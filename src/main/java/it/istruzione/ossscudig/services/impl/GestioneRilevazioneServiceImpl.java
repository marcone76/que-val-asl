package it.istruzione.ossscudig.services.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.istruzione.ossscudig.constant.TIPO_STATO_RILEVAZIONE;
import it.istruzione.ossscudig.controllers.util.CommonsUtility;
import it.istruzione.ossscudig.model.dto.PubblicazioneDTO;
import it.istruzione.ossscudig.model.dto.RilevazioneDTO;
import it.istruzione.ossscudig.model.dto.StoricizzazioneDTO;
import it.istruzione.ossscudig.model.entity.PubblicazioneEntity;
import it.istruzione.ossscudig.model.entity.PubblicazioneRecordsEntity;
import it.istruzione.ossscudig.model.entity.StoricizzazioneEntity;
import it.istruzione.ossscudig.model.entity.Tod1001Istanzarilevazione;
import it.istruzione.ossscudig.model.entity.Tod1002Anagrafequestionario;
import it.istruzione.ossscudig.model.entity.Tod1007Tipostato;
import it.istruzione.ossscudig.model.entity.Tod1013Gestpropristanza;
import it.istruzione.ossscudig.model.entity.Tod1015Valrispostadomandascu;
import it.istruzione.ossscudig.model.entity.Tod1018Vallimris;
import it.istruzione.ossscudig.model.entity.Tod1019Pubrispostadomandascu;
import it.istruzione.ossscudig.model.entity.Tod1019PubrispostadomandascuPK;
import it.istruzione.ossscudig.model.entity.Tod1021Storicizzazione;
import it.istruzione.ossscudig.model.formObject.RilevazioneForm;
import it.istruzione.ossscudig.repository.PubblicazioneRecordRepository;
import it.istruzione.ossscudig.repository.Tod1001IstanzarilevazioneRepository;
import it.istruzione.ossscudig.repository.Tod1002AnagrafequestionarioRepository;
import it.istruzione.ossscudig.repository.Tod1013GestpropristanzaRepository;
import it.istruzione.ossscudig.repository.Tod1015ValrispostadomandascuRepository;
import it.istruzione.ossscudig.repository.Tod1018VallimrisRepository;
import it.istruzione.ossscudig.repository.Tod1019PubrispostadomandascuRepository;
import it.istruzione.ossscudig.repository.Tod1021StoricizzazioneRepository;
import it.istruzione.ossscudig.services.GestioneRilevazioneService;

@Service
public class GestioneRilevazioneServiceImpl implements GestioneRilevazioneService {

	private static Logger logger = Logger.getLogger(GestioneRilevazioneServiceImpl.class);

	@Autowired
	private Tod1001IstanzarilevazioneRepository tod1001IstanzarilevazioneRepository;

	@Autowired
	private Tod1021StoricizzazioneRepository tod1021StoricizzazioneRepository;

	@Autowired
	private Tod1013GestpropristanzaRepository tod1013GestpropristanzaRepository;

	@Autowired
	private Tod1018VallimrisRepository tod1018VallimrisRepository;

	@Autowired
	private Tod1019PubrispostadomandascuRepository tod1019PubrispostadomandascuRepository;

	@Autowired
	private Tod1015ValrispostadomandascuRepository tod1015ValrispostadomandascuRepository;
	@Autowired
	private PubblicazioneRecordRepository pubblicazioneRecordRepository;
	@Autowired
	private Tod1002AnagrafequestionarioRepository tod1002AnagrafequestionarioRepository;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public RilevazioneDTO loadRilevazioneAttiva() {
		RilevazioneDTO out = null;
		Tod1001Istanzarilevazione tod1001Istanzarilevazione = tod1001IstanzarilevazioneRepository
				.findByTod1007TipostatoCodTipSta(Long.valueOf(TIPO_STATO_RILEVAZIONE.APERTA.getCodice()));
		if (tod1001Istanzarilevazione != null) {
			out = new RilevazioneDTO();
			out.setId(tod1001Istanzarilevazione.getPrgIstRil());
			out.setDataFine(tod1001Istanzarilevazione.getDatFinVal());
			out.setDataInizio(tod1001Istanzarilevazione.getDatIniVal());
			out.setDescrizione(tod1001Istanzarilevazione.getDesIstRil());
		}
		return out;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public RilevazioneDTO loadRilevazioneApprovata() {
		RilevazioneDTO out = null;
		Tod1001Istanzarilevazione tod1001Istanzarilevazione = tod1001IstanzarilevazioneRepository
				.findByTod1007TipostatoCodTipSta(Long.valueOf(TIPO_STATO_RILEVAZIONE.APPROVATO.getCodice()));
		if (tod1001Istanzarilevazione != null) {
			out = new RilevazioneDTO();
			out.setId(tod1001Istanzarilevazione.getPrgIstRil());
			out.setDataFine(tod1001Istanzarilevazione.getDatFinVal());
			out.setDataInizio(tod1001Istanzarilevazione.getDatIniVal());
			out.setDescrizione(tod1001Istanzarilevazione.getDesIstRil());
			// out.setDescrizione(tod1001Istanzarilevazione.getTod1007Tipostato().getDesTipSta());
		}
		return out;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public RilevazioneDTO loadRilevazioneBozza() {
		RilevazioneDTO out = null;
		Tod1001Istanzarilevazione tod1001Istanzarilevazione = tod1001IstanzarilevazioneRepository
				.findByTod1007TipostatoCodTipSta(Long.valueOf(TIPO_STATO_RILEVAZIONE.BOZZA.getCodice()));
		if (tod1001Istanzarilevazione != null) {
			out = new RilevazioneDTO();
			out.setId(tod1001Istanzarilevazione.getPrgIstRil());
			out.setDataFine(tod1001Istanzarilevazione.getDatFinVal());
			out.setDataInizio(tod1001Istanzarilevazione.getDatIniVal());
			out.setDescrizione(tod1001Istanzarilevazione.getDesIstRil());
			// out.setDescrizione(tod1001Istanzarilevazione.getTod1007Tipostato().getDesTipSta());
		}
		return out;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<StoricizzazioneDTO> loadStoricizzazione() {
		logger.debug("StoricizzazioneDTO");
		List<StoricizzazioneDTO> out = new ArrayList<>();
		List<Tod1021Storicizzazione> entitys = tod1021StoricizzazioneRepository.findAll();

		for (Tod1021Storicizzazione tod1021Storicizzazione : entitys) {
			StoricizzazioneDTO dto = new StoricizzazioneDTO();
			dto.setId(tod1021Storicizzazione.getPrgStor());
			dto.setDataStoricizzazione(CommonsUtility.format(tod1021Storicizzazione.getDatStoDwh()));
			dto.setDataPubblicazioni(CommonsUtility.format(tod1021Storicizzazione.getDatPubRis()));
			
			
			Date dataOdierna = CommonsUtility.getTodayDate();
			if (tod1021Storicizzazione.getDatStoDwh().after(dataOdierna)) {
			/*Date dataFiltri = null;
			 * Tod1018Vallimris oTod1018Vallimris = tod1018VallimrisRepository
					.findByPrgIstRil(tod1021Storicizzazione.getPrgIstRil());
			if (oTod1018Vallimris != null && oTod1018Vallimris.getDatOraUltMov() != null) {
				dataFiltri = tod1018VallimrisRepository.findByPrgIstRil(tod1021Storicizzazione.getPrgIstRil())
						.getDatOraUltMov();
				if (dataFiltri.equals(tod1021Storicizzazione.getDatPubRis())) {
					dto.setFlagLimite("S");
				} else {
					dto.setFlagLimite("N");
				}
			} else {*/
				dto.setFlagLimite("N");
			}
			out.add(dto);
		}
		return out;
	}

	@Override
	@Transactional
	public void deleteFieldStoricizzazione(Long id) {
		Tod1021Storicizzazione tod1021Storicizzazione = tod1021StoricizzazioneRepository.findOne(id);
		tod1021StoricizzazioneRepository.delete(tod1021Storicizzazione);
	}

	@Override
	@Transactional
	public void insertStoricizzazione(Long id, String dataStoricizzazione) {
		logger.debug("insertStoricizzazione");
		Tod1021Storicizzazione oTod1021Storicizzazione = new Tod1021Storicizzazione();
		oTod1021Storicizzazione.setPrgIstRil(id);
		Tod1021Storicizzazione ultimaTod1021Storicizzazione=tod1021StoricizzazioneRepository.getMaxId();
		Long idStor = 0L;
		if (ultimaTod1021Storicizzazione == null) {
			idStor = 1L;
		} else {
			idStor = ultimaTod1021Storicizzazione.getPrgStor();
			Date dataOdierna = CommonsUtility.getTodayDate();
			Date dataStor = ultimaTod1021Storicizzazione.getDatStoDwh();
			if (dataOdierna.after(dataStor)) {
				idStor = idStor + 1;
			}
		}

		oTod1021Storicizzazione.setPrgStor(idStor);
	//	tod1019PubrispostadomandascuRepository.findByTod1001IstanzarilevazionePrgIstRil(id);
		if (dataStoricizzazione != null) {
			oTod1021Storicizzazione.setDatStoDwh(CommonsUtility.parse(dataStoricizzazione));
		}
		List<Tod1019Pubrispostadomandascu> listaTod1019Pubrispostadomandascu =  tod1019PubrispostadomandascuRepository
				.findByTod1001IstanzarilevazionePrgIstRil(id);
		if (listaTod1019Pubrispostadomandascu != null) {
			oTod1021Storicizzazione.setDatPubRis(listaTod1019Pubrispostadomandascu.get(0).getDatPubRis());
			List <StoricizzazioneEntity> oStoricizzazioneEntity = tod1015ValrispostadomandascuRepository.getFiltriUltimaDataPubblicazione();
			Iterator itr = oStoricizzazioneEntity.iterator();
			Date dataPubblicazione=null;
			String filtro="N";
			while (itr.hasNext()) {
				Object[] obj = (Object[]) itr.next();
			    dataPubblicazione= (Date) obj[0];
			    filtro= obj[1].toString();
			}
//			if (dataPubblicazione
//					.compareTo(listaTod1019Pubrispostadomandascu.get(0).getDatPubRis()) == 0) {
//				oTod1021Storicizzazione.setFlgLim("S");
//			} else {
//				oTod1021Storicizzazione.setFlgLim("N");
//			}
		} else {
			oTod1021Storicizzazione.setDatPubRis(null);
			//oTod1021Storicizzazione.setFlgLim("N");
		}
		
		oTod1021Storicizzazione.setDatOraUltMov(CommonsUtility.getTodayDate());
		tod1021StoricizzazioneRepository.saveAndFlush(oTod1021Storicizzazione);

	}

	@Override
	public List<PubblicazioneDTO> loadPubblicazione() {
		// TODO Auto-generated method stub
		logger.debug("loadPubblicazione");
		List<PubblicazioneDTO> out = new ArrayList<>();
		List<PubblicazioneEntity> entitys = (List<PubblicazioneEntity>) tod1015ValrispostadomandascuRepository
				.getPubblicazione();
		Iterator itr = entitys.iterator();
		while (itr.hasNext()) {
			Object[] obj = (Object[]) itr.next();
			PubblicazioneDTO oPubblicazioneDTO = new PubblicazioneDTO();
			oPubblicazioneDTO.setDescQst(obj[0].toString());
			oPubblicazioneDTO.setDesSez(obj[1].toString());
			oPubblicazioneDTO.setCodIdeDmd(obj[2].toString());
			oPubblicazioneDTO.setCodDmd(obj[3].toString());
			oPubblicazioneDTO.setDesDmd(obj[4].toString());
			oPubblicazioneDTO.setMinimo(obj[5].toString().substring(0, 1));
			oPubblicazioneDTO.setMassimo(obj[6].toString().substring(0, 1));
			oPubblicazioneDTO.setMedia(obj[7].toString().substring(0, 1));
			oPubblicazioneDTO.setNumValMas((BigDecimal) obj[9]);
			oPubblicazioneDTO.setNumValMin((BigDecimal) obj[8]);
			BigDecimal id = (BigDecimal) obj[10];
			oPubblicazioneDTO.setPrgIstRil(id.longValue());
			oPubblicazioneDTO.setCodQuest(obj[11].toString());
			out.add(oPubblicazioneDTO);
		}
		return out;
	}

	@Override
	public List<PubblicazioneDTO> getRecordPubblicati(String codicedomanda, String limiteminimo, String limitemassimo) {
		List<PubblicazioneRecordsEntity> listaRec = null;
		listaRec = pubblicazioneRecordRepository.getRecordsPubblicazione(
				(codicedomanda != null && !codicedomanda.trim().equals("")) ? codicedomanda.trim() : null,
				(limiteminimo != null && !limiteminimo.trim().equals("")) ? limiteminimo.trim() : "0",
				(limitemassimo != null && !limitemassimo.trim().equals("")) ? limitemassimo.trim() : "0");

		PubblicazioneDTO oPubblicazioneDTO = null;
		List<PubblicazioneDTO> out = new ArrayList<>();

		Iterator itr = listaRec.iterator();
		while (itr.hasNext()) {
			PubblicazioneRecordsEntity obj = (PubblicazioneRecordsEntity) itr.next();
			oPubblicazioneDTO = new PubblicazioneDTO();
			oPubblicazioneDTO.setCodForScu(obj.getCodForScu());
			oPubblicazioneDTO.setCodIdeDmd(obj.getCodIdeDmd());
			oPubblicazioneDTO.setDesDmd(obj.getDesDmd());
			oPubblicazioneDTO.setDesRis(obj.getDesRis());
			out.add(oPubblicazioneDTO);
		}
		return out;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public PubblicazioneDTO percentualeRecordIgnorati(String codicedomanda, String limiteminimo, String limitemassimo) {
		PubblicazioneDTO out = null;
		List<Object> oPubblicazioneRecordsEntity = pubblicazioneRecordRepository.getPercentualeRecordIgnorati(
				(codicedomanda != null && !codicedomanda.trim().equals("")) ? codicedomanda.trim() : null,
				(limiteminimo != null && !limiteminimo.trim().equals("")) ? limiteminimo.trim() : "0",
				(limitemassimo != null && !limitemassimo.trim().equals("")) ? limitemassimo.trim() : "0");

		Iterator itr = oPubblicazioneRecordsEntity.iterator();
		while (itr.hasNext()) {
			Object[] obj = (Object[]) itr.next();
			out = new PubblicazioneDTO();
			out.setDomTot(obj[0].toString());
			out.setDomEsc(obj[1].toString());
			out.setPerDmd(obj[2].toString());
		}
		return out;
	}

	@Override
	@Transactional
	public void insertFiltri(PubblicazioneDTO oPubblicazioneDTO) {
		logger.debug("insertFiltri");
		Tod1018Vallimris oTod1018Vallimris = new Tod1018Vallimris();// tod1018VallimrisRepository.findByPrgIstRilAndCodQstAndCodDmd(oPubblicazioneDTO.getPrgIstRil(),oPubblicazioneDTO.getCodQuest(),oPubblicazioneDTO.getCodDmd());
		oTod1018Vallimris.setPrgIstRil(oPubblicazioneDTO.getPrgIstRil());
		oTod1018Vallimris.setCodQst(oPubblicazioneDTO.getCodQuest());
		if (oPubblicazioneDTO.getFiltroMas() != null && !"".equals(oPubblicazioneDTO.getFiltroMas().trim())) {
			oTod1018Vallimris.setNumValMas(Long.valueOf(oPubblicazioneDTO.getFiltroMas()).longValue());
		}
		else {
			oTod1018Vallimris.setNumValMas(0L);
		}
		if (oPubblicazioneDTO.getFiltroMin() != null && !"".equals(oPubblicazioneDTO.getFiltroMin().trim())) {
			oTod1018Vallimris.setNumValMin(Long.valueOf(oPubblicazioneDTO.getFiltroMin()).longValue());
		}
		else {
			oTod1018Vallimris.setNumValMin(0L);
		}

		oTod1018Vallimris.setCodDmd(oPubblicazioneDTO.getCodDmd());
		oTod1018Vallimris.setDatOraUltMov(CommonsUtility.getTodayDate());
		tod1018VallimrisRepository.saveAndFlush(oTod1018Vallimris);

	}

	@Override
	@Transactional
	public void deleteFieldCampione(Long prgIstRil) {
		List<Tod1013Gestpropristanza> tod1013Gestpropristanza = tod1013GestpropristanzaRepository
				.findByTod1001IstanzarilevazionePrgIstRil(prgIstRil);
		tod1013GestpropristanzaRepository.delete(tod1013Gestpropristanza);
	}
	
	@Override
	@Transactional
	public List<Tod1013Gestpropristanza> findCampione(Long prgIstRil) {
		List<Tod1013Gestpropristanza> tod1013Gestpropristanza = tod1013GestpropristanzaRepository
				.findByTod1001IstanzarilevazionePrgIstRil(prgIstRil);
		return tod1013Gestpropristanza;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<RilevazioneDTO> getRilevazioni() {
		logger.debug("getRilevazioni");
		List<RilevazioneDTO> out = new ArrayList<>();
		List<Tod1001Istanzarilevazione> entitys = tod1001IstanzarilevazioneRepository.findAll();

		for (Tod1001Istanzarilevazione oTod1001Istanzarilevazione : entitys) {
			RilevazioneDTO dto = new RilevazioneDTO();
			dto.setDescrizione(oTod1001Istanzarilevazione.getDesIstRil());
			dto.setDataInizio(oTod1001Istanzarilevazione.getDatIniVal());
			dto.setDataFine(oTod1001Istanzarilevazione.getDatFinVal());
			dto.setStato(TIPO_STATO_RILEVAZIONE.getInstanceFromCode(
					String.valueOf(oTod1001Istanzarilevazione.getTod1007Tipostato().getCodTipSta())));
			dto.setId(oTod1001Istanzarilevazione.getPrgIstRil());
			out.add(dto);
		}
		return out;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public RilevazioneDTO getRilevazioneById(String id) {

		Tod1001Istanzarilevazione tod1001Istanzarilevazione = tod1001IstanzarilevazioneRepository
				.findOne(Long.valueOf(id));
		RilevazioneDTO out = popolaRilevazioneDTO(tod1001Istanzarilevazione);
		return out;
	}

	public RilevazioneDTO popolaRilevazioneDTO(Tod1001Istanzarilevazione tod1001Istanzarilevazione) {
		RilevazioneDTO out = null;
		if (tod1001Istanzarilevazione != null) {
			out = new RilevazioneDTO();
			out.setId(tod1001Istanzarilevazione.getPrgIstRil());
			out.setDataFine(tod1001Istanzarilevazione.getDatFinVal());
			out.setDataInizio(tod1001Istanzarilevazione.getDatIniVal());
			out.setDescrizione(tod1001Istanzarilevazione.getDesIstRil());
			out.setStato(TIPO_STATO_RILEVAZIONE.getInstanceFromCode(
					String.valueOf(tod1001Istanzarilevazione.getTod1007Tipostato().getCodTipSta())));
		}
		return out;

	}

	@Override
	@Transactional
	public RilevazioneDTO salvaGestioneRilevazione(RilevazioneForm rilevazione, boolean stato) {
		Tod1001Istanzarilevazione uptod1001Istanzarilevazione = updateTod1001Istanzarilevazione(rilevazione, stato);
		RilevazioneDTO out = popolaRilevazioneDTO(uptod1001Istanzarilevazione);
		return out;
	}

	@Transactional
	public Tod1001Istanzarilevazione updateTod1001Istanzarilevazione(RilevazioneForm rilevazione, boolean stato) {
		Tod1001Istanzarilevazione tod1001Istanzarilevazione = tod1001IstanzarilevazioneRepository
				.findOne(Long.valueOf(rilevazione.getId()));
		if (rilevazione.getStato() == TIPO_STATO_RILEVAZIONE.APERTA && !stato) {
			tod1001Istanzarilevazione.setDatFinVal(CommonsUtility.parse(rilevazione.getDataFine()));
			tod1001Istanzarilevazione
			.setTod1007Tipostato(cambioStato(Long.parseLong(TIPO_STATO_RILEVAZIONE.CHIUSA.getCodice())));
		}

		if (rilevazione.getStato() == TIPO_STATO_RILEVAZIONE.APERTA && stato) {
			tod1001Istanzarilevazione
					.setTod1007Tipostato(cambioStato(Long.parseLong(TIPO_STATO_RILEVAZIONE.SOSPESA.getCodice())));
		}

		if (rilevazione.getStato() == TIPO_STATO_RILEVAZIONE.APPROVATO) {
			List<Tod1001Istanzarilevazione> entitys = tod1001IstanzarilevazioneRepository.findAll();
			for (Tod1001Istanzarilevazione uTod1001Istanzarilevazione : entitys) {
				if (uTod1001Istanzarilevazione.getTod1007Tipostato().getCodTipSta() == Long
						.valueOf(TIPO_STATO_RILEVAZIONE.APERTA.getCodice())) {
					uTod1001Istanzarilevazione
							.setTod1007Tipostato(cambioStato(Long.parseLong(TIPO_STATO_RILEVAZIONE.CHIUSA.getCodice())));
					tod1001IstanzarilevazioneRepository.saveAndFlush(uTod1001Istanzarilevazione);
				} else if (uTod1001Istanzarilevazione.getTod1007Tipostato().getCodTipSta() == Long
						.valueOf(TIPO_STATO_RILEVAZIONE.SOSPESA.getCodice())) {
					uTod1001Istanzarilevazione
							.setTod1007Tipostato(cambioStato(Long.parseLong(TIPO_STATO_RILEVAZIONE.CHIUSA.getCodice())));
					tod1001IstanzarilevazioneRepository.saveAndFlush(uTod1001Istanzarilevazione);
				}
			}
			tod1001Istanzarilevazione.setDatIniVal(CommonsUtility.parse(rilevazione.getDataInizio()));
			tod1001Istanzarilevazione
			.setTod1007Tipostato(cambioStato(Long.parseLong(TIPO_STATO_RILEVAZIONE.APERTA.getCodice())));
		}
			  

		if (rilevazione.getStato() == TIPO_STATO_RILEVAZIONE.SOSPESA) {
			tod1001Istanzarilevazione
					.setTod1007Tipostato(cambioStato(Long.parseLong(TIPO_STATO_RILEVAZIONE.APERTA.getCodice())));
		}
		
		if( rilevazione.getDataFine()!=null && !"".equals(rilevazione.getDataFine().trim())){        
		      tod1001Istanzarilevazione.setDatFinVal(CommonsUtility.parse(rilevazione.getDataFine()));
		      tod1001Istanzarilevazione
				.setTod1007Tipostato(cambioStato(Long.parseLong(TIPO_STATO_RILEVAZIONE.CHIUSA.getCodice())));
		  }

		return tod1001IstanzarilevazioneRepository.saveAndFlush(tod1001Istanzarilevazione);

	}

	public Tod1007Tipostato cambioStato(Long stato) {
		Tod1007Tipostato oTod1007Tipostato = new Tod1007Tipostato();
		oTod1007Tipostato.setCodTipSta(stato);
		return oTod1007Tipostato;

	}

	@Override
	@Transactional
	public void insertFieldCampione(Long prgIstRil, String descPrpRil, String codPrpRil, int id) {

		logger.debug("in inserimento");

		Tod1013Gestpropristanza oTod1013Gestpropristanza = new Tod1013Gestpropristanza();
		oTod1013Gestpropristanza.setPrgPrpIst(Long.valueOf(id));
		Tod1001Istanzarilevazione tod1001 = new Tod1001Istanzarilevazione();
		tod1001.setPrgIstRil(prgIstRil);
		oTod1013Gestpropristanza.setTod1001Istanzarilevazione(tod1001);
		oTod1013Gestpropristanza.setCodPrpRil(codPrpRil);
		oTod1013Gestpropristanza.setDesPrpRil(descPrpRil);
		oTod1013Gestpropristanza.setDatOraUltMov(CommonsUtility.getTodayDate());
		tod1013GestpropristanzaRepository.saveAndFlush(oTod1013Gestpropristanza);

	}

	

	@Override
	@Transactional
	public void pubblicaRilevazione(Boolean isFiltered) {

		tod1019PubrispostadomandascuRepository.deleteAll();

		// prendo la rilevazione validata
		Tod1001Istanzarilevazione istanzarilevazione = tod1001IstanzarilevazioneRepository
				.findByTod1007TipostatoCodTipSta(new Long(TIPO_STATO_RILEVAZIONE.APERTA.getCodice()));
		Long idRilevazione = istanzarilevazione.getPrgIstRil();

		// PRENDo I FILTRI E li APPLICo nel for


		boolean isContinue = false;
		Date dataPubblicazione = CommonsUtility.getTodayDate();

		List<Tod1018Vallimris> tod1018VallimrisList = null;
		if (isFiltered) {
			tod1018VallimrisList = tod1018VallimrisRepository.findByPrgIstRil(idRilevazione);
		}

		List<Tod1015Valrispostadomandascu> tod1015ValrispostadomandascuList = tod1015ValrispostadomandascuRepository
				.findByIdPrgIstRil(idRilevazione);
		for (Tod1015Valrispostadomandascu tod1015Valrispostadomandascu : tod1015ValrispostadomandascuList) {
			if (isFiltered) {
				for (Tod1018Vallimris tod1018Vallimris : tod1018VallimrisList) {
					if (tod1018Vallimris.getCodDmd().equals(tod1015Valrispostadomandascu.getId().getCodDmd())) {

						if (new Long(tod1015Valrispostadomandascu.getDesRis()) < tod1018Vallimris.getNumValMin()
								|| new Long(tod1015Valrispostadomandascu.getDesRis()) > tod1018Vallimris
										.getNumValMas()) {
							isContinue = true;
							break;
						}
					} else {
						isContinue = false;
					}
				}
				if (isContinue) {
					continue;
				}
			}
			Tod1019Pubrispostadomandascu tod1019Pubrispostadomandascu = new Tod1019Pubrispostadomandascu();
			Tod1019PubrispostadomandascuPK pk = new Tod1019PubrispostadomandascuPK();
			pk.setCodDmd(tod1015Valrispostadomandascu.getId().getCodDmd());
			pk.setCodEdi(tod1015Valrispostadomandascu.getId().getCodEdi());
			pk.setCodForScu(tod1015Valrispostadomandascu.getId().getCodForScu());
			pk.setCodQst(tod1015Valrispostadomandascu.getId().getCodQst());
			pk.setPrgIstRil(tod1015Valrispostadomandascu.getId().getPrgIstRil());
			pk.setPrgRisDmdScu(tod1015Valrispostadomandascu.getId().getPrgRisDmdScu());
			tod1019Pubrispostadomandascu.setId(pk);
			tod1019Pubrispostadomandascu.setDatPubRis(dataPubblicazione);
			tod1019Pubrispostadomandascu.setDesPriRis(tod1015Valrispostadomandascu.getDesPriRis());
			tod1019Pubrispostadomandascu.setDesRis(tod1015Valrispostadomandascu.getDesRis());
			tod1019Pubrispostadomandascu.setDesSecRis(tod1015Valrispostadomandascu.getDesSecRis());

			tod1019PubrispostadomandascuRepository.save(tod1019Pubrispostadomandascu);

			isContinue = false;
		}

	}

	@Override
	@Transactional
	public void approvaQuestionario(String idQst) {
		Tod1002Anagrafequestionario ent = tod1002AnagrafequestionarioRepository.findOne(idQst);
		Tod1007Tipostato tip = new Tod1007Tipostato();
		tip.setCodTipSta(new Long(TIPO_STATO_RILEVAZIONE.QST_APPROVATO_GEST.getCodice()));
		ent.setTod1007Tipostato(tip);
		tod1002AnagrafequestionarioRepository.save(ent);
	}

	public RilevazioneDTO approvaRilevazione() {
		// prendo l'unica rilevazione in bozza se c'è//cambio in Aperta
		Tod1001Istanzarilevazione tod1001Istanzarilevazione = tod1001IstanzarilevazioneRepository.findByTod1007TipostatoCodTipSta(new Long(TIPO_STATO_RILEVAZIONE.BOZZA.getCodice()));	
		// prendo tutti i questionari di quella rilevazione se tutti approvati approvo
		// la rilevazione
		boolean isToApprove = true;
		RilevazioneDTO out = null;
		List<Tod1002Anagrafequestionario> list = tod1002AnagrafequestionarioRepository
				.findByTod1001IstanzarilevazionePrgIstRil(tod1001Istanzarilevazione.getPrgIstRil());
		for (Tod1002Anagrafequestionario tod1002Anagrafequestionario : list) {
			if (tod1002Anagrafequestionario.getTod1007Tipostato()
					.getCodTipSta() != new Long(TIPO_STATO_RILEVAZIONE.QST_APPROVATO_GEST.getCodice())) {
				isToApprove = false;
				break;
			}
		}

		if (isToApprove) {

			Tod1007Tipostato tip = new Tod1007Tipostato();
			tip.setCodTipSta(new Long(TIPO_STATO_RILEVAZIONE.APPROVATO.getCodice()));
			tod1001Istanzarilevazione.setTod1007Tipostato(tip);

			tod1001Istanzarilevazione = tod1001IstanzarilevazioneRepository.save(tod1001Istanzarilevazione);
			if (tod1001Istanzarilevazione != null) {
				out = new RilevazioneDTO();
				out.setId(tod1001Istanzarilevazione.getPrgIstRil());
				out.setDataFine(tod1001Istanzarilevazione.getDatFinVal());
				out.setDataInizio(tod1001Istanzarilevazione.getDatIniVal());
				out.setDescrizione(tod1001Istanzarilevazione.getDesIstRil());
				// out.setDescrizione(tod1001Istanzarilevazione.getTod1007Tipostato().getDesTipSta());
			}

		}
		return out;
	}

}