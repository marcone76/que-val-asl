<%@ include file="../../includes/taglib.jsp"%>
<%@ include file="../../includes/breadcrumb.jsp"%>

<script type="text/javascript"
	src="<spring:url value="/static/js/gestioneRilevazione/dettaglioRilevazione.js" />"></script>



<script>
	$("#dataInizio").datepicker({
		format : 'dd/mm/yyyy',
		autoclose : true,
		language : 'it',
	});

	$("#dataFine").datepicker({
		format : 'dd/mm/yyyy',
		autoclose : true,
		language : 'it',
	});

	function changeFrom(id) {
		var tt = document.getElementById(id).value;
		var date = tt;
		document.getElementById(id).value = tt;
	}

	function url() {
		$("#change").change(
				function() {
					alert("Selected value is : "
							+ document.getElementById("change").value);
				});
		var id = $('#id').val();
		var stato = $('#stato').val();
		var dataInizio = $('#dataInizio').val();
		var dataFine = $('#dataFine').val();
		var url = '/oss-scu-dig-web/#salvaRilevazione?breadcrumbTitle=SalvaRilevazione&subItem=y&nomeBottone=Salva&id='
				+ id
				+ '&stato='
				+ stato
				+ '&dataInizio='
				+ dataInizio
				+ '&dataFine=' + dataFine;
		$(".link").attr('href', url);
	}
</script>
<div>


	<h3>GESTIONE RILEVAZIONE</h3>
	<div>
		<div class="content-frame m-b-2">

			<fieldset>
				<div class="row text-center">
					<div class="col-md-12">
						<h2 for="descrizione">${codiceMeccanografico.dataApertura}</h2>
					</div>
				</div>
				<br />
				<div class="row">
					<div class="col-md-3">
						<label for="dataInizio">Data Apertura:</label>
					</div>
					<div class="col-md-3">

						<c:choose>
							<c:when
								test="${rilevazioneForm.dataInizio ne null || rilevazioneForm.dataInizio eq ''}">

								<input type="text" value="${rilevazioneForm.dataInizio}"
									id="dataInizio" class="date" />
							</c:when>
							<c:otherwise>
								<input type="text" value="${rilevazioneForm.dataInizio}"
									id="dataInizio" class="date" />
							</c:otherwise>

						</c:choose>
					</div>
					<div class="col-md-3">
						<label for="dataFine">Data Chiusura:</label>
					</div>
					<div class="col-md-3">

						<input type="text" value="${rilevazioneForm.dataFine}"
							id="dataFine" class="date" />

					</div>
				</div>

				<br>
				<div class="col-md-12">
					<div class="row text-center">
						<center>
							<a class="link"><button class="btn btn-block submit-btn"
									style="width: 90px;" onclick="javascript:url();">Salva</button></a>

						</center>
					</div>
				</div>
				<br>
			</fieldset>
		</div>
		<br> <br> <br>
		<c:if test="${rilevazioneForm.stato != 'BOZZA'}">
			<div class="content-frame m-b-2">
				<fieldset>
					<div class="row">
						<div class="col-md-12">
							<center>

								<c:if test="${rilevazioneForm.stato == 'APERTA'}">

									<label for="stato">SOSPESA:NO</label>
									<br>
									<a style="width: 120px"
										onclick="if(!window.confirm('Si vuol sospendere la rilevazione attiva. Procedere?')) return false"
										href="/oss-scu-dig-web/#salvaRilevazione?breadcrumbTitle=SalvaRilevazione&subItem=y&nomeBottone=Sospendi&id=${rilevazioneForm.id}&stato=${rilevazioneForm.stato}"
										id="btn-sospendi" type="button"
										class="btn btn-block submit-btn" aria-label="Sospendi">Sospendi</a>

								</c:if>
								<c:if test="${rilevazioneForm.stato == 'SOSPESA'}">
									<label for="stato">SOSPESA:SI</labl> <Br> <a
										style="width: 120px"
										onclick="if(!window.confirm('Si vuol attivare la rilevazione attiva. Procedere?')) return false"
										href="/oss-scu-dig-web/#salvaRilevazione?breadcrumbTitle=SalvaRilevazione&subItem=y&nomeBottone=Attiva&id=${rilevazioneForm.id}&stato=${rilevazioneForm.stato}"
										id="btn-attiva" type="button" class="btn btn-block submit-btn"
										aria-label="Attiva">Attiva</a>
								</c:if>
							</center>
						</div
					</div>
					<br> <br>
				</fieldset>
			</div>
		</c:if>

		<c:if test="${messageRilevazione ne null }">
			<fieldset>
				</legend>
				<h4>${messageRilevazione}</h4>
			</fieldset>
		</c:if>
		<input type="hidden" id="stato" name="stato"
			value="${rilevazioneForm.stato}" /> <input type="hidden" id="id"
			name="id" value="${rilevazioneForm.id}" /> <input type="hidden"
			id="dataInizio" name="dataInizio"
			value="${rilevazioneForm.dataInizio}" /> <input type="hidden"
			id="dataFine" name="dataFine" value="${rilevazioneForm.dataFine}" />


	</div>