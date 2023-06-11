<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Customer Name: <c:out value="${customerName}"/></h1>
	<p style="font-size:25px;">Item Name: <c:out value="${itemName}"/></p>
	<p style="font-size:25px;">Price: $<c:out value="${price}"/></p>
	<p style="font-size:25px;">Description: <c:out value="${description}"/></p>
	<p style="font-size:25px;">Vendor: <c:out value="${vendor}"/></p>
</body>
</html>