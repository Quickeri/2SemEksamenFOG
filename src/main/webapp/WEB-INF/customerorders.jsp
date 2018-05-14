<%@page import="java.util.List"%>
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
        <%@include file="../includes/customermenu.jsp" %>
        
        <% List<Order> orders = (ArrayList<Order>) request.getAttribute("list");%>
        <div class="container">
            <h2>Her kan du se dine ordrer</h2>
            <table class="table">
                <tr>
                    <th>Order ID</th>
                    <th>Højde</th>
                    <th>Længde</th>
                    <th>Bredde</th>
                    <th>Dato</th>
                </tr>
                
                 <%
                for(Order o : orders)
                { %>
                    <tr>
                    <td> <%= o.getOrderid() %> </td>
                    <td> <%= o.getHeight() %>cm </td>
                    <td> <%= o.getLength() %>cm </td>
                    <td> <%= o.getWidth() %>cm </td>
                    <td> <%= o.getDate() %> </td>
                    
                </tr> 
                <% } %>
            </table>
        </div>
    </body>
</html>
