package lesson;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/janken")
public class result extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータを取得
    	request.setCharacterEncoding("UTF-8");
    	
    	Htmlspecialchars hsc = new Htmlspecialchars();
    	String me = request.getParameter("radio");
    	String error = "";
    	if (me == null || me.length() ==0) {
    		error += "自分の出す手を選択してください。";
    		me = "";
    	}
    	Random random = new Random();
		int num = random.nextInt(3);
		String cpu;
		
		if(num == 0){
			cpu = "グー";
		}else if(num ==1){
			cpu = "チョキ";
		}else {
			cpu = "パー";
		}
		String result;
    	//リクエストパラメータをチェック
		if (me.equals(cpu)) {
			result = "あいこ";
		} else if ((me.equals("グー") && cpu.equals("チョキ")) || (me.equals("チョキ") && cpu.equals("パー")) || (me.equals("パー") && cpu.equals("グー"))) {
			result = "勝ち";
		} else {
			result = "負け";
		}
		    	
    	//HTMLを出力
    	response.setContentType("text/html; charset=UTF-8");
    	PrintWriter out = response.getWriter();
    	out.println("<!DOCTYPE html>");
    	out.println("<html>");
    	out.println("<head>");
    	out.println("<meta charset=\"UTF-8\">");
    	out.println("<title>じゃんけん結果</title>");
    	out.println("</head>");
    	out.println("<body>");
    	if (error.length() > 0) {
    		out.println("<p>" + error + "</p>");
    	} else {
    		out.println("<p>あなた:" + me + "</p>");
        	out.println("<p>CPU:" + cpu + "</p>");
        	out.println("<p>判定: " + result + "</p>");
    	}
    	out.println("<a href=\"janken.html\">戻る</a>");
    	out.println("</body>");
    	out.println("</html>");	
	}

}
