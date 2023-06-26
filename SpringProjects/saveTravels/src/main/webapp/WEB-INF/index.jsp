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
    <title>Save Travels</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
    <div class="p-4 container">
        <h1 class="mb-5 text-primary">Save Travels</h1>
        <table class="mb-5 table table-striped table-bordered shadow text-center fs-5">
            <thead>
                <tr class="table-active">
                    <th scope="col">Expense</th>
                    <th scope="col">Vendor</th>
                    <th scope="col">Amount</th>
                    <th scope="col">Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="expense" items="${expenses}">
                    <tr>
                        <td><a href="/expenses/${expense.id}"><c:out value="${expense.expenseName}"/></a></td>
                        <td><c:out value="${expense.vendor}"/></td>
                        <td>$<c:out value="${expense.amount}"/></td>
                        <td class="d-flex justify-content-evenly">
                        	<a href="/expenses/edit/${expense.id}">edit</a>
                        	<form action="/expenses/delete/${expense.id}" method="POST">
                        		<input type="hidden" name="_method" value="delete">
                        		<input type="submit" class="btn btn-danger bg-gradient shadow" value="Delete">
                        	</form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <hr>
        <h2 class="mb-5 text-primary">Add an expense:</h2>
        <form:form class="p-4 border shadow" action="/expenses/new" method="POST" modelAttribute="expense">
        	<div class="row">
        		<form:label path="expenseName" class="col-sm-3 form-label fs-5 fw-semibold">Expense Name:</form:label>
        		<div class="mb-4 col-sm-9">
        			<form:input type="text" class="form-control fs-5" path="expenseName" placeholder="Type expense name here"/>
        			<form:errors path="expenseName" class="text-danger"/>
        		</div>
        	</div>
        	<div class="row">
        		<form:label path="vendor" class="col-sm-3 form-label fs-5 fw-semibold">Vendor:</form:label>
        		<div class="mb-4 col-sm-9">
        			<form:input type="text" class="form-control fs-5" path="vendor" placeholder="Type vendor name here"/>
        			<form:errors path="vendor" class="text-danger"/>
        		</div>
        	</div>
        	<div class="row">
        		<form:label path="amount" class="col-sm-3 form-label fs-5 fw-semibold">Amount:</form:label>
        		<div class="mb-4 col-sm-9">
        			<form:input type="text" class="form-control fs-5" path="amount" placeholder="Enter amount here"/>
        			<form:errors path="amount" class="text-danger"/>
        		</div>
        	</div>
        	<div class="row">
        		<form:label path="description" class="col-sm-3 form-label fs-5 fw-semibold">Description:</form:label>
        		<div class="mb-4 col-sm-9">
        			<form:textarea rows="3" class="form-control fs-5" path="description" placeholder="Type description here"/>
        			<form:errors path="description" class="text-danger"/>
        		</div>
        	</div>
        	<div class="d-flex justify-content-end">
        		<input type="submit" class="btn btn-primary bg-gradient shadow fs-5 fw-semibold" value="Submit">
        	</div>
        </form:form>
    </div>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>