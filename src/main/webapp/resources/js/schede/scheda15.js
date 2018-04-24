$( document ).ready(function() {
	 $(window).scrollTop(0);

	 $('input').click(function(){
			var name=$(this).attr('name');
			$( 'input[name='+name+']' ).removeClass( "validationError" );
		});
	 
	 
	 if(document.getElementById('262_726').checked) {
		    $("#263").show();
		} else {
		    $("#263").hide();
		}
	 
	//CHECKBOX
	$('input[id=262_726]').click(function () {
		
		var values = $("input[id=262_726]:checked").map(function(){
			return $(this).val();
		}).get();
		
		if (values.length == 0) {
			$("#263").hide('slow');
		} else {
			$('input[name=DOM_263]').val('');
			$("#263").show('slow');
		}
	});
	
	
});


	
