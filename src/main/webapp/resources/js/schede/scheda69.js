$( document ).ready(function() {
	 $(window).scrollTop(0);
	
	 $('input').click(function(){
			var name=$(this).attr('name');
			$( 'input[name='+name+']' ).removeClass( "validationError" );
		});
	 
	 var arrayInitToClose = ["1323","1326","1327","1328","1329","1331","1332","1333","1334","1336","1337","1338","1339","1347","1350","1352","1353","1354","1355","1356","1357"];
	svuota(arrayInitToClose);
	var arrayInitToClose1 = ["1326","1327","1328","1329"];
	var arrayInitToClose2 = ["1331","1332","1333","1334"];
	var arrayInitToClose3 = ["1336","1337","1338","1339"];
	var arrayInitToClose4 = ["","","",""];
	var arrayToOpen5=["1352","1353","1354","1355","1356","1357"];
	var arrayToOpen1=["1326","1327","1329"];
	var arrayToOpen2=["1331","1332","1334"];
	var arrayToOpen3=["1336","1337","1339"];
	var arrayToOpen4=["","","",""];
	var arrayToOpen5=["1352","1353","1354","1355","1356","1357"];
	var arrayRadioDecheck = ["1325" , "1330", "1335",""];
	var arrayToOpen1064=["1042","1043","1045"];

	var idDmd1="1325";
	var idDmd2="1330";
	var idDmd3="1335";
	var idDmd4="";
	
	ApriSI('1325_165',arrayToOpen1);
	var array1028 = ["1328"];
	checkEApriSI('1327',array1028);
	apriSingoloCheck('1327','1328');
	
	ApriSI('1330_165',arrayToOpen2);	
	var array1033 = ["1333"];
	checkEApriSI('1332',array1033);
	apriSingoloCheck('1332','1333');
	
	
	ApriSI('1335_165',arrayToOpen3);
	var array1038 = ["1338"];
	checkEApriSI('1337',array1038);
	apriSingoloCheck('1337','1338');
	


	var arrayToOpen1055=["1350"];
	ApriSI('1349_165',arrayToOpen1055);
	
	var arrayToOpen1057=["1352","1353","1354","1355","1356","1357"];
	ApriSI('1351_165',arrayToOpen1057);
	
	var array1052 = ["1347"];
	apriText('1346',array1052);
	
	$('input[name=DOM_1346]').on('input',function(e){
		 if($('input[name=DOM_1346]').val()){
		    	console.log('dentro if');
		    	$('#1347').show(velocita);

		    }
		 else{
			 $('input[name=DOM_1347]').val('');
			 $('#1347').hide(velocita);
		 }
		 
	});
	
	var array1322 = ["1323"];
	apriText('1322',array1322);
	
	$('input[name=DOM_1322]').on('input',function(e){
		 if($('input[name=DOM_1322]').val()){
		    	console.log('dentro if');
		    	$('#1323').show(velocita);

		    }
		 else{
			 $('input[name=DOM_1323]').val('');
			 $('#1323').hide(velocita);
		 }
		 
	});
	

		
		
		var array1 = ["1326","1327","1329"];		chiamaClik('1325', '1325_165', array1);//523
		apriSingolo('1327','1328');
		//chiusura di tutti a cascata, altrimenti se si in un ramo e no nel principale rimaneva aperto in basso
		$('input[id=1325_164]').click(function () {
			for( i =0; i<arrayInitToClose1.length; i++){
				$('#'+arrayInitToClose1[i]).hide(velocita);
				}
			});
		
		var array2 = ["1331","1332","1334"];		chiamaClik('1330', '1330_165', array2);//523		
		apriSingolo('1332','1333');
		
		$('input[id=1330_164]').click(function () {
		for( i =0; i<arrayInitToClose2.length; i++){
			$('#'+arrayInitToClose2[i]).hide(velocita);
			}
		});
		
		var array3 = ["1336","1337","1339"];		chiamaClik('1335', '1335_165', array3);//523		
		apriSingolo('1337','1338');
		$('input[id=1335_164]').click(function () {
			for( i =0; i<arrayInitToClose3.length; i++){
				$('#'+arrayInitToClose3[i]).hide(velocita);
				}
			});
		
		
chiamaClik('1351', '1351_165', arrayToOpen5);//523		
		
		$('input[id=1351_164]').click(function () {
			for( i =0; i<arrayInitToClose5.length; i++){
				$('#'+arrayInitToClose5[i]).hide(velocita);
				}
			});
		
	
		apriSingolo('1349','1350');
	
});


	
