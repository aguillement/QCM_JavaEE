<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Theme</title>
</head>
<body>

	<form method="post" action="createTheme">
	   <fieldset>
	       <legend>Create theme</legend>	       
	
	       <label for="label">Libelle<span class="requis">*</span></label>
	       <input type="text" id="label" name="label" value=""/>
	       <br />
	       	
	       <input type="submit" value="CreateTheme" class="sansLabel" />
	       <br />
	       	       
	    </fieldset>
	</form>
		
</body>
</html>