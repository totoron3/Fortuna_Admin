<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>観光地追加画面</title>
<style type="text/css">
<%@include file="/WEB-INF/addspots.css"%>
</style>
</head>
<body>
	<h1>観光地追加画面</h1>
	<form action="AddSpotServlet" method="post">
	<div class="box">
	<table>
<tr>
<td><p>No</td><td><input type="text" name="no" size=20 required="required"></td>
</tr>
<tr>
<td><p>ジャンル</td><td><label id="label"><select name="genre">
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
</select></label></td>
</tr>
<tr>
<td><p>サブジャンル</td><td><input type="text" name="subgenre" size=20 required="required"></td>
</tr>
<tr>
<td><p>観光地名称</td><td><input type="text" name="spotname" size=50 required="required"></td>
</tr>
<tr>
<td><p>市町村郡</td><td><input type="text" name="city" size=20 required="required"></td>
</tr>
<tr>
<td><p>所在地</td><td><input type="text" name="location" size=50 required="required"></td>
</tr>
<tr>
<td><p>休館日,休園日</td><td><input type="text" name="rest" size=50 required="required"></td>
</tr>
<tr>
<td><p>営業時間</td><td><input type="text" name="businessHours" size=50 required="required"></td>
</tr>
<tr>
<td><p>アクセス方法1</td><td><input type="text" name="access1" size=50 ></td>
</tr>
<tr>
<td><p>アクセス方法2</td><td><input type="text" name="access2" size=50 ></td>
</tr>
<tr>
<td><p>マップのURL</td><td><input type="text" name="mapURL" size=100 required="required"></td>
</tr>
<tr>
<td><p>ホームページ１</td><td><input type="text" name="page1" size=50></td>
</tr>
<tr>
<td><p>ホームページ２</td><td><input type="text" name="page2" size=50></td>
</tr>
<tr>
<td><p>説明</td><td><textarea class="textlines" rows="5" cols="50" name="intro" required="required"></textarea></td>
</tr>
<tr>
<td><p>気分</td><td><input type="text" name="feeling" size=40 required="required"></td>
</tr>
<tr>
<td><p>家族</td><td><input type="checkbox" name="family" value="1"></td>
</tr>
<tr>
<td><p>友人</td><td><input type="checkbox" name="friend" value="1"></td>
</tr>
<tr>
<td><p>恋人</td><td><input type="checkbox" name="lover" value="1"></td>
</tr>
<tr>
<td><p>インアウト</td><td><div class="a"><input type="radio" name="inout" value="In" required="required">インドア
<input type="radio" name="inout" value="Out"required="required">アウトドア
<input type="radio" name="inout" value="IO"required="required">両方</div></td>
</tr>
<tr>
<td><p>知名度</td><td><div class="a"><input type="radio" name="pop" value="f" required="required">有名 
<input type="radio" name="pop" value="o" required="required">普通
<input type="radio" name="pop" value="h" required="required">穴場</div>
</td>
</tr>
<tr>
<td><p>エリア</td><td><input type="text" name="area" size=20 required="required"></td>
</tr>
<tr>
<td><p>おすすめ季節</td><td>
<div class="chkbox">
<input type="checkbox" name="all" value="all" id="box-1"><label for="box-1">一年中</label>
<input type="checkbox" name="Spring" value="Spring" id="box-2"><label for="box-2">春</label>
<input type="checkbox" name="Summer" value="Summer" id="box-3"><label for="box-3">夏</label>
<input type="checkbox" name="Autumn" value="Autumn" id="box-4"><label for="box-4">秋</label>
<input type="checkbox" name="Winter" value="Winter" id="box-5"><label for="box-5">冬</label>
</div></td>
</tr>
<tr>
<td><p>画像</td><td>
1:<input type="text" name="img1" size="32"><br>
2:<input type="text" name="img2" size="32"><br>
3:<input type="text" name="img3" size="32"><br>
4:<input type="text" name="img4" size="32"><br>
5:<input type="text" name="img5" size="32">
</table></div>
<div class="di">
<input type="submit" value="登録確認"><input type="reset" value="リセット">
</div></form>
<div class="id">
<form action="ToAdminMenuServlet" method="post">
<input type="submit" value="メニューへ戻る" id="menu">
</form></div><br>
</body>
</html>