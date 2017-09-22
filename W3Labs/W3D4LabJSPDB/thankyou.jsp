<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>CS472-WAP - Customer Contacts WebApp - Thank you!</title>
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
		<%-- Show current Date --%> 
		<div class="container"><br/>
			<span style="float:left;" class="text-muted"><a href="./listMessages">List of all Contact Messages</a></span>
			<span style="float:right;" class="text-muted">${contactMessage.currentDate}</span>
		</div>
		
		<br/>
		<div class="card">
			<div class="card-header">
				<h2>Thank you! Your message has been received as follows:</h2>
			</div>
			<div class="card-body">
				<h4 class="card-title">Name: ${contactMessage.customerName}</h4><br/>
				<h5 class="card-subtitle mb-2 text-muted">Gender: ${contactMessage.gender}</h5><br/>
				<h5 class="card-subtitle mb-2 text-mute">Category: ${contactMessage.category}</h5><br/>
				<p class="card-text">Message: ${contactMessage.message}</p><br/><br/>
				<p>Please feel free to <a href="./contactForm" class="card-link">Contact us</a> again</p>
				<p>Or view a <a href="./listMessages">list of all submitted Contact messages</a>
			</div>
		</div>

	</div>	
	<%-- Display Hit Counts --%>
    <div class="container"><br/>
        <span class="text-muted">
            Hit Count for this page: ${thankYouPageHitCount} 
        </span>
        <span style="float:right;" class="text-muted">
            Total Hit Count for the entire WebApp: ${totalHitCount}
        </span>
	</div>		
		
	<footer class="footer">
	    <div class="container">
            <span class="text-muted">O. Kalu ::: CS472-WAP</span>
            <span style="float:right;" class="text-muted">&copy September 2017</span>
        </div>
	</footer>          	
</body>
</html>