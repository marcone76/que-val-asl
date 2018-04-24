<%@ include file="../../includes/taglib.jsp"%>
<%@ include file="../../includes/breadcrumb.jsp"%>
<script type="text/javascript"
	src="<spring:url value="/static/js/chart/Chart.bundle.js" />"></script>
<script type="text/javascript"
	src="<spring:url value="/static/js/chart/utils.js" />"></script>
<script type="text/javascript"
	src="<spring:url value="/static/js/utils/tendine.js"/>"></script>
	<script type="text/javascript"
	src="<spring:url value="/static/js/menuGestione/menuGestione.js" />"></script>
<style>
select {
	width: 90%;
	text-overflow: ellipsis;
}
</style>





<form id="gestioneCampioneForm" action="gestioneCampioneFiltri"
	method="post" class="no_ajax">

	<h3>Gestione Campione</h3>

	<br> <br>
	<c:if test="${not empty rilevazione}">
		<center>
			<label>Rilevazione: ${rilevazione.descrizione }</label>
		</center>

		<div class="row">
			<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">




				<div class="row" style="padding-top: 50px;">
					<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
						<label style="text-align: right;">Regione</label>
					</div>
					<div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
						<select name="regioneCamp.value" id="regioneCamp">
							<option value="ALL">TUTTE</option>
							<c:forEach items="${regioni}" var="regioneCamp">
								<option value="${regioneCamp.value}">${regioneCamp.label}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<br>

				<div class="row">
					<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
						<label>Tipologia Istituto</label>
					</div>
					<div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
						<select id="tipologiaIstituto" name="tipologiaIstituto.value">
							<option value="ALL">TUTTE</option>
							<c:forEach items="${tipologiaIstituto}" var="tipologiaIstituto">
								<option value="${tipologiaIstituto.value}">${tipologiaIstituto.label}</option>
							</c:forEach>
						</select>

					</div>
				</div>



				<br>
				<div class="row">
					<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
						<label>Ordine Scuola</label>
					</div>
					<div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">


						<input type="checkbox" name="ordine" id="infanzia" value="AA">&ensp;
						${ordineScuola1}<br>
						 <input type="checkbox" name="ordine"
							id="primaria" value="EE">&ensp; ${ordineScuola2}<br>
							
						<input type="checkbox" name="ordine"
							id="secondaria1" value="MM">&ensp; ${ordineScuola3}<br>
						 <input type="checkbox" name="ordine"
							id="secondaria2" value="SS">&ensp; ${ordineScuola4}<br>
							
						<input type="checkbox" name="ordine" id="comprensivo" value="IC">&ensp;
						${ordineScuola5}<br> 
						<input type="checkbox" name="ordine"
							id="territoriale" value="CT">&ensp; ${ordineScuola6}<br>
							
						<input type="checkbox" name="ordine" id="tutti" value="ALL">&ensp;
						${ordineScuola7}<br>
						 <br>
					</div>
				</div>
				
					<div class="row">
					<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
						<label>Adulti</label>
					</div>
					<div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
						<input type="checkbox" name="adulti" id="adulti" value="SI" >&ensp;
						${adulti}<br>
						 <br>
					</div>
				</div>
				
			</div>
			<br>
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<br> (La modifica del campione può avvenire solo a Rilevazione
				Approvata) <br> <br>
			</div>

			<br> <br>
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<center>
					<button type="submit"  id="campioneButton"
						class="btn btn-block submit-btn"
									style="width:120px;" data-toggle="modal" >Conferma</button>
									<br>
					<!-- 				<input type="submit" value="TEST"> -->
				</center>
			</div>
			
<!-- <!-- Modal -->
<!--   <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      Modal content
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Attenzione</h4>
        </div>
        <div class="modal-body">
          <p>Almeno un checkbox obbligatorio</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div> -->
  




		</div>
</form>
</c:if>
<c:if test="${empty rilevazione}">
	<div class="row text-center">
		<div class="col-md-12">
			<h2>ATTENZIONE : NESSUNA RILEVAZIONE APPROVATA</h2>
		</div>
	</div>
</c:if>



