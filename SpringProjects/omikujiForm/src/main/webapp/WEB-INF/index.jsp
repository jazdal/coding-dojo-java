<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Omikuji</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
    <div class="p-4 container">
        <h1 class="text-center">Send an Omikuji!</h1>
        <br>
        <form class="p-5 border border-black shadow fs-5" action="/process" method="POST">
        	<div class="mb-3">
        		<label for="number" class="form-label">Pick any number from 5 to 25</label>
        		<input type="number" class="form-control form-control-lg" name="number" placeholder="Enter number here">
        	</div>
        	<div class="mb-3">
        		<label for="city" class="form-label">Enter the name of any city</label>
        		<input type="text" class="form-control form-control-lg" name="city" placeholder="Enter city name here">
        	</div>
        	<div class="mb-3">
        		<label for="name" class="form-label">Enter the name of any real person</label>
        		<input type="text" class="form-control form-control-lg" name="name" placeholder="Enter person name here">
        	</div>
        	<div class="mb-3">
        		<label for="hobby" class="form-label">Enter professional endeavor or hobby</label>
        		<input type="text" class="form-control form-control-lg" name="hobby" placeholder="Enter hobby here">
        	</div>
        	<div class="mb-3">
        		<label for="livingThing" class="form-label">Enter any type of living thing</label>
        		<input type="text" class="form-control form-control-lg" name="livingThing" placeholder="Enter type of living thing here">
        	</div>
        	<div class="mb-3">
        		<label for="comment" class="form-label">Say something nice to someone</label>
        		<textarea class="form-control form-control-lg" rows="4" name="comment" placeholder="Enter comment here"></textarea>
        	</div>
        	<p>Send and show a friend</p>
        	<div class="d-flex justify-content-end">
        		<input class="btn btn-primary bg-gradient shadow" type="submit" value="Send">
        	</div>
        </form>
    </div>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>