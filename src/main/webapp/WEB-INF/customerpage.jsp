
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer home page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script> 
        $(document).ready(function(){
            $("#custpage").addClass('active');
        });
       </script> 
    </head>
    <body>
        <%@include file="../includes/customermenu.jsp" %> 
        <div class="container">
        <h2>Hej <%=session.getAttribute("email")%> </h2>
        Du er nu logget ind som kunde
        </div>
    </body>
</html>
