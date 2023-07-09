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
    <title>${dorm.name}</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
    <div id="dashboard" class="p-4 container">
        <h1 class="mb-5 text-center">${dorm.name} Students</h1>
        <a class="fs-4" href="/dorms">Dashboard</a>
        <form:form class="p-4 mt-4 mb-5 bg-primary-subtle bg-gradient border shadow fs-5" action="/students/addToDorm/${dorm.id}" method="POST" modelAttribute="dorm">
        	<div class="row">
        		<div class="col-sm-6 text-center">
        			<form:label path="id" class="form-label fs-4 fw-semibold">Students</form:label>
        			<form:select path="id" class="form-select fs-5">
        				<c:forEach var="student" items="${allStudents}">
        					<form:option value="${student.id}" path="id">
        						<c:out value="${student.name}"/> (<c:out value="${student.dorm.name}"/>)
        					</form:option>
        				</c:forEach>
        			</form:select>
        		</div>
        		<div class="col-sm-6 d-flex align-items-end">
        			<input id="submit-btn" type="submit" class="btn btn-warning bg-gradient shadow fs-5 fw-semibold" value="Add">
        		</div>
        	</div>
        </form:form>
        <hr>
        <table class="mt-4 table table-striped table-bordered shadow text-center fs-5">
        	<thead>
                <tr class="table-active">
                    <th scope="col">Student</th>
                    <th scope="col">Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="student" items="${dormStudents}">
                    <tr>
                        <td><c:out value="${student.name}"/></td>
                        <td><a href="/students/remove/${student.id}">Remove</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
