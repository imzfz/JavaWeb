<%--
  Created by IntelliJ IDEA.
  User: zfz
  Date: 2017/10/16
  Time: 下午7:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="cn.imzfz.faq.Check" %>
<html>
<head>
    <title>none</title>
</head>
<body>
<%
    Check check = new Check();
    String user = request.getParameter("user");
    check.setUser(user);
    check.setPass(request.getParameter("password"));
    if (!check.isValid()) {
        response.sendRedirect("index.jsp");
        session.setAttribute("login", 0);
    }
    else{
        session.setAttribute("user", user);
        response.sendRedirect("question.jsp");
    }
%>
</body>
</html>
