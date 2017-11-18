<%@ page import="cn.imzfz.faq.Result" %><%--
  Created by IntelliJ IDEA.
  User: zfz
  Date: 2017/10/16
  Time: 下午9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>得分情况</title>
    <script src="/js/bootstrap.min.js" type="text/javascript"></script>
    <link href="/css/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">
    <%
        if (session.getAttribute("user") == null) {
            response.sendRedirect("index.jsp");
            session.setAttribute("login", 1);
        }
        Result result = new Result();
        result.setTf(request.getParameterValues("tf"));
        result.setSingle(request.getParameterValues("single"));
        result.setMulti(request.getParameterValues("multi"));
        out.print("您的得分是: " + result.judge());
    %>
</div>
</body>
</html>
