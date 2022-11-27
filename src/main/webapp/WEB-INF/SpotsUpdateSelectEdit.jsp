<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>観光地情報変更画面</title>
<style type="text/css">
<%@include file="/WEB-INF/spotsupdateselectedit.css"%>
</style>
</head>
<body>
	<jsp:useBean id="selectBean" class="bean.SpotsUpdateBean" scope="session"/>
	<h1>観光地情報変更画面</h1>
	<br>
	<div class="box">
		<table border="1">
	<tbody>
		<tr>
			<td>No</td>
			<td><%=selectBean.getNo() %></td>
			<td><%=selectBean.getNo() %></td>
		</tr>
		<tr>
			<td>ジャンル</td>
			<td><%=selectBean.getGenre() %></td>
			<td><form action="SpotsEditServlet" method="post"><select name="updateValue">
				<option value="寺社仏閣">寺社仏閣</option>
				<option value="歴史">歴史</option>
				<option value="動物園・水族館など">動物園・水族館など</option>
				<option value="美術館">美術館</option>
				<option value="博物館">博物館</option>
				<option value="自然・景色">自然・景色</option>
				<option value="遊園地">遊園地</option>
				<option value="ショッピング">ショッピング</option>
				<option value="キャンプ場">キャンプ場</option>
				<option value="公園・スポーツ">公園・スポーツ</option>
				<option value="農園・牧場">農園・牧場</option>
				</select>
				<input type="hidden" name="db" value="spot">
				<input type="hidden" name="column" value="genre"><input type="submit" value="変更"></form>
			</td>
		</tr>
		<tr>
			<td>サブジャンル</td>
			<td><%=selectBean.getSubGenre() %></td>
			<td><form action="SpotsEditServlet" method="post">
			<input type="text" name="updateValue" size=20 required="required">
			<input type="hidden" name="db" value="spot">
			<input type="hidden" name="column" value="subgenre">
			<input type="submit" value="変更"></form>
			</td>
		</tr>
		<tr>
			<td>観光地名称</td>
			<td><%=selectBean.getName() %></td>
			<td><form action="SpotsEditServlet" method="post">
			<input type="text" name="updateValue" size=50 required="required">
			<input type="hidden" name="db" value="spot">
			<input type="hidden" name="column" value="name">
			<input type="submit" value="変更"></form>
			</td>
		</tr>
		<tr>
			<td>市町村群</td>
			<td><%=selectBean.getCity() %></td>
			<td><form action="SpotsEditServlet" method="post">
			<input type="text" name="updateValue" size=20 required="required">
			<input type="hidden" name="db" value="spot">
			<input type="hidden" name="column" value="city">
			<input type="submit" value="変更"></form>
			</td>
		</tr>
		<tr>
			<td>所在地</td>
			<td><%=selectBean.getAddress() %></td>
			<td><form action="SpotsEditServlet" method="post">
			<input type="text" name="updateValue" size=50 required="required">
			<input type="hidden" name="db" value="spot">
			<input type="hidden" name="column" value="address">
			<input type="submit" value="変更"></form>
			</td>
		</tr>
		<tr>
			<td>休館日,休園日</td>
			<td><%=selectBean.getRest() %></td>
			<td><form action="SpotsEditServlet" method="post">
			<input type="text" name="updateValue" size=50 required="required">
			<input type="hidden" name="db" value="spot">
			<input type="hidden" name="column" value="rest">
			<input type="submit" value="変更"></form>
			</td>
		</tr>
		<tr>
			<td>営業時間</td>
			<td><%=selectBean.getHours() %></td>
			<td><form action="SpotsEditServlet" method="post">
			<input type="text" name="updateValue" size=50 required="required">
			<input type="hidden" name="db" value="spot">
			<input type="hidden" name="column" value="hours">
			<input type="submit" value="変更"></form>
			</td>
		</tr>
		<tr>
			<td>アクセス方法1</td>
			<td><%=selectBean.getAccess1() %></td>
			<td><form action="SpotsEditServlet" method="post">
			<input type="text" name="updateValue" size=50 required="required">
			<input type="hidden" name="db" value="spot">
			<input type="hidden" name="column" value="access1">
			<input type="submit" value="変更"></form>
			</td>
		</tr>
		<tr>
			<td>アクセス方法2</td>
			<td><%=selectBean.getAccess2() %></td>
			<td><form action="SpotsEditServlet" method="post">
			<input type="text" name="updateValue" size=50 required="required">
			<input type="hidden" name="db" value="spot">
			<input type="hidden" name="column" value="access2">
			<input type="submit" value="変更"></form>
			</td>
		</tr>
		<tr>
			<td>マップのURL</td>
			<td><%=selectBean.getMapURL() %></td>
			<td><form action="SpotsEditServlet" method="post">
			<input type="text" name="updateValue" size=100 required="required">
			<input type="hidden" name="db" value="map">
			<input type="hidden" name="column" value="map">
			<input type="submit" value="変更"></form>
			</td>
		</tr>
		<tr>
			<td>ホームページ1</td>
			<td><%=selectBean.getPage1() %></td>
			<td><form action="SpotsEditServlet" method="post">
			<input type="text" name="updateValue" size=50>
			<input type="hidden" name="db" value="spotinfo">
			<input type="hidden" name="column" value="page1">
			<input type="submit" value="変更"></form>
			</td>
		</tr>
		<tr>
			<td>ホームページ2</td>
			<td><%=selectBean.getPage2() %></td>
			<td><form action="SpotsEditServlet" method="post">
			<input type="text" name="updateValue" size=50>
			<input type="hidden" name="db" value="spotinfo">
			<input type="hidden" name="column" value="page2">
			<input type="submit" value="変更"></form>
			</td>
		</tr>
		<tr>
			<td>説明</td>
			<td><%=selectBean.getIntro() %></td>
			<td><form action="SpotsEditServlet" method="post">
			<textarea rows="5" cols="50" name="updateValue" required="required"></textarea>
			<input type="hidden" name="db" value="spotinfo">
			<input type="hidden" name="column" value="intro">
			<input type="submit" value="変更"></form>
			</td>
		</tr>
		<tr>
			<td>気分</td>
			<td><%=selectBean.getFeel() %></td>
			<td><form action="SpotsEditServlet" method="post">
			<input type="text" name="updateValue" size=40 required="required">
			<input type="hidden" name="db" value="question">
			<input type="hidden" name="column" value="feel">
			<input type="submit" value="変更"></form>
			</td>
		</tr>
		<tr>
			<td>家族</td>
			<td><%=selectBean.getFamily() %></td>
			<td><form action="SpotsEditServlet" method="post">
			1にする。
			<input type="checkbox" name="updateValue" value="1">
			<input type="hidden" name="db" value="question">
			<input type="hidden" name="column" value="FA">
			<input type="submit" value="変更"></form>
			<form action="SpotsEditServlet" method="post">
			0にする。
			<input type="checkbox" name="updateValue" value="0">
			<input type="hidden" name="db" value="question">
			<input type="hidden" name="column" value="FA">
			<input type="submit" value="変更"></form>
			</td>
		</tr>
		<tr>
			<td>友人</td>
			<td><%=selectBean.getFriend() %></td>
			<td><form action="SpotsEditServlet" method="post">
			1にする。
			<input type="checkbox" name="updateValue" value="1">
			<input type="hidden" name="db" value="question">
			<input type="hidden" name="column" value="FR">
			<input type="submit" value="変更"></form>
			<form action="SpotsEditServlet" method="post">
			0にする。
			<input type="checkbox" name="updateValue" value="0">
			<input type="hidden" name="db" value="question">
			<input type="hidden" name="column" value="FR">
			<input type="submit" value="変更"></form>
			</td>
		</tr>
		<tr>
			<td>恋人</td>
			<td><%=selectBean.getCupple() %></td>
			<td><form action="SpotsEditServlet" method="post">
			1にする。
			<input type="checkbox" name="updateValue" value="1">
			<input type="hidden" name="db" value="question">
			<input type="hidden" name="column" value="LO">
			<input type="submit" value="変更"></form>
			<form action="SpotsEditServlet" method="post">
			0にする。
			<input type="checkbox" name="updateValue" value="0">
			<input type="hidden" name="db" value="question">
			<input type="hidden" name="column" value="LO">
			<input type="submit" value="変更"></form>
			</td>
		</tr>
		<tr>
			<td>インアウト</td>
			<td><%=selectBean.getInout() %></td>
			<td><form action="SpotsEditServlet" method="post">
			インドアにする。
			<input type="checkbox" name="updateValue" value="In">
			<input type="hidden" name="db" value="question">
			<input type="hidden" name="column" value="IO">
			<input type="submit" value="変更"></form>
			<form action="SpotsEditServlet" method="post">
			アウトドアにする。
			<input type="checkbox" name="updateValue" value="Out">
			<input type="hidden" name="db" value="question">
			<input type="hidden" name="column" value="IO">
			<input type="submit" value="変更"></form>
			<form action="SpotsEditServlet" method="post">
			両方にする。
			<input type="checkbox" name="updateValue" value="IO">
			<input type="hidden" name="db" value="question">
			<input type="hidden" name="column" value="IO">
			<input type="submit" value="変更"></form>
			</td>
		</tr>
		<tr>
			<td>知名度</td>
			<td><%=selectBean.getFamous() %></td>
			<td><form action="SpotsEditServlet" method="post">
			有名にする。
			<input type="checkbox" name="updateValue" value="f">
			<input type="hidden" name="db" value="question">
			<input type="hidden" name="column" value="FOH">
			<input type="submit" value="変更"></form>
			<form action="SpotsEditServlet" method="post">
			普通にする。
			<input type="checkbox" name="updateValue" value="o">
			<input type="hidden" name="db" value="question">
			<input type="hidden" name="column" value="FOH">
			<input type="submit" value="変更"></form>
			<form action="SpotsEditServlet" method="post">
			穴場にする。
			<input type="checkbox" name="updateValue" value="h">
			<input type="hidden" name="db" value="question">
			<input type="hidden" name="column" value="FOH">
			<input type="submit" value="変更"></form>
			</td>
		</tr>
		<tr>
			<td>エリア</td>
			<td><%=selectBean.getArea() %></td>
			<td><form action="SpotsEditServlet" method="post">
			<input type="text" name="updateValue" size=20 required="required">
			<input type="hidden" name="db" value="question">
			<input type="hidden" name="column" value="area">
			<input type="submit" value="変更"></form>
			</td>
		</tr>
		<tr>
			<td>おすすめ季節</td>
			<td><%=selectBean.getSeason() %></td>
			<td><form action="SpotsEditServlet" method="post">
			<input type="checkbox" name="all" value="all">一年中
			<input type="checkbox" name="Spring" value="Spring">春
			<input type="checkbox" name="Summer" value="Summer">夏
			<input type="checkbox" name="Autumn" value="Autumn">秋
			<input type="checkbox" name="Winter" value="Winter">冬
			<input type="hidden" name="db" value="question">
			<input type="hidden" name="column" value="season">
			<input type="submit" value="変更"></form>
			</td>
		</tr>
		<tr>
			<td>画像</td>
			<td>1:<%=selectBean.getImg1() %><br>
				2:<%=selectBean.getImg2() %><br>
				3:<%=selectBean.getImg3() %><br>
				4:<%=selectBean.getImg4() %><br>
				5:<%=selectBean.getImg5() %></td>
			<td><form action="SpotsEditServlet" method="post">1:<input type="text" name="img" size="32" required="required"><input type="hidden" name="num" value="1"><input type="submit" value="変更"></form><br>
				<form action="SpotsEditServlet" method="post">2:<input type="text" name="img" size="32" required="required"><input type="hidden" name="num" value="2"><input type="submit" value="変更"></form><br>
				<form action="SpotsEditServlet" method="post">3:<input type="text" name="img" size="32" required="required"><input type="hidden" name="num" value="3"><input type="submit" value="変更"></form><br>
				<form action="SpotsEditServlet" method="post">4:<input type="text" name="img" size="32" required="required"><input type="hidden" name="num" value="4"><input type="submit" value="変更"></form><br>
				<form action="SpotsEditServlet" method="post">5:<input type="text" name="img" size="32" required="required"><input type="hidden" name="num" value="5"><input type="submit" value="変更"></form>
			</td>	
		</tr>
	</tbody>
</table><br></div>
<div class="submit">
<form action="SpotsDeleteServlet" method="post">
<input type="submit" value="削除"></form><br>

<form action="ToSpotsUpdateServlet" method="post">
<input type="submit" value="別の観光地を変更する">
</form><br>

<form action="ToAdminMenuServlet" method="post">
<input type="submit" value="メニューへ戻る"></form></div><br>
</body>
</html>