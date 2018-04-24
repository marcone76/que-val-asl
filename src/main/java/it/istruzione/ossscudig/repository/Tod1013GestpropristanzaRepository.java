package it.istruzione.ossscudig.repository;

import it.istruzione.ossscudig.model.entity.Tod1001Istanzarilevazione;
import it.istruzione.ossscudig.model.entity.Tod1013Gestpropristanza;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Tod1013GestpropristanzaRepository extends JpaRepository<Tod1013Gestpropristanza, Long> {
	
	public List<Tod1013Gestpropristanza> findByTod1001IstanzarilevazionePrgIstRilAndCodPrpRil(Long prgIstRil, String codPrpRil);
	public List<Tod1013Gestpropristanza> findByTod1001IstanzarilevazionePrgIstRil(Long prgIstRil);
	//Tod1013Gestpropristanza findByTod1007TipostatoCodTipSta(long codTipSta);


}
