<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>エラー</title>
<style type="text/css">
<%@include file="/WEB-INF/error.css"%>
</style>
</head>
<body>


	<div class="container">
  <p class="bound">
    <span>エ</span>
    <span>ラ</span>
    <span>ー</span>
    <span>画</span>
    <span>面</span>
  </p>
</div>
<div class="stars">
<span class="s"></span>
    <span class="s"></span>
    <span class="s"></span>
    <span class="s"></span>
    <span class="s"></span>
    <span class="m"></span>
    <span class="m"></span>
    <span class="m"></span>
    <span class="m"></span>
    <span class="m"></span>
    <span class="l"></span>
    <span class="l"></span>
    <span class="l"></span>
    <span class="l"></span>
    <span class="l"></span>
 <section class="w">
  <div class="w-head">
    <i class="w-eye"></i>
    <i class="w-eye w-eye_right"></i>
  </div>
  <div class="w-arm"></div>
  <div class="w-arm w-arm_right"></div>
  <div class="w-leg">
    <div class="w-leg-top"></div>
    <div class="w-leg-bottom">
      <div class="w-heel"></div>
      <div class="w-shoelace"></div>
      <div class="w-shoelace"></div>
    </div>
  </div>
  <div class="w-leg w-leg_right">
    <div class="w-leg-top"></div>
    <div class="w-leg-bottom">
      <div class="w-heel"></div>
      <div class="w-shoelace"></div>
      <div class="w-shoelace"></div>
    </div>
  </div>
  <div class="w-body">
    <div class="w-body-skin"></div>
    <div class="w-body-nipples"></div>
  </div>
</section>
</div>
	<%
		Exception e = (Exception) session.getAttribute("Except");
	%>
	<p class="text"><%= e.getMessage() %></p>
	<br><br>
	<div class="ball"><a href="/AdminLogin.html">ログイン画面に戻る</a></div>
</body>
</html>