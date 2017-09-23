<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>CS472 ::: MiniBanking App</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
        <link rel="stylesheet" href="css/main.css">		
    </head>
    <body>
        <nav class="navbar navbar-expand-md navbar-dark bg-dark">
            <a class="navbar-brand" href="index.html">CS472 ::: MiniBanking App</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
        </nav>
        <div class="container">
            <form id="formCustomerContact" method="post" action="processAccountFormData">
                <fieldset>
                    <legend>Bank Account Form</legend>
                    ${errMsgs} <br/>

                    <div class="form-group">
                        <label for="accountNo">Account No:</label>
                        <input type="text" class="form-control" id="accountNo" name="accountNo" 
                               aria-describedby="accountNoHelp" placeholder="01-XXX-XXXX" 
                               title="Enter your account number" value="${account.getAccountNo()}"
                               pattern="^01-\d{3}-\d{4}$"/>
                        <small id="accountNoHelp" class="form-text text-muted">Your unique account number.</small>                        
                    </div>
                        
                    <div class="form-group">
                        <label for="customerName">Customer Name:</label>
                        <input type="text" class="form-control" id="customerName" name="customerName" aria-describedby="customerNameHelp" placeholder="e.g. John Smith" title="Enter your full name" value="${account.getName()}" />
                        <small id="customerNameHelp" class="form-text text-muted">Enter your full name.</small>                        
                    </div>

                    <div class="form-group">
                        <label for="type">Type of Account:</label>
                        <select class="form-control" id="type" name="type">
                            <c:choose>
                                <c:when test="${account.getType() eq 'Checking'}">
                                    <option selected value="Checking">Checking</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="Savings">Savings</option>
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${account.getType() eq 'Savings'}">
                                    <option selected value="Savings">Savings</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="Checking">Checking</option>
                                </c:otherwise>
                            </c:choose>
                        </select>
                    </div>				

                    <button id="btnSubmit" type="submit" class="btn btn-primary btn-block">Create New Account</button>
                </fieldset>
            </form>
        </div>	
    </body>
</html>