package it.istruzione.ossscudig.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.istruzione.ossscudig.model.entity.PubblicazionePercentualeRecordsEntity;
import it.istruzione.ossscudig.model.entity.PubblicazioneRecordsEntity;

public interface PubblicazioneRecordRepository extends JpaRepository<PubblicazioneRecordsEntity,String> {
	
	@Query(nativeQuery = true, value= " SELECT B.COD_FOR_SCU AS COD_FOR_SCU, A.COD_IDE_DMD AS COD_IDE_DMD, A.DES_DMD AS DES_DMD,  decode(REGEXP_INSTR (B.DES_RIS, '[^[:digit:]]'),0,B.DES_RIS,NULL) AS DES_RIS " 
			+ " FROM TOD1004_ANAGRAFEDOMANDA A,TOD1015_VALRISPOSTADOMANDASCU B,TOD1018_VALLIMRIS C " 
			+ " WHERE  A.COD_DMD = B.COD_DMD "
			+ " AND  C.COD_DMD = B.COD_DMD "
			+ " AND  C.COD_QST = B.COD_QST "
			+ " AND  C.PRG_IST_RIL = B.PRG_IST_RIL " 
			+ " AND  C.COD_DMD = :codicedomanda "
			+ " AND  (TO_NUMBER(decode(REGEXP_INSTR (B.DES_RIS, '[^[:digit:]]'),0,B.DES_RIS,NULL)) < :limiteminimo  " 
			+ " OR "
			+ " TO_NUMBER(decode(REGEXP_INSTR (B.DES_RIS, '[^[:digit:]]'),0,B.DES_RIS,NULL)) >:limitemassimo ) ") 
				
	public List<PubblicazioneRecordsEntity> getRecordsPubblicazione(@Param("codicedomanda") String codicedomanda ,@Param("limiteminimo") String limiteminimo, @Param("limitemassimo") String limitemassimo);
	
	
	@Query(nativeQuery = true, value= " select NVL(SUM(DOM_ESC),0) AS DOM_ESC,NVL(SUM(DOM_TOT),0) AS DOM_TOT, TO_CHAR(NVL(SUM((DOM_ESC/DOM_TOT*100)),0),'990.99') ||'%' AS PER_DMD " 
			+ " FROM  " 	
			+ " (SELECT count (distinct B.COD_FOR_SCU) DOM_ESC,A.COD_DMD " 	
			+ " FROM "  
			+ " TOD1004_ANAGRAFEDOMANDA A, TOD1015_VALRISPOSTADOMANDASCU B,TOD1018_VALLIMRIS C "		
			+ " WHERE " 
			+ " A.COD_DMD = B.COD_DMD " 
			+ " AND   C.COD_DMD = B.COD_DMD " 
		    + " AND   C.COD_QST = B.COD_QST " 
			+ " AND   C.PRG_IST_RIL = B.PRG_IST_RIL " 
			+ " AND   C.COD_DMD = :codicedomanda " 
			
			+ " AND   (TO_NUMBER(decode(REGEXP_INSTR (B.DES_RIS, '[^[:digit:]]'),0,B.DES_RIS,NULL)) < :limiteminimo " 
			+ " OR " 
			+ " TO_NUMBER(decode(REGEXP_INSTR (B.DES_RIS, '[^[:digit:]]'),0,B.DES_RIS,NULL)) > :limitemassimo ) "  
			+ " GROUP BY A.COD_DMD ) ESC, "		 
			+ " (SELECT count (distinct B.COD_FOR_SCU) DOM_TOT, A.COD_DMD "  
			+ " FROM " 
			+ " TOD1004_ANAGRAFEDOMANDA A,TOD1015_VALRISPOSTADOMANDASCU B,TOD1018_VALLIMRIS C " 
			+ " WHERE "  
		    + " A.COD_DMD = B.COD_DMD "  
			+ " AND C.COD_DMD = B.COD_DMD "  
			+ " AND C.COD_QST = B.COD_QST " 
			+ " AND C.PRG_IST_RIL = B.PRG_IST_RIL "  
			+ " AND C.COD_DMD = :codicedomanda "
			+ " GROUP BY A.COD_DMD) TOT "
			+ " WHERE TOT.COD_DMD = ESC.COD_DMD ") 
				
	public List<Object> getPercentualeRecordIgnorati(@Param("codicedomanda") String codicedomanda ,@Param("limiteminimo") String limiteminimo, @Param("limitemassimo") String limitemassimo);




}
