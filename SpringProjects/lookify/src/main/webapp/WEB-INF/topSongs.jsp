<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Top Songs</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
    <div class="p-4 container">
        <h1 class="mb-5">Top Songs</h1>
        <div class="p-4 mb-5 card bg-primary-subtle bg-gradient border shadow">
        	<c:forEach var="song" items="${songs}">
        		<p class="fs-5 fw-semibold">${song.rating} - <a href="/songs/${song.id}">${song.title}</a> - ${song.artist}</p>
        	</c:forEach>
        </div>
        <a href="/dashboard" class="fs-3">Dashboard</a>
    </div>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>