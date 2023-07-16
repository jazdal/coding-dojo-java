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
    <title>Home</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
	<div class="p-4 container">
		<h1 class="mb-5 text-center">Home Page</h1>
		<p class="mb-1 fs-5"><a href="/products/new">New Product</a></p>
		<p class="mb-4 fs-5"><a href="/categories/new">New Category</a></p>
		<hr>
		<table class="table table-bordered shadow fs-5">
			<thead>
				<tr class="table-active text-center">
					<th scope="col">Products</th>
					<th scope="col">Categories</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
						<c:forEach var="product" items="${products}">
							<ul>
								<li><a href="/products/${product.id}">${product.getProdName()}</a></li>
							</ul>
						</c:forEach>
					</td>
					<td>
						<c:forEach var="category" items="${categories}">
							<ul>
								<li><a href="/categories/${category.id}">${category.getCatName()}</a></li>
							</ul>
						</c:forEach>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>