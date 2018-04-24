$( document ).ready(function() {
    console.log( "ready!" );
    var ctx = document.getElementById("torta");
    console.log(ctx);
    var ctx2 = document.getElementById("torta2");
    
    $("#change").change(function(){
        alert("Selected value is : " + document.getElementById("change").value);
       });
    
    $(document)
    .ajaxStart(function() {
      console.log('some AJAX request has started'); 
      $(".loaderImage").show();
    })
    .ajaxStop(function() {
      console.log('all AJAX requests have completed'); 
      $(".loaderImage").hide();
    })
    ;
	
	
	
	
	var request = $.ajax({ 
	    type: 'GET', 
	    url: 'getDatiTortaQuestionariInCorso.json', 
	    data: { get_param: 'value' }, 
	    dataType:'json',
	    success: function (data) { 
	                        //var names = data
	          			  console.log('ciao dentro data '+data);
	          			var myData = JSON.stringify(data);  
	          			 console.log('ciao myData2 '+myData);
	          			
	          			console.log( "call myData " +myData);
	          			console.log( "myData.compilazione " +myData.compilazione);
	          			var obj = JSON.parse( myData);
	          			console.log( "call 1 obj " +obj);
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
	          			console.log( "call 2" );





	          			console.log(config);
	          			window.myPie2 = new Chart(ctx, config);



	          			console.log( "call 3" );

	          			console.log( "fine" );
	          			
	          			
	          			
	          			
	          			
	          			
	          			
	          			
	          			
	          			
	          			
	          			
			}
		});
	
	var request = $.ajax({ 
	    type: 'GET', 
	    url: 'getDatiTortaQuestionariRilevazioniValidate.json', 	    
	    data: { get_param: 'value' }, 
	    dataType:'json',
	    success: function (data) { 
	                        //var names = data
	          			  console.log('ciao dentro data '+data);
	          			var myData = JSON.stringify(data);  
	          			 console.log('ciao myData2 '+myData);
	          			
	          			console.log( "call myData " +myData);
	          			console.log( "myData.compilazione " +myData.compilazione);
	          			var obj = JSON.parse( myData);
	          			console.log( "call 1 obj " +obj);
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
	          			console.log( "call 2" );





	          			console.log(config);
	          			window.myPie = new Chart(ctx2, config);



	          			console.log( "call 3" );

	          			console.log( "fine" );
	          			
	          			
	          			
	          			
	          			
	          			
	          			
	          			
	          			
	          			
	          			
	          			
			}
		});
	
		
		request.fail(function( jqXHR, textStatus ) {
			console.log('jqXHR '+jqXHR);
			console.log('request '+request);
			
            alert( "Request failed: " + textStatus );
        });

	
	});





