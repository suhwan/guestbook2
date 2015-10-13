<%@page import="com.bit2015.guestbook.test.GuestBookTest"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bit2015.guestbook.dao.GuestBookDao"%>
<%@page import="com.bit2015.guestbook.vo.GuestBookVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	
	List<GuestBookVo> list = (List<GuestBookVo>)request.getAttribute("list");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="/guestbook2/gb?a=insert" method="post">
	<table border=1 width=500>
		<tr>
			<td>이름</td><td><input type="text" name="name"></td>
			<td>비밀번호</td><td><input type="password" name="pass"></td>
		</tr>
		<tr>
			<td colspan=4><textarea name="content" cols=60 rows=5></textarea></td>
		</tr>
		<tr>
			<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
		</tr>
	</table>
	</form>
	<br>
	<%-- <% for(int i =0; i < list.size(); i++){ %>
	<table width=510 border=1>
		<tr>
			<td><%= i + 1 %></td>
			<td><%= list.get(i).getName() %></td>
			<td><%= list.get(i).getRegDate() %></td>
			<td><a href="deleteform.jsp?no=<%= list.get(i).getNo() %>">삭제</a></td>
		</tr>
		<tr>
			<td colspan=4><%= list.get(i).getMessage().replaceAll("\n",	"<br>") %></td>
		</tr>
	</table>
	<% } %> --%>
	<%
	int countTotal =list.size();
	int index = 0;
	for(GuestBookVo vo : list){ %>
	<table width=510 border=1>
		<tr>
			<td><%= countTotal-index++ %></td>
			<td><%= vo.getName() %></td>
			<td><%= vo.getRegDate() %></td>
			<td>
			<%-- <a href="/guestbook2/gb?a=deleteform&no=<%= vo.getNo() %>">삭제</a> --%>
			<form action="/guestbook2/gb" method="post">
				<input type="hidden" name="a" value="deleteform">
				<input type="hidden" name="no" value="<%= vo.getNo() %>">
				<input type="submit" value="삭제">
			</form>
			</td>
		</tr>
		<tr>
			<td colspan=4><%= vo.getMessage().replaceAll("\n",	"<br>") %></td>
		</tr>
	</table>
	<% } %>
</body>
</html>