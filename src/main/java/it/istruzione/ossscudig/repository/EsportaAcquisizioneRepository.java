package it.istruzione.ossscudig.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import it.istruzione.ossscudig.model.entity.ElencoScuoleCountEntity;

public interface EsportaAcquisizioneRepository extends JpaRepository<ElencoScuoleCountEntity, Long> {
	
	@Query(nativeQuery = true, value= " select rownum ID, COD_QUESTIONARIO, QUESTIONARIO, IN_CORSO, VALIDATI from ("  
			+" SELECT COD_QUESTIONARIO, QUESTIONARIO, COUNT (COD_SCU_UT) IN_CORSO, SUM(NUM_STA_VAL) VALIDATI"
			+" FROM ( SELECT DISTINCT ROWNUM ID,A.COD_SCU_UT,A.DES_NOM_SCU DENOM,F.COD_QST COD_QUESTIONARIO, F.DES_QST QUESTIONARIO,G.DES_TIP_STA STATO,"
			+" CASE WHEN "
			+" A.COD_FOR_SCU_APP IN (select S.COD_FOR_SCU from  TOD1015_VALRISPOSTADOMANDASCU S where S.COD_FOR_SCU=A.COD_FOR_SCU_APP AND E.COD_QST=S.COD_QST)"
			+" then 1 else 0 END AS NUM_STA_VAL FROM TWS1002_ANAGISTSCOL A, TWB1014_COMUNE B, MFG1029_PROVNUOIST C, TWB1012_REGIONE D, TOD1009_STATOQUESTSCUOLA E, TOD1002_ANAGRAFEQUESTIONARIO F, TOD1007_TIPOSTATO G"
			             +" WHERE "
			             +" A.COD_COM = B.COD_COM"
			             +" AND B.COD_PRV_NIS = C.COD_PRV"
			             +" AND C.COD_REG = D.COD_REG"
			             +" AND A.DAT_ANN_SCO_RIL = :annoScolastico"
			             +" AND (DAT_FIN_VAL IS NULL OR DAT_FIN_VAL > SYSDATE)"
			             +" AND E.COD_FOR_SCU = A.COD_FOR_SCU_APP"
			             +" AND E.PRG_IST_RIL = :prgIstRil"
			             +" AND F.COD_QST = E.COD_QST"
			             +" and (:codScu IS NULL OR TRIM(A.COD_SCU_UT) = :codScu)"
			             +" AND G.COD_TIP_STA = E.COD_TIP_STA"
			             +" AND (:codiceRegione IS NULL OR trim(C.COD_REG) = :codiceRegione)"
			             +" AND (:codiceProvincia IS NULL OR C.COD_PRV = :codiceProvincia)"
			             +" AND (:codiceComune IS NULL OR B.COD_COM = :codiceComune)"
			             +" ORDER BY A.COD_SCU_UT, F.DES_QST )"
			  +" GROUP BY QUESTIONARIO,COD_QUESTIONARIO )" )
	public List<ElencoScuoleCountEntity> getElencoScuoleAndCount(@Param("prgIstRil") String prgIstRil, @Param("annoScolastico") String annoScolastico, @Param("codiceRegione") String codiceRegione, @Param("codiceProvincia") String codiceProvincia, 
			@Param("codiceComune") String codiceComune, @Param("codScu") String codScu);
	
}
