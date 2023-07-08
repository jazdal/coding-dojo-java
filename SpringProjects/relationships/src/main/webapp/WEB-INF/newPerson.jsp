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
    <title>New Person</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
    <div id="bookForm" class="p-4 container">
        <h1 class="mb-5">New Person</h1>
        <form:form class="p-4 mb-5 border shadow" action="/newPerson" method="POST" modelAttribute="person">
        	<div class="row">
        		<form:label path="firstName" class="col-sm-3 form-label fs-5 fw-semibold">First Name:</form:label>
        		<div class="mb-4 col-sm-9">
        			<form:input type="text" class="form-control fs-5" path="firstName" placeholder="Enter first name"/>
        			<form:errors path="firstName" class="text-danger"/>
        		</div>
        	</div>
        	<div class="row">
        		<form:label path="lastName" class="col-sm-3 form-label fs-5 fw-semibold">Last Name:</form:label>
        		<div class="mb-4 col-sm-9">
        			<form:input type="text" class="form-control fs-5" path="lastName" placeholder="Enter last name"/>
        			<form:errors path="lastName" class="text-danger"/>
        		</div>
        	</div>
        	<input type="submit" class="btn btn-primary bg-gradient shadow fs-5 fw-semibold" value="Create">
        </form:form>
    </div>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>