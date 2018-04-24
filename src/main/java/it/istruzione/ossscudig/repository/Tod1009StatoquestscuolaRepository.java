package it.istruzione.ossscudig.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.istruzione.ossscudig.model.entity.Tod1009Statoquestscuola;
import it.istruzione.ossscudig.model.entity.Tod1009StatoquestscuolaPK;

public interface Tod1009StatoquestscuolaRepository
		extends JpaRepository<Tod1009Statoquestscuola, Tod1009StatoquestscuolaPK> {

	@Query(nativeQuery = true, value = " SELECT COUNT(*) "
			+ " FROM TWS1002_ANAGISTSCOL A, TWB1014_COMUNE B, MFG1029_PROVNUOIST C, TOD1009_STATOQUESTSCUOLA D "
			+ " WHERE " + " A.COD_COM = B.COD_COM " + " AND B.COD_PRV_NIS = C.COD_PRV "
			+ " AND A.DAT_ANN_SCO_RIL = :annoScolastico " + " AND (DAT_FIN_VAL IS NULL OR DAT_FIN_VAL > SYSDATE) "
			+ " AND D.COD_FOR_SCU = A.COD_FOR_SCU_APP " + " AND D.PRG_IST_RIL = :prgIstRil "
			+ " AND D.COD_TIP_STA = :codSta " + " AND (:codiceRegione IS NULL OR C.COD_REG = :codiceRegione) "
			+ " AND (:codiceProvincia IS NULL OR C.COD_PRV = :codiceProvincia) "
			+ " AND (:codiceComune IS NULL OR B.COD_COM = :codiceComune) ")
	public Integer getNumeroQuestionariScuolaPerRilevazioneEStato(
			@Param("prgIstRil") Long prgIstRil,
			@Param("annoScolastico") int annoScolastico,
			@Param("codiceComune") String codiceComune,
			@Param("codiceProvincia") String codiceProvincia,
			@Param("codiceRegione") String codiceRegione,
			@Param("codSta") String codSta);

	@Query(nativeQuery = true, value = " "
			+ " SELECT COUNT(distinct COD_FOR_SCU_APP)TOTALE, SUM(DECODE(D.COD_TIP_STA,7,1,0)) INCOMPILAZIONE, SUM(DECODE(D.COD_TIP_STA,9,1,0)) COPILATI"
			+ " FROM" + " TWS1002_ANAGISTSCOL A," + " TWB1014_COMUNE B," + " MFG1029_PROVNUOIST C,"
			+ " (SELECT COD_FOR_SCU, COD_TIP_STA FROM" + " TOD1009_STATOQUESTSCUOLA" + " WHERE"
			+ " PRG_IST_RIL = :prgIstRil)D ," + " TOD1013_GESTPROPRISTANZA E," + " TOD1013_GESTPROPRISTANZA F"
			+ " WHERE" + " A.COD_COM = B.COD_COM" + " AND B.COD_PRV_NIS = C.COD_PRV"
			+ " AND A.DAT_ANN_SCO_RIL = :annoScolastico" + " AND (DAT_FIN_VAL IS NULL OR DAT_FIN_VAL > SYSDATE)"
			+ " AND D.COD_FOR_SCU(+) = A.COD_FOR_SCU_APP"
			+ " AND (E.COD_PRP_RIL = 'INCLUDI_ORDINE' AND ( E.DES_PRP_RIL = COD_TIP_SIT  OR (E.DES_PRP_RIL = 'SS' AND ( COD_TIP_SIT > 'MM' OR COD_TIP_SIT = 'IS' ))))"
			+ " AND (F.COD_PRP_RIL = 'TIPOLOGIA_ISTITUTO'  AND (F.DES_PRP_RIL ='ALL' OR  (A.FLG_IST_STA = F.DES_PRP_RIL)))"
			+ " AND (:flagAdulti IS NULL OR A.FLG_IST_ADU = :flagAdulti OR A.FLG_IST_ADU IS NULL) "	
			+ " and flg_ist_sta= 0"//FIXME: 0=STATALI - DA CANCELLARE UNA VOLTA CHE LA SCELTA DEL TIPO DI SCUOLA (statle/privata/tutte) SARA' AUTOMATIZZATA
			+ " AND(" + "        (:codiciclo is null)" + " or"
			+ " (:codiciclo = 2 and (A.COD_TIP_SIT='IS' OR A.COD_TIP_SIT>'MM'))" + " or"
			+ " (:codiciclo = 1 and NOT (A.COD_TIP_SIT='IS' OR A.COD_TIP_SIT>'MM'))" + " )"
			+ " AND (:codiceRegione IS NULL OR C.COD_REG = :codiceRegione)"
			+ " AND (:codiceProvincia IS NULL OR C.COD_PRV = :codiceProvincia)"
			+ " AND (:codiceComune IS NULL OR B.COD_COM = :codiceComune)"

	)
	public List<Object[]> getNumeriTortaQstInCorso(
			@Param("prgIstRil") Long prgIstRil,
			@Param("annoScolastico") int annoScolastico,
			@Param("flagAdulti") String flagAdulti,
			@Param("codiceComune") String codiceComune,
			@Param("codiceProvincia") String codiceProvincia,
			@Param("codiceRegione") String codiceRegione,
			@Param("codiciclo") String codiciclo);

	@Query(nativeQuery = true, value = " " + " SELECT COUNT(A.COD_SCU_UT) TOTALE , COUNT(D.COD_FOR_SCU) COMPILATI"
			+ " FROM" + " TWS1002_ANAGISTSCOL A," + " TWB1014_COMUNE B," + " MFG1029_PROVNUOIST C,"
			+ " (SELECT distinct (COD_FOR_SCU)  COD_FOR_SCU" + " FROM" + " TOD1015_VALRISPOSTADOMANDASCU T,"
			+ " TWS1002_ANAGISTSCOL ANA" + " WHERE" + " PRG_IST_RIL = :prgIstRil"
			+ " AND T.COD_FOR_SCU =  ANA.COD_FOR_SCU_APP" + " AND ANA.COD_SCU_UT = ANA.COD_SCU_UT_PRI )D ,"
			+ " TOD1013_GESTPROPRISTANZA E," + " TOD1013_GESTPROPRISTANZA F" + " WHERE"
			+ " A.COD_SCU_UT = A.COD_SCU_UT_PRI"
			+ " AND (E.COD_PRP_RIL = 'INCLUDI_ORDINE' AND ( E.DES_PRP_RIL = COD_TIP_SIT  OR (E.DES_PRP_RIL = 'SS' AND ( COD_TIP_SIT > 'MM' OR COD_TIP_SIT = 'IS' ))))"
			+ " AND (F.COD_PRP_RIL = 'TIPOLOGIA_ISTITUTO'  AND (F.DES_PRP_RIL ='ALL' OR  (A.FLG_IST_STA = F.DES_PRP_RIL)))"
			+ " AND (:flagAdulti IS NULL OR A.FLG_IST_ADU = :flagAdulti OR A.FLG_IST_ADU IS NULL) "	
			+ " AND A.flg_ist_sta= 0"//FIXME: 0=STATALI - DA CANCELLARE UNA VOLTA CHE LA SCELTA DEL TIPO DI SCUOLA (statle/privata/tutte) SARA' AUTOMATIZZATA
			+ " AND A.COD_COM = B.COD_COM" + " AND B.COD_PRV_NIS = C.COD_PRV"
			+ " AND A.DAT_ANN_SCO_RIL = :annoScolastico" + " AND (DAT_FIN_VAL IS NULL OR DAT_FIN_VAL > SYSDATE)"
			+ " AND D.COD_FOR_SCU (+)= A.COD_FOR_SCU_APP" + " AND( (:codiciclo is null)" + " or"
			+ " (:codiciclo = 2 and (A.COD_TIP_SIT='IS' OR A.COD_TIP_SIT>'MM'))" + " or"
			+ " (:codiciclo = 1 and NOT (A.COD_TIP_SIT='IS' OR A.COD_TIP_SIT>'MM'))" + " )"
			+ " AND (:codiceRegione IS NULL OR C.COD_REG = :codiceRegione)"
			+ " AND (:codiceProvincia IS NULL OR C.COD_PRV = :codiceProvincia)"
			+ " AND (:codiceComune IS NULL OR B.COD_COM = :codiceComune)")
	public List<Object[]> getNumeriTortaValidati(
			@Param("prgIstRil") Long prgIstRil,
			@Param("flagAdulti") String flagAdulti,
			@Param("annoScolastico") int annoScolastico,
			@Param("codiceComune") String codiceComune,
			@Param("codiceProvincia") String codiceProvincia,
			@Param("codiceRegione") String codiceRegione,
			@Param("codiciclo") String codiciclo);

}
