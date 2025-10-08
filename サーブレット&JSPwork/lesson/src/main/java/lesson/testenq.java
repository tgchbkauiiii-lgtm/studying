package lesson;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/testenq")
public class testenq extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータを取得
    	request.setCharacterEncoding("UTF-8");
    	Htmlspecialchars hsc = new Htmlspecialchars();
    	String name = hsc.htmlspecialchars(request.getParameter("name"));
    	String qtype = hsc.htmlspecialchars(request.getParameter("qtype"));
    	String body = hsc.htmlspecialchars(request.getParameter("body"));
    	
    	//リクエストパラメータをチェック
    	String errorMsg = "";
    	if (name == null || name.length() == 0) {
    		errorMsg += "名前が入力されていません<br>";
    	}
    	if (qtype == null || qtype.length() == 0) {
    		errorMsg += "お問い合わせの種類が選択されていません<br>";
    	} else {
    		if (qtype.equals("company")) {qtype = "会社について";}
    		else if (qtype.equals("product")) {qtype = "製品について";}
    		else {qtype = "アフターサポートについて";}
    	}
    	if (body == null || body == "") {
    		errorMsg += "お問い合わせ内容が空欄です<br>";
    	}
    	//表示するメッセージを設定
    	String msg = name + "さんの" + qtype + "の以下のお問い合わせを登録しました。";
    	if (errorMsg.length() != 0) {
    		msg = errorMsg;
    	}
    	
    	//HTMLを出力
    	response.setContentType("text/html; charset=UTF-8");
    	PrintWriter out = response.getWriter();
    	out.println("<!DOCTYPE html>");
    	out.println("<html>");
    	out.println("<head>");
    	out.println("<meta charset=\"UTF-8\">");
    	out.println("<title>ユーザー登録結果</title>");
    	out.println("</head>");
    	out.println("<body>");
    	if (errorMsg.length() == 0) {
    		out.println("<p>" + msg + "</p>");
    		out.println("<p>===================================================================================================</p>");
    		out.println("<p>" + body + "</p>");
    		out.println("<p>===================================================================================================</p>");
    		out.println("<p>以上</p>");
    	} else {
    		out.println("<p>" + msg + "</p>");
    	}
    	out.println("</body>");
    	out.println("</html>");	
	}

}
