<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Time</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="time">
		<p><c:out value="${time}"/></p>
	</div>
	<script src="/js/time.js"></script>
</body>
</html>