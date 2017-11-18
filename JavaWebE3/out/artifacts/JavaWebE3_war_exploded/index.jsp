<%--
  Created by IntelliJ IDEA.
  User: zfz
  Date: 2017/10/26
  Time: 下午1:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <title>在线答题系统</title>
    <script src="/js/bootstrap.min.js" type="text/javascript"></script>
    <link href="/css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="container">
    <form action="loginControl" method="post">
        <div class="panel panel-info row col-md-4 center-pill">
            <div class="panel-heading row">登录</div>
            <%if (session.getAttribute("login") != null) {%>
            <%=session.getAttribute("login")%>
            <%}%>

            <div class="panel-body row col-md-12 form-group">
                <table class="table">
                    <tr>
                        <td>用户名</td>
                        <td><input type="text" class="form-control" placeholder="Username" id="user" name="user"></td>

                    <tr>
                        <td>密码</td>
                        <td><input type="password" class="form-control" placeholder="Password" id="password"
                                   name="password"></td>
                    </tr>
                    <tr>
                        <td>
                            <button type="submit" class="btn btn-success" name="submit">提交</button>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </form>
</div>
</body>
</html>
