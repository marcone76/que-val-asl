package it.istruzione.ossscudig.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.istruzione.ossscudig.model.dto.SezioneDTO;
import it.istruzione.ossscudig.model.entity.Tod1003Anagrafesezione;
import it.istruzione.ossscudig.repository.Tod1003AnagrafesezioneRepository;
import it.istruzione.ossscudig.services.AnagrafeSezioneService;

@Service
public class AnagrafeSezioneServiceImpl implements AnagrafeSezioneService{
	
	private static Logger logger = Logger.getLogger(AnagrafeSezioneServiceImpl.class);
	@Autowired
	private DozerBeanMapper rdDozerMapper;
	@Autowired
	private Tod1003AnagrafesezioneRepository sezioneRepository;


	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<SezioneDTO> findSezioniQuestionario(String idQuestionario) {
		logger.debug("findSezioniQuestionario: " + idQuestionario);
		List<Tod1003Anagrafesezione> listaEntita =  sezioneRepository.findByQuestionario(idQuestionario);
		SezioneDTO sezioneDTO = null;
		List<SezioneDTO> sezioni = new ArrayList<SezioneDTO>();
		for (Tod1003Anagrafesezione anagrafesezione : listaEntita) {
			sezioneDTO = new SezioneDTO(); 
			sezioneDTO = rdDozerMapper.map(anagrafesezione, SezioneDTO.class);
			sezioni.add(sezioneDTO);
		}
		
		return sezioni;
	}
}
