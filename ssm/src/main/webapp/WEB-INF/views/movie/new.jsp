<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>新增影片</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <form method="post">
            <legend>新增影片</legend>
            <label>名称</label>
            <input type="text" name="title">
            <label>评分</label>
            <input type="text" name="rate">
            <label>导演</label>
            <input type="text" name="daoyan">
            <label>演员</label>
            <input type="text" name="actors">
            <label>发行时间</label>
            <input type="text" name="releaseyear">
            <label>上映时间</label>
            <input type="text" name="sendtime">
            <label>简介</label>
            <textarea name="jianjie" style="width:60%;height: 100px"></textarea>
            <div class="form-actions">
                <button>保存</button>
            </div>
        </form>
    </div>
</body>
</html>