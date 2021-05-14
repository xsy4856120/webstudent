<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="../styles.css"/>
    <script src="../jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript"></script>
    <meta charset="UTF-8">
    <title>列表</title>
</head>
<body>
${list}
<div class="condition">
    用户名：<input type="text">
    用户名：<input type="text">
    用户名：<input type="text">
    <button>查询</button>
    <button onclick="window.location.href='add.jsp'">添加</button>
</div>
<table class="tablelist">
    <thead>
        <tr>
            <th>1</th>
            <th>1</th>
            <th>1</th>
            <th>1</th>
            <th width="300px">操作</th>
        </tr>
    </thead>
    <tr>
        <td>1</td>
        <td>1</td>
        <td>1</td>
        <td>1</td>
        <td>
           <button class="edit">修改</button>
           <button class="remove">删除</button>
        </td>
    </tr>
    <tr>
        <td>1</td>
        <td>1</td>
        <td>1</td>
        <td>1</td>
        <td>1</td>
    </tr>
    <tr>
        <td>1</td>
        <td>1</td>
        <td>1</td>
        <td>1</td>
        <td>1</td>
    </tr>

</table>
<table class="page">
    <td>
        <button>首页</button>
        <button>上一页</button>
        <button>下一页</button>
        <button>尾页</button>
        <input type="text" class="page-no" name="pageNo"/>
        <button>转到</button>

    </td>
</table>
</body>
</html>