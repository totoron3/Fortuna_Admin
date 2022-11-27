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
<%@include file="/WEB-INF/userssearchResult.css"%>
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
	<jsp:useBean id="uiArrayBean" class="bean.UserInfoArrayBean" scope="session"/>
	<%
	if(uiArrayBean.getArraySize() != 0){
	%>
	<p>検索結果<br>
	<div  class="box2">
	<table border="1">
	<tr>
		<td>ID</td>
		<td>PASSWORD</td>
		<td>NICKNAME</td>
	</tr>
	<%
		ArrayList<UserInfoBean> array = uiArrayBean.getUserArray();
		for(UserInfoBean record : array){
	%>
	<tr>
		<td><%=record.getId() %></td>
		<td><%=record.getPassword() %></td>
		<td><%=record.getNickname() %></td>
		<td><div class="hensyuu">
		<form action="UserInfoUpdateServlet" method="post">
		<input type="hidden" name="id" value="<%=record.getId() %>">
		<input type="submit" value="編集" id="hensyu">
		</form></div>
	</tr>
	<%
		}
	%>
	</table>
	<%
	}else{
	%>
	<h2>検索結果が見つかりませんでした。</h2>
	<%
	}
	%>
	<br></div>
	<form action="ToAdminMenuServlet" method="post">
	<input type="submit" value="メニューへ戻る">
	</form>
</body>
</html>