package it.istruzione.ossscudig.services;

import it.istruzione.ossscudig.model.dto.EdificioDTO;
import it.istruzione.ossscudig.model.dto.ScuolaDTO;

import java.util.List;


public interface AnagrafeScuolaService {
	
	List<ScuolaDTO> getScuoleAssociate(String codiceForteIstitutoPrincipale, Long prgIstRil);
	
	ScuolaDTO getScuola(String codiceForte);
	
	public List<EdificioDTO> getEdificiPerPlesso(String codiceMeccanograficoPlesso);
	
	Integer getNumeroScuoleCampione(Long prgIstRil,
								    String codiceRegione,
								    String codiceProvincia,
								    String codiceComune);
	
  String getAdultiInclusiNelCampione(Long prgIstRil);
}
