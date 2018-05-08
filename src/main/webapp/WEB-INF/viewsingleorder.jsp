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
    </head>
    <body>
        <%@include file="../includes/fogmenu.jsp" %>
        <% Order o = (Order) request.getAttribute("order"); %>
        <% List<Item> stykliste = (ArrayList<Item>) request.getAttribute("stykliste"); %>
        <h1>Se Ordre</h1>
        <div id="orderTable">   
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
        <h1>Stykliste</h1>
        <div id="styklisteTable">   
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
                    
        <h1>Opdater Ordre</h1>            
        <form name="updateorder" action="FrontController" method="POST">
            <input type="hidden" name="command" value="updateorder">
            <input type="hidden" name="orderid" value="<%= o.getOrderid() %>">
            Længde:<br>
            <input type="number" name="length" value="<%= o.getLength() %>" required>
            <br>
            Bredde:<br>
            <input type="number" name="width" value="<%= o.getWidth() %>" required>
            <br>
            Højde:<br>
            <input type="number" name="height" value="<%= o.getHeight() %>" required>
            <br>
            <input type="submit" value="Opdater Ordre">   
        </form>
            
        <h1>Slet Ordre</h1>      
        <form name="deleteorder" action="FrontController" method="POST">
            <input type="hidden" name="command" value="deleteorder">
            <input type="hidden" name="orderid" value="<%= o.getOrderid() %>">
            <input type="submit" value="Slet Ordre" onclick="return confirm('Vil du slette denne ordre?')">   
        </form>
            
        <a href="FrontController?command=vieworders">Tilbage</a> 
    </body>
</html>
