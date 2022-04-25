<%@page import = "model.model" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
        <%
/*if (request.getParameter("name") != null)
{
model staffObj = new model();
String stsMsg = staffObj.insertStaff(request.getParameter("name"),
request.getParameter("title"),
request.getParameter("mail"),
request.getParameter("contact"),
request.getParameter("gender"),
request.getParameter("password"));
session.setAttribute("statusMsg", stsMsg);
}*/
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Staff</title>
<link rel="stylesheet" href="View/bootstrap.min.css">
</head>
<body>

<h1>Staff Management</h1>
<form method="post" action="readStaff.jsp">
Staff Name : <input name="name" type="text" class="form-control" required ><br>
Job Title : <input name="title" type="text" class="form-control" required><br>
Staff Mail : <input name="mail" type="email" class="form-control" required><br>
Staff Contact Number : <input name="contact" type="number" class="form-control" required><br>
Gender : <input name="gender" type="text" class="form-control" required><br>
Password : <input name="password" type="password" class="form-control" required><br>
<input name="btnSubmit" type="submit" value="Save Staff Details" class="btn btn-primary">
</form>

</body>
</html>