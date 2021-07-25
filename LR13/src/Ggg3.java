import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Ggg3 extends HttpServlet implements Servlet {
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs)
            throws ServletException, IOException {
        String press = rq.getParameter("press");
        rs.setContentType("text/html");

        RequestDispatcher rd = null;
        String parmstr = "page=255";

        if (press.equalsIgnoreCase("toGgg")) {
            rd = rq.getRequestDispatcher("/Ggg?"+parmstr);
          rs.sendRedirect("http://localhost:8081/LR13/Ggg?page=100");
        } else if (press.equalsIgnoreCase("toIndex.html"))
    //        rd = rq.getRequestDispatcher("/index.html");
          rs.sendRedirect("http://localhost:8081/LR13/index.html");
     //   rd.forward(rq, rs);
    }
}
