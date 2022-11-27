<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>観光地情報変更画面</title>
<style type="text/css">
<%@include file="/WEB-INF/spotsupdatecomplete.css"%>
</style>
</head>
<body>
	<h1>観光地情報変更画面</h1>
	<h2>変更が完了しました。</h2>
	<form action="ToSelectSpotsUpdateServlet" method="post">
	<input type="submit" value="変更画面へ戻る">
	</form><br>
	<form action="ToSpotsUpdateServlet" method="post">
	<input type="submit" value="別の観光地を変更する">
	</form><br>
	<form action="ToAdminMenuServlet" method="post">
	<input type="submit" value="メニューへ戻る">
	</form><br>
</body>
</html>