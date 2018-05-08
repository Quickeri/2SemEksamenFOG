<%-- 
    Document   : ordercarportpage
    Created on : 25-04-2018, 11:59:17
    Author     : alber
--%>

<%@page import="FunctionLayer.SVGUtil"%>
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
        <h1>Byg-selv carport</h1>
        <p>Carport Type 1: 600cm x 300cm x 250cm.</p>
        <button type="button" onclick="carportType1()">Carport Type 1</button>
        <p>Carport Type 2: 700cm x 400cm x 250cm.</p>
        <button type="button" onclick="carportType2()">Carport Type 2</button>
        <p>Carport Type 3: 500cm x 300cm x 250cm.</p>
        <button type="button" onclick="carportType3()">Carport Type 3</button>
        <script>
            function carportType1() {
                document.getElementById("length").value = "600";
                document.getElementById("width").value = "300";
                document.getElementById("height").value = "250";
            }
            function carportType2() {
                document.getElementById("length").value = "700";
                document.getElementById("width").value = "400";
                document.getElementById("height").value = "250";
            }
            function carportType3() {
                document.getElementById("length").value = "500";
                document.getElementById("width").value = "300";
                document.getElementById("height").value = "250";
            }
        </script>
        <H2> Indtast mål på carport </H2>
        
        <form name="createorder" action="FrontController" method="POST">
            <input type="hidden" name="command" value="createorder">
            Længde:<br>
            <input type="number" name="length" value="" id="length" required>
            <br>
            Bredde:<br>
            <input type="number" name="width" value="" id="width" required>
            <br>
            Højde:<br>
            <input type="number" name="height" value="" id="height" required>
            <br>
            <input type="submit" value="Bestil">
            
        </form>
        <% if (request.getAttribute("order") != null) {
                Order order = (Order) request.getAttribute("order");
                SVGUtil draw = new SVGUtil();
        %>
        <table>
    <tr>
        <td>    
            <h4> Carporten set ovenfra</h4>

            <SVG width="<%= order.getWidth() + 200%>" height="<%= order.getLength() + 200%>">
            <%= draw.carport(order, "roof") %>
            </SVG>
        </td>
        <td>
            <h4> Carporten set forfra</h4>

            <SVG width="<%= order.getWidth() + 200%>" height="<%= order.getHeight() + 200%>">
            <%= draw.carport(order, "front") %>
            </SVG>
        </td>
        <td>
            <h4> Carporten set fra siden</h4>

            <SVG width="<%= order.getLength() + 200%>" height="<%= order.getHeight() + 200%>">
            <%= draw.carport(order, "side") %>
            </SVG>
        </td>
    </tr>    
        </table>

            <rect x="100" y="10" height="<%= order.getLength()%>" width="<%= order.getWidth()%>"
                  style="stroke:#000000; stroke-width: 4; fill: #F5F5DC"/>
            <rect x="100" y="10" height="<%= order.getHeight()%>" width="<%= order.getWidth()%>"
                  style="stroke:#000000; stroke-width: 4; fill: #F5F5DC"/>
            <rect x="100" y="10" height="<%= order.getHeight()%>" width="<%= order.getLength()%>"
                  style="stroke:#000000; stroke-width: 4; fill: #F5F5DC"/>
        <% }%>

    </body>
</html>
