<%--
  Created by IntelliJ IDEA.
  User: zfz
  Date: 2017/10/16
  Time: 下午6:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="cn.imzfz.exp2.TrueOrFalse" %>
<%@ page import="cn.imzfz.exp2.Choice" %>
<%@ page import="cn.imzfz.exp2.Select" %>
<html>
<head>
    <title>欢迎答题</title>
    <script src="/js/bootstrap.min.js" type="text/javascript"></script>
    <link href="/css/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:useBean id="question" class="cn.imzfz.exp2.Question"/>
<jsp:useBean id="choice" class="cn.imzfz.exp2.Choice"/>
<div class="container">
    <%
        session.setMaxInactiveInterval(300);
        if (session.getAttribute("user") == null) {
            response.sendRedirect("index.jsp");
            session.setAttribute("login", 1);
        } else {
            question.connect();
            choice.connect();
        }
    %>

    <%if (choice.getList() != null) {%>
    <form method="post" action="result.jsp">
        <div class="panel panel-info">
            <div class="panel-heading">用户:<%=session.getAttribute("user")%>
                <a href="exit.jsp">退出</a>
            </div>
            <div class="panel-body">
                <%for (int i = 0; i < question.getqId().size(); i++) {%>
                <p><%=question.getqId().get(i)%>、<%=question.getqTitle().get(i)%> (<%=question.getqScore().get(i)%>
                    分)</p>
                <%if (choice.getList().get(question.getqId().get(i)) instanceof TrueOrFalse) {%>
                <ul>
                    <li style="list-style-type: none">
                        <label>
                            <input type="radio" name="<%="tf" + i%>" value="yes"> 对
                        </label>
                    </li>
                    <li style="list-style-type: none">
                        <label>
                            <input type="radio" name="<%="tf" + i%>" value="no"> 错
                        </label>
                    </li>
                </ul>
                <%}%>

                <%if (choice.getList().get(question.getqId().get(i)) instanceof Select) {%>
                <ul>
                    <li style="list-style-type: none">
                        <label>
                            <input type="radio" name="<%="single" + i%>" value="a">
                            A.<%=((Select) choice.getList().get(question.getqId().get(i))).getChoiceA()%>
                        </label>
                    </li>
                    <li style="list-style-type: none">
                        <label>
                            <input type="radio" name="<%="single" + i%>" value="b">
                            B.<%=((Select) choice.getList().get(question.getqId().get(i))).getChoiceB()%>
                        </label>
                    </li>
                    <li style="list-style-type: none">
                        <label>
                            <input type="radio" name="<%="single" + i%>" value="c">
                            C.<%=((Select) choice.getList().get(question.getqId().get(i))).getChoiceC()%>
                        </label>
                    </li>
                    <li style="list-style-type: none">
                        <label>
                            <input type="radio" name="<%="single" + i%>" value="d">
                            D.<%=((Select) choice.getList().get(question.getqId().get(i))).getChoiceD()%>
                        </label>
                    </li>
                </ul>
                <%}%>
                <%}%>
                <%session.setAttribute("count", question.getqId().size());%>
                <%session.setAttribute("id", question.getqId());%>
                <ul>
                    <li style="list-style-type: none">
                        <p></p>
                        <p></p>
                        <button type="submit" class="btn btn-success text-center">提交</button>
                    </li>
                </ul>
            </div>
        </div>
    </form>
    <%}%>
</div>

</body>
</html>
