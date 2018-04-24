package it.istruzione.ossscudig.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dozer.DozerBeanMapper;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.istruzione.ossscudig.constant.Constants;
import it.istruzione.ossscudig.controllers.util.CommonsUtility;
import it.istruzione.ossscudig.model.dto.AnagrafeDomandaDTO;
import it.istruzione.ossscudig.model.dto.DomandaDTO;
import it.istruzione.ossscudig.model.dto.QuestionarioDTO;
import it.istruzione.ossscudig.model.dto.VoceDTO;
import it.istruzione.ossscudig.model.entity.GestioneEntity;
import it.istruzione.ossscudig.model.entity.Tod1001Istanzarilevazione;
import it.istruzione.ossscudig.model.entity.Tod1002Anagrafequestionario;
import it.istruzione.ossscudig.model.entity.Tod1004Anagrafedomanda;
import it.istruzione.ossscudig.model.entity.Tod1012Anagrafevoce;
import it.istruzione.ossscudig.repository.GestioneRepository;
import it.istruzione.ossscudig.repository.Tod1001IstanzarilevazioneRepository;
import it.istruzione.ossscudig.repository.Tod1002AnagrafequestionarioRepository;
import it.istruzione.ossscudig.repository.Tod1004AnagrafedomandaRepository;
import it.istruzione.ossscudig.repository.Tod1012AnagrafevoceRepository;
import it.istruzione.ossscudig.services.AnagrafeQuestionarioService;

@Service
public class AnagrafeQuestionarioServiceImpl implements AnagrafeQuestionarioService{
	
	private static Logger logger = Logger.getLogger(AnagrafeQuestionarioServiceImpl.class);
	
	@Autowired
	private DozerBeanMapper rdDozerMapper;
	
	@Autowired
	private Tod1001IstanzarilevazioneRepository tod1001IstanzarilevazioneRepository;
	
	@Autowired
	private Tod1002AnagrafequestionarioRepository tod1002AnagrafequestionarioRepository;
	
	@Autowired
	Tod1004AnagrafedomandaRepository tod1004AnagrafedomandaRepository;
	
	@Autowired
	Tod1012AnagrafevoceRepository tod1012AnagrafevoceRepository;
	
