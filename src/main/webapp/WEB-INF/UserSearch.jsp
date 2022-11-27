<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー情報変更</title>
<style type="text/css">
<%@include file="/WEB-INF/usersearch.css"%>
</style>
</head>
<body>
	<h1>ユーザー情報変更</h1>
	<form action="UserSearchServlet" method="post">
	<div class="box">
	<p>ユーザーID<input type="text" name="id"><br></div>
	<input type="submit" value="検索">
	<input type="reset" value="リセット">
	</form><br>
	<div class="modoru"><form action="ToAdminMenuServlet" method="post">
	<input type="submit" value="メニューへ戻る">
	</form></div>
</body>
</html>