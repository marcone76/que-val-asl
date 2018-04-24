$( document ).ready(function() 
{
	$(window).scrollTop(0);
	
	$('input').click(function(){
		var name=$(this).attr('name');
		$( 'input[name='+name+']' ).removeClass( "validationError" );
	});
	
	var arrayInitToClose = ["170","171","172","174","175","176"];
	svuota(arrayInitToClose);
	
	var arrayToOpen = ["170","171","172"];
	var arrayToOpen2 = ["174","175","176"];
	var arrayToClose = ["170","171","172"];
	var arrayToClose2 = ["174","175","176"];

	var arrayRadioDecheck = [];
	var arrayRadioDecheck2 = [];
	var arraySvuotaText = ["170","171","172"];
	var arraySvuotaText2 = ["174","175","176"];

	var idDmd = '169';
	var idDmd2 = '173';
		
	checkEApriSI(idDmd,arrayToOpen);
	checkEApriSI(idDmd2,arrayToOpen2);
	
	apriInizio(arrayToOpen,arrayToClose,arrayRadioDecheck,arraySvuotaText,idDmd);
	apriInizio(arrayToOpen2,arrayToClose2,arrayRadioDecheck2,arraySvuotaText2,idDmd2);
	

});