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
import model.Items;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        // 入力されたキーワードを取得
        String keyword = request.getParameter("keyword");
        
        // DAOから検索結果を取得
        ItemsDAO dao = new ItemsDAO();
        List<String> allTypesList = dao.findAllTypes();
        List<Items> keywordList = dao.findByKeyword(keyword);

        // 結果をリクエストスコープに保存
        request.setAttribute("keywordList", keywordList);
        request.setAttribute("allTypesList", allTypesList);
        // 検索ワードをそのままJSPに表示したい場合もセットしておく（任意）
        request.setAttribute("keyword", keyword);

        // 商品一覧ページへフォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/items.jsp");
        dispatcher.forward(request, response);
    }
}