	@Autowired
	private GestioneRepository gestioneRepository;


	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
	public Map<String, QuestionarioDTO> findQuestionariByRilevazione(Long idRilevazione) {
		logger.debug("findQuestionariByRilevazione : " + idRilevazione);
		Tod1001Istanzarilevazione tod1001Istanzarilevazione = tod1001IstanzarilevazioneRepository.findOne(idRilevazione);
		Map<String, QuestionarioDTO> questionari = new HashMap<String, QuestionarioDTO>();
		if (tod1001Istanzarilevazione != null){
			List<Tod1002Anagrafequestionario> listaEntita = tod1001Istanzarilevazione.getTod1002Anagrafequestionarios();
			QuestionarioDTO questionarioDTO = null;
			for (Tod1002Anagrafequestionario tod1002Anagrafequestionario : listaEntita) {
				questionarioDTO = new QuestionarioDTO(); 
				questionarioDTO = rdDozerMapper.map(tod1002Anagrafequestionario, QuestionarioDTO.class);
				questionari.put(questionarioDTO.getCodiceQuestionario(), questionarioDTO);
			}
		}
		
		return questionari;
	}
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public QuestionarioDTO getQuestionario(String codQst){
		Tod1002Anagrafequestionario tod1002Anagrafequestionario = tod1002AnagrafequestionarioRepository.findOne(codQst);
		QuestionarioDTO questionarioDTO = rdDozerMapper.map(tod1002Anagrafequestionario, QuestionarioDTO.class);
		return questionarioDTO;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public AnagrafeDomandaDTO getAnagrafeDomandaDTOValidator(String codDmd) {
		AnagrafeDomandaDTO out = null;
		Tod1004Anagrafedomanda tod1004Anagrafedomanda = tod1004AnagrafedomandaRepository.findOne(codDmd);
		if (tod1004Anagrafedomanda != null && tod1004Anagrafedomanda.getTod1006Regolevalidazione() != null
				&& tod1004Anagrafedomanda.getTod1006Regolevalidazione().getDesScrRegVld() != null) {

			out = new AnagrafeDomandaDTO();
			out.setRegExp(tod1004Anagrafedomanda.getTod1006Regolevalidazione().getDesScrRegVld());
			out.setIdRegExp(tod1004Anagrafedomanda.getTod1006Regolevalidazione().getPrgRegVld());
			out.setDesMsgUte(tod1004Anagrafedomanda.getTod1006Regolevalidazione().getDesMsgUte());
		}
		return out;
	}
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public AnagrafeDomandaDTO getAnagrafeDomandaDTO(String codDmd,String prgVoce){
		AnagrafeDomandaDTO out = null;
		Tod1004Anagrafedomanda tod1004Anagrafedomanda = tod1004AnagrafedomandaRepository.findOne(codDmd);
			out = new AnagrafeDomandaDTO();

			if (tod1004Anagrafedomanda.getTod1011Gruppovoce().getDesGrpVoc() != null) {
			out.setDesGrpVoce(tod1004Anagrafedomanda.getTod1011Gruppovoce().getDesGrpVoc());
			
			Tod1012Anagrafevoce tod1012Anagrafevoce =tod1012AnagrafevoceRepository.findOne(Long.parseLong(prgVoce));
		    out.setOrdineVoce(tod1012Anagrafevoce.getNumOrdVoc());

			}
		
		return out;
	}
	


		
		
	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<QuestionarioDTO> getGestioneQuestionario(int codTipSta){
		logger.debug("getGestioneQuestionario : " + codTipSta);
		List<QuestionarioDTO> out = new ArrayList<>();
		List<GestioneEntity> entitys = gestioneRepository.findBozzaRilevazioniPerQuestionari(codTipSta);
		
		for (GestioneEntity oGestioneEntity : entitys) {
			QuestionarioDTO dto = new QuestionarioDTO();
			dto.setCodiceQuestionario(oGestioneEntity.getCodQuestionario());			
			dto.setNome(oGestioneEntity.getQuestionario());			
			dto.setDescrizioneStatoQuestionario(oGestioneEntity.getStato());
			dto.setCodiceRilevazione(oGestioneEntity.getCodRilevazione());
			dto.setCodTipSta(oGestioneEntity.getCodTipSta());
			
			out.add(dto);
		}

		return out;
	}
		
	@Override
	@Transactional
	public void saveSezioneDomande(String idSezione, List<DomandaDTO> domanda) {
		logger.debug("in saveSezioneDomande");
		for (DomandaDTO domandaDTO : domanda) {

			String codDmd = CommonsUtility.getCodDmdFromParam(domandaDTO.getId());
			String codEdi = CommonsUtility.getCodEdiFromParam(domandaDTO.getId());

			logger.debug("elaborazione codDmd : " + codDmd);
			logger.debug("elaborazione codEdi : " + codEdi);

			if (codEdi == null || codEdi.trim().equals("")) {
				codEdi = Constants.DEFAULT_COD_EDI;
			}
			for (int i = 0; i < domandaDTO.getDomande().size(); i++) {
				Tod1004Anagrafedomanda oTod1004Anagrafedomanda = tod1004AnagrafedomandaRepository.findOne(codDmd);
				oTod1004Anagrafedomanda.setDesDmd(domandaDTO.getDomande().get(i));
				oTod1004Anagrafedomanda.setDatOraUltMov(CommonsUtility.getTodayDate());
				tod1004AnagrafedomandaRepository.saveAndFlush(oTod1004Anagrafedomanda);
			}
		}
	}
	
	@Override
	@Transactional
	public void saveSezioneVoci(String idSezione, List<VoceDTO> voce) {
		logger.debug("in saveSezioneDomande");
		for (VoceDTO voceDTO : voce) {

			String codVoc = voceDTO.getId();
			//String codEdi = CommonsUtility.getCodEdiFromParam(voceDTO.getId());

			logger.debug("elaborazione codDmd : " + codVoc);
			//logger.debug("elaborazione codEdi : " + codEdi);

			/*if (codEdi == null || codEdi.trim().equals("")) {
				codEdi = Constants.DEFAULT_COD_EDI;
			}*/
			for (int i = 0; i < voceDTO.getVoci().size(); i++) {
				Tod1012Anagrafevoce oTod1012Anagrafevoce = tod1012AnagrafevoceRepository.findOne(Long.parseLong(codVoc));
				oTod1012Anagrafevoce.setDesVoc(voceDTO.getVoci().get(i));
				oTod1012Anagrafevoce.setDatOraUltMov(CommonsUtility.getTodayDate());
				tod1012AnagrafevoceRepository.saveAndFlush(oTod1012Anagrafevoce);
			}
		}
	}
}
