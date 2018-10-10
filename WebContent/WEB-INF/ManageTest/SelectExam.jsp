<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="fr.eni.jee.bo.Exam"%>
<%@page import="fr.eni.jee.bo.Test"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sélectionner une épreuve</title>
</head>
<body>

<% 
List<Exam> exams = (ArrayList<Exam>)request.getAttribute("exams");
 
for(Exam exam : exams)
{
	Test test = exam.getTest();
	
	out.print("jif : " + test);
    out.print("Id: " + exam.getId());
    out.print("<br/>");
}
 
%>

</body>
</html>