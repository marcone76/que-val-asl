<%@ include file="../../includes/taglib.jsp"%>
<%@ include file="../../includes/breadcrumb.jsp"%>

<script type="text/javascript"
	src="<spring:url value="/static/js/gestioneRilevazione/dettaglioRilevazione.js" />"></script>
<script type="text/javascript"
	src="<spring:url value="/static/js/menuGestione/menuGestione.js" />"></script>


<h3>Gestione - Gestione Pubblicazione - Record Fuori Intervallo</h3>

<input type="hidden" id="codicedomanda" name="codicedomanda"
	value="${pubblicazionePercentualeRecord.codDmd}">
<input type="hidden" id="codiceQuestionario" name="codiceQuestionario"
	value="${pubblicazionePercentualeRecord.codQuest}" />
<input type="hidden" id="idRil" name="idRil"
	value="${pubblicazionePercentualeRecord.prgIstRil}" />

<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

	<div class="row" style="padding-top: 50px;">


		<div class="row">
			<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
				<label>Filtro Massimo:</label>
			</div>
			<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
				<input type="text" size="5" id="limiteMassimo" name="limiteMassimo"
					value="${pubblicazionePercentualeRecord.filtroMas}" />

			</div>

			<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
				<label>Filtro Minimo:</label>
			</div>
			<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
				<input type="text" size="5" id="limiteMinimo" name="limiteMinimo"
					value="${pubblicazionePercentualeRecord.filtroMin}" />
			</div>


			<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">

				<a class="link"><button class="btn btn-block submit-btn"
						id="applicaFiltriButton" style="width: 190px;"
						onclick="javascript:urlInserisciFiltro();">&ensp; APPLICA
						FILTRI</button></a>
			</div>
		</div>
		<br> <label>Percentuale Record Ignorati su totale :
			${pubblicazionePercentualeRecord.perDmd}</label> <br>
		<fieldset>

			<h4 align="center">
				<label>ELENCO RECORD ${sessionScope.etichette['JPPERCORSI']}</label>
			</h4>
			<table class="display sortable" id="tabellaRecordPubblicazione">
				<thead>
					<tr>
						<th>Scuola</th>
						<th>Cod Domanda</th>
						<th>Domanda</th>
						<th>Risposta</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pubblicazioneRecord}" var="dto">
						<tr>

							<td>${dto.codForScu}</td>
							<td>${dto.codIdeDmd}</td>
							<td>${dto.desDmd}</td>
							<td>${dto.desRis}</td>

						</tr>
					</c:forEach>
				</tbody>
			</table>

			<div id="tabellaRecordPubblicazione-per-download"
				style="display: none;">
				<table>
					<thead>
						<tr>
							<th>Scuola</th>
							<th>Cod Domanda</th>
							<th>Domanda</th>
							<th>Risposta</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pubblicazioneRecord}" var="dto">
							<tr>
								<td>${dto.codForScu}</td>
								<td>${dto.codIdeDmd}</td>
								<td>${dto.desDmd}</td>
								<td>${dto.desRis}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<br />
			<table style="width: 100%;">
				<tr>
					<td align="center">

						<button class="export-pdf"
							data-ref="tabellaRecordPubblicazione-per-download"
							data-filename="RecordPubblicazione"
							data-title="RecordPubblicazione" data-rotate="true"
							data-filtro="">Esporta in PDF</button> &nbsp;
						<button class="export-excel"
							data-ref="tabellaRecordPubblicazione-per-download"
							data-filename="RecordPubblicazione"
							data-title="RecordPubblicazione" data-filtro="">Esporta
							in Excel</button> &nbsp;
						<button class="export-csv"
							data-ref="tabellaRecordPubblicazione-per-download"
							data-filename="RecordPubblicazione"
							data-title="RecordPubblicazione">Esporta in CSV</button> &nbsp;
						<button class="export-txt"
							data-ref="tabellaRecordPubblicazione-per-download"
							data-filename="RecordPubblicazione"
							data-title="RecordPubblicazione">Esporta in TXT</button>
					</td>
				</tr>
			</table>


		</fieldset>



		<br>
		<div class="row">




			<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
				<button type="button" class="btn btn-block submit-btn"
					aria-label="Indietro" style="width: 120px;"
					onclick="window.location='#gestionePubblicazione'">Indietro</button>
			</div>


		</div>

	</div>
</div>



