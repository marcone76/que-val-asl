package it.istruzione.ossscudig.repository;

import it.istruzione.ossscudig.model.entity.Tod1003Anagrafesezione;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Tod1003AnagrafesezioneRepository extends JpaRepository<Tod1003Anagrafesezione, String> {
	
	@Query(value = " SELECT tod1003 FROM Tod1003Anagrafesezione tod1003, Tod1016Assquestsezione tod1016 "
				 + " WHERE "
				 + " tod1003.codSez = tod1016.id.codSez"
				 + " and tod1016.id.codQst = :codQst "
				 + " order by tod1016.numOrdSez asc ")
	List<Tod1003Anagrafesezione> findByQuestionario(@Param("codQst") String codQst);

}
