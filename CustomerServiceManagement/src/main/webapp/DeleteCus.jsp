<%@ page import="model.CustomerService" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
//Delete method----------------------------------
if (request.getParameter("Id") != null) {
	CustomerService methodObj = new CustomerService();
	String stsMsg = methodObj.deleteCusService(request.getParameter("Id"));
	session.setAttribute("statusMsg", stsMsg);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
CustomerService paymentObj = new CustomerService();
				out.print(paymentObj.readCusService());
				%>

</body>
</html>