<%-- 
    Document   : updatecustomer
    Created on : 13-05-2018, 20:09:24
    Author     : Mads
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update User</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script> 
        $(document).ready(function(){
            $("#updatecust").addClass('active');
            if(${userupdated == "success"}){
                $("#updatealert").removeClass('hidden');
            }
        });
       </script> 
    </head>
    <body>
        <%@include file="../includes/customermenu.jsp" %>
 
        <div class="container">
        <h2>Opdater Bruger</h2>
        <form name="updateuser" action="FrontController" method="POST">
                <input type="hidden" name="command" value="updateuser">     
                <input type="hidden" name="userid" value="<%=session.getAttribute("id")%>">         
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="text" name="email" id="email" class="form-control" value="<%=session.getAttribute("email")%>" maxlength="40" required>
            </div>
            <div class="form-group">
                <label for="pass">Password:</label>
                <input type="password" name="password" id="pass" class="form-control" minlength="4" maxlength="16" required>
            </div>
            <div class="form-group"> 
                <button type="submit" class="btn btn-default">Opdater Bruger</button>
            </div>
        </form>
            <div class="alert alert-success hidden" id="updatealert">
                <button class="close" data-dismiss="alert" aria-label="close">&times;</button>
                <strong>Success!</strong> Brugeren er blevet opdateret
            </div>
        </div>
            
    </body>
</html>
