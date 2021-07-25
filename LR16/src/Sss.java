import java.io.*;        // ���������� �����/������   
import javax.servlet.*;            // ���������� � ������ ������ ����  
import javax.servlet.http.*;       // ���������� javax.servlet ��� http 

public class Sss extends HttpServlet implements Servlet {

    public Sss() {
        super();
        System.out.println("Sss:constructor");
    }

    public void init(ServletConfig sc) throws ServletException {

        super.init();
        System.out.println("Sss:init");
    }
    public void destroy() {
         super.destroy();
        System.out.println("Sss:destroy");
    }
    protected void service(HttpServletRequest rq,  HttpServletResponse rs)
            throws ServletException,  IOException {
         System.out.println("Sss:service:"+rq.getMethod());
        if(rq.getMethod().equals("GET"))
            doGet(rq,rs);
        if(rq.getMethod().equals("POST"))
            doPost(rq,rs);
    }

    protected void doGet(HttpServletRequest rq, HttpServletResponse rs)
            throws ServletException, IOException {
        String parm = rq.getParameter("page"); // 1
        System.out.println("Sss:doGet:page=" + parm); // 2
        rs.setContentType("text/html"); // 3
        PrintWriter pw = rs.getWriter(); // 4
        pw.println("<html> " // 5
                +"<body> " // 6
                +"Hello from Servlet" // 7
                +"<br>Sss:doGet:page=" + parm // 8
                +"</body>" // 9
                +"</html>"); // 10
        pw.close(); // 11
    }

    protected void doPost(HttpServletRequest rq, HttpServletResponse
            rs)
            throws ServletException, IOException {
        String firstname = rq.getParameter("firstname");
        String lastname = rq.getParameter("lastname");
        String password = rq.getParameter("password");
        String sex = rq.getParameter("sex");
        String press = rq.getParameter("press");
        rs.setContentType("text/html");
        PrintWriter pw = rs.getWriter();
        pw.println("<html> " + "<body> "
                + "<br>Sss:doPost:firstname=" + firstname
                + "<br>Sss:doPost:lastname= " + lastname
                + "<br>Sss:doPost:password= " + password
                + "<br>Sss:doPost:sex= " + sex
                + "<br>Sss:doPost:press= " + press
                + "</body>" + "</html>");
        pw.close();
    }
}