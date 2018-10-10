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

  <%    
   	List<Question> lstQuestion = (List<Question>)request.getAttribute("lstQuestion");	    	
	for(Question question : lstQuestion) {
  %>
	 <a href="#"><%=question.getStatement()%></a>
	 <br>
	 <br>
  <% } %>
</body>
</html>