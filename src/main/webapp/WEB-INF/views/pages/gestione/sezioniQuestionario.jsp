<%@ include file="../../includes/taglib.jsp"%>
<%@ include file="../../includes/breadcrumb.jsp"%>

<script type="text/javascript" src="<spring:url value="/static/js/gestioneRilevazione/dettaglioRilevazione.js" />"></script>
<div>
	<h3>${rilevazione.descrizione}</h3>
	<div>
		<div class="content-frame m-b-2">
		
		<c:if test="${not empty rilevazione}">
			<c:if test="${empty message}">
			
			<fieldset>
			

				<div class="content">
					  <c:forEach items="${sezioni}" var="sezione">
					  	<c:set var="codiceForteScuola" value="${sezione.codiceForteScuola}" />
						  <div class="panel panel-default">
							    <div class="panel-heading">
							      <h3 class="panel-title">
							        <a href="#schedeGestione?breadcrumbTitle=SchedeGestione&subItem=y&scheda=${sezione.idSezione}&codQuest=${questionario.codiceQuestionario}&codForteScu=${sezione.codiceForteScuola}&codEdi=">${sezione.descrizioneSezione}</a>
							        
							      </h3>
							    </div>
						  </div>
					  </c:forEach>
		  
				  
				</div> 
			</c:if>
				
	<br/>
		<div class="row">

			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="col-md-2">
								<a class="btn btn-block submit-btn" href="javascript:history.back()">Indietro</a>
						</div>
						<c:if test="${empty message}">
							<div  class="col-md-10">
								<a class="link"><button class="btn btn-block submit-btn pull-right" style="width:250px;" onclick="javascript:location.href='/oss-scu-dig-web/#approvaQuestionario?codQst=${questionario.codiceQuestionario}';">Approva Questionario</button></a>
	    					</div>
    					</c:if>
			</div>
      
      
      	<c:if test="${not empty message}">
			<div class="row text-center">
				<div class="col-md-12">
			  			<h2 style="color: #06C">${message}</h2>
			   </div>
		   </div>
		</c:if>	
		</div>
				
		</div> <!-- class="content" -->				
				
				<br/>
				<br/>
			</fieldset>
			
		</c:if>
			          
            <br/>
		
		<c:if test="${empty rilevazione}">
			<div class="row text-center">
				<div class="col-md-12">
					<h2>ATTENZIONE : NESSUNA RILEVAZIONE APERTA</h2>
				</div>										
			</div>			
		</c:if>
				
		</div>
	</div>
</div>
