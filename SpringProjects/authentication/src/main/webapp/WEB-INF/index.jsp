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
    <title>Login and Registration</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
    <div id="regForm" class="p-4 container">
        <h1 class="mb-3 fw-bold">Welcome!</h1>
        <h4 class="mb-4">Join our growing community</h4>
        <div class="row justify-content-between">
        	<form:form class="p-3 col-sm-6 card bg-primary-subtle bg-gradient shadow" action="/register" method="POST" modelAttribute="user">
        		<div class="card-body">
        			<h2 class="mb-4 card-title">Register</h2>
        			<div class="row mb-4 g-3 align-items-center justify-content-between">
        				<div class="col-auto">
        					<form:label path="userName" class="col-form-label fs-5 fw-semibold">User Name:</form:label>
        				</div>
        				<div class="col-sm-8">
        					<form:input type="text" class="form-control fs-5" path="userName" placeholder="Enter username"/>
        					<form:errors path="userName" class="text-danger"/>
        				</div>
        			</div>
        			<div class="row mb-4 g-3 align-items-center justify-content-between">
        				<div class="col-auto">
        					<form:label path="email" class="col-form-label fs-5 fw-semibold">Email:</form:label>
        				</div>
        				<div class="col-sm-8">
        					<form:input type="email" class="form-control fs-5" path="email" placeholder="Enter email"/>
        					<form:errors path="email" class="text-danger"/>
        				</div>
        			</div>
        			<div class="row mb-4 g-3 align-items-center justify-content-between">
        				<div class="col-auto">
        					<form:label path="birthday" class="col-form-label fs-5 fw-semibold">Birthday:</form:label>
        				</div>
        				<div class="col-sm-8">
        					<form:input type="date" class="form-control fs-5" path="birthday"/>
        					<form:errors path="birthday" class="text-danger"/>
        				</div>
        			</div>
        			<div class="row mb-4 g-3 align-items-center justify-content-between">
        				<div class="col-auto">
        					<form:label path="language" class="col-form-label fs-5 fw-semibold">Language:</form:label>
        				</div>
        				<div class="col-sm-8">
        					<form:select path="language" class="form-select fs-5">
        						<form:option value="Choose Language:"/>
        						<form:option path="language" value="JavaScript"/>
        						<form:option path="language" value="Python"/>
        						<form:option path="language" value="Java"/>
        					</form:select>
        				</div>
        			</div>
        			<div class="row mb-4 g-3 align-items-center justify-content-between">
        				<div class="col-auto">
        					<form:label path="password" class="col-form-label fs-5 fw-semibold">Password:</form:label>
        				</div>
        				<div class="col-sm-8">
        					<form:input type="password" class="form-control fs-5" path="password" placeholder="Enter password"/>
        					<form:errors path="password" class="text-danger"/>
        				</div>
        			</div>
        			<div class="row mb-5 g-3 align-items-center justify-content-between">
        				<div class="col-auto">
        					<form:label path="confirm" class="col-form-label fs-5 fw-semibold">Confirm PW:</form:label>
        				</div>
        				<div class="col-sm-8">
        					<form:input type="password" class="form-control fs-5" path="confirm" placeholder="Confirm password"/>
        					<form:errors path="confirm" class="text-danger"/>
        				</div>
        			</div>
        			<div class="row g-3 align-items-center">
        				<input type="submit" class="btn btn-primary bg-gradient shadow fs-5 fw-semibold" value="Submit">
        			</div>
        		</div>
        	</form:form>
        	<form:form class="p-3 col-sm-6 card bg-warning-subtle bg-gradient shadow" action="/login" method="POST" modelAttribute="loginuser">
        		<div class="card-body">
        			<h2 class="mb-4 card-title">Login</h2>
        			<div class="row mb-4 g-3 align-items-center justify-content-between">
        				<div class="col-auto">
        					<form:label path="email" class="col-form-label fs-5 fw-semibold">Email:</form:label>
        				</div>
        				<div class="col-sm-8">
        					<form:input type="email" class="form-control fs-5" path="email" placeholder="Enter email"/>
        					<form:errors path="email" class="text-danger"/>
        				</div>
        			</div>
        			<div class="row mb-5 g-3 align-items-center justify-content-between">
        				<div class="col-auto">
        					<form:label path="password" class="col-form-label fs-5 fw-semibold">Password:</form:label>
        				</div>
        				<div class="col-sm-8">
        					<form:input type="password" class="form-control fs-5" path="password" placeholder="Enter password"/>
        					<form:errors path="password" class="text-danger"/>
        				</div>
        			</div>
        			<div class="row g-3 align-items-center">
        				<input type="submit" class="btn btn-warning bg-gradient shadow fs-5 fw-semibold" value="Submit">
        			</div>
        		</div>
        	</form:form>
        </div>
    </div>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
