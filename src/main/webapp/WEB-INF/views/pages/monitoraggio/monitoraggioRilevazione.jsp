<%@ include file="../../includes/taglib.jsp"%>
<%@ include file="../../includes/breadcrumb.jsp"%>

<script type="text/javascript" src="<spring:url value="/static/js/chart/Chart.bundle.js" />"></script>
<script type="text/javascript" src="<spring:url value="/static/js/chart/utils.js" />"></script>
<script type="text/javascript" src="<spring:url value="/static/js/monitoraggioRilevazione/home.js" />"></script>



<!-- 
<style>
.loader {
  border: 16px solid #f3f3f3;
  border-radius: 50%;
  border-top: 16px solid #3498db;
  width: 120px;
  height: 120px;
  -webkit-animation: spin 2s linear infinite;
  animation: spin 2s linear infinite;
}

@-webkit-keyframes spin {
  0% { -webkit-transform: rotate(0deg); }
  100% { -webkit-transform: rotate(360deg); }
}

@keyframes spin {
  0% { transform: rotate(0deg); }
  100% { transform: rotate(360deg); }
}
</style> -->

	<h3>Monitoraggio Rilevazione</h3>

<br>
<br>
<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" >
<div class="row">
<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
<label>Data Apertura:</label>
</div>
<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
<label>${rilevazione.dataInizio}</label>
</div>
					<c:if test="${not empty rilevazione.dataFine}">
<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
<label>Data Chiusura:</label>
</div>
<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
<label>${rilevazione.dataFine}</label>
</div>
</c:if>	
</div>
<br>
<div class="row">
<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
<label>Stato Rilevazione:</label>
</div>
<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
<label>${rilevazione.descrizioneStato}</label>
</div>
</div>

<br>
<br>

<div class="row">
<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
<div style="border-style: solid;
    border-width: 2px; border-color: #54D1E1">
    <br>
    <center><label>Questionari in corso</label></center>  
<center><img src="static/img/ajax-loader.gif" class="loaderImage" />
</center>    
<canvas id="torta" width="20%" height="10%"></canvas>
</div>
</div>
<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
<div style="border-style: solid;
    border-width: 2px; border-color: #54D1E1">
    <br>
    <center><label>Rilevazioni Validate</label></center>  
    <center><img src="static/img/ajax-loader.gif" class="loaderImage" />
</center>
<canvas id="torta2" width="20%" height="10%"></canvas>
</div>
</div>
</div>
</div>
