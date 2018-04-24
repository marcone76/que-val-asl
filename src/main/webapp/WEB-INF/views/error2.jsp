<%@ include file="includes/taglib.jsp"%>

<div id="page">
	<div id="content">
		<div id="stackTraceShort" class="info ui-corner-all">
			<h2>Impossibile proseguire</h2>
			<pre>${errorObject.message}</pre>
		</div>
	</div>
	<div align="center">
		<button type="button" class="btn btn-block submit-btn" aria-label="Indietro"
			onclick="window.location='#ricercaPraticaPerCalcolo'">Indietro</button>
	</div>
</div>
