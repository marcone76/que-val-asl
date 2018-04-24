package it.istruzione.ossscudig.model.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;

@Entity
//@SqlResultSetMapping(
//	    name="studentPercentile",
//	    entities={
//	        @EntityResult(
//	           entityClass=CustomStudent.class,
//	              fields={
//	                  @FieldResult(name="id", column="ID"),
//	                  @FieldResult(name="firstName", column="FIRST_NAME"),
//	                   @FieldResult(name="lastName", column="LAST_NAME")
//	              }         
//	        )
//	   }
//	)
@NamedNativeQuery(
		 name="ElencoQuestionariForScuolaEntity.elencoQuestionari", 
		 query = " select rownum ID, COD_SCU_UT, DENOM, QUESTIONARIO, COD_QUESTIONARIO, STATO, DAT_ULT_SAL, DAT_VLD_RIS, COD_FOR_SCU_APP from ("
				 +" SELECT DISTINCT A.COD_SCU_UT COD_SCU_UT, A.DES_NOM_SCU DENOM, A.COD_FOR_SCU_APP COD_FOR_SCU_APP, F.DES_QST QUESTIONARIO, F.COD_QST COD_QUESTIONARIO, G.DES_TIP_STA STATO,"
					+" TRUNC(E.DAT_ORA_ULT_MOV) DAT_ULT_SAL,"
					+" TRUNC(MAX(S.DAT_VLD_RIS)) DAT_VLD_RIS"
					+" FROM TWS1002_ANAGISTSCOL A, TOD1009_STATOQUESTSCUOLA E, TOD1002_ANAGRAFEQUESTIONARIO F, TOD1007_TIPOSTATO G , TOD1015_VALRISPOSTADOMANDASCU S"
					+" WHERE"
					     +" E.COD_FOR_SCU=S.COD_FOR_SCU(+)"
					     +" AND E.COD_QST=S.COD_QST(+)"
					     +" AND A.COD_SCU_UT_PRI = :codIstPri"
					     +" AND A.DAT_ANN_SCO_RIL = :annoScolastico"
					     +" AND (DAT_FIN_VAL IS NULL OR DAT_FIN_VAL > SYSDATE)"
					     +" AND E.COD_FOR_SCU = A.COD_FOR_SCU_APP"
					     +" AND E.PRG_IST_RIL = :prgIstRil"
					     +" AND F.COD_QST = E.COD_QST"
					     +" AND G.COD_TIP_STA = E.COD_TIP_STA "
					+" GROUP BY"
					    +" A.COD_SCU_UT,"
					    +" A.DES_NOM_SCU , A.COD_FOR_SCU_APP, "
					    +" F.DES_QST,"
					    +" F.COD_QST,"
					    +" G.DES_TIP_STA,"
					    +" TRUNC(E.DAT_ORA_ULT_MOV)"
					+" ORDER BY A.COD_SCU_UT, F.DES_QST )", resultClass = ElencoQuestionariForScuolaEntity.class)
public class ElencoQuestionariForScuolaEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID")
	private Long id;
	
	@Column(name="COD_SCU_UT")
	private String codScu;
	
	@Column(name="DENOM")
	private String denom;
	
	@Column(name="COD_QUESTIONARIO")
	private String codQuestionario;
	
	@Column(name="QUESTIONARIO")
	private String questionario;
	
	@Column(name="STATO")
	private String stato;

	@Column(name="DAT_ULT_SAL")
	private String datUltSal;
	
	@Column(name="DAT_VLD_RIS")
	private String dataUltVal;
	
	@Column(name="COD_FOR_SCU_APP")
	private String codForScu;
	
	
	public final String getCodForScu() {
		return codForScu;
	}

	public final void setCodForScu(String codForScu) {
		this.codForScu = codForScu;
	}

	public final String getCodScu() {
		return codScu;
	}

	public final void setCodScu(String codScu) {
		this.codScu = codScu;
	}

	public final String getDatUltSal() {
		return datUltSal;
	}

	public final void setDatUltSal(String datUltSal) {
		this.datUltSal = datUltSal;
	}

	public final String getDataUltVal() {
		return dataUltVal;
	}

	public final void setDataUltVal(String dataUltVal) {
		this.dataUltVal = dataUltVal;
	}

	public final Long getId() {
		return id;
	}

	public final void setId(Long id) {
		this.id = id;
	}

	public final String getDenom() {
		return denom;
	}

	public final void setDenom(String denom) {
		this.denom = denom;
	}

	public final String getCodQuestionario() {
		return codQuestionario;
	}

	public final void setCodQuestionario(String codQuestionario) {
		this.codQuestionario = codQuestionario;
	}

	public final String getQuestionario() {
		return questionario;
	}

	public final void setQuestionario(String questionario) {
		this.questionario = questionario;
	}

	public final String getStato() {
		return stato;
	}

	public final void setStato(String stato) {
		this.stato = stato;
	}


}
