<%@page import="model.Admin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%
//insert item..........................
if (request.getParameter("name") != null) {
	Admin consumerObj = new Admin();
	consumerObj.connect();

	String stsMsg = consumerObj.insertDetail(request.getParameter("name"), request.getParameter("address"),
	request.getParameter("phone"), request.getParameter("email"), request.getParameter("username"),
	request.getParameter("password"));

	session.setAttribute("ststusMsg", stsMsg);
}
%>
	


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>Consumer List</h1>
	<%
	Admin consumerObj = new Admin();
	out.print(consumerObj.readDetails());
	%>
<br>
	<a href="consumerAdd.jsp">
	<button type="button" class="btn btn-warning">Add New Consumer</button>
	</a>
</center>
</body>
</html>