<%@ include file="../../includes/taglib.jsp"%>
<%@ include file="../../includes/breadcrumb.jsp"%>

<script type="text/javascript" src="<spring:url value="/static/js/gestioneRilevazione/dettaglioRilevazione.js" />"></script>

<div>
	<h3>VISUALIZZA RILEVAZIONE</h3>
	<div>
		<div class="content-frame m-b-2">
		
		<c:if test="${not empty rilevazione}">
			<fieldset>
				<div class="row text-center">
					<div class="col-md-12">
						<h2 for="descrizione"> Rilevazione: ${rilevazione.descrizione}</h2>
					</div>										
				</div>
				<br/>
				<br/>
				
				<div class="row">
					<table class="display">
						<thead>
					  	  	 <tr>
							  <th>Scuola</th>
							  <th>Qestionario</th>
							  <th>Data in Corso</th>
							  <th></th>
							  <th>Data Validazione</th>
							  <th></th>
							</tr>
						</thead>
						<tbody>
				
						<c:forEach items="${questionari}" var="dto">
						<tr>
						  <td class="text-left-important">${dto.scuola.codiceMeccanografico} - ${dto.scuola.denominazione}</td>
						  <td>${dto.nome}</td>
						  <td>${dto.dataUltimaModificaQuestionarioInCorso}</td>
						  <td class="last-td">
							  <c:if test="${not empty dto.dataUltimaModificaQuestionarioInCorso}">
					  			<a href="/oss-scu-dig-web/#visualizzaQuestionario?breadcrumbTitle=Questionario&subItem=y&codForScu=${dto.scuola.codiceForte}&idQst=${dto.codiceQuestionario}&sezioneValidata=0"  class="icon miur-vai" title="Visualizza"></a>
					  		  </c:if>
				  		  </td>
				  		  <td>${dto.dataUltimaModificaQuestionarioValidato}</td>
				  		  <td class="last-td">
				  			<c:if test="${not empty dto.dataUltimaModificaQuestionarioValidato}">
				  				<a href="/oss-scu-dig-web/#visualizzaQuestionario?breadcrumbTitle=Questionario&subItem=y&codForScu=${dto.scuola.codiceForte}&idQst=${dto.codiceQuestionario}&sezioneValidata=1"  class="icon miur-vai" title="Visualizza"></a>
				  		  	</c:if>
				  		  </td>	
						</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
				
				<br/>
				<br/>
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
