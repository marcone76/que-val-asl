<%@ include file="../../includes/taglib.jsp"%>
<%@ include file="../../includes/breadcrumb.jsp"%>
<%@ taglib uri="/WEB-INF/tld/displaytag.tld" prefix="display"%>

<script type="text/javascript"
	src="<spring:url value="/static/js/gestioneRilevazione/dettaglioRilevazione.js" />"></script>

<div>
	<h3>DETTAGLIO ESPORTA RILEVAZIONE VALIDATA</h3>
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

						<c:if test="${not empty listaDomandaValidato}">
							<h4 align="center">
								<label>ELENCO RISPOSTE VALIDATE
									${sessionScope.etichette['JPDOMANDEVALIDATE']}</label>
							</h4>
							<table class="display sortable" id="tabellaDomandeValidate">
								<thead>
									<tr>
										<th>Sezione</th>
										<th>Codice domanda</th>
										<th>Descrizione Domanda</th>
										<th>Descrizione Risposta</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${listaDomandaValidato}" var="dto">
										<tr>
											<td>${dto.descrizioneSezione}</td>
											<td>${dto.codiceDomanda}</td>
											<td>${dto.descrizioneDomanda}</td>
											<td>${dto.descrizioneRisposta}</td>
										</tr>
									</c:forEach>
								</tbody>

							</table>

							<div id="tabellaDomandeValidate-per-download"
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
										<c:forEach items="${listaDomandaValidato}" var="dto">
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
											data-ref="tabellaDomandeValidate-per-download"
											data-filename="RilevazioneDomandeValidate"
											data-title="RilevazioneDomandeValidate" data-rotate="true"
											data-filtro="">Esporta in PDF</button> &nbsp;
										<button class="export-excel"
											data-ref="tabellaDomandeValidate-per-download"
											data-filename="RilevazioneDomandeValidate"
											data-title="RilevazioneDomandeValidate" data-filtro="">Esporta
											in Excel</button> &nbsp;
										<button class="export-csv"
											data-ref="tabellaDomandeValidate-per-download"
											data-filename="RilevazioneDomandeValidate"
											data-title="RilevazioneDomandeValidate">Esporta in
											CSV</button> &nbsp;
										<button class="export-txt"
											data-ref="tabellaDomandeValidate-per-download"
											data-filename="RilevazioneDomandeValidate"
											data-title="RilevazioneDomandeValidate">Esporta in
											TXT</button>

									</td>
								</tr>
							</table>
							<div class="col-md-2">
								<a class="btn btn-block submit-btn" onclick="window.location='#esportaRilevazione'">Indietro</a>
							</div>
						</c:if>

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
