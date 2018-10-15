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
				<div class="jumbotron">
					<h1 class="display-3 text-center">
						<c:out value="${requestScope.exam.test.label}" />
					</h1>
					<p class="lead text-center">
						Durée :
						<c:out value="${requestScope.exam.test.duration}" />
						minutes
					</p>
					<hr class="my-4">
					<p class="text-center">
						<c:out value="${requestScope.exam.test.statement}" />
					</p>
					<p class="lead text-center">
						<a class="btn btn-primary btn-lg"
							href="<c:out value="${pageContext.servletContext.contextPath}" />/Candidat/PassExam?id=<c:out value="${requestScope.exam.id}" />"
							role="button">Commencer le test</a>
					</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
