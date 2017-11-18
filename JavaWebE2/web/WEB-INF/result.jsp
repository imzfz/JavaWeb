<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="cn.imzfz.exp2.Question" %><%--
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
<jsp:useBean id="result" class="cn.imzfz.exp2.Result"/>
<%
    session.setMaxInactiveInterval(300);
    if (session.getAttribute("user") == null) {
        response.sendRedirect("index.jsp");
        session.setAttribute("login", 1);
    } else {
        result.connect();
    }
%>

<%
    Map<String, String> sin = new HashMap<>();
    Map<String, String> ttff = new HashMap<>();
    if(session.getAttribute("count") != null)
    for (int i = 0; i < (int) session.getAttribute("count"); i++) {
        if (request.getParameter("single" + i) != null) {
            sin.put(((ArrayList) (session.getAttribute("id"))).get(i).toString(), request.getParameter("single" + i));
        }
        if (request.getParameter("tf" + i) != null) {
            ttff.put(((ArrayList) (session.getAttribute("id"))).get(i).toString(), request.getParameter("tf" + i));
        }
    }
%>
<jsp:setProperty name="result" property="single" value="<%=sin%>"/>
<jsp:setProperty name="result" property="tf" value="<%=ttff%>"/>
<%result.judge(((ArrayList<String>) (session.getAttribute("id"))));%>
您的得分是:
<jsp:getProperty name="result" property="score"/>
分
<p>
    <button type="submit" class="btn btn-success" onclick="exit()">退出</button>

    <script type="text/javascript">
        function exit() {
            window.location.href = "exit.jsp";
        }
    </script>

</body>
</html>
