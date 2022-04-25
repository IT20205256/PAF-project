<%@page import="model.model" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Staff Login</title>
<link rel="stylesheet" href="View/bootstrap.min.css">
</head>
<body>

<form method="post" action="readStaff.jsp" class="form-inline" >
		<label class="col-form-label" style="font-size: 16px;" >Enter Staff Mail :</label> 
		<input type="text" name="email" style="border: 1px solid #4863A0;" size="50" required><br><br>
		<label class="col-form-label" style="font-size: 16px;" >Enter Password :</label>
		<input type="password" name="password" style="border: 1px solid #4863A0;" size="50" required><br><br>
		<button type="submit" style=" border: 1px solid #4863A0;" class="btn btn-primary">Submit</button>
	</form>

</body>
</html>