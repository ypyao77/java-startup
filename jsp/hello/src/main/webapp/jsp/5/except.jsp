<%@ page language="java" contentType="text/html; charset=UTF-8" errorPage="/index.jsp" pageEncoding="UTF-8"%>
<%! int day = 3; %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>菜鸟教程(runoob.com)</title>
</head>
<body>
<h3>except 实例</h3>
<p>
    <% out.println("value=" + (2/0)); %>
</p>
</body>
</html>
