<%@ page import="model.paymentMethod"  %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
	String account = request.getParameter("account");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Payment Method</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
</head>
<body>

<div class="container">
		<div class="row">
			<div class="col">

				<h1>Insert Payment Method</h1>
				<form method="post" action="paymentMethods.jsp">
					Account: <input name="account" type="text" class="form-control" value="<%=account%>" readonly><br>
					Account Type: <input name="type" type="text" class="form-control"><br>
					Card Number: <input name="number" type="text" class="form-control"><br>
					Expiration Date: <input name="date" type="text" class="form-control"><br> 
					CVV: <input name="cvv" type="text" class="form-control"><br> 
					Account Holder: <input name="name" type="text" class="form-control"><br>
					Name on Card: <input name="cardName" type="text" class="form-control"><br> 
					<input name="btnSubmit" type="submit" value="Save Payment Method" class="btn btn-primary">
				</form>

			</div>
		</div>
	</div>

</body>
</html>