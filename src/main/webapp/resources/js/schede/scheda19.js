	$( document ).ready(function() {
		
		$(window).scrollTop(0);
		
		
		
		var arrayInitToClose = ["367","368"];
		 svuotaCheck(arrayInitToClose);
		 
		chiamaClikCheck( "367_759", "368");
			
			
		 if(document.getElementById('367_759').checked) {
			    $("#368").show();
			} else {
			    $("#368").hide();
			}
		
		 if ($('input[name=DOM_366]:checked').val()=="165") {
		  }else{
			  $("#367").hide('slow');//id domanda		
			  $("#368").hide('slow');
			  $("#368").val('');
			 /* $('#367_756').prop('checked', false);
			  $('#367_757').prop('checked', false);
			  $('#367_758').prop('checked', false);
			  $('#367_759').prop('checked', false);*/
			  $(':checkbox').removeAttr('checked').removeAttr('selected');

		  }
		
		

		//RADIO va bene anche per i se sì
			$('input[name=DOM_366]').click(function () {// name del gruppo di radio o check
				console.log('entrato nella function');
				if (this.id == "366_165") {//id domanda + id voce
					$("#367").show('slow');//id domanda			
				}
				else {
				
					 $("#367").hide('slow');//id domanda		
						$("#368").hide('slow');
						$("#368").val('');
					  $('#367_756').prop('checked', false);
					  $('#367_757').prop('checked', false);
					  $('#367_758').prop('checked', false);
					  $('#367_759').prop('checked', false);
				}
			});
			 
		 
	
		
			  
			  
			$('input').click(function(){
				var name=$(this).attr('name');
				$( 'input[name='+name+']' ).removeClass( "validationError" );
				
			});
			
});


	
