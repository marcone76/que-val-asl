<%@ include file="includes/taglib.jsp" %>

<sec:authentication var="principal" property="principal" ></sec:authentication>

<c:choose>
	<c:when test="${principal.username!='anonymousUser'}">
		<%@ include file="includes/header.jsp" %>

		<%@ include file="includes/body.jsp" %>
		
		<!-- include file="pages/home.jsp" %> -->
		<%@ include file="includes/cambiaProfiloContesto.jsp" %>
			
		<%@ include file="includes/footer.jsp" %>
	</c:when>
	<c:otherwise>
		UTENTE NON AUTORIZZATO
	</c:otherwise>
</c:choose>
