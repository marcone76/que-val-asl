$( document ).ready(function()
{
	$(window).scrollTop(0);
	
	$('input').click(function(){
		$( 'input' ).removeClass( "validationError" );
	});
	
	var arrayInitToClose = ["534"];
	svuota(arrayInitToClose);
	
	var arrayToOpen = ["534"];
	checkEApriSIByRadio(arrayToOpen);
	
	$('input[name=DOM_533]').click(function () {
		console.log('dentro clik');
		if ($('#533_789').is(':checked')
			||$('#533_790').is(':checked')
			||$('#533_791').is(':checked')
			||$('#533_792').is(':checked')
			||$('#533_793').is(':checked'))
			{
				$('#534').show(velocita);
			} else {
				$('#534').hide(velocita);
				$('#534999').val('');
			}
	});
	
	function checkEApriSIByRadio(arrayToOpen) {
		if ($('input[name=DOM_533]').is(':radio') && (
				$('#533_789').is(':checked')
				||$('#533_790').is(':checked')
				||$('#533_791').is(':checked')
				||$('#533_792').is(':checked')
				||$('#533_793').is(':checked')))
		{
			apriSI(arrayToOpen);
		}
	}
	
});


	
