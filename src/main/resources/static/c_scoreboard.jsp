<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css"
	rel="stylesheet" media="screen">
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>


<!-- 页面主体 -->
<div id="section">

<div class="btn-group" style="margin:0px 0px 0px 12px">
	<button type="button" class="btn btn-default" style="width:95px" onclick="jifen()">球队积分榜</button>
	<button type="button" class="btn btn-default" style="width:95px" onclick="jinqiu()">球员进球榜</button>
	<button type="button" class="btn btn-default" style="width:95px" onclick="zhugong()">球员助攻榜</button>
    <p>&nbsp;</p>
</div>


<!-- 球队积分榜 -->
<div class="container" id="jifen" style="display: block">
	<table class="table table-striped table-hover" style="width:950px">
		<tr><th>排名</th><th>队伍</th><th>比赛次数</th><th>胜场(+3分)</th><th>平局(+1分)</th><th>得分</th></tr>
		<c:forEach items="${score}" var="data" varStatus="status">
			<tr><td>${status.index+1}</td><td>${data.name}</td>
			<td>${data.matchTimes}</td><td>${data.winTimes}</td>
			<td>${data.tieTimes}</td><td>${data.score}</td></tr>
		</c:forEach>
	</table>
</div>


<!-- 球员进球榜 -->
<div class="container" id="jinqiu" style="display: none">
	<table class="table table-striped table-hover">
	<tr><th>排名</th><th>姓名</th><th>队伍</th><th>位置</th><th>进球</th><th>助攻</th></tr>
		<c:forEach items="${goal}" var="player1" varStatus="status">
			<tr><td>${status.index+1}</td><td>${player1.realname}</td>
			<td>${map.get(player1.teamId)}</td><td>${player1.position}</td>
			<td>${player1.goal}</td><td>${player1.secAttack}</td></tr>
		</c:forEach>
	</table>
</div>


<!-- 球员助攻榜 -->
<div class="container" id="zhugong" style="display: none">
	<table class="table table-striped table-hover">
	<tr><th>排名</th><th>姓名</th><th>队伍</th><th>位置</th><th>进球</th><th>助攻</th></tr>
		<c:forEach items="${secAttack}" var="player2" varStatus="status">
			<tr><td>${status.index+1}</td><td>${player2.realname}</td>
			<td>${map.get(player2.teamId)}</td><td>${player2.position}</td>
			<td>${player2.goal}</td><td>${player2.secAttack}</td></tr>
		</c:forEach>
	</table>
</div>
</div>

<script type="text/javascript">
function jifen(){
	var jifen = document.getElementById("jifen").style.display;
	var jinqiu = document.getElementById("jinqiu").style.display;
	document.getElementById("jinqiu").style.display = "none";
	document.getElementById("zhugong").style.display = "none";
	if (jifen == "block") {
		document.getElementById("jifen").style.display = "none";
	} else {
	document.getElementById("jifen").style.display = "block";
	}
}

function jinqiu(){
	var jifen = document.getElementById("jifen").style.display;
	var jinqiu = document.getElementById("jinqiu").style.display;
	var zhugong = document.getElementById("zhugong").style.display;
	document.getElementById("jifen").style.display = "none";
	document.getElementById("zhugong").style.display = "none";
	if (jinqiu == "block") {
		document.getElementById("jinqiu").style.display = "none";
	} else {
		document.getElementById("jinqiu").style.display = "block";
	}
}

function zhugong(){
	var jifen = document.getElementById("jifen").style.display;
	var jinqiu = document.getElementById("jinqiu").style.display;
	var zhugong = document.getElementById("zhugong").style.display;
	document.getElementById("jifen").style.display = "none";
	document.getElementById("jinqiu").style.display = "none";
	if (zhugong == "block") {
		document.getElementById("zhugong").style.display = "none";
	} else {
		document.getElementById("zhugong").style.display = "block";
	}
}
</script>
