package it.istruzione.ossscudig.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.istruzione.ossscudig.model.entity.EdificiEntity;

public interface EdificiRepository extends JpaRepository<EdificiEntity, Long> {
	
	@Query(nativeQuery = true, value = ""
				 + " select ROWNUM ID, a.COD_EDI, a.A006 from VOD1006_ANAGEDIFICI a, VOD1007_ASSOCSCUEDIFICI b " + 
				 " where a.COD_EDI = b.COD_EDI " + 
				 " and b.COD_SCU_UT = :codScuUt " + 
				 "")
	List<EdificiEntity> findByPlesso(@Param("codScuUt") String codScuUt);

}
