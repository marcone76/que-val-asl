package it.istruzione.ossscudig.services;

import java.util.List;
import it.istruzione.ossscudig.model.dto.PubblicazioneDTO;
import it.istruzione.ossscudig.model.dto.RilevazioneDTO;
import it.istruzione.ossscudig.model.dto.StoricizzazioneDTO;
import it.istruzione.ossscudig.model.entity.Tod1013Gestpropristanza;
import it.istruzione.ossscudig.model.formObject.RilevazioneForm;

public interface GestioneRilevazioneService {


	RilevazioneDTO loadRilevazioneAttiva();
	
	RilevazioneDTO loadRilevazioneApprovata();
	
	RilevazioneDTO loadRilevazioneBozza();
	
	List<StoricizzazioneDTO> loadStoricizzazione();

	List<RilevazioneDTO> getRilevazioni();

	RilevazioneDTO getRilevazioneById(String id);
	
	RilevazioneDTO salvaGestioneRilevazione(RilevazioneForm rilevazione,boolean stato);

	void deleteFieldCampione(Long prgIstRil);

	void insertFieldCampione(Long prgIstRil, String descPrpRil, String codPrpRil, int id);

	void deleteFieldStoricizzazione(Long id);
	
	void insertStoricizzazione(Long id,String dataStoricizzazione);

	void pubblicaRilevazione(Boolean isFiltered);

	List<PubblicazioneDTO> loadPubblicazione();

	List<PubblicazioneDTO> getRecordPubblicati(String codicedomanda, String limiteminimo,String limitemassimo);

	PubblicazioneDTO percentualeRecordIgnorati(String codicedomanda, String limiteminimo,String limitemassimo);

	void insertFiltri(PubblicazioneDTO oPubblicazioneDTO);
	
	void approvaQuestionario(String idQst);
	
	RilevazioneDTO approvaRilevazione();

	List<Tod1013Gestpropristanza> findCampione(Long prgIstRil);
}
