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
    <title>Search</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
    <div class="p-4 container">
    	<h1 class="mb-5">Songs by: ${artist}</h1>
        <table class="mb-5 table table-striped table-bordered shadow fs-5">
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
        <a href="/dashboard" class="fs-3">Dashboard</a>
    </div>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>