$( document ).ready(function() {
	 $(window).scrollTop(0);
	
	 $('input').click(function(){
			var name=$(this).attr('name');
			$( 'input[name='+name+']' ).removeClass( "validationError" );
		});
	 
	 var arrayInitToClose = ["1027","1028","1029","1030","1032","1033","1034","1035","1037","1038","1039","1040","1042","1043","1044","1045","1053","1056","1058","1059","1060","1061","1062","1063"];
	svuota(arrayInitToClose);
	var arrayInitToClose1 = ["1027","1028","1029","1030"];
	var arrayInitToClose2 = ["1032","1033","1034","1035"];
	var arrayInitToClose3 = ["1037","1038","1039","1040"];
	var arrayInitToClose4 = ["1042","1043","1044","1045"];
	var arrayToOpen1=["1027","1028","1030"];
	var arrayToOpen2=["1032","1033","1035"];
	var arrayToOpen3=["1037","1038","1040"];
	var arrayToOpen4=["1042","1043","1044","1045"];
	var arrayToOpen5 = ["1058","1059","1060","1061","1062","1063"];
	var arrayRadioDecheck = ["1026" , "1031", "1036","1041"];
	var arrayToOpen1064=["1042","1043","1045"];

	var idDmd1="1026";
	var idDmd2="1031";
	var idDmd3="1036";
	var idDmd4="1041";
	
	ApriSI('1026_165',arrayToOpen1);
	var array1028 = ["1029"];
	checkEApriSI('1028',array1028);
	apriSingoloCheck('1028','1029');
	
	ApriSI('1031_165',arrayToOpen2);	
	var array1033 = ["1034"];
	checkEApriSI('1033',array1033);
	apriSingoloCheck('1033','1034');
	
	
	ApriSI('1036_165',arrayToOpen3);
	var array1038 = ["1039"];
	checkEApriSI('1038',array1038);
	apriSingoloCheck('1038','1039');
	
	ApriSI('1064_165',arrayToOpen1064);
	var array1043 = ["1044"];
	checkEApriSI('1043',array1043);
	apriSingoloCheck('1043','1044');

	var arrayToOpen1055=["1056"];
	ApriSI('1055_165',arrayToOpen1055);
	
	ApriSI('1026_165',arrayToOpen5);

	
	
	var array1052 = ["1053"];
	apriText('1052',array1052);
	
	$('input[name=DOM_1052]').on('input',function(e){
		 if($('input[name=DOM_1052]').val()){
		    	console.log('dentro if');
		    	$('#1053').show(velocita);

		    }
		 else{
			 $('input[name=DOM_1053]').val('');
			 $('#1053').hide(velocita);
		 }
		 
	});
	
		
		var array1 = ["1027","1028","1030"];		chiamaClik('1026', '1026_165', array1);//523
		apriSingolo('1028','1029');
		//chiusura di tutti a cascata, altrimenti se si in un ramo e no nel principale rimaneva aperto in basso
		$('input[id=1026_164]').click(function () {
			for( i =0; i<arrayInitToClose1.length; i++){
				$('#'+arrayInitToClose1[i]).hide(velocita);
				}
			});
		
		var array2 = ["1032","1033","1035"];		chiamaClik('1031', '1031_165', array2);//523		
		apriSingolo('1033','1034');
		
		$('input[id=1031_164]').click(function () {
		for( i =0; i<arrayInitToClose2.length; i++){
			$('#'+arrayInitToClose2[i]).hide(velocita);
			}
		});
		
		var array3 = ["1037","1038","1040"];		chiamaClik('1036', '1036_165', array3);//523		
		apriSingolo('1038','1039');
		$('input[id=1036_164]').click(function () {
			for( i =0; i<arrayInitToClose3.length; i++){
				$('#'+arrayInitToClose3[i]).hide(velocita);
				}
			});
		
		var array4 = ["1042","1043","1045"];		chiamaClik('1064', '1064_165', array4);//523		
		apriSingolo('1043','1044');
		
		$('input[id=1064_164]').click(function () {
			for( i =0; i<arrayInitToClose4.length; i++){
				$('#'+arrayInitToClose4[i]).hide(velocita);
				}
			});
		
		
		chiamaClik('1057', '1057_165', arrayToOpen5);//523		
		
		$('input[id=1057_164]').click(function () {
			for( i =0; i<arrayInitToClose4.length; i++){
				$('#'+arrayInitToClose4[i]).hide(velocita);
				}
			});

		
		apriSingolo('1055','1056');
	
		
});


	
