<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>フィードバック確認</title>
<style type="text/css">
<%@include file="/WEB-INF/feedbackdetail.css"%>
</style>
</head>
<body>
	<h1>フィードバック確認</h1>
	<jsp:useBean id="selectBean" class="bean.FeedBackBean" scope="session"/>
	<div class="box"><table border="1">
	<tr><td>件名</td><td><%=selectBean.getTitle() %></td></tr>
	<tr><td>受取日</td><td><%=selectBean.getDate() %></td></tr>
	<tr><td>本文</td><td><%=selectBean.getMain() %></td></tr>
	</table><br></div>
	<form action="ToFeedBackServlet" method="post">
	<input type="submit" value="フィードバック確認へ戻る"></form><br>
	<form action="ToAdminMenuServlet" method="post">
	<input type="submit" value="メニューへ戻る">
	</form>
</body>
</html>