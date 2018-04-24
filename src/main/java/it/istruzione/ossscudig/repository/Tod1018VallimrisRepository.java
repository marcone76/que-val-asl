package it.istruzione.ossscudig.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.istruzione.ossscudig.model.entity.Tod1018Vallimris;



public interface Tod1018VallimrisRepository extends JpaRepository<Tod1018Vallimris, String> {
	
	List<Tod1018Vallimris> findByPrgIstRil(Long prgIstRil);
	
	List<Tod1018Vallimris> findByPrgIstRilAndCodQst(Long prgIstRil, String codQst);
	
	Tod1018Vallimris findByPrgIstRilAndCodQstAndCodDmd(Long prgIstRil,String codQst,String codDmd);

}
