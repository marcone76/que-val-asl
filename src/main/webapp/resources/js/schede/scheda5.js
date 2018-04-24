$( document ).ready(function() {

	$(window).scrollTop(0);

	$('input').click(function(){
		var name=$(this).attr('name');
		$( 'input[name='+name+']' ).removeClass( "validationError" );
	});

	var arrayInitToClose = ["69","70","71","72","73","74","75","76","77","78","79","80","81","82","83","84","85","86","87","88","89","97","100","102"
		,"103","104","105","106","107"];
	svuota(arrayInitToClose);

	var arrayToOpen = ["69","70","75","80","85"];
	var arrayRadioDecheck = ["70","72","74","75","77","79","80","82","84","85","87","89"];
	var arraySvuotaText = ["71","76","81","86"];
	var arraySvuotaCKB = ["73","78","83","88"];
	
	checkEApriSI('67',arrayToOpen);

			
	$('input[name=DOM_67]').on('input',function(e){
		if( $('#67999').val() ){
			for( i =0; i<arrayToOpen.length; i++){
				$('#'+arrayToOpen[i]).show(velocita);
			}
		} else {
			for( i =0; i<arrayInitToClose.length; i++)
			{
				$('#'+arrayInitToClose[i]).hide(velocita);
			}
			for( i =0; i<arrayRadioDecheck.length; i++)
			{
				$('input[name=DOM_'+arrayRadioDecheck[i]+']').prop('checked',false);
			}	
			for( i =0; i<arraySvuotaText.length; i++)
			{
				$('input[name=DOM_'+arraySvuotaText[i]+']').val('');
			}
			for( i =0; i<arraySvuotaCKB.length; i++)
			{
				$('#'+arraySvuotaCKB[i]+'_24').prop('checked', false);
				$('#'+arraySvuotaCKB[i]+'_25').prop('checked', false);
			}
		}
	});


	var array2Open = ["71","72","74"];
	var array2Close = ["71","72","73","74"];
	checkEApriSI('70',array2Open);
	chiamaClik5('70', '70_165',array2Open,array2Close);
	var array21 = ["73"];
	checkEApriSI('72',array21);
	apriSingoloCheck('72','73');

	var array3Close = ["76","77","78","79"];
	var array3Open = ["76","77","79"];
	checkEApriSI('75',array3Open);
	chiamaClik5('75', '75_165',array3Open,array3Close);
	var array31 = ["78"];
	checkEApriSI('77',array31);
	apriSingoloCheck('77','78');

	var array4Close = ["81","82","83","84"];
	var array4Open = ["81","82","84"];
	checkEApriSI('80',array4Open);
	chiamaClik5('80', '80_165',array4Open,array4Close);
	var array41 = ["83"];
	checkEApriSI('82',array41);
	apriSingoloCheck('82','83');

	var array5Close = ["86","87","88","89"];	
	var array5Open = ["86","87","89"];	
	checkEApriSI('85',array5Open);
	chiamaClik5('85', '85_165',array5Open,array5Close);
	var array51 = ["88"];
	checkEApriSI('87',array51);
	apriSingoloCheck('87','88');

	var array6 = ["97"];	
	checkEApriSI('96',array6);
	$('input[name=DOM_96]').on('input',function(){
		if($('#96999').val()){
			$('#97').show(velocita);
		}else{
			$('input[name=DOM_97]').val('');
			$('#97').hide(velocita);
		}
	});

	var array7 = ['100'];	
	checkEApriSI('99',array7);
	apriSingolo('99','100');

	
	var arrayToOpen2 = ["102","103","104","105","106","107"];
	checkEApriSI('101',arrayToOpen2);
	$('input[name=DOM_101]').click(function () {  
		if(this.id == "101_165" ){
			for( i =0; i<arrayToOpen2.length; i++){
				$('#'+arrayToOpen2[i]).show(velocita);
			}
		}else{
			for( i =0; i<arrayToOpen2.length; i++){
				$('#'+arrayToOpen2[i]).hide(velocita);
			}
			$('input[name=DOM_102]').val('');
			$('input[name=DOM_104]').val('');
			$('input[name=DOM_105]').val('');
			$('input[name=DOM_106]').val('');
			$('input[name=DOM_107]').prop('checked', false);
		}
	});

	
	function chiamaClik5(gruppo, id, arrayToOpen, arrayToClose){
		$('input[name=DOM_'+gruppo+']').click(function () {
			if (this.id == id) {
				for( i =0; i<arrayToOpen.length; i++){
					$('#'+arrayToOpen[i]).show(velocita);
					}
			} else {
				for( i =0; i<arrayToClose.length; i++)
				{
					if($('input[name=DOM_'+arrayToClose[i]+']').is(':radio'))
					{
						$('input[name=DOM_'+arrayToClose[i]+']').prop('checked', false);
					}
					else if($('input[name=DOM_'+arrayToClose[i]+']').is(':text'))
					{
						$('input[name=DOM_'+arrayToClose[i]+']').val('');
					}
					else if($('input[name=DOM_'+arrayToClose[i]+']').is(':checkbox'))
					{
						$('input[name=DOM_'+arrayToClose[i]+']').prop('checked', false);
					}
					$('#'+arrayToClose[i]).hide(velocita);
				}
			}
		});
	}
	
	

});