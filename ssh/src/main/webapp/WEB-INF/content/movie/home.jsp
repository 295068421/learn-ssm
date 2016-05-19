<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

        <div class="well well-small">
            <form action="" method="get" class="form-search" style="margin-bottom:0px;">
                <input type="text" placeholder="影片名称 或 导演" name="q_s_like_title_or_daoyan" value="${q_s_like_title_or_daoyan}">
                <input type="text" placeholder="最低评分" name="q_f_gt_rate" value="${q_rate_f_gt}">
                <input type="text" placeholder="最高评分" name="q_f_lt_rate" value="${q_rate_f_lt}">
                <button class="btn">搜</button>
            </form>
        </div>


        <a href="/movie/add.action" class="btn btn-success">新增影片</a>

        <table class="table">
            <thead>
                <tr>
                    <th>影片名称</th>
                    <th>导演</th>
                    <th>评分</th>
                    <th>#</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${page.items}" var="movie">
                <tr>
                    <td width="400">${movie.title}</td>
                    <td>${movie.daoyan}</td>
                    <td>${movie.rate}</td>
                    <td>
                        <a href="/movie/edit.action?id=${movie.id}">编辑</a>
                        <a href="javascript:;" class="delLink" rel="${movie.id}">删除</a>
                    </td>
                </tr>
                </c:forEach>
            </tbody>

        </table>
        <div class="pagination pagination-right" id="pages"></div>

    </div>
    <script src="/repo/js/jquery-1.11.3.min.js"></script>
    <script src="/repo/js/jquery.twbsPagination.min.js"></script>
    <script>
        $(function(){
            $(".delLink").click(function(){
                var id = $(this).attr("rel");
                if(confirm("确定要删除吗")) {
                    window.location.href = "/movie/del.action?id="+id;
                }


            });

            $("#pages").twbsPagination({
                totalPages:${page.totalPages},
                visiblePages:5,
                first:'首页',
                last:'末页',
                prev:'上一页',
                next:'下一页',
                href:"?q_s_like_title_or_daoyan="+encodeURIComponent('${q_s_like_title_or_daoyan}')+"&q_f_gt_rate=${q_f_gt_rate}&q_f_lt_rate=${q_f_lt_rate}&p={{number}}"
            });
        });
    </script>
</body>
</html>