package listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
@WebListener
public class CounterListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce)  { 
    	ServletContext context = sce.getServletContext();
    	Integer count = 0;
    	context.setAttribute("count", count);
    	System.out.println("リスナーが実行されました");
    }
    public void contextDestroyed(ServletContextEvent sce)  {
    	System.out.println("リスナーのdestroy()が実行されました");
    }	
}
