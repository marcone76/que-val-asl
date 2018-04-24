<%@ include file="../includes/taglib.jsp"%>
<%@ include file="../includes/breadcrumb.jsp"%>


<div>
	<center><h3>Osservatorio Permanente Scuola Digitale</h3></center>
	<div>
		<div class="content-frame m-b-2">	
				<fieldset>
				
					<div class="row text-center">
						<div class="col-md-12">
							<h2> AVVISI UTENTE </h2>
						</div>			
					</div>
					
					<div class="row">
					<table class="tablesaw">
							<thead>
						  	  	 <tr> 
								  <th></th>
								  <th></th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${avvisi}" var="avvisiDTO">
							<tr>
							<c:if test="${avvisiDTO.codTipoAvv=='1'}">
							  <td class="text-left-important" style="color:green;font-weight: bold;">
							  ${avvisiDTO.descrizioneAvv}</td>
							</c:if>
							<c:if test="${avvisiDTO.codTipoAvv=='2'}">
							  <td class="text-left-important" style="color:red;font-weight: bold;">
							  ${avvisiDTO.descrizioneAvv}</td>
							</c:if>				  
							  <td>${avvisiDTO.descrizioneTestoAVV}</td>	 
							</tr>
							</c:forEach>
							</tbody>
						</table>
					</div>			
					<br/>		
				</fieldset>				
		</div>
	</div>
</div>

