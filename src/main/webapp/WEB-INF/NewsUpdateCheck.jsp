<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お知らせ確認</title>
<style type="text/css">
<%@include file="/WEB-INF/newsupdatecheck.css"%>
</style>
</head>
<body>
	<h1>お知らせ確認</h1>
	<h2>お知らせ変更(更新)</h2><br>
	<jsp:useBean id="selectNews" class="bean.NewsBean" scope="session"/>
	<jsp:useBean id="cNews" class="bean.NewsBean" scope="session"/>
	
	<div class="box"><table border="1">
	<tr><td></td><td>変更前</td><td>変更後</td></tr>
	<tr><td id="td">ID</td><td><%=selectNews.getId() %></td><td><%=cNews.getId() %></td></tr>
	<tr><td id="td">カテゴリー</td><td><%=selectNews.getCat() %></td><td><%=cNews.getCat() %></td></tr>
	<tr><td id="td">タイトル</td><td><%=selectNews.getTitle() %></td><td><%=cNews.getTitle() %></td></tr>
	<tr><td id="td">本文</td><td><%=selectNews.getMain() %></td><td><%=cNews.getMain() %></td></tr>
	<tr><td id="td">日付</td><td><%=selectNews.getDate() %></td><td><%=cNews.getDate() %></td></tr>
	</table></div><br>
	
	<p>更新しますか?
	<form action="NewsUpdateFinal" method="post">
	<input type="submit" value="更新"></form><br>
	
	<form action="NewsCheck" method="post">
	<input type="submit" value="お知らせ一覧へ戻る"></form><br>
	
	<form action="ToAdminMenuServlet" method="post">
	<input type="submit" value="メニューへ戻る"></form><br>
</body>
</html>