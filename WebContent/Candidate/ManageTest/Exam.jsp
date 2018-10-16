<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../../Common/header.jspf"%>
<title>Épreuve</title>
</head>
<body>
	<div class="container-fluid">
		<%@ include file="../../Common/navbar.jspf"%>
		<div class="row" style="margin-top: 20px;">
			<div class="col-lg-12">
				<c:choose>
					<c:when test="${not empty requestScope.exam.test}">
						<div class="jumbotron">
							<h1 class="display-3 text-center">
								<c:out value="${requestScope.exam.test.label}" />
							</h1>
							<p class="lead text-center">
								Durée :
								<c:out value="${requestScope.exam.test.duration}" />
								minutes
							</p>
							<c:if test="${exam.state eq 'EC'}">
								<c:set var="timeSpent"
									value="${exam.test.duration - exam.timeSpent}" />
								<p class="lead text-center">
									Temps restant :
									<c:out value="${timeSpent}" />
									minutes
								</p>
							</c:if>
							<hr class="my-4">
							<p class="text-center">
								<c:out value="${requestScope.exam.test.statement}" />
							</p>
							<p class="lead text-center">
								<a class="btn btn-primary btn-lg"
									href="<c:out value="${pageContext.servletContext.contextPath}" />/Candidat/PassExam?id=<c:out value="${requestScope.exam.id}" />"
									role="button"> <c:choose>
										<c:when test="${exam.state eq 'EC'}">Reprendre le test
								</c:when>
										<c:otherwise>Commencer le test</c:otherwise>
									</c:choose>
								</a>
							</p>
						</div>
					</c:when>
					<c:otherwise>
						<div class="alert alert-dismissible alert-primary">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							<strong>Attention!</strong> Le test que vous recherchez n'existe
							pas ou n'est plus accessible.
						</div>
					</c:otherwise>
				</c:choose>

			</div>
		</div>
	</div>
</body>
</html>
