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
    <title>Edit Book</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
    <div id="bookForm" class="p-4 container bg-secondary-subtle">
        <h1 class="mb-5">Edit Book</h1>
        <form:form class="p-3 border bg-light shadow fs-5" action="/books/${book.id}" method="PUT" modelAttribute="book">
        	<input type="hidden" name="_method" value="put">
        	<div class="mb-3">
        		<form:label path="title" class="form-label fw-semibold">Title</form:label>
        		<form:errors path="title" class="text-danger"/>
        		<form:input type="text" class="form-control fs-5" path="title"/>
        	</div>
        	<div class="mb-3">
        		<form:label path="description" class="form-label fw-semibold">Description</form:label>
        		<form:errors path="description" class="text-danger"/>
        		<form:textarea class="form-control fs-5" rows="4" path="description"/>
        	</div>
        	<div class="mb-3">
        		<form:label path="language" class="form-label fw-semibold">Language</form:label>
        		<form:errors path="language" class="text-danger"/>
        		<form:input type="text" class="form-control fs-5" path="language"/>
        	</div>
        	<div class="mb-4">
        		<form:label path="numberOfPages" class="form-label fw-semibold">Pages</form:label>
        		<form:errors path="numberOfPages" class="text-danger"/>
        		<form:input type="number" class="form-control fs-5" path="numberOfPages"/>
        	</div>
        	<input type="submit" class="btn btn-primary bg-gradient shadow fs-5 fw-semibold" value="Submit">
        </form:form>
    </div>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>