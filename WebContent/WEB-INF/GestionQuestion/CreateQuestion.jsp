<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Question</title>
</head>
<body>

	<form method="post" action="createQuestion">
	   <fieldset>
	       <legend>Create question</legend>	       
	
	       <label for="enonce">Enonce<span class="requis">*</span></label>
	       <input type="text" id="enonce" name="enonce" value=""/>
	       <br />
	       
	       <label for="media">Media<span class="requis">*</span></label>
	       <input type="text" id="media" name="media" value=""/>
	       <br />
	       
	       <label for="points">Points<span class="requis">*</span></label>
	       <input type="text" id="points" name="points" value=""/>
	       <br />
	       
		   <select>
		      <option value="1">Theme1</option>
			  <option value="2">Theme2</option>
			  <option value="3">Theme3</option>
			  <option value="4">Theme4</option>
		   </select>
	       	
	       <input type="submit" value="Save" class="sansLabel" />
	       <br />
	       	       
	    </fieldset>
	</form>

</body>
</html>