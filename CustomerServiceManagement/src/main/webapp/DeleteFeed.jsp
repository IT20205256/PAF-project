<%@ page import="model.Feedback" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%
    if(request.getParameter("FeedId") != null){
    	Feedback feedObj = new Feedback();
    	String stsMsg = feedObj.deleteFeedback(request.getParameter("FeedId"));
    	session.setAttribute("statusMsg" , stsMsg);
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
Feedback feedobj =new Feedback();
out.print(feedobj.readFeedback());
%>
</body>
</html>