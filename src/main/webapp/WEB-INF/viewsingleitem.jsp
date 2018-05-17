<%-- 
    Document   : viewsingleitem
    Created on : 10-05-2018, 12:47:20
    Author     : Mads
--%>

<%@page import="FunctionLayer.Item"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%@include file="../includes/employeemenu.jsp" %>
        <% Item i = (Item) request.getAttribute("item"); %>
        
        <div class="container">
        <h2>Opdater Item</h2>            
        <form name="updateitem" action="FrontController" method="POST">
                <input type="hidden" name="command" value="updateitem">
                <input type="hidden" name="itemid" value="<%= i.getItemid() %>">
            <div class="form-group">
                <label for="name">Navn:</label>
                <input type="text" name="name" id="name" class="form-control" value="<%= i.getName() %>" required>
            </div> 
            <div class="form-group">
                <label for="unit">Enhed:</label>
                <input type="text" name="unit" id="unit" class="form-control" value="<%= i.getUnit() %>" required>
            </div> 
            <div class="form-group">
                <label for="price">Pris:</label>
                <input type="number" name="price" id="price" class="form-control" value="<%= i.getPrice() %>" required>
            </div> 
            <div class="form-group">
                <label for="descr">Beskrivelse:</label>
                <input type="text" name="description" id="descr" class="form-control" value="<%= i.getDescription() %>" required>
            </div> 
            <div class="form-group">
                <button type="submit" class="btn btn-default">Opdater Item</button>
            </div> 
        </form>
            <a href="FrontController?command=viewitems&page=1&orderby=itemid">Tilbage</a> 
        </div>    
         
    </body>
</html>
