<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お知らせ確認</title>
<style type="text/css">
<%@include file="/WEB-INF/newsupdate.css"%>
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
	<h1>お知らせ確認</h1>
	<h2>お知らせ変更(更新)</h2><br>
	<jsp:useBean id="selectNews" class="bean.NewsBean" scope="session"/>
	<form action="NewsUpdateCheck" method="post">
        <div class="box">
      カテゴリー<br>
      <%=selectNews.getCat() %>
      <br><br>
      タイトル<br>
      <input type="text" name="ctitle" size="50" required="required" value="<%=selectNews.getTitle() %>">
      <p>本文<br>
      <textarea id="text" name="cmain" rows="25" cols="100" required="required" onkeyup="showPreview()"><%=selectNews.getMain() %></textarea>
      <br><br>
      <p>プレビュー
      <div style="padding: 10px; margin-bottom: 10px; border: 5px double #333333; border-radius: 10px;" id="pre">
    <div id="preview"></div>
    </div></div>
    <input type="submit" value="確認">
    </form><br>
    
    <form action="NewsCheck" method="post">
	<input type="submit" value="お知らせ一覧へ戻る"></form><br>
	
	<form action="ToAdminMenuServlet" method="post">
	<input type="submit" value="メニューへ戻る"></form><br>
</body>
</html>