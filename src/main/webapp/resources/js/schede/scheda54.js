$(document).ready(

		 
		function() {
			$(window).scrollTop(0);
			$('input').click(function(){
				var name=$(this).attr('name');
				$( 'input[name='+name+']' ).removeClass( "validationError" );
				
			});
			
			 var arrayClose = ["1066", "1067", "1068", "1069", "1070", "1071", "1072", "1073", "1074", "1075", "1076",  "1079", "1080", "1081",  "1083", "1084", "1085", , "1087", "1088", "1089", "1091", "1092", "1093", "1102"];
				svuota(arrayClose);

			var arrayInitToClose = [ "1066", "1067", "1068", "1069", "1070", "1071", "1072", "1073", "1074", "1075", "1076"];//, "129"
			//svuota(arrayInitToClose);

			var arrayToOpen = [ "1066", "1067", "1068", "1069"];
			var arrayRadioDecheck = [];
			
			var idDmd = '1065';
			apriInizio(arrayToOpen, arrayInitToClose, arrayRadioDecheck, arrayInitToClose, idDmd);
			if ($('input[name=DOM_1065]:checked').val() == "165") {
				for (i = 0; i < arrayToOpen.length; i++) {
					$('#' + arrayToOpen[i]).show(velocita);
				}
			}else{
				for (i = 0; i < arrayToOpen.length; i++) {
					$('#' + arrayToOpen[i]).val('');
				}
			}
			
		
			
			
			
			
			
			var array1069 = ["1070","1071","1072","1073","1074","1075","1076"];

			apriText('1069',array1069);

			$('input[name=DOM_1069]').on('input',function(e){
				 if($('input[name=DOM_1069]').val()){
				    	console.log('dentro if');
				    	$('#1070').show(velocita);
				    	$('#1071').show(velocita);
				    	$('#1072').show(velocita);
				    	$('#1073').show(velocita);
				    	$('#1074').show(velocita);
				    	$('#1075').show(velocita);
				    	$('#1076').show(velocita);


				    }
				 else{
					 $( 'input[name=DOM_1070]').val('');
					 $( 'input[name=DOM_1071]').val('');
					 $( 'input[name=DOM_1072]').val('');
					 $( 'input[name=DOM_1073]').val('');
					 $( 'input[name=DOM_1074]').val('');
					 $( 'input[name=DOM_1075]').val('');
					 $( 'input[name=DOM_1076]').val('');


					 $('#1070').hide(velocita);
					 $('#1071').hide(velocita);
					 $('#1072').hide(velocita);
					 $('#1073').hide(velocita);
					 $('#1074').hide(velocita);
					 $('#1075').hide(velocita);
					 $('#1076').hide(velocita);
				 }
				 
			});
			
			
			
			var array1078 = ["1079","1080","1081"];

			apriText('1078',array1078);


			$('input[name=DOM_1078]').on('input',function(e){
				 if($('input[name=DOM_1078]').val()){
				    	console.log('dentro if');
				    	$('#1079').show(velocita);
				    	//$('#1080').show(velocita);
				    	$('#1081').show(velocita);

				    }
				 else{
					 $( 'input[name=DOM_1079]').prop('checked', false);
					 $('input[name=DOM_1080]').prop('checked', false);
					 $('input[name=DOM_1081]').prop('checked', false);

					 $('#1079').hide(velocita);
					 $('#1080').hide(velocita);
				    	$('#1081').hide(velocita);
				 }
				 
			});
			
			
			var array1082 = ["1083","1084","1085"];

			apriText('1082',array1082);

			$('input[name=DOM_1082]').on('input',function(e){
				 if($('input[name=DOM_1082]').val()){
				    	console.log('dentro if');
				    	$('#1083').show(velocita);
				    	//$('#1084').show(velocita);
				    	$('#1085').show(velocita);

				    }
				 else{
					 $( 'input[name=DOM_1083]').prop('checked', false);
					 $('input[name=DOM_1084]').prop('checked', false);
					 $('input[name=DOM_1085]').prop('checked', false);
					 $('#1083').hide(velocita);
					 $('#1084').hide(velocita);
				    $('#1085').hide(velocita);
				 }
				 
			});
			
			var array1086 = ["1087","1088","1089"];

			apriText('1086',array1086);

			$('input[name=DOM_1086]').on('input',function(e){
				 if($('input[name=DOM_1086]').val()){
				    	console.log('dentro if');
				    	$('#1087').show(velocita);
				    	//$('#1088').show(velocita);
				    	$('#1089').show(velocita);

				    }
				 else{
					 $( 'input[name=DOM_1087]').prop('checked', false);
					 $('input[name=DOM_1088]').prop('checked', false);
					 $('input[name=DOM_1089]').prop('checked', false);

					 $('#1087').hide(velocita);
					 $('#1088').hide(velocita);
				    	$('#1089').hide(velocita);
				 }
				 
			});
			
			var array1090 = ["1091","1092","1093"];

			apriText('1090',array1090);

			$('input[name=DOM_1090]').on('input',function(e){
				 if($('input[name=DOM_1090]').val()){
				    	console.log('dentro if');
				    	$('#1091').show(velocita);
				    	//$('#1092').show(velocita);
				    	$('#1093').show(velocita);

				    }
				 else{
					 $( 'input[name=DOM_1091]').prop('checked', false);
					 $('input[name=DOM_1092]').prop('checked', false);
					 $('input[name=DOM_1093]').prop('checked', false);
					 $('#1091').hide(velocita);
					 $('#1092').hide(velocita);
				    	$('#1093').hide(velocita);
				 }
				 
			});
			
			
			var arrayInitToClose1 = ["1080"];
			svuota(arrayInitToClose1);			
			var arrayToOpen1 = ["1080"];
			var arrayToClose1 = ["1080"];
			var arrayRadioDecheck1 = ["1080"];
			var arraySvuotaText1 = ["1080"];
			var idDmd1 = '1079';	
			checkEApriSI(idDmd1,arrayToOpen1);
			apriInizio(arrayToOpen1,arrayToClose1,arrayRadioDecheck1,arraySvuotaText1,idDmd1);
			
			var arrayInitToClose2 = ["1084"];
			svuota(arrayInitToClose2);			
			var arrayToOpen2 = ["1084"];
			var arrayToClose2 = ["1084"];
			var arrayRadioDecheck2 = ["1084"];
			var arraySvuotaText2 = ["1084"];
			var idDmd2 = '1083';	
			checkEApriSI(idDmd2,arrayToOpen2);
			apriInizio(arrayToOpen2,arrayToClose2,arrayRadioDecheck2,arraySvuotaText2,idDmd2);
			
			
			var arrayInitToClose3 = ["1088"];
			svuota(arrayInitToClose3);			
			var arrayToOpen3 = ["1088"];
			var arrayToClose3 = ["1088"];
			var arrayRadioDecheck3 = ["1088"];
			var arraySvuotaText3 = ["1088"];
			var idDmd3 = '1087';	
			checkEApriSI(idDmd3,arrayToOpen3);
			apriInizio(arrayToOpen3,arrayToClose3,arrayRadioDecheck3,arraySvuotaText3,idDmd3);
			
			
			var arrayInitToClose4 = ["1092"];
			svuota(arrayInitToClose4);			
			var arrayToOpen4 = ["1092"];
			var arrayToClose4 = ["1092"];
			var arrayRadioDecheck4 = ["1092"];
			var arraySvuotaText4 = ["1092"];
			var idDmd4 = '1091';	
			checkEApriSI(idDmd4,arrayToOpen4);
			apriInizio(arrayToOpen4,arrayToClose4,arrayRadioDecheck4,arraySvuotaText4,idDmd4);

			
			chiamaClikCheck("1091_165", "1092");
			if(document.getElementById('1091_165').checked) {
				   $("#1092").show();
				} else {
				   $("#1092").hide();
				   $("#1092").val('');
				}
			
			
			
			var array1101 = ["1102"];

			apriText('1101',array1101);

			$('input[name=DOM_1101]').on('input',function(e){
				 if($('input[name=DOM_1101]').val()){
				    	console.log('dentro if');
				    	$('#1102').show(velocita);

				    }
				 else{
					 $( 'input[name=DOM_1102]').val('');
					 $('#1102').hide(velocita);
				 }
				 
			});
			
			
			
			
			
			
		});
