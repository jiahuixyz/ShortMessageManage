<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<link href="css/home.css" rel="stylesheet">
</head>
<body>
<%@include file="include/top.jsp" %>
	<div class="container">
		<!-- Main component for a primary marketing message or call to action -->
		<div class="jumbotron">
			<form action="#">
				<h3>${sessionScope.message}</h3>
				<input type="button" class="btn btn-primary" role="button" value="管理>>"/>&nbsp;&nbsp;
				<input type="button" class="btn btn-primary" role="button" value="删除" id="delete1"/>
				<input type="button" class="btn btn-primary" role="button" value="转发" id="forward1"/>
				<br />
				<br />
				<table class="table table-hover">
					<tr class="success">
						<th><input type="checkbox"/>全选</th>
						<th>状态</th>
						<th>收件人</th>
						<th>主题</th>
						<th>正文</th>
						<th>时间（向下）</th>
					</tr>
					<c:forEach items="${page.listMessage}" var="message">
						<tr>
							<td><input type="checkbox" name="id" value="${message.id}"/></td>
							<c:choose>
								<c:when test="${message.ifAccept==1}">
									<td><img src="img/sms_unReaded.png" alt="" /></td>
								</c:when>
								<c:otherwise>
									<td><img src="img/sms_readed.png" alt="" /></td>
								</c:otherwise>
							</c:choose>
							<td>
								<a href="/messageDetail?id=${message.id}">
								${message.sendUser.username}</a>
							</td>
							<td>${message.theme}</td>
							<c:choose>
								<c:when test="${fn:length(message.content)>8}">
									<td>${fn:substring(message.content,0,2)}......</td>
								</c:when>
								<c:otherwise>
									<td>${message.content}</td>
								</c:otherwise>
							</c:choose>
							<td>${message.sendTime}</td>
						</tr>
					</c:forEach>
				</table>
			</form>

			<%--<div id="divPage">--%>
			<%--<nav aria-label="Page navigation" >--%>
				<%--<ul class="pagination">--%>
					<%--<li class="disabled"><a href="#" aria-label="Previous"> <span--%>
							<%--aria-hidden="true">&laquo;</span>--%>
					<%--</a></li>--%>
					<%--<li class="active"><a href="#">1</a></li>--%>
					<%--<li><a href="#">2</a></li>--%>
					<%--<li><a href="#">3</a></li>--%>
					<%--<li><a href="#">4</a></li>--%>
					<%--<li><a href="#">5</a></li>--%>
					<%--<li><a href="#" aria-label="Next"> <span--%>
							<%--aria-hidden="true">&raquo;</span>--%>
					<%--</a></li>--%>
				<%--</ul>--%>
			<%--</nav>--%>
			<%--</div>--%>

		</div>

	</div>
	<!-- /container -->
<%@include file="include/bottom.jsp" %>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/messageList.js"></script>
</body>
</html>
