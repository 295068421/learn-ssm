<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="/repo/css/bootstrap.min.css">
</head>
<body>

    <div class="container">
        <c:if test="${param.state == 1001}">
            <div class="alert alert-danger">
                账号或密码错误
            </div>
        </c:if>
        <form action="/user/lg.do" method="post">
            <label>账号</label>
            <input type="text" name="user.username">
            <label>密码</label>
            <input type="password" name="user.password">
            <div class="form-actions">
                <button class="btn">登录</button>
            </div>
        </form>
    </div>

</body>
</html>