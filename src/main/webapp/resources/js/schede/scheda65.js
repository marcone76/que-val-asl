$( document ).ready(function()
{
	$(window).scrollTop(0);
	
	$('input').click(function(){
		var name=$(this).attr('name');
		$( 'input[name='+name+']' ).removeClass( "validationError" );
	});
	
	
	var arrayInitToClose = ["1291"];
	svuota(arrayInitToClose);

	var arrayToOpen = ["1291"];
	var arrayRadioDecheck = ["1291"];
	var arraySvuotaText = ["1291"];

	checkEApriSI('1290',arrayToOpen);
	apriInizio(arrayToOpen,arrayInitToClose,arrayRadioDecheck,arraySvuotaText,'1290');
	
	/*var arrayInitToClose = ["1291"];
	svuota(arrayInitToClose);
	
	var arrayToOpen = ["1291"];
	var arrayToClose = ["1291"];

	var arrayRadioDecheck = [];
	var arrayRadioDecheck2 = [];
	var arraySvuotaText = ["1291"];


	var idDmd = '1290';
	
		
	checkEApriSI(idDmd,arrayToOpen);

	
	apriInizio(arrayToOpen,arrayToClose,arrayRadioDecheck,arraySvuotaText,idDmd);*/

	
});

	
