<%@page import="model.paymentMethod"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
//Delete method----------------------------------
if (request.getParameter("ID") != null) {
	paymentMethod methodObj = new paymentMethod();
	String stsMsg = methodObj.deleteMethod(request.getParameter("ID"));
	session.setAttribute("statusMsg", stsMsg);
}
%>

<%
	String account = request.getParameter("account");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Payment Methods</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
</head>
<body>

<div class="container">
		<div class="row">
			<div class="col">

				<h1>Payment Methods</h1>


				<%
				paymentMethod methodObj = new paymentMethod();
				out.print(methodObj.searchMethod(request.getParameter("account")));
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