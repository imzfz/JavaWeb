<%--
  Created by IntelliJ IDEA.
  User: zfz
  Date: 2017/11/30
  Time: 上午10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>错误页</title>
</head>
<body>

出错啦！请重试
<p>${requestScope.error.value}</p>
</body>
</html>
