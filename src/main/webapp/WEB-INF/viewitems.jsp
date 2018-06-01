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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script> 
        $(document).ready(function(){
            $("#viewitems").addClass('active'); 
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
            <input type="number" name="itemid" class="form-control" placeholder="itemid" min="1" max="1000" required>
            </div>
            <div class="form-group">
            <button type="submit" class="btn btn-default">
                <span class="glyphicon glyphicon-search"></span>Søg Item
            </button>
            </div>
        </form>
            <div class="alert alert-info hidden" id="searchalert">
                <button class="close" data-dismiss="alert" aria-label="close">&times;</button>
                <strong>Fejl!</strong> Intet item med dette itemnummer
            </div>
        </div>
        
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
            Items i alt: <%=count%>
        </div>
        
        <div class="container">
            <ul class="pagination">
                <li class="page-item" id="previous">
                    <a class="page-link" href="FrontController?command=viewitems&page=<%=currentPage - 1%>&orderby=<%=orderby%>">Forrige</a>
                </li>
                <% for (int i = 1; i < totalPages + 1; i++) {%>
                <li class="page-item" id="page<%=i%>">
                    <a class="page-link" href="FrontController?command=viewitems&page=<%=i%>&orderby=<%=orderby%>"><%=i%></a>
                </li>
                <% }%>
                <li class="page-item" id="next">
                    <a class="page-link" href="FrontController?command=viewitems&page=<%=currentPage + 1%>&orderby=<%=orderby%>">Næste</a>
                </li>
            </ul>  
        </div>
    </body>
</html>
