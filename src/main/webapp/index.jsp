<%-- 
    Document   : index
    Created on : Aug 22, 2017, 2:01:06 PM
    Author     : kasper
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome page</title>
    </head>
    <body>
        <%@include file="/includes/fogmenu.jsp" %>
        <h1 class="text-center">Velkommen til Fog Carport</h1>
        
        <div class="container">
        <h2>Log Ind</h2>
            <form name="login" action="FrontController" method="POST">
                    <input type="hidden" name="command" value="login">
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="text" id="email" class="form-control" name="email" value="kunde@somewhere.com">
                </div>
                <div class="form-group">
                    <label for="pass">Password:</label>
                    <input type="password" id="pass" class="form-control" name="password" value="1234">
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-default">Log Ind</button>
                </div>
            </form>
        </div>
                
        <div class="container">
        <h2>Eller Registrer</h2>
            <form name="register" action="FrontController" method="POST">
                    <input type="hidden" name="command" value="register">
                <div class="form-group">
                    <label for="name">Navn:</label>    
                    <input type="text" name="name" id="name" class="form-control">
                </div>
                <div class="form-group">
                    <label for="email">Email:</label>   
                    <input type="text" name="email" id="email" class="form-control">
                </div>        
                <div class="form-group">  
                    <label for="pass1">Password:</label>   
                    <input type="password" name="password1" id="pass1" class="form-control">
                </div>
                <div class="form-group"> 
                    <label for="pass2">Gentag Password:</label>   
                    <input type="password" name="password2" id="pass2" class="form-control">
                </div>    
                <div class="form-group">         
                    <button type="submit" class="btn btn-default">Opret Bruger</button>
                </div>
            </form>
                
        <% String error = (String) request.getAttribute( "error");
           if ( error != null) { %>
           <H2>Error!!</h2>
           <p><%= error %>
        <% }
        %>
    </body>
</html>
