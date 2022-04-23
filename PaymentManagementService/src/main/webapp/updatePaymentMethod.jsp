<%@page import="model.paymentMethod"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Payment Method</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
</head>
<body>

<div class="container">
		<div class="row">
			<div class="col">

				<h1>Update Payment Method</h1>
				<br>
				<%
				paymentMethod methodObj = new paymentMethod();
				out.print(methodObj.getPaymentMethod(request.getParameter("ID")));
				%>

			</div>
		</div>
	</div>


</body>
</html>