<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Items" %>
<%
List<Items> itemsList = (List<Items>)request.getAttribute("itemsList");
List<Items> typeList = (List<Items>)request.getAttribute("typeList");
String itemsType = (String)request.getAttribute("itemsType");
List<Items> keywordList = (List<Items>)request.getAttribute("keywordList");
String keyword = (String)request.getAttribute("keyword");
%>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Management Panel Wireframe</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/management.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
</head>
<body>
    <div class="container">
        <aside class="sidebar">
            <div class="logo">.αβ</div>
            <nav>
                <div class="category-group">
                    <h3>woman</h3>
                    <ul>
                        <li><a href="#">Category 1</a></li>
                        <li><a href="#">Category 2</a></li>
                        <li><a href="#">Category 3</a></li>
                        <li><a href="#">Category 4</a></li>
                        <li><a href="#">Category 5</a></li>
                        <li><a href="#">Category 6</a></li>
                        <li><a href="#">Category 7</a></li>
                        <li><a href="#">Category 8</a></li>
                        <li><a href="#">Category 9</a></li>
                        <li><a href="#">Category 10</a></li>
                    </ul>
                </div>
                <div class="category-group">
                    <h3>Man</h3>
                    <ul>
                        <li><a href="#">Category 11</a></li>
                        <li><a href="#">Category 12</a></li>
                        <li><a href="#">Category 13</a></li>
                        <li><a href="#">Category 14</a></li>
                        <li><a href="#">Category 15</a></li>
                        <li><a href="#">Category 16</a></li>
                        <li><a href="#">Category 17</a></li>
                        <li><a href="#">Category 18</a></li>
                        <li><a href="#">Category 19</a></li>
                        <li><a href="#">Category 20</a></li>
                    </ul>
                </div>
            </nav>
        </aside>

        <main class="main-content">
            <form action="AddServlet" method="post" class="search-form">
			    <input type="hidden" name="add">
			    <button type="submit">追加</button>
			</form>
    		<form action="SearchServlet" method="post" class="search-form">
			    <input type="text" name="keyword" placeholder="商品名で検索" required>
			    <button type="submit">検索</button>
			</form>
		    <% if (itemsType != null) { %>
		    	<h2><%= itemsType %></h2>
		    	<% for(Items item : typeList) { %>
				   <div class="Items">
				        <img src="<%= request.getContextPath() + "/" + item.getItemsImage() %>">
				        <div class="stock">残り　<%= item.getItemsStock() %>　点</div>
				        <div class="id">ID:<%= item.getItemsId() %></div>
				        <div class="title">商品名:<%=item.getItemsName()%></div>
				        <div class="explain">商品説明:<%= item.getItemsExplain() %></div>
				        <div class="caption">値段:<%=item.getItemsPrice()%></div>
				        <form action="ChangeDeleteSurvlet" method="post">
				        	<input type="hidden" name="<%= item.getItemsId() %>">
				        	<button type="submit">変更・削除</button>
				        </form>
				    </div>
				<% } %>
		    <% } else if (keyword != null) { %>
		    	<h2>"<%= keyword %>"に該当する商品</h2>
		    	<% if (keywordList.size() == 0) { %>
		    		<h3>該当する商品はありませんでした</h3>
		    	<% } %>
		   		<% for(Items item : keywordList) { %>
				    <div class="Items">
				        <img src="<%= request.getContextPath() + "/" + item.getItemsImage() %>">
				        <div class="stock">残り　<%= item.getItemsStock() %>　点</div>
				        <div class="id">ID:<%= item.getItemsId() %></div>
				        <div class="title">商品名:<%=item.getItemsName()%></div>
				        <div class="explain">商品説明:<%= item.getItemsExplain() %></div>
				        <div class="caption">値段:<%=item.getItemsPrice()%></div>
				        <form action="ChangeDeleteSurvlet" method="post">
				        	<input type="hidden" name="<%= item.getItemsId() %>">
				        	<button type="submit">変更・削除</button>
				        </form>
				    </div>
				<% } %>
		    <% } else if (itemsList != null) {%>
		    	<% for(Items item : itemsList) { %>
				    <div class="Items">
				        <img src="<%= request.getContextPath() + "/" + item.getItemsImage() %>">
				        <div class="stock">残り　<%= item.getItemsStock() %>　点</div>
				        <div class="id">ID:<%= item.getItemsId() %></div>
				        <div class="title">商品名:<%=item.getItemsName()%></div>
				        <div class="explain">商品説明:<%= item.getItemsExplain() %></div>
				        <div class="caption">値段:<%=item.getItemsPrice()%></div>
				        <form action="ChangeDeleteSurvlet" method="post">
				        	<input type="hidden" name="<%= item.getItemsId() %>">
				        	<button type="submit">変更・削除</button>
				        </form>
				    </div>
				<% } %>
		    <% } else {%>
    			<h2>商品表示エラー</h2>
			<% } %>   
    <footer>
        </footer>

    <script src="<%= request.getContextPath() %>/js/script.js"></script>       
        </main>
        <footer class="footer"></footer>
    </div>
</body>
</html>
