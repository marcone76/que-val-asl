<%@ include file="../../includes/taglib.jsp"%>
<%@ include file="../../includes/breadcrumb.jsp"%>
<%@ taglib uri="/WEB-INF/tld/displaytag.tld" prefix="display"%>

<script type="text/javascript"
	src="<spring:url value="/static/js/gestioneRilevazione/dettaglioRilevazione.js" />"></script>

<div>
	<h3>DETTAGLIO ESPORTA RILEVAZIONE IN CORSO</h3>
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
					<br /> <br />
					<div class="row">

						<c:if test="${not empty listaDomandaInCorso}">
							<h4 align="center">
								<label>ELENCO RISPOSTE IN CORSO
									${sessionScope.etichette['JPDOMANDEINCORSO']}</label>
							</h4>
							<table class="display sortable" id="tabellaDomandeInCorso">
								<thead>
									<tr>
										<th>Sezione</th>
										<th>Codice domanda</th>
										<th>Descrizione Domanda</th>
										<th>Descrizione Risposta</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${listaDomandaInCorso}" var="dto">
										<tr>
											<td>${dto.descrizioneSezione}</td>
											<td>${dto.codiceDomanda}</td>
											<td>${dto.descrizioneDomanda}</td>
											<td>${dto.descrizioneRisposta}</td>
										</tr>
									</c:forEach>
								</tbody>

							</table>

							<div id="tabellaDomandeInCorso-per-download"
								style="display: none;">
								<table>
									<thead>
										<tr>
											<th>Sezione</th>
											<th>Codice domanda</th>
											<th>Descrizione Domanda</th>
											<th>Descrizione Risposta</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${listaDomandaInCorso}" var="dto">
											<tr>
												<td>${dto.descrizioneSezione}</td>
												<td>${dto.codiceDomanda}</td>
												<td>${dto.descrizioneDomanda}</td>
												<td>${dto.descrizioneRisposta}</td>
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
											data-ref="tabellaDomandeInCorso-per-download"
											data-filename="RilevazioneDomandeInCorso"
											data-title="RilevazioneDomandeInCorso" data-rotate="true"
											data-filtro="">Esporta in PDF</button> &nbsp;
										<button class="export-excel"
											data-ref="tabellaDomandeInCorso-per-download"
											data-filename="RilevazioneDomandeInCorso"
											data-title="RilevazioneDomandeInCorso" data-filtro="">Esporta
											in Excel</button> &nbsp;
										<button class="export-csv"
											data-ref="tabellaDomandeInCorso-per-download"
											data-filename="RilevazioneDomandeInCorso"
											data-title="RilevazioneDomandeInCorso">Esporta in
											CSV</button> &nbsp;
										<button class="export-txt"
											data-ref="tabellaDomandeInCorso-per-download"
											data-filename="RilevazioneDomandeInCorso"
											data-title="RilevazioneDomandeInCorso">Esporta in
											TXT</button>
									</td>
								</tr>
							</table>
							<div class="col-md-2">
								<a class="btn btn-block submit-btn" onclick="window.location='#esportaRilevazione'">Indietro</a>
							</div>
						</c:if>

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
