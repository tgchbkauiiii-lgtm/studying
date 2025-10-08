package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.GetItemsListLogic;
import model.Items;

@WebServlet("/ItemsServlet")
public class ItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       		//商品の情報をデータベースから取得
       		GetItemsListLogic gmll = new GetItemsListLogic();
       		List<Items> itemsList = gmll.execute();
       		request.setAttribute("itemsList", itemsList);
       		//ログインしているか確認するためセッションスコープからユーザー情報を取得
//       		HttpSession session = request.getSession();
//       		User loginUser = (User)session.getAttribute("loginUser");
//       		
//       		if (loginUser == null) {
//       			//リダイレクト
//       			response.sendRedirect("index.jsp");
//       		} else {
//       			//フォワード
	       			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/items.jsp");
	       			dispatcher.forward(request, response);
//       		}
       	}
       	
       	
//		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////			リクエストパラメータの取得
////			request.setCharacterEncoding("UTF-8");
//			String text = request.getParameter("text");
//			
//			//入力値チェック
//			if (text != null && text.length() != 0) {
//				//アプリケーションスコープに保存されたつぶやきリストを取得
//				ServletContext application = this.getServletContext();
//				List<Items> ItemsList = (List<Items>)application.getAttribute("ItemsList");
//				
//				//セッションスコープに保存されたユーザー情報を取得
//				HttpSession session = request.getSession();
//				User loginUser = (User)session.getAttribute("loginUser");
//				
//				//つぶやきを作成してつぶやきリストに追加
//				Items Items = new Items(loginUser.getName(), text);
//				PostItemsLogic pml = new  PostItemsLogic();
//				pml.execute(Items);
//				
//				//アプリケーションスコープにつぶやきリストを保存
//				application.setAttribute("ItemsList", ItemsList);
//			} else {
//				//エラーメッセージをリクエストスコープに保存
//				request.setAttribute("errorMsg", "つぶやきが入力されていません");
//			}
//			//つぶやきリストを取得して、リクエストスコープに保存
//			GetItemsListLogic gmll = new GetItemsListLogic();
//			List<Items> ItemsList = gmll.execute();
//			request.setAttribute("ItemsList", ItemsList);
//			
//			//メイン画面にフォワード
//			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/main.jsp");
//   			dispatcher.forward(request, response);
//		}
}
