package it.istruzione.ossscudig.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.istruzione.ossscudig.model.entity.Tod1021Storicizzazione;

public interface Tod1021StoricizzazioneRepository  extends JpaRepository<Tod1021Storicizzazione, Long> {
	
	
	
	
	//@Query("SELECT coalesce(max(tod1021.prgStor), 0) FROM Tod1021Storicizzazione tod1021 WHERE tod1021.datStoDwh > CURDATE()")
	@Query("SELECT tod1021 FROM Tod1021Storicizzazione tod1021 where tod1021.prgStor=(SELECT max(t.prgStor) FROM Tod1021Storicizzazione t)")
	
	Tod1021Storicizzazione getMaxId();
}





