<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action="/signup" method="POST">
		<label>ID : </label>
		<input type="text" name="mId" placeholder="User ID">
		
		<label>Password : </label>
		<input type="password" name="mPw" placeholder="Password">
		
		<input type="submit" value="등록">
	</form>
</body>
</html>