<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% boolean result = (boolean)request.getAttribute("result"); %>
	<h1><%= result ? "회원가입 성공" : "회원가입 실패" %></h1>
	<a href="/">처음으로</a>
</body>
</html>