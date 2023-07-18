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
    <title>Question</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
    <div id="dashboard" class="p-5 container">
        <h1>${thisQuestion.text}</h1>
        <p class="mb-5 fs-5"><a href="/">Dashboard</a></p>
        <span class="me-3 fs-4 fw-semibold">Tags:</span>
		<c:forEach var="tag" items="${thisQuestion.tags}">
			<button class="me-2 btn btn-secondary bg-gradient shadow fw-semibold disabled"><c:out value="${tag.subject}"></c:out></button>
        </c:forEach>
        <div class="d-flex justify-content-between">
        	<div class="card col-sm-6 border-light">
        		<div class="card-body">
        			<h2 class="mb-4">Answers:</h2>
        			<c:forEach var="answer" items="${thisQuestion.answers}">
        				<ul class="mb-2">
        					<li class="fs-5">${answer.text}</li>
        				</ul>
        			</c:forEach>
        		</div>
        	</div>
        	<form:form class="form p-3 card col-sm-6 border-light" action="/answer" method="POST" modelAttribute="answer">
        		<input type="hidden" name="questionId" value="${thisQuestion.id}">
        		<h2>Add your answer:</h2>
        		<div class="mb-4 row justify-content-between">
        			<div class="col-auto">
        				<form:label class="col-form-label fs-5 fw-semibold" path="text">Answer:</form:label>
        			</div>
        			<div class="col-sm-9">
        				<form:textarea type="text" class="form-control fs-5" rows="6" path="text" placeholder="Type your answer here"/>
        				<form:errors path="text" class="text-danger"/>
        			</div>
        		</div>
        		<div class="row">
        			<input type="submit" class="btn btn-secondary bg-gradient shadow fs-5 fw-semibold" value="Answer!!!">
        		</div>
        	</form:form>
        </div>
     </div>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
