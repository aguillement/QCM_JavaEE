<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="fr.eni.jee.bo.Question"%>
<%@page import="fr.eni.jee.bo.Exam"%>
<%@page import="fr.eni.jee.bo.ExamQuestion"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>OUI</title>
</head>
<body>
 	<%
		if (null == request.getAttribute("examQuestions")) {
			List<Question> questions = (ArrayList<Question>) request.getAttribute("questions");
 			for (Question question : questions) {
				out.print(question.getStatement());
				out.print("<br>");
			}
		} else {
			List<ExamQuestion> questions = (ArrayList<ExamQuestion>) request.getAttribute("examQuestions");
 			for (ExamQuestion question : questions) {
				out.print(question.getQuestion().getStatement());
				out.print("<br>");
			}
		}
	%>
 </body>
</html> 