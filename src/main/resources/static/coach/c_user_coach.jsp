<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>足球联赛管理系统</title> 
<link href="resources/css/style.css" rel="stylesheet" type="text/css" /> 
</head>
<body>

<!-- 欢迎用户 -->
 <form action="<c:url value="/coach_logout"/>" method="post">
<div class = "user">
	<div>欢迎您，${coach.username}&nbsp;&nbsp;&nbsp;&nbsp;
	<input type= "submit" value="退出" style="width:80px; height:50px; font-size:20px"/></div>
</div>
</form>
<hr>

