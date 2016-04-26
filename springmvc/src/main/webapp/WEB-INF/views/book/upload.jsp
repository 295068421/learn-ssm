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
        <form method="post" enctype="multipart/form-data">
            <input type="file" name="doc">
            <div class="form-actions">
                <button class="btn btn-primary">Upload</button>
            </div>
        </form>
    </div>
</body>
</html>