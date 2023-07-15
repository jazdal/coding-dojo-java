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
    <title>Book Lender Dashboard</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
    <div id="regForm" class="p-4 container">
    	<div class="mb-2 d-flex align-items-center justify-content-between">
        	<h3 class="mb-0 fw-semibold">Hello, ${currentUser.getName()}. Welcome to...</h3>
        	<a class="fs-4" href="/logout">Logout</a>
        </div>
        <div class="mb-4 d-flex align-items-center justify-content-between">
        	<h1 class="mb-0 fw-bold">The Book Broker!</h1>
        	<a class="fs-4" href="/books/new">+ Add a book to my shelf!</a>
        </div>
        <div class="mb-4">
        	<h3>Available Books to Borrow</h3>
        </div>
        <table class="mb-5 table table-striped table-bordered shadow text-center fs-5">
            <thead>
                <tr class="table-active">
                    <th scope="col">ID</th>
                    <th scope="col">Title</th>
                    <th scope="col">Author Name</th>
                    <th scope="col">Owner</th>
                    <th scope="col">Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="book" items="${books}">
                    <tr>
                    	<c:if test="${book.getBorrower().getId() eq null}">
                        	<td><c:out value="${book.getId()}"/></td>
                        	<td><a href="/books/${book.getId()}"><c:out value="${book.getTitle()}"/></a></td>
                        	<td><c:out value="${book.getAuthor()}"/></td>
                        	<td><c:out value="${book.getUser().getName()}"/></td>
                        	<c:choose>
                        		<c:when test="${currentUser.getId() eq book.getUser().getId()}">
                        			<td><a href="/books/${book.getId()}/edit">edit</a> <a href="/books/delete/${book.getId()}">delete</a></td>
                        		</c:when>
                        		<c:otherwise>
                        			<td><a href="/books/borrow/${book.getId()}">borrow</a>
                        		</c:otherwise>
                        	</c:choose>
                        </c:if>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
       	<div class="mb-4">
        	<h3>Books I'm Borrowing</h3>
        </div>
        <table class="table table-striped table-bordered shadow text-center fs-5">
            <thead>
                <tr class="table-active">
                    <th scope="col">ID</th>
                    <th scope="col">Title</th>
                    <th scope="col">Author Name</th>
                    <th scope="col">Owner</th>
                    <th scope="col">Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="book" items="${books}">
                    <tr>
                        <c:if test="${currentUser.getId() eq book.getBorrower().getId()}">
                        	<td><c:out value="${book.getId()}"/></td>
                        	<td><a href="/books/<c:out value='${book.getId()}'/>"><c:out value="${book.getTitle()}"/></a></td>
                        	<td><c:out value="${book.getAuthor()}"/></td>
                        	<td><c:out value="${book.getUser().getName()}"/></td>
                        	<td><a href="/return/books/${book.getId()}">return</a></td>
                        </c:if>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
     </div>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
