<%@ include file="../../includes/taglib.jsp"%>
<%@ include file="../../includes/breadcrumb.jsp"%>



<script type="text/javascript"
	src="<spring:url value="/static/js/gestioneRilevazione/dettaglioRilevazione.js" />"></script>
<script type="text/javascript"
	src="<spring:url value="/static/js/menuGestione/menuGestione.js" />"></script>

<div>
	<h3>GESTIONE - GESTIONE PUBBLICAZIONE</h3>
	<div>

		<div class="content-frame m-b-2">
			
				<fieldset>


					<h4 align="center">
						<label>ELENCO FILTRI DOMANDE</label>
					</h4>
					
					<table class="display noPaging" id="tabellaPubblicazione">
				<thead>
					<tr>
						<th>Questionario</th>
								<th>Sezione</th>
								<th>Cod. Dmd</th>
								<th>Domanda</th>
								<th>Val.Max</th>
								<th>Val.Min</th>
								<th>Val.Medio</th>
								<th>Fil.Min</th>
								<th>Fil.Max</th>
								<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pubblicazione}" var="dto">
						        <td>${dto.descQst}</td>
						        <td><label>${dto.desSez}</td>
								<td>${dto.codDmd}</td>
								<input type="hidden" id="codicedomanda" name="codicedomanda" 
					             value="${dto.codDmd}">
								<td>${dto.desDmd}</td>
								<td>${dto.massimo}</td>
								<td>${dto.minimo}</td>
								<td>${dto.media}</td>
								<td>${dto.numValMin}</td>
								<input type="hidden" size="3" id="limiteMinimo" name="limiteMinimo" value="${dto.numValMin}"/>
								<td>${dto.numValMas}</td>
								<input type="hidden" size="3" id="limiteMassimo" name="limiteMassimo" value="${dto.numValMas}"/>
								<input type="hidden" id="codiceQuestionario" name="codiceQuestionario" value="${dto.codQuest}"/>	
								<input type="hidden"  id="idRil" name="idRil" value="${dto.prgIstRil}"/>	
								<td class="last-td">
									<a href="/oss-scu-dig-web/#gestioneRecordS?codicedomanda=${dto.codDmd}&limiteMinimo=${dto.numValMin}&limiteMassimo=${dto.numValMas}&id=${dto.prgIstRil}&codQuest=${dto.codQuest}"
										class="icon miur-vai" title="dettaglio"></a>
							
							</td>
							</tr>

					</c:forEach>
				</tbody>
			</table>

			<div id="tabellaPubblicazione-per-download" style="display: none;">
				<table>
							<thead>
					<tr>
						<th>Questionario</th>
								<th>Sezione</th>
								<th>Cod. Dmd</th>
								<th>Domanda</th>
								<th>Val.Max</th>
								<th>Val.Min</th>
								<th>Val.Medio</th>
								<th>Fil.Min</th>
								<th>Fil.Max</th>
								<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pubblicazione}" var="dto">
						        <td>${dto.descQst}</td>
						        <td><label>${dto.desSez}</td>
								<td>${dto.codDmd}</td>
								<input type="hidden" id="codicedomanda" name="codicedomanda" 
					             value="${dto.codDmd}">
								<td>${dto.desDmd}</td>
								<td>${dto.massimo}</td>
								<td>${dto.minimo}</td>
								<td>${dto.media}</td>
								<td>${dto.numValMin}</td>
								<input type="hidden"  id="limiteMinimo" name="limiteMinimo"value="${dto.numValMin}"/>
								<td>${dto.numValMas}</td>
								<input type="hidden"  id="limiteMassimo" name="limiteMassimo" value="${dto.numValMas}"/>
								<input type="hidden" id="codiceQuestionario" name="codiceQuestionario" value="${dto.codQuest}"/>	
								<input type="hidden"  id="idRil" name="idRil" value="${dto.prgIstRil}"/>				
								<td nowrap="nowrap">
									<a href="/oss-scu-dig-web/#gestioneRecordS?codicedomanda=${dto.codDmd}&limiteMinimo=${dto.numValMin}&limiteMassimo=${dto.numValMas}&id=${dto.prgIstRil}&codQuest=${dto.codQuest}"
										class="icon miur-vai" title="dettaglio"></a>
							</td>
							
							</tr>

					</c:forEach>
				</tbody>
				</table>
				</div>	
					<br>
					<div class="row">


						<div class="col-lg-7 col-md-7 col-sm-7 col-xs-7">
							<a style="width: 210px" 
										href="/oss-scu-dig-web/#pubblica?isFiltered=true" 
										id="publicazioneFltrButton" type="button" class="btn btn-block submit-btn" aria-label="Attiva" >Pubblica Con Filtri</a>

						</div>

						<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
							<a style="width: 230px" 
										href="/oss-scu-dig-web/#pubblica?isFiltered=false" 
										id="publicazioneNoFltrButton" type="button" class="btn btn-block submit-btn" aria-label="Attiva" >Pubblica Senza Filtri</a>

						</div>

					</div>
					
					<!-- Modal -->
  <!-- <div class="modal fade" id="modalNoFiltri" role="dialog">
    <div class="modal-dialog">
    
      Modal content
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Attenzione</h4>
        </div>
        <div class="modal-body">
          <p>Pubblicazione senza filtri effettuata con successo</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div> -->
  
  <!-- Modal -->
  <!-- <div class="modal fade" id="modalFiltri" role="dialog">
    <div class="modal-dialog">
    
      Modal content
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Attenzione</h4>
        </div>
        <div class="modal-body">
          <p>Pubblicazione con filtri effettuata con successo</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div> -->
					
					
			</fieldset>

		