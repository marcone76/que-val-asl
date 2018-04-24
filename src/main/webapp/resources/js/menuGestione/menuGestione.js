//gestione campione



 $("#campioneButton").click(function(){
    	if( $('#infanzia').not(':checked').length && $('#primaria').not(':checked').length && $('#secondaria1').not(':checked').length
    			 && $('#secondaria2').not(':checked').length && $('#comprensivo').not(':checked').length && $('#territoriale').not(':checked').length && $('#tutti').not(':checked').length){
        //$("#myModal").modal();
   	 window.confirm('Attenzione, almeno un checkbox obbligatorio di ordine scuola');

        return false;
    	}
    	else
    		 window.confirm('Campionamento Salvato');

    		//$("#myModal2").modal();
    	return true;

    });
	

	
	$('#publicazioneFltrButton').click(function() {
       // $("#modalFiltri").modal();
        

		if ( window.confirm('Sei sicuro di voler pubblicare con i filtri?')){

			if ( window.confirm('Publicazione con filtri effettuata con successo'))
			{
			return true;
			}
		else {
			return true;
		}
	}

		else {
			return false;

		}

		 
		});
	
	$('#publicazioneNoFltrButton').click(function() {
       // $("#modalNoFiltri").modal();


		if ( window.confirm('Sei sicuro di voler pubblicare senza i filtri?')){

			if ( window.confirm('Publicazione senza filtri effettuata con successo'))
				{
				return true;
				}
			else {
				return true;
			}
		}

		else {
			return false;

		}
	 
	 
	});
	
	
	//gestione domande
	function urlGestioneDomande(){
		var dataStoricizzazione = $('#dataStoricizzazione').val();  
	    var url= '/oss-scu-dig-web/#approvaRilevazione';
	    $(".link").attr('href', url);
}
	
	//gestione storicizzazione
	function urlStoricizzazione(){
		var dataStoricizzazione = $('#dataStoricizzazione').val();  
	    var url= '/oss-scu-dig-web/#confermaDataStoricizzazione?breadcrumbTitle=confermaDataStoricizzazione&subItem=y&dataStoricizzazione='+dataStoricizzazione;
	    $(".link").attr('href', url);
}
	
	  $( function() {
		    $( "#dataStoricizzazione" ).datepicker(
		    		{
		    			autoclose: true,
		    		    format: 'dd/mm/yyyy',
		    		    	language: 'it'
		    		});
		  } );

	  
//gestione records
	  function urlInserisciFiltro(){
	  	    var codicedomanda = $('#codicedomanda').val(); 
	  		var limiteMinimo = $('#limiteMinimo').val(); 
	  		var limiteMassimo = $('#limiteMassimo').val(); 	
	  		var id = $('#idRil').val(); 
	  		var codQuest = $('#codiceQuestionario').val(); 
	  	    var url= '/oss-scu-dig-web/#applicaFiltri?codicedomanda='+codicedomanda+'&limiteMinimo='+limiteMinimo+'&limiteMassimo='+limiteMassimo+'&id='+id+'&codQuest='+codQuest;
	  	    $(".link").attr('href', url);
	  }
	

		$('#applicaFiltriButton').click(function() {
	       // $("#modalNoFiltri").modal();
			var limiteMinimo = $('#limiteMinimo').val(); 
	  		var limiteMassimo = $('#limiteMassimo').val(); 	
if (limiteMinimo == null || limiteMinimo == undefined || limiteMinimo == '' || limiteMassimo == null || limiteMassimo == undefined || limiteMassimo == '' ){
	

			if ( window.confirm('Se i filtri non vengono valorizzati verra` inserito il valore 0 di default, continuare?')){

				if ( window.confirm('Filtri applicati con successo'))
					{
					return true;
					}
				else {
					return true;
				}
			}

			else {
				return false;

			}
}

else {
	 window.confirm('Filtri applicati con successo');
	
	return true;

}
	
		 
		});
		