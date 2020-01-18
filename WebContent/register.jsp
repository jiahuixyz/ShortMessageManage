<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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

    <title>欢迎您的注册</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/register.css" rel="stylesheet">

    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/md5.min.js"></script>
    <script !src="">
        $(function () {
            $("#register").click(function () {
                var password = $("#inputPassword").val();
                $("#realPassword").val(md5(password));
                $("form").submit();
            });
        });
    </script>
</head>

<body>

<div class="container">

    <form class="form-horizontal" method="post" action="Register">
        <h1>欢迎注册</h1>
        <div class="form-group">
            <label for="inputEmail" class="col-sm-3 control-label">你的昵称</label>
            <div class="col-sm-9">
                <input type="text" class="form-control" id="inputEmail"
                       placeholder="仅限英文" name="username">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword" class="col-sm-3 control-label">你的密码</label>
            <div class="col-sm-9">
                <input type="password" class="form-control" id="inputPassword"
                       placeholder="输入你的密码">
                <input type="hidden" name="password" id="realPassword">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword" class="col-sm-3 control-label">确认密码</label>
            <div class="col-sm-9">
                <input type="password" class="form-control"
                       placeholder="再次输入你的密码">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword" class="col-sm-3 control-label">手机号</label>
            <div class="col-sm-9">
                <input type="email" class="form-control"
                       placeholder="输入你的手机号" name="iphone">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-9 col-sm-offset-3" style="font-size: 12px;color: #9d9d9d">
                可通过该手机号找回密码
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-3 col-sm-9">
                <button class="btn btn-lg btn-primary btn-block" type="button" id="register">注
                    册
                </button>
            </div>
        </div>
    </form>

</div>
<!-- /container -->
</body>
</html>
