<%@ include file="../../includes/taglib.jsp"%>
<%@ include file="../../includes/breadcrumb.jsp"%>

<script type="text/javascript" src="<spring:url value="/static/js/gestioneRilevazione/dettaglioRilevazione.js" />"></script>

<script>
$.xhrPool = [];

$.xhrPool.abortAll = function() {
  /* Original example used _underscore api
    _.each(this, function(jqXHR) {
        jqXHR.abort();
    });
  */
    $.each(this, function(jqXHR) { 
        jqXHR.abort(); 
    });
};

$.ajaxSetup({
	    beforeSend: function(jqXHR) {
	        $.xhrPool.push(jqXHR);
	    }
	});
</script>

<div>
	<h3>MONITORAGGIO - VISUALIZZA ACQUISIZIONE</h3>
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

			</fieldset>
			
			<div class="row text-center">
				<div class="col-md-3">
					<button onclick="javascript:location.href='/oss-scu-dig-web/#';" id="btn-cerca" type="button" class="btn btn-block submit-btn" aria-label="Cerca" tabindex="70">Cerca</button>
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
