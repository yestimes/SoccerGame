<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"> 
<link href="css/style.css"
	rel="stylesheet" media="screen">
</head>

<!-- 页面的顶部 -->
<c:import url="c_title_audience.jsp"/>
<!-- 页面的菜单 -->
<c:import url="c_menu_audience.jsp"/>
<!-- 页面主体 -->
<div id="section">
	<form action="<c:url value="/deleteComments"/>" method="post">
	<table class="table table-striped table-hover">
		<tr><th>内容</th><th>日期</th><th>操作</th></tr>
		<c:forEach items="${list}" var="data" varStatus="status">
			<tr><td>${data.content}</td><td>${data.time}</td>
			<td><a href="deleteComments?id=${data.id}">删除</a></td></tr>
		</c:forEach>
		<tr><td colspan="3"><input type="button" onclick="nextPage()" value="下一页"/>&nbsp;&nbsp;
		<input type="button" onclick="lastPage()" value="上一页"/>&nbsp;&nbsp;第${page}页，共计${count}条评论，共${maxPage}页&nbsp;&nbsp;&nbsp;&nbsp;跳转至第
		<input type="text" id="page" name="page" style="width:50px;"/>页
		<input type="button" value="跳" onclick="jump()" /></td></tr>
	</table>
	</form>
</div>

<script type="text/javascript">
function nextPage(){
	if(${list.size()}==5)
		location.href='/soccer/nextPageAudienceComments';
}
function lastPage(){
	location.href='/soccer/lastPageAudienceComments';
}
function jump(){
	var page = document.getElementById("page").value;
	if(page>${maxPage}) page=${maxPage};
		location.href='/soccer/jumpAudienceComments?page='+page;
}
</script>


<!-- 页面的脚部 -->
<c:import url="../c_footer.jsp"/>