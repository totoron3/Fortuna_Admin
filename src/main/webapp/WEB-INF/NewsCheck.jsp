<%@page import="bean.NewsBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お知らせ確認</title>
<style type="text/css">
<%@include file="/WEB-INF/newscheck.css"%>
</style>
</head>
<body>
	<h1>お知らせ確認</h1>
	<jsp:useBean id="nArray" class="bean.NewsArrayBean" scope="session"/>
	<h2>お知らせ一覧</h2>
	<%
	ArrayList<NewsBean> array = nArray.getNewsArray();
	int i = 0;
	int j = 0;
	int k = 0;
	int l = 0;
	int m = 0;
 	%>
 	<input type="button" value="全件" onclick="clickBtn0()" />
	<input type="button" value="新規観光地" onclick="clickBtn1()" />
	<input type="button" value="アップデート" onclick="clickBtn2()" />
	<input type="button" value="障害不具合" onclick="clickBtn3()" />
	<input type="button" value="その他" onclick="clickBtn4()" />
	
	
	<div class="box"><table border="1" id="p0">
		<tr>
			<td>ID</td>
			<td>カテゴリー</td>
			<td>タイトル</td>
			<td>日付</td>
		</tr>
		<%
			for(NewsBean record : array){
		%>
		<tr>
			<td><%=record.getId() %></td>
			<td><%=record.getCat() %></td>
			<td><form action="NewsDetail" method="post" name="formA<%=i %>"><input type="hidden" name="id" value="<%=record.getId() %>">
			<a href="javascript:formA<%=i %>.submit()"><%=record.getTitle() %></a></form></td>
			<td><%=record.getDate() %></td>
		</tr>
		<%
			i++;
			}
		%>	
	</table>
	
	<table border="1" id="p1">
	<tr>
		<td>ID</td>
		<td>カテゴリー</td>
		<td>タイトル</td>
		<td>日付</td>
	</tr>
	<%
		for(NewsBean record : array){
			if(record.getCategory() == 1){
	%>
	<tr>
		<td><%=record.getId() %></td>
		<td><%=record.getCat() %></td>
		<td><form action="NewsDetail" method="post" name="formA<%=i %>"><input type="hidden" name="id" value="<%=record.getId() %>">
		<a href="javascript:formB<%=j %>.submit()"><%=record.getTitle() %></a></form></td>
		<td><%=record.getDate() %></td>
	</tr>
	<%
			}
		j++;
		}
	%>
	</table>
	
	<table border="1" id="p2">
	<tr>
		<td>ID</td>
		<td>カテゴリー</td>
		<td>タイトル</td>
		<td>日付</td>
	</tr>
	<%
		for(NewsBean record : array){
			if(record.getCategory() == 2){
	%>
	<tr>
		<td><%=record.getId() %></td>
		<td><%=record.getCat() %></td>
		<td><form action="NewsDetail" method="post" name="formA<%=i %>"><input type="hidden" name="id" value="<%=record.getId() %>">
		<a href="javascript:formC<%=k %>.submit()"><%=record.getTitle() %></a></form></td>
		<td><%=record.getDate() %></td>
	</tr>
	<%
			}
		k++;
		}
	%>
	</table>
	
	<table border="1" id="p3">
	<tr>
		<td>ID</td>
		<td>カテゴリー</td>
		<td>タイトル</td>
		<td>日付</td>
	</tr>
	<%
		for(NewsBean record : array){
			if(record.getCategory() == 3){
	%>
	<tr>
		<td><%=record.getId() %></td>
		<td><%=record.getCat() %></td>
		<td><form action="NewsDetail" method="post" name="formA<%=i %>"><input type="hidden" name="id" value="<%=record.getId() %>">
		<a href="javascript:formD<%=l %>.submit()"><%=record.getTitle() %></a></form></td>
		<td><%=record.getDate() %></td>
	</tr>
	<%
			}
		l++;
		}
	%>
	</table>
	
	<table border="1" id="p4">
	<tr>
		<td>ID</td>
		<td>カテゴリー</td>
		<td>タイトル</td>
		<td>日付</td>
	</tr>
	<%
		for(NewsBean record : array){
			if(record.getCategory() == 4){
	%>
	<tr>
		<td><%=record.getId() %></td>
		<td><%=record.getCat() %></td>
		<td><form action="NewsDetail" method="post" name="formA<%=i %>"><input type="hidden" name="id" value="<%=record.getId() %>">
		<a href="javascript:formE<%=m %>.submit()"><%=record.getTitle() %></a></form></td>
		<td><%=record.getDate() %></td>
	</tr>
	<%
			}
		m++;
		}
	%>
	</table></div><br>
	
	<form action="ToAdminMenuServlet" method="post">
	<input type="submit" value="メニューへ戻る">
	</form><br>
	
	<script>
const p0 = document.getElementById("p0");
const p1 = document.getElementById("p1");
const p2 = document.getElementById("p2");
const p3 = document.getElementById("p3");
const p4 = document.getElementById("p4");

p0.style.display ="block";
p1.style.display ="none";
p2.style.display ="none";
p3.style.display ="none";
p4.style.display ="none";

function clickBtn0(){	
	p1.style.display ="none";
	p2.style.display ="none";
	p3.style.display ="none";
	p4.style.display ="none";
	p0.style.display ="block";
}
function clickBtn1(){
	p0.style.display ="none";
	p2.style.display ="none";
	p3.style.display ="none";
	p4.style.display ="none";
	p1.style.display ="block";
}
function clickBtn2(){
	p0.style.display ="none";
	p1.style.display ="none";
	p3.style.display ="none";
	p4.style.display ="none";
	p2.style.display ="block";
}
function clickBtn3(){
	p0.style.display ="none";
	p1.style.display ="none";
	p2.style.display ="none";
	p4.style.display ="none";
	p3.style.display ="block";
}
function clickBtn4(){
	p0.style.display ="none";
	p1.style.display ="none";
	p2.style.display ="none";
	p3.style.display ="none";
	p4.style.display ="block";
}

</script>	
</body>
</html>