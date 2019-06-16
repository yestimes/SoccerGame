<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"> 
<link href="css/style.css"
	rel="stylesheet" media="screen">

</head>
<!-- 页面的首部 -->
<c:import url="c_title_audience.jsp"/>
<!-- 页面的菜单 -->
<c:import url="c_menu_audience.jsp"/>
<!-- 页面主体 -->
<div id="section">
<table style="border:0px;width:100%;">
	<tr><td>
	<table  id="matchtable" >
		<tr style="visibility:hidden"><td>比赛id</td>
		<td><input type="text" name="id" value="${Match.id}"></td></tr>
		<tr><td>主场队伍</td>
		<td>${team1}</td></tr>
		<tr><td>客场队伍</td>
		<td>${team2}</td></tr>
		<tr><td>主场进球</td>
		<td>${match.in1}</td></tr>
		<tr><td>客场进球</td>
		<td>${match.in2}</td></tr>
		<tr><td>开始时间</td>
		<td>${match.startTime}</td></tr>
	</table></td><td style="vertical-align:top;" rowspan="2">
	<table id="right"  class="table table-striped table-hover" style="min-width:500px;">
		<tr><td colspan="3">评论列表：</td></tr>
		<tr><td>用户</td><td>内容</td><td>时间</td></tr>
		<c:forEach items="${list}" var="com" varStatus="status">
			<tr><td>${map.get(com.audienceId)}</td><td>${com.content}</td><td>${com.time}</td></tr>
		</c:forEach>
		<tr><td colspan="3"><input type="button" onclick="nextPage()" value="下一页"/>&nbsp;&nbsp;
		<input type="button" onclick="lastPage()" value="上一页"/></td></tr>
	</table>
	</td></tr><tr><td>
	<form name="frm" action="<c:url value="/addComments"/>" method="post">
	<div>
		<textarea rows="3" cols="20" style="font-size:20px; min-width:400px" id="editor1"></textarea>
		<input type="hidden" name="mycomments" id="valueNode" value="${mycomments}"/>
		<input type="button" onclick="al()" value="提交评论"/>
	</div>
	</form>
	</td></tr>
	</table>
</div>
<script type="text/javascript">
function al() {
	var str = document.getElementById("editor1").value;
	document.getElementById("valueNode").value = str;
	if((str.length<1) || (str.length>20)){
		alert("评论内容需为1到20字");
		return false;
	}
	document.frm.submit();
}
function nextPage(){
	if(${list.size()}==5)
		location.href='/soccer/nextPageMatchComments';
}
function lastPage(){
	location.href='/soccer/lastPageMatchComments';
}
</script>

<!-- 页面的脚部 -->
<c:import url="../c_footer.jsp"/>