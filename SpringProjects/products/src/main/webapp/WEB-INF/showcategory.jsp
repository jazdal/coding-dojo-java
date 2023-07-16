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
    <title>Category Page</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
	<div class="p-4 container">
		<h1 class="mb-5 text-center"><c:out value="${category.catName}"/></h1>
		<p class="mb-4 fs-5"><a href="/">Home</a></p>
		<hr>
		<h2>Products:</h2>
		<c:forEach var="product" items="${productsInCategories}">
			<ul>
				<li><c:out value="${product.prodName}"/></li>
			</ul>
		</c:forEach>
		<hr>
		<form:form action="/categories/${category.id}" method="POST" modelAttribute="category">
			<div class="row mb-4 align-items-center justify-content-between">
				<h3 class="mb-4">Add Product:</h3>
				<form:select class="form-select fs-5" path="id">
					<option selected disabled>Select Product:</option>
					<c:forEach var="product" items="${products}">
						<form:option value="${product.id}">
							<c:out value="${product.prodName}"/>
						</form:option>
					</c:forEach>
				</form:select>
			</div>
			<div class="row">
				<input type="submit" class="btn btn-primary bg-gradient shadow fs-5 fw-semibold" value="Add">
			</div>
		</form:form>
	</div>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>