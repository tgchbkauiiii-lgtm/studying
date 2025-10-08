<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Items" %>
<%
List<Items> itemsList = (List<Items>)request.getAttribute("itemsList");
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
        <a href="#top"><img src="<%= request.getContextPath() %>/images/rogo.png" width="40" height="40" alt="トップへ戻る" srcset=""></a>
        <nav class="main-nav">
            <ul>
                </ul>
        </nav>
        
<div class="header">
  <button class="hamburger-grid" aria-label="メニュー" aria-controls="grid-menu" aria-expanded="false">
    <div class="hamburger-grid__dots">
      <span class="hamburger-grid__dot"></span>
      <span class="hamburger-grid__dot"></span>
      <span class="hamburger-grid__dot"></span>
      <span class="hamburger-grid__dot"></span>
      <span class="hamburger-grid__dot"></span>
      <span class="hamburger-grid__dot"></span>
      <span class="hamburger-grid__dot"></span>
      <span class="hamburger-grid__dot"></span>
      <span class="hamburger-grid__dot"></span>
    </div>
  </button>

  <nav id="grid-menu" class="nav-grid" aria-hidden="true">
    <div class="nav-grid__content">
      <div class="nav-grid__sections">
        <section class="nav-grid__section">
          <h2 class="nav-grid__title">Menu</h2>
          <ul class="nav-grid__list">
            <li><a href="items.html" class="nav-grid__link">WOMEN</a></li>
            <li><a href="items.html" class="nav-grid__link">MEN</a></li>
            <li><a href="items.html" class="nav-grid__link">SEARCH</a></li>           
            <li><a href="index.html#recommend" class="nav-grid__link">RECOMMEND</a></li>
            <li><a href="index.html#ranking" class="nav-grid__link">RANKING</a></li>
          </ul>
        </section>

        <section class="nav-grid__section">
          <h2 class="nav-grid__title">Social</h2>
          <ul class="nav-grid__list">
            <li><a href="login.html" class="nav-grid__link">LOGIN</a></li>
            <li><a href="contact.html" class="nav-grid__link">CONTACT</a></li>
            <li><a href="cart.html" class="nav-grid__link">CART</a></li>
            <li><a href="mypage.html" class="nav-grid__link">MYPAGE</a></li>           
          </ul>
        </section>
      </div>
    </div>
  </nav>
</div>
    </header>
		<div class="grid">
			<% for(Items item : itemsList) { %>
			    <div class="Items">
			        <img src="<%= request.getContextPath() + "/" + item.getItemsImage() %>">
			        <div class="title"><%=item.getItemsName()%></div>
			        <div class="caption"><%=item.getItemsPrice()%></div>
			        <div class="button"><button type="submit">カートに追加</button></div>
			    </div>
			<% } %>
		</div>
   
    <footer>
        </footer>

    <script src="<%= request.getContextPath() %>/js/script.js"></script>
</body>
</html>