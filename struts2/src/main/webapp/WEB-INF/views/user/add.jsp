<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/2.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/2.3.2/css/bootstrap.min.css">
</head>
<body>

    <div class="container">
        <form action="/user/save.do" method="post">
            <label>姓名</label>
            <input type="text" name="user.name">
            <label>电话</label>
            <input type="text" name="user.phone">
            <div class="form-actions">
                <button class="btn">保存</button>
            </div>
        </form>
    </div>

</body>
</html>