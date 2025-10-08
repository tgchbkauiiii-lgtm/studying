<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Product" %>
<%
List<Product> products = (List<Product>)request.getAttribute("products");
String keyword = (String)request.getAttribute("keyword");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>商品一覧</title>
<style>
body{ font-family: sans-serif; padding:20px; background:#f4f4f4;}
.grid{ display:grid; grid-template-columns: repeat(4, 1fr); gap:12px; }
.product{ background:#fff; padding:10px; border-radius:6px; box-shadow:0 1px 3px rgba(0,0,0,0.1); text-align:center; }
.product img{ width:100%; height:120px; object-fit:cover; border-radius:4px;}
.product .title{ font-weight:bold; margin:6px 0 4px; }
.product .caption{ font-size:12px; color:#666; }
form{ margin-bottom:20px; }
input[type=text]{ padding:6px; width:200px;}
button{ padding:6px 12px; }
</style>
</head>
<body>
<h1>商品一覧</h1>

<form method="get">
    <input type="text" name="keyword" value="<%=keyword%>" placeholder="商品名検索">
    <button type="submit">検索</button>
</form>

<div class="grid">
<% for(Product p : products) { %>
    <div class="product">
        <img src="<%=p.getImageUrl()%>" alt="<%=p.getName()%>">
        <div class="title"><%=p.getName()%></div>
        <div class="caption"><%=p.getCaption()%></div>
    </div>
<% } %>
</div>

</body>
</html>
