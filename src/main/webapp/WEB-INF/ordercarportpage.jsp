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
        <%@include file="../includes/customermenu.jsp" %>
        <div class="container">
        <h2>Vælg Carport</h2>
            <p>Carport Type 1: 600cm x 300cm x 250cm.</p>
            <button type="button" class="btn btn-default" onclick="carportType1()">Carport Type 1</button>
            <p>Carport Type 2: 700cm x 400cm x 250cm.</p>
            <button type="button" class="btn btn-default" onclick="carportType2()">Carport Type 2</button>
            <p>Carport Type 3: 500cm x 300cm x 250cm.</p>
            <button type="button" class="btn btn-default" onclick="carportType3()">Carport Type 3</button>
        </div>
        
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
        
        <div class="container">
        <h2> Indtast mål på carport </h2>
            <form name="createorder" action="FrontController" method="POST">
                    <input type="hidden" name="command" value="createorder">
                <div class="form-group">
                    <label for="length">Length:</label>
                    <input type="number" name="length" id="length" class="form-control" required>
                </div>
                <div class="form-group">
                    <label for="width">Width:</label>
                    <input type="number" name="width" id="width" class="form-control" required>
                </div>
                <div class="form-group">
                    <label for="height">Height:</label>
                    <input type="number" name="height" id="height" class="form-control" required>
                </div>
                <div class="form-group">
                     <button type="submit" class="btn btn-default">Bestil</button>
                </div>
        </form>
        </div>
        <% if (request.getAttribute("order") != null) {
                Order order = (Order) request.getAttribute("order");
                SVGUtil draw = new SVGUtil();
        %>
        <table>
    <tr>
        <td>    
            <h4> Carporten set ovenfra</h4>

            <SVG width="<%= order.getWidth() + 300%>" height="<%= order.getLength() + 300%>">
            <rect x="0" y="<%= draw.sideRemnant(order,"roof") %>" height="<%= order.getLength()%>" width="<%= order.getWidth()%>"
                  style="stroke:#000000; stroke-width: 4; fill: #F5F5DC"/>
            <%= draw.carport(order, "roof") %>
            </SVG>
        </td>
        <td>
            <h4> Carporten set forfra</h4>

            <SVG width="<%= order.getWidth() + 300%>" height="<%= order.getHeight() + 300%>">
            <rect x="<%= draw.sideRemnant(order,"front") %>" y="0" height="<%= order.getHeight()%>" width="<%= order.getWidth()%>"
                  style="stroke:#000000; stroke-width: 4; fill: #F5F5DC"/>
            <%= draw.carport(order, "front") %>
            </SVG>
        </td>
        <td>
            <h4> Carporten set fra siden</h4>

            <SVG width="<%= order.getLength() + 300%>" height="<%= order.getHeight() + 300%>">
            <rect x="<%=draw.sideRemnant(order, "side")%>" y="0" height="<%= order.getHeight()%>" width="<%= order.getLength()%>"
                  style="stroke:#000000; stroke-width: 4; fill: #F5F5DC"/>
            <%= draw.carport(order, "side") %>
            </SVG>
        </td>
    </tr>    
        </table>
            <p> antal spær til tag: <%= draw.getPartQuantity("roof")%></p>
            <p> antal stolper til front: <%= draw.getPartQuantity("front")%></p>
            <p> antal stolper til side: <%= draw.getPartQuantity("side")%></p>
            <p> Bemærk at bagside side og front i alt deler 4 stolper, disse tal indikerer kun, hvor mange stopler/spær der er på hver tegning</p>
        <% }%>

    </body>
</html>
