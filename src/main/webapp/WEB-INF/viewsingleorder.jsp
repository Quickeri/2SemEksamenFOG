<%-- 
    Document   : vieworder
    Created on : May 1, 2018, 2:25:01 PM
    Author     : Jesper Outzen
--%>

<%@page import="FunctionLayer.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="../includes/fogmenu.jsp" %>
        <% Order o = (Order) request.getAttribute("order"); %>
        <h1>View single order!</h1>
        <div id="orderTable">   
            <table class="table">
                <tr>
                    <th>Order ID</th>
                    <th>User ID</th>
                    <th>Length</th>
                    <th>Width</th>
                    <th>Height</th>
                </tr>   
                <tr>
                    <td> <%= o.getOrderid() %> </td>  
                    <td> <%= o.getCustomerid() %> </td>  
                    <td> <%= o.getLength() %> </td>
                    <td> <%= o.getWidth() %> </td>  
                    <td> <%= o.getHeight() %> </td>                                   
                </tr> 
            </table>              
        </div>
        
        <form name="updateorder" action="FrontController" method="POST">
            <input type="hidden" name="command" value="updateorder">
            <input type="hidden" name="orderid" value="<%= o.getOrderid() %>">
            Længde:<br>
            <input type="number" name="length" value="<%= o.getLength() %>">
            <br>
            Bredde:<br>
            <input type="number" name="width" value="<%= o.getWidth() %>">
            <br>
            Højde:<br>
            <input type="number" name="height" value="<%= o.getHeight() %>">
            <br>
            <input type="submit" value="Submit">   
        </form>
            
        <form name="deleteorder" action="FrontController" method="POST">
            <input type="hidden" name="command" value="deleteorder">
            <input type="hidden" name="orderid" value="<%= o.getOrderid() %>">
            <input type="submit" value="Delete Order" onclick="return confirm('Are you sure you want to delete this order?')">   
        </form>
            
        <a href="FrontController?command=vieworders">back</a> 
    </body>
</html>
