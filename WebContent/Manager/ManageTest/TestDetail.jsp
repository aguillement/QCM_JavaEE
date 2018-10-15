<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../../Common/header.jspf"%>
<title>Inscription test</title>
</head>
<body>
	<%@ include file="../../Common/navbar.jspf"%>

	${test.getLabel()} - ${test.getStatement()}
	<br>
	<c:if test="${!empty  requestScope.isInsert }">
		<c:choose>
			<c:when test="${ requestScope.isInsert }">
				<div class="alert alert-dismissible alert-success">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					<strong>Succès!</strong>
					<c:out value='${requestScope.message}' />
				</div>
			</c:when>
			<c:otherwise>
				<div class="alert alert-dismissible alert-primary">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					<strong>Attention!</strong>
					<c:out value='${requestScope.message}' />
				</div>
			</c:otherwise>
		</c:choose>
	</c:if>

	<form method="post" action="${request.getContextPath()}">
		<div class="form-group">
			<label for="promotions">Promotions</label> <select
				class="form-control" id="promotions" multiple="multiple" name="promos">
				<c:forEach items="${requestScope.promos}" var="promo">
					<option><a href="test/ajouter?id=${test.getId()}">
							${promo.getLabel()} </a>
					</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group">
			<label>Date et heure de début</label> <input type="date"
				name="startDate" class="form-control"> <input type="time"
				name="startTime" class="form-control">
		</div>
		<div class="form-group">
			<label>Date et heure de fin</label> <input type="date" name="endDate"
				class="form-control"> <input type="time" name="endTime"
				class="form-control">
		</div>

		<button type="submit">Inscrire</button>
	</form>

</body>
</html>