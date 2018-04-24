package it.istruzione.ossscudig.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import it.istruzione.ossscudig.model.entity.MonitoraggioEntity;

public interface MonitoraggioRepository extends JpaRepository<MonitoraggioEntity, Long> {
	
	@Query(nativeQuery = true, value= " SELECT DISTINCT ROWNUM ID, A.COD_SCU_UT, A.DES_NOM_SCU DENOM, F.DES_QST QUESTIONARIO, D.DES_REG REGIONE, C.DES_PRV PROVINCIA, B.DES_COM COMUNE, G.DES_TIP_STA STATO "
			+ " FROM TWS1002_ANAGISTSCOL A, TWB1014_COMUNE B, MFG1029_PROVNUOIST C, TWB1012_REGIONE D, TOD1009_STATOQUESTSCUOLA E, TOD1002_ANAGRAFEQUESTIONARIO F, TOD1007_TIPOSTATO G "
			+ " WHERE G.COD_TIP_STA IN(:codTipStaIn)"
			
			+" AND( (:codiciclo is null)"
		    +" or (:codiciclo = 2 and (A.COD_TIP_SIT='IS' OR A.COD_TIP_SIT>'MM'))"
		    +" or (:codiciclo = 1 and NOT (A.COD_TIP_SIT='IS' OR A.COD_TIP_SIT>'MM'))  )"
			
			+ " AND A.COD_COM = B.COD_COM "
			+ " AND B.COD_PRV_NIS = C.COD_PRV "
			+ " AND C.COD_REG = D.COD_REG "
			+ " AND A.DAT_ANN_SCO_RIL = :annoScolastico "
			+ " AND (DAT_FIN_VAL IS NULL OR DAT_FIN_VAL > SYSDATE) "
			+ " AND E.COD_FOR_SCU = A.COD_FOR_SCU_APP "
			+ " AND E.PRG_IST_RIL = :prgIstRil "
			+ " AND F.COD_QST = E.COD_QST "
			+ " AND G.COD_TIP_STA = E.COD_TIP_STA "
			+ " AND (:codiceRegione IS NULL OR TRIM(C.COD_REG) = :codiceRegione) "
			+ " AND (:codiceProvincia IS NULL OR TRIM(C.COD_PRV) = :codiceProvincia) "
			+ " AND (:codiceComune IS NULL OR B.COD_COM = :codiceComune) "
			+ " ORDER BY A.COD_SCU_UT, F.DES_QST ")
	public List<MonitoraggioEntity> getAcquisizioneQuestionarioInCorso(@Param("annoScolastico") int annoScolastico,
																	   @Param("codiceComune") String codiceComune,
																	   @Param("codiceProvincia") String codiceProvincia,
																	   @Param("codiceRegione") String codiceRegione,
																	   @Param("prgIstRil") Long prgIstRil,
																	   @Param("codTipStaIn")   List<String> codTipStaIn,
																	   @Param("codiciclo")   String codiciclo);
	
//	@Query(nativeQuery = true, value= " SELECT ROWNUM ID, COD_SCU_UT, DENOM,  QUESTIONARIO, REGIONE, PROVINCIA, COMUNE, STATO FROM ( "
//									+ " SELECT DISTINCT A.COD_SCU_UT, A.DES_NOM_SCU DENOM, 'Istituto Principale' QUESTIONARIO, D.DES_REG REGIONE, C.DES_PRV PROVINCIA, B.DES_COM COMUNE, '' STATO "
//									+ " FROM TWS1002_ANAGISTSCOL A, TWB1014_COMUNE B, MFG1029_PROVNUOIST C, TWB1012_REGIONE D, TOD1015_VALRISPOSTADOMANDASCU E "
//									+ " WHERE "
//									+ " A.COD_COM = B.COD_COM "
//									
//								    +" AND( (:codiciclo is null)"
//							        +" or (:codiciclo = 2 and (A.COD_TIP_SIT='IS' OR A.COD_TIP_SIT>'MM'))"
//							        +" or (:codiciclo = 1 and NOT (A.COD_TIP_SIT='IS' OR A.COD_TIP_SIT>'MM'))  )"
//									
//									+ " AND B.COD_PRV_NIS = C.COD_PRV "
//									+ " AND C.COD_REG = D.COD_REG "
//									+ " AND A.DAT_ANN_SCO_RIL = :annoScolastico "
//									+ " AND (DAT_FIN_VAL IS NULL OR DAT_FIN_VAL > SYSDATE) "
//									+ " AND E.COD_FOR_SCU = A.COD_FOR_SCU_APP "
//									+ " AND A.COD_SCU_UT = A.COD_SCU_UT_PRI "
//									+ " AND E.PRG_IST_RIL = :prgIstRil "
//									+ " AND (:codiceRegione IS NULL OR TRIM(C.COD_REG) = :codiceRegione) "
//									+ " AND (:codiceProvincia IS NULL OR TRIM(C.COD_PRV) = :codiceProvincia) "
//									+ " AND (:codiceComune IS NULL OR B.COD_COM = :codiceComune) "
//
//									+ " ) ORDER BY COD_SCU_UT, QUESTIONARIO ")
//	public List<MonitoraggioEntity> getAcquisizioneRilevazioneValidata(@Param("annoScolastico") int annoScolastico,
//																	   @Param("codiceComune") String codiceComune,
//																	   @Param("codiceProvincia") String codiceProvincia,
//																	   @Param("codiceRegione") String codiceRegione,
//																	   @Param("prgIstRil") Long prgIstRil,
//																	   @Param("codiciclo")   String codiciclo);
	
//	
//	@Query(nativeQuery = true, value = " SELECT distinct ROWNUM ID, D.COD_FOR_SCU COD_SCU_UT, A.DES_NOM_SCU DENOM, 'Istituto Principale' QUESTIONARIO, R.DES_REG REGIONE, C.DES_PRV PROVINCIA, B.DES_COM COMUNE, '' STATO"
//			+ " FROM  TWS1002_ANAGISTSCOL A,TWB1014_COMUNE B,MFG1029_PROVNUOIST C,"
//			+ " (SELECT distinct (COD_FOR_SCU)  COD_FOR_SCU  FROM  TOD1015_VALRISPOSTADOMANDASCU T,"
//			+ " TWS1002_ANAGISTSCOL ANA  WHERE  PRG_IST_RIL = :prgIstRil"
//			+ " AND T.COD_FOR_SCU =  ANA.COD_FOR_SCU_APP  AND ANA.COD_SCU_UT = ANA.COD_SCU_UT_PRI ) D ,"
//			+ " TOD1013_GESTPROPRISTANZA E,  TOD1013_GESTPROPRISTANZA F,  TWB1012_REGIONE R "
//			+ " WHERE"
//			+ " C.COD_REG = R.COD_REG " 
//			+ " AND A.COD_SCU_UT = A.COD_SCU_UT_PRI"
//			+ " AND (E.COD_PRP_RIL = 'INCLUDI_ORDINE' AND ( E.DES_PRP_RIL = COD_TIP_SIT  OR (E.DES_PRP_RIL = 'SS' AND ( COD_TIP_SIT > 'MM' OR COD_TIP_SIT = 'IS' ))))"
//			+ " AND (F.COD_PRP_RIL = 'TIPOLOGIA_ISTITUTO'  AND (F.DES_PRP_RIL ='ALL' OR  (A.FLG_IST_STA = F.DES_PRP_RIL)))"
//			+ " AND (:flagAdulti IS NULL OR A.FLG_IST_ADU = :flagAdulti OR A.FLG_IST_ADU IS NULL) "	
//			+ " AND A.flg_ist_sta= 0"//FIXME: 0=STATALI - DA CANCELLARE UNA VOLTA CHE LA SCELTA DEL TIPO DI SCUOLA (statle/privata/tutte) SARA' AUTOMATIZZATA
//			+ " AND A.COD_COM = B.COD_COM  AND B.COD_PRV_NIS = C.COD_PRV"
//			+ " AND A.DAT_ANN_SCO_RIL = :annoScolastico  AND (DAT_FIN_VAL IS NULL OR DAT_FIN_VAL > SYSDATE)"
//			+ " AND D.COD_FOR_SCU = A.COD_FOR_SCU_APP  AND( (:codiciclo is null) OR"
//			+ " (:codiciclo = 2 and (A.COD_TIP_SIT='IS' OR A.COD_TIP_SIT>'MM')) OR"
//			+ " (:codiciclo = 1 and NOT (A.COD_TIP_SIT='IS' OR A.COD_TIP_SIT>'MM'))  )"
//			+ " AND (:codiceRegione IS NULL OR C.COD_REG = :codiceRegione)"
//			+ " AND (:codiceProvincia IS NULL OR C.COD_PRV = :codiceProvincia)"
//			+ " AND (:codiceComune IS NULL OR B.COD_COM = :codiceComune)")
	
	
	@Query(nativeQuery = true, value ="SELECT ROWNUM ID, COD_SCU_UT,DENOM,QUESTIONARIO,REGIONE,PROVINCIA,COMUNE,STATO " + 
			" FROM " + 
			" (select distinct A.COD_SCU_UT COD_SCU_UT, A.COD_SCU_UT_PRI, A.DES_NOM_SCU DENOM, 'Istituto Principale' QUESTIONARIO, R.DES_REG REGIONE, C.DES_PRV PROVINCIA, B.DES_COM COMUNE, '' STATO," + 
			" 	case" + 
			"    	when exists (select 1 from " + 
			"    	TOD1015_VALRISPOSTADOMANDASCU T " + 
			"    	WHERE " + 
			"    	PRG_IST_RIL = :prgIstRil " + 
			"    	AND T.COD_FOR_SCU =  A.COD_FOR_SCU_APP) then 1 " + 
			"    	else 0 " + 
			" 	end as validato " + 
			" from " + 
			" TWS1002_ANAGISTSCOL A, " + 
			" TWB1014_COMUNE B, " + 
			" MFG1029_PROVNUOIST C, " + 
			" TWB1012_REGIONE R, " + 
			" TOD1013_GESTPROPRISTANZA E, " + 
			" TOD1013_GESTPROPRISTANZA F " + 
			" where " + 
			" A.COD_SCU_UT = A.COD_SCU_UT_PRI " + 
			" and C.COD_REG = R.COD_REG  " + 
			" and (E.COD_PRP_RIL = 'INCLUDI_ORDINE' AND ( E.DES_PRP_RIL = COD_TIP_SIT  OR (E.DES_PRP_RIL = 'SS' AND ( COD_TIP_SIT > 'MM' OR COD_TIP_SIT = 'IS' )))) " + 
			" and (F.COD_PRP_RIL = 'TIPOLOGIA_ISTITUTO'  AND (F.DES_PRP_RIL ='ALL' OR  (A.FLG_IST_STA = F.DES_PRP_RIL))) " + 
			" and A.flg_ist_sta= 0 " + 
			" and A.COD_COM = B.COD_COM " + 
			" and B.COD_PRV_NIS = C.COD_PRV " + 
			" and A.DAT_ANN_SCO_RIL = :annoScolastico " + 
			" and (DAT_FIN_VAL IS NULL OR DAT_FIN_VAL > SYSDATE) " + 
			" and (:flagAdulti IS NULL OR A.FLG_IST_ADU = :flagAdulti OR A.FLG_IST_ADU IS NULL) " +	
			" and((:codiciclo is null) " + 
			"     or (:codiciclo =2 and (A.COD_TIP_SIT='IS' OR A.COD_TIP_SIT>'MM')) " + 
			"     or (:codiciclo =1 and NOT (A.COD_TIP_SIT='IS' OR A.COD_TIP_SIT>'MM'))) " + 
			" and (:codiceRegione IS NULL OR TRIM(C.COD_REG) = :codiceRegione) " + 
			" and (:codiceProvincia IS NULL OR TRIM(C.COD_PRV) = :codiceProvincia) " + 
			" and (:codiceComune IS NULL OR B.COD_COM = :codiceComune)) " + 
			" WHERE validato=1 ")
	public List<MonitoraggioEntity> getNumeriElencoValidati(
			@Param("annoScolastico") int annoScolastico,
			@Param("codiceComune") String codiceComune,
			@Param("codiceProvincia") String codiceProvincia,
			@Param("codiceRegione") String codiceRegione,
			@Param("prgIstRil") Long prgIstRil,
			@Param("codiciclo") String codiciclo,
			@Param("flagAdulti") String flagAdulti);

}
