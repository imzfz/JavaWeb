<%--
  Created by IntelliJ IDEA.
  User: zfz
  Date: 2017/10/16
  Time: 下午6:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>欢迎答题</title>
    <script src="/js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="/js/bootstrap.min.js" type="text/javascript"></script>
    <link href="/css/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">
    <c:if test="${requestScope.ql != null}">
        <form method="post" action="result">
            <div class="panel panel-info">
                <div class="panel-heading">用户:<%=session.getAttribute("user")%>
                    <a href="/logout">退出</a>
                </div>
                <div class="panel-body">
                    <c:forEach items="${requestScope.ql}" var="question">
                        <p>${question.value.id}、${question.value.title}(${question.value.score}分)</p>
                        <c:if test="${question.value.type == 'tf'}">
                            <ul>
                                <li style="list-style-type: none">
                                    <label>
                                            <%--<input type="radio" name="<%="tf" + i%>" value="yes"> 对--%>
                                        <input type="radio" name="<%="tf_"%>${question.value.id}" value="yes"> 对
                                    </label>
                                </li>
                                <li style="list-style-type: none">
                                    <label>
                                            <%--<input type="radio" name="<%="tf" + i%>" value="no"> 错--%>
                                        <input type="radio" name="<%="tf_"%>${question.value.id}" value="no"> 错
                                    </label>
                                </li>
                            </ul>
                        </c:if>

                        <c:if test="${question.value.type == 'select'}">
                            <c:set var="id" value="${question.value.id}"/>
                            <ul>
                                <li style="list-style-type: none">
                                    <label>
                                            <%--<input type="radio" name="<%="single" + i%>" value="a">
                                            A.<%=((Select) choice.getList().get(q.getId())).getChoiceA()%>--%>
                                        <input type="radio" name="<%="single_"%>${question.value.id}" value="a">
                                        A.${requestScope.cho[id].choiceA}
                                    </label>
                                </li>
                                <li style="list-style-type: none">
                                    <label>
                                        <input type="radio" name="<%="single_"%>${question.value.id}" value="b">
                                        B.${requestScope.cho[id].choiceB}
                                    </label>
                                </li>
                                <li style="list-style-type: none">
                                    <label>
                                        <input type="radio" name="<%="single_"%>${question.value.id}" value="c">
                                        C.${requestScope.cho[id].choiceC}
                                    </label>
                                </li>
                                <li style="list-style-type: none">
                                    <label>
                                        <input type="radio" name="<%="single_"%>${question.value.id}" value="d">
                                        D.${requestScope.cho[id].choiceD}
                                    </label>
                                </li>
                            </ul>
                        </c:if>
                        <input type="hidden" name="totalId" value="${requestScope.get("totalNum")}">
                    </c:forEach>
                        <%--<%session.setAttribute("count", question.getQuestionMap().size());%>--%>
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
    </c:if>
</div>

</body>
</html>
