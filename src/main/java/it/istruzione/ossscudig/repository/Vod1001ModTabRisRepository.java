package it.istruzione.ossscudig.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.istruzione.ossscudig.model.entity.Vod1001ModTabRis;
import it.istruzione.ossscudig.model.entity.Vod1001ModTabRisPK;

public interface Vod1001ModTabRisRepository extends JpaRepository<Vod1001ModTabRis, Vod1001ModTabRisPK> {
	
	@Query(nativeQuery = true, value= " SELECT * from VOD1001_MODTABRIS L, TWS1002_ANAGISTSCOL A, TWB1014_COMUNE B, MFG1029_PROVNUOIST C, TWB1012_REGIONE D  where  (:codQst IS NULL OR TRIM(COD_QST) = :codQst) "
			+ " and (:codForScu IS NULL OR TRIM(COD_FOR_SCU) = :codForScu)"
			+ " AND L.COD_FOR_SCU = A.COD_FOR_SCU_APP "
			+ " AND A.DAT_ANN_SCO_RIL = :annoScolastico "
			+ " AND (DAT_FIN_VAL IS NULL OR DAT_FIN_VAL > SYSDATE) "
			+ " AND A.COD_COM = B.COD_COM "
			+ " AND B.COD_PRV_NIS = C.COD_PRV "
			+ " AND C.COD_REG = D.COD_REG "
			+ " AND (:codiceRegione IS NULL OR C.COD_REG = :codiceRegione) "
			+ " AND (:codiceProvincia IS NULL OR C.COD_PRV = :codiceProvincia) "
			+ " AND (:codiceComune IS NULL OR B.COD_COM = :codiceComune) "
			)
	public List<Vod1001ModTabRis> getDatiInCorso(@Param("codQst") String codQst, @Param("codForScu") String codForScu, @Param("codiceComune") String codiceComune, @Param("codiceProvincia") String codiceProvincia, 
			@Param("codiceRegione") String codiceRegione, @Param("annoScolastico") Integer annoScolastico);
	
	@Query(nativeQuery = true, value= " SELECT COUNT(*) from VOD1001_MODTABRIS L, TWS1002_ANAGISTSCOL A, TWB1014_COMUNE B, MFG1029_PROVNUOIST C, TWB1012_REGIONE D  where  (:codQst IS NULL OR TRIM(COD_QST) = :codQst) "
			+ " and (:codForScu IS NULL OR TRIM(COD_FOR_SCU) = :codForScu)"
			+ " AND L.COD_FOR_SCU = A.COD_FOR_SCU_APP "
			+ " AND A.DAT_ANN_SCO_RIL = :annoScolastico "
			+ " AND (DAT_FIN_VAL IS NULL OR DAT_FIN_VAL > SYSDATE) "
			+ " AND A.COD_COM = B.COD_COM "
			+ " AND B.COD_PRV_NIS = C.COD_PRV "
			+ " AND C.COD_REG = D.COD_REG "
			+ " AND (:codiceRegione IS NULL OR C.COD_REG = :codiceRegione) "
			+ " AND (:codiceProvincia IS NULL OR C.COD_PRV = :codiceProvincia) "
			+ " AND (:codiceComune IS NULL OR B.COD_COM = :codiceComune) "
			)
	public Integer countDatiInCorso(@Param("codQst") String codQst, @Param("codForScu") String codForScu, @Param("codiceComune") String codiceComune, @Param("codiceProvincia") String codiceProvincia, 
			@Param("codiceRegione") String codiceRegione, @Param("annoScolastico") Integer annoScolastico);
	
	@Query(nativeQuery = true, value= " SELECT * FROM (SELECT BASEINFO.*, rownum rNum FROM ("
			+ "SELECT L.* from VOD1001_MODTABRIS L, TWS1002_ANAGISTSCOL A, TWB1014_COMUNE B, MFG1029_PROVNUOIST C, TWB1012_REGIONE D  where  (:codQst IS NULL OR TRIM(COD_QST) = :codQst) "
			+ " and (:codForScu IS NULL OR TRIM(COD_FOR_SCU) = :codForScu)"
			+ " AND L.COD_FOR_SCU = A.COD_FOR_SCU_APP "
			+ " AND A.DAT_ANN_SCO_RIL = :annoScolastico "
			+ " AND (DAT_FIN_VAL IS NULL OR DAT_FIN_VAL > SYSDATE) "
			+ " AND A.COD_COM = B.COD_COM "
			+ " AND B.COD_PRV_NIS = C.COD_PRV "
			+ " AND C.COD_REG = D.COD_REG "
			+ " AND (:codiceRegione IS NULL OR C.COD_REG = :codiceRegione) "
			+ " AND (:codiceProvincia IS NULL OR C.COD_PRV = :codiceProvincia) "
			+ " AND (:codiceComune IS NULL OR B.COD_COM = :codiceComune)) "
			+ " BASEINFO WHERE rownum < (((:pageNumber) + (:pageSize)) + 1 ))"
			+ " WHERE rNum >= (:pageNumber+ 1)"
			)
	public List<Vod1001ModTabRis> getDatiInCorsoPaged(@Param("codQst") String codQst, @Param("codForScu") String codForScu, @Param("codiceComune") String codiceComune, @Param("codiceProvincia") String codiceProvincia, 
			@Param("codiceRegione") String codiceRegione, @Param("annoScolastico") Integer annoScolastico, @Param("pageNumber") Integer pageNumber,@Param("pageSize") Integer pageSize);
	
}

