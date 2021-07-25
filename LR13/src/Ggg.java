import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.HttpClient;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Ggg extends HttpServlet implements Servlet {
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs)
            throws ServletException, IOException {
        String parm = rq.getParameter("page"); // 1
        System.out.println("Ggg:doGet:page=" + parm); // 2
        rs.setContentType("text/html"); // 3
        PrintWriter pw = rs.getWriter(); // 4
        pw.println("<html> " // 5
                +"<body> " // 6
                +"Hello from Servlet GGG" // 7
                +"<br>Ggg:doGet:page=" + parm // 8
                +"</body>" // 9
                +"</html>"); // 10
        pw.close(); // 11
    }
}


//        String uri ="http://localhost:8081/LR13/Ggg?page="+rq.getParameter("page");
//        HttpClient hc =new HttpClient();
//        GetMethod gm=new GetMethod("http://localhost:8081/LR13/Ggg?page=777");//url
//        System.out.println(gm.getPath());
//        System.out.println(gm.getURI());
//        hc.executeMethod(gm);
//        System.out.println("Ggg execute");