function submitForm(tipoOperazione){
	$('#tipoOperazione').val(tipoOperazione);
	$('#formRilevazione').submit();
}
function urlApprovaQst(codForScu,codQst){
    var url= '/oss-scu-dig-web/approvaQuestionario?codForScu='+codForScu+'&codQst='+codQst;
    $(".link").attr('href', url);
}



