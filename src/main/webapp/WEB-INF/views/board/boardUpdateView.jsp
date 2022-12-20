<%@page import="Pack.dto.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% BoardDTO board = (BoardDTO)request.getAttribute("board"); %>
	<h1>게시글 수정</h1>
	<form method="post" action="/updateBoard">
		<label>제목</label>
		<input type="text" name="title" value="<%=board.getTitle()%>"/><br/>
		<label>내용</label>
		<input type="text" name="contents" value="<%=board.getContents()%>"/><br/>
		<input type="hidden" name="boardNo" value="<%=board.getBoardNo()%>"/><br/>
		<input type="submit" value="수정"/>		 
	</form>
</body>
</html>