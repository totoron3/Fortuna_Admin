<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>観光地削除完了画面</title>
<style type="text/css">
<%@include file="/WEB-INF/spotsdeletecomplete.css"%>
</style>
</head>
<body>
		<h1>観光地削除完了画面</h1><br>
		<h2>観光地削除しました。</h2><br>
		
		<form action="ToAdminMenuServlet" method="post">
		<input type="submit" value="メニューへ戻る"></form><br>
</body>
</html>