<%@page import="model.Register"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
//Delete method----------------------------------
if (request.getParameter("account_no") != null) {
	Register methodObj = new Register();
	String stsMsg = methodObj.deleteDetail(request.getParameter("account_no"));
	session.setAttribute("statusMsg", stsMsg);
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete User Account</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
</head>
<body>
<%
    String redirectURL = "http://localhost:8090/ConsumerManagement/Register.jsp";
    response.sendRedirect(redirectURL);
%>
</body>
</html>