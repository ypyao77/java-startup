<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>JSP Demo</title>
    <!-- <link rel="stylesheet" type="text/css" href="../../bootstrap-3.3.7-dist/css/bootstrap-responsive.min.css"> -->
    <link rel="stylesheet" type="text/css" href="../../bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link href="../../bootstrap-3.3.7-dist/css/bootstrap-theme.min.css"
          data-href="../../bootstrap-3.3.7-dist/css/bootstrap-theme.min.css" rel="stylesheet" id="bs-theme-stylesheet">

    <link href="../../assets/css/docs.min.css" rel="stylesheet">
    <link href="../../assets/css/patch.css" rel="stylesheet">
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>

    <script src="../../lib/js/jquery-3.2.1.js"></script>
    <script src="../../bootstrap-3.3.7-dist/js/bootstrap.js"></script>
</head>

<body>
<div class="container">
    <%
        session.setAttribute("cuurentPage", "page2");
    %>
    <%@ include file="nav.jsp" %>

    <div class="row">
        <div class="col-xs-12">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Table heading</th>
                    <th>Table heading</th>
                    <th>Table heading</th>
                    <th>Table heading</th>
                    <th>Table heading</th>
                    <th>Table heading</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>Table cell1</td>
                    <td>Table cell2</td>
                    <td>Table cell3</td>
                    <td>Table cell4</td>
                    <td>Table cell5</td>
                    <td>Table cell6</td>
                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td>Table cell1</td>
                    <td>Table cell2</td>
                    <td>Table cell3</td>
                    <td>Table cell4</td>
                    <td>Table cell5</td>
                    <td>Table cell6</td>
                </tr>
                <tr>
                    <th scope="row">3</th>
                    <td>Table cell1</td>
                    <td>Table cell2</td>
                    <td>Table cell3</td>
                    <td>Table cell4</td>
                    <td>Table cell5</td>
                    <td>Table cell6</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
<br>

<br><br><br><br><br>
</body>
</html>
