$( document ).ready(function() {
	
	var arrFrom= [];
	var arrTo= [];
	var myLineChart;

	var legenda;




	$(document)
	.ajaxStart(function() {
	    	myLineChart.destroy();

	  console.log('some AJAX request has started'); 
	  $(".loaderImage").show();
	})
	.ajaxStop(function() {
	  console.log('all AJAX requests have completed'); 
	  $(".loaderImage").hide();
	})
	;
	
	var newdatAl = new Date();
	//console.log(new Date(new Date().setDate(newdatAl - 14));
	  
    $("#to").datepicker({
    	format: 'dd/mm/yyyy',
    	autoclose: true,
    	language: 'it',
    	}).datepicker("setDate", newdatAl);
	
	
	var newdatFrom = new Date();
	newdatFrom.setDate(newdatAl.getDate() - 14);
	
	
	
	  $("#from").datepicker({
		  maxDate: newdatAl,
	        autoclose: true,
	        format: 'dd/mm/yyyy',
	        language: 'it'
	    }).on('changeDate', function (selected) {
	        var minDate = new Date(selected.date.valueOf() + (1000 * 60 * 60 * 24 * 14));
	        $('#to').datepicker("setDate", minDate);
	        
	    }).datepicker("setDate", newdatFrom);


	
	
	
	
	

	  fillPies();


	  function fillPies(){
	  	var regione = $('#regione').val();
	  	var provincia = $('#provincia').val();
	  	var comune = $('#comune').val();
	  	var from = $('#from').val();
	  	var cicliScolastici = $('#cicliScolastici').val();    
	  	console.log('dentro'+regione);
	  	console.log('dentro'+provincia);
	  	console.log('dentro'+comune);
	  	callFillAndamentoValidazione("getDatiAndamentoAcquisizione.json?regione="+regione+"&provincia="+provincia+"&comune="+comune+"&from="+from+"&cicliScolastici="+cicliScolastici);
	  }

	  function fillCerca(){
	  	var regione = $('#regione').val();
	  	var provincia = $('#provincia').val();
	  	var comune = $('#comune').val();
	  	var from = $('#from').val();
	  	var cicliScolastici = $('#cicliScolastici').val();    

	  	console.log('dentro'+regione);
	  	console.log('dentro'+provincia);
	  	console.log('dentro'+comune);
	  }
	      
	      
	
	      function callFillAndamentoValidazione(urlToCall){

	    	  $.xhrPool = [];

	    	  $.xhrPool.abortAll = function() {
	    	    /* Original example used _underscore api
	    	      _.each(this, function(jqXHR) {
	    	          jqXHR.abort();
	    	      });
	    	    */
	    	      $.each(this, function(jqXHR) { 
	    	          jqXHR.abort(); 
	    	      });
	    	  };
	    	  
	    	  $.ajaxSetup({
	    		    beforeSend: function(jqXHR) {
	    		        $.xhrPool.push(jqXHR);
	    		    }
	    		});
	  	var request = $.ajax({ 
	  	    type: 'GET', 
	  	    url: urlToCall, 
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
	  	          			
	  	          		var arr2= [];
		          			var arr3= [];
		          		var arr5= [];
	          			var arr6= [];
	          		 var tt = document.getElementById('from').value;
var arrsplit= [];
arrsplit=tt.split("/");
var ciao=arrsplit[1]+"/"+arrsplit[0]+"/"+arrsplit[2];
		        	    var date =  new Date(ciao);
		        	    var newdate = new Date(date);
		        	    var dd = newdate.getDate();
		        	    var mm = newdate.getMonth() + 1;
		        	   
		        	    var y = newdate.getFullYear();
		          		var lunghezza=dd+15;
                   var count=0;
		          		var maxDay=0;
                   
                  
                  if (mm == 01 || mm == 03 || mm == 05 || mm == 07 || mm == 08 || mm == 10 || mm == 12){
                  	arr5= [];
	          			 arr6= [];
                  	maxDay=31;
	          		for (var d=dd; d < lunghezza; d++)	{
	          		if( d > maxDay && d < 41) {
	          		var str = d;
	          		var res = str.toString().substring(1, 2);
	          		if (str == 40 ){
	          		arr5.push("Giorno " + "09");
	          		arr6.push(obj[count].value);
	          		count++;	
	          		}
	          		else {
	          	     arr5.push("Giorno " + "0" + [res-1]);
		          		arr6.push(obj[count].value);
		          		count++;
	          		}
	          		}
	          	else if (d > maxDay && d > 40) {
		          	
	          	var str = d;
          		var res = str.toString().substring(1, 2);
          	     arr5.push("Giorno " + "1" + [res-1]);
	          		arr6.push(obj[count].value);
	          		count++;
	          		
	          		}
	          		else {
		          	
		          	     arr5.push("Giorno " + d);
			          		arr6.push(obj[count].value);
			          		count++;
		          		
		          		}
	          		}
                  }
                  
                  else if ( mm == 04 || mm == 06 || mm == 09 || mm == 11){
                  	 arr5= [];
	          			 arr6= [];
                  	maxDay=30;
	          		for (var d=dd; d < lunghezza; d++)	{
	          		if( d > maxDay && d < 40) {
	          		var str = d;
	          		var res = str.toString().substring(1, 2);
	          	     arr5.push("Giorno " + "0" + res );
		          		arr6.push(obj[count].value);
		          		count++;
	          		}
	          		
	          	else if (d > maxDay && d > 39) {
		          	
		          	var str = d;
	          		var res = str.toString().substring(1, 2);
	          	     arr5.push("Giorno " + "1" + res );
		          		arr6.push(obj[count].value);
		          		count++;
		          		
		          		}
	          	else {
		          	
	          	     arr5.push("Giorno " + d);
		          		arr6.push(obj[count].value);
		          		count++;
	          		
	          		}
		          		}
                  }
                  
                  else if ( mm == 02){
                  	
                  	/*for (var d=0; d < obj.length; d++)	{
			          		arr5.push("Giorno " + [d+1]);
			          		arr6.push(obj[d].value);
			          		
			          		}*/
                  	arr5= [];
	          			 arr6= [];
                  	maxDay=28;
	          		for (var d=dd; d < lunghezza; d++)	{
	          		if( d > maxDay && d < 44) {
	          		var str = d;
	          		var res = str.toString().substring(1, 2);
	          		if (str == 29 || str == 30 || str == 31 || str == 32 || str == 33 || str == 34 || str == 35 || str == 36 || str == 37     ){
	          		arr5.push("Giorno " + "0" + [parseInt(str-28)]);
	          		arr6.push(obj[count].value);
	          		count++;
	          		
		          		}
	 
	          		
	         /* 	
	          else {
	          		arr5.push("Giorno " + [parseInt(str-28)]);
	          		arr6.push(obj[count].value);
	          		count++;
	          		}*/
	          		
	          		}
	          	else {
		          	
	          	     arr5.push("Giorno " + d);
		          		arr6.push(obj[count].value);
		          		count++;
	          		
	          		}
	          		
	          
		          		}
	        	    
                  }
                  
                    var strGiorni = arr5.toString();
                    var resGiorni = strGiorni.split(",");

                    var strDati= arr6.toString();
                    var resDati = strDati.split(",");
	                    
		          			var canvas = document.getElementById('chartLine');
		          			var data = {
		          		
		          			    labels: resGiorni,
		
		          			    datasets: [
		          			        {
		          			            label: "Grafico Andamento",
		          			            fill: false,
		          			            lineTension: 0.1,
		          			            backgroundColor: "rgba(75,192,192,0.4)",
		          			            borderColor: "rgba(75,192,192,1)",
		          			            borderCapStyle: 'butt',
		          			            borderDash: [],
		          			            borderDashOffset: 0.0,
		          			            borderJoinStyle: 'miter',
		          			            pointBorderColor: "rgba(75,192,192,1)",
		          			            pointBackgroundColor: "#fff",
		          			            pointBorderWidth: 1,
		          			            pointHoverRadius: 5,
		          			            pointHoverBackgroundColor: "rgba(75,192,192,1)",
		          			            pointHoverBorderColor: "rgba(220,220,220,1)",
		          			            pointHoverBorderWidth: 2,
		          			            pointRadius: 5,
		          			            pointHitRadius: 10,
		          			            data: resDati,
		          			        }
		          			    ]
	                      
		          			};

		          			var option = {
		          				showLines: true
		          			};
	  	          				          			myLineChart = Chart.Line(canvas,{
	  	          				          				data:data,
	  	          				          			  options:option
	  	          				          			});

	  	          				             
	  	          				          		arr2 = [];
	  	          				          		arr3 = [];
	  	          				          	arr5 = [];
	            				          		arr6 = [];

	  	    }
	  		});
	      
	  	request.fail(function( jqXHR, textStatus ) {
	  		console.log('jqXHR '+jqXHR);
	  		console.log('request '+request);
	  		
	          alert( "Request failed: " + textStatus );
	      });
	  	
	      }
	      

	      function cercaFillAndamento(){
	      	  
	    
	      var regione = $('#regione').val();
	  	var provincia = $('#provincia').val();
	  	var comune = $('#comune').val();
	  	var from = $('#from').val();  
	  	var cicliScolastici = $('#cicliScolastici').val();    
	  var urlToCall = "getDatiAndamentoAcquisizione.json?regione="+regione+"&provincia="+provincia+"&comune="+comune+"&from="+from+"&cicliScolastici="+cicliScolastici;

	  	var request = $.ajax({ 
	  	    type: 'GET', 
	  	    url: urlToCall,
	  	    data: { get_param: 'value' }, 
	  	    dataType:'json',
	  	    success: function (data) { 
	  	          			  console.log('ciao dentro data '+data);
	  	          			var myData = JSON.stringify(data);  
	  	          			 console.log('ciao myData2 '+myData);
	  	          			
	  	          			console.log( "call myData " +myData);
	  	          			console.log( "myData.compilazione " +myData.compilazione);
	  	          			var obj = JSON.parse( myData);
	  	          			console.log( "call 1 obj " +obj);

	  	          		
	  	          				          			var arr2= [];
	  	          				          			var arr3= [];
	  	          				          		var arr5= [];
	            				          			var arr6= [];
	            				          		 var tt = document.getElementById('from').value;
var arrsplit= [];
arrsplit=tt.split("/");
var ciao=arrsplit[1]+"/"+arrsplit[0]+"/"+arrsplit[2];
	  	          				        	    var date =  new Date(ciao);
	  	          				        	    var newdate = new Date(date);
	  	          				        	    var dd = newdate.getDate();
	  	          				        	    var mm = newdate.getMonth() + 1;
	  	          				        	   
	  	          				        	    var y = newdate.getFullYear();
	  	          				          		var lunghezza=dd+15;
	                                           var count=0;
	  	          				          		var maxDay=0;
	                                           
	                                          
	                                          if (mm == 01 || mm == 03 || mm == 05 || mm == 07 || mm == 08 || mm == 10 || mm == 12){
	                                          	arr5= [];
	            				          			 arr6= [];
	                                          	maxDay=31;
	            				          		for (var d=dd; d < lunghezza; d++)	{
	            				          		if( d > maxDay && d < 41) {
	            				          		var str = d;
	            				          		var res = str.toString().substring(1, 2);
	            				          		if (str == 40 ){
	            				          		arr5.push("Giorno " + "09");
	            				          		arr6.push(obj[count].value);
	            				          		count++;	
	            				          		}
	            				          		else {
	            				          	     arr5.push("Giorno " + "0" + [res-1]);
	  	          				          		arr6.push(obj[count].value);
	  	          				          		count++;
	            				          		}
	            				          		}
	            				          	else if (d > maxDay && d > 40) {
	  	          				          	
	            				          	var str = d;
	        				          		var res = str.toString().substring(1, 2);
	        				          	     arr5.push("Giorno " + "1" + [res-1]);
	            				          		arr6.push(obj[count].value);
	            				          		count++;
	           				          		
	           				          		}
	            				          		else {
	  	          				          	
	  	          				          	     arr5.push("Giorno " + d);
	  		          				          		arr6.push(obj[count].value);
	  		          				          		count++;
	  	          				          		
	  	          				          		}
	            				          		}
	                                          }
	                                          
	                                          else if ( mm == 04 || mm == 06 || mm == 09 || mm == 11){
	                                          	 arr5= [];
	            				          			 arr6= [];
	                                          	maxDay=30;
	            				          		for (var d=dd; d < lunghezza; d++)	{
	            				          		if( d > maxDay && d < 40) {
	            				          		var str = d;
	            				          		var res = str.toString().substring(1, 2);
	            				          	     arr5.push("Giorno " + "0" + res );
	  	          				          		arr6.push(obj[count].value);
	  	          				          		count++;
	            				          		}
	            				          		
	            				          	else if (d > maxDay && d > 39) {
	  	          				          	
	                				          	var str = d;
	            				          		var res = str.toString().substring(1, 2);
	            				          	     arr5.push("Giorno " + "1" + res );
	                				          		arr6.push(obj[count].value);
	                				          		count++;
	               				          		
	               				          		}
	            				          	else {
	  	          				          	
	            				          	     arr5.push("Giorno " + d);
	  	          				          		arr6.push(obj[count].value);
	  	          				          		count++;
	            				          		
	            				          		}
	  	          				          		}
	                                          }
	                                          
	                                          else if ( mm == 02){
	                                          	
	                                          	/*for (var d=0; d < obj.length; d++)	{
	  		          				          		arr5.push("Giorno " + [d+1]);
	  		          				          		arr6.push(obj[d].value);
	  		          				          		
	  		          				          		}*/
	                                          	arr5= [];
	            				          			 arr6= [];
	                                          	maxDay=28;
	            				          		for (var d=dd; d < lunghezza; d++)	{
	            				          		if( d > maxDay && d < 44) {
	            				          		var str = d;
	            				          		var res = str.toString().substring(1, 2);
	            				          		if (str == 29 || str == 30 || str == 31 || str == 32 || str == 33 || str == 34 || str == 35 || str == 36 || str == 37     ){
	            				          		arr5.push("Giorno " + "0" + [parseInt(str-28)]);
	          				          		arr6.push(obj[count].value);
	          				          		count++;
	            				          		
	                				          		}
	            				 
	            				          		
	            				         /* 	
	            				          else {
	          				          		arr5.push("Giorno " + [parseInt(str-28)]);
	          				          		arr6.push(obj[count].value);
	          				          		count++;
	          				          		}*/
	            				          		
	            				          		}
	            				          	else {
	  	          				          	
	           				          	     arr5.push("Giorno " + d);
	  	          				          		arr6.push(obj[count].value);
	  	          				          		count++;
	           				          		
	           				          		}
	            				          		
	            				          
	  	          				          		}
	            				        	    
	                                          }
	                                          
	            			                    var strGiorni = arr5.toString();
	            			                    var resGiorni = strGiorni.split(",");

	            			                    var strDati= arr6.toString();
	            			                    var resDati = strDati.split(",");
	  	          			                    
	  	          				          			var canvas = document.getElementById('chartLine');
	  	          				          			var data = {
	  	          				          		
	  	          				          			    labels: resGiorni,
	  	          				
	  	          				          			    datasets: [
	  	          				          			        {
	  	          				          			            label: "Grafico Andamento",
	  	          				          			            fill: false,
	  	          				          			            lineTension: 0.1,
	  	          				          			            backgroundColor: "rgba(75,192,192,0.4)",
	  	          				          			            borderColor: "rgba(75,192,192,1)",
	  	          				          			            borderCapStyle: 'butt',
	  	          				          			            borderDash: [],
	  	          				          			            borderDashOffset: 0.0,
	  	          				          			            borderJoinStyle: 'miter',
	  	          				          			            pointBorderColor: "rgba(75,192,192,1)",
	  	          				          			            pointBackgroundColor: "#fff",
	  	          				          			            pointBorderWidth: 1,
	  	          				          			            pointHoverRadius: 5,
	  	          				          			            pointHoverBackgroundColor: "rgba(75,192,192,1)",
	  	          				          			            pointHoverBorderColor: "rgba(220,220,220,1)",
	  	          				          			            pointHoverBorderWidth: 2,
	  	          				          			            pointRadius: 5,
	  	          				          			            pointHitRadius: 10,
	  	          				          			            data: resDati,
	  	          				          			        }
	  	          				          			    ]
	  	          			                      
	  	          				          			};

	  	          				          			var option = {
	  	          				          				showLines: true
	  	          				          			};
	  	          				          			
	  		          				          		
	  			          				          	myLineChart.destroy();

	  		          				          		myLineChart = Chart.Line(canvas,{
	  	          				          				data:data,
	  	          				          			  options:option
	  	          				          			});

	  	          				          	   
	  	          				             
	  	          				          		arr2 = [];
	  	          				          		arr3 = [];
	  	          				          	arr5 = [];
	            				          		arr6 = [];

	  	    }
	  	
	  	});
	  	
	      
	  	
	  	
	  	
	  		
	  		request.fail(function( jqXHR, textStatus ) {
	  			console.log('jqXHR '+jqXHR);
	  			console.log('request '+request);
	  			
	              alert( "Request failed: " + textStatus );
	          });

	      }
	      
	      
	      
	      var runButton = document.getElementById("run");
	      runButton.addEventListener("click", cercaFillAndamento);
	      }); 
	      
	      

	  	function changeTo() {
	  	    var tt = document.getElementById('from').value;

	  	    var date = new Date(tt);
	  	    var newdate = new Date(date);

	  	    newdate.setDate(newdate.getDate() + 14);
	  	    
	  	    var dd = newdate.getDate();
	  	    var mm = newdate.getMonth() + 1;
	  	    var y = newdate.getFullYear();

	  	    var someFormattedDate = mm + '/' + dd + '/' + y;
	  	    document.getElementById('to').value = someFormattedDate;
	  	}

	  	function changeFrom() {
	  	    var tt = document.getElementById('to').value;

	  	    var date = new Date(tt);
	  	    var newdate = new Date(date);

	  	    newdate.setDate(newdate.getDate() - 14);
	  	    
	  	    var dd = newdate.getDate();
	  	    var mm = newdate.getMonth() + 1;
	  	    var y = newdate.getFullYear();

	  	    var someFormattedDate = mm + '/' + dd + '/' + y;
	  	    document.getElementById('from').value = someFormattedDate;
	  	}


