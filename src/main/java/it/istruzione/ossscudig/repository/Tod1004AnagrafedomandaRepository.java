package it.istruzione.ossscudig.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.istruzione.ossscudig.model.entity.Tod1004Anagrafedomanda;

public interface Tod1004AnagrafedomandaRepository extends JpaRepository<Tod1004Anagrafedomanda, String> {
	
//	@Query(nativeQuery = true, value = " SELECT cod_dmd FROM tod1004_anagrafedomanda where cod_sez = :codSez and prg_reg_vld in (1,2,8,9) ")
//	List<String> findCodDmdByCodSezAndIdsPrgVal(@Param("codSez") String codSez);
	
}
