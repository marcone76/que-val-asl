package it.istruzione.ossscudig.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import it.istruzione.ossscudig.model.entity.AndamentoEntity;

public interface AndamentoRepository extends JpaRepository<AndamentoEntity, Long> {
	
	@Query(nativeQuery = true, value= " "
			+" SELECT rownum ID, GIORNO, SUM(CONTEGGIO) OVER(order by GIORNO) as CONTEGGIO    FROM("
            +" select B.GIORNO, SUM(CONTEGGIO) CONTEGGIO  from"
                                +" (select (trunc(to_date(:dataFrom,'ddmmyyyy')-1)+level) GIORNO from dual"
                                +" connect by level <=15) B LEFT OUTER JOIN"
                                +" (select to_date(:dataFrom,'ddmmyyyy') GIORNO , COUNT(DISTINCT S.COD_FOR_SCU) CONTEGGIO from"
                                +" TOD1015_VALRISPOSTADOMANDASCU S, TWS1002_ANAGISTSCOL A,TWB1014_COMUNE B,MFG1029_PROVNUOIST C,TWB1012_REGIONE D WHERE"
                                +" TRUNC(S.DAT_VLD_RIS) <= TO_DATE(:dataFrom,'DDMMYYYY')"
                                +" AND A.COD_FOR_SCU_APP  = S.COD_FOR_SCU"
                                +" AND A.COD_COM = B.COD_COM"
                                +" AND B.COD_PRV_NIS = C.COD_PRV"
                                +" AND C.COD_REG = D.COD_REG"
                                +" AND A.DAT_ANN_SCO_RIL = :annoScolastico"
                                +" AND (DAT_FIN_VAL IS NULL OR DAT_FIN_VAL > SYSDATE)"
                                +" AND( (:cicliScolastici is null) or "
                                +" (:cicliScolastici =2 and (A.COD_TIP_SIT='IS' OR A.COD_TIP_SIT>'MM')) or "
                                +" (:cicliScolastici =1 and NOT (A.COD_TIP_SIT='IS' OR A.COD_TIP_SIT>'MM'))  )"
                                +" AND (:codiceRegione IS NULL OR TRIM(C.COD_REG) = :codiceRegione)"
                                +" AND (:codiceProvincia IS NULL OR TRIM(C.COD_PRV) = :codiceProvincia)"
                                +" AND (:codiceComune IS NULL OR B.COD_COM = :codiceComune) UNION"
                                +" select TRUNC(S.DAT_VLD_RIS) GIORNO , COUNT(DISTINCT S.COD_FOR_SCU) CONTEGGIO from"
                                +" TOD1015_VALRISPOSTADOMANDASCU S,TWS1002_ANAGISTSCOL A,TWB1014_COMUNE B,MFG1029_PROVNUOIST C,TWB1012_REGIONE D WHERE"
                                +" TRUNC(DAT_VLD_RIS) > TO_DATE(:dataFrom,'DDMMYYYY')"
                                +" AND A.COD_FOR_SCU_APP = S.COD_FOR_SCU"
                                +" AND A.COD_COM = B.COD_COM"
                                +" AND B.COD_PRV_NIS = C.COD_PRV"
                                +" AND C.COD_REG = D.COD_REG"
                                +" AND A.DAT_ANN_SCO_RIL = :annoScolastico"
                                +" AND (DAT_FIN_VAL IS NULL OR DAT_FIN_VAL > SYSDATE)"
                                +" AND( (:cicliScolastici is null) or "
                                +" (:cicliScolastici =2 and (A.COD_TIP_SIT='IS' OR A.COD_TIP_SIT>'MM')) or "
                                +" (:cicliScolastici =1 and NOT (A.COD_TIP_SIT='IS' OR A.COD_TIP_SIT>'MM'))  )"
                                +" AND (:codiceRegione IS NULL OR TRIM(C.COD_REG) = :codiceRegione)"
                                +" AND (:codiceProvincia IS NULL OR TRIM(C.COD_PRV) = :codiceProvincia)"
                                +" AND (:codiceComune IS NULL OR B.COD_COM = :codiceComune)"
                                +" GROUP BY TRUNC(DAT_VLD_RIS)) A ON"
                                +" TO_CHAR(B.GIORNO,'DDMMYYYY') = TO_CHAR(A.GIORNO,'DDMMYYYY')"
                                +" GROUP BY B.GIORNO"
                                +" ORDER BY B.GIORNO)")
	public List<AndamentoEntity> getAndamento(@Param("dataFrom") String dataFrom ,@Param("codiceRegione") String codiceRegione, @Param("codiceProvincia") String codiceProvincia, @Param("codiceComune") String codiceComune,
			@Param("annoScolastico") Integer annoScolastico,@Param("cicliScolastici") String cicliScolastici);

	
}
