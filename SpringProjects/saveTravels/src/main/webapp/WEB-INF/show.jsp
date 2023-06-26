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
    <title>Show Expense</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
    <div class="p-4 container">
    	<div class="d-flex align-items-center justify-content-between">
        	<h1 class="mb-5 text-primary">Expense Details</h1>
        	<a href="/expenses" class="mb-5 fs-5">Go Back</a>
        </div>
        <div class="p-4 card border shadow">
        	<div class="row">
        		<label class="col-sm-3 form-label fs-5 fw-semibold">Expense Name:</label>
        		<div class="mb-4 col-sm-9">
        			<span class="fs-5">${expense.expenseName}</span>
        		</div>
        	<div class="row">
        		<label class="col-sm-3 form-label fs-5 fw-semibold">Expense Description:</label>
        		<div class="mb-4 col-sm-9">
        			<span class="fs-5">${expense.description}</span>
        		</div>
        	</div>
        	</div>
        	<div class="row">
        		<label class="col-sm-3 form-label fs-5 fw-semibold">Vendor:</label>
        		<div class="mb-4 col-sm-9">
        			<span class="fs-5">${expense.vendor}</span>
        		</div>
        	</div>
        	<div class="row">
        		<label class="col-sm-3 form-label fs-5 fw-semibold">Amount Spent:</label>
        		<div class="mb-4 col-sm-9">
        			<span class="fs-5">$${expense.amount}</span>
        		</div>
        	</div>
        </div>
    </div>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>