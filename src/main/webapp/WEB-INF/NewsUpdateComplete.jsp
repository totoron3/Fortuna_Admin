<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お知らせ確認</title>
<style type="text/css">
<%@include file="/WEB-INF/newsupdatecomplete.css"%>
</style>
</head>
<body>
	<h1>お知らせ確認</h1>
	<h2>お知らせ変更(更新)</h2>
	<br>
	<p>お知らせを変更しました。
	<form action="NewsCheck" method="post">
	<input type="submit" value="お知らせ一覧へ戻る"></form><br>
	
	<form action="ToAdminMenuServlet" method="post">
	<input type="submit" value="メニューへ戻る"></form>
</body>
</html>