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
    <title>New Question</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
    <div id="dashboard" class="p-5 container">
        <h1>What is your question?</h1>
        <a class="fs-5" href="/">Dashboard</a>
        <form:form class="form mt-4 p-4 bg-secondary-subtle bg-gradient shadow" action="/questions/new" method="POST" modelAttribute="question">
        	<div class="mb-4 row justify-content-between">
        		<div class="col-auto">
        			<form:label class="col-form-label fs-5 fw-semibold" path="text">Question:</form:label>
        		</div>
        		<div class="col-sm-10">
        			<form:textarea type="text" class="form-control fs-5" rows="6" path="text" placeholder="Type your question here"/>
        			<form:errors path="text" class="text-danger"/>
        		</div>
        	</div>
        	<div class="mb-4 row justify-content-between">
        		<div class="col-auto">
        			<label for="listOfTags" class="col-form-label fs-5 fw-semibold">Tags:</label>
        		</div>
        		<div class="col-sm-10">
        			<input type="text" class="form-control fs-5" name="listOfTags" placeholder="Enter tags (separate each tag with commas)">
        			<p class="text-danger">${error}</p>
        		</div>
        	</div>
        	<div class="d-flex justify-content-end">
        		<input type="submit" class="btn btn-secondary bg-gradient shadow fs-5 fw-semibold" value="Submit">
        	</div>
        </form:form>
     </div>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
