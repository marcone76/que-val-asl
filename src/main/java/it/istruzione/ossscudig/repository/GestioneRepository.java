package it.istruzione.ossscudig.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import it.istruzione.ossscudig.model.entity.GestioneEntity;

public interface GestioneRepository extends JpaRepository<GestioneEntity, Long> {
	
	
	@Query(nativeQuery = true, value= "SELECT ROWNUM ID, B.DES_QST QUESTIONARIO, C.DES_TIP_STA STATO, B.COD_QST COD_QUESTIONARIO, A.PRG_IST_RIL COD_RILEVAZIONE, B.COD_TIP_STA COD_TIP_STA" 						
			+ " FROM TOD1001_ISTANZARILEVAZIONE A, TOD1002_ANAGRAFEQUESTIONARIO B, TOD1007_TIPOSTATO C "
			+ " WHERE "
			+ " A.COD_TIP_STA = :codTipSta "
			+ " AND A.PRG_IST_RIL = B.PRG_IST_RIL "
			+ " AND B.COD_TIP_STA = C.COD_TIP_STA ")

public List<GestioneEntity> findBozzaRilevazioniPerQuestionari(@Param("codTipSta") int codTipSta);
	
	
	 
}
