<%-- 
    Document   : vieworders
    Created on : 24-04-2018, 10:50:32
    Author     : Mads
--%>

<%@page import="FunctionLayer.Order"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Orders</title>
    </head>
        <%@include file="../includes/fogmenu.jsp" %>
    
        <% List<Order> orders = (ArrayList<Order>) request.getAttribute("list");%>
        <h1>View Orders</h1>

        <form action="FrontController" method="post" id="formSearch">
            <input type="hidden" name="command" value="searchorder">
            <input type="number" name="orderid" placeholder="orderid" required>
            <input type="submit" value="SEARCH ORDER" class="button">
        </form>
        
        <div id="orderTable">   
            <table class="table">
                <tr>
                    <th>Order ID</th>
                    <th>Customer name</th>
                    <th>Customer email</th>
                    <th>Carport ID</th>
                    <th>Length</th>
                    <th>Width</th>
                    <th>Height</th>
                    <th>Customer ID</th>
                </tr>

                <%
                     for (Order o : orders) {%>
                <tr>
                    <td> <%= o.getOrderid()%> </td>  
                    <td> <%= o.getName()%> </td>  
                    <td> <%= o.getEmail()%> </td>  
                    <td> <%= o.getCarportid()%> </td>  
                    <td> <%= o.getLength()%> </td>
                    <td> <%= o.getWidth()%> </td>  
                    <td> <%= o.getHeight()%> </td>                                   
                    <td> <%= o.getCustomerid()%> </td>
                </tr> 
                <% }%>
            </table>              
        </div>
        <a href="FrontController?command=viewsingleorder">view single order</a> 
    </body>
</html>
