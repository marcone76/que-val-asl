$( document ).ready(function() {
	 $(window).scrollTop(0);

	 $('input').click(function(){
			var name=$(this).attr('name');
			$( 'input[name='+name+']' ).removeClass( "validationError" );
		});
	 
	 $("#265").hide();//id domanda da nascondere
	
	 //chiamaClikCheck(264_32,265);
	 
	 if(document.getElementById('264_32').checked) {
		    $("#265").show();
		} else {
		    $("#265").hide();
		}
	 
	 
	//CHECKBOX
	$('input[id=264_32]').click(function () {
		
		var values = $("input[id=264_32]:checked").map(function(){
			return $(this).val();
		}).get();
		
		if (values.length == 0) {
			$("#265").hide('slow');

		} else {
			$('input[name=DOM_265]').val('');
			$("#265").show('slow');

		}
	});
	
	var idDmd="266";
    var idDmdOpen="267";
    var arr = ["267"];
	svuota(arr);
	var arrayToOpen = ['267'];
	var arrayToClose = ['267'];	
	var arrayRadioDecheck = ['267'];
	var arraySvuotaText = [];
	
	checkEApriSI(idDmd,arrayToOpen);
	

	apriInizio(arrayToOpen,arrayToClose,arrayRadioDecheck,arraySvuotaText,idDmd);

	
});


	
