<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お知らせ追加</title>
<style type="text/css">
<%@include file="/WEB-INF/addnewscomplete.css"%>
</style>
</head>
<body>
	<h1>お知らせ追加</h1>
	<br>
	<h2>お知らせ追加しました。</h2><br>
	<form action="ToAddNewsServlet" method="post">
	<input type="submit" value="別のお知らせを追加する">
	</form><br>
	<form action="ToAdminMenuServlet" method="post">
	<input type="submit" value="メニューへ戻る">
	</form>
</body>
</html>