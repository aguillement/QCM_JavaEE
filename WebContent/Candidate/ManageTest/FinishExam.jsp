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
				<h2>Rendre un test</h2>
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
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>


</body>
</html>