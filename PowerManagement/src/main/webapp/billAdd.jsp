<%@page import="model.Bill"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col">

				<h1>ADD RECORDS</h1>
				<form method="post" action="allBills.jsp">
					ACCOUNT NO:<br> <input name="accountNo" type="text" placeholder="Enter the Tariff_Block" required><br> 
					NAME:<br> <input name="name" type="text" placeholder="Enter Charge Per Unit" required><br> 
					ADDRESS:<br> <input name="address" type="text" placeholder="Enter Consumer Type" required><br> 
					MONTH:<br> <input name="month" type="text" placeholder="Enter the Tariff_Block" required><br> 
					CURRENT READING:<br> <input name="current_reading" type="text" placeholder="Enter Charge Per Unit" required><br> 
					PREVIOUS READING:<br> <input name="previous_reading" type="text" placeholder="Enter Consumer Type" required><br>
					<br>  
					<input name="btnSubmit" type="submit" value="Generate Bill" class="btn btn-primary">
				</form>

				<%
				//out.print(session.getAttribute("statusMsg"));
				%>

				<br>


			</div>
		</div>
	</div>

</body>
</html>