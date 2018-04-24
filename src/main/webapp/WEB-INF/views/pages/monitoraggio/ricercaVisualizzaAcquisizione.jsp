<%@ include file="../../includes/taglib.jsp"%>
<%@ include file="../../includes/breadcrumb.jsp"%>

<script type="text/javascript" src="<spring:url value="/static/js/utils/tendine.js"/>"></script>

<style>
select{
    width: 86%;
    text-overflow: ellipsis;
}
</style> 

<div>
	<h3>MONITORAGGIO - VISUALIZZA ACQUISIZIONE</h3>
	<form id="schedaForm" name="schedaForm" action="visualizzaAcquisizioneElencoScuole" method="post" class="no_ajax">
		<div class="row">
			<div class="col-lg-11 col-md-11 col-sm-11 col-xs-11">
				<div class="row" style="padding-top: 50px;">
					<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
						<label style="text-align: right;">Cod.Mec.</label>
					</div>
				
				<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
					<input name="codMec" type="text"></input>
				</div>
				</div>
				<br>
				<div class="row">
					<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
						<label style="text-align: right;">Questionario</label>
					</div>
				<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
						<select name="questionario" id="questionario" >
							<c:forEach items="${questionari}" var="questionario">
								<option value="${questionario.value}">${questionario.label}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
						<label style="text-align: right;">Regione</label>
					</div>
				<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
						<select name="regioneAc" id="regione">
							<option value="">TUTTE</option>
							<c:forEach items="${regioni}" var="regione">
								<option value="${regione.value}/${regione.label}">${regione.label}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
						<label> Provincia</label>
					</div>
				<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
						<select id="provincia" name="provinciaAc">
							<option value="">TUTTE</option>
						</select>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
						<label>Comune</label>
					</div>
				<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
						<select id="comune" name="comuneAc">
							<option value="">TUTTI</option>
						</select> <br>
					</div>
				</div>
				<br> <br>
				<div class="row">
					<!-- <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
						<button class="btn btn-primary" style="width: 90px;" onclick="javascript:location.href='/oss-scu-dig-web/#visualizzaAcquisizioneElencoScuole?breadcrumbTitle=VisualizzaAcquisizione';" id="btn-procedi" type="button" class="btn btn-block submit-btn" aria-label="Cerca" tabindex="70">Cerca</button>
					</div> -->
					<div class="col-md-3 col-lg-3">
						<button type="submit" class="btn btn-block submit-btn" aria-label="Cerca" tabindex="50">Cerca</button>
					</div>
				</div>
			</div>
		</div>
		
	</form>
</div>
