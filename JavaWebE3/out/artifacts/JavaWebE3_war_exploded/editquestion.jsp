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
<body>
<!-- 弹窗 -->
<%@include file="modal.html" %>

<!--==================================================================================================-->
<div class="container">
    <div class="panel panel-info">
        <div class="panel-heading">
            <h4>题目管理</h4>
            <button class="btn btn-link" type="button">退出</button>
        </div>
        <div class="panel-body">
            <button class="btn btn-default" type="button" data-toggle="modal" data-target="#addModal" onclick="loadjs()">
                添加
            </button>
            <button class="btn btn-default" type="button">修改</button>
            <button class="btn btn-default" type="button">删除</button>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th></th>
                    <th>题号</th>
                    <th>类型</th>
                    <th>题目</th>
                    <th>分值</th>
                </tr>
                </thead>
                <c:forEach items="${requestScope.ql}" var="question" varStatus="status">
                    <c:choose>
                        <c:when test="${question.value.type == 'tf'}">
                            <c:set var="type" value="判断"/>
                        </c:when>
                        <c:when test="${question.value.type == 'select'}">
                            <c:set var="type" value="选择"/>
                        </c:when>

                        <c:otherwise>
                            <c:set var="type" value=""/>
                        </c:otherwise>
                    </c:choose>
                    <tr>
                        <td><input type="checkbox" name="checkbox_${question.value.id}"></td>
                        <td>${question.value.id}</td>
                        <td>${type}</td>
                        <td>${question.value.title}</td>
                        <td>${question.value.score}</td>
                    </tr>
                    <c:if test="${status.last}">
                        <input type="hidden" id="getId" value="${status.index + 2}">
                    </c:if>
                </c:forEach>
            </table>
        </div>
    </div>
</div>

</body>
</html>
