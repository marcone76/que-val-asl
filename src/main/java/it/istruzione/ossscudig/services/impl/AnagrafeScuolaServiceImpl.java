package it.istruzione.ossscudig.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.istruzione.ossscudig.constant.Constants;
import it.istruzione.ossscudig.controllers.helper.DtoFactory;
import it.istruzione.ossscudig.controllers.util.CommonsUtility;
import it.istruzione.ossscudig.model.dto.EdificioDTO;
import it.istruzione.ossscudig.model.dto.ScuolaDTO;
import it.istruzione.ossscudig.model.entity.EdificiEntity;
import it.istruzione.ossscudig.model.entity.Scuola;
import it.istruzione.ossscudig.model.entity.Tod1013Gestpropristanza;
import it.istruzione.ossscudig.repository.EdificiRepository;
import it.istruzione.ossscudig.repository.ScuolaRepository;
import it.istruzione.ossscudig.repository.Tod1013GestpropristanzaRepository;
import it.istruzione.ossscudig.services.AnagrafeScuolaService;

@Service
public class AnagrafeScuolaServiceImpl implements AnagrafeScuolaService{
	
	private static Logger logger = Logger.getLogger(AnagrafeScuolaServiceImpl.class);
	
	@Autowired
	private ScuolaRepository scuolaRepository;
	
	@Autowired
	private EdificiRepository edificiRepository;
	
