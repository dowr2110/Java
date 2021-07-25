import jspclass.CBean;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class Bbb extends HttpServlet implements Servlet {

    protected void doPost(HttpServletRequest rq, HttpServletResponse rs)
            throws ServletException, IOException {
        String s;
        rs.setContentType("text/html");
        rs.addHeader("MyHeader", "Jemshidovic1");
        rs.addHeader("MyHeader", "Jemshidovic2");
        PrintWriter pw = rs.getWriter();
        Enumeration enh = rq.getHeaderNames();
        pw.println("<h2><br>Servlet Bbb<br>Request Headers from Aaa</h2>");
        while (enh.hasMoreElements()) {
            s = (String)enh.nextElement();
            pw.println("<br>" + s + " = ");
            Enumeration enhel = rq.getHeaders(s);
            while (enhel.hasMoreElements())
                pw.print((String)enhel.nextElement() + " ");
        }
        enh = rq.getParameterNames();
        pw.println("<br><h2>Request Parameters from Aaa</h2>");
        while (enh.hasMoreElements()) {
            s = (String)enh.nextElement();
            pw.println("<br>" + s + " = ");
            String[] enhel = rq.getParameterValues(s);
            for(int i =0; i< enhel.length;i++)
                pw.print(enhel[i] + " ");
        }
        pw.close();
    }
}