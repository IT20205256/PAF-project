<%@page import="model.payment"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Payments</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
</head>
<body>

<div class="container">
		<div class="row">
			<div class="col">

				<h1>All Payments</h1>


				<%
				payment paymentObj = new payment();
				out.print(paymentObj.allPayment());
				%>

			</div>
		</div>
	</div>

</body>
</html>