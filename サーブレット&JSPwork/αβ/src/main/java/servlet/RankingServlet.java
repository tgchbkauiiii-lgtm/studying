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

@WebServlet("/RankingServlet")

public class RankingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ItemsDAO dao = new ItemsDAO();
   		List<Items> rankingList = dao.findByRanking();
   		request.setAttribute("rankingList", rankingList);
   		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/index.jsp");
		dispatcher.forward(request, response);
	}
}
