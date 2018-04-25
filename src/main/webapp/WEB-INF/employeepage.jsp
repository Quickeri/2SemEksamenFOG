<%-- 
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
    Author     : kasper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../includes/fogmenu.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee home page</title>
    </head>
    <body>
        <h1>Hello <%=session.getAttribute("email")%> </h1>
        You are now logged in as a EMPLOYEE of our wonderful site.
        
        <a href="FrontController?command=vieworders">View Orders</a>
    </body>
</html>
