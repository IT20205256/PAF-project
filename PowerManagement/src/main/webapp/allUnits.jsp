<%@page import="model.Unit"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
//insert item..........................
if (request.getParameter("Tariff_Block") != null) {
	Unit UnitObj = new Unit();
	UnitObj.connect();

	String stsMsg = UnitObj.insertUnit(request.getParameter("Tariff_Block"), request.getParameter("Charge_per_Unit"),
	request.getParameter("Type"));

	session.setAttribute("ststusMsg", stsMsg);
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
<br>
<center>
<h1>Unit Records</h1>
	<%
	Unit UnitObj = new Unit();
	out.print(UnitObj.readUnits());
	%>
<br>
	<a href="unitAdd.jsp">
		<button type="button" class="btn btn-warning">Add New Record</button>
	</a>
</center>	
	</body>
</html>