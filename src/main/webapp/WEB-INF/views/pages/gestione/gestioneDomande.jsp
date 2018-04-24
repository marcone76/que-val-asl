<%@ include file="../../includes/taglib.jsp"%>
<%@ include file="../../includes/breadcrumb.jsp"%>

<script type="text/javascript" src="<spring:url value="/static/js/gestioneRilevazione/dettaglioRilevazione.js" />"></script>
<script type="text/javascript"
	src="<spring:url value="/static/js/menuGestione/menuGestione.js" />"></script>

<div>
	<h3>GESTIONE DOMANDE</h3>
	<div>
		<div class="content-frame m-b-2">
		
		<c:if test="${not empty rilevazione}">
			<fieldset>
				<div class="row text-center">
					<div class="col-md-12">
						<h2 for="descrizione"> Rilevazione: ${rilevazione.descrizione}</h2>
					</div>										
				</div>
				<br/>
				<br/>
		
		
			
				  <h4 align="center"><label>ELENCO QUESTIONARI</label></h4>
            <table class="display noPaging" id="tabellaDomande">
            
                   <thead>
                        <tr>
                        <th>Tipologia</th>
						<th>Stato</th>	
						<th></th>	
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${questionari}" var="dto">
                            <tr>
                              <td>${dto.nome}</td>
                          <td>${dto.descrizioneStatoQuestionario}</td>
						    <td class="last-td">
 						    	<c:if test="${dto.codTipSta!=15}">				 
					  				<a href="/oss-scu-dig-web/#questionarioDomande?breadcrumbTitle=QuestionarioDomande&subItem=y&idQst=${dto.codiceQuestionario}"  class="icon miur-vai" title="Visualizza"></a>
					  			</c:if> 
				  		  </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                    
                      
            </table>
            
		    <br/>
		    
		<div class="row">

			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="row">
						<center>
							<a class="link"><button class="btn btn-block submit-btn" style="width:250px;" onclick="javascript:urlGestioneDomande();">Approva Rilevazione</button></a>
						<center>   			
						</div>
			</div>
      
		</div>
		
		  <br/>  <br/>

			</fieldset>
		  </c:if>
		
		<c:if test="${not empty message}">
			<div class="row text-center">
				<div class="col-md-12">
			  			<h2 style="color: #06C">${message}</h2>
			   </div>
		   </div>
		</c:if>	
			          
            <br/>
		
		<c:if test="${empty rilevazione && empty message}">
			<div class="row text-center">
				<div class="col-md-12">
					<h2>ATTENZIONE : NESSUNA RILEVAZIONE IN BOZZA</h2>
				</div>										
			</div>			
		</c:if>
				
		</div>
	</div>
</div>
