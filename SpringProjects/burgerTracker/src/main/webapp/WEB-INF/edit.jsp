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
    <title>Burger Tracker</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
    <div class="p-4 container">
        <h1 class="mb-5 text-primary">Edit Burger</h1>
        <form:form class="p-4 border shadow" action="/burgers/edit/${burger.id}" method="PUT" modelAttribute="burger">
        	<div class="row">
        		<form:label path="burgerName" class="col-sm-3 form-label fs-5 fw-semibold">Burger Name</form:label>
        		<div class="mb-4 col-sm-9">
        			<form:input type="text" class="form-control fs-5" path="burgerName"/>
        			<form:errors path="burgerName" class="text-danger"/>
        		</div>
        	</div>
        	<div class="row">
        		<form:label path="restaurantName" class="col-sm-3 form-label fs-5 fw-semibold">Restaurant Name</form:label>
        		<div class="mb-4 col-sm-9">
        			<form:input type="text" class="form-control fs-5" path="restaurantName"/>
        			<form:errors path="restaurantName" class="text-danger"/>
        		</div>
        	</div>
        	<div class="row">
        		<form:label path="rating" class="col-sm-3 form-label fs-5 fw-semibold">Rating</form:label>
        		<div class="mb-4 col-sm-9">
        			<form:input type="number" class="form-control fs-5" path="rating"/>
        			<form:errors path="rating" class="text-danger"/>
        		</div>
        	</div>
        	<div class="row">
        		<form:label path="notes" class="col-sm-3 form-label fs-5 fw-semibold">Notes</form:label>
        		<div class="mb-4 col-sm-9">
        			<form:textarea rows="3" class="form-control fs-5" path="notes"/>
        			<form:errors path="notes" class="text-danger"/>
        		</div>
        	</div>
        	<div class="d-flex justify-content-end">
        		<input type="submit" class="btn btn-primary bg-gradient shadow fs-5 fw-semibold" value="Submit">
        	</div>
        </form:form>
    </div>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>