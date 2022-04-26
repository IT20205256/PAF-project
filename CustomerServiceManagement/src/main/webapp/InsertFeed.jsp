<%@page import="model.Feedback" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    if(request.getParameter("RepairId") != null){
    	Feedback feedObj = new Feedback();
    	String stsMsg = feedObj.insertFeedback(request.getParameter("RepairId"), request.getParameter("Rate"), request.getParameter("Feedback"));
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
<form action="InsertFeed.jsp" method="post">
     Service Id: <input type="text" name="RepairId" required><br>
         Rate the Service: <select name="Rate" required>
    <option value="VeryPoor">VeryPoor</option>
    <option value="Poor">Poor</option>
    <option value="Average">Average</option>
    <option value="Good">Good</option>
    <option value="Excellent">Excellent</option>
    </select><br>
     Feedback: <input type="text" name="Feedback" required><br>
 
     <input name="btnSubmit" type="submit" value="Submit">
</form>
     <%
	out.print(session.getAttribute("statusMsg"));
	%>

</body>
</html>