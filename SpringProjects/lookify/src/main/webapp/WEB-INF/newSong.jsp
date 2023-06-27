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
    <title>Add Song</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
    <div id="bookForm" class="p-4 container">
        <h1 class="mb-5">Add Song</h1>
        <form:form class="p-4 mb-5 border shadow" action="/process" method="POST" modelAttribute="song">
        	<div class="row">
        		<form:label path="title" class="col-sm-3 form-label fs-5 fw-semibold">Title</form:label>
        		<div class="mb-4 col-sm-9">
        			<form:input type="text" class="form-control fs-5" path="title" placeholder="Enter song title"/>
        			<form:errors path="title" class="text-danger"/>
        		</div>
        	</div>
        	<div class="row">
        		<form:label path="artist" class="col-sm-3 form-label fs-5 fw-semibold">Artist</form:label>
        		<div class="mb-4 col-sm-9">
        			<form:input type="text" class="form-control fs-5" path="artist" placeholder="Enter artist name"/>
        			<form:errors path="artist" class="text-danger"/>
        		</div>
        	</div>
        	<div class="row">
        		<form:label path="rating" class="col-sm-3 form-label fs-5 fw-semibold">Rating (1-10)</form:label>
        		<div class="mb-4 col-sm-4">
        			<form:input type="number" class="form-control fs-5" path="rating" placeholder="Enter song rating"/>
        			<form:errors path="rating" class="text-danger"/>
        		</div>
        	</div>
        	<div class="d-flex justify-content-end">
        		<input type="submit" class="btn btn-primary bg-gradient shadow fs-5 fw-semibold" value="Add">
        	</div>
        </form:form>
        <a href="/dashboard" class="fs-3">Dashboard</a>
    </div>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>