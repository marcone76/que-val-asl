<%@ include file="../../includes/taglib.jsp"%>
<%@ include file="../../includes/breadcrumb.jsp"%>
<%@ taglib uri="/WEB-INF/tld/displaytag.tld" prefix="display"%>

<script type="text/javascript"
	src="<spring:url value="/static/js/gestioneRilevazione/dettaglioRilevazione.js" />">
</script>

<div>
	<h3>ESPORTA ACQUISIZIONE GENERALE - ELENCO QUESTIONARI</h3>
	<div>
		<div class="content-frame m-b-2">

			<c:if test="${not empty rilevazione}">
				<fieldset>
					<div class="row text-center">
						<div class="col-md-12">
							<h2 for="descrizione">Rilevazione: ${rilevazione.descrizione}</h2>
						</div>
					</div>
					<br /> <br />
					<div class="col-md-12">
						
					    <c:set var="regioneParts" value="${fn:split(regioneR, '/')}" />
					    <c:set var="provinciaParts" value="${fn:split(provinciaR, '/')}" />
					    <c:set var="comuneParts" value="${fn:split(comuneR, '/')}" />

						<label for="regione"> Regione - ${regioneParts[1]} </label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
						<label for="provincia"> Provincia - ${provinciaParts[1]} </label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
						<label for="comune"> Comune - ${comuneParts[1]} </label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
						<label for="codiceMeccanografico"> Codice Meccanografico - ${codMec} </label>
					</div>	
					<div class="row">
					<c:set var="prov" value="&provincia=" />
					<c:set var="com" value="&comune=" />
					<c:set var="codForScu" value="&codForScu=" />
					
			<%-- <c:if test="${not empty listaRilevazioneAcquisizione}"> --%>
            <h4 align="center"><label>ELENCO QUESTIONARI${sessionScope.etichette['JPPERCORSI']}</label></h4>
            <table class="display noPaging" id="tabellaRilevazione">
            
                   <thead>
                        <tr>
                        <th >Questionario</th>
                        <th >Numero di scuole con Questionari in Corso</th>
                        <th >Download</th>
                        <th >Numero di scuole con Questionari Validati</th>
                        <th >Download</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listaRilevazioneAcquisizione}" var="dto">
                            <tr>
                            <td>${dto.questionario}</td>
                            <td>${dto.inCorso}</td>
                            <td nowrap="nowrap">
                            <c:if test="${readonlyMode ne true}">                                
                            		<a href="/oss-scu-dig-web/#esportaAcquisizioneInCorso?breadcrumbTitle=EsportaAcquisizioneInCorso&subItem=y&codQst=${dto.codQuestionario}&codMec=${codMec}&regioneEs=${regioneR}&provinciaEs=${provinciaR}&comuneEs=${comuneR}" class="icon miur-vai" title="Download"></a> 
							</c:if>   <!--  //regione=${regioneR}${prov}${provinciaR}${com}${comuneR}${codForScu}${codMec} -->
                            </td>
                            <td>${dto.validati}</td>
                              <td nowrap="nowrap">
                            <c:if test="${readonlyMode ne true}">                                
                          			<a href="/oss-scu-dig-web/#esportaAcquisizioneValidato?breadcrumbTitle=EsportaAcquisizioneValidato&subItem=y&codQst=${dto.codQuestionario}&codMec=${codMec}&regioneEs=${regioneR}&provinciaEs=${provinciaR}&comuneEs=${comuneR}" class="icon miur-vai" title="Download"></a>
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
	                        <th >Questionario</th>
	                        <th >Numero di scuole con Questionari in Corso</th>
	                        <th >Numero di scuole con Questionari Validati</th>
                        </tr>
                    </thead>
                   <tbody>
                        <c:forEach items="${listaRilevazioneAcquisizione}" var="dto">
                            <tr>
	                            <td>${dto.questionario}</td>
	                            <td>${dto.inCorso}</td>
	                            <td>${dto.validati}</td>
                            </tr>
                        </c:forEach>
                        
                    </tbody>
                      
                </table>
                
             
            </div>
            <br/>
     
     		<table style="width: 100%;">
				<tr>
					<td align="center">
						<button class="export-pdf"
							data-ref="tabellaRilevazione-per-download"
							data-filename="ElencoQuestionariEsportaAcquisizione"
							data-title="Elenco Questionari Esporta Acquisizione"
							data-rotate="true" 
							data-filtro="Regione=${regioneParts[1]}|Provincia=${provinciaParts[1]}|Comune=${comuneParts[1]}">			
							Esporta in PDF</button> &nbsp;
						<button class="export-excel"
							data-ref="tabellaRilevazione-per-download"
							data-filename="ElencoQuestionariEsportaAcquisizione"
							data-title="Elenco Questionari Esporta Acquisizione"
							data-filtro="Regione=${regioneParts[1]}|Provincia=${provinciaParts[1]}|Comune=${comuneParts[1]}">		Esporta
							in Excel</button> &nbsp;
						<button class="export-csv"
							data-ref="tabellaRilevazione-per-download"
							data-filename="ElencoQuestionariEsportaAcquisizione"
							data-title="Elenco Questionari Esporta Acquisizione">
							Esporta in CSV</button> &nbsp;
						<button class="export-txt"
							data-ref="tabellaRilevazione-per-download"
							data-filename="ElencoQuestionariEsportaAcquisizione"
							data-title="Elenco Questionari Esporta Acquisizione">
							Esporta in TXT</button>

					</td>
				</tr>
			</table>
							
        </c:if>
				 <div class="col-md-2">
					<!--  <a class="btn btn-block submit-btn" href="javascript:history.back()">Indietro</a>--> 
					 <a class="btn btn-block submit-btn" onclick="reloadPage();">Indietro</a> 
				 </div>

				</fieldset>
		

			<c:if test="${empty rilevazione}">
				<div class="row text-center">
					<div class="col-md-12">
						<h2>ATTENZIONE : NESSUNA RILEVAZIONE PRESENTE</h2>
					</div>
				</div>
			</c:if>

		</div>
	</div>
</div>
