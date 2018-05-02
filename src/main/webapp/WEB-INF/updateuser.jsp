<%-- 
    Document   : updateuser
    Created on : 02-05-2018, 21:55:55
    Author     : Mads
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update User</title>
    </head>
    <body>
        <%@include file="../includes/fogmenu.jsp" %>
 
        <h1>Update User</h1>
        
        <form name="updateuser" action="FrontController" method="POST">
            <input type="hidden" name="command" value="updateuser">
            <input type="hidden" name="userid" value="<%=session.getAttribute("id")%>">
            Email:<br>
            <input type="text" name="email" value="<%=session.getAttribute("email")%>">
            <br>
            Password:<br>
            <input type="password" name="password">
            <br>  
            <input type="submit" value="Update User">   
        </form>
            
    </body>
</html>
