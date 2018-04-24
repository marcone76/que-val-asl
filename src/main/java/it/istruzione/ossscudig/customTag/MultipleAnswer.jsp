<%@ include file="../../includes/taglib.jsp"%>
<%@ include file="../../includes/breadcrumb.jsp"%>
<%@ taglib prefix="risp" uri="../../../tld/RispostaTag.tld"%>
<script type="text/javascript" src="<spring:url value="/static/js/gestioneRilevazione/dettaglioRilevazione.js" />"></script>
<%@ include file="../../pages/validation.jsp" %>	
<div>
	<h3>ACQUISIZIONE RILEVAZIONE</h3>
<div>

<div class="content-frame m-b-2">
		<fieldset>

	<form:form id="connettivitaForm" name="reg-form" action="salvaConnettivita" method="post" class="no_ajax hide-btn" modelAttribute="connettivitaForm">
	
				
			<div class="row">
				<div class="col-md-6">
					<label for="comuneNascita">Quante utenze contrattuali per la connettività a Internet sono attivate presso l'istituzione scolastica?</label>
				</div>
				<div class="col-md-6">	
					<form:input type="text" path="numeroUtenze" id="numeroUtenze" value="" class="form-control" aria-label="comuneNascita" tabindex="10" maxlength="2"/>
					<form:errors path="numeroUtenze" cssClass="error" />
				</div>
			</div>
			
			<div class='col-lg-8 col-lg-offset-2'>
        		<hr style="height : 1px; background-color:black;">
       		</div>
			
			
			<div class="row">
				<div class="col-md-6">
						<div class="form-group">
							<label class="control-label">Esistono contratti diversi per la connettività dedicata ai servizi di segreteria amministrativa e per la connettività dedicata alla didattica?</label>
						</div>
				</div>
				<div class="col-md-6">	
					<div class="inputbg-frame">
						<label for="search-type-name" class="radio-inline width-1-3">
							<form:radiobutton id="search-type-name" onclick="setPanelFilter()" value="SI" aria-label="Ricerca per nome e cognome" data-switch-input="switch-name" tabindex="10" checked="checked" path="tipoRicerca" /><span>Sì</span>
						</label>
						<label for="search-type-username" class="radio-inline width-1-3">
							<form:radiobutton id="search-type-name" onclick="setPanelFilter()" value="NO" aria-label="Ricerca per username" data-switch-input="switch-username" tabindex="20" path="tipoRicerca" /><span>No</span>
						</label>
					</div>
				</div>
			</div>
			
			
			
			<div class='col-lg-8 col-lg-offset-2'>
        		<hr style="height : 1px; background-color:black;">
       		</div>
       		
       		<div class="row">
				<div class="col-md-6">
					<label for="comuneNascita">Indicare gli intestatari delle utenze per la connettività a Internet: (Indicare anche più di una voce se la situazione è mista)</label>
				</div>
				<div class="col-md-6">	
					<form:input type="text" path="intestatari" id="intestatari" value="" class="form-control" aria-label="intestatari" tabindex="10" maxlength="2"/>
					<form:errors path="intestatari" cssClass="error" />
				</div>
			</div>
			
			
			<div class='col-lg-12'>
        		<hr style="height : 1px; background-color:black;">
       		</div>
       		
       					
			<!-- for sulle domande -->
			
			<div class="row">
				<div class="col-md-6">
					<label for="comuneNascita">Prendo da oggetto domanda</label>
				</div>
				<div class="col-md-6">	
					
					<risp:Risposta tipoDomanda="1"  gruppoVoce="5"/>


					<form:errors path="intestatari" cssClass="error" />
				</div>
			</div>
			
			
			
			<!-- chiudi for sulle domande -->
			
</div>

				
				
				
					
				
				
				
	<button type="submit" class="btn btn-block submit-btn" aria-label="Salva" tabindex="50">Salva</button>


	</form:form>


		<fieldset>
		
</div>




			<div id="form-block-error" class="hidden">
				<p>Si sono verificati degli errori nei seguenti campi:</p>
				<div id="resume-errors"></div>
				<p>Per favore ricontrolla i campi del modulo</p>
			</div>

		</div>

		<p class="text-left msg-required">I campi con asterisco (<strong>*</strong>) sono obbligatori</p>
		
				

	</div>			
				
				
				
</div>				
				
				

