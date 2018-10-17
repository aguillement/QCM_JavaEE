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
				<h2>Vos épreuves</h2>
				<p class="lead">Voici la liste des tests auquels vous êtes inscrits.<br />Selectionnez le test à passer et confirmez son lancement.</p>
				<c:choose>
					<c:when test="${not empty requestScope.exams }">
						<div class="list-group">
							<c:forEach items="${ requestScope.exams }" var="exam">
								<a href="Exam?id=<c:out value="${exam.id}"/>"
									class="list-group-item list-group-item-action flex-column align-items-start
									<c:if test="${exam.state eq 'EC'}">
										active
									</c:if>
									">
									<div class="d-flex w-100 justify-content-between">
										<h5 class="mb-1">
											<c:if test="${exam.state eq 'EC'}">
												(En cours)
											</c:if>
											<c:out value="${exam.test.label}" />
										</h5>
									</div>
									<p class="mb-1">
										Inscription valide du <fmt:formatDate pattern = "dd/MM/yyyy à HH:mm" value = "${exam.startDate}" />
											au <fmt:formatDate pattern = "dd/MM/yyyy à HH:mm" value = "${exam.endDate}" />
									</p>
									<p class="mb-1">
										Durée : <c:out value="${exam.test.duration}" />
											minutes
									</p>
									<c:if test="${exam.state eq 'EC'}">
										<c:set var="timeSpent"
											value="${exam.test.duration - exam.timeSpent}" />
										<p class="mb-1">
											Temps restant : <c:out value="${timeSpent}" />
											minutes
										</p>
									</c:if>
								</a><br />
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