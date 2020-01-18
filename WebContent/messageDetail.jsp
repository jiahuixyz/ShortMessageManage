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

    <title>邮件管理中心</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/homeDetail.css" rel="stylesheet">
</head>
<body>
<%@include file="include/top.jsp" %>
<div class="container">
    <!-- Main component for a primary marketing message or call to action -->
    <div class="jumbotron">
        <p>
            <a class="btn btn-primary" href="#" role="button">返回</a>&nbsp;&nbsp;
            <a class="btn btn-primary" href="#" role="button">回复</a>
            <a class="btn btn-primary" href="#" role="button">删除</a>
            <a class="btn btn-primary" href="#" role="button">转发</a>
            <a class="btn btn-primary btn-danger" href="#" role="button">举报</a>
        </p>


        <div class="container">
            <div class="form-group">
                <div class="col-sm-1 text-center" style="font-size: 18px">
                    主题
                </div>
                <div class="panel panel-default col-sm-11">
                    <div class="panel-body">
                        ${shortms.theme}
                    </div>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-1 text-center" style="font-size: 18px">
                    正文
                </div>
                <div class="panel panel-default col-sm-11">
                    <div class="panel-body">
                        ${shortms.content}
                    </div>
                </div>
            </div>

        </div>


        <%--<p>主题&nbsp;&nbsp;&nbsp;&nbsp;</p>--%>
        <%--<p>正文&nbsp;&nbsp;&nbsp;&nbsp;</p>--%>

    </div>

</div> <!-- /container -->
<%@include file="include/bottom.jsp" %>
</body>
</html>
