package it.istruzione.ossscudig.model.dto;

import java.util.List;

public class DomandaDTO //implements ElementFactory<DomandaDTO> 
{

	private String id;
	private String codIdeDomanda;
	private String testoDomanda;
	private String tipoRisposta;
	private String valoreRisposta;
	private String livelli;
	private List<VoceDTO> voci;
	private String codEdi;
	private String tipoGruppo; /** D=Default, E=Edifici, P=Plessi **/
	private String flgObb;
	private String descrizioneTipoDomanda;
	private String codTipoDomanda;
	private String stato;
	private List<String> domande;
	
	public String getLivelli() {
		return livelli;
	}
	public void setLivelli(Integer livelli) {
		this.livelli = "row livello"+livelli;
	}
	public void setLivelli(String livelli) {
		this.livelli = livelli;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCodIdeDomanda() {
		return codIdeDomanda;
	}
	public void setCodIdeDomanda(String codIdeDomanda) {
		this.codIdeDomanda = codIdeDomanda;
	}
	public String getTestoDomanda() {
		return testoDomanda;
	}
	public void setTestoDomanda(String testoDomanda) {
		this.testoDomanda = testoDomanda;
	}
	public String getTipoRisposta() {
		return tipoRisposta;
	}
	public void setTipoRisposta(String tipoRisposta) {
		this.tipoRisposta = tipoRisposta;
	}
	public List<VoceDTO> getVoci() {
		return voci;
	}
	public void setVoci(List<VoceDTO> voci) {
		this.voci = voci;
	}
	public String getValoreRisposta() {
		return valoreRisposta;
	}
	public void setValoreRisposta(String valoreRisposta) {
		this.valoreRisposta = valoreRisposta;
	}
//	@Override
//	public DomandaDTO createElement(int arg0) throws ElementInstantiationException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	private DomandaDTO person;
//
//	  public PassportFactory(DomandaDTO person) {
//	     this.person = person;
//	  }
	public String getCodEdi() {
		return codEdi;
	}
	public void setCodEdi(String codEdi) {
		this.codEdi = codEdi;
	}
	public String getTipoGruppo() {
		return tipoGruppo;
	}
	public void setTipoGruppo(String tipoGruppo) {
		this.tipoGruppo = tipoGruppo;
	}
	public final String getFlgObb() {
		return flgObb;
	}
	public final void setFlgObb(String flgObb) {
		this.flgObb = flgObb;
	}
	public String getDescrizioneTipoDomanda() {
		return descrizioneTipoDomanda;
	}
	public void setDescrizioneTipoDomanda(String descrizioneTipoDomanda) {
		this.descrizioneTipoDomanda = descrizioneTipoDomanda;
	}
	public String getCodTipoDomanda() {
		return codTipoDomanda;
	}
	public void setCodTipoDomanda(String codTipoDomanda) {
		this.codTipoDomanda = codTipoDomanda;
	}
	public String getStato() {
		return stato;
	}
	public void setStato(String stato) {
		this.stato = stato;
	}
	public List<String> getDomande() {
		return domande;
	}
	public void setDomande(List<String> domande) {
		this.domande = domande;
	}
	
	
}
