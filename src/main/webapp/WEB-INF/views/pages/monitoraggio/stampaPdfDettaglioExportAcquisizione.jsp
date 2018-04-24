<%@ include file="../../includes/taglib.jsp"%>


	<h2>DETTAGLIO ESPORTA ACQUISIZIONE ${inCorsoValidate}</h2>

	<div id="tabellaDomandeInCorso-per-download">
		<table>
			<thead>
				<tr>
					<th>Codice Scuola</th>
					<th>Codice Edificio</th>
					<th>Descrizione Questionario</th>
					<th>Descrizione Sezione</th>
					<th>Codice Domanda</th>
					<th>Descrizione Domanda</th>
					<th>Descrizione Risposta</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listaDomanda}" var="dto">
					<tr>
						<td>${dto.codiceScuola}</td>
						<td>${dto.codiceEdificio}</td>
						<td>${dto.descrizioneQuestionario}</td>
						<td>${dto.descrizioneSezione}</td>
						<td>${dto.codiceDomanda}</td>
						<td>${dto.descrizioneDomanda}</td>
						<td>${dto.descrizioneRisposta}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>


