<%@ page import="model.model" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%
if (request.getParameter("name") != null)
{
model staffObj = new model();
String stsMsg = staffObj.insertStaff(request.getParameter("name"),
request.getParameter("title"),
request.getParameter("mail"),
request.getParameter("contact"),
request.getParameter("gender"),
request.getParameter("password"));
session.setAttribute("statusMsg", stsMsg);
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Staff Details</title>
<link rel="stylesheet" href="View/bootstrap.min.css">
</head>
<body>

<%
model loginObj = new model();
out.print(loginObj.validate(request.getParameter("email"), request.getParameter("password")));
%>

<br>
	<br>
	<form method="post" action="insertStaff.jsp" class="form-inline">
		<input type="submit" name="btnInsert" value="Add New Staff Member" class="btn btn-primary"><br><br>
	</form>
	
	<form method="post" action="insertSalary.jsp" class="form-inline">
		<input type="submit" name="btnInsert" value="Add or Update Salary" class="btn btn-primary"><br><br>
	</form>
	

</body>
</html>