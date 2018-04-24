$( document ).ready(function()
{
	$(window).scrollTop(0);
	
	$('input').click(function(){
		var name=$(this).attr('name');
		$( 'input[name='+name+']' ).removeClass( "validationError" );
	});
	
	var arrayInitToClose = ['178','181'];
	svuota(arrayInitToClose);
	
	var arrayToOpen = ['178'];
	var arrayToClose = ['178'];
	var arrayRadioDecheck = ['178'];
	var arraySvuotaText = [];
	
	var idDmd = '177';
	
	checkEApriSI(idDmd,arrayToOpen);
	apriInizio(arrayToOpen,arrayToClose,arrayRadioDecheck,arraySvuotaText,idDmd);
	
	if($('#180_712').is(':checked') || $('#180_713').is('checked'))
		apriSI(["181"]);
	
	$('input[name=DOM_'+180+']').click(function () {
		console.log('dentro clik');
		if (this.id == '180_712' || this.id == '180_713') {
				$('#181').show(velocita);
			} else {
				$('#181').hide(velocita);
				$('#181_805').prop('checked',false)
				$('#181_806').prop('checked',false)
				$('#181_807').prop('checked',false)
				$('#181_810').prop('checked',false)
			}
	});

});


	
