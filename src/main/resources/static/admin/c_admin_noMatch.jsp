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
	<div id="bt">
		<h2>没有正在进行的比赛</h2>
		<input type="button" onclick="showList()" value="新建比赛" style="width:150px; height:80px; font-size:30px; margin:50px"/>
	</div>
	<form action="<c:url value="/c_admin_addMatch"/>" method="post" name="frm">
	<div class="container" id="addList" style="display: none">
		<table class="matchtable">
		<tr><td>主场球队</td>
		<td><select name="team1" id="team1" style="font-size:30px">
		<c:forEach items="${list}" var="data" varStatus="status">
			<option value="${data.id}">${data.name}</option>
		</c:forEach>
		</select></td></tr>
		<tr><td>客场球队</td>
		<td><select name="team2" id="team2" style="font-size:30px">
		<c:forEach items="${list}" var="data" varStatus="status">
			<option value="${data.id}">${data.name}</option>
		</c:forEach>
		</select></td></tr>
		<tr><td>时间</td><td><input type="text" name="time" id="time" value="${time}" style="font-size:30px" readonly/></td></tr>
		<tr><td><input type="button" onclick="add()" value="确定" style="font-size:30px" /></td></tr>
		</table>
	</div>
	</form>
</div>
<script type="text/javascript">
function showList() {
	document.getElementById("bt").style.display = "none";
	document.getElementById("addList").style.display = "block";
}
function add() {
	var team1 = document.getElementById("team1");
	var team2 = document.getElementById("team2");
	if(team1.value == team2.value){ 
		alert("比赛双方不能相同");
		return false;
	}
	document.frm.submit();
}
</script>

<!-- 页面的脚部 -->
<c:import url="../c_footer.jsp"/>