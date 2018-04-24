$( document ).ready(function() {
	 $(window).scrollTop(0);
	 $("#1003").hide();//id domanda da nascondere
	
	$('input[name=DOM_1002]').click(function () {// name del gruppo di radio o check
		if(  $('#1002_801').is(':checked') || $('#1002_802').is(':checked')){
			$("#1003").show('slow');//id domanda
		}else{
			$("#1003").hide('slow');
			$('input[name=DOM_1003]').val('');
		}
});
	
	
	if ($('input[name="DOM_1002"]:checked').length > 0) {
		$('#1003').show(velocita);
	}
	
	$('input').click(function(){
		var name=$(this).attr('name');
		$( 'input[name='+name+']' ).removeClass( "validationError" );
	});
	
});


	
