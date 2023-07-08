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
    <title>Dojos and Ninjas</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
    <div class="p-4 container">
    	<h1 class="text-center fw-bold">DOJOS AND NINJAS</h1>
    	<div id="content" class="d-flex row align-items-center justify-content-center">
    		<div class="col-sm-3">
    			<div class="card shadow" onclick="location.href='/dojos/new'">
    				<div class="card-body">
    					<h3 class="mb-4 card-title text-center fw-bold">New Dojo</h3>
    					<div class="d-flex justify-content-center">
    						<img src="/img/dojo.png" alt="dojo" width="40%">
    					</div>
    				</div>
    			</div>
    		</div>
    		<div class="col-sm-3">
    			<div class="card shadow" onclick="location.href='/ninjas/new'">
    				<div class="card-body">
    					<h3 class="mb-4 card-title text-center fw-bold">New Ninja</h3>
    					<div class="d-flex justify-content-center">
    						<img src="/img/ninja.png" alt="ninja" width="40%">
    					</div>
    				</div>
    			</div>
    		</div>
    	</div>
    	<p class="text-center fs-4 fw-semibold">
    		<c:forEach var="dojo" items="${dojos}">
    			| <c:out value="${dojo.name.toUpperCase()}"/>GAKURE 
    		</c:forEach> |
    	</p>
    </div>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>