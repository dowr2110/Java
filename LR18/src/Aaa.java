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

public class Aaa extends HttpServlet implements Servlet {

    protected void doPost(HttpServletRequest rq, HttpServletResponse rs)
            throws ServletException, IOException {
        System.out.println("Sss:doPost");
        HttpClient hc = new HttpClient();
        PostMethod pm = new PostMethod("http://localhost:8081" + rq.getContextPath() + "/Bbb");
        pm.addRequestHeader("lastname", "atayew1");
        pm.addRequestHeader("lastname", "atayew2");
        pm.addRequestHeader("lastname", "atayew3");

        NameValuePair[] parms = { new NameValuePair("name", "dowr1"),
                new NameValuePair("name", "dowr2"),
                new NameValuePair("name", "dowr3")};
        pm.addParameters(parms);
        hc.executeMethod(pm);


        rs.setContentType("text/html");
        PrintWriter pw = rs.getWriter();
        pw.println("<html><body><h1>Servlet Aaa<br>Response Headers from Bbb</h1>");
        //pm.getRequestHeaderNames();

        Header[] enhl = pm.getResponseHeaders();
        for(int i=0;i<enhl.length;i++) {
            pw.println("<br>" + enhl[i].getName() + ": " + enhl[i].getValue());
        }
        pw.println(pm.getResponseBodyAsString());
        pw.println("</body></html>");
        pw.close();
    }
}