<%@page import="model.Unit"%>
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

				<h1>Update Unit Record</h1>
				
				<%
				Unit unitObj = new Unit();
				out.print(unitObj.getUnit(request.getParameter("Unit_Record_Id")));
				%>

			</div>
		</div>
	</div>

</body>
</html>