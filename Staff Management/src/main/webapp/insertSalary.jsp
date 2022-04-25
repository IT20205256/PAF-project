<%@page import="model.model" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
if (request.getParameter("Name") != null)
{
model staffObj = new model();
String stsMsg = staffObj.insertSalary(request.getParameter("Name"),
request.getParameter("Salary"));
session.setAttribute("statusMsg", stsMsg);
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Salary</title>
<link rel="stylesheet" href="View/bootstrap.min.css">
</head>
<body>

<form method="post" action="insertSalary.jsp">
  Staff Name: <input name="Name" type="text" class="form-control" required><br>
  Staff Salary: <input name="Salary" type="text" class="form-control" required><br>
  
  <input type="submit" name="btn-submit" value="Insert Salary" class="btn btn-primary"><br>
  
</form>

<br>

<form method="post" action="readStaff.jsp">
  <input type="submit" name="btn-submit" value="See Staff Details" class="btn btn-primary"><br>
</form>

<br>

<form method="post" action="readSalary.jsp">
  <input type="submit" name="btn-submit" value="See Salary Details" class="btn btn-primary"><br>
</form>


<%
out.print(session.getAttribute("statusMsg"));
%>

</body>
</html>