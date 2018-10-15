<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../../Common/header.jspf"%>
<title>Theme view</title>
</head>
<body>

	<div class="container-fluid">
		<%@ include file="../../Common/navbar.jspf"%>
		<div class="row" style="margin-top: 20px;">
			<div class="col-lg-12">
				<div class="col-lg-3">
					<h2>Liste des thèmes</h2>

					<table class="table table-hover">
						<thead class="thead-dark">
							<tr>
								<th scope="col">Label</th>
								<th scope="col">Fonctionnalités</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${lstTheme}" var="theme">
								<tr>
									<td>${theme.label}</td>
									<td>
										<div class="row">
											<div class="col-6">
												<a class="btn btn-primary btn-lg"
												href="<c:out value="${pageContext.servletContext.contextPath}" />/Formateur/updateTheme?id=<c:out value="${theme.id}" />"
												role="button">Modify</a>
											</div>
											<div class="col-6">
													<a class="btn btn-primary btn-lg"
												href="<c:out value="${pageContext.servletContext.contextPath}" />/Formateur/deleteTheme?id=<c:out value="${theme.id}" />"
												role="button">Delete</a>
											</div>
										</div>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

</body>
</html>