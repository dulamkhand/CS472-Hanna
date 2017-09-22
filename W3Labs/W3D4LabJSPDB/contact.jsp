<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>CS472-WAP - Customer Contacts WebApp</title>
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
        <form id="formCustomerContact" method="post" action="processContact">
            <fieldset>
                <legend>Customer Contact Form</legend>
                <%-- Error messages --%>
                ${errMsgs} 
                <%-- End Error messages --%>                
                <div class="form-group">
                    <label for="customerName">*Name:</label>
                    <input type="text" class="form-control" id="customerName" name="customerName" aria-describedby="customerNameHelp" placeholder="e.g. John Smith" title="Enter your full name" value="${contactMessage.customerName}" />
                    <small id="customerNameHelp" class="form-text text-muted">Enter your full name.</small>                        
                </div>
                <label>*Gender:</label><br/>
                <label class="custom-control custom-radio">
                	<c:choose>
                		<c:when test="${contactMessage.gender eq 'male'}">
                    		<input id="radioGenderMale" name="radioGender" type="radio" class="custom-control-input" value='male' checked />
                    	</c:when>
                    	<c:otherwise>
                    		<input id="radioGenderMale" name="radioGender" type="radio" class="custom-control-input" value='male' />
                    	</c:otherwise>
                    </c:choose>
                    <span class="custom-control-indicator"></span>
                    <span class="custom-control-description">Male</span>
                </label>
                <label class="custom-control custom-radio">
                	<c:choose>
                		<c:when test="${contactMessage.gender eq 'female'}">
                    		<input id="radioGenderFemale" name="radioGender" type="radio" class="custom-control-input" value='female' checked />
                    	</c:when>
                    	<c:otherwise>
                    		<input id="radioGenderFemale" name="radioGender" type="radio" class="custom-control-input" value='female'/>
                    	</c:otherwise>
                    </c:choose>                  
                    <span class="custom-control-indicator"></span>
                    <span class="custom-control-description">Female</span>
                </label>	
            
                <div class="form-group">
                    <label for="ddlCategory">*Category:</label>
                    <select class="form-control" id="ddlCategory" name="ddlCategory">
                    	<c:choose>
                    		<c:when test="${contactMessage.category eq 'null'}">
                        		<option selected value="null">Select...</option>
                        	</c:when>
                        	<c:otherwise>
                        		<option value="null">Select...</option>
                        	</c:otherwise>
                        </c:choose>
                        <c:choose>
                        	<c:when test="${contactMessage.category eq 'feedback'}">
                        		<option selected value="feedback">Feedback</option>
                        	</c:when>
                        	<c:otherwise>
                        		<option value="feedback">Feedback</option>
                        	</c:otherwise>
                        </c:choose>
                        <c:choose>
                        	<c:when test="${contactMessage.category eq 'inquiry'}">
                        		<option selected value="inquiry">Inquiry</option>
                        	</c:when>
                        	<c:otherwise>
                        		<option value="inquiry">Inquiry</option>
                        	</c:otherwise>
                        </c:choose>
                        <c:choose>
                        	<c:when test="${contactMessage.category eq 'complaint'}">
                        		<option selected value="complaint">Complaint</option>
                        	</c:when>
                        	<c:otherwise>
                        		<option value="complaint">Complaint</option>
                        	</c:otherwise>
                        </c:choose>
                    </select>
                </div>				
                
                <div class="form-group">
                    <label for="message">*Message:</label>
                    <textarea class="form-control" id="message" name="message" rows="3" >${contactMessage.message}</textarea>
                </div>
                
                <button id="btnSubmit" type="submit" class="btn btn-primary btn-block">Submit</button>
            </fieldset>
        </form>
    </div>	
    <div class="container"><br/>
        <span class="text-muted">
            Hit Count for this page: ${contactFormHitCount} 
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