package it.istruzione.ossscudig.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.istruzione.ossscudig.model.entity.Tod1002Anagrafequestionario;

public interface Tod1002AnagrafequestionarioRepository extends JpaRepository<Tod1002Anagrafequestionario, String> {
	
	LinkedList<Tod1002Anagrafequestionario> findByTod1001IstanzarilevazionePrgIstRilOrderByCodQstAsc(Long prgIstRil);
	
	List<Tod1002Anagrafequestionario>  findByTod1001IstanzarilevazionePrgIstRil(Long prgIstRil);
}
