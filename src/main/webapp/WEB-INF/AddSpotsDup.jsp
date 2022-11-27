<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>観光地追加画面</title>
<style type="text/css">
<%@include file="/WEB-INF/addspotsdup.css"%>
</style>
</head>
<body>
	<h1>観光地追加画面</h1><br>
	<h2>IDが重複しています。</h2><br>
	
	<form action="ToAddSpotsServlet" method="post">
	<input type="submit" value="観光地追加へ戻る">
	</form><br>
	<form action="ToAdminMenuServlet" method="post">
	<input type="submit" value="メニューへ戻る">
	</form>
</body>
</html>