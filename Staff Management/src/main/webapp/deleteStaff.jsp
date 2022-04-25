<%@ page import="model.model" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <% if(request.getParameter("StaffId")!= null){
    	model staffObj = new model();
    	String stsmsg = staffObj.deleteStaff(request.getParameter("StaffId"));
    	session.setAttribute("statusmsg",stsmsg);
    } %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Staff</title>
<link rel="stylesheet" href="View/bootstrap.min.css">
</head>
<body>

<% 
model staffObj = new model();
out.print(staffObj.readStaff());
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