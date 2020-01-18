<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link href="css/homeSendMS.css" rel="stylesheet">
</head>
<body>
<%@include file="include/top.jsp" %>
<div class="container">

    <!-- Main component for a primary marketing message or call to action -->
    <div class="jumbotron">
        <form action="/saveMessage" method="post" class="form-horizontal">
            <h5>${sessionScope.message}</h5>
            <input type="button" class="btn btn-primary" role="button" value="返回"/>&nbsp;&nbsp;
            <input type="submit" class="btn btn-primary" role="button" value="发送" id="send1"/>
            <br/>
            <br>
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">选择收件人</label>
                <div class="col-sm-10">
                    <select class="form-control" name="acceptId">
                        <c:forEach items="${userList}" var="cUser" >
                            <option value="${cUser.id}">${cUser.username}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">主题</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputEmail3"
                           placeholder="" name="theme" value="${empty mail?"":mail.theme}">
                </div>
            </div>
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">正文</label>
                <div class="col-sm-10">
                    <textarea class="form-control" rows="9" name="content">${empty mail?"":mail.content}</textarea>
                </div>
            </div>
        </form>
    </div>
</div>
<!-- /container -->
<%@include file="include/bottom.jsp" %>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<%--<script type="text/javascript" src="js/sendMessage.js"></script>--%>
</body>
</html>
