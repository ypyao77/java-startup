<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<html>
<head><title>Hello World</title></head>
<body>
Hello World!<br/>
<%
    out.println("Your IP 地址 is " + request.getRemoteAddr());
%>
</body>
</html>