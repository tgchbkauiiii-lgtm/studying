package servlet;


import java.io.IOException;
import java.util.Random;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ex62")

public class SelectRandom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       		int num = new Random().nextInt(10);
       		System.out.println(num);
       		if (num % 2 == 0) {
       			RequestDispatcher dispatcher = request.getRequestDispatcher("forwarded.jsp");
       			dispatcher.forward(request, response);
       		} else {
       			response.sendRedirect("redirected.jsp");
       		}
	}

}
