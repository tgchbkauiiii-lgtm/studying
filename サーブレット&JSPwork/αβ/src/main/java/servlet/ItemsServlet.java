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

@WebServlet("/ItemsServlet")
public class ItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       		//商品の情報をデータベースから取得
       		GetItemsListLogic gmll = new GetItemsListLogic();
       		List<Items> itemsList = gmll.execute();
       		ItemsDAO dao = new ItemsDAO();
       		List<String> allTypesList = dao.findAllTypes();
       		request.setAttribute("itemsList", itemsList);
       		request.setAttribute("allTypesList", allTypesList);
       		//フォワード
   			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/items.jsp");
   			dispatcher.forward(request, response);
       	}

       	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       	    request.setCharacterEncoding("UTF-8");
       	    
       	    // 1. パラメータの取得
       	    String womenItemsType = request.getParameter("womenItemsType");
       	    String menItemsType = request.getParameter("menItemsType");
       	    String gender = request.getParameter("gender"); // gender全体ボタンからの値("women"または"men")を取得
       	    
       	    // 2. どの検索を実行するかを判定し、必要なDAO呼び出しのみ実行
       	    ItemsDAO dao = new ItemsDAO();
       	    
       	    // 初期値として、すべて null に設定することで、JSPの条件分岐を正しく機能させる
       	    List<Items> womenTypeList = null;
       	    List<Items> menTypeList = null;
       	    List<Items> genderList = null;
       	    
       	    // タイプ別検索が選択された場合
       	    if (womenItemsType != null) {
       	        womenTypeList = dao.findByWomenType(womenItemsType);
       	    } else if (menItemsType != null) {
       	        menTypeList = dao.findByMenType(menItemsType);
       	    } 
       	    // 性別全体検索が選択された場合 (タイプ別検索がなかった場合のみ実行)
       	    else if (gender != null) {
       	        genderList = dao.findByGender(gender);
       	    }
       	    
       	    // 共通で取得するデータ
       	    List<String> allTypesList = dao.findAllTypes();

       	    // 3. JSPへデータを渡す
       	    request.setAttribute("womenItemsType", womenItemsType); 
       	    request.setAttribute("menItemsType", menItemsType);   
       	    request.setAttribute("gender", gender);               
       	    
       	    request.setAttribute("womenTypeList", womenTypeList); // 必要なリスト以外は null のまま
       	    request.setAttribute("menTypeList", menTypeList);     // 必要なリスト以外は null のまま
       	    request.setAttribute("genderList", genderList);       // 必要なリスト以外は null のまま
       	    request.setAttribute("allTypesList", allTypesList);
       	    
       	    // 表示ページへフォワード
       	    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/items.jsp");
       	    dispatcher.forward(request, response);
       	}
}
