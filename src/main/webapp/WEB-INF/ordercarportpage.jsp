
<%@page import="FunctionLayer.SVGUtil"%>
<%@page import="FunctionLayer.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                    <label for="length">Længde:</label>
                    <input type="number" name="length" id="length" class="form-control" min="350" max="700" required>
                </div>
                <div class="form-group">
                    <label for="width">Bredde:</label>
                    <input type="number" name="width" id="width" class="form-control" min="300" max="800" required>
                </div>
                <div class="form-group">
                    <label for="height">Højde:</label>
                    <input type="number" name="height" id="height" class="form-control" min="250" max="300" required>
                </div>
                <div class="form-group">
                    <label for="skur">Redskabsskur:</label>
                    <select name="skur" id="skur" class="form-control">
                        <option value="yes">Ja</option>
                        <option value="no">Nej</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="textarea">Bemærkninger:</label>
                    <textarea name="textarea" id="textarea" class="form-control" rows="5" maxlength="100"></textarea>
                </div>
                <div class="form-group">
                     <button type="submit" class="btn btn-default" id="orderbutton">Bestil</button>
                </div>
            </form>
        </div>
    </body>
</html>
