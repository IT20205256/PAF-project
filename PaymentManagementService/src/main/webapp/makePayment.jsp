<%@page import="model.payment"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
//Insert method----------------------------------
if (request.getParameter("billNo") != null) {
	payment methodObj = new payment();

	String stsMsg = methodObj.insertMethod(request.getParameter("billNo"), request.getParameter("name"),
	request.getParameter("amountPay"));

	session.setAttribute("statusMsg", stsMsg);
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Bills</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
</head>
<body>

<div class="container">
		<div class="row">
			<div class="col">

				<h1>All Bills</h1>

				<%
				payment methodObj = new payment();
				out.print(methodObj.getAllBills(request.getParameter("account")));
				%>
				
				<br>
				<br>
				
				<%
				String account = request.getParameter("account");
				%>
				
				<form style="text-align: center;" method='post' action='PaymentHistory.jsp'>
				<input name='btnGet' type='submit' value='View Payment History' class='btn btn-primary'>
				<input name='account' type='hidden' value="<%=account%>">
				</form>

			</div>
		</div>
	</div>

</body>
</html>