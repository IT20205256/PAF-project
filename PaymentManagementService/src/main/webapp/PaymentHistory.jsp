<%@page import="model.payment"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment History</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
</head>
<body>

<div class="container">
		<div class="row">
			<div class="col">

				<h1>Payment History</h1>


				<%
				payment paymentObj = new payment();
				out.print(paymentObj.getPaymentHistory(request.getParameter("account")));
				%>

			</div>
		</div>
	</div>

</body>
</html>