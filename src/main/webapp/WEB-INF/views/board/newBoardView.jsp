<%@page import="Pack.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% int userNo = (int)session.getAttribute("userNo"); %>
	<h1>게시글 작성</h1>
	<form method="post" action="newBoard">
		<label>제목</label>
		<input type="text" name="title"/><br/>
		<label>내용</label>
		<input type="text" name="contents"/><br/>
		<input type="hidden" name="userNo" value="<%=userNo%>"/><br/>
		<input type="submit" value="작성"/>		 
	</form>
	<a href='boardList'>목록으로</a>
</body>
</html>