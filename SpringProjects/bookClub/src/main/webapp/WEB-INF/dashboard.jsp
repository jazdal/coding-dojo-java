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
    <title>Read Share</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
    <div id="regForm" class="p-4 container">
    	<div class="mb-3 d-flex align-items-center justify-content-between">
        	<h1 class="mb-0 fw-bold">Welcome, ${currentUser.getName()}!</h1>
        	<a class="fs-4" href="/logout">Logout</a>
        </div>
        <div class="mb-4 d-flex align-items-center justify-content-between">
        	<h3 class="mb-0">Books from everyone's shelves:</h3>
        	<a class="fs-4" href="/books/new">+ Add a book to my shelf!</a>
        </div>
        <table class="table table-striped table-bordered shadow text-center fs-5">
            <thead>
                <tr class="table-active">
                    <th scope="col">ID</th>
                    <th scope="col">Title</th>
                    <th scope="col">Author Name</th>
                    <th scope="col">Posted By</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="book" items="${books}">
                    <tr>
                        <td><c:out value="${book.getId()}"/></td>
                        <td><a href="/books/<c:out value='${book.getId()}'/>"><c:out value="${book.getTitle()}"/></a></td>
                        <td><c:out value="${book.getAuthor()}"/></td>
                        <td><c:out value="${book.getUser().getName()}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
