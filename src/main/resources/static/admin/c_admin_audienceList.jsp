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
	<table class="table table-striped table-hover">
		<tr><td>序号</td><td>用户名</td><td>电话</td><td>评论数量</td></tr>
		<c:forEach items="${list}" var="data" varStatus="status">
			<tr><td>${status.index+1}</td><td>${data.username}</td><td>${data.tel}</td>
			<td>${map.get(data.id)}</td></tr>
		</c:forEach>
	</table>
</div>


<!-- 页面的脚部 -->
<c:import url="../c_footer.jsp"/>