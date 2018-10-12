<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../../Common/header.jspf"%>
<title>Test en cours</title>
</head>
<body>
	<div class="container-fluid">
		<%@ include file="../../Common/navbar.jspf"%>
		<div class="row" style="margin-top: 20px;">
			<div class="col-lg-2" style="border-right: #d6d6d6 1px solid;">
				<h5>Liste des questions :</h5>
				<hr>
				<c:forEach items="${ sessionScope.examQuestions }"
					var="examQuestion">
					<a
						class="badge 
						<c:choose>
							<c:when test="${ examQuestion.orderNumber == requestScope.idQuestion}">badge-danger</c:when>
							<c:when test="${ examQuestion.isMarked }">badge-dark</c:when>
							<c:otherwise>badge-light</c:otherwise>
						</c:choose>
						"
						href="
							    	<c:out value="${pageContext.servletContext.contextPath}" />
									/Candidat/PassExam?idQuestion=
									<c:out value="${examQuestion.orderNumber}" />"
						style="font-size: 20px;"> <c:out
							value='${examQuestion.orderNumber}' />
					</a>
				</c:forEach>
			</div>
			<div class="col-lg-10">
				<h2>
					<c:out value="${sessionScope.exam.test.label}" />
				</h2>
				<c:if test="${!empty  requestScope.error }">
					<div class="alert alert-dismissible alert-primary">
						<button type="button" class="close" data-dismiss="alert">&times;</button>
						<strong>Attention!</strong>
						<c:out value='${requestScope.error}' />
					</div>
				</c:if>
				<div class="jumbotron">
					<form
						action="
					<c:out value="${pageContext.servletContext.contextPath}" />
					/Candidat/PassExam?idQuestion=
					<c:out value="${requestScope.idQuestion + 1}" />
					"
						method="POST">
						<p class="lead">
							<c:out value="${requestScope.idQuestion}" />
							-
							<c:out value="${requestScope.currentQuestion.statement}" />
						</p>
						<hr class="my-4">
						<c:forEach items="${ requestScope.currentPropositions }"
							var="proposition">
							<div class="form-group">
								<div class="custom-control custom-checkbox">
									<input type="checkbox" class="custom-control-input"
										name="responses"
										id="response_<c:out value="${proposition.id}" />"
										value="<c:out value="${proposition.id}" />"> <label
										class="custom-control-label"
										for="response_<c:out value="${proposition.id}" />"><c:out
											value="${proposition.statement}" /></label>
								</div>
							</div>
						</c:forEach>
						<p class="lead">
							<button type="submit" class="btn btn-primary btn-lg">Confirmer</button>
						</p>
					</form>
				</div>
				<div class="text-right">
					<button type="button" class="btn btn-outline-success" disabled>Rendre
						le test</button>
				</div>
			</div>
			<div id="compteur"></div>
		</div>
	</div>
</body>
</html>