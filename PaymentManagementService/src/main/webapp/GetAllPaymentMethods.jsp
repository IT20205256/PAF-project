<%@page import="model.paymentMethod"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	String account = request.getParameter("account");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get All Payment Methods</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
</head>
<body>

<form method="post" action="GetAllPaymentMethods.jsp" class="form-inline">
		<label class="col-form-label" style="font-size: 16px;">
		Submit User Account</label><br> 
		<input type="number" name="account" style="border: 1px solid #4863A0;" size="40">
		<button type="submit" style="border: 1px solid #4863A0;">Submit</button>
	</form>

	<br>
	<br>

	<div class="container">
		<div class="row">
			<div class="col">

				<h1>All Payment Methods</h1>


				<%
				paymentMethod paymentMethodObj = new paymentMethod();
				out.print(paymentMethodObj.searchMethod(request.getParameter("account")));
				%>
				
				<br>
				<br>
				
				
				<form style="text-align: center;" method='post' action='insertPaymentMethod.jsp'>
				<input name='btnInsert' type='submit' value='Add Payment Method' class='btn btn-primary'>
				<input name='account' type='hidden' value="<%=account%>">
				</form>
				

			</div>
		</div>
	</div>

</body>
</html>