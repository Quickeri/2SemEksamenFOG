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
        <h1>Se Ordre</h1>

        <form action="FrontController" method="post" id="formSearch">
            <input type="hidden" name="command" value="searchorder">
            <input type="number" name="orderid" placeholder="orderid" required>
            <input type="submit" value="Søg Ordre">
        </form>
        ${searchError}
        <div id="orderTable">   
            <table class="table">
                <tr>
                    <th>Order ID</th>
                    <th>Kunde ID</th>
                    <th>Navn</th>
                    <th>Email</th>
                    <th>Længde</th>
                    <th>Bredde</th>
                    <th>Højde</th>       
                    <th>Dato</th>   
                </tr>

                <% for (Order o : orders) {%>
                <tr>
                    <td> <a href="FrontController?command=searchorder&orderid=<%= o.getOrderid()%>"> <%= o.getOrderid()%> </a> </td>  
                    <td> <%= o.getCustomerid()%> </td>
                    <td> <%= o.getName()%> </td>  
                    <td> <a href="mailto:<%= o.getEmail()%>"> <%= o.getEmail()%> </a> </td>   
                    <td> <%= o.getLength()%>cm </td>
                    <td> <%= o.getWidth()%>cm </td>  
                    <td> <%= o.getHeight()%>cm </td>     
                    <td> <%= o.getDate()%> </td>  
                </tr> 
                <% }%>
            </table>              
        </div>
    </body>
</html>
