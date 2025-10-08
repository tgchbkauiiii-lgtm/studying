<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page import="model.User, model.Mutter, java.util.List" %>
<%
//セッションスコープに保存されたユーザー情報を取得
User loginUser = (User)session.getAttribute("loginUser");
//アプリケーションスコープに保存されたユーザ情報を取得
List<Mutter> mutterList = (List<Mutter>)application.getAttribute("mutterList");
//リクエストスコープに保存されたエラーメッセージを取得
String errorMsg = (String)request.getAttribute("errorMsg");
%> --%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
<h1>どこつぶメイン</h1>
<p>
<%-- <%= loginUser.getName() %> --%>
<c:out value="${loginUser.name}"></c:out>さん、ログイン中
</p>
<a href="Logout">ログアウト</a>
<p><a href="Main">更新</a></p>
<form action="Main" method="post">
<input type="text" name="text">
<input type="submit" value="つぶやく">
</form>
<%-- <% if (errorMsg != null) {%>
	<p><%= errorMsg %></p>
<% } %>
<% for (Mutter mutter : mutterList) { %>
	<p><%= mutter.getUserName() %>:<%= mutter.getText() %></p>
<% } %> --%>
<c:if test="${not empty errorMsg}">
	<p><c:out value="${errorMsg}"></c:out></p>
</c:if>
<c:forEach var="mutter" items="${mutterList}">
	<p>
		<c:out value="${mutter.userName}"></c:out>
		<c:out value="${mutter.text}"></c:out>
	</p>
</c:forEach>
<jsp:include page="footer.jsp" />
</body>
</html>