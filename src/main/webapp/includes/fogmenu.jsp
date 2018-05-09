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
        background-color: #15317b;
    }
    .topMenu a {
        float: left;
        display: block;
        color: #f1f1f1;
        text-align: center;
        padding: 20px 20px;
        text-decoration: none;
        transition-duration: 0.3s;
    }
    .topMenu a:hover{
        background-color: #0b1c5c;
        color: #4c77b1;
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
    <a href="FrontController?command=vieworders" class="button">Kundeordrer</a>
    <a href="FrontController?command=gotoupdateuser" class="button">Opdater Bruger</a>
    <a href="FrontController?command=logout"> <span class="glyphicon glyphicon-log-out" name="icon"> </span> Log ud</a>
    
</div>
<%}else{%>
<div class="topMenu">
    <a href="FrontController?command=rolepage" class="navbar-left"><img src="https://d3ikkoqs9ddhdl.cloudfront.net/img/logo/pageflip/6d77Ug_6fhnjpi14.png"></a>
    <a href="FrontController?command=gotoupdateuser" class="button">Opdater Bruger</a>
    <a href="FrontController?command=ordercarportpage" class="button">Bestil Carport</a>
    <a href="FrontController?command=customerorders" class="button">Se dine bestilte carporte</a>
    <a href="FrontController?command=logout"> <span class="glyphicon glyphicon-log-out" name ="icon"> </span> Log ud</a>

</div>
<%}%>




