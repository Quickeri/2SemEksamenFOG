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
        <%@include file="../includes/employeemenu.jsp" %>
 
        <div class="container">
        <h2>Opdater Bruger</h2>
        <form name="updateuser" action="FrontController" method="POST">
                <input type="hidden" name="command" value="updateuser">     
                <input type="hidden" name="userid" value="<%=session.getAttribute("id")%>">         
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="text" name="email" id="email" class="form-control" value="<%=session.getAttribute("email")%>" required>
            </div>
            <div class="form-group">
                <label for="pass">Password:</label>
                <input type="password" name="password" id="pass" class="form-control" required>
            </div>
            <div class="form-group"> 
                <button type="submit" class="btn btn-default">Opdater Bruger</button>
            </div>
        </form>
        </div>
            
    </body>
</html>
