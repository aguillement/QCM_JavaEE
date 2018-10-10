<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Thème</title>
</head>
<body>

	<form method="post" action="createQuestion">
	   <fieldset>
	       <legend>Create thème</legend>	       
	
	       <label for="libelle">Libelle<span class="requis">*</span></label>
	       <input type="text" id="libelle" name="libelle" value=""/>
	       <span class="erreur">${form.erreurs['email']}</span>
	       <br />
	       	
	       <input type="submit" value="Save" class="sansLabel" />
	       <br />
	       	       
	    </fieldset>
	</form>
		
</body>
</html>