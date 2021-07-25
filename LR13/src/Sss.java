import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.hc.core5.http.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Sss extends HttpServlet implements Servlet {
    public Sss() {
        super();
        System.out.println("Sss:constructor");
    }
    public void init(ServletConfig sc) throws ServletException {
        // инициализация сервлета
        super.init();
        System.out.println("Sss:init");
    }
    public void destroy() {
        // перед уничтожением сервлета
        super.destroy();
        System.out.println("Sss:destroy");
    }
    protected void service(HttpServletRequest rq, HttpServletResponse rs)
            throws ServletException, IOException {
        // обработка http-запроса
      System.out.println("Sss:service:"+rq.getMethod());
//        super.service(rq,rs);
        if(rq.getMethod().equals("GET"))
             doGet(rq, rs);
        if(rq.getMethod().equals("POST"))
             doPost(rq, rs);
    }

    protected void doGet(HttpServletRequest rq, HttpServletResponse rs)
            throws ServletException, IOException {
        String parm = rq.getParameter("page"); // 1
        System.out.println("Sss:doGet:page=" + parm); // 2

//        rs.setContentType("text/html"); // 3
//        PrintWriter pw = rs.getWriter(); // 4
//        pw.println("<html> " // 5
//                +"<body> " // 6
//                +"Hello from Servlet" // 7
//                +"<br>Sss:doGet:page=" + parm
//                +"</body>" // 9
//                +"</html>"); // 1
//
//
//        RequestDispatcher rd = null;
//        String parmstr = "page=25";
//        rd = rq.getRequestDispatcher("/Ggg?"+parmstr);//berilya uri suffiks
//
//        rd.forward(rq, rs);
//
//        //rs.sendRedirect("http://localhost:8081/LR13/Ggg?page=40");
//
//        pw.close(); // 11



        PrintWriter pw = rs.getWriter();
        HttpClient hc = new HttpClient();
        GetMethod gm = new GetMethod("http://localhost:8081/LR13/Ggg?page=5000");

        hc.executeMethod(gm);
        pw.println(gm.getResponseBodyAsString());
        System.out.println("hc.executeMethod(gm)");
    }

    protected void doPost(HttpServletRequest rq, HttpServletResponse
            rs)
            throws ServletException, IOException {
        String firstname = rq.getParameter("firstname");
        String lastname = rq.getParameter("lastname");
        String password = rq.getParameter("password");
        String sex = rq.getParameter("sex");
        String press = rq.getParameter("press");
//        rs.setContentType("text/html");
//        PrintWriter pw = rs.getWriter();
//        pw.println("<html> " + "<body> "
//                + "<br>Ppp:doPost:firstname=" + firstname
//                + "<br>Ppp:doPost:lastname= " + lastname
//                + "<br>Ppp:doPost:password= " + password
//                + "<br>Ppp:doPost:sex= " + sex
//                + "<br>Ppp:doPost:press= " + press
//                + "</body>" + "</html>");
//        pw.close();



       String parmstr = "firstname=" + firstname + "&"
                + "lastname=" + lastname+"&"+"password="+password+"&"+"sex="+sex+"&"+"press="+press;
        RequestDispatcher rd = null;
        if (press.equalsIgnoreCase("OK")) {
        //    rd = rq.getRequestDispatcher("/Ppp?" + parmstr);
            rs.setStatus(307);
            rs.addHeader("Location", "http://localhost:8081/LR13/Ppp?"+parmstr);
        //rs.sendRedirect("http://localhost:8081/LR13/Ppp?"+parmstr);
        }
        //rd.forward(rq, rs);



//        String parmstr = "firstname=" + firstname + "&"
//                + "lastname=" + lastname+"&"+"password="+password+"&"+"sex="+sex+"&"+"press="+press;
//        PrintWriter pw = rs.getWriter();
//        HttpClient hc = new HttpClient();
//        PostMethod pm = new PostMethod("http://localhost:8081/LR13/Ppp?"+parmstr);
//
//        hc.executeMethod(pm);
//        pw.println(pm.getResponseBodyAsString());
//        System.out.println("hc.executeMethod(pm)");


    }
}
