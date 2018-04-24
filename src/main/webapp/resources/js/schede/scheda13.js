$( document ).ready(function()
{
	$(window).scrollTop(0);
	
	$('input').click(function(){
		var name=$(this).attr('name');
		$( 'input[name='+name+']' ).removeClass( "validationError" );
	});
	
	var arrayInitToClose = ["183","184","185","186","187","188","189","190","191","192","193",
		"194","195","196","197","198","199","200","201","202","203","204","205","206","207",
		"208","209","210","211","212","213","214","215","216","217","218","219","220","221",
		"222","223","224","233","225","226","227","228","229","230","231","232","233","236","237","238","239","240","241"];
	
	svuota(arrayInitToClose);
	
	
	var idDmd='182';
	var arrayToOpen = ["183","193","203","213","223"];
	
	var arrayToClose = ["183","184","185","186","187","188","189","190","191","192","193","194","195","196","197","198","199","200","201","202","203",
						"204","205","206","207","208","209","210","211","212","213","214","215","216","217","218","219","220","221","222","223","224",
						"233","225","226","227","228","229","230","231","232"];
	
	var arrayRadioDecheck = ["183","185","186","187","188","189","190","191","192","193","195","196","197","198","199","200","201","202","203","205","206",
							"207","208","209","210","211","212","213","215","216","217","218","219","220","221","222","223","233","226","227","228",
							"229","230","231","232"];
	
	var arraySvuotaText = ["184","194","204","214","224","225"];
	
	
	checkEApriSI(idDmd,arrayToOpen);
	apriInizio(arrayToOpen,arrayToClose,arrayRadioDecheck,arraySvuotaText,idDmd);
	
	
	var array11 = ["184","185","186","187","188","189","190","191","192"];
	checkEApriSI('183',array11);
	chiamaClik('183', '183_165', array11);
	
	var array12 = ["194","195","196","197","198","199","200","201","202"];
	checkEApriSI('193',array12);
	chiamaClik('193','193_165', array12);
	
	var array13 = ["204","205","206","207","208","209","210","211","212"];
	checkEApriSI('203',array13);
	chiamaClik('203','203_165', array13);
	
	var array14 = ["214","215","216","217","218","219","220","221","222"];
	checkEApriSI('213',array14);
	chiamaClik('213','213_165', array14);
	
	var array15 = ["224","225","226","227","228","229","230","231","232","233"];
	checkEApriSI('223',array15);
	chiamaClik('223','223_165', array15);
	
	
	var idDmd3='235';
	var arrayToOpen3 = ["236","238","240"];
	var arrayToClose3 = ["236","237","238","239","240","241"];
	var arraySvuotaText3 = ["236","237","238","239","240","241"];
	var arrayRadioDecheck3 = [];
	
	checkEApriSI(idDmd3,arrayToOpen3);
	apriInizio(arrayToOpen3,arrayToClose3,arrayRadioDecheck3,arraySvuotaText3,idDmd3);
	
	var array31 = ["237"]
	var array32 = ["239"]
	var array33 = ["241"]
	checkEApriSI('236',array31);
	checkEApriSI('238',array32);
	checkEApriSI('240',array33);
	
	$('input[name=DOM_236]').on('input',function(e){
		 if($('input[name=DOM_236]').val()){
		    	console.log('dentro if');
		    	$('#237').show(velocita);
		    }
		 else{
			 $('input[name=DOM_237]').val('');
			 $('#237').hide(velocita);
		 }
	});
	
	
	
	$('input[name=DOM_238]').on('input',function(e){
		 if($('input[name=DOM_238]').val()){
		    	console.log('dentro if');
		    	$('#239').show(velocita);
		    }
		 else{
			 $('input[name=DOM_239]').val('');
			 $('#239').hide(velocita);
		 }
	});
	$('input[name=DOM_240]').on('input',function(e){
		 if($('input[name=DOM_240]').val()){
		    	console.log('dentro if');
		    	$('#241').show(velocita);
		    }
		 else{
			 $('input[name=DOM_241]').val('');
			 $('#241').hide(velocita);
		 }
	});
	
	
});


	
