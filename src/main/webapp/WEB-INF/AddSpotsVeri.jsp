<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>観光地追加画面</title>
<style type="text/css">
<%@include file="/WEB-INF/addspotsVeri.css"%>
</style>
</head>
<body>
	<jsp:useBean id="asBean" class="bean.AddSpotBean" scope="session"/>
	<h1>観光地追加画面</h1>
	<div class="box">
	<table border="1">
	<tbody>
		<tr>
			<td>No</td>
			<td><%=asBean.getNo() %></td>
		</tr>
		<tr>
			<td>ジャンル</td>
			<td><%=asBean.getGenre() %></td>
		</tr>
		<tr>
			<td>サブジャンル</td>
			<td><%=asBean.getSubGenre() %></td>
		</tr>
		<tr>
			<td>観光地名称</td>
			<td><%=asBean.getName() %></td>
		</tr>
		<tr>
			<td>市町村群</td>
			<td><%=asBean.getCity() %></td>
		</tr>
		<tr>
			<td>所在地</td>
			<td><%=asBean.getAddress() %></td>
		</tr>
		<tr>
			<td>休館日,休園日</td>
			<td><%=asBean.getRest() %></td>
		</tr>
		<tr>
			<td>営業時間</td>
			<td><%=asBean.getHours() %></td>
		</tr>
		<tr>
			<td>アクセス方法</td>
			<td><%=asBean.getAccess1() %></td>
		</tr>
		<tr>
			<td>アクセス方法2</td>
			<td><%=asBean.getAccess2() %></td>
		</tr>
		<tr>
			<td>マップのURL</td>
			<td><%=asBean.getMapURL() %></td>
		</tr>
		<tr>
			<td>ホームページ1</td>
			<td><%=asBean.getPage1() %></td>
		</tr>
		<tr>
			<td>ホームページ2</td>
			<td><%=asBean.getPage2() %></td>
		</tr>
		<tr>
			<td>説明</td>
			<td><%=asBean.getIntro() %></td>
		</tr>
		<tr>
			<td>気分</td>
			<td><%=asBean.getFeel() %></td>
		</tr>
		<tr>
			<td>家族</td>
			<td><%=asBean.getFamily() %></td>
		</tr>
		<tr>
			<td>友人</td>
			<td><%=asBean.getFriend() %></td>
		</tr>
		<tr>
			<td>恋人</td>
			<td><%=asBean.getCupple() %></td>
		</tr>
		<tr>
			<td>インアウト</td>
			<td><%=asBean.getInout() %></td>
		</tr>
		<tr>
			<td>知名度</td>
			<td><%=asBean.getFamous() %></td>
		</tr>
		<tr>
			<td>エリア</td>
			<td><%=asBean.getArea() %></td>
		</tr>
		<tr>
			<td>おすすめ季節</td>
			<td><%=asBean.getSeason() %></td>
		</tr>
		<tr>
			<td>画像</td>
			<td>1:<%=asBean.getImg1() %><br>
				2:<%=asBean.getImg2() %><br>
				3:<%=asBean.getImg3() %><br>
				4:<%=asBean.getImg4() %><br>
				5:<%=asBean.getImg5() %></td>
		</tr>
	</tbody>
</table>
</div><br>
<form action="AddSpotsFinalServlet" method="post">
<input type="submit" value="登録">
</form><br>
<form action="ToAdminMenuServlet" method="post">
<input type="submit" value="メニューへ戻る">
</form>
</body>
</html>