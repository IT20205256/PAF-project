<%@page import="model.CustomerService" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
if (request.getParameter("Name") != null) {
	CustomerService cusobj = new CustomerService();
	String stsMsg = cusobj.insertCusService(request.getParameter("Name"), request.getParameter("Address"),
	request.getParameter("Issue"), request.getParameter("TelNo"), request.getParameter("Status"));
	session.setAttribute("statusMsg", stsMsg);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="InsertCus.jsp" method="post">
     Name: <input type="text" name="Name" required><br>
     Address: <input type="text" name="Address" required><br>
     Issue: <input type="text" name="Issue" required><br>
     Phone Number: <input type="text" name="TelNo" required><br>
     Status: <select name="Status">
    <option value="not repaired">Not Yet Repaired</option>
    <option value="repaired">Repaired</option>
</select>
     
     <input name="btnSubmit" type="submit" value="Create Inquiry">
</form>
     <%
	out.print(session.getAttribute("statusMsg"));
	%>
</body>
</html>