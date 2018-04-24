<%@ include file="../../includes/taglib.jsp"%>
<%@ include file="../../includes/breadcrumb.jsp"%>

<script type="text/javascript"
	src="<spring:url value="/static/js/gestioneRilevazione/dettaglioRilevazione.js" />"></script>

<div>
	<h3>GESTIONE DOMANDE</h3>
	<div>
		<div class="content-frame m-b-2">

			<c:if test="${not empty rilevazioni}">
				<fieldset>
					<div class="row text-center">
						<div class="col-md-12">
							<h2 for="descrizione">Gestione rilevazioni</h2>
						</div>
					</div>
					<br /> <br />

					<h4 align="center">
						<label>ELENCO RILEVAZIONI</label>
					</h4>
					<table class="display noPaging" id="tabellaGestioneRilevazioni">

						<thead>
							<tr>
								<th>Rilevazione</th>
								<th>Stato</th>
								<th>Data Apertura</th>
								<th>Data Chiusura</th>
								<th>Vai a Chiudi/Sospendi</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${rilevazioni}" var="dto">
								<tr>
									<td>${dto.descrizione}</td>
									<td class="last-td">${dto.stato} </td>
									<td>${dto.dataInizio}</td>
									<td>${dto.dataFine}</td>
									<td><a
										href="/oss-scu-dig-web/#dettaglioRilevazione?breadcrumbTitle=DettaglioRilevazione&subItem=y&id=${dto.id}"
										class="icon miur-vai" title="Visualizza"></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>


				</fieldset>
			</c:if>
			
<c:if test="${empty rilevazioni}">
	<div class="row text-center">
		<div class="col-md-12">
			<h2>ATTENZIONE : NESSUNA RILEVAZIONE  APERTA / SOSPESA / APPROVATA </h2>
		</div>
	</div>
</c:if>

		</div>
	</div>
</div>
