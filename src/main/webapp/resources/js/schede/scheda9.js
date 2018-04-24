$( document ).ready(function() {
	 $(window).scrollTop(0);

	 $('input').click(function(){
			var name=$(this).attr('name');
			$( 'input[name='+name+']' ).removeClass( "validationError" );
		});
	 
	var arrayInitToClose = ["145","146","147","148","149","150","152"];
	svuota(arrayInitToClose);
	var arrayInitToClose144 = ["145","146","147","148","149","150"];	
	var arrayToOpen = ["145","146","147","148","149","150"];
	var arrayRadioDecheck = ["145","146","147","148","149","150"];
	var arraySvuotaText = [];

	
	var idDmd1='144';
	var idDmd2='151_707';
	var idDmdOpen = '152';
	

	ApriSI('144_165',arrayToOpen);
	
	apriInizio(arrayToOpen,arrayInitToClose144,arrayRadioDecheck,arraySvuotaText,idDmd1);
//	chiamaClikCheck("151_707","152");

	
	if(document.getElementById('151_707').checked) {
	    $("#152").show();
	} else {
	    $("#152").hide();
	}
 
	
	//CHECKBOX
	$('input[id=151_707]').click(function () {
		
		var values = $("input[id=151_707]:checked").map(function(){
			return $(this).val();
		}).get();
		
		if (values.length == 0) {
			$("#152").hide('slow');
		} else {
			$('input[name=DOM_152]').val('');
			$("#152").show('slow');
		}
	});
	
	// MODIFICA NEL CASO IN CUI E' UNA CHECKBOX 
	/*$('input[id=144_165]').click(function () {
		
		var valuesSi = $("input[id=144_165]:checked").map(function(){
			return $(this).val();
		}).get();
		
		if (valuesSi.length == 0) {
			$("#145").hide('slow');
			$("#146").hide('slow');
			$("#147").hide('slow');
			$("#148").hide('slow');
			$("#149").hide('slow');
			$("#150").hide('slow');
			$( 'input[id=144_165]'   ).prop('checked', false);
			} 
		else
			{
			checkboxDececk(arrayCheckboxDecheck);
			//radioDececk (arrayRadioDecheck);
			$( 'input[name=DOM_150]'   ).prop('checked', false);
			$("#145").show('slow');
			$("#146").show('slow');
			$("#147").show('slow');
			$("#148").show('slow');
			$("#149").show('slow');
			$("#150").show('slow');
			$( 'input[id=144_164]'   ).prop('checked', false); //giusta

		}
	});
	
	//esclusività checkbox NO
$('input[id=144_164]').click(function () {
		
		var valuesNO = $("input[id=144_164]:checked").map(function(){
			return $(this).val();
		}).get();
		if (valuesNO.length == 0) {
			$('input[name=DOM_263]').prop('checked', false);			
			$("#145").hide('slow');
			$("#146").hide('slow');
			$("#147").hide('slow');
			$("#148").hide('slow');
			$("#149").hide('slow');
			$("#150").hide('slow');
			$( 'input[id=144_165]'   ).prop('checked', false);

			} 
		else
			{
			$('input[name=DOM_146]').val('');			
			$("#145").hide('slow');
			$("#146").hide('slow');
			$("#147").hide('slow');
			$("#148").hide('slow');
			$("#149").hide('slow');
			$("#150").hide('slow');
			$( 'input[id=144_165]'   ).prop('checked', false);
			$('input[name=DOM_263]').val('');			
			}
	});*/
	
	
	
		
	
});


	
