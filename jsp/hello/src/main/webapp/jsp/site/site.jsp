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

    <!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous"> -->

    <link href="../../assets/css/docs.min.css" rel="stylesheet">
    <link href="../../assets/css/patch.css" rel="stylesheet">

    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>

    <script src="../../lib/js/jquery-3.2.1.js"></script>
    <script src="../../bootstrap-3.3.7-dist/js/bootstrap.js"></script>

    <!--
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
    -->
    <!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script> -->
</head>

<body>

<script>
    function direct2(url) {
        $("#myContent").load(url);
    }
</script>
<script>
    $(document).ready(function(){
        $(".nav a").on("click", function(){
            $(".nav").find(".active").removeClass("active");
            $(this).parent().addClass("active");

            var myUrl = $(this).data("dest");
            $("#myContent").load(myUrl);
        });

        $("#main-nav li:first a").click();
    });
</script>

<div class="container">
    <div class="row">
        <div class="col-xs-12">
            <nav class="navbar navbar-inverse" role="navigation">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="javascript:void(0);">菜鸟教程</a>
                    </div>
                    <div id="main-nav" class="collapse navbar-collapse" id="example-navbar-collapse">
                        <ul class="nav navbar-nav">
                            <li><a href="javascript:void(0);" data-dest="p1.jsp">导航1</a></li>
                            <li><a href="javascript:void(0);" data-dest="p2.jsp">导航2</a></li>
                            <li><a href="javascript:void(0);" data-dest="p3.jsp">导航3</a></li>
                            <li><a href="javascript:void(0);" data-dest="p4.jsp">导航4</a></li>
                            <!--
                            <li><a href="javascript:void(0);" onclick="direct2('p1.jsp')">导航1</a></li>
                            <li><a href="javascript:void(0);" onclick="direct2('p2.jsp')">导航2</a></li>
                            <li><a href="javascript:void(0);" onclick="direct2('p3.jsp')">导航3</a></li>
                            <li><a href="javascript:void(0);" onclick="direct2('p4.jsp')">导航4</a></li>
                            -->
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
    </div>

    <div class="row">
        <div class="col-xs-12">
            <div id="myContent" />
        </div>
    </div>
</div>

</body>
</html>
