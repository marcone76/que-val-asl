$( document ).ready(function() {
    console.log( "ready!" );
    
    
    $("#change").change(function(){
        alert("Selected value is : " + document.getElementById("change").value);
       });
    
    var myPie1;
    var myPie2;

	console.log('prima');
	
	fillPies();
	console.log('dopo');
	
	});



function cambiaLink(url)
{	
  var singleReg = $('#regione').val();
  var singlePro = $('#provincia').val();
  var singleComu = $('#comune').val();
  var cicloScolastico = $('#cicliScolastici').val();
  var urlComposta='/oss-scu-dig-web/#'+url+'?regione='+ singleReg+'&provincia='+singlePro+'&comune='+singleComu+'&cicloScolastico='+cicloScolastico;
  $(".link").attr('href', urlComposta); 
}


function fillPies(){
	var regione = $('#regione').val();
	var provincia = $('#provincia').val();
	var comune = $('#comune').val();
	var cicloScolastico = $('#cicliScolastici').val();
	console.log('dentro reg '+regione);
	console.log('dentro pv '+provincia);
	console.log('dentro com '+comune);
	callFillPieInCorso("getDatiTortaQuestionariInCorso.json?regione="+regione+"&provincia="+provincia+"&comune="+comune+'&cicloScolastico='+cicloScolastico, 'tortaInCorso');
	callFillPieVal("getDatiTortaQuestionariRilevazioniValidate.json?regione="+regione+"&provincia="+provincia+"&comune="+comune+'&cicloScolastico='+cicloScolastico, 'tortaValidate');

}


function callFillPieVal(urlToCall, element){
	console.log('urlToCall '+urlToCall);
	console.log('element '+element);
	 $(document)
	    .ajaxStart(function() {
	      console.log('some AJAX request has started callFillPieVal'); 
			myPie1.destroy();
	    });
	    
	var ctx = document.getElementById(element);
	var request = $.ajax({ 
	    type: 'GET', 
	    beforeSend: function () { 
	    	$(".loaderImage").fadeIn(); 


	    	},
        // hides the loader after completion of request, whether successfull or failor.             
        
	    url: urlToCall, 
	    data: { get_param: 'value' }, 
	    dataType:'json',
	    success: function (data) { 
	                        //var names = data
	          			var myData = JSON.stringify(data);  
	          			var obj = JSON.parse( myData);
	          			//alert(obj);

	          			var  config = {
	          			        type: 'pie',
	          			        data: {
	          			            datasets: [{
	          			                data: [
	          			                	obj.inAttesa,
	          			                	obj.validati,
	          			                	
	          			                ],
	          			                backgroundColor: [
	          			                	"#FF6384",
	          			              	"#84FF63" 
	          			                ],
	          			                label: 'Dataset 1'
	          			            }],
	          			            labels: [
	          			            	"Non Validate",
	          			              "Validate"
	          			            ]
	          			        },
	          			        options: {
	          			        	legend: {
	          			    		  position: 'right',
	          			    		   },
	          			    		  layout: {
	          			    		        padding: {
	          			    		            left: 0,
	          			    		            right: 0,
	          			    		            top: 15,
	          			    		            bottom: 0
	          			    		        }
	          			    		    } 
	          			        }
	          			    };
	          			/*if (myPie1 != null || myPie1 != undefined ){

	          			myPie1.destroy();
	          			//myPie1.clear();

	          			}*/
	          			myPie1 = new Chart(ctx, config);
	          			
			}/*,
			complete: function () { 
	        	$(".loaderImage").fadeOut(); 
	        	}, */
		});
	
		
		request.fail(function( jqXHR, textStatus ) {
			console.log('jqXHR '+jqXHR);
			console.log('request '+request);
			      $(".loaderImage").hide();
            alert( "Request failed on pie validate: " + textStatus );
        });
	
}

function callFillPieInCorso(urlToCall, element){
	console.log('urlToCall '+urlToCall);
	console.log('element '+element);
	$(document)
    .ajaxStart(function() {
      console.log('some AJAX request has started callFillPieInCorso'); 
		myPie2.destroy();
    });
	
	var ctx = document.getElementById(element);
	var request = $.ajax({ 
	    type: 'GET', 
	    url: urlToCall, 
	    data: { get_param: 'value' }, 
	    dataType:'json',
	    success: function (data) { 
	    	
	    	console.log('data :'+data);
  			console.log('compilati :'+data.compilazione);
  			console.log('validati :'+data.validati);
  			console.log('inAttesa :'+data.inAttesa);
  			if((data.compilazione==null||data.compilazione==0 && data.validati==0 && data.inAttesa==0)
  						||(data.compilazione==0 && data.validati==null||data.validati==0 && data.inAttesa==0)
  						||(data.compilazione==0 && data.validati==0 && data.inAttesa==null||data.inAttesa==0)){
  				alert('Nessun risultato per i criteri di ricerca selezionati');
  			}
	    	
	                        //var names = data
	          			var myData = JSON.stringify(data);  
	          			

	          			var obj = JSON.parse( myData);
	          			var  config = {
	          			        type: 'pie',
	          			        data: {
	          			            datasets: [{
	          			                data: [
	          			                	obj.compilazione,
	          			                	obj.validati,
	          			                	obj.inAttesa,
	          			                ],
	          			                backgroundColor: [
	          			                	"#FF6384",
	          			              	"#84FF63", 
	          			              	"#6384FF"
	          			                ],
	          			                label: 'Dataset 1'
	          			            }],
	          			            labels: [
	          			            	"In compilazione",
	          			              "Compilati",
	          			              "In Attesa"
	          			            ]
	          			        },
	          			        options: {
	          			        	legend: {
	          			    		  position: 'right',
	          			    		   },
	          			    		  layout: {
	          			    		        padding: {
	          			    		            left: 0,
	          			    		            right: 0,
	          			    		            top: 15,
	          			    		            bottom: 0
	          			    		        }
	          			    		    } 
	          			        }
	          			    };
	          			/*if (myPie2 != null || myPie2 != undefined ){
		          			//myPie2.destroy();
		          			myPie2.clear();
	          			}*/
	          			myPie2 = new Chart(ctx, config);
	          			
	          			
	    },
	        			complete: function () { 
	        	        	$(".loaderImage").fadeOut(); 
	        	        	}, 
	          			
			
		});
	
	

		request.fail(function( jqXHR, textStatus ) {
			console.log('jqXHR in corso '+jqXHR);
			console.log('request in corso '+request);
			      $(".loaderImage").hide();
			
            alert( "Request failed on pie in corso: " + textStatus );
        });
	
}
