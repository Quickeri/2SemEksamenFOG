<%-- 
    Document   : vieworder
    Created on : May 1, 2018, 2:25:01 PM
    Author     : Jesper Outzen
--%>

<%@page import="FunctionLayer.Item"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.Order"%>
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
        <% Order o = (Order) request.getAttribute("order"); %>
        <% List<Item> stykliste = (ArrayList<Item>) request.getAttribute("stykliste"); %>
 
        <div class="container">   
            <h2>Se Ordre</h2>
            <table class="table">
                <tr>
                    <th>Order ID</th>
                    <th>Kunde ID</th>
                    <th>Længde</th>
                    <th>Bredde</th>
                    <th>Højde</th>
                    <th>Dato</th>
                </tr>   
                <tr>
                    <td> <%= o.getOrderid() %> </td>  
                    <td> <%= o.getCustomerid() %> </td>  
                    <td> <%= o.getLength() %>cm </td>
                    <td> <%= o.getWidth() %>cm </td>  
                    <td> <%= o.getHeight() %>cm </td>
                    <td> <%= o.getDate() %> </td>  
                </tr> 
            </table>              
        </div>
                
        <div class="container">
            <h2>Stykliste</h2>
            <table class="table">
                <tr>
                    <th>Navn</th>
                    <th>Længde</th>
                    <th>Antal</th>
                    <th>Enhed</th>
                    <th>Beskrivelse</th>
                </tr>  
                <% for (Item s : stykliste) {%>
                <tr>
                    <td> <%= s.getName() %>  </td>   
                    <td> <%= s.getLength() %> </td>  
                    <td> <%= s.getAmount() %> </td>  
                    <td> <%= s.getUnit() %>  </td>  
                    <td> <%= s.getDescription() %> </td>   
                </tr> 
                <% }%>
            </table>              
        </div>
            
        <div class="container">            
        <h2>Opdater Ordre</h2>            
        <form name="updateorder" action="FrontController" method="POST">
                <input type="hidden" name="command" value="updateorder">
                <input type="hidden" name="orderid" value="<%= o.getOrderid() %>">
            <div class="form-group">
                <label for="length">Længde:</label>
                <input type="number" name="length" id="length" class="form-control" value="<%= o.getLength() %>" required>
            </div> 
            <div class="form-group">
                <label for="width">Bredde:</label>
                <input type="number" name="width" id="width" class="form-control" value="<%= o.getWidth() %>" required>
            </div> 
            <div class="form-group">
                <label for="height">Højde:</label>
                <input type="number" name="height" id="height" class="form-control" value="<%= o.getHeight() %>" required>
            </div> 
            <div class="form-group">
                <button type="submit" class="btn btn-default">Opdater Ordre</button>
            </div> 
        </form>
        </div>
        
        <div class="container">
        <h2>Slet Ordre</h2>      
        <form name="deleteorder" action="FrontController" method="POST">
            <input type="hidden" name="command" value="deleteorder">
            <input type="hidden" name="orderid" value="<%= o.getOrderid() %>">
            <!--<input type="submit" value="Slet Ordre" onclick="return confirm('Vil du slette denne ordre?')">-->
            <button type="submit" class="btn btn-default" onclick="return confirm('Vil du slette denne ordre?')">
                <span class="glyphicon glyphicon-trash"></span>Slet Ordre
            </button>
        </form>
            <a href="FrontController?command=vieworders&page=1&orderby=orderid">Tilbage</a> 
        </div>
            
    </body>
</html>
