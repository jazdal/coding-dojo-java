<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Driver's License</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
    <div class="p-4 container">
        <h1 class="mb-5">Person Details:</h1>
        <table class="table table-striped table-bordered shadow text-center fs-5">
            <thead class="table-dark">
                <tr>
                    <th scope="col">Name</th>
                    <th scope="col">License Number</th>
                    <th scope="col">State</th>
                    <th scope="col">Exp Date</th>
                </tr>
            </thead>
            <tbody>
                    <tr>
                        <td><c:out value="${person.firstName} ${person.lastName}"/></td>
                        <td><c:out value="${person.license.number}"/></td>
                        <td><c:out value="${person.license.state}"/></td>
                        <td><fmt:formatDate value="${person.license.expirationDate}" pattern="yyyy-MM-dd"/></td>
                    </tr>
            </tbody>
        </table>
    </div>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>