<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>

<%--
  Created by IntelliJ IDEA.
  User: zfz
  Date: 2017/10/30
  Time: 下午6:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>得分情况</title>
    <script src="/js/bootstrap.min.js" type="text/javascript"></script>
    <link href="/css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body>
您的得分是:<%=session.getAttribute("score")%>
分
<p>
    <button type="submit" class="btn btn-success" onclick="exit()">退出</button>

    <script type="text/javascript">
        function exit() {
            window.location.href = "logout";
        }
    </script>

</body>
</html>
