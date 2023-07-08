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
    <title>Dojo Page</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
    <div id="ninjaTable" class="p-4 container">
        <h1 class="mb-5 text-center">${dojo.name}gakure Ninjas</h1>
        <table class="table table-striped table-bordered shadow fs-5">
            <thead>
                <tr class="table-active">
                    <th scope="col">First Name</th>
                    <th scope="col">Last Name</th>
                    <th scope="col">Age</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="ninja" items="${dojo.ninjas}">
                    <tr>
                        <td><c:out value="${ninja.firstName}"/></td>
                        <td><c:out value="${ninja.lastName}"/></td>
                        <td><c:out value="${ninja.age}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <br>
        <button class="btn btn-primary bg-gradient shadow fs-5 fw-semibold" onclick="location.href='/'">Back to Home</button>
    </div>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>