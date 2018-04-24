$( document ).ready(function() {
	 $(window).scrollTop(0);
	 
	 $('input').click(function(){
			var name=$(this).attr('name');
			$( 'input[name='+name+']' ).removeClass( "validationError" );
		});	
	 
	 if(document.getElementById('142_690').checked) {
		    $("#143").show();
		} else {
		    $("#143").hide();
		}
	 
	 
			//CHECKBOX
			$('input[id=142_690]').click(function () {
				
				var values = $("input[id=142_690]:checked").map(function(){
					return $(this).val();
				}).get();
				
				if (values.length == 0) {
					$("#143").hide('slow');
				} else {
					$('input[name=DOM_143]').val('');
					$("#143").show('slow');
				}
			});
		
});


	
