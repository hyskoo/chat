<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">

// After Page loading
$(function(){
	
	$('#submitBtn').click(function(event){
		event.preventDefault(); //이벤트 초기화

		var id = $('#mId').val();
		var pw = $('#mPw').val();
		
		if($('#mId').val() == ''){
			alert('아이디를 입력해주세요');
			$('#mId').focus();
			return false;
		} else if($('#mPw').val() == ''){
			alert('비밀번호를 입력해주세요');
			$('#mPw').focus();
			return false;
		} else {

			$.ajax({
				url : '/login',
				type : 'POST',
				data : {
					mId : id,
					mPw : pw
				},
				success : function(data){
					if(data == 1) {
						alert("로그인성공");
						location.href='/';
					} else {
						alert("ID or Password are different");
						$("#mId").val("");
						$("#mPw").val("");
						$('#mId').focus();
					}
				},
				error : function(error){
					console.log(error);
				}
				
			});	
		}
	});
});


</script>
</head>
<body>
	<h1>로그인</h1>
	<form action="/login" method="POST">
		<label>ID : </label>
		<input type="text" name="mId" id="mId" placeholder="User ID">
		
		<label>Password : </label>
		<input type="password" name="mPw" id="mPw" placeholder="Password">
		
		<input type="submit" value="등록" id="submitBtn">
	</form>
</body>
</html>