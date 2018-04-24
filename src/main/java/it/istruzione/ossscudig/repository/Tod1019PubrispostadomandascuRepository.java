package it.istruzione.ossscudig.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.istruzione.ossscudig.model.entity.Tod1019Pubrispostadomandascu;



public interface Tod1019PubrispostadomandascuRepository extends JpaRepository<Tod1019Pubrispostadomandascu, String> {
	
	List<Tod1019Pubrispostadomandascu> findByTod1001IstanzarilevazionePrgIstRil(Long prgIstRil);
	

}
