package it.istruzione.ossscudig.repository;


import it.istruzione.ossscudig.model.entity.Twb1014Comune;

import java.util.LinkedList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Twb1014ComuneRepository extends JpaRepository<Twb1014Comune, String> {
	
	LinkedList<Twb1014Comune> findByMfg1029ProvnuoistCodPrvOrderByDesComAsc(String codPrv);

}
