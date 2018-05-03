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
        <%@include file="../includes/fogmenu.jsp" %>
        
        <h1>Her kan du se dine ordre</h1>
        <% List<Order> orders = (ArrayList<Order>) request.getAttribute("list");%>
        <div class="orderTable2">   
            <table class="table">
                <tr>
                    <th>Order ID</th>
                    <th>Højde</th>
                    <th>Længde</th>
                    <th>Bredde</th>
                </tr>
                
                 <%
                for(Order o : orders)
                { %>
                    <tr>
                    <td> <%= o.getOrderid() %> </td>
                    <td> <%= o.getHeight() %>cm </td>
                    <td> <%= o.getLength() %>cm </td>
                    <td> <%= o.getWidth() %>cm </td>
                    
                </tr> 
                <% } %>
            </table>
        </div>
    </body>
</html>
