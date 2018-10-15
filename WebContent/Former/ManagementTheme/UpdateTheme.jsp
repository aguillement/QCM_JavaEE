<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../../Common/header.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Management theme</title>
</head>
<body>
	<div class="container-fluid">
		<%@ include file="../../Common/navbar.jspf"%>
		<div class="row" style="margin-top: 20px;">
			<div class="col-lg-12">
				<form
					action="
		<c:out value="${pageContext.servletContext.contextPath}" />
		/Formateur/updateTheme"
					name="updateTheme" method="post">
					<fieldset>
						<input class="form-control" value="${theme.id}" type="hidden"
							name="idTheme">
						<div class="form-group">
							<label for="label">Label :</label> <input class="form-control"
								value="${theme.label}" type="text" name="label" id="label" />
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