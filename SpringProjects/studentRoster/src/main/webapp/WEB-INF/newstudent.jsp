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
    <title>New Student</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
    <div id="dashboard" class="p-4 container">
        <h1 class="mb-5 text-center">New Student</h1>
        <a class="fs-4" href="/dorms">Dashboard</a>
        <form:form class="p-4 mt-4 mb-5 border shadow fs-5" action="/students/new" method="POST" modelAttribute="student">
        	<div class="row">
        		<form:label path="name" class="col-sm-3 form-label fw-semibold">Name:</form:label>
        		<div class="mb-4 col-sm-9">
        			<form:input type="text" class="form-control fs-5" path="name" placeholder="Enter student name"/>
        			<form:errors path="name" class="text-danger"/>
        		</div>
        	</div>
        	<div class="row">
        		<form:label path="dorm" class="col-sm-3 form-label fw-semibold">Select Dorm:</form:label>
        		<div class="mb-4 col-sm-9">
        			<form:select path="dorm" class="form-select fs-5">
        				<c:forEach var="dorm" items="${dorms}">
        					<form:option value="${dorm.id}" path="dorm">
        						<c:out value="${dorm.name}"/>
        					</form:option>
        				</c:forEach>
        			</form:select>
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
