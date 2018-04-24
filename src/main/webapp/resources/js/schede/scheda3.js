$( document ).ready(function() {
	 $(window).scrollTop(0);
	 
		if ($('input[name=DOM_34]:checked').val() == "165") {
			$("#35").show();
		}else{
			$("#35").hide();
		}
		
		if ($('input[name=DOM_35]:checked').val() == "165") {
			$("#36").show();
		}else{
			$("#36").hide();
		}
		if (   $('#36_865').is(":checked")  ) {//CHECKBOX
			$("#37").show();
		}else{
			$("#37").hide();
		}
		
		//RADIO va bene anche per i se sì
		$('input[name=DOM_34]').click(function () {// name del gruppo di radio o check
			if (this.id == "34_165") {//id domanda + id voce
				$("#35").show('slow');//id domanda
			} else {
				$("#35").hide('slow');//id domanda
				$("#36").hide('slow');
				$("#37").hide('slow');
				$('input[name=DOM_36]').prop('checked', false);
				$('input[name=DOM_35]').prop('checked', false);
				$('input[name=DOM_37]').val('');
			}
		});
		 
		//RADIO va bene anche per i se sì
		$('input[name=DOM_35]').click(function () {// name del gruppo di radio o check
			if (this.id == "35_165") {//id domanda + id voce
				$("#36").show('slow');//id domanda
			} else {
				$("#36").hide('slow');//id domanda
				$("#37").hide('slow');//id domanda
				$('input[name=DOM_36]').prop('checked', false);
				$('input[name=DOM_37]').val('');
			}
		});
		 
		//RADIO va bene anche per i se sì
		$('input[name=DOM_36]').click(function () {// name del gruppo di radio o check
				if(  $('#36_865').is(':checked')  ){
					$("#37").show('slow');//id domanda
				}else{
					$("#37").hide('slow');
					$('input[name=DOM_37]').val('');
				}
		});
		
		$('input').click(function(){
			var name=$(this).attr('name');
			$( 'input[name='+name+']' ).removeClass( "validationError" );
		});
		
		
});


	
