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
    <title>Edit Expense</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
    <div class="p-4 container">
    	<div class="d-flex align-items-center justify-content-between">
        	<h1 class="mb-5 text-success">Edit Expense</h1>
        	<a href="/expenses" class="mb-5 fs-5">Go Back</a>
        </div>
        <form:form class="p-4 border shadow" action="/expenses/edit/${expense.id}" method="PUT" modelAttribute="expense">
        	<div class="row">
        		<form:label path="expenseName" class="col-sm-3 form-label fs-5 fw-semibold">Expense Name:</form:label>
        		<div class="mb-4 col-sm-9">
        			<form:input type="text" class="form-control fs-5" path="expenseName"/>
        			<form:errors path="expenseName" class="text-danger"/>
        		</div>
        	</div>
        	<div class="row">
        		<form:label path="vendor" class="col-sm-3 form-label fs-5 fw-semibold">Vendor:</form:label>
        		<div class="mb-4 col-sm-9">
        			<form:input type="text" class="form-control fs-5" path="vendor"/>
        			<form:errors path="vendor" class="text-danger"/>
        		</div>
        	</div>
        	<div class="row">
        		<form:label path="amount" class="col-sm-3 form-label fs-5 fw-semibold">Amount:</form:label>
        		<div class="mb-4 col-sm-9">
        			<form:input type="text" class="form-control fs-5" path="amount"/>
        			<form:errors path="amount" class="text-danger"/>
        		</div>
        	</div>
        	<div class="row">
        		<form:label path="description" class="col-sm-3 form-label fs-5 fw-semibold">Description:</form:label>
        		<div class="mb-4 col-sm-9">
        			<form:textarea rows="3" class="form-control fs-5" path="description"/>
        			<form:errors path="description" class="text-danger"/>
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