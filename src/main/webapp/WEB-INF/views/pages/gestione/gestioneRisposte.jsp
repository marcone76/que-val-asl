<%@ include file="../../includes/taglib.jsp"%>
<%@ include file="../../includes/breadcrumb.jsp"%>

<script type="text/javascript"
	src="<spring:url value="/static/js/gestioneRilevazione/dettaglioRilevazione.js" />"></script>
<script>
function resizeInput() {
    $(this).attr('size', $(this).val().length);
}

$('input[type="text"]')
    // event handler
    .keyup(resizeInput)
    // resize on page load
    .each(resizeInput);
</script>

<h3>Gestione - Gestione Domande - Modifica Valori risposte</h3>
<div class="content-frame m-b-2">
<form id="salvaRisposteForm" name="salvaRisposteForm" action="salvaRisposte" method="post">

	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

		<div class="row" style="padding-top: 50px;">

			<div class="row">
				<div class="col-md-6 col-lg-6">
					<h5>${sezione.descrizioneQuestionario}</h5>
				</div>
				<div class="col-md-6 col-lg-6" name="${idSezione}">
					<h5>${sezione.descrizioneSezione}</h5>
				</div>
			</div>

			<br>
			<fieldset>

				<h4 align="center">
					<label>ELENCO VOCI ASSEGNATE ALLE DOMANDE</label>
				</h4>
				<%-- <table class="display noPaging" id="table"> 

					<thead>
						<tr>
							<th>Cod</th>
							<th>Domanda</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
							<!-- for sulle domande -->
								<tr>
									<td>${idDmd}</td>
									<td><label>${descrizione}</label></td>
								</tr>

					</tbody>


				</table> --%>
                  

			</fieldset>
			<div class="row">
                  <label>Domanda</label>
</div>
                  <div class="row">
                                    <label>${descrizione}</label>
                  
</div>


				<br />
                  <div class="row">
				<div class="col-lg-7 col-md-7 col-sm-7 col-xs-7">
					<label>Gruppo voce</label> <br>
				</div>
				</div>
				                  <div class="row">
				
				<div class="col-lg-7 col-md-7 col-sm-7 col-xs-7">
					<label>${gruppoVoce}</label>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-lg-7 col-md-7 col-sm-7 col-xs-7">
					<label>Valore</label> <br>
				</div>
				<!-- <div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
					<label>Ordine</label>
				</div> -->
			</div>
			<div class="row">
			
				<c:forEach items="${voci}" var="voce">																		
				<div class="col-lg-7 col-md-7 col-sm-7 col-xs-7">
					<input type="text"  name="${voce.id}" value="${voce.descrizione}" >
<br>
				</div>
				<%-- <div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
					<select name="ordine" id="ordine">
						<c:forEach items="${ordine}" var="ordineRisp">
						<option value="${ordineRisp}">${ordineRisp}</option>
											</c:forEach>
						
					</select>
					<br>
				</div> --%>
				<br>
				</c:forEach>												
				
				<br>
			</div>
			
			<br>
			<div class="row">

	
				

				<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
					<button type="submit" class="btn btn-block submit-btn" aria-label="Salva" tabindex="50" onclick="if(!window.confirm('I dati immessi salveranno tutte le occorrenze. Procedere?')) return false" >Salva</button>

				</div>
					</form>
				
<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
					<button  class="btn btn-block submit-btn" href="javascript:history.back()" onclick="if(!window.confirm('I dati immessi e non salvati andranno persi. Procedere?')) return false" >Indietro</button>

				</div>
				<br>

			</div>
		</div>
	</div>
	
</div>
