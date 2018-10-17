<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid">
		<%@ include file="../../Common/navbar.jspf"%>
		<div class="row" style="margin-top: 20px;">
			<div class="col-lg-12">

				<form class="form-inline my-2 my-lg-0">
					<input class="form-control mr-sm-2" type="search"
						placeholder="Search" aria-label="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form>

				<table class="table table-hover">
					<thead class="thead-dark">
						<tr>
							<th scope="col">Prenom</th>
							<th scope="col">Nom</th>
							<th scope="col">Mail</th>
							<th scope="col">Profile</th>
							<th scope="col">Promotion</th>
						</tr>
					</thead>

					<c:forEach items="${lstUserCandidats}" var="user">
						<tr>
							<td>${user.lastname}</td>
							<td>${test.firstname}</td>
							<td>${test.email}</td>
							<td>${test.getProfile().getLabel()}</td>
							<td>${test.getPromotion().getLabel()}</td>
							<td>
								<div class="row">
									<div class="col-6">
										<a class="btn btn-primary btn-lg"
											href="<c:out value="${pageContext.servletContext.contextPath}" />/#?id=<c:out value="${test.id}" />"
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