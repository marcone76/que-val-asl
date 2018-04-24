package it.istruzione.ossscudig.services;

import it.istruzione.ossscudig.model.dto.SezioneDTO;

import java.util.List;


public interface AnagrafeSezioneService {
	
          List<SezioneDTO> findSezioniQuestionario(String idQuestionario);
}
