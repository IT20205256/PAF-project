<%@page import="model.Admin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
//Delete method----------------------------------
if (request.getParameter("account_no") != null) {
	Admin methodObj = new Admin();
	String stsMsg = methodObj.deleteDetail(request.getParameter("account_no"));
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
    String redirectURL = "http://localhost:8090/ConsumerManagement/ConsumerList.jsp";
    response.sendRedirect(redirectURL);
%>

</body>
</html>