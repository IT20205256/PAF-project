<%@page import="model.Register"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
if (request.getParameter("account_no") != null && request.getParameter("name") != null
		&& request.getParameter("address") != null && request.getParameter("phone") != null
		&& request.getParameter("uemail") != null && request.getParameter("username") != null
		&& request.getParameter("password") != null) {
	Register methodObj = new Register();
	String stsMsg = methodObj.updateDetail(request.getParameter("account_no"), request.getParameter("name"),
	request.getParameter("address"), request.getParameter("phone"), request.getParameter("uemail"),
	request.getParameter("username"), request.getParameter("password"));
	session.setAttribute("statusMsg", stsMsg);

}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update User Account</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
</head>
<body>
<div class="container">
		<div class="row">
			<div class="col">
			
			<h1>Update</h1>

	<%
	Register methodObj = new Register();
	out.print(methodObj.validate(request.getParameter("username"), request.getParameter("password")));
	%>
	
				</div>
		</div>
	</div>

</body>
</html>
