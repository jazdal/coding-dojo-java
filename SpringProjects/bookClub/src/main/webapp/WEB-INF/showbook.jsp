<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Read Share</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
    <div id="regForm" class="p-4 container">
    	<div class="mb-5 d-flex align-items-center justify-content-between">
        	<h1 class="mb-0 fw-bold">${book.getTitle()}</h1>
        	<a class="col-sm-3 fs-4 text-end" href="/books">Back to the shelves</a>
        </div>
        <div class="mb-5">
        	<c:choose>
        		<c:when test="${currentUser.getId() eq book.getUser().getId()}">
        			<h3>You read <span id="book_title">${book.getTitle()}</span> by 
        			<span class="text-success fw-bold fst-italic">${book.getAuthor()}</span></h3>
        			<h3>Here are your thoughts:</h3>
        		</c:when>
        		<c:otherwise>
        			<h3><span class="text-danger fw-bold fst-italic">${book.getUser().getName()}</span> 
        			read <span id="book_title">${book.getTitle()}</span> by 
        			<span class="text-success fw-bold fst-italic">${book.getAuthor()}</span></h3>
        			<h3>Here are <span class="text-danger fw-bold fst-italic">${book.getUser().getName()}'s</span> thoughts:</h3>
        		</c:otherwise>
        	</c:choose>
        </div>
        <hr>
        <div id="thoughts" class="mb-4 d-flex align-items-center justify-content-center fs-4 fw-semibold fst-italic">
        	<p>${book.getThoughts()}</p>
        </div>
        <hr class="mb-5">
        <div class="d-flex justify-content-end">
        	<c:choose>
        		<c:when test="${currentUser.getId() eq book.getUser().getId()}">
        			<button class="me-3 btn btn-primary btn-lg bg-gradient shadow fs-5 fw-semibold" onclick="location.href='/books/${book.getId()}/edit'">Edit</button>
        			<button class="ms-3 btn btn-danger btn-lg bg-gradient shadow fs-5 fw-semibold" onclick="location.href='/books/delete/${book.getId()}'">Delete</button>
        		</c:when>
        		<c:otherwise>
        			<button class="me-3 btn btn-outline-secondary btn-lg fs-5 fw-semibold" disabled>Edit</button>
        			<button class="ms-3 btn btn-outline-danger btn-lg fs-5 fw-semibold" disabled>Delete</button>
        		</c:otherwise>
        	</c:choose>
        </div>
    </div>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
