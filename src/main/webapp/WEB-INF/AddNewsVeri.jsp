<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お知らせ追加</title>
<style type="text/css">
<%@include file="/WEB-INF/addnewsveri.css"%>
</style>
</head>
<body>
	<jsp:useBean id="anBean" class="bean.AddNewsBean" scope="session"/>
	<h1>お知らせ追加</h1>
	<br>
	<div class="box"><table border="1">
	<tr><td>ID</td><td><%=anBean.getId() %></td></tr>
	<tr><td>カテゴリー</td><td><%=anBean.getCat() %></td></tr>
	<tr><td>タイトル</td><td><%=anBean.getTitle() %></td></tr>
	<tr><td>本文</td><td><%=anBean.getMain() %></td></tr>
	<tr><td>日付</td><td><%=anBean.getDate() %></td></tr>
	</table><br></div>
	<form action="AddNewsFinalServlet" method="post">
	<input type="submit" value="お知らせを追加する"></form><br>
	<form action="ToAdminMenuServlet" method="post">
	<input type="submit" value="メニューへ戻る">
	</form><br>
</body>
</html>