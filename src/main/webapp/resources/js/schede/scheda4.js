$( document ).ready(function() {

	$(window).scrollTop(0);

	$('input').click(function(){
		var name=$(this).attr('name');
		$( 'input[name='+name+']' ).removeClass( "validationError" );
	});	

	var arrayInitToClose = ["44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60","61","62","63","64","65","66"];
	svuota(arrayInitToClose);

	var arrayToOpen = ["44","45","48","51","54","57","60","63"];
	var arrayRadioDecheck = ["45","47","48","50","51","53","54","56","57","59","60","62","63","66"];
	var arraySvuotaText = ["46","49","52","55","58","61","64","65"];

	checkEApriSI('43',arrayToOpen);
	apriInizio(arrayToOpen,arrayInitToClose,arrayRadioDecheck,arraySvuotaText,'43');

	var arrayNew = ["46","47"];
	checkEApriSI('45',arrayNew);
	chiamaClik('45', '45_165', arrayNew);

	var arrayNew1 = ["49","50"];
	checkEApriSI('48',arrayNew1);
	chiamaClik('48', '48_165', arrayNew1);

	var arrayNew2 = ["52","53"];
	checkEApriSI('51',arrayNew2);
	chiamaClik('51', '51_165', arrayNew2);

	var arrayNew3 = ["55","56"];
	checkEApriSI('54',arrayNew3);
	chiamaClik('54', '54_165', arrayNew3);

	var arrayNew4 = ["58","59"];
	checkEApriSI('57',arrayNew4);
	chiamaClik('57', '57_165', arrayNew4);

	var arrayNew5 = ["61","62"];
	checkEApriSI('60',arrayNew5);
	chiamaClik('60', '60_165', arrayNew5);

	var arrayNew6 = ["64","65","66"];
	checkEApriSI('63',arrayNew6);
	chiamaClik('63', '63_165', arrayNew6);


});