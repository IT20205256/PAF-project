<%@page import="model.Unit"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col">

				<h1>ADD RECORDS</h1>
				<form method="post" action="allUnits.jsp">
					TARIFF BLOCK:<br> <input name="Tariff_Block" type="text" placeholder="Enter the Tariff_Block" required><br> 
					CHARGE PER UNIT:<br> <input name="Charge_per_Unit" type="text" placeholder="Enter Charge Per Unit" required><br> 
					CONSUMER TYPE:<br> <input name="Type" type="text" placeholder="Enter Consumer Type" required><br> 
					<br>  
					<input name="btnSubmit" type="submit" value="Create" class="btn btn-primary">
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