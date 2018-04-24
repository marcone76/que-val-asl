package it.istruzione.ossscudig.services;

import java.util.Date;

public interface VisualizzaRilevazioneService {

	Date getDataUltimaModificaQuestionarioValidato(String codForScu, long prgIstRil, String codQst);
}
