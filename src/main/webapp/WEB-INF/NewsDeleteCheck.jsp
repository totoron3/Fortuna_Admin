<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お知らせ確認</title>
<style type="text/css">
<%@include file="/WEB-INF/newsdeletecheck.css"%>
</style>
</head>
<body>
	<h1>お知らせ確認</h1>
	<h2>お知らせ削除</h2>
	<br>
	<jsp:useBean id="selectNews" class="bean.NewsBean" scope="session"/>
	<div class="box"><table border="1">
	<tr>
		<td id="td">ID</td><td><%=selectNews.getId() %></td>
	</tr>
	<tr>
		<td id="td">カテゴリー</td><td><%=selectNews.getCat() %></td>
	</tr>
	<tr>
		<td id="td">日付</td><td><%=selectNews.getDate() %></td>
	</tr>
	<tr>
		<td id="td">タイトル</td><td><%=selectNews.getTitle() %></td>
	</tr>
	<tr>
		<td id="td">本文</td><td><%=selectNews.getMain() %></td>
	</tr>
	</table></div><br>
	<p>本当に削除しますか?
	<form action="NewsDeteleFinal" method="post">
	<input type="hidden" name="id" value="<%=selectNews.getId() %>">
	<input type="submit" value="削除する">
	</form><br>
	
	<form action="NewsCheck" method="post">
	<input type="submit" value="お知らせ一覧へ戻る"></form><br>
	
	<form action="ToAdminMenuServlet" method="post">
	<input type="submit" value="メニューへ戻る">
	</form><br>
</body>
</html>