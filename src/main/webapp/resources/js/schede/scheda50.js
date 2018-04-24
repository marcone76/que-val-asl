$( document ).ready(function()
{
	$(window).scrollTop(0);
	
	$('input').click(function(){
		var name=$(this).attr('name');
		$( 'input[name='+name+']' ).removeClass( "validationError" );
	});
	
	var arrayInitToClose = ["1011"];
	svuota(arrayInitToClose);
	
	var arrayToOpen = ["1011"];
	var arrayToClose = ["1011"];

	var arrayRadioDecheck = [];
	var arrayRadioDecheck2 = [];
	var arraySvuotaText = ["1011"];


	var idDmd = '1010';
	
		
	checkEApriSI(idDmd,arrayToOpen);

	
	apriInizio(arrayToOpen,arrayToClose,arrayRadioDecheck,arraySvuotaText,idDmd);

	
});

	
