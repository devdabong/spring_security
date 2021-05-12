<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>
</head>
<body>
	<h2>로그인 성공</h2>
	이름 : ${sessionScope.userLoginInfo.username} 
	<a href="logout">로그아웃</a>
	<a href="page1">페이지1</a>
</body>
</html>