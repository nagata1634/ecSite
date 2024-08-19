package listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class setContextPath
 *
 */
@WebListener
public class setContextPath implements ServletContextListener {

    /**
     * Default constructor.
     */
    public setContextPath() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  {
         // TODO Auto-generated method stub

        ServletContext application = getServletContext();
    }

    /**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  {
         // TODO Auto-generated method stub
    }

}
