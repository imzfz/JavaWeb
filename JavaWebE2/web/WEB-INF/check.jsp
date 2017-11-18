<%--
  Created by IntelliJ IDEA.
  User: zfz
  Date: 2017/10/26
  Time: 下午1:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<jsp:useBean id="check" scope="page" class="cn.imzfz.exp2.Check"/>
<html>
<head>
    <title>none</title>
</head>
<body>
<%request.setCharacterEncoding("UTF-8");%>
<jsp:setProperty name="check" property="user" param="user" />
<jsp:setProperty name="check" property="pass" param="password" />
<%
    if (!check.isValid()) {
        response.sendRedirect("index.jsp");
        session.setAttribute("login", 0);
    }
    else{
        session.setAttribute("user", check.getUser());
        response.sendRedirect("question.jsp");
    }
%>
</body>
</html>