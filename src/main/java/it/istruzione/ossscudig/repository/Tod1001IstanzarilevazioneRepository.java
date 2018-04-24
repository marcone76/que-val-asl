package it.istruzione.ossscudig.repository;

import it.istruzione.ossscudig.model.entity.Tod1001Istanzarilevazione;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Tod1001IstanzarilevazioneRepository extends JpaRepository<Tod1001Istanzarilevazione, Long> {
	
	Tod1001Istanzarilevazione findByTod1007TipostatoCodTipSta(long codTipSta);
	
	

}
