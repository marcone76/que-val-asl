<%@ include file="../../includes/taglib.jsp"%>
<%@ include file="../../includes/breadcrumb.jsp"%>
<script type="text/javascript" src="<spring:url value="/static/js/chart/Chart.bundle.js"/>"></script>
<script type="text/javascript" src="<spring:url value="/static/js/chart/utils.js"/>"></script>
<script type="text/javascript" src="<spring:url value="/static/js/andamentoAcquisizione/andamentoAcquisizione.js" />"></script>
<script type="text/javascript" src="<spring:url value="/static/js/utils/tendine.js"/>"></script>


<style>
select {
	width: 80%;
	text-overflow: ellipsis;
}
</style>



<h3>Monitoraggio - Andamento Acquisizione</h3>
<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

	<div class="row" style="padding-top: 50px;">
		<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1">
			<label style="text-align: right;">Ciclo Scolastico</label>
		</div>
		<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
			<select name="cicliScolastici" id="cicliScolastici">
				<option value="">TUTTI</option>
				<c:forEach items="${cicliScolastici}" var="cicliScolastici">
					<option value="${cicliScolastici.value}">${cicliScolastici.label}</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="row" style="padding-top: 23px;">
		<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1">
			<label>Regione</label>
		</div>
		<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
			<select name="regione" path="regioni" id="regione">
				<option value="">TUTTE</option>
				<c:forEach items="${regioni}" var="regione">
					<option value="${regione.value}">${regione.label}</option>
				</c:forEach>
			</select>
		</div>
		<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1">
			<label>Dal</label>
		</div>
		<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
			<input type="text" id="from" value="${rilevazioneForm.dataInizio}"  name="from" />
		</div>
	</div>
	<br>
	<div class="row">
		<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1">
			<label>Provincia</label>
		</div>
		<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
			<select id="provincia" name="provincia">
				<option value="">TUTTE</option>
			</select>
		</div>
		<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1">
			<label>Al</label>
		</div>
		<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
			<input type="text" id="to" disabled="disabled"/>
		</div>
	</div>
	<br>
	<div class="row">
		<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1">
			<label>Comune</label>
		</div>
		<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
			<select id="comune" name="comune">
				<option value="">TUTTI</option>
			</select>
		</div>
		<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
			<label> 15 gg di intervallo</label>
 <br> <br>
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<center>
						<button class="btn btn-primary" id="run"
							onclick="cercaFillAndamento();" style="width: 90px;">Cerca</button>
					</center>
					<center>


						<!-- 

<button class="btn btn-primary" id="run" style="width: 90px;">Cerca</button></center> -->
				</div>
			</div>
		</div>

	</div>
	<br>
</div>
<br>
<div class="row" style="padding-buttom: 23px; padding-top: 25px;">
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<center><img src="static/img/ajax-loader.gif" class="loaderImage" /></center>
	
		<canvas id="chartLine" width="400" height="125"></canvas>
	</div>
</div>
</div>
<br>



