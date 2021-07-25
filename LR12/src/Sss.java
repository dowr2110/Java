import javax.servlet.*;
import javax.servlet.http.*;
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
        super.service(rq,rs);
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
                + "<br>Ppp:doPost:firstname=" + firstname
                + "<br>Ppp:doPost:lastname= " + lastname
                + "<br>Ppp:doPost:password= " + password
                + "<br>Ppp:doPost:sex= " + sex
                + "<br>Ppp:doPost:press= " + press
                + "</body>" + "</html>");
        pw.close();
    }


}
