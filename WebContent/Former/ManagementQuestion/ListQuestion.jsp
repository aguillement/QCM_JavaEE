<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../../Common/header.jspf"%>
<title>Question view</title>
</head>

<body>
	<div class="container-fluid">
		<%@ include file="../../Common/navbar.jspf"%>
		<div class="row" style="margin-top: 20px;">
			<div class="col-lg-12">
				<div class="col-lg-10">
					<h2>Liste des questions</h2>

					<table class="table table-hover">
						<thead class="thead-dark">
							<tr>
								<th scope="col">Statement</th>
								<th scope="col">Media</th>
								<th scope="col">Points</th>
								<th scope="col">Theme</th>
								<th scope="col">Fonctionnalités</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${lstQuestion}" var="question">
								<tr>
									<td>${question.statement}</td>
									<td>${question.media}</td>
									<td>${question.points}</td>
									<td>${question.theme.label}</td>
									<td>
										<div class="row">
											<div class="col-4">
												<button type="button" class="btn btn-default">
													<span class="glyphicon glyphicon-file"></span> Update
												</button>
											</div>
											<div class="col-4">
												<button type="button" class="btn btn-default">
													<span class="glyphicon glyphicon-remove"></span> Delete
												</button>
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