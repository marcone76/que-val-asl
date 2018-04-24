package it.istruzione.ossscudig.repository;

import it.istruzione.ossscudig.model.entity.Twb1012Regione;

import java.util.LinkedList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Twb1012RegioneRepository extends JpaRepository<Twb1012Regione, String> {
	
	@Query(nativeQuery = true, value= " SELECT * FROM TWB1012_REGIONE WHERE TRIM(COD_REG) = :codReg")
	public Twb1012Regione findByCodiceRegione(@Param("codReg") String codReg);
	
    @Query(nativeQuery = true, value= " SELECT * FROM TWB1012_REGIONE WHERE COD_CIT = 200 ORDER BY DES_REG")
    public LinkedList<Twb1012Regione> findAllRegioniItaliane();


}
