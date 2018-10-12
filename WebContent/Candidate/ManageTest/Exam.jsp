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
<title>Épreuve</title>
</head>
<body>
 	<%
 		Exam exam = (Exam)request.getAttribute("exam");
 		out.print("Date debut : " + exam.getStartDate());
 		out.print("<br>");
 		out.print("Date fin : " + exam.getEndDate());
 		out.print("<br>");
 		out.print("Durée : " + exam.getTest().getDuration());
 		out.print("<br>");
 		out.print("Libellé : " + exam.getTest().getLabel());
 		out.print("<br>");
	%>
 </body>
</html> 