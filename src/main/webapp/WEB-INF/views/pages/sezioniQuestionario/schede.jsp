<%@ include file="../../includes/taglib.jsp"%>
<%@ include file="../../includes/breadcrumb.jsp"%>
<%@ taglib prefix="risp" uri="../../../tld/RispostaTag.tld"%>
<%@ taglib prefix="rispSpr" uri="../../../tld/radioButtonsTagCustom.tld"%>
<script type="text/javascript" src="<spring:url value="/static/js/gestioneRilevazione/dettaglioRilevazione.js" />"></script>
<%@ include file="../../pages/validation.jsp" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<c:set var="prePath" value="static/js/schede/" />
<c:set var="jsFileName" value="scheda" />
<c:set var="id" value="${sezione.idSezione}" />
<c:set var="estensione" value=".js" />
<script type="text/javascript" src="${prePath}variabili${estensione}"></script>
<script type="text/javascript" src="${prePath}${jsFileName}${id}${estensione}"></script>
<link type="text/css" rel="stylesheet" href="<spring:url value="/static/css/ossScuDig.css" />">
<div>
	<h3>${sezione.descrizioneSezione} </h3>
<div>
<div class="col-md-12">
	<h5>${sezione.descrizioneQuestionario} - ${sezione.codiceForteScuola}</h5>
