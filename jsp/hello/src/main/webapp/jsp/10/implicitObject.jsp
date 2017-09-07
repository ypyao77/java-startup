<%--
  Created by IntelliJ IDEA.
  User: yaoyp
  Date: 2017/9/7
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test implicit object</title>
</head>
<body>
<%
    out.println(page.toString() + "<br>");
    if (session.getAttribute("aa") == null || session.getAttribute("aa").equals("")) {
        session.setAttribute("aa", "Student");
    } else {
        session.setAttribute("aa", "Student again");
    }
    out.println("session = " + session.getAttribute("aa") + "<br>");
%>
</body>
</html>
