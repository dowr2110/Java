import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;

public class Ggg extends HttpServlet implements Servlet {
//    Разработайте сервлет, обрабатывающий запрос типа GET.
//    Сервлет должен обрабатывать параметр с именем urln.  Если значение параметра равно n,
//    то сервлет должен считывать параметр инициализации с именем  URLn. Если  параметр инициализации
//    существует, то сервлет должен сгенерировать запрос  типа  GET  к ресурсу с URL равному значению
//    соответствующего параметра
//    инициализации и  вывести в окно браузера ответ, иначе – должен выдать  сообщение parameter URLn not found.
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs)
            throws ServletException, IOException {
        System.out.println("Ggg:doGet");
        String urln = rq.getParameter("urln");
        ServletContext sc = getServletContext();
        String url = sc.getInitParameter(urln);
        if( url == null || urln == null) {
            PrintWriter pw = rs.getWriter();
            pw.println("<h1>parameter URLn not found</h1>");
            pw.close();
        } else {
            HttpClient hc = new HttpClient();
            GetMethod gm;
            String uri = url + "?" +  "page=" + rq.getParameter("page");
            hc.executeMethod(gm = new GetMethod(uri));
            rs.setContentType("text/html");
            PrintWriter pw = rs.getWriter();
            pw.println(gm.getResponseBodyAsString());
            pw.close();
        }
    }
}