<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>New Book</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
    <div id="bookForm" class="p-4 container bg-secondary-subtle">
        <h1 class="mb-5">New Book</h1>
        <form class="p-3 border bg-light shadow fs-5" action="/books/new" method="POST">
        	<div class="mb-3">
        		<label for="title" class="form-label fw-semibold">Title</label>
        		<input type="text" class="form-control fs-5" name="title" placeholder="Book Title">
        	</div>
        	<div class="mb-3">
        		<label for="description" class="form-label fw-semibold">Description</label>
        		<textarea class="form-control fs-5" rows="4" name="description" placeholder="Enter Description"></textarea>
        	</div>
        	<div class="mb-3">
        		<label for="language" class="form-label fw-semibold">Language</label>
        		<input type="text" class="form-control fs-5" name="language" placeholder="Book Language">
        	</div>
        	<div class="mb-4">
        		<label for="numberOfPages" class="form-label fw-semibold">Pages</label>
        		<input type="number" class="form-control fs-5" name="numberOfPages" placeholder="Number of Pages">
        	</div>
        	<input type="submit" class="btn btn-primary bg-gradient shadow fs-5 fw-semibold" value="Submit">
        </form>
    </div>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>