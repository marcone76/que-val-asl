<%@ include file="../../includes/taglib.jsp"%>
<%@ include file="../../includes/breadcrumb.jsp"%>

<script type="text/javascript"
	src="<spring:url value="/static/js/gestioneRilevazione/dettaglioRilevazione.js" />"></script>
	<script type="text/javascript" src="<spring:url value="/static/js/utils/tendine.js"/>"></script>

<style>
select{
    width: 90%;
    text-overflow: ellipsis;
}
</style>

<div>

		<form:form id="elencoQuestionariDaEsportareForm" name="elencoQuestionariDaEsportare" action="elencoQuestionariDaEsportare" method="get" cssClass="no_ajax">
		<h3>ESPORTA ACQUISIZIONE</h3>
		<div>
			<div class="content-frame m-b-2">

				<c:if test="${not empty rilevazione}">
					<fieldset>
						<div class="row text-center">
							<div class="col-md-12">
								<h2 for="descrizione">${rilevazione.descrizione}</h2>
							</div>
						</div>
						<br />

						<div class="row">
							<div class="col-md-3">
								<label for="codiceMeccanografico">Codice meccanografico:</label>
							</div>
							<div class="col-md-3">
								<form:input path="codiceMeccanografico"
									id="codiceMeccanografico" />
							</div>

						</div>

						 <br>

						<div class="row">
						<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3" >
								<label>Regione</label>
							</div>
							<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
								<select name="regioneEs" id="regione">
							<option value="">TUTTE</option>
							<c:forEach items="${regioni}" var="regione">
								<option value="${regione.value}/${regione.label}">${regione.label}</option>
							</c:forEach>
						</select>
							</div>
						</div>
                        <br>
						<div class="row">
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3" >
								<label>Provincia</label>
							</div>
							<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
								<select id="provincia" name="provinciaEs">
									<option value="">TUTTE</option>
								</select>
							</div>
						</div>



						<br>
						<div class="row">
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3" >
								<label>Comune</label>
							</div>
							<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
								<select id="comune" name="comuneEs">
									<option value="">TUTTI</option>
								</select> <br>
							</div>
						</div>



						<br> <br> <br /> <br />

					</fieldset>

					<div class="row text-center">
						<div class="col-md-3">
						<button type="submit" class="btn btn-block submit-btn" aria-label="Cerca" tabindex="50">Cerca</button>
							<!-- <button
								onclick="javascript:location.href='/oss-scu-dig-web/#elencoQuestionariDaEsportare';"
								id="btn-cerca" type="button" class="btn btn-block submit-btn"
								aria-label="Cerca" tabindex="70">Cerca</button> -->
						</div>
					</div>
				</c:if>


				<c:if test="${empty rilevazione}">
					<div class="row text-center">
						<div class="col-md-12">
							<h2>ATTENZIONE : NESSUNA RILEVAZIONE APERTA</h2>
						</div>
					</div>
				</c:if>

			</div>
		</div>
	</form:form>
</div>
