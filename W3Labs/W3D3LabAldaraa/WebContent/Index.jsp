<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>First JSP</title>
</head>
<body>
	<div>
		<h1>
			Hello Java Server Page
		</h1>
		<p>
			<%
				String numbers = "";
				for(int n=1; n<=10;n++){
					numbers += n;
				}
				out.append(numbers);
			%>
		</p>
	</div>
</body>
</html>