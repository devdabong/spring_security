<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h1>로그인 페이지</h1>
	<c:forEach var="user" items="${userList }">
		<c:out value="${user.userId }" />
	</c:forEach>
	<%-- <h1>로그인 페이지</h1>
	<h1>Login Page</h1> 
	<h2>${resultCode}</h2> 
	<form> 
	<form action="${pageContext.request.contextPath}/login/login" method="post">
		<div> <input type="text" name="uid" /> </div> 
		<div> <input type="password" name="upw" /> </div> 
		<div> <input type="submit"/> </div> 
	</form>   --%>
  
</body>
</html>