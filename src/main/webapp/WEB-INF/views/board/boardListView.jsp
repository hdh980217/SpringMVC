<%@page import="Pack.dto.UserDTO"%>
<%@page import="Pack.dto.BoardDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String name = (String)session.getAttribute("name");
		String id = (String)session.getAttribute("id");
		if (name != null) 
			out.println(name + "님(" + id + ") 접속중 <a href='/'>로그아웃</a>");
		else  
			out.println("<a href='/'>로그인 하러 가기</a>");
		
		@SuppressWarnings("unchecked")
		List<BoardDTO> list = (List<BoardDTO>)request.getAttribute("list");
	%>
	<h1>게시판 목록</h1>
	<table border='1'>
	<tr>
		<td>번호</td>
		<td>제목</td>
		<td>내용</td>		
		<td>작성자</td>		
		<td>날짜</td>		
	</tr>
	<% for (int i = 0; i < list.size(); i++) { 
		BoardDTO board = list.get(i);
	%>		
		<tr>
			<td><%= i + 1 %></td>			
			<td><a href='boardDetail/<%=board.getBoardNo()%>'><%= board.getTitle() %></a></td>			
			<td><%= board.getContents() %></td>
			<td><%= board.getName() %></td>		
			<td><%= board.getDate() %></td>		
		</tr>	
	<%	}  %>
	</table>
	
	<% if (name != null) { %>
		<a href='newBoard'>게시글 작성</a>
	<% } %>
</body>
</html>