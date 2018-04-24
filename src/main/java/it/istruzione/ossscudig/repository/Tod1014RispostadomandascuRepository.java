package it.istruzione.ossscudig.repository;

import it.istruzione.ossscudig.model.entity.Tod1014Rispostadomandascu;
import it.istruzione.ossscudig.model.entity.Tod1014RispostadomandascuPK;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Tod1014RispostadomandascuRepository extends JpaRepository<Tod1014Rispostadomandascu, Tod1014RispostadomandascuPK> {
	
	List<Tod1014Rispostadomandascu> findByIdCodForScuAndIdPrgIstRilAndIdCodDmdAndIdCodEdiAndIdCodQst(String codForScu, 
																						  long prgIstRil, 
																						  String codDmd, 
																						  String codEdi,
																						  String codQst);
	
	@Query(value = " SELECT tod1014 FROM Tod1014Rispostadomandascu tod1014, Tod1004Anagrafedomanda tod1004 "
			 + " WHERE "
			 + " tod1014.id.codDmd = tod1004.codDmd "
			 + " and tod1014.id.codForScu = :codForScu "
			 + " and tod1014.id.prgIstRil = :prgIstRil "
			 + " and tod1014.id.codQst = :codQst "
			 + " and tod1004.tod1003Anagrafesezione.codSez = :codSez ")
	List<Tod1014Rispostadomandascu> findRisposteDomandeBySezione(@Param("codForScu")String codForScu, 
																 @Param("prgIstRil") long prgIstRil, 
																 @Param("codSez") String codSez, 
																 @Param("codQst") String codQst);
	
	
	List<Tod1014Rispostadomandascu> findByIdCodForScuAndIdPrgIstRil(String codForScu, long prgIstRil);

}
