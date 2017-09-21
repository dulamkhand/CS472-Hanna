<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang='en'>
<head>
<meta charset='UTF-8'>
<meta name='viewport' content='width=device-width, initial-scale=1.0'
	, shrink-to-fit=no">
<meta http-equiv='X-UA-Compatible' content='ie=edge'>
<title>Customer Contact App - Thank you!</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/main.css">
<style type="text/css">
html {
	position: relative;
	min-height: 100%;
}

body {
	margin-bottom: 40px;
}

.footer {
	position: absolute;
	bottom: 0;
	width: 100%;
	height: 40px;
	line-height: 40px;
	background-color: #f5f5f5;
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-dark bg-dark">
		<a class="navbar-brand" href="index.html">CS472 ::: W3D2 Lab</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarsExampleDefault"
			aria-controls="navbarsExampleDefault" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
	</nav>
	<div class="container">
		<div class="container">
			<br /> <span style="float: right;" class="text-muted">Wednesday,
				20 September 2017</span>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>Customer Name</th>
					<th>Gender</th>
					<th>Category</th>
					<th>Message</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="mList" items="${sessionScope.messageList}" >
					<tr>
						<td>${mList.name} </td>
						<td>${mList.gender}</td>
						<td>${mList.category}</td>
						<td>${mList.message}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="container">
			<span class="text-muted">Hit Count for this page: 2</span><span
				style="float: right;" class="text-muted">Total Hit Count for
				the entire WebApp: --</span>
		</div>
	</div>
	<footer class="footer">
		<div class="container">
			<span class="text-muted">Aldarkhangai Chimed-Ochir :::
				CS472-WAP</span><span style="float: right;" class="text-muted">&copy
				September 2017</span>
		</div>
	</footer>
</body>
</html>
