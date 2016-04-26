<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>电影列表</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>

    <div class="container">
        <c:if test="${not empty message}">
            <div class="alert alert-info">${message}</div>
        </c:if>
        <div class="page-header">
            <h4>SpringMVC+Spring+MyBatis CRUD Demo</h4>
        </div>
        <a href="/movie/new" class="btn btn-primary">新增影片</a>
        <table class="table">
            <thead>
                <tr>
                    <th>电影名称</th>
                    <th>评分</th>
                    <th>发行时间</th>
                    <th>上映时间</th>
                    <th>导演</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${movieList}" var="movie">
                    <tr>
                        <td width="400"><a href="/movie/${movie.id}">${movie.title}</a></td>
                        <td>${movie.rate}</td>
                        <td>${movie.releaseyear}</td>
                        <td>${movie.sendtime}</td>
                        <td>${movie.daoyan}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>


    </div>

</body>
</html>