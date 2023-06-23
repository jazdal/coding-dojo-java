<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Reading Books</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
    <div class="p-4 container">
        <h1><c:out value="${book.title}"/></h1>
        <label for="description" class="mb-1 form-label fs-5 fw-semibold">Description:</label>
        <span class="fs-5"><c:out value="${book.description}"/></span><br>
        <label for="language" class="mt-1 form-label fs-5 fw-semibold">Language:</label>
        <span class="fs-5"><c:out value="${book.language}"/></span><br>
        <label for="description" class="form-label fs-5 fw-semibold">Number of Pages:</label>
        <span class="fs-5"><c:out value="${book.numberOfPages}"/></span>
        <br>
        <button class="btn btn-primary bg-gradient shadow fs-5 fw-semibold" onclick="location.href='/books/${book.id}/edit'">Edit Book</button>
    </div>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>