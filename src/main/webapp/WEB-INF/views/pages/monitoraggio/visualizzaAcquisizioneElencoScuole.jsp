<%@ include file="../../includes/taglib.jsp"%>
<%@ include file="../../includes/breadcrumb.jsp"%>

<div>
	<h3>Monitoraggio - Visualizza Acquisizione - Elenco Scuole</h3>
	<div>
		<div class="content-frame m-b-2">
			<fieldset>
				<div class="row text-center">
					<div class="col-md-12">
						<h2 for="descrizione">Elenco Scuole</h2>
					</div>
				</div>

				<div class="row">
					<div class="col-sm-3">
						<label for="codiceMeccanografico">Codice Meccanografico:</label>
					
						<label for="codiceMeccanografico"> ${codMec} </label>
					</div>

					<div class="col-sm-3">
						<label for="questionario">Questionario:</label>
					
						<label for="questionario">${questionario} </label>
					</div>

				</div>
				<br />
				<div class="row">
					<div class="col-sm-3">
						<label for="codiceMeccanografico">Regione:</label>
						<c:set var="regioneParts" value="${fn:split(regioni, '/')}" />
						<label for="codiceMeccanografico">${regioneParts[1]} </label>
					</div>

					<div class="col-sm-3">
						<label for="questionario">Provincia:</label>
					    <c:set var="provinceParts" value="${fn:split(province, '/')}" />
						<label for="codiceMeccanografico">${provinceParts[1]} </label>		
					</div>

					<div class="col-sm-3">
						<label for="comune">Comune:</label>
					 <c:set var="comuniParts" value="${fn:split(comuni, '/')}" />
						<label for="codiceMeccanografico">${comuniParts[1]} </label>	
						
					</div>
				</div>


				<div class="row">

					<table class="display noPaging" id="tabellaDomandeValidate">
						<thead>
							<tr>
								<th>Codice Meccanografico</th>
								<th>Denominazione</th>
								<th>Questionario</th>
								<th>Stato</th>
								<th>In corso</th>
								<th>Validato</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${questionari}" var="dto">
								<tr>
									<td>${dto.codScu}</td>
									<td>${dto.denom}</td>
									<td>${dto.questionario}</td>
									<td>${dto.stato}</td>
									 <td class="last-td"><a
										href="/oss-scu-dig-web/#visualizzaQuestionario?breadcrumbTitle=Questionario&subItem=y&codForScu=${dto.codScu}&idQst=${dto.codQuestionario}&sezioneValidata=0"
										class="icon miur-vai" title="Visualizza"></a> </td>
										
									<td class="last-td">
										<c:if test="${dto.validati=='VALIDATO'}">
												<a href="/oss-scu-dig-web/#visualizzaQuestionario?breadcrumbTitle=Questionario&subItem=y&codForScu=${dto.codScu}&idQst=${dto.codQuestionario}&sezioneValidata=1"
													class="icon miur-vai" title="Visualizza"></a>
										</c:if>
									</td> 
										
								</tr>
							</c:forEach>
						</tbody>

					</table>
					<br>
					<div class="col-md-2">
								<a class="btn btn-block submit-btn" onclick="reloadPage();">Indietro</a> 
					</div>

				</div>

				<br /> <br />
			</fieldset>

			<c:if test="false">
				<div class="row text-center">
					<div class="col-md-12">
						<h2>ATTENZIONE : NESSUNA RILEVAZIONE PRESENTE</h2>
					</div>
				</div>
			</c:if>

		</div>
	</div>
	
</div>
