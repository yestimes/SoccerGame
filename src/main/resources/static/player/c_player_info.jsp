<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<link href="css/style.css"
	rel="stylesheet" media="screen">
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<!-- 页面的首部 -->
<c:import url="c_title_player.jsp"/>
<!-- 页面的菜单 -->
<c:import url="c_menu_player.jsp"/>
<!-- 页面主体 -->
<div id="section">
	<form  name="frm" action="<c:url value="/updatePlayer"/>" method="post">
	<div class="input-group input-group-lg">
			<span class="input-group-addon" style="width:100px"><span class="glyphicon glyphicon-user" style="color: rgb(212, 106, 64);">账号</span></span>
			<input type="text" class="form-control" name="username" id="username" value="${username}" >
	</div><br>
	
	<div class="input-group input-group-lg">
			<span class="input-group-addon" style="width:100px"><span class="glyphicon glyphicon-leaf" style="color: rgb(212, 106, 64);">姓名</span></span>
			<input type="text" class="form-control" name="realname" id="realname" value="${realname}">
	</div><br>
	
	<div class="input-group input-group-lg">
			<span class="input-group-addon" style="width:100px"><span class="glyphicon glyphicon-phone-alt" style="color: rgb(212, 106, 64);">电话</span></span>
			<input type="text" class="form-control" name="tel" id="tel" value="${tel}" >
	</div><br>
	
	<input type="button" onclick="check()" value="修改" style="width:50px"/>
	
	<table class="infotable">
		<tr  style="visibility:hidden"><td>用户id</td>
		<td><input type="text" name="id" value="${id}"></td></tr>
	</table>
	</form>
</div>


<!-- 页面的脚部 -->
<c:import url="../c_footer.jsp"/>

<script type="text/javascript">
function check() {
	var name = document.getElementById("username");
	var tel = document.getElementById("tel");
	var realname = document.getElementById("realname");
	if((name.value.length<2)||(name.value.length>10)){ 
		alert("用户名长度需在2-10字符");
		return false;
	}
	if (!((/^0?1[3|4|5|7|8][0-9]\d{8}$/.test(tel.value))||(/^0[\d]{2,3}-[\d]{7,8}$/.test(tel.value)))) {
		alert('电话格式不正确');
		(tel).focus();
		return false;
	}
	 if (!realname.value.match(/^[\u4e00-\u9fa5]{2,5}$/)){
		alert("姓名格式不正确");
		return false;
	}
	document.frm.submit();
}
</script>