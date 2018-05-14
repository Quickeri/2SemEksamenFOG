<%-- 
    Document   : customerpage
    Created on : Aug 22, 2017, 2:33:37 PM
    Author     : kasper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer home page</title>
    </head>
    <body>
        <%@include file="../includes/customermenu.jsp" %> 
        <div class="container">
        <h2>Hej <%=session.getAttribute("email")%> </h2>
        Du er nu logget ind som kunde
        </div>
    </body>
</html>
