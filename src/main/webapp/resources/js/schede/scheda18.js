$( document ).ready(function() {
	
	$(window).scrollTop(0);
	
	var arrayInitToClose = ["360","363","365"];
	svuotaCheck(arrayInitToClose);

	chiamaClikCheck( "359_800", "360");
	chiamaClikCheck( "362_823", "363");
	chiamaClikCheck( "364_866", "365");
	
	
	if(document.getElementById('359_800').checked) {
		   $("#360").show();
		} else {
		   $("#360").hide();
		   $("#360").val('');
		}
	
	if(document.getElementById('362_823').checked) {
		   $("#363").show();
		} else {
		   $("#363").hide();
		   $("#363").val('');
		}
	
	if(document.getElementById('364_866').checked) {
		   $("#365").show();
		} else {
		   $("#365").hide();
		   $("#365").val('');
		}
	
	$('input').click(function(){
		var name=$(this).attr('name');
		$( 'input[name='+name+']' ).removeClass( "validationError" );
		
	});
	
});


	
