<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>      
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Management test</title>
</head>
<body>
	<form
		action="
		<c:out value="${pageContext.servletContext.contextPath}" />
		/Formateur/updateTest"
		name="updateTest" method="post">
		<fieldset>
			<div class="form-group">
				<label for="label">Label :</label> <input class="form-control"
					type="text" name="label" id="label" />
			</div>

			<div class="form-group">
				<label for="firstname">Statement :</label> <input
					class="form-control" type="text" name="statement"
					id="statement" />
			</div>

			<div class="form-group">
				<label for="duration">Duration :</label> <input class="form-control"
					type="text" name="duration" id="duration" />
			</div>
			
			<div class="form-group">
				<label for="high_level">High level :</label> <input class="form-control"
					type="text" name="high_level" id="high_level" />
			</div>
			
			<div class="form-group">
				<label for="low_level">Low level :</label> <input class="form-control"
					type="text" name="low_level" id="low_level" />
			</div>
			
			<div class="text-center">
				<button type="submit" class="btn btn-outline-success"
					name="Save" value="Save">Save</button>
			</div>
		</fieldset>
	</form>

</body>
</html>