package it.istruzione.ossscudig.controllers;

import it.istruzione.commons.security.SidiUser;
import it.istruzione.ossscudig.constant.TIPO_QUESTIONARIO;
import it.istruzione.ossscudig.model.dto.QuestionarioDTO;
import it.istruzione.ossscudig.model.dto.QuestionarioScuolaDTO;
import it.istruzione.ossscudig.model.dto.RilevazioneDTO;
import it.istruzione.ossscudig.model.dto.ScuolaDTO;
import it.istruzione.ossscudig.model.dto.StatoQuestionarioDTO;
import it.istruzione.ossscudig.services.AcquisizioneRilevazioneService;
import it.istruzione.ossscudig.services.VisualizzaRilevazioneService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

public class BaseController {
	
	@Autowired
	AcquisizioneRilevazioneService acquisizioneRilevazioneService;
	
	@Autowired
	VisualizzaRilevazioneService visualizzaRilevazioneService;
	

	
	
/*	public final String DATE_PATTERN = "dd/MM/yyyy";
	
	//PROFILI 
	public final static String PROFILO_AMMINISTRATORE		= "RIVMON_UTE_AMM";
	public final static String PROFILO_UTENTE_USR 			= "RIVMON_UTE_USR";*/
		
	public String getProfiloCorrente() throws java.lang.Exception {
		String profilo = "";
		SidiUser user = (SidiUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (user.getCurrentProfile() != null) {
			profilo = user.getCurrentProfile().getNome();
		} else {
			throw new java.lang.Exception("Sessione scaduta");
		}
		return profilo;
	}
	
	public String getContestoCorrente() throws java.lang.Exception {
		String contesto = "";
		SidiUser user = (SidiUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (user.getCurrentContesto() != null) {
			contesto = user.getCurrentContesto().getCodice();
		} else {
			throw new java.lang.Exception("Sessione scaduta");
		}
		return contesto;
	}
	
	protected List<QuestionarioScuolaDTO> getQuestionariAbilitatiPerScuole(List<ScuolaDTO> scuole, 
			RilevazioneDTO rilevazioneDTO, 
			Map<String, QuestionarioDTO> mapQuestionariByRilevazione){

		List<QuestionarioScuolaDTO> questionari = new ArrayList<>();
		for (ScuolaDTO scuola : scuole) {

			QuestionarioDTO questionario = null;

			if (scuola.isStatale()){
				if (scuola.isIstitutoPrincipale()){
					if (scuola.isSecondoCiclo()){
						questionario = mapQuestionariByRilevazione.get(TIPO_QUESTIONARIO.SECONDO_CICLO_ISTITUZIONE_SCOLASTICA.getCodice());
					}else{
						questionario = mapQuestionariByRilevazione.get(TIPO_QUESTIONARIO.PRIMO_CICLO_ISTITUZIONE_SCOLASTICA.getCodice());
					}
				}
				if (questionario != null){
					QuestionarioScuolaDTO questionarioScuolaDTO = new QuestionarioScuolaDTO();
					questionarioScuolaDTO.setCodiceQuestionario(questionario.getCodiceQuestionario());
					questionarioScuolaDTO.setNome(questionario.getNome());
					questionarioScuolaDTO.setScuola(scuola);
					StatoQuestionarioDTO statoQuestionarioInCorso = acquisizioneRilevazioneService.getStatoQuestionarioScuola(scuola.getCodiceForte(), rilevazioneDTO.getId(), questionario.getCodiceQuestionario());
					questionarioScuolaDTO.setStato(statoQuestionarioInCorso.getTipoStato());
					questionarioScuolaDTO.setDataUltimaModificaQuestionarioInCorso(statoQuestionarioInCorso.getDataUltimaModifica());
					questionarioScuolaDTO.setDataUltimaModificaQuestionarioValidato(visualizzaRilevazioneService.getDataUltimaModificaQuestionarioValidato(scuola.getCodiceForte(), rilevazioneDTO.getId(), questionario.getCodiceQuestionario()));
					questionari.add(questionarioScuolaDTO);
				}
				questionario = null;
				if (scuola.isPlesso()){
					if (scuola.isSecondoCiclo()){
						questionario = mapQuestionariByRilevazione.get(TIPO_QUESTIONARIO.SECONDO_CICLO_PLESSO.getCodice());
					}else{
						questionario = mapQuestionariByRilevazione.get(TIPO_QUESTIONARIO.PRIMO_CICLO_PLESSO.getCodice());
					}
				}
				if (questionario != null){
					QuestionarioScuolaDTO questionarioScuolaDTO = new QuestionarioScuolaDTO();
					questionarioScuolaDTO.setCodiceQuestionario(questionario.getCodiceQuestionario());
					questionarioScuolaDTO.setNome(questionario.getNome());
					questionarioScuolaDTO.setScuola(scuola);
					StatoQuestionarioDTO statoQuestionarioInCorso = acquisizioneRilevazioneService.getStatoQuestionarioScuola(scuola.getCodiceForte(), rilevazioneDTO.getId(), questionario.getCodiceQuestionario());
					questionarioScuolaDTO.setStato(statoQuestionarioInCorso.getTipoStato());
					questionarioScuolaDTO.setDataUltimaModificaQuestionarioInCorso(statoQuestionarioInCorso.getDataUltimaModifica());
					questionarioScuolaDTO.setDataUltimaModificaQuestionarioValidato(visualizzaRilevazioneService.getDataUltimaModificaQuestionarioValidato(scuola.getCodiceForte(), rilevazioneDTO.getId(), questionario.getCodiceQuestionario()));
					questionari.add(questionarioScuolaDTO);
				}
			}else{
				if (scuola.isSecondoCiclo()){
					questionario = mapQuestionariByRilevazione.get(TIPO_QUESTIONARIO.SECONDO_CICLO_PARITARIA.getCodice());
				}else{
					questionario = mapQuestionariByRilevazione.get(TIPO_QUESTIONARIO.PRIMO_CICLO_PARITARIA.getCodice());
				}
				if (questionario != null){
					QuestionarioScuolaDTO questionarioScuolaDTO = new QuestionarioScuolaDTO();
					questionarioScuolaDTO.setCodiceQuestionario(questionario.getCodiceQuestionario());
					questionarioScuolaDTO.setNome(questionario.getNome());
					questionarioScuolaDTO.setScuola(scuola);
					StatoQuestionarioDTO statoQuestionarioInCorso = acquisizioneRilevazioneService.getStatoQuestionarioScuola(scuola.getCodiceForte(), rilevazioneDTO.getId(), questionario.getCodiceQuestionario());
					questionarioScuolaDTO.setStato(statoQuestionarioInCorso.getTipoStato());
					questionarioScuolaDTO.setDataUltimaModificaQuestionarioInCorso(statoQuestionarioInCorso.getDataUltimaModifica());
					questionarioScuolaDTO.setDataUltimaModificaQuestionarioValidato(visualizzaRilevazioneService.getDataUltimaModificaQuestionarioValidato(scuola.getCodiceForte(), rilevazioneDTO.getId(), questionario.getCodiceQuestionario()));
					questionari.add(questionarioScuolaDTO);
				}
			}

		}
		return questionari;
	}
	
	public String getCodice(String nome,String delimitatore)throws Exception
	{ 
		String  codice=null;
		if(nome!=null ||"".equals(nome)) {
			String[] array=nome.split(delimitatore);
		codice=String.valueOf(array[0]);
		}
		return codice;
	}
	
}
