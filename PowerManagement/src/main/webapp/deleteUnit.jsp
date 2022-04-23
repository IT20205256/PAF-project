<%@page import="model.Unit"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
//Delete method----------------------------------
if (request.getParameter("Unit_Record_Id") != null) {
	Unit methodObj = new Unit();
	String stsMsg = methodObj.deleteUnit(request.getParameter("Unit_Record_Id"));
	session.setAttribute("statusMsg", stsMsg);
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
</head>
<body>
<%
    String redirectURL = "http://localhost:8090/PowerManagement/unitAdd.jsp";
    response.sendRedirect(redirectURL);
%>
</body>
</html>