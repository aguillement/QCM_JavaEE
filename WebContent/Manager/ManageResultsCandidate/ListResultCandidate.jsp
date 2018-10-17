<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../../Common/header.jspf"%>
<title>List result candidate</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div class="container-fluid">
		<%@ include file="../../Common/navbar.jspf"%>
		<div class="row" style="margin-top: 20px;">
			<div class="col-lg-12">

				<form class="form-inline my-2 my-lg-0"  method="post" action="<c:out value="${pageContext.servletContext.contextPath}" />
		/Responsable/ShowListResultCandidate">
					<input class="form-control mr-sm-2" type="search" name="search"
						placeholder="Search" aria-label="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form>
				<br>

				<table class="table table-hover">
					<thead class="thead-dark">
						<tr>
							<th scope="col">Prenom</th>
							<th scope="col">Nom</th>
							<th scope="col">Mail</th>
							<th scope="col">Profile</th>
							<th scope="col">Promotion</th>
							<th scope="col">Fonctionnalités</th>
						</tr>
					</thead>

					<c:forEach items="${lstUserCandidate}" var="user">
						<tr>
							<td>${user.lastname}</td>
							<td>${user.firstname}</td>
							<td>${user.mail}</td>
							<td>${user.getProfile().getLabel()}</td>
							<td>${user.getPromotion().getLabel()}</td>
							<td>
								<div class="row">
									<div class="col-6">
										<a class="btn btn-primary btn-lg"
											href="<c:out value="${pageContext.servletContext.contextPath}" />/Responsable/ShowDetailResultCandidate?id=<c:out value="${user.id}" />"
											role="button">Details résultats</a>
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
</body>
</html>