<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-sm-9">
				<form action="<%=request.getContextPath() %>/login/ValidateAccessUser" method="post">					
				  	<div class="form-group">i
				    	<label for="identifiant">Email :</label>
				    	<input type="email" class="form-control" id="identifiant" name="identifiant">
				  	</div>
				  	<div class="form-group">
				    	<label for="motdepasse">Password :</label>
				    	<input type="password" class="form-control" id="motdepasse" name="motdepasse">
				  	</div>
				  	<button type="submit" class="btn btn-default">Connection</button>
				</form>
			</div>
		</div>
	</div>
	
</body>
</html>