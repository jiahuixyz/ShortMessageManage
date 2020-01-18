<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="img/favicon.ico">

    <title>登录邮箱</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="css/login.css" rel="stylesheet" type="text/css">

    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/md5.min.js"></script>
    <script src="js/jquery.cookie.js"></script>
    <script !src="">
        $(function () {
            console.log($.cookie("username"))
            console.log($.cookie("password"))
            var status=0;//cookie状态
            if ($.cookie("password")) {
                $("#realPassword").val($.cookie("password"));
                status=1;
            }
            if ($.cookie("username")) {
                $("#inputEmail").val($.cookie("username"));
                $("#inputPassword").val("******")
            }
            $("#login").click(function () {
                if(status==0){
                    var password = $("#inputPassword").val();
                    $("#realPassword").val(md5(password));
                }

                $("form").submit();
            });
        });
    </script>
</head>

<body>

<div class="container">

    <form class="form-signin" action="/login" method="post">
        <h2 class="form-signin-heading">欢&nbsp;迎</h2>
        <h5 class="form-signin-heading" style="color: #ff0000">${error}</h5>
        <input type="text" id="inputEmail" class="form-control"
               placeholder="你的邮箱" required autofocus name="username">
        <input type="password" id="inputPassword" class="form-control"
               placeholder="你的密码" required>
        <input type="hidden" name="password" id="realPassword">
        <div class="checkbox">
            <label>
                <input type="checkbox" value="1" name="remeberMe"> 记住我
            </label>
            <span id="spanHelp"><a href="#">忘记密码？</a><a href="Register">注册</a></span>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="button" id="login">登 陆</button>
    </form>

</div>
</body>

</html>

