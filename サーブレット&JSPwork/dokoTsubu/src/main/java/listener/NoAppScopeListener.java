package listener;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.annotation.WebListener;
@WebListener
public class NoAppScopeListener implements ServletContextAttributeListener {
    public void attributeReplaced(ServletContextAttributeEvent scae)  { 
    }
    public void attributeRemoved(ServletContextAttributeEvent scae)  { 
    }
    public void attributeAdded(ServletContextAttributeEvent scae)  { 
         System.out.println("!!注意!!アプリケーションスコープにインスタンスを保存しないでください!!");
    }
}
