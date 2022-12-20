<%@page import="Pack.dto.UserDTO"%>
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
	<h1>게시글</h1>
	<% 
		BoardDTO board = (BoardDTO)request.getAttribute("board");
		String id = (String)session.getAttribute("id");
		if (id != null)
			out.println((board.getId().equals(id)) ? 
					"<a href='/updateBoard/" + board.getBoardNo() + 
					"'>수정</a> <a href='/deleteBoard/" + board.getBoardNo() + "'>삭제</a>" : "");
	%>
	<table border='1'>
	<tr>
		<td>작성자</td>
		<td><%= board.getName() %>(<%= board.getId() %>)</td>
	</tr>
	<tr>
		<td>제목</td>
		<td><%= board.getTitle() %></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><%= board.getContents() %></td>
	</tr>
	<tr>
		<td>작성 일자</td>
		<td><%= board.getDate() %></td>
	</tr>
</table>
	<a href='/boardList'>목록으로</a>
</body>
</html>