$( document ).ready(function() {
	 $(window).scrollTop(0);

	 $('input').click(function(){
			var name=$(this).attr('name');
			$( 'input[name='+name+']' ).removeClass( "validationError" );
		});
	 
	var arrayInitToClose1 = ["245","246", "247","248","249"];
	var arrayInitToClose2 = ["251","252", "253","254","255"];
	var arrayInitToClose3 = ["257","258", "259","260","261"];
	svuota(arrayInitToClose1);
	svuota(arrayInitToClose2);
	svuota(arrayInitToClose3);
	var arrayInitToClose = "";	
	var arrayToOpen = "";
	var arrayToOpen1=["245", "246", "247", "248", "249"];
	var arrayToOpen2=["251", "252","253", "254", "255"];
	var arrayToOpen3=["257", "258", "259", "260", "261"];

	var arrayRadioDecheck = ["244" , "251", "256"];
	
	/* svuota tutti i campi testo */
	var arraySvuotaText1 =["245", "246", "247", "248", "249"];
	var arraySvuotaText2 = ["251", "252","253", "254", "255"];
	var arraySvuotaText3 = ["257", "258", "259", "260", "261"];

var idDmd1='244';
var idDmd2='250';
var idDmd3='256';

ApriSI('244_165',arrayToOpen1);
ApriSI('250_165',arrayToOpen2);
ApriSI('256_165',arrayToOpen3);


    apriInizio(arrayToOpen1,arrayInitToClose1,"244",arraySvuotaText1,idDmd1);
    apriInizio(arrayToOpen2,arrayInitToClose2,"250",arraySvuotaText2,idDmd2);
    apriInizio(arrayToOpen3,arrayInitToClose3,"256",arraySvuotaText3,idDmd3);


	
	
});


