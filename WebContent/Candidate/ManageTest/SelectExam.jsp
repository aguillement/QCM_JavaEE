<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../../Common/header.jspf"%>
<title>Sélectionner une épreuve</title>
</head>
<body>

	<div class="container-fluid">
		<%@ include file="../../Common/navbar.jspf"%>
		<div class="row" style="margin-top: 20px;">
			<div class="col-lg-12">
				<h2>Sélectionner une épreuve</h2>
				<c:choose>
					<c:when test="${not empty requestScope.exams }">
						<div class="list-group">
							<c:forEach items="${ requestScope.exams }" var="exam">

								<a href="Exam?id=<c:out value="${exam.id}"/>"
									class="list-group-item list-group-item-action flex-column align-items-start">
									<div class="d-flex w-100 justify-content-between">
										<h5 class="mb-1">
											<c:out value="${exam.test.label}" />
										</h5>
										<small>Durée : <c:out value="${exam.test.duration}" />
											minutes
										</small>
									</div>
									<p class="mb-1">
										<c:out value="${exam.test.statement}" />
									</p>
								</a>
							</c:forEach>
						</div>
					</c:when>
					<c:otherwise>
					    	Aucun test de disponible
					 </c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</body>
</html>