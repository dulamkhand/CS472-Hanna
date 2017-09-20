<%-- 
    Document   : thankyou
    Created on : Sep 20, 2017, 2:25:44 PM
    Author     : 985892
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate,java.time.format.DateTimeFormatter, javax.servlet.http.HttpSession" %>

<% //HTTPSession session = request.getSession(true); %>
<!DOCTYPE html>
<html lang='en'>
    <head>
        <meta charset='UTF-8'>
        <meta name='viewport' content='width=device-width, initial-scale=1.0', shrink-to-fit=no">
        <meta http-equiv='X-UA-Compatible' content='ie=edge'>
        <title>Customer Contact App - Thank you!</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
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
             <a class="navbar-brand" href="index.html">CS472 ::: W3D1 Lab</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
            </button>            
        </nav>
        <div class="container">	
            <div class="container"><br/>
                <span style="float:right;" class="text-muted"><%= LocalDate.now().format(
                DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy")) %></span>
            </div>
            <p>
                <br/>
            <div class="card">
                <div class="card-header">
                    <h2>Thank you! Your message has been received as follows:</h2>
                </div>
                <div class="card-body">
                    <h4 class="card-title">Name: <%= (String) session.getAttribute("customerName")%></h4><br/>
                    <h5 class="card-subtitle mb-2 text-muted">Gender: <%= (String) session.getAttribute("gender")%></h5><br/>
                    <h5 class="card-subtitle mb-2 text-muted">Category: <%= (String) session.getAttribute("category")%></h4><br/>
                        <p class="card-text">Message: <%= (String) session.getAttribute("message")%></p><br/><br/>
                        <p>Please feel free to <a href="contact" class="card-link">Contact Us</a> again</p>
                </div>
            </div>
        </p>

        <div class="container">
            <span class="text-muted">Hit Count for this page: <%= (String) session.getAttribute("hitCount")%></span><span style="float:right;" class="text-muted">Total Hit Count for the entire WebApp: --</span>
        </div>		

    </div>
    <footer class="footer">
        <div class="container">
            <span class="text-muted">O. Kalu ::: CS472-WAP</span><span style="float:right;" class="text-muted">&copy September 2017</span>
        </div>
    </footer>      
</body>
</html>	
