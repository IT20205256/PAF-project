<%@page import="model.Unit"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
if (request.getParameter("Unit_Record_Id") != null && request.getParameter("Tariff_Block") != null
		&& request.getParameter("Charge_per_Unit") != null && request.getParameter("Type") != null) {
	Unit methodObj = new Unit();
	String stsMsg = methodObj.updateUnit(request.getParameter("Unit_Record_Id"), request.getParameter("Tariff_Block"),
	request.getParameter("Charge_per_Unit"), request.getParameter("Type"));
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
	Unit UnitObj = new Unit();
	out.print(UnitObj.readUnits());
	%>

</body>
</html>