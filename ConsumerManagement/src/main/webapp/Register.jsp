<%@page import="model.Register"%>
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

				<h1>Register</h1>
				<form method="post" action="Login.jsp">
					Name:<br> <input name="name" type="text" placeholder="Enter Account Number" required><br> 
					Address:<br> <input name="address" type="text" placeholder="Enter Address" required><br> 
					Phone:<br> <input name="phone" type="number" placeholder="Enter Conatact Number" required><br> 
					Email:<br> <input name="email" type="email" placeholder="Enter Your Email" required><br> 
					UserName:<br> <input name="username" type="text" placeholder="" required><br> 
					Password:<br> <input name="password" type="password" placeholder="" required><br><br>  
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