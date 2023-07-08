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
    <title>New Ninja</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
    <div id="ninjaForm" class="p-4 container">
        <h1 class="mb-5">New Ninja</h1>
        <form:form class="p-4 mb-5 border shadow" action="/ninjas/new" method="POST" modelAttribute="ninja">
        	<div class="row">
        		<form:label path="dojo" class="col-sm-4 form-label fs-5 fw-semibold">Dojo:</form:label>
        		<div class="mb-4 col-sm-8">
        		<form:select path="dojo" class="form-select fs-5">
        			<c:forEach var="dojo" items="${dojos}">
        				<form:option value="${dojo.id}" path="dojo">
        					<c:out value="${dojo.name}"/>gakure
        				</form:option>
        			</c:forEach>
        		</form:select>
        		</div>
        	</div>
        	<div class="row">
        		<form:label path="firstName" class="col-sm-4 form-label fs-5 fw-semibold">First Name:</form:label>
        		<div class="mb-4 col-sm-8">
        			<form:input type="text" class="form-control fs-5" path="firstName" placeholder="Enter first name"/>
        			<form:errors path="firstName" class="text-danger"/>
        		</div>
        	</div>
        	<div class="row">
        		<form:label path="lastName" class="col-sm-4 form-label fs-5 fw-semibold">Last Name (Optional):</form:label>
        		<div class="mb-4 col-sm-8">
        			<form:input type="text" class="form-control fs-5" path="lastName" placeholder="Enter last name"/>
        			<form:errors path="lastName" class="text-danger"/>
        		</div>
        	</div>
        	<div class="row">
        		<form:label path="age" class="col-sm-4 form-label fs-5 fw-semibold">Age:</form:label>
        		<div class="mb-4 col-sm-8">
        			<form:input type="number" class="form-control fs-5" path="age" placeholder="Enter age"/>
        			<form:errors path="age" class="text-danger"/>
        		</div>
        	</div>
        	<input type="submit" class="btn btn-primary bg-gradient shadow fs-5 fw-semibold" value="Create">
        </form:form>
    </div>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>