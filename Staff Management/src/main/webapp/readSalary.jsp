<%@ page import="model.model" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Read Salary Details</title>
<link rel="stylesheet" href="View/bootstrap.min.css">
</head>
<body>

<%
model SalaryObj = new model();
out.print(SalaryObj.readSalary());
%>

</body>
</html>