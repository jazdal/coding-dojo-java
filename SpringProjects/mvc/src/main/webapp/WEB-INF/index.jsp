<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <div class="p-4 container">
        <h1 class="mb-5">All Books</h1>
        <table class="table table-striped table-bordered shadow text-center fs-5">
        	<thead>
        		<tr class="table-active">
        			<th scope="col">ID</th>
        			<th scope="col">Title</th>
        			<th scope="col">Language</th>
        			<th scope="col"># Pages</th>
        		</tr>
        	</thead>
        	<tbody>
        		<c:forEach var="book" items="${books}">
        			<tr>
        				<td><c:out value="${book.id}"/></td>
        				<td><a href="/books/<c:out value='${book.id}'/>"><c:out value="${book.title}"/></a></td>
        				<td><c:out value="${book.language}"/></td>
        				<td><c:out value="${book.numberOfPages}"/></td>
        			</tr>
        		</c:forEach>
        	</tbody>
        </table>
        <br>
        <button class="btn btn-primary bg-gradient shadow fs-5 fw-semibold" onclick="location.href='/books/new'">Add a Book</button>
    </div>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>