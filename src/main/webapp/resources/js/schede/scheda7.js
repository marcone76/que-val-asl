$( document ).ready(function() {
	 $(window).scrollTop(0);
	
	 $('input').click(function(){
			var name=$(this).attr('name');
			$( 'input[name='+name+']' ).removeClass( "validationError" );
			
		});
});


	
