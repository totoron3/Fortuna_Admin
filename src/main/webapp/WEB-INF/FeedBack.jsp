<%@page import="bean.FeedBackBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>フィードバック確認</title>
<style type="text/css">
<%@include file="/WEB-INF/feedback.css"%>
</style>
</head>
<body>
	<h1>フィードバック確認</h1>
	<jsp:useBean id="fbArray" class="bean.FeedBackArrayBean" scope="session"/>
	<h2>フィードバック一覧</h2>
	<%
	ArrayList<FeedBackBean> array = fbArray.getFeedBackArray();
	int i = 0;
	int j = 0;
	int k = 0;
	%>
	<input type="button" value="全件" onclick="clickBtn1()" />
	<input type="button" value="未読" onclick="clickBtn2()" />
	<input type="button" value="既読" onclick="clickBtn3()" />
   	  <div class="box">
      <table border="1" id="p1">
      	<tr>
      		<td>ID</td>
      		<td>件名</td>
      		<td>受取日</td>
      		<td>未読/既読</td>
      	</tr>
      	<%
			for(FeedBackBean record : array){
		%>
      	<tr>
      		<td><%=record.getId() %></td>
      		<td><div class="hensyuu"><form action="FeedBackDetailServlet" method="post" name="formA<%=i%>"><input type="hidden" name="id" value="<%=record.getId() %>">
      		<a href="javascript:formA<%=i%>.submit()"><%=record.getTitle() %></a></form></div></td>
      		<td><%=record.getDate() %></td>
      		<td><%
      		if(record.getCk() == 0){ 
      		%>
      		未読
      		<%
      		}else{ 
      		%>
      		既読
      		<%
      		} 
      		%>
      		</td>
      	</tr>
      	<%
      		i++;
			}
      	%>
      </table>
      
      <table border="1" id="p2">
      	<tr>
      		<td>ID</td>
      		<td>件名</td>
      		<td>受取日</td>
      		<td>未読/既読</td>
      	</tr>
      	<%
			for(FeedBackBean record : array){
				if(record.getCk() == 0){
		%>
      	<tr>
      		<td><%=record.getId() %></td>
      		<td><form action="FeedBackDetailServlet" method="post" name="formB<%=j%>"><input type="hidden" name="id" value="<%=record.getId() %>">
      		<a href="javascript:formB<%=j%>.submit()"><%=record.getTitle() %></a></form></td>
      		<td><%=record.getDate() %></td>
      		<td><%
      		if(record.getCk() == 0){ 
      		%>
      		未読
      		<%
      		}else{ 
      		%>
      		既読
      		<%
      		} 
      		%>
      		</td>
      	</tr>
      	<%
				}
			j++;
			}
      	%>
      </table>
      
      <table border="1" id="p3">
      	<tr>
      		<td>ID</td>
      		<td>件名</td>
      		<td>受取日</td>
      		<td>未読/既読</td>
      	</tr>
      	<%
			for(FeedBackBean record : array){
				if(record.getCk() == 1){
		%>
      	<tr>
      		<td><%=record.getId() %></td>
      		<td><form action="FeedBackDetailServlet" method="post" name="formC<%=k%>"><input type="hidden" name="id" value="<%=record.getId() %>">
      		<a href="javascript:formC<%=k%>.submit()"><%=record.getTitle() %></a></form></td>
      		<td><%=record.getDate() %></td>
      		<td><%
      		if(record.getCk() == 0){ 
      		%>
      		未読
      		<%
      		}else{ 
      		%>
      		既読
      		<%
      		} 
      		%>
      		</td>
      	</tr>
      	<%
				}
			k++;
			}
      	%>
      </table><br>
</div>      
      
    <form action="ToAdminMenuServlet" method="post">
	<input type="submit" value="メニューへ戻る">
	</form><br>

<script>
const p1 = document.getElementById("p1");
const p2 = document.getElementById("p2");
const p3 = document.getElementById("p3");

p1.style.display ="block";
p2.style.display ="none";
p3.style.display ="none";
function clickBtn1(){	
	p2.style.display ="none";
	p3.style.display ="none";
	p1.style.display ="block";
}
function clickBtn2(){
	p1.style.display ="none";
	p3.style.display ="none";
	p2.style.display ="block";
}
function clickBtn3(){
	p1.style.display ="none";
	p2.style.display ="none";
	p3.style.display ="block";
}
</script>	
</body>
</html>