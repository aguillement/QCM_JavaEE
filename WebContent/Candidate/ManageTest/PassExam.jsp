<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../../Common/header.jspf"%>
<title>Test en cours</title>
</head>
<body>
	<div class="container-fluid">
		<%@ include file="../../Common/navbar.jspf"%>
		<div class="row" style="margin-top: 20px;">
			<c:choose>
				<c:when test="${empty requestScope.error}">
					<div class="col-lg-2" style="border-right: #d6d6d6 1px solid;">
						<h5>Liste des questions :</h5>
						<hr>
						<c:forEach items="${ sessionScope.examQuestions }"
							var="examQuestion">
							<a id="${ examQuestion.question.id }"
								class="badge 
						<c:choose>
							<c:when test="${ examQuestion.isMarked }">badge-danger</c:when>
							<c:otherwise>badge-light</c:otherwise>
						</c:choose>
						<c:if test="${ examQuestion.question.id == requestScope.currentQuestion.id}">currentQuestion</c:if>
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
						<div class="row">
							<h2 style="display: inline-block;" class="col-lg-10">
								<c:out value="${sessionScope.exam.test.label}" />
							</h2>
							<div class="col-lg-2" style="display: inline-block;">
								<div class="my-2 my-sm-0" style="text-align: center;">
									<p style="margin-bottom: 0;">Temps restant :</p>
									<b id="timer">0h 00min 00s</b>
								</div>
							</div>
						</div>

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
									<c:set var="isCheck" value="false" scope="page" />
									<div class="form-group">
										<c:forEach items="${ requestScope.answers }" var="answer">
											<c:choose>
												<c:when test="${ answer.id eq proposition.id }">
													<c:set var="isCheck" value="true" scope="page" />
												</c:when>
											</c:choose>
										</c:forEach>
										<div class="custom-control custom-checkbox">
											<input type="checkbox" class="custom-control-input"
												name="responses"
												id="response_<c:out value="${proposition.id}" />"
												value="<c:out value="${proposition.id}" />"
												<c:if test="${ pageScope.isCheck eq 'true' }" var="variable">
										    checked
										</c:if>>
											<label class="custom-control-label"
												for="response_<c:out value="${proposition.id}" />"><c:out
													value="${proposition.statement}" /></label>
										</div>
									</div>
								</c:forEach>
								<input type="hidden" id="question_id" name="question_id"
									value="<c:out value="${requestScope.currentQuestion.id}" />" />
								<p class="lead">
									<button type="submit" class="btn btn-primary btn-lg">Confirmer</button>
								</p>
								<input type="hidden" id="timeSpent"
									value="<c:out value="${sessionScope.exam.timeSpent}" />" /> <input
									type="hidden" id="duration"
									value="<c:out value="${sessionScope.exam.test.duration}" />" />
								<input type="hidden" id="examID"
									value="<c:out value="${sessionScope.exam.id}" />" />
							</form>
						</div>
						<button type="button" class="btn btn-info"
							onclick="questionMarked();">Marquer la question</button>
						<div class="text-right">
							<button type="button" class="btn btn-outline-success" disabled>Rendre
								le test</button>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<div class="alert alert-dismissible alert-primary">
						<button type="button" class="close" data-dismiss="alert">&times;</button>
						<strong>Attention!</strong> Le test que vous rechercher n'existe
						pas ou n'est plus accessible.
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<c:if test="${empty requestScope.error}">
		<script type="text/javascript"
			src="<c:out value="${pageContext.servletContext.contextPath}" />/theme/js/script.js">
			
		</script>
	</c:if>
</body>
</html>