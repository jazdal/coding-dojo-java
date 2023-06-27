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
    <title>Lookify</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
	<nav class="navbar navbar-expand-lg bg-primary-subtle bg-gradient">
		<div class="container-fluid">
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target=#navbarSupportedContent>
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0 fs-5 fw-semibold">
					<li class="nav-item">
						<a class="nav-link text-primary" href="/songs/new">Add New</a>
					</li>
					<li class="nav-item">
						<a class="nav-link text-danger" href="/songs/top-ten">Top Songs</a>
					</li>
				</ul>
				<form class="d-flex" action="/search" method="POST">
					<input id="search-box" class="form-control me-2 fs-5" type="search" name="artist" placeholder="Search">
					<button class="btn btn-primary bg-gradient shadow fs-5" type="submit">Search</button>
				</form>
			</div>
		</div>
	</nav>
    <div class="p-4 container">
        <table class="table table-striped table-bordered shadow fs-5">
            <thead>
                <tr class="table-active">
                    <th scope="col">Name</th>
                    <th scope="col">Rating</th>
                    <th scope="col">Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="song" items="${songs}">
                    <tr>
                        <td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
                        <td><c:out value="${song.rating}"/></td>
                        <td><a href="/delete/${song.id}">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>