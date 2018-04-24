package it.istruzione.ossscudig.services;

import it.istruzione.ossscudig.constant.TIPO_STATO_RILEVAZIONE;
import it.istruzione.ossscudig.constant.TIPO_STATO_SEZIONE;
import it.istruzione.ossscudig.model.dto.RispostaDTO;
import it.istruzione.ossscudig.model.dto.ScuolaDTO;
import it.istruzione.ossscudig.model.dto.SezioneDTO;
import it.istruzione.ossscudig.model.dto.StatoQuestionarioDTO;
import it.istruzione.ossscudig.model.dto.VoceDTO;

import java.util.List;

import org.springframework.data.repository.query.Param;


public interface AcquisizioneRilevazioneService {
	
	/**
	 * Il metodo restituisce tutte le informazioni necessarie alla visualizzazione della sezione di input
	 * @param idSezione
	 * @param codiceForteScuola
	 * @param codiceEdificio
	 * @return SezioneDTO
	 */
	SezioneDTO loadSezione(String idSezione, 
						   String codiceForteScuola,
						   String idQuestionario,
						   boolean validata);
	
	StatoQuestionarioDTO getStatoQuestionarioScuola(String codForScu, 
													   long prgIstRil,
													   String codQst);
	
	TIPO_STATO_SEZIONE getStatoSezioneScuola(String codForScu, 
										     long prgIstRil,
										     String codQst,
										     String codSezione);
	
	TIPO_STATO_RILEVAZIONE getStatoRilevazioneScuola(String codForScu, long prgIstRil);
	
	void saveSezione(String idSezione, 
			    	 String codiceForteScuola,
			    	 Long prgIstRil,
			    	 List<RispostaDTO> risposte,
			    	 String idQuestionario,
			    	 boolean isComplete);
	
	/*void saveVoce(String idSezione, 
	    	 String codiceForteScuola,
	    	 Long prgIstRil,
	    	 List<VoceDTO> voce,
	    	 String idQuestionario,
	    	 boolean isComplete);*/
	
	void validaRilevazione(List<ScuolaDTO> scuole, Long idRilevazione);
	


}
