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
    <title>Book Share</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
    <div id="regForm" class="p-4 container">
    	<div class="mb-5 d-flex align-items-center justify-content-between">
        	<h1 class="mb-0 fw-bold">Add a Book to Your Shelf!</h1>
        	<a class="fs-4" href="/bookmarket">Back to the shelves</a>
        </div>
        <div class="row justify-content-between">
        	<form:form class="p-3 col-sm-12 card bg-warning-subtle bg-gradient shadow" action="/books/new" method="POST" modelAttribute="book">
        		<div class="card-body">
        			<form:input type="hidden" path="user.id" value="${currentUser.getId()}"/>
        			<div class="row mb-4 g-3 align-items-center justify-content-between">
        				<div class="col-auto">
        					<form:label path="title" class="col-form-label fs-5 fw-semibold">Title:</form:label>
        				</div>
        				<div class="col-sm-10">
        					<form:input type="text" class="form-control fs-5" path="title" placeholder="Enter book title"/>
        					<form:errors path="title" class="text-danger"/>
        				</div>
        			</div>
        			<div class="row mb-4 g-3 align-items-center justify-content-between">
        				<div class="col-auto">
        					<form:label path="author" class="col-form-label fs-5 fw-semibold">Author:</form:label>
        				</div>
        				<div class="col-sm-10">
        					<form:input type="text" class="form-control fs-5" path="author" placeholder="Enter author name"/>
        					<form:errors path="author" class="text-danger"/>
        				</div>
        			</div>
        			<div class="row mb-5 g-3 align-items-center justify-content-between">
        				<div class="col-auto">
        					<form:label path="thoughts" class="col-form-label fs-5 fw-semibold">Thoughts:</form:label>
        				</div>
        				<div class="col-sm-10">
        					<form:textarea type="text" class="form-control fs-5" rows="5" path="thoughts" placeholder="Enter your thoughts on the book"/>
        					<form:errors path="thoughts" class="text-danger"/>
        				</div>
        			</div>
        			<div class="d-flex align-items-center justify-content-end">
        				<input type="submit" class="btn btn-warning bg-gradient shadow fs-5 fw-semibold" value="Submit">
        			</div>
        		</div>
        	</form:form>
        </div>
    </div>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
