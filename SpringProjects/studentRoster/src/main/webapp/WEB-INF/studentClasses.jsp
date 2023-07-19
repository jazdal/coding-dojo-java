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
    <title>${student.name}</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
    <div id="dashboard" class="p-4 container">
        <h1 class="mb-5 text-center">${student.name}'s Classes</h1>
        <a class="fs-4" href="/dorms">Dashboard</a>
        <form:form class="p-4 mt-4 mb-5 bg-primary-subtle bg-gradient border shadow fs-5" action="/subjects/addToStudent/${student.id}" method="POST" modelAttribute="student">
        	<div class="row">
        		<div class="col-sm-6 text-center">
        			<form:label path="id" class="form-label fs-4 fw-semibold">Classes</form:label>
        			<form:select path="id" class="form-select fs-5">
        				<c:forEach var="subject" items="${allSubjects}">
        					<form:option value="${subject.id}" path="id">
        						<c:out value="${subject.className}"/>
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
                    <th scope="col">Class Name</th>
                    <th scope="col">Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="subject" items="${studentSubjects}">
                    <tr>
                        <td><a href="/subjects/${subject.id}"><c:out value="${subject.className}"/></a></td>
                        <td><a href="/subjects/remove/${subject.id}/${student.id}">Drop</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
