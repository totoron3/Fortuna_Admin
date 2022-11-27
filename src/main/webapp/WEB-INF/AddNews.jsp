<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お知らせ追加</title>
<style type="text/css">
<%@include file="/WEB-INF/addnews.css"%>
</style>
</head>
<body>
<script type="text/javascript">
      function showPreview() {
        var html = document.getElementById('text').value ;
        /*
          必要なら html に変換処理を入れる
        */
        document.getElementById('preview').innerHTML = html ;
      }
</script>
    <h1>お知らせ追加</h1>
    <br>
    <form action="AddNewsServlet" method="post">
        <div class="box">
      カテゴリー<br>
      <select name="category">
      	<option value="1">新規観光地</option>
      	<option value="2">アップデート</option>
      	<option value="3">障害不具合</option>
      	<option value="4">その他</option>
      </select><br><br>
      タイトル<br>
      <input type="text" name="title" size="50" required="required">
      <p>本文<br>
      <textarea id="text" name="main" rows="25" cols="100" required="required" onkeyup="showPreview()"></textarea>
      <br><br>
      <p>プレビュー
      <div style="padding: 10px; margin-bottom: 10px; border: 5px double #333333; border-radius: 10px;" id="pre">
    <div id="preview"></div>
    </div></div>
      <input type="submit" value="確認">
    </form>
    <br>
    <form action="ToAdminMenuServlet" method="post">
    <input type="submit" value="メニューへ戻る">
	</form><br>
</body>
</html>