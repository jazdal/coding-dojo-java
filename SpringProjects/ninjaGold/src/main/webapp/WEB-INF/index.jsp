<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Ninja Gold Game</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
    <div class="p-4 container fs-5">
    	<div class="mb-5 d-flex justify-content-between">
    		<div class="d-flex">
        		<label for="amount" class="form-label me-3 fw-semibold">Your Gold: </label>
        		<p class="text-danger fw-semibold"><c:out value="${totalGold}"/></p>
        	</div>
        	<div>
        		<button class="btn btn-primary bg-gradient shadow" onclick="location.href='/reset'">Reset</button>
        	</div>
        </div>
        <div class="mb-5 d-flex row justify-content-center">
        	<form class="col-sm-2 me-3 p-3 card border shadow text-center" action="/process" method="POST">
        		<p class="fw-semibold">Farm</p>
        		<p>(earns 10-20 gold)
        		<br>
        		<br>
        		<hr>
        		<input type="hidden" name="type" value="farm">
        		<input class="btn btn-success bg-gradient shadow fw-semibold" type="submit" value="Find Gold!">
        	</form>
        	<form class="col-sm-2 ms-3 me-3 p-3 card border shadow text-center" action="/process" method="POST">
        		<p class="fw-semibold">Cave</p>
        		<p>(earns 5-10 gold)</p>
        		<br>
        		<hr>
        		<input type="hidden" name="type" value="cave">
        		<input class="btn btn-success bg-gradient shadow fw-semibold" type="submit" value="Find Gold!">
        	</form>
        	<form class="col-sm-2 ms-3 me-3 p-3 card border shadow text-center" action="/process" method="POST">
        		<p class="fw-semibold">House</p>
        		<p>(earns 2-5 gold)</p>
        		<br>
        		<hr>
        		<input type="hidden" name="type" value="house">
        		<input class="btn btn-success bg-gradient shadow fw-semibold" type="submit" value="Find Gold!">
        	</form>
        	<form class="col-sm-2 ms-3 me-3 p-3 card border shadow text-center" action="/process" method="POST">
        		<p class="fw-semibold">Quest</p>
        		<p>(earns/takes 0-50 gold)</p>
        		<hr>
        		<input type="hidden" name="type" value="quest">
        		<input class="btn btn-warning bg-gradient shadow fw-semibold" type="submit" value="Find Gold!">
        	</form>
        	<form class="col-sm-2 ms-3 p-3 card border shadow text-center" action="/process" method="POST">
        		<p class="fw-semibold">Spa</p>
        		<p>(takes 5-20 gold)</p>
        		<br>
        		<hr>
        		<input type="hidden" name="type" value="spa">
        		<input class="btn btn-danger bg-gradient shadow fw-semibold" type="submit" value="Lose Gold!">
        	</form>
        </div>
        <div class="row">
        	<label for="activities" class="form-label fw-semibold">Activities:</label>
        	<div id="message-box" class="card card-body fs-6 overflow-auto border shadow">
        		<c:forEach var="message" items="${messages}">
        			<c:choose>
        				<c:when test="${fn:contains(message, 'earned')}">
        					<p class="mb-0 text-success"><c:out value="${message}"/></p>
        				</c:when>
        				<c:when test="${fn:contains(message, 'lost')}">
        					<p class="mb-0 text-danger"><c:out value="${message}"/></p>
        				</c:when>
        			</c:choose>
        		</c:forEach>
        	</div>
        </div>
    </div>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>