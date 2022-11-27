<%@page import="bean.UserInfoBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー情報変更</title>
<style type="text/css">
<%@include file="/WEB-INF/userinfoupdate.css"%>
</style>
</head>
<body>
	<h1>ユーザー情報変更</h1>
	<jsp:useBean id="selectUser" class="bean.UserInfoBean" scope="session"/>	
		<div class="box"><table border="1">
		<tr>
			<td>ID</td><td><%=selectUser.getId() %></td><td><%=selectUser.getId() %></td>
		</tr>
		<tr>
			<td>PASSWORD</td><td>************</td>
			<td><form action="UserInfoUpdateFinalServlet" method="post">
			<input type="password" name="updateValue">
			<input type="hidden" name="column" value="password">
			<input type="hidden" name="id" value="<%=selectUser.getId() %>">
			<input type="submit" value="変更確認">
			</form></td>
		</tr>
		<tr>
			<td>NICKNAME</td><td><%=selectUser.getNickname() %></td>
			<td><form action="UserInfoUpdateFinalServlet" method="post">
			<input type="text" name="updateValue">
			<input type="hidden" name="column" value="nickname">
			<input type="hidden" name="id" value="<%=selectUser.getId() %>">
			<input type="submit" value="変更確認">
			</form></td>
		</tr>
		</table><br></div>
		<form action="UserDeleteServlet" method="post">
		<input type="hidden" name="id" value="<%=selectUser.getId() %>">
		<input type="submit" value="退会させる">
		</form><br><br>
	<form action="ToAdminMenuServlet" method="post">
	<input type="submit" value="メニューへ戻る">
	</form>
</body>
</html>