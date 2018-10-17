<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../../Common/header.jspf"%>
<title>Rendre un test</title>
</head>
<body>
	<div class="container-fluid">
		<%@ include file="../../Common/navbar.jspf"%>
		<div class="row" style="margin-top: 20px;">
			<div class="col-lg-12">
				<c:if test="${!empty  requestScope.error }">
					<div class="alert alert-dismissible alert-primary">
						<button type="button" class="close" data-dismiss="alert">&times;</button>
						<strong>Attention!</strong>
						<c:out value='${requestScope.error}' />
					</div>
				</c:if>
				<c:choose>
					<c:when test="${!empty  requestScope.error }">
						<div class="alert alert-dismissible alert-primary">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							<strong>Attention!</strong>
							<c:out value='${requestScope.error}' />
						</div>
					</c:when>
					<c:otherwise>
						<div class="alert alert-dismissible alert-success">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							<strong>Succès!</strong>
							<c:out value='${requestScope.message}' />
						</div>

						<div class="jumbotron">
							<h1 class="display-4 text-center">Résultat obtenu à l'épreuve</h1>
							<p class="lead text-center">Epreuvre : <c:out value='${requestScope.result.label}' /></p>
							<hr class="my-4">
							<p class="lead text-center">Liste des résultats :</p>
							<p class="lead text-center">
							Nombre de questions justes : 
							<c:out value='${requestScope.result.nbRightQuestion}' />
							</p>
							<p class="lead text-center">
							Nombre de questions répondues : 
							<c:out value='${requestScope.result.nbAnsweredQuestion}' /> / 
							<c:out value='${requestScope.result.nbQuestion}' />
							</p>			
							<p class="lead text-center">Votre note : <c:out value='${requestScope.result.note}' />/20</p>
							<p class="lead text-center">Votre niveau d'acquisition :
								<c:out value='${requestScope.result.result}' /></p>
							<p class="lead text-center">
								<a class="btn btn-primary btn-lg"
									href="<c:out value="${pageContext.servletContext.contextPath}" />/Home"
									role="button">Quitter l'épreuve</a>
							</p>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>


</body>
</html>