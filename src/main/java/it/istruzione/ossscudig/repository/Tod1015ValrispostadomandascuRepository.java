package it.istruzione.ossscudig.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.istruzione.ossscudig.controllers.util.CommonsUtility;
import it.istruzione.ossscudig.model.entity.PubblicazioneEntity;
import it.istruzione.ossscudig.model.entity.StoricizzazioneEntity;
import it.istruzione.ossscudig.model.entity.Tod1015Valrispostadomandascu;
import it.istruzione.ossscudig.model.entity.Tod1015ValrispostadomandascuPK;

public interface Tod1015ValrispostadomandascuRepository extends JpaRepository<Tod1015Valrispostadomandascu, Tod1015ValrispostadomandascuPK> {
	
	List<Tod1015Valrispostadomandascu> findByIdPrgIstRil(long prgIstRil);
	
	List<Tod1015Valrispostadomandascu> findByIdCodForScuAndIdPrgIstRil(String codForScu, long prgIstRil);
	
	List<Tod1015Valrispostadomandascu> findByIdCodForScuAndIdPrgIstRilAndIdCodQst(String codForScu, long prgIstRil, String codQst);
	
	List<Tod1015Valrispostadomandascu> findByIdCodForScuAndIdPrgIstRilAndIdCodDmdAndIdCodEdiAndIdCodQst(String codForScu, 
																									 long prgIstRil, 
																									 String codDmd, 
																									 String codEdi,
																									 String codQst);

	
	
	//il valida si attiva solo quando sono completi tutti i questionari,e la data di salvataggio delle domande in corso è superiore alla data di validazione.

	@Query(nativeQuery = true, value= " select max(1) "
			+ " FROM TOD1014_RISPOSTADOMANDASCU A, TOD1015_VALRISPOSTADOMANDASCU B "
			+ " WHERE "
			+ " A.COD_FOR_SCU=B.COD_FOR_SCU "
			+ " AND A.DAT_ORA_ULT_MOV > B.DAT_VLD_RIS  "
			+ " AND A.COD_FOR_SCU in( :codForScu)")
    public Integer getValidatePerData(@Param("codForScu") String codForScu); 
	

	@Query(nativeQuery = true, value= " select MAX(B.DAT_VLD_RIS) AS Data,MAX(DECODE(A.DAT_ORA_ULT_MOV,NULL,'N','S')) AS Filtro"
			+ " FROM TOD1015_VALRISPOSTADOMANDASCU B LEFT OUTER JOIN TOD1018_VALLIMRIS A "
			+ " ON TRUNC(A.DAT_ORA_ULT_MOV) = TRUNC(B.DAT_VLD_RIS) ")
    public List<StoricizzazioneEntity> getFiltriUltimaDataPubblicazione(); 
	

	@Query(nativeQuery = true, value= " SELECT D.DES_QST AS DES_QST,E.DES_SEZ AS DES_SEZ ,A.COD_IDE_DMD AS COD_IDE_DMD,A.COD_DMD AS COD_DMD ,A.DES_DMD AS DES_DMD, "
			+ " MIN(TO_NUMBER(decode(REGEXP_INSTR (B.DES_RIS, '[^[:digit:]]'),0,B.DES_RIS,NULL))) AS MINIMO  ,"
			+ " MAX(TO_NUMBER(decode(REGEXP_INSTR (B.DES_RIS, '[^[:digit:]]'),0,B.DES_RIS,NULL))) AS MASSIMO , "
			+ " AVG(TO_NUMBER(decode(REGEXP_INSTR (B.DES_RIS, '[^[:digit:]]'),0,B.DES_RIS,NULL))) AS MEDIA , "
			+ " C.NUM_VAL_MIN AS NUM_VAL_MIN ,C.NUM_VAL_MAS AS NUM_VAL_MAS ,C.PRG_IST_RIL AS ID ,C.COD_QST AS COD_QST "
			+ " FROM  TOD1004_ANAGRAFEDOMANDA A, TOD1015_VALRISPOSTADOMANDASCU B,TOD1018_VALLIMRIS C , TOD1002_ANAGRAFEQUESTIONARIO D,TOD1003_ANAGRAFESEZIONE E "
			+ " WHERE A.COD_DMD = B.COD_DMD "
			+ " AND   C.COD_DMD = B.COD_DMD "
			+ " AND   C.COD_QST = B.COD_QST "
			+ " AND   D.COD_QST = B.COD_QST "
			+ " AND   D.PRG_IST_RIL = B.PRG_IST_RIL "
			+ " AND   C.PRG_IST_RIL = B.PRG_IST_RIL "
			+ " AND   E.COD_SEZ = A.COD_SEZ "
			+ " GROUP BY D.DES_QST, E.DES_SEZ, A.COD_IDE_DMD, A.COD_DMD, A.DES_DMD ,C.NUM_VAL_MIN, C.NUM_VAL_MAS,C.PRG_IST_RIL ,C.COD_QST ")
    public List<PubblicazioneEntity> getPubblicazione();
	
	
	


     }
