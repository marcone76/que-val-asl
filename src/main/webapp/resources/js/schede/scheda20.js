	$( document ).ready(function() {
		$(window).scrollTop(0);
		$('input').click(function(){
			var name=$(this).attr('name');
			$( 'input[name='+name+']' ).removeClass( "validationError" );
		});
		
		//gestione ripetizioni
		var arrayInitToClose = [];
		var arrayToOpen1 = []; 
		var arrayToOpenCheck = []; 
		
		var arrayToOpen2 = []; 
		var arrayToOpenCheck2 = []; 
		
		var arrayToOpen3 = []; 
		var arrayToOpenCheck3 = []; 
		
		
		
		$( '.codEdi' ).each(function( index, value ) {
			  if($(value).attr('id') == '501999'){
				  
						  console.log( $(value).val() );
						  //tutti gli elementi che si devono arire
						  arrayInitToClose.push("503"+$(value).val());
						  arrayInitToClose.push("504"+$(value).val());
						  arrayInitToClose.push("1610"+$(value).val());
						  arrayInitToClose.push("1611"+$(value).val());
						  arrayInitToClose.push("1612"+$(value).val());
						  arrayInitToClose.push("1613"+$(value).val());

						  arrayToOpen1.push("503"+$(value).val());
						 // arrayToOpen1.push("504"+$(value).val());
						  arrayToOpen1.push("1610"+$(value).val());
						  arrayToOpen1.push("1611"+$(value).val());
						  arrayToOpen1.push("1612"+$(value).val());

						 // arrayInitToClose.push("1612"+$(value).val());

						  //il radio si dentro 
						  arrayToOpenCheck.push('#502_165_COD_EDI_'+$(value).val());
						  
						  //129 è quello che si apre sotto,simil altro
						  arrayToOpen2.push("1613"+$(value).val());
						  //128_165 radio button che apre quello di sopra
						  arrayToOpenCheck2.push('#1612_10_COD_EDI_'+$(value).val());
						  arrayToOpenCheck2.push('#1612_9_COD_EDI_'+$(value).val());

						  arrayToOpen3.push("504"+$(value).val());
						  arrayToOpenCheck3.push('#503_771');
						  
						$('input[name=DOM_502_COD_EDI_'+$(value).val()+']').click(function () {// name del gruppo di radio o check
						if (this.id == "502_165_COD_EDI_"+$(value).val()) {//   502_165_COD_EDI_0840111577
							$("#503"+$(value).val()).show('slow');
							//$("#504"+$(value).val()).show('slow');
							$("#1610"+$(value).val()).show('slow');
							$("#1611"+$(value).val()).show('slow');
							$("#1612"+$(value).val()).show('slow');

						} else {
							$("#503"+$(value).val()).hide('slow');
							$("#504"+$(value).val()).hide('slow');
							$("#1610"+$(value).val()).hide('slow');
							$("#1611"+$(value).val()).hide('slow');
							$("#1612"+$(value).val()).hide('slow');
							$("#1613"+$(value).val()).hide('slow');


							//svuoto tutti i radio e campi testo che si erano aperti
								$('input[name=DOM_503_COD_EDI_'+$(value).val() + ']').prop('checked',false);
								$('input[name=DOM_504_COD_EDI_'+$(value).val() + ']').val('');
								$('input[name=DOM_1610_COD_EDI_'+$(value).val() + ']').prop('checked',false);
								$('input[name=DOM_1611_COD_EDI_'+$(value).val() + ']').val('');
								$('input[name=DOM_1612_COD_EDI_'+$(value).val() + ']').prop('checked',false);
								$('input[name=DOM_1613_COD_EDI_'+$(value).val() + ']').prop('checked',false);

						}
						
					});
						
					$('input[name=DOM_1612_COD_EDI_'+$(value).val()+']').click(function () {// name del gruppo di radio o check	
						if (this.id == "1612_10_COD_EDI_"+$(value).val() || this.id == "1612_9_COD_EDI_"+$(value).val()) {//   502_165_COD_EDI_0840111577
							$("#1613"+$(value).val()).show('slow');
						} else {
							$("#1613"+$(value).val()).hide('slow');
							$('input[name=DOM_1613_COD_EDI_'+$(value).val() + ']').prop('checked',false);
						}
					});	
					
					//CHECKBOX
					$('input[name=DOM_503_COD_EDI_'+$(value).val()+']').click(function () {
						
						var values = $('input[id=503_771]:checked').map(function(){
							return $(this).val();
						}).get();
						
						if (values.length == 0) {
							$("#504"+$(value).val()).hide('slow');
							$('input[name=DOM_504_COD_EDI_'+$(value).val() + ']').val('');
						} else {
							
							$("#504"+$(value).val()).show('slow');

						}
					});
					
				
			  }
			  
			});

svuota(arrayInitToClose);


apriSIPlessiEdifici(arrayToOpen1,arrayToOpenCheck);
apriSIPlessiEdifici(arrayToOpen2,arrayToOpenCheck2);
apriSIPlessiEdifici(arrayToOpen3,arrayToOpenCheck3);

		
/*if(document.getElementById('503_771').checked) {
    $("#504").hide();
} else {
	 $("#504").show();

}*/



});


	