<div>
<div class="content-frame m-b-2">
	<form id="schedaForm" name="schedaForm" action="salvaScheda.json" method="post">
			<fieldset>
       	<c:set var="separatore" value="_"/>
       	
			<!-- for sui gruppi -->
			<c:forEach items="${sezione.gruppiDomande}" var="gruppo" varStatus="loop">
			
			
			<!-- for sulle domande -->
				<c:forEach items="${gruppo.domande}" var="domanda" varStatus="loop">
			
       			<c:set var="idDomanda" value="${domanda.id}"/>
       				<c:if test="${domanda.tipoRisposta == 'MC'}">
       					<div class="${domanda.livelli}" id="${domanda.id}${gruppo.codEdi}">
       					<br/>
							<div class="col-md-4">
								<c:if test="${domanda.flgObb != 'S'}">
									<label class="obbligatorio" for="testoDomanda">${domanda.testoDomanda}</label>
								</c:if>
								<c:if test="${domanda.flgObb == 'S'}">
									<label for="testoDomanda">${domanda.testoDomanda}</label>
								</c:if>
							</div>
							<div class="col-md-8">	
								<c:forEach items="${domanda.voci}" var="voce" varStatus="loop">
									<c:if test="${gruppo.tipoGruppo == 'D'}">
										<input type="checkbox" name="DOM_${domanda.id}" id="${domanda.id}${separatore}${voce.id}"  label="${voce.descrizione}" value="${voce.id}" ${voce.checked} class="radio-inline spazio">${voce.descrizione}<br/>
										 <div name="${domanda.id}" cssClass="error" />
									</c:if>
									<c:if test="${gruppo.tipoGruppo != 'D'}">
										<input type="checkbox" name="DOM_${domanda.id}_COD_EDI_${domanda.codEdi}" id="${domanda.id}${separatore}${voce.id}"  label="${voce.descrizione}" value="${voce.id}" ${voce.checked} class="radio-inline spazio">${voce.descrizione}<br/>
										 <div name="${domanda.id}_COD_EDI_${domanda.codEdi}" cssClass="error" />
									</c:if>
								</c:forEach>
							</div>
							<div class="col-md-12">	
								&nbsp;
							</div>
       					</div>
       				</c:if>	
       				<c:if test="${domanda.tipoRisposta == 'MA'}">
       					<div class="${domanda.livelli}" id="${domanda.id}${gruppo.codEdi}">
       						<br/>
							<div class="col-md-4">
								<c:if test="${domanda.flgObb != 'S'}">
									<label class="obbligatorio" for="testoDomanda">${domanda.testoDomanda}</label>
								</c:if>
								<c:if test="${domanda.flgObb == 'S'}">
									<label for="testoDomanda">${domanda.testoDomanda}</label>
								</c:if>
							</div>
							<div class="col-md-8">	
								<c:forEach items="${domanda.voci}" var="voce" varStatus="loop">
									<c:if test="${gruppo.tipoGruppo == 'D'}">
										<input type="radio" name="DOM_${domanda.id}"  id="${domanda.id}${separatore}${voce.id}" label="${voce.descrizione}" value="${voce.id}" ${voce.checked} class="radio-inline spazio">${voce.descrizione}<br/>
										<div name="${domanda.id}" cssClass="error" />
									</c:if>
									<c:if test="${gruppo.tipoGruppo != 'D'}">
										<input type="radio" name="DOM_${domanda.id}_COD_EDI_${domanda.codEdi}"  id="${domanda.id}${separatore}${voce.id}_COD_EDI_${domanda.codEdi}" label="${voce.descrizione}" value="${voce.id}" ${voce.checked} class="radio-inline spazio">${voce.descrizione}<br/>
										<div name="${domanda.id}_COD_EDI_${domanda.codEdi}" cssClass="error" />
									</c:if>
								</c:forEach>
							</div>
							<div class="col-md-12">	
								&nbsp;
							</div>
       					</div>
       				</c:if>	
       				<c:if test="${domanda.tipoRisposta == 'FT'}">
       					<div class="${domanda.livelli}" id="${domanda.id}${gruppo.codEdi}">
       						<br/>
							<div class="col-md-4">
								<c:if test="${domanda.flgObb != 'S'}">
									<label class="obbligatorio" for="testoDomanda">${domanda.testoDomanda}</label>
								</c:if>
								<c:if test="${domanda.flgObb == 'S'}">
									<label for="testoDomanda">${domanda.testoDomanda}</label>
								</c:if>
							</div>
							<div class="col-md-8">
									<c:if test="${gruppo.tipoGruppo == 'D'}">	
										<input type="text" id="${domanda.id}999"  name="DOM_${domanda.id}" value="${domanda.valoreRisposta}" maxlength="140" size="50">
										<div name="${domanda.id}" cssClass="error" />
									</c:if>
									<c:if test="${gruppo.tipoGruppo != 'D'}">
										<input type="text" id="${domanda.id}999_COD_EDI_${domanda.codEdi}"  name="DOM_${domanda.id}_COD_EDI_${domanda.codEdi}" value="${domanda.valoreRisposta}" maxlength="140" size="50">
										<div name="${domanda.id}_COD_EDI_${domanda.codEdi}" cssClass="error" />
									</c:if>
							</div>
							<div class="col-md-12">	
								&nbsp;
							</div>
						</div>
       				</c:if>	
       				<c:if test="${domanda.tipoRisposta == 'EM'}">
	       					<div class="${domanda.livelli}" id="${domanda.id}${gruppo.codEdi}">
       					<br/>
							<div class="col-md-12 center">
								<c:if test="${gruppo.tipoGruppo == 'D'}">
									<label for="testoDomanda">${domanda.testoDomanda}</label>
								</c:if>
								<c:if test="${gruppo.tipoGruppo != 'D'}">
									<c:choose>
									  <c:when test="${domanda.id == '501' || domanda.id == '506' || domanda.id == '509'}">
									    <label for="testoDomandaCodEdi">${domanda.testoDomanda}&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="${domanda.id}999" class="codEdi" name="DOM_${domanda.id}_COD_EDI_${domanda.codEdi}" value="${gruppo.codEdi}" readonly="readonly">
									    <label for="indirizzo"><input type="text" name="indirizzo" value="${gruppo.indirizzo}" readonly="readonly" size="30">
									  </c:when>
									  <c:when test="${domanda.id == '126'}">
									    <label for="testoDomandaCodEdi">${domanda.testoDomanda}&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="${domanda.id}999" class="codEdi" name="DOM_${domanda.id}_COD_EDI_${domanda.codEdi}" value="${gruppo.codEdi}" readonly="readonly">
									    <label for="indirizzo"><input type="text" name="indirizzo" value="${gruppo.indirizzo}" readonly="readonly" size="30">
									  </c:when>
									  <c:otherwise>
									    <label for="testoDomandaCodEdi">${domanda.testoDomanda}</label>
									  </c:otherwise>
									</c:choose>
								</c:if>
							</div>
							<div class="col-md-12">	
								&nbsp;
							</div>
       					</div>
       				</c:if>	
       			</c:forEach><!-- chiudi for sulle domande -->
       		</c:forEach><!-- chiudi for sui gruppi -->
			
			<div class="row">
				&nbsp;
			</div>
			<div class="row">
				<div class="col-md-3">
					&nbsp;
				</div>
				<div class="col-md-2">
					<a class="btn btn-block submit-btn" href="javascript:history.back()" onclick="if(!window.confirm('I dati immessi e non salvati andranno persi. Procedere?')) return false">Indietro</a>
				</div>
				<div class="col-md-2">
					&nbsp;
				</div>
				<div class="col-md-2">
					<button type="submit" class="btn btn-block submit-btn" aria-label="Salva" tabindex="50">Salva</button>
				</div>
				<div class="col-md-3">
					&nbsp;
				</div>
			</div>
			<div id="form-block-error" class="hidden">
				<p>Si sono verificati degli errori nei seguenti campi:</p>
				<div id="resume-errors"></div>
				<p>Per favore ricontrolla i campi del modulo</p>
			</div>

			<fieldset>
			
		<input type="hidden" id="sezione" name="sezione" value="${sezione}"/>
		<input type="hidden" id="sizeListaEdificiPlessi" name="sizeListaEdificiPlessi" value="${sezione.sizeListaEdificiPlessi}"/>
		<input type="hidden" id="listaCodiciEdificiPlessi" name="listaCodiciEdificiPlessi" value="${sezione.listaCodiciEdificiPlessi}"/>
		<input type="hidden" id="idSezione" name="idSezione" value="${sezione.idSezione}"/>
		<input type="hidden" id="codForteScu" name="codForteScu" value="${sezione.codiceForteScuola}"/>
		<input type="hidden" id="codQuest" name="codQuest" value="${codQuest}"/>	
			
	</form>

</div><!-- chiusura div principale -->
