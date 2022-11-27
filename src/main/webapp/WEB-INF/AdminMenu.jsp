<%@page import="token.TokenBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者メニュー</title>

<style type="text/css">
<%@include file="/WEB-INF/admin_menu.css"%>
</style>
</head>
<body>
	<h1>管理者メニュー</h1><br>
	<div class="box">
	<form action="ToAddSpotsServlet" method="post">
	<input type="submit" value="観光地追加"></form><br>
	<form action="ToSpotsUpdateServlet" method="post">
	<input type="submit" value="観光地情報変更"></form><br>
	<form action="ToUserInfoUpdateForAdminServlet" method="post">
	<input type="submit" value="ユーザー情報変更"></form><br>
	<form action="ToFeedBackServlet" method="post">
	<input type="submit" value="フィードバック確認"></form><br>
	<form action="ToAddNewsServlet" method="post">
	<input type="submit" value="お知らせ追加"></form><br>
	<form action="NewsCheck" method="post">
	<input type="submit" value="お知らせ確認"></form><br>
	<form action="LogoutServlet" method="post">
	<input type="submit" value="ログアウト"></form><br>
	</div>
</body>
</html>