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
    <title>New License</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
    <div class="p-4 container">
        <h1 class="mb-5">New License</h1>
        <form:form class="p-4 mb-5 border shadow" action="/newLicense" method="POST" modelAttribute="license">
        	<div class="row">
        		<form:label path="person" class="col-sm-3 form-label fs-5 fw-semibold">Person: </form:label>
        		<form:select path="person" class="mb-4 col-sm-9 fs-5">
        			<c:forEach var="onePerson" items="${persons}">
        				<!-- Each option value is the id of the person  -->
        				<form:option value="${onePerson.id}" path="person">
        				<!-- This is what shows to the user as the option  -->
        					<c:out value="${onePerson.firstName}"/>
        					<c:out value="${onePerson.lastName}"/>
        				</form:option>
        			</c:forEach>
        		</form:select>
        	</div>
        	<div class="row">
        		<form:label path="number" class="col-sm-3 form-label fs-5 fw-semibold">License Number:</form:label>
        		<div class="mb-4 col-sm-9">
        			<form:input type="number" class="form-control fs-5" path="number" placeholder="Enter license number"/>
        			<form:errors path="number" class="text-danger"/>
        		</div>
        	</div>
        	<div class="row">
        		<form:label path="state" class="col-sm-3 form-label fs-5 fw-semibold">State:</form:label>
        		<div class="mb-4 col-sm-9">
        			<form:input type="text" class="form-control fs-5" path="state" placeholder="Enter state"/>
        			<form:errors path="state" class="text-danger"/>
        		</div>
        	</div>
        	<div class="row">
        		<form:label path="expirationDate" class="col-sm-3 form-label fs-5 fw-semibold">Expiration Date:</form:label>
        		<div class="mb-4 col-sm-9">
        			<form:input type="date" class="form-control fs-5" path="expirationDate"/>
        			<form:errors path="expirationDate" class="text-danger"/>
        		</div>
        	</div>
        	<input type="submit" class="btn btn-primary bg-gradient shadow fs-5 fw-semibold" value="Create">
        </form:form>
    </div>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>