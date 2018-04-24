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
    <body>
        <% List<Order> orders = (ArrayList<Order>) request.getAttribute("list");%>
        <h1>View Orders</h1>
        
        <div id="orderTable">   
            <table class="table">
                <tr>
                    <th>Order ID</th>
                    <th>User ID</th>
                    <th>Length</th>
                    <th>Width</th>
                    <th>Height</th>
                </tr>
                
                 <%
                for(Order o : orders)
                { %>
                    <tr>
                    <td> <%= o.getOrderid() %> </td>  
                    <td> <%= o.getUserid() %> </td>  
                    <td> <%= o.getLength() %> </td>
                    <td> <%= o.getWidth() %> </td>  
                    <td> <%= o.getHeight() %> </td>                                   
                </tr> 
                <% } %>
            </table>              
        </div>
         <a href="FrontController?command=rolepage">Back</a> 
    </body>
</html>
