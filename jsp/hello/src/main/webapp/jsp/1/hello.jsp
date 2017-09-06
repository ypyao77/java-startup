<%--
  Created by IntelliJ IDEA.
  User: yunping.yao
  Date: 2017/9/6
  Time: 8:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>第一个 JSP 程序</title>
</head>
<body>
<h3>这是标题</h3>
<%
    for (int i = 0; i < 10; i ++) {
        out.println("Hello World！\n");
    }
    for (int i = 0; i < 10; i ++) {
        out.println("Hello World！<br>");
    }
%>
</body>
</html>
