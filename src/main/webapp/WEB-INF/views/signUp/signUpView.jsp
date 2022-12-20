<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 가입</h1>
	<form method="post" action="signUp">
		<label>이름</label>
		<input type="text" name="name"/><br/>
		<label>아이디</label>
		<input type="text" name="id"/><br/>
		<label>비밀번호</label>
		<input type="text" name="pw"/><br/>
		<input type="submit" value="회원가입"/>		 
	</form>
	<a href="/">처음으로</a>
</body>
</html>