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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script> 
        $(document).ready(function(){
            $("#vieworders").addClass('active'); 
            var page = ${page};
            var total = ${totalpages};
            $("#page${param.page}").addClass('active'); 
            if(page <= 1){
            $("#previous").addClass('disabled'); 
            $('#previous').click(function(e){
                e.preventDefault();
            });
            }
            if(page >= total){
            $("#next").addClass('disabled');
            $('#next').click(function(e){
                e.preventDefault();
            });
            }
            if(${searcherror == "notfound"}){
                $("#searchalert").removeClass('hidden');
            }          
        });
       </script> 
    </head>
    <body>
        <%@include file="../includes/employeemenu.jsp" %>
        
        <% List<Order> orders = (ArrayList<Order>) request.getAttribute("list");%>
        <% int totalPages = (int) request.getAttribute("totalpages");%>
        <% int count = (int) request.getAttribute("count");%>
        <% int currentPage = (int) request.getAttribute("page");%>
        <% String orderby = (String) request.getParameter("orderby");%>
        
        <div class="container">
        <h2>Se Ordre</h2>
        <form action="FrontController" method="post" id="formSearch">
                <input type="hidden" name="command" value="searchorder">
            <div class="form-group">
                <input type="number" name="orderid" class="form-control" placeholder="orderid" min="1" max="1000" required>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-default">
                    <span class="glyphicon glyphicon-search"></span>Søg Ordre
                </button>
            </div>
        </form>
            <div class="alert alert-info hidden" id="searchalert">
                <button class="close" data-dismiss="alert" aria-label="close">&times;</button>
                <strong>Fejl!</strong> Ingen ordre med dette ordrenummer
            </div>
        </div>
  
        <div class="container">   
            <table class="table">
                <tr>
                    <th><a href="FrontController?command=vieworders&page=<%=currentPage%>&orderby=orderid">Order ID</a></th>
                    <th><a href="FrontController?command=vieworders&page=<%=currentPage%>&orderby=customerid">Kunde ID</a></th>
                    <th><a href="FrontController?command=vieworders&page=<%=currentPage%>&orderby=name">Navn</a></th>
                    <th>Email</th>
                    <th>Længde</th>
                    <th>Bredde</th>
                    <th>Højde</th>       
                    <th><a href="FrontController?command=vieworders&page=<%=currentPage%>&orderby=date">Dato</a></th> 
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
            Ordrer i alt: <%=count%>
        </div>
            
        <div class="container">
            <ul class="pagination">
                <li class="page-item" id="previous"><a class="page-link" href="FrontController?command=vieworders&page=${param.page - 1}&orderby=<%=orderby%>">Forrige</a></li>
                <% for (int i = 1; i < totalPages + 1; i++) {%>
                <li class="page-item" id="page<%=i%>"><a class="page-link" href="FrontController?command=vieworders&page=<%=i%>&orderby=<%=orderby%>"><%=i%></a></li>
                <% }%>
                <li class="page-item" id="next"><a class="page-link" href="FrontController?command=vieworders&page=${param.page + 1}&orderby=<%=orderby%>">Næste</a></li> 
            </ul>  
        </div>
       
    </body>
</html>
