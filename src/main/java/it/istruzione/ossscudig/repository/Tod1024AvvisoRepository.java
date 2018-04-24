package it.istruzione.ossscudig.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import it.istruzione.ossscudig.model.entity.Tod1024Avviso;

public interface Tod1024AvvisoRepository extends JpaRepository<Tod1024Avviso, Long> {	
	@Query(nativeQuery = true, value= "SELECT * FROM TOD1024_AVVISO tod1024 " + 
			"WHERE TRIM(SYSDATE) <=  tod1024.DAT_FIN_VAL_AVV AND tod1024.DAT_INI_VAL_AVV <= TRIM(SYSDATE) ") 
	 List<Tod1024Avviso> findByAvviso();
}
