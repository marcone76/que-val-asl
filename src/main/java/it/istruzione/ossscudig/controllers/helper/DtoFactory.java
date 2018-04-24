package it.istruzione.ossscudig.controllers.helper;

import it.istruzione.ossscudig.controllers.util.CommonsUtility;
import it.istruzione.ossscudig.model.dto.PubblicazioneDTO;
import it.istruzione.ossscudig.model.dto.RilevazioneDTO;
import it.istruzione.ossscudig.model.dto.ScuolaDTO;
import it.istruzione.ossscudig.model.entity.PubblicazioneEntity;
import it.istruzione.ossscudig.model.entity.Scuola;
import it.istruzione.ossscudig.model.formObject.RilevazioneForm;

public class DtoFactory {
	
	public static RilevazioneDTO fromFormToDto(RilevazioneForm in){
		RilevazioneDTO dto = new RilevazioneDTO();
		dto.setDataInizio(CommonsUtility.parse(in.getDataInizio()));
		dto.setDataFine(CommonsUtility.parse(in.getDataFine()));
		dto.setDescrizione(in.getDescrizione());
		return dto;
	}
	
	public static RilevazioneForm fromDtoToForm(RilevazioneDTO in){
		RilevazioneForm form = new RilevazioneForm();
		form.setDataInizio(CommonsUtility.format(in.getDataInizio()));
		form.setDataFine(CommonsUtility.format(in.getDataFine()));
		form.setDescrizione(in.getDescrizione());
		form.setStato(in.getStato());
		form.setId(String.valueOf(in.getId()));
		form.setNomeBottone("");
		return form;
	}
	
	public static ScuolaDTO fromEntityToDto(Scuola in){
		
		ScuolaDTO scuola = null;
		if (in != null){
			scuola = new ScuolaDTO();
			scuola.setCodiceForte(in.getCodForScuApp());
			scuola.setCodiceMeccanografico(in.getId().getCodScuUt());
			scuola.setDenominazione(in.getDesNomScu());
			scuola.setCodiceMeccanograficoIstitutoPrincipale(in.getCodScuUtPri());
			scuola.setComune(in.getDesCom());
			scuola.setCpia(in.getCodCarScu()!=null && in.getCodCarScu().trim().equals("1"));
			scuola.setStatale(in.getFlgIstSta()!=null && in.getFlgIstSta().trim().equals("0"));
			scuola.setTipoIstituto(in.getDesTipIst());
			scuola.setDenominazione(in.getDesNomScu());
			scuola.setIndirizzo(in.getDesIndScu());

		}
		return scuola;
		
	}
	

}
