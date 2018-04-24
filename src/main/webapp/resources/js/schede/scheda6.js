$(document).ready(
		 
		function() {
			$(window).scrollTop(0);
			$('input').click(function(){
				var name=$(this).attr('name');
				$( 'input[name='+name+']' ).removeClass( "validationError" );
				
			});
			
			var arrayInitToClose = [ "109", "110", "111", "112", "113", "114", "115", "116", "117", "118", "119", "122" , "139"];//, "129"
			svuota(arrayInitToClose);

			var arrayToOpen = [ "109", "110", "111", "112", "113", "114", "115", "116", "117", "118", "119" ];
			var arrayRadioDecheck = [];
			
			var idDmd = '108';
			apriInizio(arrayToOpen, arrayInitToClose, arrayRadioDecheck, arrayToOpen, idDmd);
			if ($('input[name=DOM_108]:checked').val() == "165") {
				for (i = 0; i < arrayToOpen.length; i++) {
					$('#' + arrayToOpen[i]).show(velocita);
				}
			}else{
				for (i = 0; i < arrayToOpen.length; i++) {
					$('#' + arrayToOpen[i]).val('');
				}
			}
			
			chiamaClikCheck("121_733", "124");
			if(document.getElementById('121_733').checked) {
				   $("#124").show();
				} else {
				   $("#124").hide();
				   $("#124").val('');
				}
			
			$('input[name=DOM_138]').on('input', function(e) {
				if ($('#138999').val()) {
					$('#139').show(velocita);
				}else{
					 $('input[name=DOM_139]').val('');
					$('#139').hide(velocita);
				}
			});
			
			//gestione ripetizioni
			var arrayInitToClose = [];
			var arrayToOpen1 = []; 
			var arrayToOpenCheck = []; 
			
			var arrayToOpen2 = []; 
			var arrayToOpenCheck2 = []; 
			//var arrayRadioDecheck = ["","",""];
						$( '.codEdi' ).each(function( index, value ) {
						  if($(value).attr('id') == '126999'){
							  
									  console.log( $(value).val() );
									  
									  arrayInitToClose.push("127"+$(value).val());
									  arrayInitToClose.push("128"+$(value).val());
									  arrayInitToClose.push("129"+$(value).val());
									  arrayInitToClose.push("130"+$(value).val());
								  
									  arrayToOpen1.push("127"+$(value).val());
									  arrayToOpen1.push("128"+$(value).val());
									  arrayToOpen1.push("130"+$(value).val());
									  arrayToOpenCheck.push('#1261_165_COD_EDI_'+$(value).val());
									  
									  arrayToOpen2.push("129"+$(value).val());
									  arrayToOpenCheck2.push('#128_165_COD_EDI_'+$(value).val());
									  
									$('input[name=DOM_1261_COD_EDI_'+$(value).val()+']').click(function () {// name del gruppo di radio o check
									if (this.id == "1261_165_COD_EDI_"+$(value).val()) {//   502_165_COD_EDI_0840111577
										$("#127"+$(value).val()).show('slow');
										$("#128"+$(value).val()).show('slow');
										$("#130"+$(value).val()).show('slow');
									} else {
										$("#127"+$(value).val()).hide('slow');
										$("#128"+$(value).val()).hide('slow');
										$("#129"+$(value).val()).hide('slow');
										$("#130"+$(value).val()).hide('slow');
											$('input[name=DOM_127_COD_EDI_'+$(value).val() + ']').prop('checked',false);
											$('input[name=DOM_128_COD_EDI_'+$(value).val() + ']').prop('checked',false);
											$('input[name=DOM_129_COD_EDI_'+$(value).val() + ']').prop('checked',false);
											$('input[name=DOM_130_COD_EDI_'+$(value).val() + ']').prop('checked',false);
									}
									
								});
									
								$('input[name=DOM_128_COD_EDI_'+$(value).val()+']').click(function () {// name del gruppo di radio o check	
									if (this.id == "128_165_COD_EDI_"+$(value).val()) {//   502_165_COD_EDI_0840111577
										$("#129"+$(value).val()).show('slow');
									} else {
										$("#129"+$(value).val()).hide('slow');
										$('input[name=DOM_129_COD_EDI_'+$(value).val() + ']').prop('checked',false);
									}
								});	
						  }
						  
						});
			
			svuota(arrayInitToClose);
			
			
			/*ApriSI(arrayToOpenCheck,arrayToOpen1);
			ApriSI(arrayToOpenCheck2,arrayToOpen2);*/
			
			apriSIPlessiEdifici(arrayToOpen1,arrayToOpenCheck);
			apriSIPlessiEdifici(arrayToOpen2,arrayToOpenCheck2);
			
			
			
			var array275 = ["139"];

			apriText('138',array275);

			$('input[name=DOM_138]').on('input',function(e){
				 if($('input[name=DOM_138]').val()){
				    	console.log('dentro if');
				    	$('#139').show(velocita);
				    	

				    }
				 else{
					 $( 'input[name=DOM_139]').val('');
					 
					 $('#139').hide(velocita);
				    
				 }
				 
			});
			
			
		});
