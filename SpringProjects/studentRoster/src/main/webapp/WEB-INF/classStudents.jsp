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
    <title>${subject.className}</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
    <div id="dashboard" class="p-4 container">
        <h1 class="mb-5 text-center">Students Taking <c:out value="${subject.className}"/></h1>
        <a class="fs-4" href="/">Dashboard</a>
        <table class="mt-4 table table-striped table-bordered shadow text-center fs-5">
            <thead>
                <tr class="table-active">
                    <th scope="col">Name</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="student" items="${students}">
                    <tr>
                        <td><a href="/students/${student.id}">${student.name}</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
