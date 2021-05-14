<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>学生管理系统登陆界面</title>

    <style type="text/css">
        html, body {
            background-image: url("static/1.jpeg");
            background-size: 100% 100%;
            height: 100%;
        }

        input {
            height: 35px;
            /*border: 0px;*/
            border-radius: 4px;
            width: 30%;

        }

        button {
            width: 30%;
            height: 35px;
            border: 0px;
            border-radius: 5px;
            font-size: 16px;

        }

        .login {
            position: absolute;
            text-align: center;
            background-color: aliceblue;
            top: 25%;
            left: 60%;
            right: 10%;
            bottom: 25%;
            border-radius: 5px;
        }

        .title {
            text-align: center;
            font-family: "Microsoft YaHei UI";
            position: absolute;
            bottom: 80%;
            top: 0%;
            border: aliceblue;
            width: 100%;
            font-size: 36px;
            font-weight: bold;
            padding-top: 10px;
        }

        .u {
            position: absolute;
            bottom: 80%;
            top: 20%;
            border: aliceblue;
            width: 100%;
        }

        .p {
            position: absolute;
            bottom: 80%;
            top: 40%;
            border: aliceblue;
            width: 100%;
        }

        .l {
            position: absolute;
            bottom: 80%;
            top: 60%;
            border: aliceblue;
            width: 100%;
        }

        .z {
            position: absolute;
            bottom: 80%;
            top: 60%;
            left: 50%;
            border: aliceblue;
            width: 100%;
        }
        .s{
            top: 80%;
            bottom: 40%;
            left: 10%;
            position: absolute;
            width: 100%;
        }
    </style>
</head>

<div class="login">
    <div class="title">
        学生管理系统
    </div>
    <form action="login" method="post">
    <div class="u">
        <label>用户名：</label>
        <div class="controls">
            <input id="inputUsername" placeholder="Username" type="text" name="username" value="123">
        </div>
    </div>
    <div class="p">
        <label>密码：</label>
        <div class="controls">
            <input id="inputPassword" placeholder="Password" type="password" name="password" value="123">
        </div>
    </div>
    <div class="l">
        ${error}
       <button>登录</button>
    </div>

    <div class="s">
        <select name="type" >
        <option value="2">请选择登陆类型</option>
        <option value="0">学生</option>
        <option value="1">教师</option>
        <option value="2">管理员</option>
    </select>
    </div>
    </form >
    <form action="logon" method="get">
        <div class="z">
            <input type="submit" value="注册"/>
        </div>
    </form>
</div>
</body>
</html>