<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${movie.title}</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>

    <div class="container">
        <div class="page-header">
            <h4>${movie.title} <span>${movie.rate}</span></h4>
        </div>
        <p>导演：${movie.daoyan} 发行时间:${movie.releaseyear} 上映时间:${movie.sendtime}</p>
        <p>演员：<c:forEach items="${actorList}" var="actor">${actor.name}&nbsp;&nbsp;</c:forEach></p>
        <c:if test="${empty movie.jianjie}">
            <p>暂无简介</p>
        </c:if>
        <p>${movie.jianjie}</p>
        <p>
            <a href="/movie/edit/${movie.id}" class="btn btn-info">编辑</a>
            <a href="javascript:;" id="del" class="btn btn-danger">删除</a>
        </p>
    </div>

    <script src="/static/js/jquery-1.11.3.min.js"></script>
    <script>
        $(function(){

            $("#del").click(function(){
                if(confirm("确定要删除吗")) {
                    window.location.href = "/movie/del/${movie.id}";
                }
            });
        });

    </script>
</body>
</html>