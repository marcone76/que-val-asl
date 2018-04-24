<%@ include file="../../includes/taglib.jsp"%>
<%@ include file="../../includes/breadcrumb.jsp"%>
<script type="text/javascript"
	src="<spring:url value="/static/js/chart/Chart.bundle.js" />"></script>
<script type="text/javascript"
	src="<spring:url value="/static/js/chart/utils.js" />"></script>
<script type="text/javascript"
	src="<spring:url value="/static/js/monitoraggioRilevazione/monitoraggioRilevazione.js" />"></script>
<!-- <script type="text/javascript" src="<spring:url value="/static/js/statoAcquisizione/statoAcquisizione.js" />"></script> -->
<script type="text/javascript"
	src="<spring:url value="/static/js/utils/tendine.js"/>"></script>
<style>
select {
	width: 90%;
	text-overflow: ellipsis;
}
</style>




<h3>Monitoraggio - Stato Acquisizione</h3>

<br>
<br>

<div class="row">
	<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">

		<div class="row" style="padding-top: 50px;">
			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
				<label style="text-align: right;">Ciclo Scolastico</label>
			</div>
			<div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
				<select name="cicliScolastici" id="cicliScolastici" >
				<option value="">TUTTI</option>
							<c:forEach items="${cicliScolastici}" var="cicliScolastici">
								<option value="${cicliScolastici.value}">${cicliScolastici.label}</option>
							</c:forEach>
						</select>
			</div>
		</div>
		
		

		<div class="row" style="padding-top: 50px;">
			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
				<label style="text-align: right;">Regione</label>
			</div>
			<div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
				<select name="regione" id="regione">
					<option value="">TUTTE</option>
					<c:forEach items="${regioni}" var="regione">
						<option value="${regione.value}">${regione.label}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<br>

		<div class="row">
			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
				<label>Provincia</label>
			</div>
			<div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
				<select id="provincia" name="provincia">
					<option value="">TUTTE</option>
				</select>
			</div>
		</div>



		<br>
		<div class="row">
			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
				<label>Comune</label>
			</div>
			<div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
				<select id="comune" name="comune">
					<option value="">TUTTI</option>
				</select> <br>
			</div>
		</div>



		<br> <br>
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<center>
					<button class="btn btn-primary" style="width: 90px;"
						onclick="fillPies();">Cerca</button>
				</center>
			</div>
		</div>
	</div>
	<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
		<div
			style="border-style: solid; border-width: 2px; border-color: #54D1E1">
			<br>
			<center>
				<label>Questionari in corso</label>
			</center>
			<center>
				<img src="static/img/ajax-loader.gif" class="loaderImage" />

				<canvas id="tortaInCorso" width="28%" height="18%"></canvas>
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<center>
							<a class="link"><button class="btn btn-primary"
									style="width: 90px;"
									onclick="javascript:cambiaLink('elencoQuestionariStatoAcquisizioneInCorso');">Elenco</button></a>

						</center>
						<br>
					</div>
				</div>
		</div>
	</div>
	<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
		<div
			style="border-style: solid; border-width: 2px; border-color: #54D1E1">
			<br>
			<center>
				<label>Rilevazioni Validate</label>
			</center>
			<center>
				<img src="static/img/ajax-loader.gif" class="loaderImage" />

				<canvas id="tortaValidate" width="28%" height="18%"></canvas>
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<center>
							<a class="link"><button class="btn btn-primary"
									style="width: 90px;"
									onclick="javascript:cambiaLink('elencoQuestionariStatoAcquisizioneValidati');">Elenco</button></a>
						</center>
						<br>
					</div>
				</div>
		</div>
	</div>
</div>
