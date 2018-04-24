package it.istruzione.ossscudig.customTag;

import javax.servlet.jsp.JspException;

import org.springframework.web.servlet.tags.form.RadioButtonsTag;
import org.springframework.web.servlet.tags.form.TagWriter;

public class RispostaTagSpring extends RadioButtonsTag {
	private static final long serialVersionUID = 1L;

	@Override
	    protected void writeDefaultAttributes(TagWriter tagWriter) throws JspException {
				super.writeDefaultAttributes(tagWriter);
	        
	}	    
	
	
	@Override
	protected void writeOptionalAttributes(TagWriter tagWriter) throws JspException {
		super.writeOptionalAttributes(tagWriter);
		writeOptionalAttribute(tagWriter, "marcoAtrr", "ciao");
	}
	
}
