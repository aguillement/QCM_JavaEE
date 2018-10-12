<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Management test</title>
</head>
<body>

		<form method="post" action="createTest">
	   <fieldset>
	       <legend>Create test</legend>	       
	
	       <label for="label">Label</label>
	       <input type="text" id="label" name="label" value=""/>
	       <br />
	       <br />
	       
	       <label for="statement">Statement</label>
	       <input type="text" id="statement" name="statement" value=""/>
	       <br />
	       <br />
	       
	       <label for="duration">Duration</label>
	       <input type="text" id="duration" name="duration" value=""/>
	       <br />
	       <br />
	       
	       <label for="high_level">High level</label>
	       <input type="text" id="high_level" name="high_level" value=""/>
	       <br />
	       <br />
	       
	       <label for="low_level">Low level</label>
	       <input type="text" id="low_level" name="low_level" value=""/>
	       <br />
	       <br />
	       	
	       <input type="submit" value="CreateTest" class="sansLabel" />
	       <br />
	       	       
	    </fieldset>
	</form>

</body>
</html>