$( document ).ready(function() {
	
	 $(window).scrollTop(0);
	 
	 $('input').click(function(){
			var name=$(this).attr('name');
			$( 'input[name='+name+']' ).removeClass( "validationError" );
		});
	 
	var arrayInitToClose = ["11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33"];
	svuota(arrayInitToClose);
	
	var arrayToOpen = ["11","12","15","18","21","24","27","30"];
	var arrayRadioDecheck = ["12","14","15","18","17","20","21","23","24","26","27","29","30","33"];
	var arraySvuotaText = ["13","16","19","22","25","28","31","32"];
	
	var idDmd='10';
	checkEApriSI(idDmd,arrayToOpen);
	
	apriInizio(arrayToOpen,arrayInitToClose,arrayRadioDecheck,arraySvuotaText,idDmd);
	
	var array12 = ["13","14"];
	checkEApriSI('12',array12);
	chiamaClik('12', '12_165', array12);
	
	var array15 = ["16","17"];
	checkEApriSI('15',array15);
	chiamaClik('15', '15_165', array15);
	
	var array18 = ["19","20"];
	checkEApriSI('18',array18);
	chiamaClik('18', '18_165', array18);

	var array21 = ["22","23"];
	checkEApriSI('21',array21);
	chiamaClik('21', '21_165', array21);
	
	var array24 = ["25","26"];
	checkEApriSI('24',array24);
	chiamaClik('24', '24_165', array24);
	
	var array27 = ["28","29"];	
	checkEApriSI('27',array27);
	chiamaClik('27', '27_165', array27);
	
	var array30 = ["31","32","33"];
	checkEApriSI('30',array30);
	chiamaClik('30', '30_165', array30);
	
	
});