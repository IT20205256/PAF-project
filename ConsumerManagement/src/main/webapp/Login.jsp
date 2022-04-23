<%@page import="model.Register"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
//insert item..........................
if (request.getParameter("name") != null) {
	Register consumerObj = new Register();
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
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
</head>
<body>

<div class="container">
		<div class="row">
			<div class="col">

<h1>Login</h1>


	<form method="post" action="Profile.jsp" class="form-inline">
		<label class="col-form-label" style="font-size: 16px;">Enter Username</label> 
		<input type="text" name="username" style="border: 1px solid #4863A0;" size="50"><br><br>
		<label class="col-form-label" style="font-size: 16px;">Enter Password</label>
		<input type="password" name="password" style="border: 1px solid #4863A0;" size="50"><br><br>
		<button type="submit" class="btn btn-info style="border: 1px solid #4863A0;" >Login</button>
	</form>
	
				</div>
		</div>
	</div>


</body>
</html>