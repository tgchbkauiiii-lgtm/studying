package servlet;

import java.io.IOException;

import dao.ItemsDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ChangeDeleteServlet")

public class ChangeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");

	        // URLパラメータ "itemsType" を取得
	        String itemsId = request.getParameter("itemsId");

	        // DAO呼び出し
	        ItemsDAO dao = new ItemsDAO();
	       
	        // JSPへデータを渡す
	        

	        // 表示ページへフォワード
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/management.jsp");
	        dispatcher.forward(request, response);
		}

}
