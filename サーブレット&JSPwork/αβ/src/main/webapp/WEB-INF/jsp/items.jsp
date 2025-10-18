<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Items" %>
<%
List<Items> itemsList = (List<Items>)request.getAttribute("itemsList");
List<Items> keywordList = (List<Items>)request.getAttribute("keywordList");
String keyword = (String)request.getAttribute("keyword");
List<String> allTypesList = (List<String>)request.getAttribute("allTypesList");
List<Items> genderList = (List<Items>)request.getAttribute("genderList");
String womenItemsType = (String)request.getAttribute("womenItemsType");
String menItemsType = (String)request.getAttribute("menItemsType");
List<Items> womenTypeList = (List<Items>)request.getAttribute("womenTypeList");
List<Items> menTypeList = (List<Items>)request.getAttribute("menTypeList");
String gender = (String)request.getAttribute("gender");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>.αβ - 商品一覧</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
<header class="main-header">
        <a href="#top"><img src="images/rogo.png" width="40" height="40" alt="トップへ戻る" srcset=""></a>
        <form action="SearchServlet" method="post" class="search-form">
		    <input type="text" name="keyword" placeholder="商品名で検索" required>
		    <button type="submit">SEARCH</button>
		</form>

	 <div class="header">
            <button class="hamburger-grid" aria-label="メニュー" aria-controls="grid-menu" aria-expanded="false">
                <div class="hamburger-grid__dots">
                    <span class="hamburger-grid__dot"></span><span class="hamburger-grid__dot"></span><span class="hamburger-grid__dot"></span>
                    <span class="hamburger-grid__dot"></span><span class="hamburger-grid__dot"></span><span class="hamburger-grid__dot"></span>
                    <span class="hamburger-grid__dot"></span><span class="hamburger-grid__dot"></span><span class="hamburger-grid__dot"></span>
                </div>
            </button>

            <nav id="grid-menu" class="nav-grid" aria-hidden="true">
                <div class="nav-grid__content">
                    <div class="nav-grid__sections">
                        <section class="nav-grid__section">
                            <ul class="nav-grid__list">
                            	<li><form action="ItemsServlet" method="post" class="nav-grid__link">
								    <input type="hidden" name="gender" value="women">
								    <button type="submit">WOMEN</button>
								</form></li>
								<% for (String Type : allTypesList) { %>
									<% if (!Type.equals("シャツ・ポロシャツ")) { %>
										<li><form action="ItemsServlet" method="post" class="nav-grid__link">
										    <input type="hidden" name="womenItemsType" value="<%= Type %>">
										    <button type="submit"><%= Type %></button>
										</form></li>
									<% } %>
								<% } %>
                            </ul>
                        </section>

                        <section class="nav-grid__section">
                            <ul class="nav-grid__list">
                                <li><form action="ItemsServlet" method="post" class="nav-grid__link">
								    <input type="hidden" name="gender" value="men">
								    <button type="submit">MEN</button>
								</form></li>
								<% for (String Type : allTypesList) { %>
									<% if (!Type.equals("スカート") && !Type.equals("シャツ・ブラウス")) { %>
										<li><form action="ItemsServlet" method="post" class="nav-grid__link">
										    <input type="hidden" name="menItemsType" value="<%= Type %>">
										    <button type="submit"><%= Type %></button>
										</form></li>
									<% } %>
								<% } %>
                            </ul>
                        </section>

                        <section class="nav-grid__section">
                            <ul class="nav-grid__list">
                                <li><a href="login.html" class="nav-grid__link">LOGIN</a></li>
                                <li><a href="index.html#recommend" class="nav-grid__link">RECOMMEND</a></li>
                                <li><a href="index.html#ranking" class="nav-grid__link">RANKING</a></li>
                                <li><a href="cart.html" class="nav-grid__link">CART</a></li>
                                <li><a href="mypage.html" class="nav-grid__link">MYPAGE</a></li>
                                <li><a href="contact.html" class="nav-grid__link">CONTACT</a></li>
                            </ul>
                        </section>
            </div>
        </div>
    </nav>
</div>
</header>
    
	<% if (genderList != null) { %>
		<% if (genderList.size() == 0) { %> 
    		<h3>該当する商品はありませんでした</h3>
    	<% } %>
		<% for(Items genderItem : genderList) { %>
		    <div class="Items">
		        <img src="<%= request.getContextPath() + "/" + genderItem.getItemsImage() %>">
		        <div class="title"><%=genderItem.getItemsName()%></div>
		        <div class="caption"><%=genderItem.getItemsPrice()%></div>
		        <form action="CartAddSurvlet" method="post">
		        	<input type="hidden" name="cart">
		        	<button type="submit">カートに追加</button>
		        </form>
		    </div>
		<% } %>
    <% } else if (womenTypeList != null) { %>
    	<h2><%= womenItemsType %></h2>
    	<% if (womenTypeList.size() == 0) { %> 
    		<h3>該当する商品はありませんでした</h3>
    	<% } %>
    	<% for(Items item : womenTypeList) { %>
		    <div class="Items">
		        <img src="<%= request.getContextPath() + "/" + item.getItemsImage() %>">
		        <div class="title"><%=item.getItemsName()%></div>
		        <div class="caption"><%=item.getItemsPrice()%></div>
		        <form action="CartAddSurvlet" method="post">
		        	<input type="hidden" name="cart">
		        	<button type="submit">カートに追加</button>
		        </form>
		    </div>
		    
		<% } %>
	<% } else if (menTypeList != null) { %>
    	<h2><%= menItemsType %></h2>
    	<% if (menTypeList.size() == 0) { %> 
    		<h3>該当する商品はありませんでした</h3>
    	<% } %>
    	<% for(Items item : menTypeList) { %>
		    <div class="Items">
		        <img src="<%= request.getContextPath() + "/" + item.getItemsImage() %>">
		        <div class="title"><%=item.getItemsName()%></div>
		        <div class="caption"><%=item.getItemsPrice()%></div>
		        <form action="CartAddSurvlet" method="post">
		        	<input type="hidden" name="cart">
		        	<button type="submit">カートに追加</button>
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
		        <div class="title"><%=item.getItemsName()%></div>
		        <div class="caption"><%=item.getItemsPrice()%></div>
		        <form action="CartAddSurvlet" method="post">
		        	<input type="hidden" name="cart">
		        	<button type="submit">カートに追加</button>
		        </form>
		    </div>
		    
		<% } %>
    <% } else if (itemsList != null) {%>
    	<% for(Items item : itemsList) { %>
		    <div class="Items">
		        <img src="<%= request.getContextPath() + "/" + item.getItemsImage() %>">
		        <div class="title"><%=item.getItemsName()%></div>
		        <div class="caption"><%=item.getItemsPrice()%></div>
		        <form action="CartAddSurvlet" method="post">
		        	<input type="hidden" name="cart">
		        	<button type="submit">カートに追加</button>
		        </form>
		    </div>
		<% } %>
    <% } else {%>
    	<h2>商品表示エラー</h2>
	<% } %>   
    <footer>
        </footer>

    <script src="<%= request.getContextPath() %>/js/script.js"></script>
</body>
</html>