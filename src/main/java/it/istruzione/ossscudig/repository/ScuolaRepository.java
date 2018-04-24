package it.istruzione.ossscudig.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.istruzione.ossscudig.model.entity.Scuola;
import it.istruzione.ossscudig.model.entity.ScuolaPK;

public interface ScuolaRepository extends JpaRepository<Scuola, ScuolaPK> {
	
	@Query(nativeQuery = true, value= " SELECT A.COD_SCU_UT_PRI, A.COD_SCU_UT, A.DAT_ANN_SCO_RIL, A.COD_FOR_SCU_APP, A.DES_NOM_SCU, A.DES_IND_SCU, A.DES_TIP_IST, B.DES_COM, C.DES_PRV,"//A.DES_NOM_SCU A.DES_IND_SCU
									+ " A.COD_TEL_SCU, A.COD_FAX_SCU, A.DES_IND_EML, A.DES_IND_WEB, A.DES_IND_EMA_PCE, A.COD_CAR_SCU, A.FLG_IST_STA, A.DES_NOM_SCU, A.DES_IND_SCU "
									+ " FROM TWS1002_ANAGISTSCOL A, "
									+ " TWB1014_COMUNE B, MFG1029_PROVNUOIST C "
									+ " WHERE "
									+ " A.COD_COM = B.COD_COM "
									+ " AND B.COD_PRV_NIS = C.COD_PRV "
									+ " AND A.DAT_ANN_SCO_RIL = :annoScolastico "
									+ " AND A.COD_FOR_SCU_APP = :codForScuApp "
									+ " AND A.COD_SCU_UT = A.COD_SCU_UT_PRI "
									+ " AND (A.DAT_FIN_VAL IS NULL OR A.DAT_FIN_VAL > SYSDATE) ")
	public Scuola findIstitutoPrincipaleByCodiceForteAndAnnoScolastico(@Param("codForScuApp") String codForScuApp, @Param("annoScolastico") int annoScolastico);


	@Query(nativeQuery = true, value= " SELECT A.COD_SCU_UT_PRI, A.COD_SCU_UT, A.DAT_ANN_SCO_RIL, A.COD_FOR_SCU_APP, A.DES_NOM_SCU, A.DES_IND_SCU, A.DES_TIP_IST, B.DES_COM, C.DES_PRV,"
									+ " A.COD_TEL_SCU, A.COD_FAX_SCU, A.DES_IND_EML, A.DES_IND_WEB, A.DES_IND_EMA_PCE, A.COD_CAR_SCU, A.FLG_IST_STA, CASE WHEN A.COD_SCU_UT = A.COD_SCU_UT_PRI THEN 0 ELSE 1 END AS ORDINAMENTO_PER_IST "
									+ " FROM TWS1002_ANAGISTSCOL A, TWB1014_COMUNE B, MFG1029_PROVNUOIST C "
									+ " WHERE "
									+ " A.COD_COM = B.COD_COM "
									+ " AND B.COD_PRV_NIS = C.COD_PRV "
									+ " AND DAT_ANN_SCO_RIL = :annoScolastico "
									+ " AND COD_SCU_UT_PRI = :codScuUtPri "
									+ " AND (DAT_FIN_VAL IS NULL OR DAT_FIN_VAL > SYSDATE) "
									+ " AND ("
									+ " 		(:ordineAA IS NOT NULL AND COD_TIP_SIT = 'AA') "
									+ "			OR (:ordineEE IS NOT NULL AND COD_TIP_SIT = 'EE')"
									+ "			OR (:ordineMM IS NOT NULL AND COD_TIP_SIT = 'MM')"
									+ "			OR (:ordineIC IS NOT NULL AND COD_TIP_SIT = 'IC')"
									+ "			OR (:ordineCT IS NOT NULL AND COD_TIP_SIT = 'CT')"
									+ "			OR (:ordineSS IS NOT NULL AND (A.COD_TIP_SIT > 'MM' OR A.COD_TIP_SIT = 'IS') )"
									+ "			OR (:ordineALL IS NOT NULL)"
									+ " ) "
									+ " AND (:flagAdulti IS NULL OR A.FLG_IST_ADU = :flagAdulti OR A.FLG_IST_ADU IS NULL) "	
									+ " AND (:tipoScuola IS NULL OR A.FLG_IST_STA = :tipoScuola) "
									+ " AND (:codiceRegioneNelCampione IS NULL OR TRIM(C.COD_REG) = :codiceRegioneNelCampione) "									
									+ " ORDER BY ORDINAMENTO_PER_IST ")
	public List<Scuola> findPlessiByCodiceMeccanograficoIstitutoPrincipaleAndAnnoScolastico(@Param("codScuUtPri") String codScuUtPri, 
																							@Param("annoScolastico") int annoScolastico,
																							@Param("ordineAA") String ordineAANelCampione,
																							@Param("ordineEE") String ordineEENelCampione,
																							@Param("ordineMM") String ordineMMNelCampione,
																							@Param("ordineSS") String ordineSSNelCampione,
																							@Param("ordineIC") String ordineICNelCampione,
																							@Param("ordineCT") String ordineCTNelCampione,
																							@Param("ordineALL") String ordineALLNelCampione,
																							@Param("flagAdulti") String flagAdulti,
																							@Param("tipoScuola") String tipoScuolaNelCampione,
																							@Param("codiceRegioneNelCampione") String codiceRegioneNelCampione);

