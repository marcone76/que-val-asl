package it.istruzione.ossscudig.services;

import java.util.List;
import java.util.Map;

import it.istruzione.ossscudig.model.dto.AnagrafeDomandaDTO;
import it.istruzione.ossscudig.model.dto.DomandaDTO;
import it.istruzione.ossscudig.model.dto.QuestionarioDTO;
import it.istruzione.ossscudig.model.dto.VoceDTO;


public interface AnagrafeQuestionarioService {
	
	Map<String, QuestionarioDTO> findQuestionariByRilevazione(Long idRilevazione);
	
	QuestionarioDTO getQuestionario(String codQst);
	
	AnagrafeDomandaDTO 	getAnagrafeDomandaDTOValidator(String codDmd);
	
	AnagrafeDomandaDTO getAnagrafeDomandaDTO(String codDmd,String voce);

	
	List<QuestionarioDTO> getGestioneQuestionario(int codTipSta);

	void saveSezioneDomande(String idSezione, List<DomandaDTO> domanda);

	void saveSezioneVoci(String idSezione, List<VoceDTO> voce);

}
