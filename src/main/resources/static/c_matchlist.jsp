<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- 页面主体 -->
<div id="section">
	<table class="table table-striped table-hover">
		<tr><th>序号</th><th>主场队伍</th><th>客场队伍</th><th>主场进球</th><th>客场进球</th><th>开始时间</th></tr>
		<c:forEach items="${list}" var="data" varStatus="status">
			<tr><td>${status.index+1}</td><td>${map.get(data.team1)}</td><td>${map.get(data.team2)}</td><td>${data.in1}</td><td>${data.in2}</td><td>${data.startTime}</td></tr>
		</c:forEach>
	</table>
</div>