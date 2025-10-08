<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Random" %>
<%
request.setCharacterEncoding("UTF-8");
String me = request.getParameter("radio");
String error = "";
if (me == null || me.length() ==0) {
	error += "自分の出す手を選択してください。";
	me = "";
}
Random random = new Random();
int num = random.nextInt(3);
String cpu;

if(num == 0){
	cpu = "グー";
}else if(num ==1){
	cpu = "チョキ";
}else {
	cpu = "パー";
}
String result;
//リクエストパラメータをチェック
if (me.equals(cpu)) {
	result = "あいこ";
} else if ((me.equals("グー") && cpu.equals("チョキ")) || (me.equals("チョキ") && cpu.equals("パー")) || (me.equals("パー") && cpu.equals("グー"))) {
	result = "勝ち";
} else {
	result = "負け";
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>じゃんけん結果</title>
</head>
<body>
<%if (error.length() != 0) {%>
<p>エラー:<%= error %></p>
<%} else {%>
<p>あなた:<%= me %></p>
<p>CPU:<%= cpu %></p>
<p>判定:<%= result %></p>
<%} %>
<a href="janken.html">もどる</a>
</body>
</html>