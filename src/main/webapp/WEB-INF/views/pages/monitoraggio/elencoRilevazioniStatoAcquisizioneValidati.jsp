<%@ include file="../../includes/taglib.jsp"%>
<%@ include file="../../includes/breadcrumb.jsp"%>
<%@ taglib uri="/WEB-INF/tld/displaytag.tld" prefix="display"%>

<script type="text/javascript"
	src="<spring:url value="/static/js/gestioneRilevazione/dettaglioRilevazione.js" />"></script>

<div>
	<h3>STATO AQUISIZIONE - ELENCO QUESTIONARI VALIDATI</h3>
	<div>
		<div class="content-frame m-b-2">

			<c:if test="${not empty rilevazione}">
				<fieldset>
					<div class="row text-center">
						<div class="col-md-12">
							<h2 for="descrizione">Rilevazione: ${rilevazione.descrizione}</h2>
						</div>
					</div>

					<div class="col-md-12">
					 <label for="descrizione"> Ciclo Scolastico - ${cicloScolasticoR} </label>&nbsp
						<label for="descrizione"> Regione - ${regioneR} </label>&nbsp <label
							for="descrizione"> Provincia - ${provinciaR} </label>&nbsp <label
							for="descrizione"> Comune - ${comuneR} </label>
					</div>
					<br /> <br />

					<div class="row">

						<h4 align="center">
							<label>ELENCO RILEVAZIONI VALIDATE ${sessionScope.etichette['JPPERCORSI']}</label>
						</h4>
						<table class="display sortable" id="tabellaElencoQuestionarioV">

							<thead>
								<tr>
									<th>Codice meccanografico</th>
									<th>Denominazione scuola</th>
									<th>Denominazione</th>
									<th>Regione</th>
									<th>Provincia</th>
									<th>Comune</th>
									<th>Stato Rilevazione Validata</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${listaElencoQuestionarioValidati}" var="dto">
									<tr>
										<td>${dto.codiceMeccanografico}</td>
										<td>${dto.denominazione}</td>
										<td>${dto.istituto}</td>
										<td>${dto.regione}</td>
										<td>${dto.provincia}</td>
										<td>${dto.comune}</td>
										<td>VALIDATO</td>

									</tr>
								</c:forEach>
							</tbody>

						</table>

						<div id="tabellaElencoQuestionarioV-per-download"
							style="display: none;">
							<table>
								<thead>
									<tr>
										<th>Codice meccanografico</th>
										<th>Denominazione scuola</th>
										<th>Denominazione</th>
										<th>Regione</th>
										<th>Provincia</th>
										<th>Comune</th>
										<th>Stato Rilevazione Validata</th>

									</tr>
								</thead>
								<tbody>
									<c:forEach items="${listaElencoQuestionarioValidati}" var="dto">
										<tr>
											<td>${dto.codiceMeccanografico}</td>
											<td>${dto.denominazione}</td>
											<td>${dto.istituto}</td>
											<td>${dto.regione}</td>
											<td>${dto.provincia}</td>
											<td>${dto.comune}</td>
											<td>VALIDATO</td>

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
										data-ref="tabellaElencoQuestionarioV-per-download"
										data-filename="ElencoAcquisizioneDomandeValidati"
										data-title="Elenco Acquisizione Domande Validati"
										data-rotate="true" data-filtro="Regione=${regioneR}|Provincia=${provinciaR}|Comune=${comuneR}">Esporta in PDF</button>
									&nbsp;
									<button class="export-excel"
										data-ref="tabellaElencoQuestionarioV-per-download"
										data-filename="ElencoAcquisizioneDomandeValidati"
										data-title="Elenco Acquisizione Domande Validati" data-filtro="Regione=${regioneR}|Provincia=${provinciaR}|Comune=${comuneR}">Esporta
										in Excel</button> &nbsp;
									<button class="export-csv"
										data-ref="tabellaElencoQuestionarioV-per-download"
										data-filename="ElencoAcquisizioneDomandeValidati"
										data-title="Elenco Acquisizione Domande Validati">
										Esporta in CSV</button> &nbsp;
									<button class="export-txt"
										data-ref="tabellaElencoQuestionarioV-per-download"
										data-filename="ElencoAcquisizioneDomandeValidati"
										data-title="Elenco Acquisizione Domande Validati">
										Esporta in TXT</button>

								</td>
							</tr>
						</table>
						<div class="col-md-2">
							<a class="btn btn-block submit-btn"
								onclick="window.location='#statoAcquisizione'">Indietro</a>
						</div>
				</fieldset>
			</c:if>

			<c:if test="${empty listaElencoQuestionarioValidati}">
				<div class="row text-center">
					<div class="col-md-12">
						<h2>ATTENZIONE : NESSUN QUESTIONARIO VALIDATO PRESENTE</h2>
					</div>
				</div>
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