	@Query(nativeQuery = true, value= " SELECT A.COD_SCU_UT_PRI, A.COD_SCU_UT, A.DAT_ANN_SCO_RIL, A.COD_FOR_SCU_APP, A.DES_NOM_SCU, A.DES_IND_SCU, A.DES_TIP_IST, B.DES_COM, C.DES_PRV,"
									+ " A.COD_TEL_SCU, A.COD_FAX_SCU, A.DES_IND_EML, A.DES_IND_WEB, A.DES_IND_EMA_PCE, A.COD_CAR_SCU, A.FLG_IST_STA "
									+ " FROM TWS1002_ANAGISTSCOL A, TWB1014_COMUNE B, MFG1029_PROVNUOIST C "
									+ " WHERE "
									+ " A.COD_COM = B.COD_COM "
									+ " AND B.COD_PRV_NIS = C.COD_PRV "
									+ " AND DAT_ANN_SCO_RIL = :annoScolastico "
									+ " AND COD_SCU_UT = :codScuUt "
									+ " AND (DAT_FIN_VAL IS NULL OR DAT_FIN_VAL > SYSDATE) ")
	public Scuola findPlessoByCodiceMeccanograficoAndAnnoScolastico(@Param("codScuUt") String codScuUt, @Param("annoScolastico") int annoScolastico);

	@Query(nativeQuery = true, value= " SELECT A.COD_SCU_UT_PRI, A.COD_SCU_UT, A.DAT_ANN_SCO_RIL, A.COD_FOR_SCU_APP, A.DES_NOM_SCU, A.DES_IND_SCU, A.DES_TIP_IST, B.DES_COM, C.DES_PRV,"
									+ " A.COD_TEL_SCU, A.COD_FAX_SCU, A.DES_IND_EML, A.DES_IND_WEB, A.DES_IND_EMA_PCE, A.COD_CAR_SCU, A.FLG_IST_STA "
									+ " FROM TWS1002_ANAGISTSCOL A, TWB1014_COMUNE B, MFG1029_PROVNUOIST C "
									+ " WHERE "
									+ " A.COD_COM = B.COD_COM "
									+ " AND B.COD_PRV_NIS = C.COD_PRV "
									+ " AND DAT_ANN_SCO_RIL = :annoScolastico "
									+ " AND COD_FOR_SCU_APP = :codForScuApp "
									+ " AND (DAT_FIN_VAL IS NULL OR DAT_FIN_VAL > SYSDATE) ")
	public Scuola findPlessoByCodiceForteAndAnnoScolastico(@Param("codForScuApp") String codForScuApp, @Param("annoScolastico") int annoScolastico);

	@Query(nativeQuery = true, value= " SELECT COUNT(*) "
									+ " FROM TWS1002_ANAGISTSCOL A, TWB1014_COMUNE B, MFG1029_PROVNUOIST C "
									+ " WHERE "
									+ " A.COD_COM = B.COD_COM "
									+ " AND B.COD_PRV_NIS = C.COD_PRV "
									+ " AND A.DAT_ANN_SCO_RIL = :annoScolastico "
									+ " AND (DAT_FIN_VAL IS NULL OR DAT_FIN_VAL > SYSDATE) "
									+ " AND ("
									+ " 		(:ordineAA IS NOT NULL AND COD_TIP_SIT = 'AA') "
									+ "			OR (:ordineEE IS NOT NULL AND COD_TIP_SIT = 'EE')"
									+ "			OR (:ordineMM IS NOT NULL AND COD_TIP_SIT = 'MM')"
									+ "			OR (:ordineIC IS NOT NULL AND COD_TIP_SIT = 'IC')"
									+ "			OR (:ordineCT IS NOT NULL AND COD_TIP_SIT = 'CT')"
									+ "			OR (:ordineSS IS NOT NULL AND (A.COD_TIP_SIT > 'MM' OR A.COD_TIP_SIT = 'IS') )"
									+ "			OR (:ordineALL IS NOT NULL)"
									+ " ) "
									+ " AND (:flagAdulti IS NULL OR A.FLG_IST_ADU = :flagAdulti OR A.FLG_IST_ADU IS NULL) "	
									+ " AND (:tipoScuola IS NULL OR A.FLG_IST_STA = :tipoScuola) "
									+ " AND (:codiceRegioneNelCampione IS NULL OR TRIM(C.COD_REG) = :codiceRegioneNelCampione) "
									+ " AND (:codiceRegione IS NULL OR TRIM(C.COD_REG) = :codiceRegione) "
									+ " AND (:codiceProvincia IS NULL OR TRIM(C.COD_PRV) = :codiceProvincia) "
									+ " AND (:codiceComune IS NULL OR B.COD_COM = :codiceComune) ")
	public Integer getNumeroScuoleCampione(
										   @Param("ordineAA") String ordineAANelCampione,
										   @Param("ordineEE") String ordineEENelCampione,
										   @Param("ordineMM") String ordineMMNelCampione,
										   @Param("ordineSS") String ordineSSNelCampione,
										   @Param("ordineIC") String ordineICNelCampione,
										   @Param("ordineCT") String ordineCTNelCampione,
										   @Param("ordineALL") String ordineALLNelCampione,
										   @Param("flagAdulti") String flagAdulti,
										   @Param("tipoScuola") String tipoScuolaNelCampione,
										   @Param("codiceRegioneNelCampione") String codiceRegioneNelCampione,
										   @Param("annoScolastico") int annoScolastico,
										   @Param("codiceComune") String codiceComune,
										   @Param("codiceProvincia") String codiceProvincia,
										   @Param("codiceRegione") String codiceRegione);


}
