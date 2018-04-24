package it.istruzione.ossscudig.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.istruzione.ossscudig.constant.Constants;
import it.istruzione.ossscudig.constant.DOMANDE_RIPETUTE_EDIFICIO;
import it.istruzione.ossscudig.constant.DOMANDE_RIPETUTE_PLESSO;
import it.istruzione.ossscudig.constant.TIPO_STATO_QUESTIONARIO;
import it.istruzione.ossscudig.constant.TIPO_STATO_RILEVAZIONE;
import it.istruzione.ossscudig.constant.TIPO_STATO_SEZIONE;
import it.istruzione.ossscudig.controllers.util.CommonsUtility;
import it.istruzione.ossscudig.model.dto.DomandaDTO;
import it.istruzione.ossscudig.model.dto.EdificioDTO;
import it.istruzione.ossscudig.model.dto.GruppoDomandaDTO;
import it.istruzione.ossscudig.model.dto.RispostaDTO;
import it.istruzione.ossscudig.model.dto.ScuolaDTO;
import it.istruzione.ossscudig.model.dto.SezioneDTO;
import it.istruzione.ossscudig.model.dto.StatoQuestionarioDTO;
import it.istruzione.ossscudig.model.dto.VoceDTO;
import it.istruzione.ossscudig.model.entity.Tod1002Anagrafequestionario;
import it.istruzione.ossscudig.model.entity.Tod1003Anagrafesezione;
import it.istruzione.ossscudig.model.entity.Tod1004Anagrafedomanda;
import it.istruzione.ossscudig.model.entity.Tod1007Tipostato;
import it.istruzione.ossscudig.model.entity.Tod1008Statorilevazscuola;
import it.istruzione.ossscudig.model.entity.Tod1008StatorilevazscuolaPK;
import it.istruzione.ossscudig.model.entity.Tod1009Statoquestscuola;
import it.istruzione.ossscudig.model.entity.Tod1009StatoquestscuolaPK;
import it.istruzione.ossscudig.model.entity.Tod1010Statosezionescuola;
import it.istruzione.ossscudig.model.entity.Tod1010StatosezionescuolaPK;
import it.istruzione.ossscudig.model.entity.Tod1012Anagrafevoce;
import it.istruzione.ossscudig.model.entity.Tod1014Rispostadomandascu;
import it.istruzione.ossscudig.model.entity.Tod1014RispostadomandascuPK;
import it.istruzione.ossscudig.model.entity.Tod1015Valrispostadomandascu;
import it.istruzione.ossscudig.model.entity.Tod1015ValrispostadomandascuPK;
import it.istruzione.ossscudig.model.entity.Tod1017Otrispostevecrilevaz;
import it.istruzione.ossscudig.model.entity.Tod1017OtrispostevecrilevazPK;
import it.istruzione.ossscudig.repository.Tod1002AnagrafequestionarioRepository;
import it.istruzione.ossscudig.repository.Tod1003AnagrafesezioneRepository;
import it.istruzione.ossscudig.repository.Tod1008StatorilevazscuolaRepository;
import it.istruzione.ossscudig.repository.Tod1009StatoquestscuolaRepository;
import it.istruzione.ossscudig.repository.Tod1010StatosezionescuolaRepository;
import it.istruzione.ossscudig.repository.Tod1014RispostadomandascuRepository;
import it.istruzione.ossscudig.repository.Tod1015ValrispostadomandascuRepository;
import it.istruzione.ossscudig.repository.Tod1017OtrispostevecrilevazRepository;
import it.istruzione.ossscudig.services.AcquisizioneRilevazioneService;
import it.istruzione.ossscudig.services.AnagrafeQuestionarioService;
import it.istruzione.ossscudig.services.AnagrafeScuolaService;
import it.istruzione.ossscudig.services.AnagrafeSezioneService;

@Service
public class AcquisizioneRilevazioneServiceImpl implements AcquisizioneRilevazioneService{
	
