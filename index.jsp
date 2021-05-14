<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();

    String basePath = request.getScheme()
            + "://" + request.getServerName()
            + ":"
            + request.getServerPort()
            + path
            + "/";
%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>学生系统首页</title>
    <link rel="stylesheet" href="<%=basePath%>styles.css"/>
    <script src="jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function(){
            $('.menux.p').click(function () {
                $(this).siblings('.ul').slideUp(200);
                $(this).next('.ul').slideToggle(200);
            });
            $('.menux ul a').click(function(){

                $('iframe').attr("src",$(this).attr("url"));
                $('.menu_title').html($(this).attr("title"));
            });

            $('.logout').click(function (){
                if (confirm("确定要退出吗？")){
                    window.location.href="logout";
                }
            });
        })
    </script>
</head>
<body>
<div class="header">
    学生管理系统
    <div>

    </div>
</div>
<div class="left">
    <div class="title">
        主菜单
    </div>
    <div class="menux">
        <c:if test="${type ==2}">
        <p>管理员操作</p>
        <ul>
            <li>
                <a href="javascript:void(0);" url="teacher?method=list" title="教师查询">教师查询</a>
            </li>
            <li>
                <a href="javascript:void(0);" url="page/teacher/add.jsp" title="教师管理">教师管理</a>
            </li>
            <li>
                <a href="javascript:void(0);" url="page/student/update.jsp" title="查询">查询</a>
            </li>
            <li>
                <a href="javascript:void(0);" class="logout" title="退出登录">退出登录</a>
            </li>
        </ul>
        </c:if>
        <c:if test="${type ==1}">

        <p>老师权限</p>
        <ul>

            <li>
                <a href="javascript:void(0);" url="page/student/list.jsp" title="查询统计">查询统计</a>
            </li>
            <li>
                <a href="javascript:void(0);" url="page/class/update.jsp" title="子功能3">查询</a>
            </li>
            <li>
                <a href="javascript:void(0);" class="logout" title="退出登录">退出登录</a>
            </li>
        </ul>
        </c:if>
        <c:if test="${type ==0}">

        <p>学生权限</p>
        <ul>
            <li>
                <a href="javascript:void(0);" url="page/class/update.jsp" title="子功能1">选课</a>
            </li>
            <li>
                <a href="javascript:void(0);" url="page/class/list.jsp" title="子功能2">查询统计</a>
            </li>
            <li>
                <a href="javascript:void(0);" url="page/class/add.jsp" title="子功能3">查询</a>
            </li>
            <li>
                <a href="javascript:void(0);" class="logout" title="退出登录">退出登录</a>
            </li>
        </ul>

        </c:if>
    </div>
</div>
<div class="main">
    <div class="location">
        <span class="menu_title">用户管理</span>
    </div>
    <iframe src="temp/add.jsp" width="100%" height="100%" frameborder="0px"></iframe>
</div>
</body>
</html>