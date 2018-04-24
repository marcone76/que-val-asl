$( document ).ready(function() {
		
		$('#regione').change(
				function() {
					console.log("change regione...");
					var fieldsRegione = $('#regione').val().split('/');

					var regione = fieldsRegione[0];
					$.ajax({
						url : 'aggiornaListaProvince.json?codRegione='+regione,
						type : 'POST',
						dataType:"json",
						success : function(data) {
							console.log("success!");
							console.log(data);
							 var html = '';
			                 var len = data.province.length;
			                 $('#provincia').html();
			                 $('#provincia').html('<option value=""> TUTTE </option>');
			                 for(var i=0; i<len; i++){
			                	 html=html+'<option value="' + data.province[i].value+ '/'+data.province[i].label+ '">' + data.province[i].label + '</option>';
			                 }
			                 $('#comune').html('<option value=""> TUTTI </option>');
			                 $('#provincia').append(html);
						},
						error : function(data, status, er) {
							console.log("error: " + data + " status: "
									+ status + " er:" + er);
						},
						complete : function() {
							console.log("complete.");
						}
					});
				});

			$('#provincia').change(
					function() {
						console.log("change provincia...");
						var fields = $('#provincia').val().split('/');

						var provincia = fields[0];
						$.ajax({
							url : 'aggiornaListaComuni.json?codProvincia='+provincia,
							type : 'POST',
							dataType:"json",
							success : function(data) {
								console.log("success!");
								console.log(data);
								console.log(data.comuni);
								 var html = '';
				                 var len = data.comuni.length;
				                 console.log(len);
				                 $('#comune').html();
				                 $('#comune').html('<option value=""> TUTTI </option>');
				                 for(var i=0; i<len; i++){
				                	 html=html+'<option value="' + data.comuni[i].value+'/'+data.comuni[i].label + '">' + data.comuni[i].label + '</option>';
				                 }
				               
				                 $('#comune').append(html);
							},
							error : function(data, status, er) {
								console.log("error: " + data + " status: "
										+ status + " er:" + er);
							},
							complete : function() {
								console.log("complete.");
							}
						});
					});
		
	
	});