
<%@page import="FunctionLayer.SVGUtil"%>
<%@page import="FunctionLayer.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Draw Carport</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script>
            $(document).ready(function () {
                $("#ordercarport").addClass('active');
            });
        </script> 
    </head>
    <body>
        <%@include file="../includes/customermenu.jsp" %>
        <h2>Sådan ser din carport ud</h2>
        
        <% if (request.getAttribute("order") != null) {
                Order order = (Order) request.getAttribute("order");
                SVGUtil draw = new SVGUtil();
        %>
       
        <table>
            <tr>
                <td>    
                    <h4> Carporten set ovenfra</h4>
                    
                    <SVG width="<%= order.getWidth() + 300%>" height="<%= order.getLength() + 300%>">
                    <rect x="50" y="<%= draw.sideRemnant(order, "roof") + 50%>" 
                          height="<%= order.getLength()%>" width="<%= order.getWidth()%>"
                          style="stroke:#000000; stroke-width: 4; fill: #F5F5DC"/>
                    
                    <%= draw.carport(order, "roof")%>
                    
                    <line x1="50" y1="<%= draw.sideRemnant(order, "roof") + 50%>" 
                          x2="<%= order.getWidth() + 50%>" y2="<%=order.getLength() + draw.sideRemnant(order, "roof") + 50%>" 
                          style="stroke:rgb(255,0,0);stroke-width:2" />
                    
                    <line x1="50" y1="<%=order.getLength() + draw.sideRemnant(order, "roof") + 50%>" 
                          x2="<%=order.getWidth() + 50%>" y2="<%= draw.sideRemnant(order, "roof") + 50%>" 
                          style="stroke:rgb(255,0,0);stroke-width:2" />
                    
                    <line x1="25" y1="<%=draw.sideRemnant(order, "roof") + 50 %>" x2="25" 
                          y2="<%=order.getLength() + draw.sideRemnant(order, "roof") + 50%>" 
                          style="stroke:rgb(255,0,0);stroke-width:2" />
                    
                    <text x="25" y="<%=order.getLength()/2 + draw.sideRemnant(order, "roof") + 50%>"
                          font-family= "Verdana" font-size="12px"
                          text-anchor= "middle" alignment-baseline=\"middle\">
                    <%= order.getLength() + " cm"%>
                    </text>
                    
                    <line x1="<%= order.getWidth() + 50%>" y1="<%= order.getLength() + draw.sideRemnant(order, "roof") + 70 %>" 
                          x2="50" y2="<%= order.getLength() +  draw.sideRemnant(order, "roof") + 70%>" style="stroke:rgb(255,0,0);stroke-width:2" />
                    
                    <text x="<%=(order.getWidth())/2 + 50%>" y="<%=order.getLength() +  draw.sideRemnant(order, "roof") + 85%>"
                          font-family= "Verdana" font-size="12px"
                          text-anchor= "middle" alignment-baseline=\"middle\">
                    <%= order.getWidth() + " cm"%>
                    </text>
                    
                    </SVG>    
                </td>
                <td>
                    <h4> Carporten set forfra</h4>

                    <SVG width="<%= order.getWidth() + 300%>" height="<%= order.getHeight() + 300%>">
                    <rect x="<%= draw.sideRemnant(order, "front") + 50%>" y="70" height="<%= order.getHeight()%>" width="<%= order.getWidth()%>"
                          style="stroke:#000000; stroke-width: 4; fill: #F5F5DC"/>
                    <%= draw.carport(order, "front")%>
                    </SVG>
                </td>
                <td>
                    <h4> Carporten set fra siden</h4>

                    <SVG width="<%= order.getLength() + 300%>" height="<%= order.getHeight() + 300%>">
                    <rect x="<%= draw.sideRemnant(order, "side") + 50%>" y="70" height="<%= order.getHeight()%>" width="<%= order.getLength()%>"
                          style="stroke:#000000; stroke-width: 4; fill: #F5F5DC"/>
                    <%= draw.carport(order, "side")%>
                    </SVG>
                </td>
            </tr>
        </table>
        <p> antal spær til tag: <%= draw.getPartQuantity("roof")%></p>
        <p> antal stolper til front: <%= draw.getPartQuantity("front")%></p>
        <p> antal stolper til side: <%= draw.getPartQuantity("side")%></p>
        <p> Bemærk at bagside side og front i alt deler 4 stolper, disse tal indikerer kun, hvor mange stopler/spær der er på hver tegning</p>
        <% }%>
        
        <a href="FrontController?command=ordercarportpage">Tilbage</a>
    </body>
</html>
