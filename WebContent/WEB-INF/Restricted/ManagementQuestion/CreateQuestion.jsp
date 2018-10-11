<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
 <%@page import="java.util.List"%>  
 <%@ page import ="fr.eni.jee.bo.Theme"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Question</title>
</head>
<body>

	<form method="post" action="createQuestion">
	   <fieldset>
	       <legend>Create question</legend>	       
	
	       <label for="statement">Statement<span class="requis">*</span></label>
	       <input type="text" id="statement" name="statement" value=""/>
	       <br />
	       
	       <label for="media">Media<span class="requis">*</span></label>
	       <input type="text" id="media" name="media" value=""/>
	       <br />
	       
	       <label for="points">Points<span class="requis">*</span></label>
	       <input type="text" id="points" name="points" value=""/>
	       <br />
	   
	   	   <select name="theme">
	       <%    
	       	List<Theme> lstTheme = (List<Theme>)request.getAttribute("lstTheme");	    	
		 	for(Theme theme : lstTheme) {
		   %>
				 <option value="<%=theme.getId() %>"><%=theme.getLabel() %></option>
		   <% } %>
	       </select>		   		   
	       <br />
	       	
	       <input type="submit" value="CreateQuestion" class="sansLabel" />
	       <br />
	       	       
	    </fieldset>
	</form>

</body>
</html>