<%@page import="bean.SpotsUpdateBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>観光地情報変更画面</title>
<style type="text/css">
<%@include file="/WEB-INF/spotsupdateselect.css"%>
</style>
</head>
<body>
	<h1>観光地情報変更画面</h1><br>
	<jsp:useBean id="suArray" class="bean.SpotsUpdateArrayBean" scope="session"/>
	<form action="SpotsUpdateSearchServlet" method="post">
	<div class="box">
	<p>検索<input type="text" name="search" required="required"><br>
	<p>検索する条件</p><select name="way">
	<option value="id">ID</option>
	<option value="name">観光地名称</option>
	</select><br></div>
	<input type="submit" value="検索">
	</form><br>
	<%
	if(suArray.getArraySize() != 0){
	%>
	<p>検索結果<br>
	<div class="box2">
	<table border="1">
	<tr>
		<td>ID</td>
		<td>名称</td>
		<td>ジャンル</td>
		<td>サブジャンル</td>
		<td>市町村郡</td>
		<td>所在地</td>
		<td>休館日,休園日</td>
		<td>営業時間</td>
		<td>アクセス方法1</td>
		<td>アクセス方法2</td>
	</tr>
	<%
		ArrayList<SpotsUpdateBean> array = suArray.getSpotsUpdateArray();
		for(SpotsUpdateBean record : array){
	%>
	<tr>
		<td><%=record.getNo() %></td>
		<td><%=record.getName() %></td>
		<td><%=record.getGenre() %></td>
		<td><%=record.getSubGenre() %></td>
		<td><%=record.getCity() %></td>
		<td><%=record.getAddress() %></td>
		<td><%=record.getRest() %></td>
		<td><%=record.getHours() %></td>
		<td><%=record.getAccess1() %></td>
		<td><%=record.getAccess2() %></td>
		<td><div class="hensyu"><form action="SpotsUpdateSelectedServlet" method="post" >
		<input type="hidden" name="id" value="<%=record.getNo()%>">
		<input type="submit" value="編集" id="hensyu">
		</form></div></td>
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
	<br>
	</div>
	<form action="ToAdminMenuServlet" method="post">
	<input type="submit" value="メニューへ戻る">
	</form>	
</body>
</html>