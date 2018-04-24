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
						<h2 for="descrizione">${rilevazione.descrizione} - Questionari</h2>
					</div>										
				</div>
				<br/>
				<br/>
				
				<div class="row">
					<table class="tablesaw">
						<thead>
					  	  	 <tr>
							  <th>Scuola</th>
							  <th>Questionario</th>
							  <th>Stato</th>
							  <th></th>
							</tr>
						</thead>
						<tbody>
				
						<c:forEach items="${questionari}" var="dto">
						<tr>
						  <td class="text-left-important">${dto.scuola.codiceMeccanografico} - ${dto.scuola.denominazione}</td>
						  <td>${dto.nome}</td>
						  <td>${dto.stato.descrizione}</td>
						  <td class="last-td">
				  			<a href="/oss-scu-dig-web/#questionario?breadcrumbTitle=Questionario&subItem=y&codForScu=${dto.scuola.codiceForte}&idQst=${dto.codiceQuestionario}"  class="icon miur-vai" title="Vai alla compilazione"></a>
				  		  </td>	
						</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
				
				<br/>
				<br/>
			</fieldset>
			
			<div class="row text-center">
				<div class="col-md-3">
				<form:form id="questionari" name="questionari" action="validaRilevazione.json" method="post">
				<!--	<button onclick="javascript:location.href='/oss-scu-dig-web/#validaRilevazione.json';" id="btn-valida" type="button" class="btn btn-block submit-btn" aria-label="Valida" tabindex="70">Valida</button> -->
					<button type="submit" class="btn btn-block submit-btn" aria-label="Valida" tabindex="50">Valida</button>
				</form:form>			
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
</div>
