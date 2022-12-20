<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 	session.invalidate(); %>
	<h1>로그인</h1>
	<form method="post" action="login">
		<label>아이디</label>
		<input type="text" name="id"/><br/>
		<label>비밀번호</label>
		<input type="text" name="pw"/><br/>
		<input type="submit" value="로그인"/>		 
	</form>
	<a href="signUp">회원가입</a><br/>
	<a href="boardList">게시판</a><br/>
</body>
</html>