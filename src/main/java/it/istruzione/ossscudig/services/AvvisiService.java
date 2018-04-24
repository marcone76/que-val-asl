package it.istruzione.ossscudig.services;

import java.util.List;

import it.istruzione.ossscudig.model.dto.AvvisiDTO;


public interface AvvisiService {
	
	/**
	 * Il metodo restituisce tutte le informazioni necessarie alla visualizzazione della sezione di avvisi
	 * @param idSezione
	 * @param codiceForteScuola
	 * @param codiceEdificio
	 * @return SezioneDTO
	 */
	List <AvvisiDTO> loadAvvisi();
	
	

}
