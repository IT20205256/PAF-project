<%@page import="model.paymentMethod"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
if (request.getParameter("ID") != null && request.getParameter("exp") != null && request.getParameter("cvv") != null) {
	paymentMethod methodObj = new paymentMethod();
	String stsMsg = methodObj.updateMethod(request.getParameter("ID"), request.getParameter("exp"),
	request.getParameter("cvv"));
	session.setAttribute("statusMsg", stsMsg);
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Methods</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
</head>
<body>

<div class="container">
		<div class="row">
			<div class="col">

				<h1>Payment Methods</h1>
				<br>


				<%
				paymentMethod methodObj = new paymentMethod();
				out.print(methodObj.searchMethod(request.getParameter("account")));
				%>

				<br> <br>

				<%
				String account = request.getParameter("account");
				%>

				<form style="text-align: center;" method='post' action='insertPaymentMethod.jsp'>
					<input name='btnPay' type='submit' value='Add Payment Method' class='btn btn-primary'> 
					<input name='account' type='hidden' value="<%=account%>">
				</form>

			</div>
		</div>
	</div>


</body>
</html>