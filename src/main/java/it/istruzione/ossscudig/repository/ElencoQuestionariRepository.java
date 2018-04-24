package it.istruzione.ossscudig.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.istruzione.ossscudig.model.entity.ElencoQuestionariForScuolaEntity;

public interface ElencoQuestionariRepository extends JpaRepository<ElencoQuestionariForScuolaEntity, Long> {
	
	
	@Query(name="ElencoQuestionariForScuolaEntity.elencoQuestionari")
	public List<ElencoQuestionariForScuolaEntity> getQuestionariForScuola(@Param("prgIstRil") String prgIstRil, @Param("annoScolastico") String annoScolastico, @Param("codIstPri") String codIstPri);

}
