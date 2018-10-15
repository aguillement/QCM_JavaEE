<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../../Common/header.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Management test</title>
</head>
<body>
	<div class="container-fluid">
		<%@ include file="../../Common/navbar.jspf"%>
		<div class="row" style="margin-top: 20px;">
			<div class="col-lg-12">
				<form
					action="
		<c:out value="${pageContext.servletContext.contextPath}" />
		/Formateur/updateTest"
					name="updateTest" method="post">
					<fieldset>
						<input class="form-control" value="${test.id}" type="hidden"
							name="idTest">
						<div class="form-group">
							<label for="label">Label :</label> <input class="form-control"
								value="${test.label}" type="text" name="label" id="label" />
						</div>

						<div class="form-group">
							<label for="firstname">Statement :</label> <input
								value="${test.statement}" class="form-control" type="text"
								name="statement" id="statement" />
						</div>

						<div class="form-group">
							<label for="duration">Duration :</label> <input
								class="form-control" value="${test.duration}" type="text"
								name="duration" id="duration" />
						</div>

						<div class="form-group">
							<label for="high_level">High level :</label> <input
								class="form-control" value="${test.high_level}" type="text"
								name="high_level" id="high_level" />
						</div>

						<div class="form-group">
							<label for="low_level">Low level :</label> <input
								class="form-control" value="${test.low_level}" type="text"
								name="low_level" id="low_level" />
						</div>

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