<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
    <h1>${sessionScope.skey2}</h1>
    <ul>
    <c:forEach items="${userList}" var="user">
        <li>${user.name}</li>
    </c:forEach>
    </ul>
</body>
</html>