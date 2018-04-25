<%-- 
    Document   : createorder
    Created on : 25-04-2018, 11:59:17
    Author     : alber
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Byg-selv carport</h1>
        <H2> Indtast mål på carport </H2>
        
        <form name="createorder" action="FrontController" method="POST">
            <input type="hidden" name="command" value="createorder">
            Længde:<br>
            <input type="number" name="length">
            <br>
            Bredde:<br>
            <input type="number" name="width">
            <br>
            Højde:<br>
            <input type="number" name="height">
            <br>
            <input type="submit" value="Submit">
        </form>
        
    </body>
</html>
