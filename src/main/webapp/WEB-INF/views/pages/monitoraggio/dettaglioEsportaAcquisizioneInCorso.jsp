<%@ include file="../../includes/taglib.jsp"%>
<%@ include file="../../includes/breadcrumb.jsp"%>
<%@ taglib uri="/WEB-INF/tld/displaytag.tld" prefix="display"%>

<script type="text/javascript"
	src="<spring:url value="/static/js/gestioneRilevazione/dettaglioRilevazione.js" />">
	
</script>
<script type="text/javascript">
	$(document).ready(function() {

		$(function() {
			$('#scaricaPdfView').click(function() {
				$('#scaricaAcquisizioneDomandeInCorsoPdf').submit();
			});
		});

		$(function() {
			$('#scaricaXlsView').click(function() {
				$('#scaricaAcquisizioneDomandeInCorsoXls').submit();
			});
		});

		$(function() {
			$('#scaricaTxtView').click(function() {
				$('#scaricaAcquisizioneDomandeInCorsoTxt').submit();
			});
		});

		$(function() {
			$('#scaricaCvsView').click(function() {
				$('#scaricaAcquisizioneDomandeInCorsoCsv').submit();
			});
		});

	});
</script>

<div>
	<h3>DETTAGLIO ESPORTA ACQUISIZIONE IN CORSO</h3>
	<div>
		<div class="content-frame m-b-2">

			<c:if test="${not empty rilevazione}">
				<fieldset>
					<div class="row text-center">
						<div class="col-md-12">
							<h2 for="descrizione">Rilevazione:	${rilevazione.descrizione}</h2>
						</div>
					</div>
					<br /> <br />
					<div class="col-md-12">
						<c:set var="regioneParts" value="${fn:split(regioneR, '/')}" />
						<c:set var="provinciaParts" value="${fn:split(provinciaR, '/')}" />
						<c:set var="comuneParts" value="${fn:split(comuneR, '/')}" />

						<label for="regione"> Regione - ${regioneParts[1]} </label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
						<label for="provincia"> Provincia - ${provinciaParts[1]} </label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
						<label for="comune"> Comune - ${comuneParts[1]} </label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
						<label for="codiceMeccanografico"> Codice Meccanografico -
							${codMec} </label>
					</div>
					<div class="row">
						<%--  <c:if test="${not empty listaDomandaInCorso}">--%>
							<h4 align="center">
								<label>ELENCO SCUOLE CON QUESTIONARI IN CORSO
									${sessionScope.etichette['JPDOMANDEINCORSO']}</label>
							</h4>

							<table class="display dataTables_info;" id="tabellaDomandeInCorso" data-serverside="tabellaEsportaAcquisizioneInCorso.json?codMec=${codMec}&regioneEs=${regioneR}
								&provinciaEs=${provinciaR}&comuneEs=${comuneR}&codQst=${codQst}">
								<thead>
									<tr>
										<th>Codice Scuola</th>
										<th>Codice Edificio/Plesso</th>
										<th>Descrizione Questionario</th>
										<th>Descrizione Sezione</th>
										<th>Codice Domanda</th>
										<th>Descrizione Domanda</th>
										<th>Descrizione Risposta</th>
									</tr>
								</thead>
								<tbody>
									<%-- ORA ATTRAVERSO LA PAGINAZIONE LATO SERVER
									<c:forEach items="${listaDomandaInCorso}" var="dto">
										<tr>
											<td>${dto.codiceScuola}</td>
											<td>${dto.codiceEdificio}</td>
											<td>${dto.descrizioneQuestionario}</td>
											<td>${dto.descrizioneSezione}</td>
											<td>${dto.codiceDomanda}</td>
											<td>${dto.descrizioneDomanda}</td>
											<td>${dto.descrizioneRisposta}</td>
										</tr>
									</c:forEach> --%>
								</tbody>
							</table>
							<br />
							
							<table style="width: 100%;">
								<tr>
									<td align="center">
										<input type="button" id="scaricaPdfView" value="Esporta in PDF" title="Esporta pdf"/>
										<input type="button" id="scaricaXlsView" value="Esporta in EXCEL" title="Esporta xls"/> 
										<input type="button" id="scaricaTxtView" value="Esporta in TXT" title="Esporta txt"/>
										<input type="button" id="scaricaCvsView" value="Esporta in CSV" title="Esporta csv">
									</td>
								</tr>
							</table>
							<div class="col-md-2">

								<button onclick="javascript:location.href='/oss-scu-dig-web/#elencoQuestionariDaEsportare?codiceMeccanografico=${codMec}&regioneEs=${regioneR}&provinciaEs=${provinciaR}&comuneEs=${comuneR}';"
									id="btn-cerca" type="button" class="btn btn-block submit-btn" aria-label="Cerca" tabindex="70">Indietro</button>
							</div>
						<%-- </c:if> --%>
					</div>

					<br /> <br />
				</fieldset>
			</c:if>

			<c:if test="${empty rilevazione}">
				<div class="row text-center">
					<div class="col-md-12">
						<h2>ATTENZIONE : NESSUNA RILEVAZIONE PRESENTE</h2>
					</div>
				</div>
			</c:if>

		</div>
	</div>
