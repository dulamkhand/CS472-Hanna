<!DOCTYPE html>
<html lang='en'>
<head>
<meta charset='UTF-8'>
<meta name='viewport' content='width=device-width, initial-scale=1.0'
	, shrink-to-fit=no">
<meta http-equiv='X-UA-Compatible' content='ie=edge'>
<title>Customer Contact App</title>
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
		<span><a class="navbar-brand" href="index.html">CS472 :::
				W3D2 Lab</a></span> <span style="float: right;"> <a id="btnLogout"
			href="logout.jsp" class="btn btn-primary btn-block">Logout</a>
		</span>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarsExampleDefault"
			aria-controls="navbarsExampleDefault" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
	</nav>
	<div class="container">
		<form id="formCustomerContact" method="post" action="processContact">
			<fieldset>
				<legend>Customer Contact Form </legend>
				<div class="form-group">
					<label for="customerName">*Name:</label> <input type="text"
						class="form-control" id="customerName" name="customerName"
						aria-describedby="customerNameHelp" placeholder="e.g. John Smith"
						title="Enter your full name"><small id="customerNameHelp"
						class="form-text text-muted">Enter your full name.</small>
				</div>
				<label>*Gender:</label><br /> <label
					class="custom-control custom-radio"> <input
					id="radioGenderMale" name="radioGender" type="radio"
					class="custom-control-input" value='male' /> <input
					id="radioGenderMale" name="radioGender" type="radio"
					class="custom-control-input" value='male'> <span
					class="custom-control-indicator"></span> <span
					class="custom-control-description">Male</span></label> <label
					class="custom-control custom-radio"> <input
					id="radioGenderFemale" name="radioGender" type="radio"
					class="custom-control-input" value='female' /> <input
					id="radioGenderFemale" name="radioGender" type="radio"
					class="custom-control-input" value='female'> <span
					class="custom-control-indicator"></span> <span
					class="custom-control-description">Female</span></label>
				<div class="form-group">
					<label for="ddlCategory">*Category:</label> <select
						class="form-control" id="ddlCategory" name="ddlCategory">
						<option value="null">Select...</option>
						<option value="feedback">Feedback</option>
						<option value="inquiry">Inquiry</option>
						<option value="complaint">Complaint</option>
					</select>
				</div>
				<div class="form-group">
					<label for="message">*Message:</label>
					<textarea class="form-control" id="message" name="message" rows="3"></textarea>
				</div>
				<div>
					<p>${sessionScope.errorMsg}</p>
				</div>
				<button id="btnSubmit" type="submit"
					class="btn btn-primary btn-block">Submit</button>
			</fieldset>
		</form>
	</div>
	<div class="container">
		<br />
		<span class="text-muted">Hit Count for this page: 2</span> <span
			style="float: right;" class="text-muted">Total Hit Count for
			the entire WebApp: --</span>
	</div>
	<footer class="footer">
		<div class="container">
			<span class="text-muted">Aldarkhangai Chimed-Ochir :::
				CS472-WAP</span> <span style="float: right;" class="text-muted">&copy
				September 2017</span>
		</div>
	</footer>
</body>
</html>