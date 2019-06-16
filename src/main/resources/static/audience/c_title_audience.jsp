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

<div id="header" >
<form action="<c:url value="/audience_logout"/>" method="post">
	<div style="position:absolute; top:90px;left:155px">
	<label style="font-size:20px">Welcome, Audience ${audience.username} ...</label>
	<input type= "submit" value="登出" style="width:80px; height:35px; font-size:20px; margin:25px"/>
	</div>
</form>
</div>
</body>
</html>
