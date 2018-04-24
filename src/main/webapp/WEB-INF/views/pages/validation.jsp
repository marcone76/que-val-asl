<c:if test="${not empty message}">
	<div class="msg-container error">
		<script type="text/javascript">
			$().ready(function() {
				var messageType = '${message.type}';
				var messageDescr= '${message.message}';
				if( messageType == "INFO"){
					showSuccessMessage(messageDescr);	
				} else if(messageType == "WARNING"){
					showWarningMessage(messageDescr);	
				} else{
					showErrorMessage(messageDescr);
				}
			});
		</script>
	</div>
</c:if>
