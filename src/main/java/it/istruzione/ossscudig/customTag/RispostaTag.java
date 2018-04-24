package it.istruzione.ossscudig.customTag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.ModelAttribute;

public class RispostaTag extends SimpleTagSupport{

	private String idDomanda;
	private String gruppoVoce;
	
	public  void setIdDomanda(final String idDomanda) {
		this.idDomanda = idDomanda;
	}

	public  void setGruppoVoce(final String gruppoVoce) {
		this.gruppoVoce = gruppoVoce;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		
		final JspWriter out = getJspContext().getOut();
		
//			        out.println( "<div class=\"inputbg-frame\"> " + 
//			        		"						<label for=\"search-type-name\" class=\"radio-inline width-1-3\"> " + 
//			        		"							<input id=\"search-type-name\" type=\"radio\" onclick=\"setPanelFilter()\" value=\"SI\" aria-label=\"Ricerca per nome e cognome\" data-switch-input=\"switch-name\" tabindex=\"10\" checked=\"checked\" path=\"tipoRicerca\" /><span>Sì</span> " + 
//			        		"						</label> " + 
//			        		"						<label for=\"search-type-username\" class=\"radio-inline width-1-3\"> " + 
//			        		"							<input type=\"radio\" id=\"search-type-name\" onclick=\"setPanelFilter()\" value=\"NO\" aria-label=\"Ricerca per username\" data-switch-input=\"switch-username\" tabindex=\"20\" path=\"tipoRicerca\" /><span>No</span> " + 
//			        		"						</label> " + 
//			        		"					</div>" );
		
		out.println(  IOUtils.toString(this.getClass().getResourceAsStream("verticalMultipleChoice.jsp"))     );
	}
	
}
