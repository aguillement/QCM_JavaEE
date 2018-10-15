<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../../Common/header.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"">
<title>Management question</title>
</head>
<body>
	<div class="container-fluid">
		<%@ include file="../../Common/navbar.jspf"%>
		<div class="row" style="margin-top: 20px;">
			<div class="col-lg-12">
				<form
					action="
		<c:out value="${pageContext.servletContext.contextPath}" />
		/Formateur/updateQuestion"
					name="updateQuestion" method="post">
					<fieldset>
						<input class="form-control" value="${question.id}" type="hidden"
							name="idQuestion">
						<div class="form-group">
							<label for="statement">Statement :</label> <input
								class="form-control" value="${question.statement}" type="text"
								name="statement" id="statement">
						</div>

						<div class="form-group">
							<label for="media">Media :</label> <input
								value="${question.media}" class="form-control" type="text"
								name="media" id="media" />
						</div>

						<div class="form-group">
							<label for="points">Points :</label> <input class="form-control"
								value="${question.points}" type="text" name="points" id="points" />
						</div>

						<select name="theme">
							<c:forEach items="${lstTheme}" var="theme">
								<option value="${theme.id}">${theme.label}</option>
							</c:forEach>
						</select>

						<div class="text-center">
							<button type="submit" class="btn btn-outline-success"
								name="Update" value="">Update</button>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</body>
</html>