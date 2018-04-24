$( document ).ready(function() {
	 $(window).scrollTop(0);
	 
	 $('input').click(function(){
			var name=$(this).attr('name');
			$( 'input[name='+name+']' ).removeClass( "validationError" );
		});
	 
	/* $('input[name=DOM_236]').on('input',function(e){
		 if($('input[name=DOM_236]').val()){
		    	console.log('dentro if');
		    	$('#237').show(velocita);
		    }
		 else{
			 $('input[name=DOM_237]').val('');
			 $('#237').hide(velocita);
		 }
	});*/
	 
	 
	 
	var arrayToClose1 = ["271","272","273","276","277","278","281","282","283","286","287","288","292", "293", "294", "297", "298", "299", "302", "303", "304", "307", "308", "309", "313", "314", "315","316", "319", "320","321","322", "325","326","327","328", "331", "332","333","334"];
	svuota(arrayToClose1);
	
	
	/* svuota tutti i campi testo */
	var arraySvuotaText = ["245", "246", "247", "248", "249", "251", "252","253", "254", "255", "257", "258", "259", "260", "261"];
	
	
//	 $("#292").hide();//id domanda da nascondere
//	
//	//CHECKBOX
//	$('input[name=DOM_291]').text(function () {
//		
//		var values = $("input[name=DOM_291]").map(function(){
//			return $(this).val();
//		}).get();
//		
//		if (values.length == 0) {
//			$("#292").hide('slow');
//		} else {
//			$("#292").show('slow');
//		}
//	});
/*	
	$("#291").bind("change paste keyup", function() {
	       alert($(this).val()); 
	    });*/
	
/*	apriInizioNew(arrayToOpen,arrayInitToClose,arrayRadioDecheck,arraySvuotaText);

	var array335 = ["336","337","441","342","347","353","348","354"];	chiamaClik('335', '335_165', array335); */	
	
	/*	var arrayToClose = ["336","337","441","342","347","353","348","354"];;	
	var arrayToOpen = ["336","337","441","342","347","353","348","354"];
    var arrayRadioDecheck = ["336","337", "338", "339", "340","341", "342", "343","344","345","346","347", "348", "349", "350","351", "352", "353", "354","355", "356", "357", "358","441"];
var idDmd4='335';

ApriSI('335_165',arrayToOpen);
var arrayToClose2 = ["336","337", "338", "339", "340","341", "342", "343","344","345","346","347", "348", "349", "350","351", "352", "353", "354","355", "356", "357", "358","441"];

var arraySvuotaText1 = ["336","337", "338", "339", "340","341", "342", "343","344","345","346","347", "348", "349", "350","351", "352", "353", "354","355", "356", "357", "358","441"];

    apriInizio(arrayToOpen,arrayToClose2,arrayRadioDecheck,arraySvuotaText1,idDmd4);
*/
    var array270 = ["271","272","273"];

	apriText('270',array270);

	$('input[name=DOM_270]').on('input',function(e){
		 if($('input[name=DOM_270]').val()){
		    	console.log('dentro if');
		    	$('#271').show(velocita);
		    	$('#272').show(velocita);
		    	$('#273').show(velocita);

		    }
		 else{
			 $( 'input[name=DOM_271]').prop('checked', false);
			 $('input[name=DOM_272]').val('');
			 $('input[name=DOM_273]').val('');
			 $('#271').hide(velocita);
		    	$('#272').hide(velocita);
		    	$('#273').hide(velocita);
		 }
		 
	});
	
    var array275 = ["276","277","278"];

	apriText('275',array275);

	$('input[name=DOM_275]').on('input',function(e){
		 if($('input[name=DOM_275]').val()){
		    	console.log('dentro if');
		    	$('#276').show(velocita);
		    	$('#277').show(velocita);
		    	$('#278').show(velocita);

		    }
		 else{
			 $( 'input[name=DOM_276]').prop('checked', false);
			 $('input[name=DOM_277]').val('');
			 $('input[name=DOM_278]').val('');
			 $('#276').hide(velocita);
		    	$('#277').hide(velocita);
		    	$('#278').hide(velocita);
		 }
		 
	});
	
	  var array280 = ["281","282","283"];

		apriText('280',array280);

		$('input[name=DOM_280]').on('input',function(e){
			 if($('input[name=DOM_280]').val()){
			    	console.log('dentro if');
			    	$('#281').show(velocita);
			    	$('#282').show(velocita);
			    	$('#283').show(velocita);

			    }
			 else{
				 $( 'input[name=DOM_281]').prop('checked', false);
				 $('input[name=DOM_282]').val('');
				 $('input[name=DOM_283]').val('');
				 $('#281').hide(velocita);
			    	$('#282').hide(velocita);
			    	$('#283').hide(velocita);
			 }
			 
		});
		
		var array285 = ["286","287","288"];

		apriText('285',array285);

		$('input[name=DOM_285]').on('input',function(e){
			 if($('input[name=DOM_285]').val()){
			    	console.log('dentro if');
			    	$('#286').show(velocita);
			    	$('#287').show(velocita);
			    	$('#288').show(velocita);

			    }
			 else{
				 $( 'input[name=DOM_286]').prop('checked', false);
				 $('input[name=DOM_287]').val('');
				 $('input[name=DOM_288]').val('');
				 $('#286').hide(velocita);
			    	$('#287').hide(velocita);
			    	$('#288').hide(velocita);
			 }
			 
		});
    
	var array291 = ["292","293","294"];

	apriText('291',array291);

	$('input[name=DOM_291]').on('input',function(e){
		 if($('input[name=DOM_291]').val()){
		    	console.log('dentro if');
		    	$('#292').show(velocita);
		    	$('#293').show(velocita);
		    	$('#294').show(velocita);

		    }
		 else{
			 $( 'input[name=DOM_292]').prop('checked', false);
			 $('input[name=DOM_293]').val('');
			 $('input[name=DOM_294]').val('');
			 $('#292').hide(velocita);
		    	$('#293').hide(velocita);
		    	$('#294').hide(velocita);
		 }
		 
	});
	
	
	var array296 = ["297","298","299"];
	apriText('296',array296);

	$('input[name=DOM_296]').on('input',function(e){
		 if($('input[name=DOM_296]').val()){
		    	console.log('dentro if');
		    	$('#297').show(velocita);
		    	$('#298').show(velocita);
		    	$('#299').show(velocita);
		    }
		 else{			 
		     $( 'input[name=DOM_297]').prop('checked', false);
			 $('input[name=DOM_298]').val('');
			$('input[name=DOM_299]').val('');
			 $('#297').hide(velocita);
		    	$('#298').hide(velocita);
		    	$('#299').hide(velocita);
		    	
		 }
		
	});
	
	var array301= ["302","303","304"];
	apriText('301',array301);
	 
	$('input[name=DOM_301]').on('input',function(e){
		 if($('input[name=DOM_301]').val()){
		    	console.log('dentro if');
		    	$('#302').show(velocita);
		    	$('#303').show(velocita);
		    	$('#304').show(velocita);

		    } else{
		    	 $( 'input[name=DOM_302]').prop('checked', false);
				 $('input[name=DOM_303]').val('');
				$('input[name=DOM_304]').val('');
				$('#302').hide(velocita);
			    	$('#303').hide(velocita);
			    	$('#304').hide(velocita);
			 }
	});
	
	var array306= ["307","308","309"];
	 apriText('306',array306);
	 
	 
	 
	$('input[name=DOM_306]').on('input',function(e){
		 if($('input[name=DOM_306]').val()){
		    	console.log('dentro if');
		    	$('#307').show(velocita);
		    	$('#308').show(velocita);
		    	$('#309').show(velocita);


		    }
		 else{
			 $( 'input[name=DOM_307]').prop('checked', false);
			 $('input[name=DOM_308]').val('');
			$('input[name=DOM_309]').val('');
			$('#307').hide(velocita);
		    	$('#308').hide(velocita);
		    	$('#309').hide(velocita);

		 }
	});
	
	var array312= ["313","314","315","316"];
	apriText('312',array312);
	$('input[name=DOM_312]').on('input',function(e){
		 if($('input[name=DOM_312]').val()){
		    	console.log('dentro if');
		    	$('#313').show(velocita);
		    	$('#314').show(velocita);
		    	$('#315').show(velocita);
		    	$('#316').show(velocita);

		    }
		 else{
			 $( 'input[name=DOM_313]').prop('checked', false);
			 $('input[name=DOM_314]').val('');
			$('input[name=DOM_315]').val('');
			$('input[name=DOM_316]').val('');
			$('#313').hide(velocita);
		    	$('#314').hide(velocita);
		    	$('#315').hide(velocita);
		    	$('#316').hide(velocita);

		 }
	});
	
	
	var array318= ["319","320","321","322"];
	apriText('318',array318);
	$('input[name=DOM_318]').on('input',function(e){
		 if($('input[name=DOM_318]').val()){
		    	console.log('dentro if');
		    	$('#319').show(velocita);
		    	$('#320').show(velocita);
		    	$('#321').show(velocita);
		    	$('#322').show(velocita);

		    }
		 else{
			 $( 'input[name=DOM_319]').prop('checked', false);
			 $('input[name=DOM_320]').val('');
			$('input[name=DOM_321]').val('');
			$('input[name=DOM_322]').val('');
			$('#319').hide(velocita);
		    	$('#320').hide(velocita);
		    	$('#321').hide(velocita);
		    	$('#322').hide(velocita);

		 }
	});
	
	var array324= ["325","326","327","328"];
	apriText('324',array324);
	$('input[name=DOM_324]').on('input',function(e){
		 if($('input[name=DOM_324]').val()){
		    	console.log('dentro if');
		    	$('#325').show(velocita);
		    	$('#326').show(velocita);
		    	$('#327').show(velocita);
		    	$('#328').show(velocita);

		    }
		 else{
			 $( 'input[name=DOM_325]').prop('checked', false);
			 $('input[name=DOM_326]').val('');
			$('input[name=DOM_327]').val('');
			$('input[name=DOM_328]').val('');
			$('#325').hide(velocita);
		    	$('#326').hide(velocita);
		    	$('#327').hide(velocita);
		    	$('#328').hide(velocita);

		 }
	});
	
	var array330= ["331","332","333","334"];
	apriText('330',array330);
	$('input[name=DOM_330]').on('input',function(e){
		 if($('input[name=DOM_330]').val()){
		    	console.log('dentro if');
		    	$('#331').show(velocita);
		    	$('#332').show(velocita);
		    	$('#333').show(velocita);
		    	$('#334').show(velocita);

		    }
		 else{
			 $( 'input[name=DOM_331]').prop('checked', false);
			 $('input[name=DOM_332]').val('');
			$('input[name=DOM_333]').val('');
			$('input[name=DOM_334]').val('');
			$('#331').hide(velocita);
		    	$('#332').hide(velocita);
		    	$('#333').hide(velocita);
		    	$('#334').hide(velocita);

		 }
	});
	
	
	
	
	
});



	



	
