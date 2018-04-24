<%@ include file="../../includes/taglib.jsp"%>
<%@ include file="../../includes/breadcrumb.jsp"%>
<%@ taglib uri="/WEB-INF/tld/displaytag.tld" prefix="display"%>

<script type="text/javascript"
	src="<spring:url value="/static/js/gestioneRilevazione/dettaglioRilevazione.js" />"></script>

<div>
	<h3>ESPORTA RILEVAZIONE</h3>
	<div>
		<div class="content-frame m-b-2">

			<c:if test="${not empty rilevazione}">
				<fieldset>
					<div class="row text-center">
						<div class="col-md-12">
							<h2 for="descrizione">Rilevazione:
								${rilevazione.descrizione}</h2>
						</div>
					</div>
					<br /> <br />

					<div class="row">
					
            <h4 align="center"><label>ELENCO QUESTIONARI ${sessionScope.etichette['JPPERCORSI']}</label></h4>
            <table class="display sortable" id="tabellaRilevazione">
                   <thead>
                        <tr>
                        <th >Scuola</th>
                        <th >Questionario</th>
                        <th >Data in Corso</th>
                        <th >Download</th>
                        <th >Data Validazione</th>
                        <th >Download</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${questionari}" var="dto">
                            <tr>
                            <td>${dto.codScu}-${dto.denom}</td>
                            <td>${dto.questionario}</td>
                            <td>${fn:substring(dto.datUltSal,0, 10)}</td>
                            <td nowrap="nowrap">
                            <c:if test="${readonlyMode ne true && dto.stato ne 'NON COMPILATO'}">                                
                            <a href="/oss-scu-dig-web/#downloadRilevazioneInCorso?breadcrumbTitle=DownloadRilevazioneInCorso&subItem=y&codScu=${dto.codForScu}&codQuest=${dto.codQuestionario}" class="icon miur-vai" title="Download"></a>
						    </c:if>
                            </td>
                            <td>${fn:substring(dto.dataUltVal,0, 10)}</td>
                            <td nowrap="nowrap">
                            <c:if test="${dto.dataUltVal ne null && dto.stato ne 'NON COMPILATO' }">                                
                            <a href="/oss-scu-dig-web/#downloadRilevazioneValidato?breadcrumbTitle=DownloadRilevazioneInCorso&subItem=y&codScu=${dto.codForScu}&codQuest=${dto.codQuestionario}" class="icon miur-vai" title="Download"></a>
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
                         <th >Scuola</th>
                        <th >Questionario</th>
                        <th >Data in Corso</th>
                        <th >Download</th>
                        <th >Data Validazione</th>
                        <th >Download</th>
                        </tr>
                    </thead>
                    <tbody>
                       <c:forEach items="${questionari}" var="dto">
                            <tr>
                            <td>${dto.codScu}-${dto.denom}</td>
                            <td>${dto.questionario}</td>
                          <td>${fn:substring(dto.datUltSal,0, 10)}</td>
                            <td nowrap="nowrap">
                            <c:if test="${readonlyMode ne true && dto.stato ne 'NON COMPILATO'}">                                
                            <a href="/oss-scu-dig-web/#downloadRilevazioneInCorso?breadcrumbTitle=DownloadRilevazioneInCorso&subItem=y&codScu=${dto.codForScu}&codQuest=${dto.codQuestionario}" class="icon miur-vai" title="Download"></a>
						    </c:if>
                            </td>
                              <td>${fn:substring(dto.dataUltVal,0, 10)}</td>
                              <td nowrap="nowrap">
                            <c:if test="${dto.dataUltVal ne null && dto.stato ne 'NON COMPILATO'} ">                                
                            <a href="/oss-scu-dig-web/#downloadRilevazioneValidato?breadcrumbTitle=DownloadRilevazioneInCorso&subItem=y&codScu=${dto.codForScu}&codQuest=${dto.codQuestionario}" class="icon miur-vai" title="Download"></a>
						    </c:if>
                            </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <br/>
     
     
				</fieldset>
		
			</c:if>

<!-- 							<div class="col-md-2">
								<a class="btn btn-block submit-btn" href="javascript:history.back()">Indietro</a>
							</div> -->

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
