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
    <title>New Category</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
	<div class="p-4 container">
		<h1 class="mb-5 text-center">New Category</h1>
		<p class="mb-4 fs-5"><a href="/">Home</a></p>
		<hr>
		<form:form class="p-3 card bg-secondary-subtle bg-gradient shadow" action="/categories/new" method="POST" modelAttribute="category">
			<div class="card-body">
				<div class="row mb-4 align-items-center justify-content-between">
					<div class="col-auto">
						<form:label path="catName" class="col-form-label fs-5 fw-semibold">Name:</form:label>
					</div>
					<div class="col-sm-10">
						<form:input type="text" class="form-control fs-5" path="catName" placeholder="Enter category name"/>
						<form:errors path="catName" class="text-danger"/>
					</div>
				</div>
				<div class="row">
					<input type="submit" class="btn btn-primary bg-gradient shadow fs-5 fw-semibold" value="Submit">
				</div>
			</div>
		</form:form>
	</div>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>