<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"> 
<link href="css/style.css"
	rel="stylesheet" media="screen">
</head>
<!-- 页面的首部 -->
<c:import url="c_title_admin.jsp"/>
<!-- 页面的菜单 -->
<c:import url="c_menu_admin.jsp"/>

<!-- 页面主体 -->
<div id="section">
	<form action="<c:url value="/deleteComments"/>" method="post">
	<table class="table table-striped table-hover">
		<tr><td colspan="4">评论列表：</td></tr>
		<tr><td>用户</td><td>内容</td><td>时间</td><th>操作</th></tr>
		<c:forEach items="${list}" var="data" varStatus="status">
			<tr><td>${map.get(data.audienceId)}</td><td>${data.content}</td><td>${data.time}</td>
			<td><a href="adminDeleteComments?id=${data.id}">删除</a></td></tr>
		</c:forEach>
	</table>
	</form>
</div>


<!-- 页面的脚部 -->
<c:import url="../c_footer.jsp"/>