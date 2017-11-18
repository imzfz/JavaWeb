<%@ page import="cn.imzfz.exp2.SqlConnect" %><%--
  Created by IntelliJ IDEA.
  User: zfz
  Date: 2017/10/30
  Time: 下午7:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>none</title>
</head>
<body>
<%session.invalidate();
response.sendRedirect("index.jsp");
%>
</body>
</html>
