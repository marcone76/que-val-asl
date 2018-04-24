package it.istruzione.ossscudig.services;

import it.istruzione.ossscudig.constant.TIPO_OPERAZIONE;
import it.istruzione.ossscudig.model.dto.GruppoVoceDTO;
import it.istruzione.ossscudig.model.dto.RilevazioneDTO;
import it.istruzione.ossscudig.model.dto.StatoQuestionarioDTO;
import it.istruzione.ossscudig.model.dto.VoceDTO;

public interface GestioneDomandeService {
	
	GruppoVoceDTO getGruppoVoce(String codForScu, 
			   long prgIstRil,
			   String codQst,
	String codDmd);
	
	VoceDTO getVoce(String codForScu, 
			   long prgIstRil,
			   String codQst,
	String codDmd);

}
