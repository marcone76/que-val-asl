<%@ include file="../../includes/taglib.jsp"%>
<%@ include file="../../includes/breadcrumb.jsp"%>

<script type="text/javascript" src="<spring:url value="/static/js/gestioneRilevazione/dettaglioRilevazione.js" />"></script>

<div>
	<h3>${rilevazione.descrizione}</h3>
	<div>
		<div class="content-frame m-b-2">
		
		<c:if test="${not empty rilevazione}">
			<fieldset>
			
				<div class="block-info">
	            	<h3>Scuola e questionario selezionati </h3>
	            	<table class="table table-one-col table-bordered">
	            		<tbody>
	            			<tr class="odd-light">
							  <td>Codice Meccanografico: <b class="ng-binding">${scuola.codiceMeccanografico}</b></td>
							</tr>
							<tr>
							  <td>Tipologia scuola: <b class="ng-binding">${scuola.tipoIstituto}</b></td>
							</tr>
							<tr class="odd-light">
							  <td>Denominazione: <b class="ng-binding">${scuola.denominazione}</b></td>
							</tr>
							<tr>
							  <td>Comune: <b class="ng-binding">${scuola.comune}</b></td>
							</tr>
							<tr>
							  <td>Questionario: <b class="ng-binding">${questionario.nome}</b></td>
							</tr>
	            		</tbody>
	            	</table>
				</div>

				<div class="content">
					  <c:forEach items="${sezioni}" var="sezione">
						  <div class="panel panel-default">
							    <div class="panel-heading">
							      <h3 class="panel-title">
							        <a href="#schede?breadcrumbTitle=Scheda&subItem=y&scheda=${sezione.idSezione}&codQuest=${questionario.codiceQuestionario}&codForteScu=${scuola.codiceForte}&codEdi=">${sezione.descrizioneSezione}</a>
							        <label style="float: right;">${sezione.stato.descrizione}</label>
							      </h3>
							    </div>
						  </div>
					  </c:forEach>

					  
					  
				  
				</div> 
				
				</div> <!-- class="content" -->				
				
				<br/>
				<br/>
			</fieldset>
			
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
