<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../../Common/header.jspf"%>
<title>Test view</title>
</head>
<body>

	<div class="container-fluid">
		<%@ include file="../../Common/navbar.jspf"%>
		<div class="row" style="margin-top: 20px;">
			<div class="col-lg-12">
				<div class="col-lg-8">
					<h2>Liste des tests</h2>

					<table class="table table-hover">
						<thead class="thead-dark">
							<tr>
								<th scope="col">Label</th>
								<th scope="col">Statement</th>
								<th scope="col">Duration</th>
								<th scope="col">High level</th>
								<th scope="col">Low level</th>
								<th scope="col">Fonctionnalités</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${lstTest}" var="test">
								<tr>
									<td>${test.label}</td>
									<td>${test.statement}</td>
									<td>${test.duration}</td>
									<td>${test.high_level}</td>
									<td>${test.low_level}</td>
									<td>
										<div class="row">
											<div class="col-6">
												<button type="button" class="btn btn-default">
													<span class="glyphicon glyphicon-file"></span> Update
												</button>
											</div>
											<div class="col-6">
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