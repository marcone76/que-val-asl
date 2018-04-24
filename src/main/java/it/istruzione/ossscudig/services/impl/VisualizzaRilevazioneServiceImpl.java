package it.istruzione.ossscudig.services.impl;

import java.util.Date;
import java.util.List;

import it.istruzione.ossscudig.model.entity.Tod1015Valrispostadomandascu;
import it.istruzione.ossscudig.repository.Tod1015ValrispostadomandascuRepository;
import it.istruzione.ossscudig.services.VisualizzaRilevazioneService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisualizzaRilevazioneServiceImpl implements VisualizzaRilevazioneService{
	
	@Autowired
	Tod1015ValrispostadomandascuRepository tod1015ValrispostadomandascuRepository;
	
	public Date getDataUltimaModificaQuestionarioValidato(String codForScu, long prgIstRil, String codQst){
		
		Date out = null;
		List<Tod1015Valrispostadomandascu> tod1015Valrispostadomandascus = tod1015ValrispostadomandascuRepository.findByIdCodForScuAndIdPrgIstRilAndIdCodQst(codForScu, prgIstRil, codQst);
		if (tod1015Valrispostadomandascus != null && !tod1015Valrispostadomandascus.isEmpty()){
			out = tod1015Valrispostadomandascus.get(0).getDatOraUltMov();
		}
		return out;
	}
	
	

}
