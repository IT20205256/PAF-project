<%@page import="model.ReadBill"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Bill</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
</head>
<body>

	<form method="post" action="ReadBill.jsp" class="form-inline">
			<label class="col-form-label" style="font-size: 16px;">Account Number</label><br>
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
				ReadBill methodObj = new ReadBill();
				out.print(methodObj.getAllBills(request.getParameter("account")));
				%>

			</div>
		</div>
	</div>

</body>
</html>