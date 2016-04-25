<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h3>添加图书 : ${pubName}</h3>
    <form method="post">
        <label>书名</label>
        <input type="text" name="bookName">
        <label>价格</label>
        <input type="text" name="bookPrice">
        <label>出版社</label>
        <input type="text" name="pubName">
        <div class="form-actions">
            <button class="btn btn-primary">保存</button>
        </div>
    </form>
</div>
</body>
</html>