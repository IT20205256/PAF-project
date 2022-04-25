<%@page import="model.model"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
//updateStaff(String ID, String name, String title, String mail, String contact)
if (request.getParameter("ID1") != null && request.getParameter("Name") != null && request.getParameter("Title") != null
		&& request.getParameter("Mail") != null && request.getParameter("Contact") != null
		&& request.getParameter("Gender") != null) {
	model staffObj = new model();
	String stsMsg = staffObj.updateStaff(request.getParameter("ID1"), request.getParameter("Name"),
	request.getParameter("Title"), request.getParameter("Mail"), request.getParameter("Contact"));
	session.setAttribute("statusMsg", stsMsg);
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="View/bootstrap.min.css">
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col">

				<h1>Staff Members</h1>
				<br>
				<%
				model staffObj = new model();
				out.print(staffObj.readStaff());
				%>

				<br> <br>
				<form method="post" action="insertStaff.jsp" class="form-inline">
					<input type="submit" name="btnInsert" value="Add New Staff Member"
						class="btn btn-primary"><br>
					<br>
				</form>

				<br> <br>


			</div>
		</div>
	</div>

</body>
</html>