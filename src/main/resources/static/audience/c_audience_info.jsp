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
	<form  name="frm" action="<c:url value="/updateAudience"/>" method="post">
	<table id="infotable">
		<tr  style="visibility:hidden"><td>用户id</td>
		<td><input type="text" name="id" value="${id}"></td></tr>
		<tr><td>用户名</td>
		<td><input type="text" name="username" id="username" value="${username}"></td></tr>
		<tr><td>电话</td>
		<td><input type="text" name="tel"  id="tel" value="${tel}"></td></tr>
		<tr><td><input type="button" onclick="check()" value="修改"/></td></tr>
	</table>
	</form>
</div>


<!-- 页面的脚部 -->
<c:import url="../c_footer.jsp"/>

<script type="text/javascript">
function check() {
	var name = document.getElementById("username");
	var tel = document.getElementById("tel");
	if((name.value.length<2)||(name.value.length>10)){ 
		alert("用户名长度需在2-10字符");
		return false;
	}
	if (!((/^0?1[3|4|5|7|8][0-9]\d{8}$/.test(tel.value))||(/^0[\d]{2,3}-[\d]{7,8}$/.test(tel.value)))) {
		alert('电话格式不正确');
		(tel).focus();
		return false;
	}
	document.frm.submit();
}
</script>