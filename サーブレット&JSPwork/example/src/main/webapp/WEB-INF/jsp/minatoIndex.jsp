<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.SiteEV" %>
<%
SiteEV sE = (SiteEV)application.getAttribute("siteEV");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>湊くんのページ</title>
<style type="text/css">
	body {
		width:600px;
		margin:0 auto;
		font-family: sans-serif;
	}
	.bar {
		display: flex;
		font-size: 24px;
		font-weight: bold;
		color: black;
		text-align: center;
	}
	.good, .bad {
		display: flex;
		align-items: center;   /* 縦中央 */
		justify-content: center; /* 横中央 */
	}
	.good {
		width: <%= (sE.getLike() + 0.5) / (sE.getLike() + sE.getDislike() + 1) * 100%>%;
		background-color: red;
		margin: 0 auto 0 0;
	}
	.bad {
		width: <%= (sE.getDislike() + 0.5) / (sE.getLike() + sE.getDislike() + 1) * 100%>%;
		background-color: blue;
		margin: 0 0 0 auto;
	}
</style>
</head>
<body>
<h1>湊くんのページへようこそ</h1>
<p>
<a href="MinatoIndex?action=like">GOOD</a>
<%= sE.getLike() %>
<a href="MinatoIndex?action=dislike">BAD</a>
<%= sE.getDislike() %>
</p>
<div class="bar">
<div class="good"><%= sE.getLike() %></div><div class="bad"><%= sE.getDislike() %></div>
</div>
<h2>湊くんとは！？</h2>
<p>説明しよう！湊くんとは国本大悟氏の「スッキリわかる」シリーズに登場するおっちょこちょいな男なんだ！</p>
</body>
</html>