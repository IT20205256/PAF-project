<%@page import="model.Register"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col">
			
			<h1>Profile</h1>

		<%
		Register methodObj = new Register();
		out.print(methodObj.validate(request.getParameter("username"), request.getParameter("password")));
		%>
		
			</div>
		</div>
	</div>
	
</body>
</html>