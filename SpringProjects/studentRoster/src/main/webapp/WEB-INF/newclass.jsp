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
    <title>New Class</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
    <div id="dashboard" class="p-4 container">
        <h1 class="mb-5 text-center">New Class</h1>
        <a class="fs-4" href="/dorms">Dashboard</a>
        <form:form class="p-4 mt-4 mb-5 border shadow fs-5" action="/classes/new" method="POST" modelAttribute="class">
        	<div class="row">
        		<form:label path="className" class="col-sm-3 form-label fw-semibold">Name:</form:label>
        		<div class="mb-4 col-sm-9">
        			<form:input type="text" class="form-control fs-5" path="className" placeholder="Enter class name"/>
        			<form:errors path="className" class="text-danger"/>
        		</div>
        	</div>
        	<hr>
        	<div class="d-flex justify-content-center">
        		<input id="submit-btn" type="submit" class="btn btn-warning bg-gradient shadow fs-5 fw-semibold" value="Add">
        	</div>
        </form:form>
    </div>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
