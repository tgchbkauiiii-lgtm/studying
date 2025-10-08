package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.SiteEV;
import model.SiteEVLogic;

@WebServlet("/MinatoIndex")

public class MinatoIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//アプリケーションスコープに保存されたサイト評価を取得
       		ServletContext application = this.getServletContext();
       		SiteEV sE = (SiteEV)application.getAttribute("siteEV");
       		
       		//サイト評価の初期化
       		if (sE == null) {
       			sE = new SiteEV();
       		}
       		
       		//リクエストパラメータの取得
       		request.setCharacterEncoding("UTF-8");
       		String action = request.getParameter("action");
       		
       		//サイトの評価処理
       		SiteEVLogic sEL = new SiteEVLogic();
       		if (action != null && action.equals("like")) {
       			sEL.like(sE);
       		} else if (action != null && action.equals("dislike")) {
       			sEL.dislike(sE);
       		}
       		
       		//アプリケーションスコープにサイト評価を保存
       		application.setAttribute("siteEV", sE);
       		
       		//フォワード
       		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/minatoIndex.jsp");
    		dispatcher.forward(request, response);
	}
}
