<%@page import="model.Bill"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
//insert item..........................
if (request.getParameter("accountNo") != null) {
	Bill BillObj = new Bill();
	BillObj.connect();

	String stsMsg = BillObj.insertBill(request.getParameter("accountNo"), request.getParameter("name"),
	request.getParameter("address"), request.getParameter("month"), request.getParameter("current_reading"),
	request.getParameter("previous_reading"), request.getParameter("consumed_units"),
	request.getParameter("total"), request.getParameter("due"), request.getParameter("status"));

	session.setAttribute("ststusMsg", stsMsg);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	Bill BillObj = new Bill();
	out.print(BillObj.readBill());
	%>

	<a href="billAdd.jsp">
		<button class="button">GENERATE BILL</button>
	</a>
</body>
</html>