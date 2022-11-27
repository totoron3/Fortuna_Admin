<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>セッションエラー</title>
<style type="text/css">
<%@include file="/WEB-INF/sessionerror.css"%>
</style>
<script type="text/javascript">
$('.fun-btn').on('click', function(event) {
	  $(this).toggleClass('start-fun');
	  var $page = $('.page');
	  $page.toggleClass('color-bg-start')
	    .toggleClass('bg-animate-color');

	  //change text when when button is clicked

	  $(this).hasClass('start-fun') ?
	    $(this).text('stop the fun') :
	    $(this).text('start the fun');

	});
</script>
</head>
<body>

	セッションが一致しません<br>
	<p>最初からやり直してください<br>
		<img src="広島県ベロあり.png" id="ken">
	<img src="エラー1.png" id="ken2"><br>
	<img src="medical_mask01_boy.png" id="boy">
	<img src="medical_mask02_girl.png" id="girl">
	<img src="広島県ベロあり.png" id="ken3">
<div class="page">
	<form action="ToAdminMenuServlet"method="post">
	<input type="submit" value="メニューに戻る">
	</form></div>
</body>
</html>