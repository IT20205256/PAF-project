<%@page import="model.payment"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
	String account = request.getParameter("account");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Bills</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
</head>
<body>

<form method="post" action="accountNumber.jsp" class="form-inline">
			<label class="col-form-label" style="font-size: 16px;">Enter Account</label><br>
			<input type="number" name="account" style="border: 1px solid #4863A0;" size="50">
		<button type="submit" style="border: 1px solid #4863A0;" >Submit</button>
	</form>

	<br>
	<br>

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
				
				
				<form style="text-align: center;" method='post' action='PaymentHistory.jsp'>
				<input name='btnGet' type='submit' value='View Payment History' class='btn btn-primary'>
				<input name='account' type='hidden' value="<%=account%>">
				</form>

			</div>
		</div>
	</div>

</body>
</html>