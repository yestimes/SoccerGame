<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"> 
<link href="css/style.css"
	rel="stylesheet" media="screen">
</head>
<!-- 页面的首部 -->
<c:import url="c_title_coach.jsp"/>
<!-- 页面的菜单 -->
<c:import url="c_menu_coach.jsp"/>

<!-- 页面主体 -->
<div id="section">
	<h2>欢迎您，${coach.username}</h2>
	
</div>


<!-- 页面的脚部 -->
<c:import url="../c_footer.jsp"/>