</div>

<form id="scaricaAcquisizioneDomandeInCorsoXls" class="default no_ajax" style="display: none" action="scaricaAcquisizioneDomandeInCorso.html">
	<input type="hidden" name="formato" value="xls" />
	<input type="hidden" id="fileNamePdf" name="filename" value="stampaXlsDettaglioExpAcqInCorso" /> 
	<input type="hidden" name="title" value="Acquisizione Domande In Corso" />
	<input type="hidden" name="rotate" value="false" /> 
	<input type="hidden" name="Regione" value="${regioneR}" />
	<input type="hidden" name="Provincia" value="${provinciaR}" />
	<input type="hidden" name="Comune" value="${comuneR}" /> 
	<input type="hidden" name="codQst" value="${codQst}" /> 
	<input type="hidden" name="filtro" value="Regione=${regioneParts[1]}|Provincia=${provinciaParts[1]}|Comune=${comuneParts[1]}" />
</form>

<form id="scaricaAcquisizioneDomandeInCorsoPdf" class="default no_ajax" style="display: none" action="scaricaAcquisizioneDomandeInCorso.html">
	<input type="hidden" name="formato" value="pdf" /> 
	<input type="hidden" id="fileNamePdf" name="filename" value="stampaPdfDettaglioExpAcqInCorso" /> 
	<input type="hidden" name="title" value="Acquisizione Domande In Corso" /> 
	<input type="hidden" name="rotate" value="false" /> 
	<input type="hidden" name="Regione" value="${regioneR}" /> 
	<input type="hidden" name="Provincia" value="${provinciaR}" /> 
	<input type="hidden" name="Comune" value="${comuneR}" /> 
	<input type="hidden" name="codQst" value="${codQst}" /> 
	<input type="hidden" name="filtro" value="Regione=${regioneParts[1]}|Provincia=${provinciaParts[1]}|Comune=${comuneParts[1]}" />
</form>

<form id="scaricaAcquisizioneDomandeInCorsoTxt" class="default no_ajax" style="display: none" action="scaricaAcquisizioneDomandeInCorso.html">
	<input type="hidden" name="formato" value="txt" /> 
	<input type="hidden" id="fileNamePdf" name="filename" value="stampaTxtPdfDettaglioExpAcqInCorso" /> 
	<input type="hidden" name="title" value="Acquisizione Domande In Corso" /> 
	<input type="hidden" name="rotate" value="false" /> 
	<input type="hidden" name="Regione" value="${regioneR}" /> 
	<input type="hidden" name="Provincia" value="${provinciaR}" /> 
	<input type="hidden" name="Comune" value="${comuneR}" /> 
	<input type="hidden" name="codQst" value="${codQst}" /> 
	<input type="hidden" name="filtro" value="Regione=${regioneParts[1]}|Provincia=${provinciaParts[1]}|Comune=${comuneParts[1]}" />
</form>

<form id="scaricaAcquisizioneDomandeInCorsoCsv" class="default no_ajax" style="display: none" action="scaricaAcquisizioneDomandeInCorso.html">
	<input type="hidden" name="formato" value="csv" /> 
	<input type="hidden" id="fileNamePdf" name="filename" value="stampaTxtPdfDettaglioExpAcqInCorso" /> 
	<input type="hidden" name="title" value="Acquisizione Domande In Corso" /> 
	<input type="hidden" name="rotate" value="false" /> 
	<input type="hidden" name="Regione" value="${regioneR}" /> 
	<input type="hidden" name="Provincia" value="${provinciaR}" /> 
	<input type="hidden" name="Comune" value="${comuneR}" /> 
	<input type="hidden" name="codQst" value="${codQst}" /> 
	<input type="hidden" name="filtro" value="Regione=${regioneParts[1]}|Provincia=${provinciaParts[1]}|Comune=${comuneParts[1]}" />
</form>