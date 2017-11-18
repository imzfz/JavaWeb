<%--
  Created by IntelliJ IDEA.
  User: zfz
  Date: 2017/10/16
  Time: 下午6:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="cn.imzfz.faq.Check" %>
<html>
<head>
    <title>欢迎答题</title>
    <script src="/js/bootstrap.min.js" type="text/javascript"></script>
    <link href="/css/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="container">
    <%
        session.setMaxInactiveInterval(300);
        if (session.getAttribute("user") == null) {
            response.sendRedirect("index.jsp");
            session.setAttribute("login", 1);
        }
    %>
    <form method="post" action="result.jsp">
        <div class="panel panel-info">
            <div class="panel-heading">用户:<%=session.getAttribute("user")%>
            </div>
            <div class="panel-body">
                <ul>
                    <p>1、JSP技术比Servlet技术出现的早。 (3分)</p>
                    <li style="list-style-type: none">
                        <label>
                            <input type="radio" name="tf" value="yes"> 对
                        </label>
                    </li>
                    <li style="list-style-type: none">
                        <label>
                            <input type="radio" name="tf" value="no"> 错
                        </label>
                    </li>
                </ul>

                <ul>
                    <p>2、JSP是被（）成Servlet后运行的。 (3分)</p>
                    <li style="list-style-type: none">
                        <label>
                            <input type="radio" name="single" value="a"> A.转译
                        </label>
                    </li>
                    <li style="list-style-type: none">
                        <label>
                            <input type="radio" name="single" value="b"> B.编译
                        </label>
                    </li>
                    <li style="list-style-type: none">
                        <label>
                            <input type="radio" name="single" value="c"> C.执行
                        </label>
                    </li>
                    <li style="list-style-type: none">
                        <label>
                            <input type="radio" name="single" value="d"> D.编码
                        </label>
                    </li>
                </ul>

                <ul>
                    <p>3、四大名著有（） (全对4分,其余2分,有错不得分)</p>
                    <li style="list-style-type: none">
                        <label>
                            <input type="checkbox" name="multi" value="a"> A.《水浒传》
                        </label>
                    </li>
                    <li style="list-style-type: none">
                        <label>
                            <input type="checkbox" name="multi" value="b"> B.《红楼梦》
                        </label>
                    </li>
                    <li style="list-style-type: none">
                        <label>
                            <input type="checkbox" name="multi" value="c"> C.《三国演义》
                        </label>
                    </li>
                    <li style="list-style-type: none">
                        <label>
                            <input type="checkbox" name="multi" value="d"> D.《西游记》
                        </label>
                    </li>
                    <li style="list-style-type: none">
                        <label>
                            <input type="checkbox" name="multi" value="e"> E.《西厢记》
                        </label>
                    </li>
                    <li style="list-style-type: none">
                        <p></p>
                        <p></p>
                        <button type="submit" class="btn btn-success text-center">提交</button>
                    </li>
                </ul>
            </div>
        </div>
    </form>
</div>

</body>
</html>
