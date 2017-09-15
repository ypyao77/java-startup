<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="row">
    <div class="col-xs-12">
        <nav class="navbar navbar-default" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse"
                            data-target="#example-navbar-collapse">
                        <span class="sr-only">切换导航</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">菜鸟教程</a>
                </div>
                <div class="collapse navbar-collapse" id="example-navbar-collapse">
                    <ul class="nav navbar-nav">
                        <%
                            String currentPage = (String) session.getAttribute("cuurentPage");
                            if (currentPage.equals("page1")) {
                        %>
                            <li class="active"><a href="page1.jsp">page1</a></li>
                            <li><a href="page2.jsp">page2</a></li>
                        <% } else { %>
                            <li><a href="page1.jsp">page1</a></li>
                            <li class="active"><a href="page2.jsp">page2</a></li>
                        <% } %>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</div>
