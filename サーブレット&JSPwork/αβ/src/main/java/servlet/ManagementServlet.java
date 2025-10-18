package servlet;

import java.io.IOException;
import java.util.List;

import dao.ItemsDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.GetItemsListLogic;
import model.Items;

@WebServlet("/ManagementServlet")
public class ManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       		//商品の情報をデータベースから取得
       		GetItemsListLogic gmll = new GetItemsListLogic();
       		List<Items> itemsList = gmll.execute();
       		request.setAttribute("itemsList", itemsList);
   			//フォワード
   			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/management.jsp");
   			dispatcher.forward(request, response);
       	}
       	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    request.setCharacterEncoding("UTF-8");

	        // URLパラメータ "itemsType" を取得
	        String itemsType = request.getParameter("itemsType");
	        String keyword = request.getParameter("keyword");
	        // DAO呼び出し
	        ItemsDAO dao = new ItemsDAO();
//	        List<Items> typeList = dao.findByType(itemsType);
	        List<Items> keywordList = dao.findByKeyword(keyword);

	        // JSPへデータを渡す
//	        request.setAttribute("typeList", typeList);
	        request.setAttribute("keywordList", keywordList);

	        // 表示ページへフォワード
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/management.jsp");
	        dispatcher.forward(request, response);
		}
}
