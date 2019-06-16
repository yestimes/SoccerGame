<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>足球联赛管理系统</title> 
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"> 
<link href="css/style.css"
	rel="stylesheet" media="screen">
</head>
<body>

<!-- 欢迎用户 -->
 <form action="<c:url value="/admin_logout"/>" method="post">
<div class = "user">
	<div>欢迎您，${admin.username}&nbsp;&nbsp;&nbsp;&nbsp;
	<input type= "submit" value="登出" style="width:80px; height:50px; font-size:20px"/></div>
</div>
</form>
<hr>

