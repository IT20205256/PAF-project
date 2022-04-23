<%@page import="model.paymentMethod"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
//Insert method----------------------------------
if (request.getParameter("account") != null) {
	paymentMethod methodObj = new paymentMethod();

	String stsMsg = methodObj.insertMethod(request.getParameter("account"), request.getParameter("type"),
	request.getParameter("number"), request.getParameter("date"), request.getParameter("cvv"),
	request.getParameter("name"), request.getParameter("cardName"));

	session.setAttribute("statusMsg", stsMsg);
}

%>

<%
	String account = request.getParameter("account");
%>


<!DOCTYPE html>
<html>
<head>
<title>All Payment Methods for <%=request.getParameter("account")%></title>
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