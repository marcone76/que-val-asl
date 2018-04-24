package it.istruzione.ossscudig.model.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the VOD1007_ASSOCSCUEDIFICI database table.
 * 
 */
@Entity
@Table(name="VOD1007_ASSOCSCUEDIFICI")
@NamedQuery(name="Vod1007Assocscuedifici.findAll", query="SELECT v FROM Vod1007Assocscuedifici v")
public class Vod1007Assocscuedifici implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private Vod1007AssocscuedificiPK id;

	public Vod1007Assocscuedifici() {
	}

	public Vod1007AssocscuedificiPK getId() {
		return id;
	}

	public void setId(Vod1007AssocscuedificiPK id) {
		this.id = id;
	}
	
	
	

}