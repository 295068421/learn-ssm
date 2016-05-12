<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
    <h1>Book Action Home Page</h1>
    <s:if test="username == 'tom'">
        <h1>Tom</h1>
    </s:if>
    <s:elseif test="username == 'tom2'">
        <h1>${username}</h1>
        <h1><s:property value="username"/> </h1>
    </s:elseif>
    <s:else>
        <h1>Other</h1>
    </s:else>

    <ul>
        <s:iterator var="user" value="userList" status="s">
            <li>${s.last} -> ${user.id} -> ${user.username}</li>
            <li><s:property value="#s.last"/> -> <s:property value="#user.id"/> -> <s:property value="#user.username"/> </li>
        </s:iterator>
    </ul>
</body>
</html>