package servlet;

import java.io.IOException;

import ex.Fruit;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/FruitServlet")

public class FruitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//       		Fruit f = new Fruit("いちご", 700);
//       		request.setAttribute("fruit", f);
//       		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/ex/fruit.jsp");
//    		dispatcher.forward(request, response);
       		Fruit f = new Fruit("いちご", 700);
       		HttpSession session = request.getSession();
       		session.setAttribute("fruit",f);
       		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/ex/fruit.jsp");
    		dispatcher.forward(request, response);
    		session.invalidate();
	}

}
