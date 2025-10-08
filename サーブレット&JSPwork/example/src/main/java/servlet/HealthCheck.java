package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Health;
import model.HealthCheckLogic;
import model.InputCheck;

@WebServlet("/HealthCheck")

public class HealthCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       		//フォワード
       		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/healthCheck.jsp");
    		dispatcher.forward(request, response);
       	}
       	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       		//リクエストパラメータを取得
       		InputCheck ic = new InputCheck();
       		double weight = ic.check(request.getParameter("weight"));
       		double height = ic.check(request.getParameter("height"));
       		
       		//入力値をプロパティに設定
       		Health health = new Health();
       		health.setHeight(height);
       		health.setWeight(weight);
       		
       		//健康診断を実行し結果を設定
       		HealthCheckLogic healthCheckLogic = new HealthCheckLogic();
       		healthCheckLogic.execute(health);
       		
       		//リクエストスコープに保存
       		request.setAttribute("health", health);
       		
       		//フォワード
       		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/healthCheckResult.jsp");
    		dispatcher.forward(request, response);
		}
}
