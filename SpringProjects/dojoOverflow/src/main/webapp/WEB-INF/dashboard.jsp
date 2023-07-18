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
    <title>Questions Dashboard</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
    <div id="dashboard" class="p-5 container">
        <h1 class="mb-5">Questions Dashboard</h1>
        <table class="mb-5 table table-striped table-bordered shadow text-center fs-5">
            <thead>
                <tr class="table-active">
                    <th scope="col">Question</th>
                    <th scope="col">Tags</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="question" items="${questions}">
                    <tr>
                        <td><a href="/questions/${question.id}">${question.text}</a></td>
                        <td>
                        	<c:forEach var="tag" items="${question.tags}">
                        		<span>${tag.subject}
                        			<c:if test="${question.tags.indexOf(tag) < question.tags.size() - 1}">, </c:if>
                        		</span>
                        	</c:forEach>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div class="d-flex align-items-center justify-content-end">
        	<a class="fs-5" href="/questions/new">New Question</a>
        </div>
     </div>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
