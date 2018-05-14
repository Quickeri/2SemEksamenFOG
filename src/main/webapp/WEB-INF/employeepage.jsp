<%-- 
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
    Author     : kasper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../includes/employeemenu.jsp" %>
        <script>
            $('.item-link').click(function(){
                $('.item-link').removeClass('active');   
                $(this).addClass('active');  
            });
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee home page</title>
    </head>
    <body>
        <div class="container">
        <h2>Hej <%=session.getAttribute("email")%> </h2>
        Du er nu logget ind som admin
        </div>
        
    </body>
</html>
