<%-- 
    Document   : ordercarportpage
    Created on : 25-04-2018, 11:59:17
    Author     : alber
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
        <h1>Byg-selv carport</h1>
        <p onclick="carportType1()">Carport Type 1: click på denne carport for at få en carport med målene 600cm x 300cm x 250cm.</p>
        <p onclick="carportType2()">Carport Type 2: click på denne carport for at få en carport med målene 700cm x 400cm x 250cm.</p>
        <p onclick="carportType3()">Carport Type 3: click på denne carport for at få en carport med målene 500cm x 300cm x 250cm.</p>
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
            <input type="number" name="length" value="" id="length">
            <br>
            Bredde:<br>
            <input type="number" name="width" value="" id="width">
            <br>
            Højde:<br>
            <input type="number" name="height" value="" id="height">
            <br>
            <input type="submit" value="Submit">
            
        </form>
        <% if (request.getAttribute("order") != null) {
                Order order = (Order) request.getAttribute("order");
        %>

        <h4> Her vises en simpel skitse af carporten set ovenfra</h4>

        <SVG width="<%= order.getWidth() + 200%>" height="<%= order.getLength() + 200%>">
        <rect x="100" y="10" height="<%= order.getLength()%>" width="<%= order.getWidth()%>"
              style="stroke:#000000; stroke-width: 4; fill: #F5F5DC"/>
        </SVG>

        <% }%>

    </body>
</html>