	private static Logger logger = Logger.getLogger(AcquisizioneRilevazioneServiceImpl.class);
	
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
	Tod1017OtrispostevecrilevazRepository tod1017OtrispostevecrilevazRepository;
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public SezioneDTO loadSezione(String idSezione, 
			   					  String codiceForteScuola,
			   					  String idQuestionario,
			   					  boolean validata){
		
		SezioneDTO sezioneDTO = null;
		SezioneDTO out = new SezioneDTO();

//		if (codiceEdificio == null || codiceEdificio.trim().equals("")){
//			codiceEdificio = Constants.DEFAULT_COD_EDI;
//		}
		
		//recupero oggetto anagrafica sezione
		Tod1003Anagrafesezione tod1003Anagrafesezione = tod1003AnagrafesezioneRepository.findOne(idSezione);
		if (tod1003Anagrafesezione != null){
			sezioneDTO = new SezioneDTO();
			sezioneDTO.setIdSezione(tod1003Anagrafesezione.getCodSez());
			sezioneDTO.setDescrizioneSezione(tod1003Anagrafesezione.getDesSez());
			Tod1002Anagrafequestionario tod1002Anagrafequestionario = tod1002AnagrafequestionarioRepository.findOne(idQuestionario);
			if (tod1002Anagrafequestionario != null){
				sezioneDTO.setIdQuestionario(tod1002Anagrafequestionario.getCodQst());
				sezioneDTO.setDescrizioneQuestionario(tod1002Anagrafequestionario.getDesQst());
				
				/** recupero lista edifici e lista plessi TODO - da fare solo per le sezioni che le utilizzano **/
				//plessi : se vuoto vuol dire che il codice scuola non è di un Istituto Principale
				List<ScuolaDTO> plessi = anagrafeScuolaService.getScuoleAssociate(codiceForteScuola,tod1002Anagrafequestionario.getTod1001Istanzarilevazione().getPrgIstRil());
				List<EdificioDTO> edifici = null;
				ScuolaDTO scuolaDTO = anagrafeScuolaService.getScuola(codiceForteScuola);
				if (scuolaDTO != null){
					edifici = anagrafeScuolaService.getEdificiPerPlesso(scuolaDTO.getCodiceMeccanografico());
				}
				
				if (tod1003Anagrafesezione.getTod1004Anagrafedomandas() != null){
					
					List<GruppoDomandaDTO> gruppiDomande = new ArrayList<>();
					sezioneDTO.setGruppiDomande(gruppiDomande);
					
					GruppoDomandaDTO currentGroup = null;
					logger.debug("-------------------------size "+tod1003Anagrafesezione.getTod1004Anagrafedomandas().size());
					for (Tod1004Anagrafedomanda tod1004Anagrafedomanda : tod1003Anagrafesezione.getTod1004Anagrafedomandas()){
						
						if(tod1004Anagrafedomanda==null)
							continue;
						
						boolean isDomandaDaRipeterePerOgniEdificio = false;
						boolean isDomandaDaRipeterePerOgniPlesso = false;
						boolean isDomandaDefault = false;
						logger.debug("recupero domanda : " + tod1004Anagrafedomanda.getCodDmd());
						if (DOMANDE_RIPETUTE_EDIFICIO.contains(tod1004Anagrafedomanda.getCodDmd())){
							logger.debug("DOMANDE_RIPETUTE_EDIFICIO");
							isDomandaDaRipeterePerOgniEdificio = true;
						}else if (DOMANDE_RIPETUTE_PLESSO.contains(tod1004Anagrafedomanda.getCodDmd())){
							logger.debug("DOMANDE_RIPETUTE_PLESSO");
							isDomandaDaRipeterePerOgniPlesso = true;
						}else{
							isDomandaDefault = true;
						}
						
						DomandaDTO domandaDTO = this.createDomandaDTO(tod1004Anagrafedomanda, Constants.DEFAULT_COD_EDI, codiceForteScuola, tod1002Anagrafequestionario,isDomandaDaRipeterePerOgniEdificio,isDomandaDaRipeterePerOgniPlesso,isDomandaDefault,validata,idSezione);
						if (currentGroup == null || !currentGroup.getTipoGruppo().equals(domandaDTO.getTipoGruppo())){
							currentGroup = new GruppoDomandaDTO();
							gruppiDomande.add(currentGroup);
							List<DomandaDTO> domande = new ArrayList<>();
							domande.add(domandaDTO);
							currentGroup.setTipoGruppo(domandaDTO.getTipoGruppo());
							currentGroup.setDomande(domande);
						}else{
							//aggiungo la domanda al gruppo
							currentGroup.getDomande().add(domandaDTO);
						}

						
					}//end for domande
					
				}
				
				/** 
				 * sezioneDTO contiene l'elenco dei gruppi domande
				 * occorre replicare ogni gruppo di tipo plesso o edifici per ogni plesso/edificio
				 * impostando il valore cod_edi per ogni domanda nel gruppo
				**/
				
				out.setCodiceForteScuola(sezioneDTO.getCodiceForteScuola());
				out.setDescrizioneQuestionario(sezioneDTO.getDescrizioneQuestionario());
				out.setDescrizioneSezione(sezioneDTO.getDescrizioneSezione());
				List<GruppoDomandaDTO> totaleGruppiDomande = new ArrayList<>();
				out.setGruppiDomande(totaleGruppiDomande);
				out.setIdQuestionario(sezioneDTO.getIdQuestionario());
				out.setIdSezione(sezioneDTO.getIdSezione());
				out.setStato(sezioneDTO.getStato());
				for (GruppoDomandaDTO gruppoDomandaDTO : sezioneDTO.getGruppiDomande()) {
					if (gruppoDomandaDTO.getTipoGruppo().equals("D")){
						totaleGruppiDomande.add(gruppoDomandaDTO);
					}else if (gruppoDomandaDTO.getTipoGruppo().equals("E")){
						//aggiungo il gruppo all'out per ogni edificio
						if (edifici != null){
							for (EdificioDTO edificioDTO : edifici) {
								GruppoDomandaDTO gruppoToAdd = this.createGruppo(gruppoDomandaDTO, edificioDTO.getCodEdi(), edificioDTO.getIndirizzo(), codiceForteScuola, tod1002Anagrafequestionario, validata);
								totaleGruppiDomande.add(gruppoToAdd);
							}
						}
					}else if (gruppoDomandaDTO.getTipoGruppo().equals("P")){
						//aggiungo il gruppo all'out per ogni plesso
						if (plessi != null){
							for (ScuolaDTO plesso : plessi) {
								GruppoDomandaDTO gruppoToAdd = this.createGruppo(gruppoDomandaDTO, plesso.getCodiceMeccanografico(), plesso.getIndirizzo(), codiceForteScuola, tod1002Anagrafequestionario, validata);
								totaleGruppiDomande.add(gruppoToAdd);
							}
						}
					}
				}

			}

		}//end if (tod1003Anagrafesezione != null)
		
		return out;
	}
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public StatoQuestionarioDTO getStatoQuestionarioScuola(String codForScu, 
															  long prgIstRil,
															  String codQst){
		
		StatoQuestionarioDTO out = new StatoQuestionarioDTO();
		Tod1009StatoquestscuolaPK pk = new Tod1009StatoquestscuolaPK();
		pk.setCodForScu(codForScu);
		pk.setPrgIstRil(prgIstRil);
		pk.setCodQst(codQst);
		Tod1009Statoquestscuola entity = tod1009StatoquestscuolaRepository.findOne(pk);
		if (entity != null && entity.getTod1007Tipostato() != null){
			out.setTipoStato(TIPO_STATO_QUESTIONARIO.getInstanceFromCode(String.valueOf(entity.getTod1007Tipostato().getCodTipSta())));
			out.setDataUltimaModifica(entity.getDatOraUltMov());
		} else {
			out.setTipoStato(TIPO_STATO_QUESTIONARIO.NON_COMPILATO);
		}
		return out;
	}
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public TIPO_STATO_SEZIONE getStatoSezioneScuola(String codForScu, 
													long prgIstRil,
													String codQst,
													String codSezione){
		
		TIPO_STATO_SEZIONE out = null;
		Tod1010StatosezionescuolaPK pk = new Tod1010StatosezionescuolaPK();
		pk.setCodForScu(codForScu);
		pk.setPrgIstRil(prgIstRil);
		pk.setCodQst(codQst);
		pk.setCodSez(codSezione);
		Tod1010Statosezionescuola entity = tod1010StatosezionescuolaRepository.findOne(pk);
		if (entity != null && entity.getTod1007Tipostato() != null){
			out = TIPO_STATO_SEZIONE.getInstanceFromCode(String.valueOf(entity.getTod1007Tipostato().getCodTipSta()));
		}
		if (out == null){
			out = TIPO_STATO_SEZIONE.NON_COMPILATA;
		}
		return out;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public TIPO_STATO_RILEVAZIONE getStatoRilevazioneScuola(String codForScu, 
															long prgIstRil){
		
		TIPO_STATO_RILEVAZIONE out = null;
		Tod1008StatorilevazscuolaPK pk = new Tod1008StatorilevazscuolaPK();
		pk.setCodForScu(codForScu);
		pk.setPrgIstRil(prgIstRil);
		Tod1008Statorilevazscuola entity = tod1008StatorilevazscuolaRepository.findOne(pk);
		if (entity != null && entity.getTod1007Tipostato() != null){
			out = TIPO_STATO_RILEVAZIONE.getInstanceFromCode(String.valueOf(entity.getTod1007Tipostato().getCodTipSta()));
		}
		if (out == null){
			out = TIPO_STATO_RILEVAZIONE.APERTA;
		}
		return out;
	}
	
	@Override
	@Transactional
	public void saveSezione(String idSezione, 
				    	    String codiceForteScuola,
				    	    Long prgIstRil,
				    	    List<RispostaDTO> risposte,
				    	    String idQuestionario,
				    	    boolean isComplete){
		
		logger.debug("in saveSezione");
		
		/* cancello le eventuali risposte presenti sul DB per tutte le domande della sezione */
		List<Tod1014Rispostadomandascu> risposteDomandeSezione = tod1014RispostadomandascuRepository.findRisposteDomandeBySezione(codiceForteScuola, 
																										   prgIstRil,
																										   idSezione,
																										   idQuestionario);
		
		for (Tod1014Rispostadomandascu tod1014Rispostadomandascu : risposteDomandeSezione) {
			tod1014RispostadomandascuRepository.delete(tod1014Rispostadomandascu);
		}
		
		
		for (RispostaDTO rispostaDTO : risposte){
			
			//String codDmd = StringUtils.remove(rispostaDTO.getCodDmd(), Constants.PREFIX_DOM);
			String codDmd = CommonsUtility.getCodDmdFromParam(rispostaDTO.getCodDmd());
			String codEdi = CommonsUtility.getCodEdiFromParam(rispostaDTO.getCodDmd());
			
			logger.debug("elaborazione codDmd : " + codDmd);
			logger.debug("elaborazione codEdi : " + codEdi);
			
			if (codEdi == null || codEdi.trim().equals("")){
				codEdi = Constants.DEFAULT_COD_EDI;
			}
			for (int i=0; i<rispostaDTO.getRisposte().size(); i++){
				
				Tod1014RispostadomandascuPK pk = new Tod1014RispostadomandascuPK();
				pk.setCodDmd(codDmd);
				pk.setCodEdi(codEdi);
				pk.setCodForScu(codiceForteScuola);
				pk.setCodQst(idQuestionario);
				pk.setPrgIstRil(prgIstRil);
				pk.setPrgRisDmdScu(i+1);
				Tod1014Rispostadomandascu entity = new Tod1014Rispostadomandascu();
				entity.setId(pk);
				entity.setDesRis(rispostaDTO.getRisposte().get(i));

				tod1014RispostadomandascuRepository.save(entity);
			}
		}
		
		//cambio lo stato della rilevazione, questionario e sezione
		Tod1008StatorilevazscuolaPK pkRil = new Tod1008StatorilevazscuolaPK();
		pkRil.setCodForScu(codiceForteScuola);
		pkRil.setPrgIstRil(prgIstRil);
		Tod1007Tipostato tod1007TipostatoRil = new Tod1007Tipostato();
		tod1007TipostatoRil.setCodTipSta(Long.valueOf(TIPO_STATO_RILEVAZIONE.IN_COMPILAZIONE.getCodice()));
		Tod1008Statorilevazscuola entityRil = new Tod1008Statorilevazscuola();
		entityRil.setId(pkRil);
		entityRil.setTod1007Tipostato(tod1007TipostatoRil);
		tod1008StatorilevazscuolaRepository.save(entityRil);
		
		Tod1009StatoquestscuolaPK pkQst = new Tod1009StatoquestscuolaPK();
		pkQst.setCodForScu(codiceForteScuola);
		pkQst.setPrgIstRil(prgIstRil);
		pkQst.setCodQst(idQuestionario);
		Tod1007Tipostato tod1007TipostatoQst = new Tod1007Tipostato();
		tod1007TipostatoQst.setCodTipSta(Long.valueOf(TIPO_STATO_QUESTIONARIO.IN_COMPILAZIONE.getCodice()));
		Tod1009Statoquestscuola entityQst = new Tod1009Statoquestscuola();
		entityQst.setId(pkQst);
		entityQst.setTod1007Tipostato(tod1007TipostatoQst);
		tod1009StatoquestscuolaRepository.save(entityQst);
		
		Tod1010StatosezionescuolaPK pk = new Tod1010StatosezionescuolaPK();
		pk.setCodForScu(codiceForteScuola);
		pk.setPrgIstRil(prgIstRil);
		pk.setCodQst(idQuestionario);
		pk.setCodSez(idSezione);
		Tod1007Tipostato tod1007Tipostato = new Tod1007Tipostato();
		if (isComplete){
			tod1007Tipostato.setCodTipSta(Long.valueOf(TIPO_STATO_SEZIONE.COMPILATA.getCodice()));
		}else{
			tod1007Tipostato.setCodTipSta(Long.valueOf(TIPO_STATO_SEZIONE.IN_COMPILAZIONE.getCodice()));
		}
		Tod1010Statosezionescuola entity = new Tod1010Statosezionescuola();
		entity.setId(pk);
		entity.setTod1007Tipostato(tod1007Tipostato);
		tod1010StatosezionescuolaRepository.save(entity);
		
		/** se tutte le sezioni sono compilate imposto lo stato del questionario a compilato **/
		List<SezioneDTO> sezioni = anagrafeSezioneService.findSezioniQuestionario(idQuestionario);
		/** imposto lo stato per ogni sezione **/
		for (SezioneDTO sezioneDTO : sezioni) {
			sezioneDTO.setCodiceForteScuola(codiceForteScuola);
			sezioneDTO.setStato(this.getStatoSezioneScuola(codiceForteScuola, prgIstRil, idQuestionario, sezioneDTO.getIdSezione()));
		}
		int nSez = sezioni.size();
		int nSezCompilate = 0;
		for (SezioneDTO sezioneDTO : sezioni) {
			if (sezioneDTO.getStato() == TIPO_STATO_SEZIONE.COMPILATA){
				nSezCompilate ++;
			}
		}
		
		if (nSez == nSezCompilate){
			tod1007TipostatoQst = new Tod1007Tipostato();
			tod1007TipostatoQst.setCodTipSta(Long.valueOf(TIPO_STATO_QUESTIONARIO.COMPILATO.getCodice()));
			entityQst.setTod1007Tipostato(tod1007TipostatoQst);
			tod1009StatoquestscuolaRepository.save(entityQst);
		}

		
	}
	
	private DomandaDTO createDomandaDTO(Tod1004Anagrafedomanda tod1004Anagrafedomanda, 
										String codEdi, 
										String codiceForteScuola, 
										Tod1002Anagrafequestionario tod1002Anagrafequestionario,
										boolean isDomandaDaRipeterePerOgniEdificio,
										boolean isDomandaDaRipeterePerOgniPlesso,
										boolean isDomandaDefault,
										boolean validata,
										String idSezione){
		
		DomandaDTO domandaDTO = new DomandaDTO();
		domandaDTO.setId(tod1004Anagrafedomanda.getCodDmd());
		domandaDTO.setFlgObb(tod1004Anagrafedomanda.getFlgObb());

		String[] listaP = tod1004Anagrafedomanda.getCodIdeDmd().split("\\.");
		domandaDTO.setLivelli(listaP.length);
		domandaDTO.setCodIdeDomanda(tod1004Anagrafedomanda.getCodIdeDmd().replace(".", ""));
		domandaDTO.setTestoDomanda(tod1004Anagrafedomanda.getDesDmd());
		domandaDTO.setTipoRisposta(tod1004Anagrafedomanda.getTod1005Tipodomanda().getCodTipDmd());
		domandaDTO.setCodEdi(codEdi);
		
		if (isDomandaDaRipeterePerOgniEdificio){
			domandaDTO.setTipoGruppo("E");
		}else if (isDomandaDaRipeterePerOgniPlesso){
			domandaDTO.setTipoGruppo("P");
		}else if (isDomandaDefault){
			domandaDTO.setTipoGruppo("D");
		}

		TIPO_STATO_SEZIONE stato_sezione = this.getStatoSezioneScuola(codiceForteScuola, 
										   tod1002Anagrafequestionario.getTod1001Istanzarilevazione().getPrgIstRil(), 
										   tod1002Anagrafequestionario.getCodQst(),
										   idSezione);

		/**	se lo stato della sezione è diverso da NON COMPILATA
		recupero l'eventuale risposta per la domanda cod_dmd 
		(lista in caso di risposte multiple possibili solo per risposte chiuse con gruppo voce) **/
		
		HashMap<String, String> mapRisposte = new HashMap<>();
		
		if (stato_sezione != TIPO_STATO_SEZIONE.NON_COMPILATA){
			List<Tod1014Rispostadomandascu> risposte = null;
			List<Tod1015Valrispostadomandascu> risposteSezioneValidata = null;
			if (!validata){
				risposte = tod1014RispostadomandascuRepository.
						findByIdCodForScuAndIdPrgIstRilAndIdCodDmdAndIdCodEdiAndIdCodQst(codiceForteScuola, 
								tod1002Anagrafequestionario.getTod1001Istanzarilevazione().getPrgIstRil(), 
								tod1004Anagrafedomanda.getCodDmd(), 
								codEdi,
								tod1002Anagrafequestionario.getCodQst());
			}else{
				risposteSezioneValidata = tod1015ValrispostadomandascuRepository.
						findByIdCodForScuAndIdPrgIstRilAndIdCodDmdAndIdCodEdiAndIdCodQst(codiceForteScuola, 
								tod1002Anagrafequestionario.getTod1001Istanzarilevazione().getPrgIstRil(), 
								tod1004Anagrafedomanda.getCodDmd(), 
								codEdi,
								tod1002Anagrafequestionario.getCodQst());
			}
			
			if (!validata){
				if (risposte != null && !risposte.isEmpty()){
					for (Tod1014Rispostadomandascu tod1014Rispostadomandascu : risposte) {
						mapRisposte.put(tod1014Rispostadomandascu.getDesRis(), tod1014Rispostadomandascu.getDesRis());
					}
				}
			}else{
				if (risposteSezioneValidata != null && !risposteSezioneValidata.isEmpty()){
					for (Tod1015Valrispostadomandascu tod1015Valrispostadomandascu : risposteSezioneValidata) {
						mapRisposte.put(tod1015Valrispostadomandascu.getDesRis(), tod1015Valrispostadomandascu.getDesRis());
					}
				}
			}
		}else{
			/**	se lo stato della sezione è NON COMPILATA
			recupero l'eventuale risposta per la domanda cod_dmd dalla vecchia rilevazione
			(lista in caso di risposte multiple possibili solo per risposte chiuse con gruppo voce) **/
			
			Tod1017OtrispostevecrilevazPK pk = new Tod1017OtrispostevecrilevazPK();
			pk.setCodForScu(codiceForteScuola);
			pk.setCodIdeDmd(tod1004Anagrafedomanda.getCodIdeDmd());
			Tod1017Otrispostevecrilevaz tod1017Otrispostevecrilevaz = tod1017OtrispostevecrilevazRepository.findOne(pk);
			if (tod1017Otrispostevecrilevaz != null && tod1017Otrispostevecrilevaz.getDesRisOst() != null){
				String[] risposteOldRil = tod1017Otrispostevecrilevaz.getDesRisOst().split(",");
				for (String risp : risposteOldRil) {
					mapRisposte.put(risp, risp);
				}
				
			}
			
		}
		
		//imposto la risposta su domandaDTO
		if (tod1004Anagrafedomanda.getTod1011Gruppovoce() != null &&
				tod1004Anagrafedomanda.getTod1011Gruppovoce().getTod1012Anagrafevoces() != null){

			//gruppo voce != null quindi risposta singola o multipla selezionata da voce
			List<VoceDTO> voci = new ArrayList<>();
			for (Tod1012Anagrafevoce tod1012Anagrafevoce : tod1004Anagrafedomanda.getTod1011Gruppovoce().getTod1012Anagrafevoces()) {
				if(tod1012Anagrafevoce==null)
					continue;
				VoceDTO voce = new VoceDTO();
				voce.setId(String.valueOf(tod1012Anagrafevoce.getPrgVoc()));
				voce.setDescrizione(tod1012Anagrafevoce.getDesVoc());
				voce.setChecked(mapRisposte.containsKey(voce.getId()));
				voci.add(voce);
			}
			domandaDTO.setVoci(voci);
		}else{
			//gruppo voce = null quindi risposta singola su campo di testo
			String valoreRisposta = "";
			/*if (!validata){
				if (risposte != null && !risposte.isEmpty()){
					valoreRisposta = risposte.get(0).getDesRis();
				}
			}else{
				if (risposteSezioneValidata != null && !risposteSezioneValidata.isEmpty()){
					valoreRisposta = risposteSezioneValidata.get(0).getDesRis();
				}
			}*/
			if (mapRisposte != null && !mapRisposte.isEmpty()){
				valoreRisposta = mapRisposte.values().iterator().next();
			}
			domandaDTO.setValoreRisposta(valoreRisposta);
		}
		
		return domandaDTO;
	}
	
	/** replicare il gruppo di tipo input
	 *  impostando il valore cod_edi per ogni domanda nel gruppo
	**/
	private GruppoDomandaDTO createGruppo(GruppoDomandaDTO gruppoIn, String codEdi, String indirizzo, String codiceForteScuola, Tod1002Anagrafequestionario tod1002Anagrafequestionario, boolean validata){
		
		GruppoDomandaDTO out = new GruppoDomandaDTO();
		out.setCodEdi(codEdi);
		out.setIndirizzo(indirizzo);
		out.setTipoGruppo(gruppoIn.getTipoGruppo());
		List<DomandaDTO> domande = new ArrayList<>();
		out.setDomande(domande);
		for (DomandaDTO dto : gruppoIn.getDomande()) {
			DomandaDTO newDomandaDTO = new DomandaDTO();
			newDomandaDTO.setCodEdi(codEdi);
			newDomandaDTO.setCodIdeDomanda(dto.getCodIdeDomanda());
			newDomandaDTO.setId(dto.getId());
			newDomandaDTO.setFlgObb(dto.getFlgObb());
			newDomandaDTO.setLivelli(dto.getLivelli());
			newDomandaDTO.setTestoDomanda(dto.getTestoDomanda());
			newDomandaDTO.setTipoGruppo(dto.getTipoGruppo());
			newDomandaDTO.setTipoRisposta(dto.getTipoRisposta());
			//newDomandaDTO.setValoreRisposta(valoreRisposta);
			//newDomandaDTO.setVoci(voci);
			
			//recupero l'eventuale risposta per la domanda cod_dmd (lista in caso di risposte multiple possibili solo per risposte chiuse con gruppo voce)
			List<Tod1014Rispostadomandascu> risposte = null;
			List<Tod1015Valrispostadomandascu> risposteSezioneValidata = null;
			if (!validata){
				risposte = tod1014RispostadomandascuRepository.
						findByIdCodForScuAndIdPrgIstRilAndIdCodDmdAndIdCodEdiAndIdCodQst(codiceForteScuola, 
								tod1002Anagrafequestionario.getTod1001Istanzarilevazione().getPrgIstRil(), 
								dto.getId(), 
								codEdi,
								tod1002Anagrafequestionario.getCodQst());
			}else{
				risposteSezioneValidata = tod1015ValrispostadomandascuRepository.
						findByIdCodForScuAndIdPrgIstRilAndIdCodDmdAndIdCodEdiAndIdCodQst(codiceForteScuola, 
								tod1002Anagrafequestionario.getTod1001Istanzarilevazione().getPrgIstRil(), 
								dto.getId(), 
								codEdi,
								tod1002Anagrafequestionario.getCodQst());
			}
			HashMap<String, String> mapRisposte = new HashMap<>();
			if (!validata){
				if (risposte != null && !risposte.isEmpty()){
					for (Tod1014Rispostadomandascu tod1014Rispostadomandascu : risposte) {
						mapRisposte.put(tod1014Rispostadomandascu.getDesRis(), tod1014Rispostadomandascu.getDesRis());
					}
				}
			}else{
				if (risposteSezioneValidata != null && !risposteSezioneValidata.isEmpty()){
					for (Tod1015Valrispostadomandascu tod1015Valrispostadomandascu : risposteSezioneValidata) {
						mapRisposte.put(tod1015Valrispostadomandascu.getDesRis(), tod1015Valrispostadomandascu.getDesRis());
					}
				}
			}

			if (dto.getVoci() != null && !dto.getVoci().isEmpty()){

				//gruppo voce != null quindi risposta singola o multipla selezionata da voce
				List<VoceDTO> voci = new ArrayList<>();
				for (VoceDTO voceIn : dto.getVoci()) {
					if(voceIn==null)
						continue;
					VoceDTO voce = new VoceDTO();
					voce.setId(voceIn.getId());
					voce.setDescrizione(voceIn.getDescrizione());
					voce.setChecked(mapRisposte.containsKey(voce.getId()));
					voci.add(voce);
				}
				newDomandaDTO.setVoci(voci);
			}else{
				//gruppo voce = null quindi risposta singola su campo di testo
				String valoreRisposta = "";
				if (!validata){
					if (risposte != null && !risposte.isEmpty()){
						valoreRisposta = risposte.get(0).getDesRis();
					}
				}else{
					if (risposteSezioneValidata != null && !risposteSezioneValidata.isEmpty()){
						valoreRisposta = risposteSezioneValidata.get(0).getDesRis();
					}
				}
				newDomandaDTO.setValoreRisposta(valoreRisposta);
			}
			
			domande.add(newDomandaDTO);
		}
		
		return out;
	}

	@Override
	@Transactional
	public void validaRilevazione(List<ScuolaDTO> scuole, Long idRilevazione){
		String codForScu = (String)scuole.get(0).getCodiceMeccanograficoIstitutoPrincipale();
		logger.debug("in validaRilevazione : " + codForScu + " - " + idRilevazione);
		Tod1008StatorilevazscuolaPK pkRil = new Tod1008StatorilevazscuolaPK();
		pkRil.setCodForScu(codForScu);
		pkRil.setPrgIstRil(idRilevazione);
		Tod1007Tipostato tod1007TipostatoRil = new Tod1007Tipostato();
		tod1007TipostatoRil.setCodTipSta(Long.valueOf(TIPO_STATO_RILEVAZIONE.VALIDATA.getCodice()));
		Tod1008Statorilevazscuola entityRil = new Tod1008Statorilevazscuola();
		entityRil.setId(pkRil);
		entityRil.setTod1007Tipostato(tod1007TipostatoRil);
		tod1008StatorilevazscuolaRepository.save(entityRil);
		
		for (Iterator iterator = scuole.iterator(); iterator.hasNext();) {
			ScuolaDTO scuolaDTO = (ScuolaDTO) iterator.next();
			
			//spostare tutti i dati dei questionari nella tabella di validazione
			List<Tod1015Valrispostadomandascu> tod1015Valrispostadomandascus = tod1015ValrispostadomandascuRepository.findByIdCodForScuAndIdPrgIstRil(scuolaDTO.getCodiceForte(), idRilevazione);
			for (Tod1015Valrispostadomandascu tod1015Valrispostadomandascu : tod1015Valrispostadomandascus) {
				tod1015ValrispostadomandascuRepository.delete(tod1015Valrispostadomandascu);
			}
			
			Date dataValidazione = CommonsUtility.getTodayDate();
			List<Tod1014Rispostadomandascu> tod1014Rispostadomandascus = tod1014RispostadomandascuRepository.findByIdCodForScuAndIdPrgIstRil(scuolaDTO.getCodiceForte(), idRilevazione);
			for (Tod1014Rispostadomandascu tod1014Rispostadomandascu : tod1014Rispostadomandascus) {
				Tod1015Valrispostadomandascu tod1015Valrispostadomandascu = new Tod1015Valrispostadomandascu();
				Tod1015ValrispostadomandascuPK pk = new Tod1015ValrispostadomandascuPK();
				pk.setCodDmd(tod1014Rispostadomandascu.getId().getCodDmd());
				pk.setCodEdi(tod1014Rispostadomandascu.getId().getCodEdi());
				pk.setCodForScu(tod1014Rispostadomandascu.getId().getCodForScu());
				pk.setCodQst(tod1014Rispostadomandascu.getId().getCodQst());
				pk.setPrgIstRil(tod1014Rispostadomandascu.getId().getPrgIstRil());
				pk.setPrgRisDmdScu(tod1014Rispostadomandascu.getId().getPrgRisDmdScu());
				tod1015Valrispostadomandascu.setId(pk);
				tod1015Valrispostadomandascu.setDatVldRis(dataValidazione);
				tod1015Valrispostadomandascu.setDesPriRis(tod1014Rispostadomandascu.getDesPriRis());
				tod1015Valrispostadomandascu.setDesRis(tod1014Rispostadomandascu.getDesRis());
				tod1015Valrispostadomandascu.setDesSecRis(tod1014Rispostadomandascu.getDesSecRis());
				
				tod1015ValrispostadomandascuRepository.save(tod1015Valrispostadomandascu);
			}
		
		}
	}
	
}
