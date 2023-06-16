<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Insert title here</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
    <div class="p-5 container">
        <p class="fs-5">You have visited <a href="/">http://localhost:8080</a> <c:out value="${count}"/> times.</p>
        <a class="fs-5" href="/">Test another visit?</a>
        <hr>
        <button class="btn btn-warning bg-gradient shadow" onclick="location.href='/reset'">Reset Counter</button>
    </div>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>