<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Demo JSP</title>
</head>
<body>
	<% for(int i = 0; i < 5; i++) { %>
		<h1><%= i %></h1>
	<% } %>
	<p>The time is: <%= new Date() %></p>
	<h2>Two plus two is: </h2>
	<h2><c:out value="${2+2}"/></h2>
	<h2>Fruit of the Day</h2>
	<h2><c:out value="${fruit}"/></h2>
	
	<h2>User Info: </h2>
	<p><c:out value="${first}"/></p>
	<p><c:out value="${last}"/></p>
	<p><c:out value="${email}"/></p>
	<p><c:out value="${age}"/></p>
</body>
</html>