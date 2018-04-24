var velocita = 'slow';

	function chiamaClik(gruppo, id, array){
		$('input[name=DOM_'+gruppo+']').click(function () {
			if (this.id == id) {
				for( i =0; i<array.length; i++){
					$('#'+array[i]).show(velocita);
					}
			} else {
				for( i =0; i<array.length; i++)
				{
					if($('input[name=DOM_'+array[i]+']').is(':radio'))
					{
						$('input[name=DOM_'+array[i]+']').prop('checked', false);
					}
					else if($('input[name=DOM_'+array[i]+']').is(':text'))
					{
						$('input[name=DOM_'+array[i]+']').val('');
					}
					else if($('input[name=DOM_'+array[i]+']').is(':checkbox'))
					{
						$('input[name=DOM_'+array[i]+']').prop('checked', false);
					}
					$('#'+array[i]).hide(velocita);
				}
			}
		});
	}
	
	function svuota(arrayInitToClose){
		for(i =0; i<arrayInitToClose.length; i++){			
			$('#'+arrayInitToClose[i]).hide();	

		}
	}
	
	
	
	function svuotaCheck(arrayInitToClose){
		for( i =0; i<arrayInitToClose.length; i++){
			if(! $('input[name=DOM_'+arrayInitToClose[i]+']').val().length > 0){
				$('#'+arrayInitToClose[i]).hide();
				}	
		}
	}
	
	function svuotaRadio(arrayRadioInitToClose){
		for( i =0; i<arrayInitToClose.length; i++){
			if (this.id == idDmd) {
				$('#'+idDmdOpen).show(velocita);
			} else {
				$('#'+idDmdOpen).hide(velocita);

			}
		}
	}
	
	function apriInizio(arrayToOpen,arrayInitToClose,arrayRadioDecheck,arraySvuotaText,idDmd){
		$('input[name=DOM_'+idDmd+']').click(function () {
			if (this.id == idDmd+"_165") {       
				for( i =0; i<arrayToOpen.length; i++){
					$('#'+arrayToOpen[i]).show(velocita);
					}
			} else {
				for( i =0; i<arrayInitToClose.length; i++){
					$('#'+arrayInitToClose[i]).hide(velocita);
					}
				for( i =0; i<arrayRadioDecheck.length; i++){
					$('input[name=DOM_'+arrayRadioDecheck[i]+']').prop('checked', false);
					}	
				for( i =0; i<arraySvuotaText.length; i++){
					$('input[name=DOM_'+arraySvuotaText[i]+']').val('');
					}	
			}
		});
	}
	
	function apriSI(arrayToOpen)
	{
		for( i =0; i<arrayToOpen.length; i++){
			$('#'+arrayToOpen[i]).show(velocita);
		}
	}
	
	function checkEApriSI(idDmd,arrayToOpen){
		if ( 
			$('input[name=DOM_'+idDmd+']').is(':radio') && $('#'+idDmd+'_165').is(':checked')
			|| $('input[name=DOM_'+idDmd+']').is(':text') && $('input[name=DOM_'+idDmd+']').val().length>0){
			apriSI(arrayToOpen)
		}
	}
	
	function ApriSI(idDmd,arrayToOpen){
		if ($('input[id='+idDmd+']:checked').val()){
			apriSI(arrayToOpen)
		}
	}
	
	function apriText(idDmd,arrayToOpen){
		if ( 
			   $('input[name=DOM_'+idDmd+']').val() != ''){
			apriSI(arrayToOpen)
		}
	}
	
	function apriSingolo(idDmd,idDmdOpen){

		$('input[name=DOM_'+idDmd+']').click(function () {
			if (this.id == idDmd+'_165') {
					$('#'+idDmdOpen).show(velocita);
			} else {
					$('#'+idDmdOpen).hide(velocita);
					$('input[name=DOM_'+idDmdOpen+']').val('');
			}
		});
	}
	
	function apriSingoloCheck(idDmd,idDmdOpen){

		$('input[name=DOM_'+idDmd+']').click(function () {
			if (this.id == idDmd+'_165') {
					$('#'+idDmdOpen).show(velocita);
			} else {
					$('#'+idDmdOpen).hide(velocita);
					$('input[name=DOM_'+idDmdOpen+']').prop('checked',false);
			}
		});
	}
	
//	function chiamaOn(gruppo, id, array){
//		$('input[name='+gruppo+']').click(function () {
//			console.log('dentro clik');
//			if (this.id == id) {
//				for( i =0; i<array.length; i++){
//					$('#'+array[i]).show(velocita);
//					}
//			} else {
//				for( i =0; i<array.length; i++){
//					$('#'+array[i]).hide(velocita);
//					$('input[name='+array[i]+']').val('')  ;
//					}
//			}
//		});
//	}
	
	function chiamaClikCheck( idC, array){
		$('input[id='+idC+']').click(function () {				
				var values = $('input[id='+idC+']:checked').map(function(){
					return $(this).val();
				}).get();				
				if (values.length == 0) {
					console.log('hide');
					$('#'+array).val('');
					$('#'+array).prop('checked', false);
					$('#'+array).hide(velocita);
				} else {
					console.log('show');
					$('input[name=DOM_'+array+']').val('');		
					$('#'+array).prop('checked', false);
					$('#'+array).show(velocita);
				}
			});

		}
		
		function radioDececk (arrayRadioDecheck){
		for( i =0; i<arrayRadioDecheck.length; i++){
			$( 'input[name=DOM_'+arrayRadioDecheck[i]+']'   ).prop('checked', false);
			}
		
		}

		function apriSIPlessiEdifici (arrayToOpen,arrayToOpenCheck){
				for( i =0; i<arrayToOpenCheck.length; i++){
					if (	$(arrayToOpenCheck[i]).is(':checked')  ){
						for( i2 =0; i2<arrayToOpen.length; i2++){
							$('#'+arrayToOpen[i2]).show(velocita);
						}
					}
				}
		}
		
		
		
		