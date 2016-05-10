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

        <form action="/file/save.do" method="post" enctype="multipart/form-data">
            <label>文件名</label>
            <input type="text" name="name">
            <label>请选择文件</label>
            <input type="file" name="doc">
            <input type="file" name="doc">
            <div class="form-actions">
                <button class="btn btn-primary">保存</button>
            </div>
        </form>

        <a href="/file/download.do?name=2.jpg">点击下载文件</a>
    </div>
</body>
</html>