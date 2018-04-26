<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
    *{
        box-sizing: border-box;
    }
    body {
        margin: 0;
    }
    .topMenu{
        overflow: hidden;
        background-color: darkgray;
    }
    .topMenu a {
        float: left;
        display: block;
        color: #f1f1f1;
        text-align: center;
        padding: 27px 27px;
        text-decoration: none;
    }
    .topMenu a:hover{
        background-color: #555;
        color: darkgray;
    }
    .button {
        float: left;
        display: block;
        color: #f1f1f1;
        padding: 14px 14px;
    }
</style>
<%if(session.getAttribute("id")== null)
{%>
<div class="topMenu">
    <a href="index.jsp" class="navbar-left"><img src="https://d3ikkoqs9ddhdl.cloudfront.net/img/logo/pageflip/6d77Ug_6fhnjpi14.png"></a>
</div>
<%}else if(session.getAttribute("role").equals("employee")){%>
    <div class="topMenu">
    <a href="FrontController?command=rolepage" class="navbar-left"><img src="https://d3ikkoqs9ddhdl.cloudfront.net/img/logo/pageflip/6d77Ug_6fhnjpi14.png"></a>
    <a href="FrontController?command=vieworders" class="button">Manage Customer Orders</a>
    <a href="FrontController?command=logout"> <span class="glyphicon glyphicon-log-out" name="icon"> </span> Log out</button></a>
    
</div>
<%}else{%>
<div class="topMenu">
    <a href="FrontController?command=rolepage" class="navbar-left"><img src="https://d3ikkoqs9ddhdl.cloudfront.net/img/logo/pageflip/6d77Ug_6fhnjpi14.png"></a>
    <a href="FrontController?command=createorder" class="button">Bestil en carport</a>
    <a href="FrontController?command=logout"> <span class="glyphicon glyphicon-log-out" name ="icon"> </span> Log out</button></a>
</div>
<%}%>




