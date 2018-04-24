<%@ include file="../../includes/taglib.jsp"%>
<%@ include file="../../includes/breadcrumb.jsp"%>

<script type="text/javascript" src="<spring:url value="/static/js/gestioneRilevazione/dettaglioRilevazione.js" />"></script>
<script type="text/javascript"
	src="<spring:url value="/static/js/menuGestione/menuGestione.js" />"></script>
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


<h3>Gestione - Gestione Storicizzazione</h3>
<div class="content-frame m-b-2">


		<br>
		<c:if test="${not empty rilevazione}">		
		<fieldset>

			<h4 align="center">
				<label>ELENCO DATE STORICIZZAZIONE ${sessionScope.etichette['JPPERCORSI']}</label>
			</h4>
			<table class="display noPaging" id="tabellaRilevazione">
				<thead>
					<tr>
						<th>Date Publicazioni</th>
						<th>Date Storicizzazioni</th>
						<th>Cancella</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${storicizzazione}" var="dto">
						<tr>
							<td>${dto.dataPubblicazioni}</td>
							<td>${dto.dataStoricizzazione}</td>
							<td nowrap="nowrap">
							<c:if test="${dto.flagLimite =='N'}">
									<a href="/oss-scu-dig-web/#cancellaRecordStoricizzazione?breadcrumbTitle=cancellaRecordStoricizzazione&subItem=y&id=${dto.id}&dataStoricizzazione=${dto.dataStoricizzazione}"
										class="icon miur-vai" title="Cancella"></a>
							</c:if> 
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<div id="tabellaRilevazione-per-download" style="display: none;">
				<table>
					<thead>
					<tr>
						<th>Date Storicizzazioni</th>
						<th>Date Publicazioni</th>
						<th>Cancella</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${storicizzazione}" var="dto">
						<tr>
							<td>${dto.dataStoricizzazione}</td>
							<td>${dto.dataPubblicazioni}</td>
							<td nowrap="nowrap">
							<c:if test="${dto.flagLimite =='N'}">
									<a href="/oss-scu-dig-web/#cancellaRecordStoricizzazione?breadcrumbTitle=cancellaRecordStoricizzazione&subItem=y&id=${dto.id}&dataStoricizzazione=${dto.dataStoricizzazione}"
										class="icon miur-vai" title="Cancella"></a>
							</c:if> 
							</td>
						</tr>
					</c:forEach>
				</tbody>
				</table>

		</fieldset>


		<br>
		<div class="row">
			<div class="col-lg-7 col-md-7 col-sm-7 col-xs-7">
				<label> Data Storicizzazione: <input type="text" id="dataStoricizzazione" name="dataStoricizzazione" placeholder="dd/mm/aaaa" ></label>
			</div>
			<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
						<div class="row text-center">
							<center>
							<a class="link"><button class="btn btn-block submit-btn"
									style="width:120px;"
									onclick="javascript:urlStoricizzazione();">Conferma</button></a>   			
							</center>
						</div>
					</div>
       <label> *Data successiva alla data odierna</label>
		
		<c:if test="${messageInserisStoric ne null }">	   
<fieldset >
	</legend>
		<h4>${messageInserisStoric}</h4>
	</fieldset> 
</c:if>

</c:if>
<c:if test="${empty rilevazione}">
			<div class="row text-center">
				<div class="col-md-12">
					<h2>ATTENZIONE : NESSUNA RILEVAZIONE DA APPROVARE</h2>
				</div>										
			</div>			
		</c:if>

	</div>
</div>

