<%@ include file="../../includes/taglib.jsp"%>
<%@ include file="../../includes/breadcrumb.jsp"%>

<script type="text/javascript" src="<spring:url value="/static/js/gestioneRilevazione/dettaglioRilevazione.js" />"></script>

<div>
	<h3>ACQUISIZIONE RILEVAZIONE</h3>
	<div>
		<div class="content-frame m-b-2">
		
		<c:if test="${not empty rilevazione}">
			<fieldset>
				<div class="row text-center">
					<div class="col-md-12">
						<h2 for="descrizione">${rilevazione.descrizione}</h2>
					</div>										
				</div>
				<br/>			
				<div class="row">
					<div class="col-md-3">
						<label for="dataInizio">Data di apertura:</label>
					</div>
					<div class="col-md-3">
						<label for="dataInizio">${rilevazione.dataInizio}</label>
					</div>			
					<c:if test="${not empty rilevazione.dataFine}">
					<div class="col-md-3">
						<label for="dataInizio">Data di chiusura:</label>
					</div>
					<div class="col-md-3">
						<label for="dataInizio">${rilevazione.dataFine}</label>
					</div>
					</c:if>					
				</div>
				<br/>
				<div class="row">
					<div class="col-md-12">
						<label for="descrizione"> Stato rilevazione - ${rilevazione.descrizioneStato}</label>
					</div>										
				</div>
				<br/>
				<br/>
				
				<div class="row text-center">
					<div class="col-md-12">
						<h2> Scuole abilitate alla rilevazione </h2>
					</div>			
				</div>
				
				<div class="row">
					<table class="tablesaw">
						<thead>
					  	  	 <tr>
							  <th>Scuola</th>
							  <th>Tipo</th>
							  <th>Oggetto rilevazione</th>
							</tr>
						</thead>
						<tbody>
						
						<c:forEach items="${scuole}" var="scuolaDTO">
						<tr>
						  <td class="text-left-important">${scuolaDTO.codiceMeccanografico} - ${scuolaDTO.denominazione}</td>
						  <td>${scuolaDTO.tipoScuola}</td>
						  <td class="last-td">
						  	<%-- <c:if test="${scuolaDTO.oggettoRilevazione}">SI</c:if>
						  	<c:if test="${not scuolaDTO.oggettoRilevazione}">NO</c:if> --%>SI
						  </td>
						</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
				
				<br/>
				<br/>
			</fieldset>
			
			
			<c:if test="${not empty scuole}">
			
				<div class="row text-center">
					<div class="col-md-3">
						<button onclick="javascript:location.href='/oss-scu-dig-web/#questionari?breadcrumbTitle=Questionari&subItem=y';" id="btn-procedi" type="button" class="btn btn-block submit-btn" aria-label="Procedi" tabindex="70">Procedi</button>
					</div>										
				</div>
			
			</c:if>
			
		</c:if>
		
		<c:if test="${empty rilevazione}">
			<div class="row text-center">
				<div class="col-md-12">
					<h2>Attenzione : Nessuna Rilevazione Aperta</h2>
				</div>										
			</div>			
		</c:if>
				
		</div>
	</div>
</div>
