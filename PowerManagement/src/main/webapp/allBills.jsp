<%@page import="model.Bill"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
//insert item..........................
if (request.getParameter("accountNo") != null) {
	Bill billObj = new Bill();

	String stsMsg = billObj.insertBill(request.getParameter("accountNo"), request.getParameter("name"), request.getParameter("address"), request.getParameter("month"), request.getParameter("current_reading"), request.getParameter("previous_reading"));

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
	<%
	Bill BillObj = new Bill();
	out.print(BillObj.readBill());
	%>

	<a href="billAdd.jsp">
		<button class="btn btn-primary">GENERATE BILL</button>
	</a>
</body>
</html>