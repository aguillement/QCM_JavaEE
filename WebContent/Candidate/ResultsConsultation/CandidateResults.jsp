<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../../Common/header.jspf"%>
<title>Candidate Results</title>
</head>
<body>

	<div class="container-fluid">
		<%@ include file="../../Common/navbar.jspf"%>
		<div class="row" style="margin-top: 20px;">
			<div class="col-12 ">
				<table class="table table-hover">
					<thead class="thead-dark">
						<tr>
							<th scope="col">Epreuve</th>
							<th scope="col">Nb questions</th>
							<th scope="col">Nb bonnes réponses</th>
							<th scope="col">Resultat</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${lstResultExamDTO}" var="resultExamDTO">
							<tr>
								<td>${resultExamDTO.label}</td>
								<td>${resultExamDTO.nbQuestionToDraw}</td>
								<td>${resultExamDTO.nbRightAnswer}</td>
								<td>${resultExamDTO.result}</td>								
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>