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
	<%
		UserDTO user = (UserDTO)request.getAttribute("user");
			if (user == null) {
		out.println("<h1>로그인 실패</h1>");
			} else {
		out.println("<h1>로그인 성공</h1>");
		session.setAttribute("userNo", user.getUserNo());
		session.setAttribute("name", user.getName());
		session.setAttribute("id", user.getId());
		response.sendRedirect("boardList");
			}
	%>
	<a href="/">처음으로</a>
</body>
</html>