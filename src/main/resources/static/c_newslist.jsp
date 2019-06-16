<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"> 
<link href="css/style.css"
	rel="stylesheet" media="screen">

<div id="section">
	
	<table class="table table-striped table-hover" id="news">
		<tr><td>序号</td><td>标题</td><td>日期</td></tr>
		<c:forEach items="${list}" var="data" varStatus="status">
			<tr style="max-height:10"><td>${status.index+1}</td><td><a href="${data.url}" target="_blank">${data.content}</a></td><td>${data.date}</td></tr>
		</c:forEach>
	</table>
</div>
