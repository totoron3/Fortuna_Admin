<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>観光地削除確認画面</title>
<style type="text/css">
<%@include file="/WEB-INF/spotsdeleteveri.css"%>
</style>
</head>
<body>
	<h1>観光地削除確認画面</h1><br>
	<h2>以下の観光地を削除しますか？</h2>
	
	<form action="SpotsDeleteFinalServlet" method="post">
	<input type="submit" value="削除します" name="way"><input type="submit" value="キャンセル" name="way">
	</form>
	<div class="box">
	<jsp:useBean id="selectBean" class="bean.SpotsUpdateBean" scope="session"/>
			<table border="1">
	<tbody>
		<tr>
			<td>No</td>
			<td><%=selectBean.getNo() %></td>
		</tr>
		<tr>
			<td>ジャンル</td>
			<td><%=selectBean.getGenre() %></td>
		</tr>
		<tr>
			<td>サブジャンル</td>
			<td><%=selectBean.getSubGenre() %></td>
		</tr>
		<tr>
			<td>観光地名称</td>
			<td><%=selectBean.getName() %></td>
		</tr>
		<tr>
			<td>市町村群</td>
			<td><%=selectBean.getCity() %></td>
		</tr>
		<tr>
			<td>所在地</td>
			<td><%=selectBean.getAddress() %></td>
		</tr>
		<tr>
			<td>休館日,休園日</td>
			<td><%=selectBean.getRest() %></td>
		</tr>
		<tr>
			<td>営業時間</td>
			<td><%=selectBean.getHours() %></td>
		</tr>
		<tr>
			<td>マップのURL</td>
			<td><%=selectBean.getMapURL() %></td>
		</tr>
		<tr>
			<td>ホームページ1</td>
			<td><%=selectBean.getPage1() %></td>
		</tr>
		<tr>
			<td>ホームページ2</td>
			<td><%=selectBean.getPage2() %></td>
		</tr>
		<tr>
			<td>説明</td>
			<td><%=selectBean.getIntro() %></td>
		</tr>
		<tr>
			<td>気分</td>
			<td><%=selectBean.getFeel() %></td>
		</tr>
		<tr>
			<td>家族</td>
			<td><%=selectBean.getFamily() %></td>
		</tr>
		<tr>
			<td>友人</td>
			<td><%=selectBean.getFriend() %></td>
		</tr>
		<tr>
			<td>恋人</td>
			<td><%=selectBean.getCupple() %></td>
		</tr>
		<tr>
			<td>インアウト</td>
			<td><%=selectBean.getInout() %></td>
		</tr>
		<tr>
			<td>知名度</td>
			<td><%=selectBean.getFamous() %></td>
		</tr>
		<tr>
			<td>エリア</td>
			<td><%=selectBean.getArea() %></td>
		</tr>
		<tr>
			<td>おすすめ季節</td>
			<td><%=selectBean.getSeason() %></td>
		</tr>
	</tbody>
</table><br>
</div>
</body>
</html>