<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>観光地情報変更画面</title>
<style type="text/css">
<%@include file="/WEB-INF/spotsupdate.css"%>
</style>
</head>
<body>
	<h1>観光地情報変更画面</h1><br>
	<form action="SpotsUpdateSearchServlet" method="post">
	<div class="box">
	<p>検索<input type="text" name="search" required="required"><br>
	<p>検索する条件</p><select name="way">
	<option value="id">ID</option>
	<option value="name">観光地名称</option>
	</select><br>
	</div>
	<input type="submit" value="検索">
	</form><br>
	<form action="ToAdminMenuServlet" method="post">
	<input type="submit" value="メニューへ戻る">
	</form><br>
</body>
</html>