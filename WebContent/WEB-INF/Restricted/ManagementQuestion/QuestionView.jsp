<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="java.util.List"%>
  <%@ page import ="fr.eni.jee.bo.Question"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Question view</title>
</head>
<body>

	<table>
	   	<tr>
       <td>Statement</td>
       <td>Media</td>
       <td>Points</td>
       <td>Theme</td>
   	</tr>
  <%    
   	List<Question> lstQuestion = (List<Question>)request.getAttribute("lstQuestion");	    	
	for(Question question : lstQuestion) {
  %>
	
   	<tr>
       <td><%= question.getStatement() %></td>
       <td><%= question.getMedia() %></td>
        <td><%= question.getPoints() %></td>
       <td><%= question.getTheme().getLabel() %></td>
   	</tr>
	
  <% } %>
  </table>
</body>
</html>