<%--
  Created by IntelliJ IDEA.
  User: zfz
  Date: 2017/11/16
  Time: 下午2:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>题目管理</title>
    <script src="/js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="/js/bootstrap.min.js" type="text/javascript"></script>
    <link href="/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <script src="/js/question.js" type="text/javascript"></script>
</head>
<body onload="beforeDelorUpdate()">
<!-- 弹窗 -->
<%@include file="modal.html" %>

<!--==================================================================================================-->
<div class="container">
    <div class="panel panel-info">
        <div class="panel-heading">
            <h4>题目管理</h4>
            <a href="/logout" class="btn btn-link" role="button" >退出</a>
        </div>
        <div class="panel-body">
            <button class="btn btn-default" type="button" data-toggle="modal" data-target="#addModal"
                    onclick="loadjs()">添加
            </button>
            <button class="btn btn-default" id="updateButton" type="button" data-toggle="modal"
                    data-target="#updateModal"
                    onclick="update()">修改
            </button>

            <button class="btn btn-default" id="delButton" type="button" onclick="doDelete()">删除</button>
            <form id="doDel" name="doDel" method="post" action="delete">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th></th>
                        <th>题号</th>
                        <th>类型</th>
                        <th>题目</th>
                        <th>答案</th>
                        <th>分值</th>
                    </tr>
                    </thead>
                    <c:forEach items="${requestScope.ql}" var="question" varStatus="status">
                        <c:choose>
                            <c:when test="${question.value.type == 'tf'}">
                                <c:set var="type" value="判断"/>
                                <c:set var="id" value="${question.value.id}"/>
                                <input type="hidden" id="getChoiceYes" value="yes">
                                <input type="hidden" id="getChoiceNo" value="no">
                            </c:when>
                            <c:when test="${question.value.type == 'select'}">
                                <c:set var="type" value="选择"/>
                                <c:set var="id" value="${question.value.id}"/>
                                <input type="hidden" name="getChoice_${question.value.id}"
                                       value="${requestScope.cho[id].choiceA}">
                                <input type="hidden" name="getChoice_${question.value.id}"
                                       value="${requestScope.cho[id].choiceB}">
                                <input type="hidden" name="getChoice_${question.value.id}"
                                       value="${requestScope.cho[id].choiceC}">
                                <input type="hidden" name="getChoice_${question.value.id}"
                                       value="${requestScope.cho[id].choiceD}">
                            </c:when>

                            <c:otherwise>
                                <c:set var="type" value=""/>
                            </c:otherwise>
                        </c:choose>
                        <tr>
                            <td><input type="checkbox" id="checkbox_${question.value.id}" name="checkbox" value="${question.value.id}"
                                       onchange="beforeDelorUpdate()"></td>
                            <td id="showId_${question.value.id}">${question.value.id}</td>
                            <td id="showType_${question.value.id}">${type}</td>
                            <td id="showTitle_${question.value.id}">${question.value.title}</td>
                            <td id="showAnswer_${question.value.id}">${question.value.answer}</td>
                            <td id="showScore_${question.value.id}">${question.value.score}</td>
                        </tr>
                        <c:if test="${status.last}">
                            <input type="hidden" id="getId" value="${status.index + 2}">
                        </c:if>
                    </c:forEach>
                </table>
            </form>
        </div>
    </div>
</div>

</body>
</html>
