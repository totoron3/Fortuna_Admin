<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー情報変更</title>
<style type="text/css">
<%@include file="/WEB-INF/userupdatecomplete.css"%>
</style>
</head>
<body>
	<h1>ユーザー情報変更</h1>
	<h2>ユーザー情報を変更しました。</h2>
	<form action="ToUserInfoUpdateServlet" method="post">
	<input type="submit" value="変更画面へ戻る">
	</form><br>
	<form action="ToAdminMenuServlet" method="post">
	<input type="submit" value="メニューへ戻る">
	</form><br>
	
</body>
</html>