	@Autowired
	private Tod1013GestpropristanzaRepository tod1013GestpropristanzaRepository;
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<ScuolaDTO> getScuoleAssociate(String codiceForteIstitutoPrincipale, Long prgIstRil){
		
		logger.debug("getScuoleAssociate : " + codiceForteIstitutoPrincipale);
		
		Map<String,String> ordineScuolaInclusi = this.getOrdineScuolaInclusiNelCampione(prgIstRil);
		String tipoScuolaNelCampione = this.getTipoScuolaNelCampione(prgIstRil);
		String regioneNelCampione = this.getRegioneNelCampione(prgIstRil);
		String flagAdulti=getAdultiInclusiNelCampione(prgIstRil);
		flagAdulti = ("NO".equals(flagAdulti) ) ? "0" : null;
		
		List<ScuolaDTO> out = new ArrayList<>();
		Scuola istitutoPrincipale = scuolaRepository.findIstitutoPrincipaleByCodiceForteAndAnnoScolastico(codiceForteIstitutoPrincipale, CommonsUtility.getAnnoScolasticoCorrente());
		if (istitutoPrincipale != null){
			logger.debug(ReflectionToStringBuilder.toString(istitutoPrincipale,ToStringStyle.MULTI_LINE_STYLE));
			List<Scuola> plessi = scuolaRepository.findPlessiByCodiceMeccanograficoIstitutoPrincipaleAndAnnoScolastico(
																							istitutoPrincipale.getId().getCodScuUt(), 
																							Long.valueOf(istitutoPrincipale.getId().getDatAnnScoRil()).intValue(),
																							ordineScuolaInclusi.get("AA"),
																							ordineScuolaInclusi.get("EE"),
																							ordineScuolaInclusi.get("MM"),
																							ordineScuolaInclusi.get("SS"),
																							ordineScuolaInclusi.get("IC"),
																							ordineScuolaInclusi.get("CT"),
																							ordineScuolaInclusi.get("ALL"),
																							flagAdulti,
																							tipoScuolaNelCampione,
																							regioneNelCampione);

			for (Scuola scuola : plessi) {
				out.add(DtoFactory.fromEntityToDto(scuola));
			}
		}else{
			logger.debug("Istituto scolastico non trovato");
		}
		logger.debug(ReflectionToStringBuilder.toString(out,ToStringStyle.MULTI_LINE_STYLE));
		return out;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public ScuolaDTO getScuola(String codiceForte){
		
		logger.debug("getScuola : " + codiceForte);
		ScuolaDTO out = null;
		Scuola scuola = scuolaRepository.findPlessoByCodiceForteAndAnnoScolastico(codiceForte, CommonsUtility.getAnnoScolasticoCorrente());
		if (scuola != null){
			logger.debug(ReflectionToStringBuilder.toString(scuola,ToStringStyle.MULTI_LINE_STYLE));
			out = DtoFactory.fromEntityToDto(scuola);
		}
		return out;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<EdificioDTO> getEdificiPerPlesso(String codiceMeccanograficoPlesso){

		logger.debug("getEdificiPerPlesso : " + codiceMeccanograficoPlesso);
		List<EdificioDTO> out = new ArrayList<>();
		List<EdificiEntity> scuole = edificiRepository.findByPlesso(codiceMeccanograficoPlesso);

		for (EdificiEntity scuola : scuole) {
			EdificioDTO dto = new EdificioDTO();
			dto.setCodEdi(scuola.getCodiceEdificio());
			dto.setIndirizzo(scuola.getIndirizzoEdificio());
			out.add(dto);
		}
		return out;
	}
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public Integer getNumeroScuoleCampione(Long prgIstRil,
										   String codiceRegione,
										   String codiceProvincia,
										   String codiceComune){
		
		Map<String,String> ordineScuolaInclusi = this.getOrdineScuolaInclusiNelCampione(prgIstRil);
		String tipoScuolaNelCampione = this.getTipoScuolaNelCampione(prgIstRil);
		String regioneNelCampione = this.getRegioneNelCampione(prgIstRil);
		String flagAdulti=getAdultiInclusiNelCampione(prgIstRil);
		flagAdulti = ("NO".equals(flagAdulti) ) ? "0" : null;
		Integer num = scuolaRepository.getNumeroScuoleCampione(ordineScuolaInclusi.get("AA"),
																ordineScuolaInclusi.get("EE"),
																ordineScuolaInclusi.get("MM"),
																ordineScuolaInclusi.get("SS"),
																ordineScuolaInclusi.get("IC"),
																ordineScuolaInclusi.get("CT"),
																ordineScuolaInclusi.get("ALL"),
																flagAdulti,
																tipoScuolaNelCampione,
																regioneNelCampione,
															    CommonsUtility.getAnnoScolasticoCorrente(), 
															   (codiceComune != null && !codiceComune.trim().equals("")) ? codiceComune.trim() : null,
															   (codiceProvincia != null && !codiceProvincia.trim().equals("")) ? codiceProvincia.trim() : null,
															   (codiceRegione != null && !codiceRegione.trim().equals("")) ? codiceRegione.trim() : null);
		
		return num;
	}
	
	
	@Transactional(propagation = Propagation.SUPPORTS)
	private Map<String,String> getOrdineScuolaInclusiNelCampione(Long prgIstRil){
		
		Map<String,String> ordineScuolaInclusi = new HashMap<>();
		List<Tod1013Gestpropristanza> ordiniInclusi = tod1013GestpropristanzaRepository.findByTod1001IstanzarilevazionePrgIstRilAndCodPrpRil(prgIstRil, Constants.INCLUDI_ORDINE);
		if (ordiniInclusi != null && !ordiniInclusi.isEmpty()){
			for (Tod1013Gestpropristanza tod1013Gestpropristanza : ordiniInclusi) {
				ordineScuolaInclusi.put(tod1013Gestpropristanza.getDesPrpRil(),tod1013Gestpropristanza.getDesPrpRil());
			}
		}
		return ordineScuolaInclusi;
	}
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
       public String getAdultiInclusiNelCampione(Long prgIstRil){
		
		String adultiInclusi = "";
		List<Tod1013Gestpropristanza> ordiniInclusi = tod1013GestpropristanzaRepository.findByTod1001IstanzarilevazionePrgIstRilAndCodPrpRil(prgIstRil, Constants.ADULTI);
		if (ordiniInclusi != null && !ordiniInclusi.isEmpty()){
			adultiInclusi=ordiniInclusi.get(0).getDesPrpRil();
		}
		return adultiInclusi;
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	private String getTipoScuolaNelCampione(Long prgIstRil){

		String tipoScuola = "";
		List<Tod1013Gestpropristanza> props = tod1013GestpropristanzaRepository.findByTod1001IstanzarilevazionePrgIstRilAndCodPrpRil(prgIstRil, Constants.TIPOLOGIA_ISTITUTO);
		if (props != null && !props.isEmpty()){
			tipoScuola = props.get(0).getDesPrpRil();
		}

		String flgIstSta = null;
		if (tipoScuola.equals("ST")){
			flgIstSta = "0";
		}else if (tipoScuola.equals("PA")){
			flgIstSta = "1";
		}

		return flgIstSta;
	}


	@Transactional(propagation = Propagation.SUPPORTS)
	private String getRegioneNelCampione(Long prgIstRil){

		String regione = "";
		List<Tod1013Gestpropristanza> props = tod1013GestpropristanzaRepository.findByTod1001IstanzarilevazionePrgIstRilAndCodPrpRil(prgIstRil, Constants.REGIONE);
		if (props != null && !props.isEmpty()){
			regione = props.get(0).getDesPrpRil();
		}

		String codRegione = null;
		if (!regione.equals("") && !regione.equals("ALL")){
			codRegione = regione;
		}

		return codRegione;
	}
	
}
