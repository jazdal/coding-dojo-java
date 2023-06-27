<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Details</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
    <div class="p-4 container">
        <h1 class="mb-5">Song Details</h1>
        <div class="p-4 mb-5 card border shadow">
        	<div class="row">
        		<label class="col-sm-2 form-label fs-5 fw-semibold">Title:</label>
        		<div class="mb-4 col-sm-9">
        			<span class="fs-5">${song.title}</span>
        		</div>
        	<div class="row">
        		<label class="col-sm-2 form-label fs-5 fw-semibold">Artist:</label>
        		<div class="mb-4 col-sm-9">
        			<span class="fs-5">${song.artist}</span>
        		</div>
        	</div>
        	</div>
        	<div class="row">
        		<label class="col-sm-2 form-label fs-5 fw-semibold">Rating:</label>
        		<div class="mb-4 col-sm-9">
        			<span class="fs-5">${song.rating}</span>
        		</div>
        	</div>
        </div>
        <a href="/dashboard" class="fs-3">Dashboard</a>
    </div>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>