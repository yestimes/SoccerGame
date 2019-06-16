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
<table style="border:0px;width:100%;">
	<tr><td>
	<form action="<c:url value="/c_admin_endMatch"/>" method="post">
	<table id="matchtable" >
		<tr  style="visibility:hidden"><td>比赛id</td>
		<td><input type="text" name="matchId" id="matchId" value="${match.id}"></td></tr>
		<tr><td>主场队伍</td>
		<td>${team1}</td></tr>
		<tr><td>客场队伍</td>
		<td>${team2}</td></tr>
		<tr><td>主场进球</td>
		<td><input type="text" name="in1" id="in1" value="${match.in1}" style="font-size:20px" readonly/>&nbsp;&nbsp;
		<input type="button" value="+1" style="font-size:20px" onclick="add1()"></td></tr>
		<tr><td>客场进球</td>
		<td><input type="text" name="in2" id="in2" value="${match.in2}" style="font-size:20px" readonly/>&nbsp;&nbsp;
		<input type="button" value="+1" style="font-size:20px" onclick="add2()"></td></tr>
		<tr><td>开始时间</td>
		<td>${match.startTime}</td></tr>
		<tr><td><input type="submit" value="比赛结束" style="font-size:35px;"/></td></tr>
	</table></form>
	</td><td style="vertical-align:top;" rowspan="2">
	<table id="right" class="table table-striped table-hover">
		<tr><td colspan="3">评论列表：</td></tr>
		<tr><td>用户</td><td>内容</td><td>时间</td></tr>
		<c:forEach items="${list}" var="com" varStatus="status">
			<tr><td>${map.get(com.audienceId)}</td><td>${com.content}</td><td>${com.time}</td></tr>
		</c:forEach>
	</table>
	</tr>
	</table>
</div>
<script type="text/javascript">
function add1() {
	if(confirm('请确认进球'))
		location.href='/soccer/c_admin_addScore?matchId='+${match.id}+'&team=1';
	return ;
}

function add2() {
	if(confirm('请确认进球'))
		location.href='/soccer/c_admin_addScore?matchId='+${match.id}+'&team=2';
	return ;
}
</script>

<!-- 页面的脚部 -->
<c:import url="../c_footer.jsp"/>