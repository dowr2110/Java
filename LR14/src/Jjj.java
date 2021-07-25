import java.io.*;        // исключения ввода/вывода
import javax.servlet.*;            // интерфейсы и классы общего типа
import javax.servlet.http.*;       // расширение javax.servlet для http
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;

public class Jjj extends HttpServlet implements Servlet {

    public Jjj() {  super(); }

    protected void service(HttpServletRequest rq,  HttpServletResponse rs)
            throws ServletException,  IOException {
        System.out.println("Jjj:service:"+rq.getMethod());
        if(rq.getMethod().equals("GET"))
            doGet(rq,rs);
        if(rq.getMethod().equals("POST"))
            doPost(rq,rs);
    }
    protected String GetJSPName(String hour) {
        Integer h = new Integer(hour);
        if ((h >= 0) && (h <= 6))
            return "/night.jsp";
        else if ((h > 6) && (h <= 12))
            return "/morning.jsp";
        else if ((h > 12) && (h <= 17))
            return "/afternoon.jsp";
        else
            return "/evening.jsp";
    }
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs)
            throws ServletException, IOException {
        System.out.println("Jjj:doGet");
        HttpClient hc = new HttpClient();
        GetMethod gm;
        String uri = "http://localhost:8081" + rq.getContextPath() + GetJSPName(rq.getParameter("hour")) + "?" + rq.getQueryString();
        hc.executeMethod(gm = new GetMethod(uri));
        rs.setContentType("text/html");
        PrintWriter pw = rs.getWriter();
        pw.println(gm.getResponseBodyAsString() + "method: GET parameters: (hour = " + rq.getParameter("hour") + ")");
        pw.close();



    }
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs)
            throws ServletException, IOException {
        System.out.println("Jjj:doPost");
//        HttpClient hc = new HttpClient();
//        PostMethod pm = new PostMethod("http://localhost:8081" + rq.getContextPath() + GetJSPName(rq.getParameter("hour")));
//        NameValuePair[] parms = { new NameValuePair("hour", rq.getParameter("hour"))};
//        pm.addParameters(parms);
//        hc.executeMethod(pm);
//        rs.setContentType("text/html");
//        PrintWriter pw = rs.getWriter();
//        pw.println(pm.getResponseBodyAsString() + "method: POST parameters: (hour = " + rq.getParameter("hour") + ")");
//        pw.close();


        RequestDispatcher rd = null;

        rd = rq.getRequestDispatcher(GetJSPName(rq.getParameter("hour")));//berilya uri suffiks

        rd.forward(rq, rs);
    }
}
