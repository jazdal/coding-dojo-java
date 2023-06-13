<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Date</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="date">
		<p><c:out value="${date}"/></p>
	</div>
	<script src="/js/date.js"></script>
</body>
</html>