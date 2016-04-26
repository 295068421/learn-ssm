<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>修改影片</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <form method="post">
            <input type="hidden" name="id" value="${movie.id}">
            <legend>修改影片</legend>
            <label>名称</label>
            <input type="text" name="title" class="span5" value="${movie.title}">
            <label>评分</label>
            <input type="text" name="rate" class="span5" value="${movie.rate}">
            <label>导演</label>
            <input type="text" name="daoyan" class="span5" value="${movie.daoyan}">
            <label>演员</label>
            <input type="text" name="actors" class="span5" value="${actorList}">
            <label>发行时间</label>
            <input type="text" name="releaseyear" class="span5" value="${movie.releaseyear}">
            <label>上映时间</label>
            <input type="text" name="sendtime" class="span5" value="${movie.sendtime}">
            <label>简介</label>
            <textarea name="jianjie" style="width:60%;height: 100px">${movie.jianjie}</textarea>
            <div class="form-actions">
                <button>保存</button>
            </div>
        </form>
    </div>
</body>
</html>