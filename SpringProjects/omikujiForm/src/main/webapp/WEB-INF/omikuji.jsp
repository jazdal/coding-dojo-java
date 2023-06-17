<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Omikuji</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
    <div class="p-4 container">
        <h1 class="text-center">Here's Your Omikuji!</h1>
        <br>
        <div class="p-5 border border-black bg-primary-subtle shadow fs-5">
        	<p>In <c:out value="${number}"/> years, you will live in <c:out value="${city}"/> with <c:out value="${name}"/></p>
        	<p>as your roommate, <c:out value="${hobby}"/> for a living.</p>
        	<p>The next time you see a <c:out value="${livingThing}"/>, you will have good luck.</p>
        	<p>Also, <c:out value="${comment}"/></p>
        </div>
        <hr>
        <p class="text-center fs-5"><a href="/omikuji">Go Back</a></p>
    </div>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>