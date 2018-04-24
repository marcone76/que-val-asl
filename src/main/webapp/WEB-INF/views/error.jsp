<%@ include file="includes/taglib.jsp"%>

<div id="page">
	<div id="content">
		
		<script type="text/javascript">
			$( "#moreDetails" ).click(function() {
				$('#stackTrace').show();
				$('#stackTraceShort').hide();
			});
		</script> 
	
		<div id="stackTraceShort" class="info ui-corner-all">
			<c:if test="${errorObject.class.simpleName eq 'FakeException'}">
				<h2>Richiesta eseguita</h2>
				<pre>${errorObject.message}</pre>
			</c:if>
			
			<c:if test="${errorObject.class.simpleName != 'FakeException'}">
				${custom:abbreviate(errorObject.message,40)} (<a id="moreDetails" href="javascript:void(0);"><b>ulteriori dettagli</b></a>)
			</c:if>
			
		</div>
		<br/>		
		<div id="stackTrace" class="ui-corner-all" style="display:none;">
			<pre style="text-align: left; font-size:11px; height:300px; overflow:auto;">${custom:stacktrace(errorObject)}</pre>
		</div>
	</div>
</div>
