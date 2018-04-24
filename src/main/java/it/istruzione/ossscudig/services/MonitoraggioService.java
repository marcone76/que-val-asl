package it.istruzione.ossscudig.services;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import it.istruzione.ossscudig.model.dto.AcquisizioneQuestionarioInCorsoDTO;
import it.istruzione.ossscudig.model.dto.AcquisizioneRilevazioneValidataDTO;
import it.istruzione.ossscudig.model.dto.LabelValueDTO;
import it.istruzione.ossscudig.model.dto.MonitoraggioDTO;
import it.istruzione.ossscudig.model.dto.StatoAcquisizioneQuestionarioInCorsoDTO;
import it.istruzione.ossscudig.model.dto.StatoAcquisizioneRilevazioneValidataDTO;



public interface MonitoraggioService {
	
	LinkedList<LabelValueDTO> getRegioni();
	
	LinkedList<LabelValueDTO> getProvince(String codRegione);
	
	LinkedList<LabelValueDTO> getComuni(String codProvincia);
	
	LinkedList<LabelValueDTO> getQuestionari();
	
	StatoAcquisizioneQuestionarioInCorsoDTO getStatoAcquisizioneQuestionarioInCorso(Long prgIstRil,
																				    String codiceRegione,
																				    String codiceProvincia,
																				    String codiceComune,
																				    String cicliScolastici);
	
	StatoAcquisizioneRilevazioneValidataDTO getStatoAcquisizioneRilevazioneValidata(Long prgIstRil,
																				    String codiceRegione,
																				    String codiceProvincia,
																				    String codiceComune,
																				    String cicliScolastici);
	
	public List<AcquisizioneQuestionarioInCorsoDTO> getAcquisizioneQuestionarioInCorso(Long prgIstRil,
																					   String codiceRegione,
																					   String codiceProvincia,
																					   String codiceComune,
																					   String ciclo);
	
	List<AcquisizioneRilevazioneValidataDTO> getAcquisizioneRilevazioneValidata(Long prgIstRil,
																			    String codiceRegione,
																			    String codiceProvincia,
																			    String codiceComune,String ciclo);
	
	
	
	ArrayList<LabelValueDTO> getAndamento(String dataFrom,
			String codiceRegione,
		    String codiceProvincia,
		    String codiceComune,
		    String cicliScolastici);
	
	
	ArrayList<MonitoraggioDTO> getElencoScuole(String prgIstRil, String annoScolastico,String codiceRegione,  String codiceProvincia,  String codiceComune, String idQst, String codScu ); 
	
	ArrayList<MonitoraggioDTO> getElencoScuoleCount(String prgIstRil, String annoScolastico,String codiceRegione,  String codiceProvincia, String codiceComune, String codScu );
	
	ArrayList<MonitoraggioDTO> getElencoQuestionariForScuola(String prgIstRil, String codIstPri, String annoScolastico);

	List<String> getCicli(Long prgIstRil);
	
}
