<%@page import="model.payment"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Payment Details</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
</head>
<body>

<div class="container">
		<div class="row">
			<div class="col">

				<h1>Payment Methods</h1>


				<%
				payment methodObj = new payment();
				out.print(methodObj.getBill(request.getParameter("billNo")));
				%>

			</div>
		</div>
	</div>

</body>
</html>