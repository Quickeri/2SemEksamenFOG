<%@page import="FunctionLayer.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.Order"%>
<%@page import="FunctionLayer.LogicFacade"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="../includes/fogmenu.jsp" %>
        
        
        <h1>All your placed orders</h1>
        <p>Below you can see all your orders<br> 
        </p>
        <%User user = (User) session.getAttribute("user");%> 
        <% ArrayList<Order> order = LogicFacade.getOrders(user.getId()); %>
        <div class="orderTable2">   
            <table class="table">
                <tr>
                    <th>Order ID</th>
                    <th>Carport ID</th>
                    <th>Højde</th>
                    <th>Længde</th>
                    <th>Bredde</th>
                </tr>
                
                 <%
                for(Order o : order)
                { %>
                    <tr>
                    <td> <%= o.getOrderid() %> </td>
                    <td> <%= o.getCarportid() %> </td>
                    <td> <%= o.getHeight() %> </td>
                    <td> <%= o.getLength() %> </td>
                    <td> <%= o.getWidth() %> </td>
                    
                </tr> 
                <% } %>
            </table>
        </div>
    </body>
</html>
