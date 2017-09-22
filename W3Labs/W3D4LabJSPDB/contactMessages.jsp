<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>CS472-WAP - Customer Contacts WebApp - Contact Messages</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
	<link rel="stylesheet" href="css/main.css">		
</head>
<body>
    <nav class="navbar navbar-expand-md navbar-dark bg-dark">
        <a class="navbar-brand" href="index.html">CS472 ::: W3D3/4 Lab</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
    </nav>
	<div class="container">
		<h2>List of Contact Messages</h2>
		<table class="table table-hover table-responsive">
		  <thead>
		    <tr>
		      <th>#</th>
		      <th>Customer Name</th>
		      <th>Gender</th>
		      <th>Category</th>
		      <th>Message</th>
		      <th>Date Submitted</th>	      
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach var="contactMessage" items="${listContactMessages}">
		    <tr>
		      <th scope="row">${contactMessage.contactMessageId}</th>
		      <td>${contactMessage.customerName}</td>
		      <td>${contactMessage.gender}</td>
		      <td>${contactMessage.category}</td>
		      <td>${contactMessage.message}</td>
		      <td>${contactMessage.currentDate}</td>
		    </tr>
		    </c:forEach>	
		   </tbody>
		  </table>	
	</div>
	<div class="container">
		<p>You are welcome to <a href="./contactForm">submit a new Contact Message</a></p>
	</div>
	<footer class="footer">
	    <div class="container">
            <span class="text-muted">O. Kalu ::: CS472-WAP</span>
            <span style="float:right;" class="text-muted">&copy September 2017</span>
        </div>
	</footer>    	
</body>
</html>