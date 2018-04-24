<%@ include file="../../includes/taglib.jsp"%>
<%@ include file="../../includes/breadcrumb.jsp"%>
<%@ taglib uri="/WEB-INF/tld/displaytag.tld" prefix="display"%>

<script type="text/javascript"
	src="<spring:url value="/static/js/gestioneRilevazione/dettaglioRilevazione.js" />"></script>

<div>
	<h3>STATO AQUISIZIONE - ELENCO QUESTIONARI IN CORSO</h3>
	<div>
		<div class="content-frame m-b-2">

			<c:if test="${not empty rilevazione}">
				<fieldset>
					<div class="row text-center">
						<div class="col-md-12">
							<h2 for="descrizione">Rilevazione:
								${rilevazione.descrizione}</h2>
						</div>
					</div>
				
					<div class="col-md-12">
					    <label for="descrizione"> Ciclo Scolastico - ${cicloScolasticoR} </label>&nbsp
						<label for="descrizione"> Regione - ${regioneR} </label>&nbsp
						<label for="descrizione"> Provincia - ${provinciaR}  </label>&nbsp
						<label for="descrizione"> Comune - ${comuneR}  </label>
					</div>	

					<br /> <br />

					<div class="row">
						
							<h4 align="center">
								<label>ELENCO ${sessionScope.etichette['JPPERCORSI']}</label>
							</h4>
							<table class="display sortable" id="tabellaElencoQuestionarioIC">

								<thead>
									<tr>
										<th>Codice meccanografico</th>
										<th>Denominazione scuola</th>
										<th>Denominazione questionario</th>
										<th>Regione</th>
										<th>Provincia</th>
										<th>Comune</th>
										<th>Stato questionario</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${listaElencoQuestionarioInCorso}" var="dto">
										<tr>
											<td>${dto.codiceMeccanografico}</td>
											<td>${dto.denominazione}</td>
											<td>${dto.questionario}</td>
											<td>${dto.regione}</td>
											<td>${dto.provincia}</td>
											<td>${dto.comune}</td>
											<td>${dto.stato}</td>

										</tr>
									</c:forEach>
								</tbody>

							</table>

							<div id="tabellaElencoQuestionarioIC-per-download"
								style="display: none;">
								<table>
									<thead>
										<tr>
											<th>Codice meccanografico</th>
											<th>Denominazione scuola</th>
											<th>Denominazione questionario</th>
											<th>Regione</th>
											<th>Provincia</th>
											<th>Comune</th>
											<th>Stato questionario</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${listaElencoQuestionarioInCorso}" var="dto">
											<tr>
												<td>${dto.codiceMeccanografico}</td>
												<td>${dto.denominazione}</td>
												<td>${dto.questionario}</td>
												<td>${dto.regione}</td>
												<td>${dto.provincia}</td>
												<td>${dto.comune}</td>
												<td>${dto.stato}</td>

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
											data-ref="tabellaElencoQuestionarioIC-per-download"
											data-filename="ElencoAcquisizioneDomandeInCorso"
											data-title="Elenco Acquisizione Domande In Corso"
											data-rotate="true" data-filtro="Regione=${regioneR}|Provincia=${provinciaR}|Comune=${comuneR}">Esporta in PDF</button>
										&nbsp;
										<button class="export-excel"
											data-ref="tabellaElencoQuestionarioIC-per-download"
											data-filename="ElencoAcquisizioneDomandeInCorso"
											data-title="Elenco Acquisizione Domande In Corso" data-filtro="Regione=${regioneR}|Provincia=${provinciaR}|Comune=${comuneR}">Esporta
											in Excel</button> &nbsp;
										<button class="export-csv"
											data-ref="tabellaElencoQuestionarioIC-per-download"
											data-filename="ElencoAcquisizioneDomandeInCorso"
											data-title="Elenco Acquisizione Domande In Corso">
											Esporta in CSV</button> &nbsp;
										<button class="export-txt"
											data-ref="tabellaElencoQuestionarioIC-per-download"
											data-filename="ElencoAcquisizioneDomandeInCorso"
											data-title="Elenco Acquisizione Domande In Corso">
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

<c:if test="${empty listaElencoQuestionarioInCorso}">
				<div class="row text-center">
					<div class="col-md-12">
						<h2>ATTENZIONE : NESSUN QUESTIONARIO PRESENTE</h2>
					</div>
				</div>
			</c:if>

	

		</div>
	</div>
</div>
