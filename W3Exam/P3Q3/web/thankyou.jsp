<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
            <div class="card">
                <div class="card-header">
                    <h2>Thank you. Your account has been created.</h2>
                </div>
                <div class="card-body">
                    <h4 class="card-title">Customer Name: ${account.getName()}</h4><br/>
                    <h5 class="card-subtitle mb-2 text-muted">Account No: ${account.getAccountNo()}</h5><br/>
                    <h5 class="card-subtitle mb-2 text-mute">Type of Account: ${account.getType()}</h5><br/>
                </div>
            </div>

        </div>	

    </body>
</html>