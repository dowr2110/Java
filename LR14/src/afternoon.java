import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class afternoon extends HttpServlet implements Servlet {

    public afternoon() {
        super();
        System.out.println("afternoon:constructor");
    }

    public void init(ServletConfig sc) throws ServletException {
        super.init();
        System.out.println("afternoon:init");
    }
    public void destroy() {
        super.destroy();
        System.out.println("afternoon:destroy");
    }
    protected void service(HttpServletRequest rq,  HttpServletResponse rs)
            throws ServletException,  IOException {
        System.out.println("afternoon:service:"+rq.getMethod());
        PrintWriter pw = rs.getWriter();
        pw.println("Servlet:Good afternoon<br> with parameter hour = " + rq.getParameter("hour"));
        pw.flush();//очистка потока
    }
}