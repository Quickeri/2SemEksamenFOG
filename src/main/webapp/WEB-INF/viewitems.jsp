<%-- 
    Document   : viewitems
    Created on : 10-05-2018, 12:32:05
    Author     : Mads
--%>

<%@page import="java.util.List"%>
<%@page import="FunctionLayer.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Items</title>
        
    </head>
    <body>
        <%@include file="../includes/employeemenu.jsp" %>
    
        <% List<Item> items = (ArrayList<Item>) request.getAttribute("list");%>
        <% int count = (int) request.getAttribute("count");%>
        <% int totalPages = (int) request.getAttribute("totalpages");%>
        <% int currentPage = (int) request.getAttribute("page");%>
        <% String orderby = (String) request.getParameter("orderby");%>
       
        <div class="container">
        <h2>Se Lager</h2>
        <form action="FrontController" method="post" id="formSearch">
            <input type="hidden" name="command" value="searchitem">
            <div class="form-group">
            <input type="number" name="orderid" class="form-control" placeholder="itemid" required>
            </div>
            <div class="form-group">
            <button type="submit" class="btn btn-default">
                <span class="glyphicon glyphicon-search"></span>Søg Item
            </button>
            </div>
        </form>
        </div>
        
        ${searchError}
        
        <div class="container">   
            <table class="table">
                <tr>
                    <th><a href="FrontController?command=viewitems&page=<%=currentPage%>&orderby=itemid">Item ID</a></th>
                    <th><a href="FrontController?command=viewitems&page=<%=currentPage%>&orderby=name">Navn</a></th>
                    <th><a href="FrontController?command=viewitems&page=<%=currentPage%>&orderby=unit">Enhed</a></th>
                    <th><a href="FrontController?command=viewitems&page=<%=currentPage%>&orderby=price">Pris</a></th>       
                    <th>Beskrivelse</th>   
                </tr>

                <% for (Item i : items) {%>
                <tr>
                    <td> <a href="FrontController?command=searchitem&itemid=<%= i.getItemid()%>"> <%= i.getItemid()%> </a> </td>  
                    <td> <%= i.getName()%> </td>   
                    <td> <%= i.getUnit()%> </td>
                    <td> <%= i.getPrice()%>kr. </td>  
                    <td> <%= i.getDescription()%> </td>     
                </tr> 
                <% }%>
            </table>    
            Total items: <%=count%>
            Page: <%=currentPage%> / <%=totalPages%>
        </div>
        
        <div class="container">
            <ul class="pagination">
                <li class="page-item"><a class="page-link" href="FrontController?command=viewitems&page=<%=currentPage - 1%>&orderby=<%=orderby%>">Previous</a>
                <% for (int i = 1; i < totalPages + 1; i++) {%>
                <li class="page-item"><a class="page-link" href="FrontController?command=viewitems&page=<%=i%>&orderby=<%=orderby%>"><%=i%></a>
                <% }%>
                <li class="page-item"><a class="page-link" href="FrontController?command=viewitems&page=<%=currentPage + 1%>&orderby=<%=orderby%>">Next</a> 
            </ul>  
        </div>
    </body>
</html>
